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
public class Doacao {
    private Integer numeroControleDoacao;
    private String descricaoDoacao;
    private Date dataSolicitacaoDoacao;
    private Date dataConclusaoDoacao;
    private String statusDoacao;
    private Beneficiario beneficiario;

   
    public Doacao(Integer numeroControleDoacao, String descricaoDoacao, Date dataSolicitacaoDoacao, Date dataConclusaoDoacao, String statusDoacao, Beneficiario beneficiario) {
        this.numeroControleDoacao = numeroControleDoacao;
        this.descricaoDoacao = descricaoDoacao;
        this.dataSolicitacaoDoacao = dataSolicitacaoDoacao;
        this.dataConclusaoDoacao = dataConclusaoDoacao;
        this.statusDoacao = statusDoacao;
        this.beneficiario = beneficiario;
    }
 public Doacao() {
    }

    /**
     * @return the numeroControleDoacao
     */
    public Integer getNumeroControleDoacao() {
        return numeroControleDoacao;
    }

    /**
     * @param numeroControleDoacao the numeroControleDoacao to set
     */
    public void setNumeroControleDoacao(Integer numeroControleDoacao) {
        this.numeroControleDoacao = numeroControleDoacao;
    }

    /**
     * @return the descricaoDoacao
     */
    public String getDescricaoDoacao() {
        return descricaoDoacao;
    }

    /**
     * @param descricaoDoacao the descricaoDoacao to set
     */
    public void setDescricaoDoacao(String descricaoDoacao) {
        this.descricaoDoacao = descricaoDoacao;
    }

    /**
     * @return the dataSolicitacaoDoacao
     */
    public Date getDataSolicitacaoDoacao() {
        return dataSolicitacaoDoacao;
    }

    /**
     * @param dataSolicitacaoDoacao the dataSolicitacaoDoacao to set
     */
    public void setDataSolicitacaoDoacao(Date dataSolicitacaoDoacao) {
        this.dataSolicitacaoDoacao = dataSolicitacaoDoacao;
    }

    /**
     * @return the dataConclusaoDoacao
     */
    public Date getDataConclusaoDoacao() {
        return dataConclusaoDoacao;
    }

    /**
     * @param dataConclusaoDoacao the dataConclusaoDoacao to set
     */
    public void setDataConclusaoDoacao(Date dataConclusaoDoacao) {
        this.dataConclusaoDoacao = dataConclusaoDoacao;
    }

    /**
     * @return the statusDoacao
     */
    public String getStatusDoacao() {
        return statusDoacao;
    }

    /**
     * @param statusDoacao the statusDoacao to set
     */
    public void setStatusDoacao(String statusDoacao) {
        this.statusDoacao = statusDoacao;
    }

    /**
     * @return the beneficiario
     */
    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    /**
     * @param beneficiario the beneficiario to set
     */
    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

   
}
