/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.model;

/**
 *
 * @author Daniel
 */
public class ListaPeca {
    private Integer idListaPeca;
    private String nomeListaPeca;
    private ListaEquipamento listaEquipamento;

    public ListaPeca(Integer idListaPeca, String nomeListaPeca, ListaEquipamento listaEquipamento) {
        this.idListaPeca = idListaPeca;
        this.nomeListaPeca = nomeListaPeca;
        this.listaEquipamento = listaEquipamento;
    }

    public ListaPeca() {
    }

    /**
     * @return the idListaPeca
     */
    public Integer getIdListaPeca() {
        return idListaPeca;
    }

    /**
     * @param idListaPeca the idListaPeca to set
     */
    public void setIdListaPeca(Integer idListaPeca) {
        this.idListaPeca = idListaPeca;
    }

    /**
     * @return the nomeListaPeca
     */
    public String getNomeListaPeca() {
        return nomeListaPeca;
    }

    /**
     * @param nomeListaPeca the nomeListaPeca to set
     */
    public void setNomeListaPeca(String nomeListaPeca) {
        this.nomeListaPeca = nomeListaPeca;
    }

    /**
     * @return the listaEquipamento
     */
    public ListaEquipamento getListaEquipamento() {
        return listaEquipamento;
    }

    /**
     * @param listaEquipamento the listaEquipamento to set
     */
    public void setListaEquipamento(ListaEquipamento listaEquipamento) {
        this.listaEquipamento = listaEquipamento;
    }

    
}
