package br.com.copa.Activity;



import br.com.copa.LocalUserOverlay;

import br.com.copa.R;
import br.com.copa.Model.Ponto;
import br.com.copa.Model.PontoIzabel;
import br.com.copa.R.drawable;
import br.com.copa.R.id;
import br.com.copa.R.idMenu;
import br.com.copa.R.layout;
import br.com.copa.R.menu;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

//Autor George Dias
/* Activity principal da aplica��o respons�vel em gerar o mapa com a localiza�ao do usu�rio.
 *Tamb�m possui a implementa��o do menu principal da aplica��o */


public class CopaAdvisorActivity extends MapActivity implements LocationListener {
    
	private static final String CATEGORIA = "copa";
	private LocalUserOverlay imagem;
	private MapView mapa;
	private MapController controlador;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
         mapa = (MapView) findViewById(R.id.mapaView);
        
        //Instancia do controlador do mapa
         controlador = mapa.getController();
        
        //Instancia ums imagem (overlay) que representar� o usuario no mapa
        LocalUserOverlay imagem = new LocalUserOverlay (new PontoIzabel(), R.drawable.red_ball);
        mapa.getOverlays().add(imagem);
                
        //centraliza o mapa em uma determinada coordenada
        controlador.animateTo(new PontoIzabel());
        
        //Centraliza o mapa na ultima localizacao conhecida
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
       /* Location local = getLocationManager().getLastKnownLocation(LocationManager.GPS_PROVIDER);
      
        if(local != null){   //Se existe ultima localizacao converte para GeoPoint
        	
        	Ponto ponto = new Ponto(local);minTime
        	//Instancia ums imagem (overlay) que representar� o usuario no mapa
        	 imagem = new LocalUserOverlay (ponto, R.drawable.red_ball);
             mapa.getOverlays().add(imagem);
        	controlador.setCenter(ponto);
        }else{
        	getMensage("Aviso", "N�o foi possiver rastrear nova localiza��o");
        }
        
        //GPS Listener
        getLocationManager().requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);*/
        
        mapa.setStreetView(true);// configura pra mostrar o mapa no modo street
        mapa.setClickable(true);
        //define o zoom do mapa
        controlador.setZoom(19);
        mapa.setBuiltInZoomControls(true); 
       
       
       
    }
    
    /*Metodo respons�vel pelo menu principal*/
    
    public boolean onCreateOptionsMenu(Menu menu){
    	MenuInflater mainMenu = getMenuInflater();
    	mainMenu.inflate(R.menu.lista, menu);
    	
    	return true;
    }
    
    // Metodo respons�vel por identificar qual o item de menu escolhido e invocar a Activity correspondente
    public boolean onOptionsItemSelected(MenuItem itemMenu){
   	 
    	switch(itemMenu.getItemId()){
    	
    		case R.idMenu.mensagem:
    			getMensage("CopaAdvisor", "Menu de Mensagem"); 
    			break;
    			 
    		case R.idMenu.amigos: 
    			getMensage("CopaAdvisor", "Menu Adicionar Amigos");
    			break;
   			 	
    		case R.idMenu.copa: 
    			/*Manda uma inten��o ao SO para executar a activity(tela) desejada*/
    			Intent it = new Intent(this, MenuCopaActivity.class);
    			startActivity(it);
    			break;
    		
    		case R.idMenu.eventos: 
    			getMensage("CopaAdvisor", "Menu Eventos"); 
    			break;
    		
    		case R.idMenu.configuracoes: 
    			getMensage("CopaAdvisor", "Menu Configuracoes"); 
    			break;
   			 
   		}
    	
    	return super.onOptionsItemSelected(itemMenu);
     }
    
    
    //GPS
    
    private LocationManager getLocationManager(){
    	LocationManager location = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    	return location;
    }

    //Esse m�todo deve retornar true se sua aplica��o estiver tra�ando rotas ou violar� os termos de uso. 
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	//M�todo chamado automaticamente pelo Android sempre que a localiza��o do GPS for alterada
	//Par�metro location contem a latitude e longitude atual.
	public void onLocationChanged(Location location) {
		Log.i(CATEGORIA, "latitude" + location.getLatitude() +" longitude"+ location.getLongitude());
		GeoPoint geoPoint = new Ponto(location);
		//Atualiza a imagem que representa o usuario no mapa
		imagem.setGeoPoint(geoPoint);
		imagem.setImagem(R.drawable.red_ball);
		
		mapa.getOverlays().add(imagem);
		
		 //Anima o mapa at� a nova localiza��o
		 controlador.animateTo(geoPoint);
		 
		 //invalida para desenhar novamente o mapa
		// mapa.invalidate();
		
		
		
	}

	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
	
	public void getMensage(String title,String mensage){
	   	 
	   	 AlertDialog.Builder mensagem = new AlertDialog.Builder(CopaAdvisorActivity.this);
	   	 mensagem.setTitle(title);
	   	 mensagem.setMessage(mensage);
	   	 mensagem.setNeutralButton("Fechar", null);
	   	 mensagem.show();
	   	 
	   	 
	    }
	
	
}