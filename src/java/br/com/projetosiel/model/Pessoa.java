/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.model;

/**
 *
 * @author Daniel
 */
public class Pessoa {
    protected Integer idPessoa;
    protected String tipoPessoa;
    protected String nomeRazaoPessoa;
    protected String cpfCnpjPessoa;
    protected String rgIePessoa;
    protected String telefonePessoa;
    protected String ruaPessoa;
    protected Integer numeroPessoa;
    protected String complementoPessoa;
    protected String bairroPessoa;
    protected String cidadePessoa;
    protected String cepPessoa;
    protected String estadoPessoa;
    protected String emailPessoa;
    protected String loginPessoa;
    protected String senhaPessoa;
    private String atorPessoa;

    public Pessoa(Integer idPessoa, String tipoPessoa, String nomeRazaoPessoa, String cpfCnpjPessoa, String rgIePessoa, String telefonePessoa, String ruaPessoa, Integer numeroPessoa, String complementoPessoa, String bairroPessoa, String cidadePessoa, String cepPessoa, String estadoPessoa, String emailPessoa, String loginPessoa, String senhaPessoa) {
        this.idPessoa = idPessoa;
        this.tipoPessoa = tipoPessoa;
        this.nomeRazaoPessoa = nomeRazaoPessoa;
        this.cpfCnpjPessoa = cpfCnpjPessoa;
        this.rgIePessoa = rgIePessoa;
        this.telefonePessoa = telefonePessoa;
        this.ruaPessoa = ruaPessoa;
        this.numeroPessoa = numeroPessoa;
        this.complementoPessoa = complementoPessoa;
        this.bairroPessoa = bairroPessoa;
        this.cidadePessoa = cidadePessoa;
        this.cepPessoa = cepPessoa;
        this.estadoPessoa = estadoPessoa;
        this.emailPessoa = emailPessoa;
        this.loginPessoa = loginPessoa;
        this.senhaPessoa = senhaPessoa;
    }

    public Pessoa() {
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getNomeRazaoPessoa() {
        return nomeRazaoPessoa;
    }

    public void setNomeRazaoPessoa(String nomeRazaoPessoa) {
        this.nomeRazaoPessoa = nomeRazaoPessoa;
    }

    public String getCpfCnpjPessoa() {
        return cpfCnpjPessoa;
    }

    public void setCpfCnpjPessoa(String cpfCnpjPessoa) {
        this.cpfCnpjPessoa = cpfCnpjPessoa;
    }

    public String getRgIePessoa() {
        return rgIePessoa;
    }

    public void setRgIePessoa(String rgIePessoa) {
        this.rgIePessoa = rgIePessoa;
    }

    public String getTelefonePessoa() {
        return telefonePessoa;
    }

    public void setTelefonePessoa(String telefonePessoa) {
        this.telefonePessoa = telefonePessoa;
    }

    public String getRuaPessoa() {
        return ruaPessoa;
    }

    public void setRuaPessoa(String ruaPessoa) {
        this.ruaPessoa = ruaPessoa;
    }

    public Integer getNumeroPessoa() {
        return numeroPessoa;
    }

    public void setNumeroPessoa(Integer numeroPessoa) {
        this.numeroPessoa = numeroPessoa;
    }

    public String getComplementoPessoa() {
        return complementoPessoa;
    }

    public void setComplementoPessoa(String complementoPessoa) {
        this.complementoPessoa = complementoPessoa;
    }

    public String getBairroPessoa() {
        return bairroPessoa;
    }

    public void setBairroPessoa(String bairroPessoa) {
        this.bairroPessoa = bairroPessoa;
    }

    public String getCidadePessoa() {
        return cidadePessoa;
    }

    public void setCidadePessoa(String cidadePessoa) {
        this.cidadePessoa = cidadePessoa;
    }

    public String getCepPessoa() {
        return cepPessoa;
    }

    public void setCepPessoa(String cepPessoa) {
        this.cepPessoa = cepPessoa;
    }

    public String getEstadoPessoa() {
        return estadoPessoa;
    }

    public void setEstadoPessoa(String estadoPessoa) {
        this.estadoPessoa = estadoPessoa;
    }

    public String getEmailPessoa() {
        return emailPessoa;
    }

    public void setEmailPessoa(String emailPessoa) {
        this.emailPessoa = emailPessoa;
    }

    public String getLoginPessoa() {
        return loginPessoa;
    }

    public void setLoginPessoa(String loginPessoa) {
        this.loginPessoa = loginPessoa;
    }

    public String getSenhaPessoa() {
        return senhaPessoa;
    }

    public void setSenhaPessoa(String senhaPessoa) {
        this.senhaPessoa = senhaPessoa;
    }

    /**
     * @return the atorPessoa
     */
    public String getAtorPessoa() {
        return atorPessoa;
    }

    /**
     * @param atorPessoa the atorPessoa to set
     */
    public void setAtorPessoa(String atorPessoa) {
        this.atorPessoa = atorPessoa;
    }

    
}
