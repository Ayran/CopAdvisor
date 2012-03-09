package br.com.copa;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import br.com.copa.Model.Ponto;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class ExemploAndandoRua extends MapActivity implements LocationListener
{
	private static final String CATEGORIA = "livro";
	private MapController controlador;
	private MapView mapa;
	private LocalUserOverlay local;
	
	@Override
	public void onCreate (Bundle icicle)
	{
		super.onCreate(icicle);
		setContentView(R.layout.main);
		mapa = (MapView) findViewById(R.id.mapaView);
		mapa.setClickable(true);
		mapa.setStreetView(true);
		controlador = mapa.getController();
		controlador.setZoom(16);
		local = new LocalUserOverlay(null, Color.BLUE);
		mapa.getOverlays().add(local);
		
		Location loc = getLocationManager().getLastKnownLocation(LocationManager.GPS_PROVIDER);
		
		if (loc != null)
		{
			Ponto ponto = new Ponto(loc);
			Log.i(CATEGORIA, "Ultima  localizacao" + ponto);
			local.setGeoPoint(ponto);
			controlador.setCenter(ponto);
			
		}
		
		getLocationManager().requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
		
	}
	public void onLocationChanged(Location arg0)
	{
		// TODO Auto-generated method stub

	}

	public void onProviderDisabled(String arg0)
	{
		// TODO Auto-generated method stub

	}

	public void onProviderEnabled(String arg0)
	{
		// TODO Auto-generated method stub

	}

	public void onStatusChanged(String arg0, int arg1, Bundle arg2)
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isRouteDisplayed()
	{
		// TODO Auto-generated method stub
		return false;
	}
	private LocationManager getLocationManager()
	{
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		return locationManager;
	}

}
