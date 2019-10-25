/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.DAO;

import br.com.projetosiel.model.ListaPeca;
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
public class ListaPecaDAOImpl implements GenericDAO {

    private Connection conn;

    public ListaPecaDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar no banco de dados! Erro: " + ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        ListaPeca listaPeca = (ListaPeca) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO lista_peca (nome_lista_peca, id_lista_equipamento) VALUES (?, ?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, listaPeca.getNomeListaPeca());
            stmt.setInt(2, listaPeca.getListaEquipamento().getIdListaEquipamento());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas no SQL ao cadastrar ListaPeça! Erro: " + ex.getMessage());
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

    public List<Object> listarListaPeca(Integer idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> resultado = new ArrayList<Object>();
        String sql = "select lp.*, le.id_lista_equipamento from lista_peca lp, lista_equipamento le "
                + "where lp.id_lista_equipamento = le.id_lista_equipamento and "
                + "le.id_lista_equipamento = ? order by lp.nome_lista_peca;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                ListaPeca listaPeca = new ListaPeca();
                listaPeca.setIdListaPeca(rs.getInt("id_lista_peca"));
                listaPeca.setNomeListaPeca(rs.getString("nome_lista_peca"));
                resultado.add(listaPeca);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar ListaPeca! Erro: " + ex.getMessage());
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

        String sql = "Delete from lista_peca where id_lista_peca=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir Lista Peça! Erro: " + ex.getMessage());
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
    
    public void excluirPorEquipamento(int idEquipamento) {
         PreparedStatement stmt = null;

        String sql = "Delete from lista_peca where id_lista_equipamento=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idEquipamento);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir Lista Peça do equipamento " + idEquipamento + " Erro: " + ex.getMessage());
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
    public List<Object> listar() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> resultado = new ArrayList<Object>();
        String sql = "select lp.* from lista_peca lp order by lp.nome_lista_peca;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                ListaPeca listaPeca = new ListaPeca();
                listaPeca.setIdListaPeca(rs.getInt("id_lista_peca"));
                listaPeca.setNomeListaPeca(rs.getString("nome_lista_peca"));
                resultado.add(listaPeca);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar ListaPeça! Erro: " + ex.getMessage());
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
    public List<Object> consultar(String descricao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
