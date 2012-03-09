package br.com.copa;


import java.util.ArrayList;

import java.util.List;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

//Autor George Dias


/*Classe respons�vel pela lista que cont�m as op��es de est�dios
* e pelo encaminhamento para a Activity tamplate que mostrar� as
* informa��es do est�dio escolhido pelo usu�rio.
* 
* Atributos
* Array contendo os estadio que ser�o inseridos na lista
*/

public class MenuEstadiosActivity extends ListActivity {
	
	private List<String> estadios =  new ArrayList<String>();
	private WebMessage request = new WebMessage();
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	   	    	
	    	//Iniciamos a lista de Estadios
	    	//estadios =  new ArrayList<String>();
	    	estadios = request.buscaEstadiosRequest();
	    	//estadios.add("Fonte Nova");
	    	//estadios.add("Maracan�");
	    	//estadios.add("Mineir�o");
	    	//Adaptador que ir� inserir os elementos do Array na lista
	    	ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,estadios);
	    	setListAdapter(adapter);
	    }
	 
	 @Override
	 protected void onListItemClick(ListView l, View v,int position, long id){
		 super.onListItemClick(l, v, position, id);
		 //Obtem o estadio escolhido pelo usu�rio
		 String nomeEstadio = estadios.get(position);
		
		 //Objeto respons�vel por executar as requisi��es ao servidor       
		 WebMessage ponte = new WebMessage();
		 Estadio estadio = ponte.executeRequest(nomeEstadio);
		//Solicita ao SO a execu��o da Activity
		 Intent it = new Intent(this,EstadioTemplateActivity.class);
		//Objeto que armazenar� o objeto estadio para ser passado como parametro para a Activity invocada
		Bundle parametro = new Bundle();
		parametro.putSerializable("estadio", estadio);
		
		it.putExtras(parametro);
		startActivity(it);
        
	 }
	   
	    
	    public void getMensage(String title,String mensage){
	      	 
	      	 AlertDialog.Builder mensagem = new AlertDialog.Builder(MenuEstadiosActivity.this);
	      	 mensagem.setTitle(title);
	      	 mensagem.setMessage(mensage);
	      	 mensagem.setNeutralButton("Fechar", null);
	      	 mensagem.show();
	      	 
	      	 
	       }
}
