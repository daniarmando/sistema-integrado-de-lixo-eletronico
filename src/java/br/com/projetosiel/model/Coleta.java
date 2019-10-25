/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.model;

import java.util.Date;

/**
 *
 * @author Daniel
 */
public class Coleta {
    private Integer numeroControleColeta;
    private String descricaoColeta;
    private Date dataSolicitacaoColeta;
    private Date dataConclusaoColeta;
    private String statusColeta;
    private String statusMaterialColeta;
    private String nomeSolicitanteColeta;
    private TipoColeta tipoColeta;
    private Receptor receptor;
    private PontoColeta pontoColeta;
    private Solicitante solicitante;

    public Coleta(Integer numeroControleColeta, String descricaoColeta, Date dataSolicitacaoColeta, Date dataConclusaoColeta, String statusColeta, String statusMaterialColeta, String nomeSolicitanteColeta, TipoColeta tipoColeta, Receptor receptor, PontoColeta pontoColeta, Solicitante solicitante) {
        this.numeroControleColeta = numeroControleColeta;
        this.descricaoColeta = descricaoColeta;
        this.dataSolicitacaoColeta = dataSolicitacaoColeta;
        this.dataConclusaoColeta = dataConclusaoColeta;
        this.statusColeta = statusColeta;
        this.statusMaterialColeta = statusMaterialColeta;
        this.nomeSolicitanteColeta = nomeSolicitanteColeta;
        this.tipoColeta = tipoColeta;
        this.receptor = receptor;
        this.pontoColeta = pontoColeta;
        this.solicitante = solicitante;
    }

    public Coleta() {
    }

    /**
     * @return the numeroControleColeta
     */
    public Integer getNumeroControleColeta() {
        return numeroControleColeta;
    }

    /**
     * @param numeroControleColeta the numeroControleColeta to set
     */
    public void setNumeroControleColeta(Integer numeroControleColeta) {
        this.numeroControleColeta = numeroControleColeta;
    }

    /**
     * @return the descricaoColeta
     */
    public String getDescricaoColeta() {
        return descricaoColeta;
    }

    /**
     * @param descricaoColeta the descricaoColeta to set
     */
    public void setDescricaoColeta(String descricaoColeta) {
        this.descricaoColeta = descricaoColeta;
    }

    /**
     * @return the dataSolicitacaoColeta
     */
    public Date getDataSolicitacaoColeta() {
        return dataSolicitacaoColeta;
    }

    /**
     * @param dataSolicitacaoColeta the dataSolicitacaoColeta to set
     */
    public void setDataSolicitacaoColeta(Date dataSolicitacaoColeta) {
        this.dataSolicitacaoColeta = dataSolicitacaoColeta;
    }

    /**
     * @return the dataConclusaoColeta
     */
    public Date getDataConclusaoColeta() {
        return dataConclusaoColeta;
    }

    /**
     * @param dataConclusaoColeta the dataConclusaoColeta to set
     */
    public void setDataConclusaoColeta(Date dataConclusaoColeta) {
        this.dataConclusaoColeta = dataConclusaoColeta;
    }

    /**
     * @return the statusColeta
     */
    public String getStatusColeta() {
        return statusColeta;
    }

    /**
     * @param statusColeta the statusColeta to set
     */
    public void setStatusColeta(String statusColeta) {
        this.statusColeta = statusColeta;
    }

    /**
     * @return the statusMaterialColeta
     */
    public String getStatusMaterialColeta() {
        return statusMaterialColeta;
    }

    /**
     * @param statusMaterialColeta the statusMaterialColeta to set
     */
    public void setStatusMaterialColeta(String statusMaterialColeta) {
        this.statusMaterialColeta = statusMaterialColeta;
    }

    /**
     * @return the nomeSolicitanteColeta
     */
    public String getNomeSolicitanteColeta() {
        return nomeSolicitanteColeta;
    }

    /**
     * @param nomeSolicitanteColeta the nomeSolicitanteColeta to set
     */
    public void setNomeSolicitanteColeta(String nomeSolicitanteColeta) {
        this.nomeSolicitanteColeta = nomeSolicitanteColeta;
    }

    /**
     * @return the tipoColeta
     */
    public TipoColeta getTipoColeta() {
        return tipoColeta;
    }

    /**
     * @param tipoColeta the tipoColeta to set
     */
    public void setTipoColeta(TipoColeta tipoColeta) {
        this.tipoColeta = tipoColeta;
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

    /**
     * @return the pontoColeta
     */
    public PontoColeta getPontoColeta() {
        return pontoColeta;
    }

    /**
     * @param pontoColeta the pontoColeta to set
     */
    public void setPontoColeta(PontoColeta pontoColeta) {
        this.pontoColeta = pontoColeta;
    }

    /**
     * @return the solicitante
     */
    public Solicitante getSolicitante() {
        return solicitante;
    }

    /**
     * @param solicitante the solicitante to set
     */
    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

   
}
