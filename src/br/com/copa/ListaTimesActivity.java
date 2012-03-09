package br.com.copa;

import java.util.ArrayList;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;


import android.app.AlertDialog;
import android.app.ListActivity;
import android.widget.ArrayAdapter;

public class ListaTimesActivity extends Activity {
    /** Called when the activity is first created. */
	private List<Time> lstTimess;
	private Intent it;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_view);
        ListView list = (ListView) findViewById(R.id.ListView12);
        
        //Iniciamos a lista de Timess
        //no m�todo add j� inserimos um novo registro de cada Timess desejado
        lstTimess = new ArrayList<Time>();
        lstTimess.add(new Time("Argentina", R.drawable.argentina));
        lstTimess.add(new Time("Brasil",  R.drawable.bra));
        lstTimess.add(new Time("Espanha", R.drawable.esp));
        lstTimess.add(new Time("Japao", R.drawable.jpn));
        lstTimess.add(new Time("Africa Do Sul", R.drawable.africa_do_sul));
        lstTimess.add(new Time("Franca", R.drawable.fra));
        lstTimess.add(new Time("Gana", R.drawable.gana));
        lstTimess.add(new Time("Alemanha", R.drawable.alemanha));
        lstTimess.add(new Time("Italia", R.drawable.italia));
        lstTimess.add(new Time("Portugal", R.drawable.portugal));
       
 
        //Criacao do Adapter e passamos a nossa lista de Timess para ele
        TimeAdapter adapter = new TimeAdapter(this, lstTimess);
 
        //referenciamos a funcao que sera invocada quando o usuario
        //clicar em algum item da lista
        list.setOnItemClickListener(onItemClick_List);
     
        list.setAdapter(adapter);
     
        
    }
    public void getTemplateTime(Time team)
    {
    	it = new Intent(this,TimeTemplateActivity.class);
    	Bundle parametro = new Bundle();
		parametro.putSerializable("time", team);
		it.putExtras(parametro);
		startActivity(it);
    }
    OnItemClickListener onItemClick_List = new OnItemClickListener() {
        public void onItemClick(AdapterView arg0, View view, int position, long index) {
            //Pegar o item clicado
            //showToast("Voce clicou no Time : " + lstTimess.get(position).getNome());
            
        	
    		 //Obtem o estadio escolhido pelo usu�rio
    		 String nometime = lstTimess.get(position).getNome();
    		
    		 //Objeto respons�vel por executar as requisi��es ao servidor       
    		 WebMessage ponte = new WebMessage();
    		 Time team = ponte.executeRequestTime(nometime);
    		//Solicita ao SO a execucao da Activity
    		//Objeto que armazenar o objeto estadio para ser passado como parametro para a Activity invocada
    		getTemplateTime(team);
        }
    };
     
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }        
        
}
