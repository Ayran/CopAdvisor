package br.com.copa;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class LoginActivity extends Activity {
    
	private EditText login, password;
    private Button btEnviar;
    private WebMessage server = new WebMessage();
    private Intent it;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_view);
        
        login = (EditText)findViewById(R.id.login);
        password = (EditText)findViewById(R.id.password);
        btEnviar = (Button) findViewById(R.botao.enviar);
        
        btEnviar.setOnClickListener(new View.OnClickListener() {
        		
			public void onClick(View v) {
				
			Usuario autenticado = (Usuario) server.autenticarUsuario(login.getText().toString(),password.getText().toString());
			
			if(autenticado!=null){
				getPrincipalView();
    			
			}else{
				getMensage("Aviso", "Usuário ou Senha Incorretos");
				}
				
			}
		});
    }
    
    public void getPrincipalView(){
    	/*Manda uma intenção ao SO para executar a activity(tela) desejada*/
    	 it = new Intent(this, CopaAdvisorActivity.class);
		startActivity(it);
    }
    
    public void getMensage(String title,String mensage){
	   	 
	   	 AlertDialog.Builder mensagem = new AlertDialog.Builder(LoginActivity.this);
	   	 mensagem.setTitle(title);
	   	 mensagem.setMessage(mensage);
	   	 mensagem.setNeutralButton("Fechar", null);
	   	 mensagem.show();
	   	 
	   	 
	    }
}