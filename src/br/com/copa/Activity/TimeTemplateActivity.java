package br.com.copa.Activity;

import br.com.copa.R;
import br.com.copa.Model.Time;
import br.com.copa.R.id;
import br.com.copa.R.layout;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TimeTemplateActivity extends Activity
{
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
	        Intent it = getIntent();
	        if(it !=null){
	        	Bundle parametro = it.getExtras();
	        	if(parametro != null){
	        		Time time = (Time) parametro.getSerializable("time");
	        		showTime(time);
	        	}else{
	        		getMensage("Error", "Parametro recebido esta nulo");
	        	}
	        }else{
	        	getMensage("Error", "Itente recebida esta nula");
	        }
	        
	 }

	public void showTime(Time time){
	 setContentView(R.layout.time_view_template);
	//carrega a imagem
    byte[] foto = time.getFoto();

    Bitmap bmp=BitmapFactory.decodeByteArray(foto,0,foto.length);// decodifica o array de bytes em um bitmamp
  //  Bitmap bMapScaled = Bitmap.createScaledBitmap(bmp, 150, 100, true); // define o tamanho da imagem (originalBitmap, newX, newY, true) 
    																	//  true habilita o filtro
    
    ImageView imView = (ImageView)findViewById(R.id.imview);
    TextView nomeTx = (TextView)findViewById(R.id.nome);
    TextView cidadeTx = (TextView)findViewById(R.id.tecnico);
    TextView descricaoTx = (TextView)findViewById(R.id.historico);
   
    imView.setImageBitmap(bmp);
    nomeTx.setText(time.getNome());
    cidadeTx.setText("Tecnico: "+ time.getTecnico());
    descricaoTx.setText(time.getHistorico());
   	
}
	
	public void getMensage(String title,String mensage){
 	 
 	 AlertDialog.Builder mensagem = new AlertDialog.Builder(TimeTemplateActivity.this);
 	 mensagem.setTitle(title);
 	 mensagem.setMessage(mensage);
 	 mensagem.setNeutralButton("Fechar", null);
 	 mensagem.show();
  }

}
