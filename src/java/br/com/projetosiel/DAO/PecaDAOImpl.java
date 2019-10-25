/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.DAO;

import br.com.projetosiel.model.Coleta;
import br.com.projetosiel.model.Peca;
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
public class PecaDAOImpl implements GenericDAO {

    private Connection conn;

    public PecaDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar no banco de dados! Erro: " + ex.getMessage());
        }
    }
    
    public Integer cadastrarPeca(Object object) {
        Peca peca = (Peca) object;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Integer idPeca = null;

        String sql = "INSERT INTO peca (nome_peca, detalhe_peca, status_peca, numerocontrole_coleta) "
                + " VALUES (?, ?, ?, ?) returning codigo_peca;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, peca.getNomePeca());
            stmt.setString(2, peca.getDetalhePeca());
            stmt.setString(3, peca.getStatusPeca());
            stmt.setInt(4, peca.getColeta().getNumeroControleColeta());

            rs = stmt.executeQuery();

            if (rs.next()) {
                idPeca = rs.getInt("codigo_peca");
            }

        } catch (SQLException ex) {
            System.out.println("Problemas no SQL ao cadastrar Peça! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        
        return idPeca;
    }

    @Override
    public List<Object> listar() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> resultado = new ArrayList<Object>();
        String sql = "select p.* from peca p order by p.nome_peca;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Peca peca = new Peca();
                peca.setCodigoPeca(rs.getInt("codigo_peca"));
                peca.setNomePeca(rs.getString("nome_peca"));
                peca.setDetalhePeca(rs.getString("detalhe_peca"));
                peca.setStatusPeca(rs.getString("status_peca"));
                resultado.add(peca);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Peça! Erro: " + ex.getMessage());
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

        String sql = "Delete from peca where codigo_peca=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir Peca! Erro: " + ex.getMessage());
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
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select p.* from peca p where p.codigo_peca=?;";
        Peca peca = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                peca = new Peca();
                peca.setCodigoPeca(rs.getInt("codigo_peca"));
                peca.setNomePeca(rs.getString("nome_peca"));
                peca.setDetalhePeca(rs.getString("detalhe_peca"));
                peca.setStatusPeca(rs.getString("status_peca"));                
                ColetaDAOImpl daoColeta = new ColetaDAOImpl();
                peca.setColeta((Coleta) daoColeta.carregar(rs.getInt("numerocontrole_coleta")));                                
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar dados Peça! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
            return peca;
        }
    }

    @Override
    public Boolean alterar(Object object) {
        Peca peca = (Peca) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE peca SET nome_peca=?, detalhe_peca=?, status_peca=?, "
                + "WHERE codigo_peca=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, peca.getNomePeca());
            stmt.setString(2, peca.getDetalhePeca());
            stmt.setString(3, peca.getStatusPeca());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar a Peça! Erro: " + ex.getMessage());
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
    public List<Object> consultar(String descricao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean cadastrar(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
