/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.DAO;

import br.com.projetosiel.model.Receptor;
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
public class ReceptorDAOImpl implements GenericDAO {

    private Connection conn;

    public ReceptorDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar no banco de dados! Erro: " + ex.getMessage());
        }
    }

    public Integer cadastrarReceptor(Object object) {
        Receptor receptor = (Receptor) object;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer idReceptor = null;

        String sql = "INSERT INTO receptor(id_pessoa, site_receptor, id_tipo_coleta) VALUES (?, ?, ?) RETURNING id_receptor;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(2, receptor.getSiteReceptor());
            stmt.setInt(3, receptor.getTipoColeta().getIdTipoColeta());
            try {
                PessoaDAOImpl daoPessoa = new PessoaDAOImpl();
                stmt.setInt(1, daoPessoa.cadastrar(receptor));
            } catch (Exception ex) {
                System.out.println("Problemas na DAO ao cadastrar Pessoa! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
            rs = stmt.executeQuery();

            while (rs.next()) {
                idReceptor = rs.getInt("id_receptor");
            }

        } catch (SQLException ex) {
            System.out.println("Problemas na DAO ao cadastrar Receptor! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        return idReceptor;

    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<Object>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select p.*, r.* "
                + "from pessoa p, receptor r "
                + "where p.id_pessoa = r.id_pessoa;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Receptor receptor = new Receptor();
                receptor.setIdPessoa(rs.getInt("id_pessoa"));
                receptor.setIdReceptor(rs.getInt("id_receptor"));
                receptor.setNomeRazaoPessoa(rs.getString("nome_razao_pessoa"));
                receptor.setCpfCnpjPessoa(rs.getString("cpf_cnpj_pessoa"));
                receptor.setRgIePessoa(rs.getString("rg_ie_pessoa"));
                receptor.setEmailPessoa(rs.getString("email_pessoa"));
                receptor.setSiteReceptor(rs.getString("site_receptor"));
                receptor.setLoginPessoa(rs.getString("login_pessoa"));

                resultado.add(receptor);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Receptor! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return resultado;

    }

    @Override
    public void excluir(int idObject) {
        PreparedStatement stmt = null;

        String sql = "Delete from receptor where id_pessoa= ?;"
                + "commit; Delete from pessoa where id_pessoa= ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.setInt(2, idObject);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir receptor! Erro: " + ex.getMessage());
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
        Receptor receptor = null;
        String sql = "select * from pessoa p, receptor r where p.id_pessoa = r.id_pessoa and r.id_pessoa = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                receptor = new Receptor();
                receptor.setIdPessoa(rs.getInt("id_pessoa"));
                receptor.setTipoPessoa(rs.getString("tipo_pessoa"));
                receptor.setIdReceptor(rs.getInt("id_receptor"));
                receptor.setNomeRazaoPessoa(rs.getString("nome_razao_pessoa"));
                receptor.setCpfCnpjPessoa(rs.getString("cpf_cnpj_pessoa"));
                receptor.setRgIePessoa(rs.getString("rg_ie_pessoa"));
                receptor.setTelefonePessoa(rs.getString("telefone_pessoa"));
                receptor.setRuaPessoa(rs.getString("rua_pessoa"));
                receptor.setNumeroPessoa(rs.getInt("numero_pessoa"));
                receptor.setComplementoPessoa(rs.getString("complemento_pessoa"));
                receptor.setBairroPessoa(rs.getString("bairro_pessoa"));
                receptor.setCidadePessoa(rs.getString("cidade_pessoa"));
                receptor.setEstadoPessoa(rs.getString("estado_pessoa"));
                receptor.setCepPessoa(rs.getString("cep_pessoa"));
                receptor.setEmailPessoa(rs.getString("email_pessoa"));
                receptor.setSiteReceptor(rs.getString("site_receptor"));
                receptor.setLoginPessoa(rs.getString("login_pessoa"));
                receptor.setSenhaPessoa(rs.getString("senha_pessoa"));

            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar dados Receptor! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
            return receptor;
        }
    }

    @Override
    public Boolean alterar(Object object) {
        Receptor receptor = (Receptor) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE receptor SET site_receptor=? WHERE id_pessoa=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, receptor.getSiteReceptor());
            try {
                PessoaDAOImpl daoPessoa = new PessoaDAOImpl();
                if (daoPessoa.alterarPessoa(receptor)) {
                    stmt.executeUpdate();
                    return true;
                } else {
                    return false;
                }
            } catch (Exception ex) {
                System.out.println("Problemas ao cadastrar Pessoa! Erro: " + ex.getMessage());
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar o Receptor! Erro: " + ex.getMessage());
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

    public Integer retornarIdReceptorPeloIdPessoa(Integer idPessoa) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer idReceptor = null;

        String sql = "select r.id_receptor from receptor r, pessoa p where p.id_pessoa = r.id_pessoa and r.id_pessoa = ?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPessoa);

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

    @Override
    public Boolean cadastrar(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Object> consultar(String descricao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Integer listarQuantidadeColetasEspera(Integer id) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        Integer quantidade = null;

        String sql = "select count(c.numerocontrole_coleta) as quantidade from coleta c, pessoa p, receptor r "
                + "where c.id_receptor = r.id_receptor and r.id_pessoa = p.id_pessoa "
                + "and p.id_pessoa = ? and status_coleta = ?;";

        try {
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, "espera");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                quantidade = rs.getInt("quantidade");
            }
            
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar a quantidade de coletas em Espera! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        
        return quantidade;

    }
}
