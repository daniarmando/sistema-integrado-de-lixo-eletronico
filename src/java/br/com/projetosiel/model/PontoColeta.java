/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.model;

/**
 *
 * @author Daniel
 */
public class PontoColeta {
    private Integer idPontoColeta;
    private String nomePontoColeta;
    private String telefonePontoColeta;
    private String ruaPontoColeta;
    private Integer numeroPontoColeta;
    private String bairroPontoColeta;
    private String complementoPontoColeta;
    private String cidadePontoColeta;
    private String estadoPontoColeta;
    private String cepPontoColeta;
    private Receptor receptor;

    public PontoColeta(Integer idPontoColeta, String nomePontoColeta, String telefonePontoColeta, String ruaPontoColeta, Integer numeroPontoColeta, String bairroPontoColeta, String complementoPontoColeta, String cidadePontoColeta, String estadoPontoColeta, String cepPontoColeta, Receptor receptor) {
        this.idPontoColeta = idPontoColeta;
        this.nomePontoColeta = nomePontoColeta;
        this.telefonePontoColeta = telefonePontoColeta;
        this.ruaPontoColeta = ruaPontoColeta;
        this.numeroPontoColeta = numeroPontoColeta;
        this.bairroPontoColeta = bairroPontoColeta;
        this.complementoPontoColeta = complementoPontoColeta;
        this.cidadePontoColeta = cidadePontoColeta;
        this.estadoPontoColeta = estadoPontoColeta;
        this.cepPontoColeta = cepPontoColeta;
        this.receptor = receptor;
    }

    public PontoColeta() {
    }

    /**
     * @return the idPontoColeta
     */
    public Integer getIdPontoColeta() {
        return idPontoColeta;
    }

    /**
     * @param idPontoColeta the idPontoColeta to set
     */
    public void setIdPontoColeta(Integer idPontoColeta) {
        this.idPontoColeta = idPontoColeta;
    }

    /**
     * @return the nomePontoColeta
     */
    public String getNomePontoColeta() {
        return nomePontoColeta;
    }

    /**
     * @param nomePontoColeta the nomePontoColeta to set
     */
    public void setNomePontoColeta(String nomePontoColeta) {
        this.nomePontoColeta = nomePontoColeta;
    }

    /**
     * @return the telefonePontoColeta
     */
    public String getTelefonePontoColeta() {
        return telefonePontoColeta;
    }

    /**
     * @param telefonePontoColeta the telefonePontoColeta to set
     */
    public void setTelefonePontoColeta(String telefonePontoColeta) {
        this.telefonePontoColeta = telefonePontoColeta;
    }

    /**
     * @return the ruaPontoColeta
     */
    public String getRuaPontoColeta() {
        return ruaPontoColeta;
    }

    /**
     * @param ruaPontoColeta the ruaPontoColeta to set
     */
    public void setRuaPontoColeta(String ruaPontoColeta) {
        this.ruaPontoColeta = ruaPontoColeta;
    }

    /**
     * @return the numeroPontoColeta
     */
    public Integer getNumeroPontoColeta() {
        return numeroPontoColeta;
    }

    /**
     * @param numeroPontoColeta the numeroPontoColeta to set
     */
    public void setNumeroPontoColeta(Integer numeroPontoColeta) {
        this.numeroPontoColeta = numeroPontoColeta;
    }

    /**
     * @return the bairroPontoColeta
     */
    public String getBairroPontoColeta() {
        return bairroPontoColeta;
    }

    /**
     * @param bairroPontoColeta the bairroPontoColeta to set
     */
    public void setBairroPontoColeta(String bairroPontoColeta) {
        this.bairroPontoColeta = bairroPontoColeta;
    }

    /**
     * @return the complementoPontoColeta
     */
    public String getComplementoPontoColeta() {
        return complementoPontoColeta;
    }

    /**
     * @param complementoPontoColeta the complementoPontoColeta to set
     */
    public void setComplementoPontoColeta(String complementoPontoColeta) {
        this.complementoPontoColeta = complementoPontoColeta;
    }

    /**
     * @return the cidadePontoColeta
     */
    public String getCidadePontoColeta() {
        return cidadePontoColeta;
    }

    /**
     * @param cidadePontoColeta the cidadePontoColeta to set
     */
    public void setCidadePontoColeta(String cidadePontoColeta) {
        this.cidadePontoColeta = cidadePontoColeta;
    }

    /**
     * @return the estadoPontoColeta
     */
    public String getEstadoPontoColeta() {
        return estadoPontoColeta;
    }

    /**
     * @param estadoPontoColeta the estadoPontoColeta to set
     */
    public void setEstadoPontoColeta(String estadoPontoColeta) {
        this.estadoPontoColeta = estadoPontoColeta;
    }

    /**
     * @return the cepPontoColeta
     */
    public String getCepPontoColeta() {
        return cepPontoColeta;
    }

    /**
     * @param cepPontoColeta the cepPontoColeta to set
     */
    public void setCepPontoColeta(String cepPontoColeta) {
        this.cepPontoColeta = cepPontoColeta;
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
