/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.DAO;

import br.com.projetosiel.model.Colaborador;
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
public class ColaboradorDAOImpl implements GenericDAO {

    private Connection conn;

    public ColaboradorDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar no banco de dados! Erro: " + ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Colaborador colaborador = (Colaborador) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO colaborador(nome_colaborador, funcao_colaborador, login_colaborador, senha_colaborador, id_receptor, ator_colaborador) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, colaborador.getNomeColaborador());
            stmt.setString(2, colaborador.getFuncaoColaborador());
            stmt.setString(3, colaborador.getLoginColaborador());
            stmt.setString(4, colaborador.getSenhaColaborador());
            stmt.setInt(5, colaborador.getReceptor().getIdReceptor());
            stmt.setString(6, colaborador.getAtorColaborador());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas no SQL ao cadastrar Colaborador! Erro: " + ex.getMessage());
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
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> resultado = new ArrayList<Object>();
        String sql = "select c.* from colaborador c order by c.nome_colaborador;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Colaborador colaborador = new Colaborador();
                colaborador.setIdColaborador(rs.getInt("id_colaborador"));
                colaborador.setNomeColaborador(rs.getString("nome_colaborador"));
                colaborador.setFuncaoColaborador(rs.getString("funcao_colaborador"));
                colaborador.setLoginColaborador(rs.getString("login_colaborador"));
                colaborador.setSenhaColaborador(rs.getString("senha_colaborador"));
                resultado.add(colaborador);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar colaborador! Erro: " + ex.getMessage());
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

        String sql = "Delete from colaborador where id_colaborador=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir colaborador! Erro: " + ex.getMessage());
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
        String sql = "select c.* from colaborador c where c.id_colaborador=?;";
        Colaborador colaborador = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                colaborador = new Colaborador();
                colaborador.setIdColaborador(rs.getInt("id_colaborador"));
                colaborador.setNomeColaborador(rs.getString("nome_colaborador"));
                colaborador.setFuncaoColaborador(rs.getString("funcao_colaborador"));
                colaborador.setLoginColaborador(rs.getString("login_colaborador"));
                colaborador.setSenhaColaborador(rs.getString("senha_colaborador"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar dados Colaborador! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
            return colaborador;
        }
    }

    @Override
    public Boolean alterar(Object object) {
        Colaborador colaborador = (Colaborador) object;
        PreparedStatement stmt = null;
        String sql = "update colaborador set nome_colaborador=?, funcao_colaborador=?, "
                + "login_colaborador=?, senha_colaborador=? where id_colaborador=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, colaborador.getNomeColaborador());
            stmt.setString(2, colaborador.getFuncaoColaborador());
            stmt.setString(3, colaborador.getLoginColaborador());
            stmt.setString(4, colaborador.getSenhaColaborador());
            stmt.setInt(5, colaborador.getIdColaborador());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar o Colaborador! Erro: " + ex.getMessage());
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

    public Colaborador verificarColaborador(String login, String senha) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select c.* from colaborador c where c.login_colaborador = ? and c.senha_colaborador = ?;";

        Colaborador colaborador = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            while (rs.next()) {
                colaborador = new Colaborador();
                colaborador.setIdColaborador(rs.getInt("id_colaborador"));
                colaborador.setNomeColaborador(rs.getString("nome_colaborador"));
                colaborador.setAtorColaborador(rs.getString("ator_colaborador"));

            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao logar Colaborador! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        return colaborador;

    }

    @Override
    public List<Object> consultar(String descricao) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> resultadoConsulta = new ArrayList<Object>();
        String sql = "select c.* from colaborador c where nome_colaborador like ? order by c.nome_colaborador;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, descricao + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Colaborador colaborador = new Colaborador();
                colaborador.setIdColaborador(rs.getInt("id_colaborador"));
                colaborador.setNomeColaborador(rs.getString("nome_colaborador"));
                colaborador.setFuncaoColaborador(rs.getString("funcao_colaborador"));
                colaborador.setLoginColaborador(rs.getString("login_colaborador"));
                colaborador.setSenhaColaborador(rs.getString("senha_colaborador"));
                resultadoConsulta.add(colaborador);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao consultar colaborador! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
            }
        }
        return resultadoConsulta;
    }
    
     public Integer retornarIdReceptorPeloIdColaborador(Integer idColaborador) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer idReceptor = null;

        String sql = "select c.id_receptor from colaborador c where c.id_colaborador = ?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idColaborador);

            rs = stmt.executeQuery();

            while (rs.next()) {
                idReceptor = rs.getInt("id_receptor");
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao trazer o id do Receptor! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        return idReceptor;

    }

}

