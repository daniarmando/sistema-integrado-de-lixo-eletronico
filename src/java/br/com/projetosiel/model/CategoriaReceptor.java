/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.model;

/**
 *
 * @author Daniel
 */
public class CategoriaReceptor {
    private Integer idCategoriaReceptor;
    private Categoria categoria;
    private Receptor receptor;

    public CategoriaReceptor(Integer idCategoriaReceptor, Categoria categoria, Receptor receptor) {
        this.idCategoriaReceptor = idCategoriaReceptor;
        this.categoria = categoria;
        this.receptor = receptor;
    }

    public CategoriaReceptor() {
    }

    /**
     * @return the idCategoriaReceptor
     */
    public Integer getIdCategoriaReceptor() {
        return idCategoriaReceptor;
    }

    /**
     * @param idCategoriaReceptor the idCategoriaReceptor to set
     */
    public void setIdCategoriaReceptor(Integer idCategoriaReceptor) {
        this.idCategoriaReceptor = idCategoriaReceptor;
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the receptor
     */
    public Receptor getReceptor() {
        return receptor;
    }

    /**
     * @param receptor the receptor to set
     */
    public void setReceptor(Receptor receptor) {
        this.receptor = receptor;
    }
    
}
