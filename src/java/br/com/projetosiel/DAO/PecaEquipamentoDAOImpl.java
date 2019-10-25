/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.DAO;

import br.com.projetosiel.model.PecaEquipamento;
import br.com.projetosiel.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class PecaEquipamentoDAOImpl implements GenericDAO{
     private Connection conn;

    public PecaEquipamentoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar no banco de dados! Erro: " + ex.getMessage());
        }
    }


    @Override
    public Boolean cadastrar(Object object) {
         PecaEquipamento pecaEquipamento = (PecaEquipamento) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO peca_equipamento (codigo_equipamento, codigo_peca) VALUES (?,?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pecaEquipamento.getEquipamento().getCodigoEquipamento());
            stmt.setInt(2, pecaEquipamento.getPeca().getCodigoPeca());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas no SQL ao cadastrar PecaEquipamento! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }

        }
    }

    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(int idObject) {
         PreparedStatement stmt = null;

        String sql = "Delete from peca_equipamento where codigo_peca=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir PecaEquipamento! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Object carregar(Integer idObject) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Object> consultar(String descricao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
