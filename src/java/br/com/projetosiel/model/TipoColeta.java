/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.model;

/**
 *
 * @author Daniel
 */
public class TipoColeta {
    private Integer idTipoColeta;
    private String nomeTipoColeta;
    private Receptor receptor;

    public TipoColeta(Integer idTipoColeta, String nomeTipoColeta, Receptor receptor) {
        this.idTipoColeta = idTipoColeta;
        this.nomeTipoColeta = nomeTipoColeta;
        this.receptor = receptor;
    }

    public TipoColeta() {
    }

    /**
     * @return the idTipoColeta
     */
    public Integer getIdTipoColeta() {
        return idTipoColeta;
    }

    /**
     * @param idTipoColeta the idTipoColeta to set
     */
    public void setIdTipoColeta(Integer idTipoColeta) {
        this.idTipoColeta = idTipoColeta;
    }

    /**
     * @return the nomeTipoColeta
     */
    public String getNomeTipoColeta() {
        return nomeTipoColeta;
    }

    /**
     * @param nomeTipoColeta the nomeTipoColeta to set
     */
    public void setNomeTipoColeta(String nomeTipoColeta) {
        this.nomeTipoColeta = nomeTipoColeta;
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
