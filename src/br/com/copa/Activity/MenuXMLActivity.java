package br.com.copa.Activity;



import br.com.copa.R;
import br.com.copa.R.idMenu;
import br.com.copa.R.layout;
import br.com.copa.R.menu;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MenuXMLActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public boolean onCreateOptionsMenu(Menu menu){
    	MenuInflater mainMenu = getMenuInflater();
    	mainMenu.inflate(R.menu.lista, menu);
    	
    	//com apenas codigo java
    	/*boolean result = super.onCreateOptionsMenu(menu);
    	super.onCreateOptionsMenu(menu);
    	menu.add(0, 1, 0, "Cadastro").setIcon(R.drawable.ic_123807);
    	menu.add(0, 2, 0, "Editar").setIcon(R.drawable.ic_launcher);
    	return result;*/
    	
    	
    	return true;
    }
    
     public boolean onOptionsItemSelected(MenuItem itemMenu){
    	 
    	switch(itemMenu.getItemId()){
    	
    		case idMenu.mensagem: getMensage("CopaAdvisor", "Menu de Mensagem");  break;
    			 
    		case idMenu.amigos: getMensage("CopaAdvisor", "Menu Adicionar Amigos"); break;
   			 	
    		case idMenu.copa: getMensage("CopaAdvisor", "Menu Sobre a Copa"); break;
    		
    		case idMenu.eventos: getMensage("CopaAdvisor", "Menu Eventos"); break;
    		
    		case idMenu.configuracoes: getMensage("CopaAdvisor", "Menu Configuracoes"); break;
   			 
   		}
    	
    	return super.onOptionsItemSelected(itemMenu);
     }
     
     
     public void getMensage(String title,String mensage){
    	 
    	 AlertDialog.Builder mensagem = new AlertDialog.Builder(MenuXMLActivity.this);
    	 mensagem.setTitle(title);
    	 mensagem.setMessage(mensage);
    	 mensagem.setNeutralButton("Fechar", null);
    	 mensagem.show();
    	 
    	 
     }
}