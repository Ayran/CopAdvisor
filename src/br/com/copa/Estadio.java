package br.com.copa;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Base64;

//Autor George Dias

//Classe model que conter� as informa��es do estadio
//Serializavel para ser passado como parametro para a Activity

public class Estadio implements Serializable{
	 private int id;
	    private String nome;
	    private String descricao;
	    private String cidade;
	    
	    private byte[] foto;

	    public Estadio(JSONObject estadioJson) throws JSONException {
	    	this.nome = estadioJson.get("nome").toString();
	    	this.descricao = estadioJson.get("descricao").toString();
	    	this.cidade = estadioJson.get("cidade").toString();
	    	this.foto = Base64.decode(estadioJson.get("foto").toString(),estadioJson.get("foto").toString().length());
	    }
	    
	    
	    public Estadio (){}

	    public String getDescricao() {
	        return descricao;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public String getCidade() {
	        return cidade;
	    }

	    public byte[] getFoto() {
	        return foto;
	    }
	    
	    
	    public void setDescricao(String descricao) {
	        this.descricao = descricao;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }
	    
	    public void setNome(JSONObject jsonNome) throws JSONException {
	        this.nome = jsonNome.get("nome").toString() ;
	    }

	    public void setCidade(String cidade) {
	        this.cidade = cidade;
	    }

	    public void setFoto(byte[] foto) {
	        this.foto = foto;
	    }
	    
	    

}
