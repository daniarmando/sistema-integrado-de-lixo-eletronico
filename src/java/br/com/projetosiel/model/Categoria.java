/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.model;

/**
 *
 * @author Daniel
 */
public class Categoria {
    private Integer idCategoria;
    private String nomeCategoria;

    public Categoria(Integer idCategoria, String nomeCategoria) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
    }

    public Categoria() {
    }

    /**
     * @return the idCategoria
     */
    public Integer getIdCategoria() {
        return idCategoria;
    }

    /**
     * @param idCategoria the idCategoria to set
     */
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * @return the nomeCategoria
     */
    public String getNomeCategoria() {
        return nomeCategoria;
    }

    /**
     * @param nomeCategoria the nomeCategoria to set
     */
    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    
    
   
}
