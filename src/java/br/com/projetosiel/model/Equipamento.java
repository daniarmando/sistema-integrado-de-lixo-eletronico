/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.model;

/**
 *
 * @author Daniel
 */
public class Equipamento {
    private Integer codigoEquipamento;
    private String nomeEquipamento;
    private String tipoEquipamento;
    private String statusEquipamento;
    private String estadoEquipamento;
    private Coleta coleta;
    private Categoria categoria;

    public Equipamento(Integer codigoEquipamento, String nomeEquipamento, String tipoEquipamento, String statusEquipamento, String estadoEquipamento, Coleta coleta, Categoria categoria) {
        this.codigoEquipamento = codigoEquipamento;
        this.nomeEquipamento = nomeEquipamento;
        this.tipoEquipamento = tipoEquipamento;
        this.statusEquipamento = statusEquipamento;
        this.estadoEquipamento = estadoEquipamento;
        this.coleta = coleta;
        this.categoria = categoria;
    }

    public Equipamento() {
    }

    /**
     * @return the codigoEquipamento
     */
    public Integer getCodigoEquipamento() {
        return codigoEquipamento;
    }

    /**
     * @param codigoEquipamento the codigoEquipamento to set
     */
    public void setCodigoEquipamento(Integer codigoEquipamento) {
        this.codigoEquipamento = codigoEquipamento;
    }

    /**
     * @return the nomeEquipamento
     */
    public String getNomeEquipamento() {
        return nomeEquipamento;
    }

    /**
     * @param nomeEquipamento the nomeEquipamento to set
     */
    public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
    }

    /**
     * @return the tipoEquipamento
     */
    public String getTipoEquipamento() {
        return tipoEquipamento;
    }

    /**
     * @param tipoEquipamento the tipoEquipamento to set
     */
    public void setTipoEquipamento(String tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    /**
     * @return the statusEquipamento
     */
    public String getStatusEquipamento() {
        return statusEquipamento;
    }

    /**
     * @param statusEquipamento the statusEquipamento to set
     */
    public void setStatusEquipamento(String statusEquipamento) {
        this.statusEquipamento = statusEquipamento;
    }

    /**
     * @return the estadoEquipamento
     */
    public String getEstadoEquipamento() {
        return estadoEquipamento;
    }

    /**
     * @param estadoEquipamento the estadoEquipamento to set
     */
    public void setEstadoEquipamento(String estadoEquipamento) {
        this.estadoEquipamento = estadoEquipamento;
    }

    /**
     * @return the coleta
     */
    public Coleta getColeta() {
        return coleta;
    }

    /**
     * @param coleta the coleta to set
     */
    public void setColeta(Coleta coleta) {
        this.coleta = coleta;
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

   
   }
