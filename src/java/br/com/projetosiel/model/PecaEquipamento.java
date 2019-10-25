/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.model;

/**
 *
 * @author Daniel
 */
public class PecaEquipamento {
    private Integer idPecaEquipamento;
    private Equipamento equipamento;
    private Peca peca;

    public PecaEquipamento(Integer idPecaEquipamento, Equipamento equipamento, Peca peca) {
        this.idPecaEquipamento = idPecaEquipamento;
        this.equipamento = equipamento;
        this.peca = peca;
    }

    public PecaEquipamento() {
    }

    /**
     * @return the idPecaEquipamento
     */
    public Integer getIdPecaEquipamento() {
        return idPecaEquipamento;
    }

    /**
     * @param idPecaEquipamento the idPecaEquipamento to set
     */
    public void setIdPecaEquipamento(Integer idPecaEquipamento) {
        this.idPecaEquipamento = idPecaEquipamento;
    }

    /**
     * @return the equipamento
     */
    public Equipamento getEquipamento() {
        return equipamento;
    }

    /**
     * @param equipamento the equipamento to set
     */
    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    /**
     * @return the peca
     */
    public Peca getPeca() {
        return peca;
    }

    /**
     * @param peca the peca to set
     */
    public void setPeca(Peca peca) {
        this.peca = peca;
    }

   
}
