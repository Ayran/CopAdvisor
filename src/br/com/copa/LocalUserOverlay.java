package br.com.copa;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class LocalUserOverlay extends Overlay{
 
	private Paint paint = new Paint();
	private int imagemId;
	private GeoPoint geoPoint;
	
	public LocalUserOverlay(GeoPoint geoPoint_, int resId){
		this.geoPoint = geoPoint_;
		this.imagemId = resId;
	}
	
	public void setGeoPoint(GeoPoint geoPoint_){
		this.geoPoint = geoPoint_;
	}
	
	public void setImagem(int resId_){
		this.imagemId = resId_;
	}
	
	
	
	
	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow){
		super.draw(canvas, mapView, shadow);
		
		//Converte as coordenadas para pixels
		Point p = mapView.getProjection().toPixels(geoPoint, null);
		
		//Converte o recurso da imagem fornecida em um bitmap atraves do bitmapFactory
		Bitmap bitmap = BitmapFactory.decodeResource(mapView.getResources(), this.imagemId);
		
		//Cria um objeto retangulo contendo as cordenadas xy do ponto e os pontos finais definidos pelo tamanho da imagem(bitmap)
		RectF r = new RectF(p.x,p.y,p.x+bitmap.getWidth(),p.y+bitmap.getHeight());
		
		//Desenha a imagem fornecida
		canvas.drawBitmap(bitmap, null,r, paint);
		
	}
}
