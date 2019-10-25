/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.model;

/**
 *
 * @author Daniel
 */
public class Solicitante extends Pessoa {
    private Integer idSolicitante;

    public Solicitante(Integer idSolicitante, Integer idPessoa, String tipoPessoa, String nomeRazaoPessoa, String cpfCnpjPessoa, String rgIePessoa, String telefonePessoa, String ruaPessoa, Integer numeroPessoa, String complementoPessoa, String bairroPessoa, String cidadePessoa, String cepPessoa, String estadoPessoa, String emailPessoa, String loginPessoa, String senhaPessoa) {
        super(idPessoa, tipoPessoa, nomeRazaoPessoa, cpfCnpjPessoa, rgIePessoa, telefonePessoa, ruaPessoa, numeroPessoa, complementoPessoa, bairroPessoa, cidadePessoa, cepPessoa, estadoPessoa, emailPessoa, loginPessoa, senhaPessoa);
        this.idSolicitante = idSolicitante;
    }

    
    public Solicitante() {
    }

    /**
     * @return the idSolicitante
     */
    public Integer getIdSolicitante() {
        return idSolicitante;
    }

    /**
     * @param idSolicitante the idSolicitante to set
     */
    public void setIdSolicitante(Integer idSolicitante) {
        this.idSolicitante = idSolicitante;
    }        
    
    
}
