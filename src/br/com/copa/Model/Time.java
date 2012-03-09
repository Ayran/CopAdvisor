package br.com.copa.Model;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Base64;

public class Time implements Serializable
{
	  private String nome;
	  private int bandeira;
	  private String tecnico;
	  private String historico;
	  private byte[] foto;
	  
	  public Time(String nome_, int bandeira_){
		  this.nome = nome_;
		  this.bandeira = bandeira_;
	  }
	  
		public Time(JSONObject timeJson) throws JSONException 
		{
			this.nome = timeJson.get("nome").toString();
			this.historico = timeJson.get("historico").toString();
			this.tecnico = timeJson.get("tecnico").toString();
			this.foto = Base64.decode(timeJson.get("foto").toString(),timeJson.get("foto").toString().length());
		}

	  public String getNome(){
		  return this.nome;
	  }
	  
	  public void setNome(String nome){
		  this.nome = nome;
	  }
	  
	  public int getBandeira(){
		  return this.bandeira;
	  }
	  
	  public void setBandeira(int bandeira){
		  this.bandeira = bandeira;
	  }
	

	public String getTecnico()
	{
		return tecnico;
	}
	
	
	public void setTecnico(String tecnico)
	{
		this.tecnico = tecnico;
	}
	
	
	public String getHistorico()
	{
		return historico;
	}
	
	
	public void setHistorico(String historico)
	{
		this.historico = historico;
	} 
	public void setFoto(byte[] foto) {
        this.foto = foto;
    }
	public byte[] getFoto() {
        return foto;
    }
}
