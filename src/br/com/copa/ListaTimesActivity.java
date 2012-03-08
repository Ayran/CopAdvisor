package br.com.copa;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class ListaTimesActivity extends Activity {
    /** Called when the activity is first created. */
	private List<Time> lstTimess;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_view);
        ListView list = (ListView) findViewById(R.id.ListView12);
        
        //Iniciamos a lista de Timess
        //no método add já inserimos um novo registro de cada Timess desejado
        lstTimess = new ArrayList<Time>();
        lstTimess.add(new Time("Argentina", R.drawable.argentina));
        lstTimess.add(new Time("Brasil",  R.drawable.bra));
        lstTimess.add(new Time("Espanha", R.drawable.esp));
        lstTimess.add(new Time("Japão", R.drawable.jpn));
       
 
        //Criação do Adapter e passamos a nossa lista de Timess para ele
        TimeAdapter adapter = new TimeAdapter(this, lstTimess);
 
        //referenciamos a função que será invocada quando o usuário
        //clicar em algum item da lista
        list.setOnItemClickListener(onItemClick_List);
     
        list.setAdapter(adapter);
     
        
    }
 
    OnItemClickListener onItemClick_List = new OnItemClickListener() {
        public void onItemClick(AdapterView arg0, View view, int position, long index) {
            //Pegar o item clicado
            showToast("Você clicou no Times : " + lstTimess.get(position).getNome());
        }
    };
     
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }        
        
}
