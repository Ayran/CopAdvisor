package br.com.copa;

public class Time {
  private String nome;
  private int bandeira;
  
  
  public Time(String nome_, int bandeira_){
	  this.nome = nome_;
	  this.bandeira = bandeira_;
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
}
