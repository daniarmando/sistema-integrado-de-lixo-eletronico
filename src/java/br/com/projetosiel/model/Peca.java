/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.model;

/**
 *
 * @author Daniel
 */
public class Peca {  
   private Integer codigoPeca;
   private String nomePeca;
   private String detalhePeca;
   private String statusPeca;
   private Coleta coleta;   

    public Peca(Integer codigoPeca, String nomePeca, String detalhePeca, String statusPeca, Coleta coleta) {
        this.codigoPeca = codigoPeca;
        this.nomePeca = nomePeca;
        this.detalhePeca = detalhePeca;
        this.statusPeca = statusPeca;
        this.coleta = coleta;        
    }

    public Peca() {
    }

    /**
     * @return the codigoPeca
     */
    public Integer getCodigoPeca() {
        return codigoPeca;
    }

    /**
     * @param codigoPeca the codigoPeca to set
     */
    public void setCodigoPeca(Integer codigoPeca) {
        this.codigoPeca = codigoPeca;
    }

    /**
     * @return the nomePeca
     */
    public String getNomePeca() {
        return nomePeca;
    }

    /**
     * @param nomePeca the nomePeca to set
     */
    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    /**
     * @return the detalhePeca
     */
    public String getDetalhePeca() {
        return detalhePeca;
    }

    /**
     * @param detalhePeca the detalhePeca to set
     */
    public void setDetalhePeca(String detalhePeca) {
        this.detalhePeca = detalhePeca;
    }

    /**
     * @return the statusPeca
     */
    public String getStatusPeca() {
        return statusPeca;
    }

    /**
     * @param statusPeca the statusPeca to set
     */
    public void setStatusPeca(String statusPeca) {
        this.statusPeca = statusPeca;
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
    
}
