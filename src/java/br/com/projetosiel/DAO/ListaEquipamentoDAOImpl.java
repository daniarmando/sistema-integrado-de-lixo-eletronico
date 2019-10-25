/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.DAO;

import br.com.projetosiel.model.ListaEquipamento;
import br.com.projetosiel.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class ListaEquipamentoDAOImpl implements GenericDAO {

    private Connection conn;

    public ListaEquipamentoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar no banco de dados! Erro: " + ex.getMessage());
        }
    }

    public Integer cadastrarListaEquipamento(Object object) {
        ListaEquipamento listaEquipamento = (ListaEquipamento) object;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer idListaEquipamento = null;

        String sql = "INSERT INTO lista_equipamento(nome_lista_equipamento, id_receptor) VALUES (?, ?) RETURNING id_lista_equipamento;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, listaEquipamento.getNomeListaEquipamento());
            stmt.setInt(2, listaEquipamento.getReceptor().getIdReceptor());

            rs = stmt.executeQuery();

            while (rs.next()) {
                idListaEquipamento = rs.getInt("id_lista_equipamento");
            }

        } catch (SQLException ex) {
            System.out.println("Problemas na DAO ao cadastrar ListaEquipamento! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        return idListaEquipamento;

    }

    @Override
    public List<Object> listar() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> resultado = new ArrayList<Object>();
        String sql = "select le.* from lista_equipamento le order by le.nome_lista_equipamento;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                ListaEquipamento listaEquipamento = new ListaEquipamento();
                listaEquipamento.setIdListaEquipamento(rs.getInt("id_lista_equipamento"));
                listaEquipamento.setNomeListaEquipamento(rs.getString("nome_lista_equipamento"));
                resultado.add(listaEquipamento);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar ListaEquipamento! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
            }
        }
        return resultado;
    }

    @Override
    public void excluir(int idObject) {
        PreparedStatement stmt = null;

        String sql = "Delete from lista_equipamento where id_lista_equipamento=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir Lista Equipamento! Erro: " + ex.getMessage());
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
    public Boolean cadastrar(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Object> consultar(String descricao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
