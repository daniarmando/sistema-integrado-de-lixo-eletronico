/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.model;

/**
 *
 * @author Daniel
 */
public class ListaEquipamento {
    private Integer idListaEquipamento;
    private String nomeListaEquipamento;
    private Receptor receptor;

    public ListaEquipamento(Integer idListaEquipamento, String nomeListaEquipamento, Receptor receptor) {
        this.idListaEquipamento = idListaEquipamento;
        this.nomeListaEquipamento = nomeListaEquipamento;
        this.receptor = receptor;
    }

    public ListaEquipamento() {
    }

    /**
     * @return the idListaEquipamento
     */
    public Integer getIdListaEquipamento() {
        return idListaEquipamento;
    }

    /**
     * @param idListaEquipamento the idListaEquipamento to set
     */
    public void setIdListaEquipamento(Integer idListaEquipamento) {
        this.idListaEquipamento = idListaEquipamento;
    }

    /**
     * @return the nomeListaEquipamento
     */
    public String getNomeListaEquipamento() {
        return nomeListaEquipamento;
    }

    /**
     * @param nomeListaEquipamento the nomeListaEquipamento to set
     */
    public void setNomeListaEquipamento(String nomeListaEquipamento) {
        this.nomeListaEquipamento = nomeListaEquipamento;
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
