package br.com.copa;

import com.google.android.maps.GeoPoint;

import android.app.Activity;
import android.location.Location;

public class Ponto extends GeoPoint{

	
	//Valores em graus * 1E6 (microdegrees)
	public Ponto(int latitudeE6, int longitudeE6) {
		super(latitudeE6, longitudeE6);
		// TODO Auto-generated constructor stub
	}
	
	// Converte em microdegrees
	public Ponto(double latitude, double longitude) {
		this((int)(latitude * 1E6),(int)(longitude * 1E6));
	  
	}
	
	
	//Cria baseado no objeto location diretamente recebido do GPS
	public Ponto(Location location) {
		this(location.getLatitude(),location.getLongitude());
	  
	}


}
