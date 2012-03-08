package br.com.copa;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class BolaOverlay extends Overlay {
	
	private int cor;
	private Paint paint = new Paint();
	private GeoPoint geoPoint;
	
	public BolaOverlay(GeoPoint geoPoint_, int cor_){
		this.cor = cor_;
		this.geoPoint = geoPoint_;
	}
	
	//Método responsável em desenhar o circulo de acordo com as coordenadas
	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow){
		super.draw(canvas, mapView, shadow);
		
		if(geoPoint != null){
			
			paint.setColor(cor);
			//Converte as coordenadas para pixels (recebe a latitude e longitude o geoPoint e converte em pixels para identificar em quais
			//pontos da tela deverá desenhar o circulo).
			Point ponto = mapView.getProjection().toPixels(geoPoint, null);
			//desenha o circulo nos pontos indicados (cordenada x, cordenada y, radiano, objeto contendo a cor)
			canvas.drawCircle(ponto.x, ponto.y,10, paint);
			
		}
		
	}
	
	public void setGeoPoint(GeoPoint geoPoint_){
		this.geoPoint = geoPoint_;
	}

}
