/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.DAO;

import java.util.List;

/**
 *
 * @author Daniel
 */
public interface GenericDAO {
   public Boolean cadastrar(Object object);
   public List<Object> listar();
   public void excluir(int idObject);
   public Object carregar(Integer idObject);
   public Boolean alterar(Object object);
   public List<Object> consultar(String descricao);
}
