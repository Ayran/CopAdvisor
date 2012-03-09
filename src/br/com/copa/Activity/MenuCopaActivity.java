package br.com.copa.Activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


//Autora Ayran Costa

/*Classe respons�vel pela lista que cont�m as informa��es sobre a copa
 * e pelo encaminhamento para a Activity referente a escolha do item desta
 * lista pelo usu�rio.
 * 
 * Atributos
 * Array contendo os itens que ser�o inseridos na lista
 * Objeto Intent para chamar a Activity respons�vel
 */


public class MenuCopaActivity extends ListActivity{
	
	private String[] opcoesMenucopa = {"Pr�ximos Jogos","Tabela da Copa","Estadios", "Times"};
	private Intent it; 
	
	  @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
	        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,opcoesMenucopa);
	        setListAdapter(adapter);
	  }
	  
	  @Override
	  protected void onListItemClick(ListView l, View v, int position, long id){
		  super.onListItemClick(l, v, position, id);
		  //Pega o nome do item que foi clicado atrav�s de sua posi��o na lista
		  String item = (String) this.getListAdapter().getItem(position);
		  
		  if(item.equals("Estadios")){
			  it = new Intent(this,MenuEstadiosActivity.class);
			  startActivity(it);
		  
		  }
		  
		  if(item.equals("Times")){
			  it = new Intent(this,ListaTimesActivity.class);
			  startActivity(it);
		  
		  }
	  }
}
