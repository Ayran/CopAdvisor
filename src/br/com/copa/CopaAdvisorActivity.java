package br.com.copa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;






import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;



public class CopaAdvisorActivity extends Activity {
    /** Called when the activity is first created. */
	private List<Estadio> estadioList = null;
	private List<String> estadios = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        getEstadiosList();
       
    }
    
    
    public void getEstadiosList(){
    	 setContentView(R.layout.list_estadios);
    
    	
    	//Iniciamos a lista de Estadios
    	estadios =  new ArrayList<String>();
    	estadios.add("Fonte Nova");
    	estadios.add("Maracanã");
    	estadios.add("Mineirão");
    	
    	
    	//obj ListView
        ListView combo = (ListView) findViewById(R.id.listEstadios);
        
        //Criar um ArrayAdapter do tipo String, que vai fazer aparecer as Strings acima na tela
        ArrayAdapter<String> adptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,estadios);
        //Associar o adaptador ao listview
    	combo.setAdapter(adptador);
    	//difino a função onItenClick_List para ser chamada quando clicar em um elemento da lista
    	combo.setOnItemClickListener( buscaEstadio);
    	
    	
    }
    
    //função executada quando um item da lista de estadios e clicado
    
    OnItemClickListener buscaEstadio = new OnItemClickListener() {
        public void onItemClick(AdapterView arg0, View view, int position, long index) {
            //Pegar o item clicado
            String nomeEstadio = estadios.get(position);
           
            //Faz um requisição ao servidor
            Estadio estadio = executeRequest(nomeEstadio);
           
            //Chama a tela do estadio selecionado
            showEstadio(estadio);
            
        }
        
    };
    
    
    public Estadio executeRequest(String nomeEstadio){
        
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://10.0.0.100:8080/CopaAdvisorServer/principal");
        
        try {
            // Add your data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("nomeEstadio", nomeEstadio));
            
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            // Executa HTTP Post Request
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity mensagem = response.getEntity();//pega o json
             
            String resp =  EntityUtils.toString(mensagem);// converte o conteudo em string
                                     
           //Seta a resposta como um objeto JSON para acessar as informações
           	JSONObject obJson = new JSONObject(resp);
             
            Estadio estadio = new Estadio(obJson);
            return estadio;
                     
        } catch (ClientProtocolException e) {
        	 getMensage("ERROR" , e.getMessage());
        } catch (IOException e) {
        	 getMensage("ERROR" , "IO-ERROR "+e.getMessage());
        } catch (JSONException e1) {
        	 getMensage("ERROR" , "IO-ERROR "+ e1.getMessage());
        }
        
		return null;
		
    }
    
    public void showEstadio(Estadio estadio){
    	 setContentView(R.layout.estadio_view);
    	//carrega a imagem
        byte[] foto = estadio.getFoto();
 
        Bitmap bmp=BitmapFactory.decodeByteArray(foto,0,foto.length);// decodifica o array de bytes em um bitmamp
      //  Bitmap bMapScaled = Bitmap.createScaledBitmap(bmp, 150, 100, true); // define o tamanho da imagem (originalBitmap, newX, newY, true) 
        																	//  true habilita o filtro
        
        ImageView imView = (ImageView)findViewById(R.id.imview);
        TextView nomeTx = (TextView)findViewById(R.id.nome);
        TextView cidadeTx = (TextView)findViewById(R.id.cidade);
        TextView descricaoTx = (TextView)findViewById(R.id.descricao);
       
        imView.setImageBitmap(bmp);
        nomeTx.setText("Nome: "+ estadio.getNome());
        cidadeTx.setText("Cidade: "+ estadio.getCidade());
        descricaoTx.setText(estadio.getDescricao());
       	
    }
    
    
    public void getMensage(String title,String mensage){
      	 
      	 AlertDialog.Builder mensagem = new AlertDialog.Builder(CopaAdvisorActivity.this);
      	 mensagem.setTitle(title);
      	 mensagem.setMessage(mensage);
      	 mensagem.setNeutralButton("Fechar", null);
      	 mensagem.show();
      	 
      	 
       }
}