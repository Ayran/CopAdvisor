package br.com.copa;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Base64;

public class Estadio {
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

	    public void setCidade(String cidade) {
	        this.cidade = cidade;
	    }

	    public void setFoto(byte[] foto) {
	        this.foto = foto;
	    }
	    

}
