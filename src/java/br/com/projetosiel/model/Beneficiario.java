/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.model;

/**
 *
 * @author Daniel
 */
public class Beneficiario extends Pessoa{
    private Integer idBeneficiario;
    private Receptor receptor;

    public Beneficiario(Integer idBeneficiario, Receptor receptor, Integer idPessoa, String tipoPessoa, String nomeRazaoPessoa, String cpfCnpjPessoa, String rgIePessoa, String telefonePessoa, String ruaPessoa, Integer numeroPessoa, String complementoPessoa, String bairroPessoa, String cidadePessoa, String cepPessoa, String estadoPessoa, String emailPessoa, String loginPessoa, String senhaPessoa) {
        super(idPessoa, tipoPessoa, nomeRazaoPessoa, cpfCnpjPessoa, rgIePessoa, telefonePessoa, ruaPessoa, numeroPessoa, complementoPessoa, bairroPessoa, cidadePessoa, cepPessoa, estadoPessoa, emailPessoa, loginPessoa, senhaPessoa);
        this.idBeneficiario = idBeneficiario;
        this.receptor = receptor;
    }

   
    public Beneficiario() {
    }

    /**
     * @return the idBeneficiario
     */
    public Integer getIdBeneficiario() {
        return idBeneficiario;
    }

    /**
     * @param idBeneficiario the idBeneficiario to set
     */
    public void setIdBeneficiario(Integer idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
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
