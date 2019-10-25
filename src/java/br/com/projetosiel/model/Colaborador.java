/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.model;

/**
 *
 * @author Daniel
 */
public class Colaborador{
    private Integer idColaborador;
    private String nomeColaborador;
    private String funcaoColaborador;
    private String loginColaborador;
    private String senhaColaborador;
    private String atorColaborador;
    private Receptor receptor;

    public Colaborador(Integer idColaborador, String nomeColaborador, String funcaoColaborador, String loginColaborador, String senhaColaborador, String atorColaborador, Receptor receptor) {
        this.idColaborador = idColaborador;
        this.nomeColaborador = nomeColaborador;
        this.funcaoColaborador = funcaoColaborador;
        this.loginColaborador = loginColaborador;
        this.senhaColaborador = senhaColaborador;
        this.atorColaborador = atorColaborador;
        this.receptor = receptor;
    }

    public Colaborador() {
    }

    /**
     * @return the idColaborador
     */
    public Integer getIdColaborador() {
        return idColaborador;
    }

    /**
     * @param idColaborador the idColaborador to set
     */
    public void setIdColaborador(Integer idColaborador) {
        this.idColaborador = idColaborador;
    }

    /**
     * @return the nomeColaborador
     */
    public String getNomeColaborador() {
        return nomeColaborador;
    }

    /**
     * @param nomeColaborador the nomeColaborador to set
     */
    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    /**
     * @return the funcaoColaborador
     */
    public String getFuncaoColaborador() {
        return funcaoColaborador;
    }

    /**
     * @param funcaoColaborador the funcaoColaborador to set
     */
    public void setFuncaoColaborador(String funcaoColaborador) {
        this.funcaoColaborador = funcaoColaborador;
    }

    /**
     * @return the loginColaborador
     */
    public String getLoginColaborador() {
        return loginColaborador;
    }

    /**
     * @param loginColaborador the loginColaborador to set
     */
    public void setLoginColaborador(String loginColaborador) {
        this.loginColaborador = loginColaborador;
    }

    /**
     * @return the senhaColaborador
     */
    public String getSenhaColaborador() {
        return senhaColaborador;
    }

    /**
     * @param senhaColaborador the senhaColaborador to set
     */
    public void setSenhaColaborador(String senhaColaborador) {
        this.senhaColaborador = senhaColaborador;
    }

    /**
     * @return the atorColaborador
     */
    public String getAtorColaborador() {
        return atorColaborador;
    }

    /**
     * @param atorColaborador the atorColaborador to set
     */
    public void setAtorColaborador(String atorColaborador) {
        this.atorColaborador = atorColaborador;
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
