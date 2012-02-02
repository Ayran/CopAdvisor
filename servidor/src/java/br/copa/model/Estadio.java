/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.copa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;


/**
 *
 * @author George
 */
@Entity
public class Estadio implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String nome;
    private String descricao;
    private String cidade;
    @Lob
    private byte[] foto;

    public Estadio() {
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
    
    
    
    

    @Override
    public String toString() {
        return "Estadio{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + '}';
    }
    
    
    
    
    
}
