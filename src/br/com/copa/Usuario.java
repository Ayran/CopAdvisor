package br.com.copa;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Base64;

public class Usuario {
	
    private int id;
    private String nome;
    private String login;
    private String password;
    private String nacionalidade;
    private String rg;
    private int latitude;
    private int longitude;

    public Usuario(JSONObject estadioJson) throws JSONException {
    	this.nome = estadioJson.get("nome").toString();
    	this.login = estadioJson.get("login").toString();
    	this.password = estadioJson.get("password").toString();
    	this.nacionalidade = estadioJson.get("nacionalidade").toString();
    	this.rg = estadioJson.get("rg").toString();
    	this.latitude = (Integer) estadioJson.get("latitude");
    	this.longitude =(Integer) estadioJson.get("longitude");
    }

    public int getId() {
        return id;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    public String getRg() {
        return rg;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
}
