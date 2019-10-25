/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.model;

/**
 *
 * @author Daniel
 */
public class Receptor extends Pessoa {

    private Integer idReceptor;
    private String siteReceptor;
    private TipoColeta tipoColeta;

    public Receptor(Integer idReceptor, String siteReceptor, Integer idPessoa, String tipoPessoa, String nomeRazaoPessoa, String cpfCnpjPessoa, String rgIePessoa, String telefonePessoa, String ruaPessoa, Integer numeroPessoa, String complementoPessoa, String bairroPessoa, String cidadePessoa, String cepPessoa, String estadoPessoa, String emailPessoa, String loginPessoa, String senhaPessoa) {
        super(idPessoa, tipoPessoa, nomeRazaoPessoa, cpfCnpjPessoa, rgIePessoa, telefonePessoa, ruaPessoa, numeroPessoa, complementoPessoa, bairroPessoa, cidadePessoa, cepPessoa, estadoPessoa, emailPessoa, loginPessoa, senhaPessoa);
        this.idReceptor = idReceptor;
        this.siteReceptor = siteReceptor;
    }

    public Receptor() {
    }

    /**
     * @return the idReceptor
     */
    public Integer getIdReceptor() {
        return idReceptor;
    }

    /**
     * @param idReceptor the idReceptor to set
     */
    public void setIdReceptor(Integer idReceptor) {
        this.idReceptor = idReceptor;
    }

    /**
     * @return the siteReceptor
     */
    public String getSiteReceptor() {
        return siteReceptor;
    }

    /**
     * @param siteReceptor the siteReceptor to set
     */
    public void setSiteReceptor(String siteReceptor) {
        this.siteReceptor = siteReceptor;
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
    
}