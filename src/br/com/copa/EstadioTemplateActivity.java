package br.com.copa;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

//Autora Ayran Costa

/*Classe respons�vel em gerar a view que ira exibir as informa��es do est�dio escolhido pelo usu�rio*/


public class EstadioTemplateActivity extends Activity {

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
	        Intent it = getIntent();
	        if(it !=null){
	        	Bundle parametro = it.getExtras();
	        	if(parametro != null){
	        		Estadio estadio = (Estadio) parametro.getSerializable("estadio");
	        		showEstadio(estadio);
	        	}else{
	        		getMensage("Error", "Parametro recebido esta nulo");
	        	}
	        }else{
	        	getMensage("Error", "Itente recebida esta nula");
	        }
	        
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
    	 
    	 AlertDialog.Builder mensagem = new AlertDialog.Builder(EstadioTemplateActivity.this);
    	 mensagem.setTitle(title);
    	 mensagem.setMessage(mensage);
    	 mensagem.setNeutralButton("Fechar", null);
    	 mensagem.show();
    	 
    	 
     }
}
