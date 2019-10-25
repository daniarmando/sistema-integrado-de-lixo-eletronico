/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.DAO;

import br.com.projetosiel.model.Solicitante;
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
public class SolicitanteDAOImpl implements GenericDAO {
    private Connection conn;
    public SolicitanteDAOImpl() throws Exception{
        try{
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        }catch (Exception ex){
            throw new Exception("Problemas ao conectar no banco de dados! Erro: "+ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Solicitante solicitante = (Solicitante) object;
        PreparedStatement stmt = null;
        String sql ="INSERT INTO solicitante(id_pessoa) VALUES (?) RETURNING id_solicitante;";
        try{
            stmt = conn.prepareStatement(sql);
            try{
                PessoaDAOImpl daoPessoa = new PessoaDAOImpl();
                stmt.setInt(1, daoPessoa.cadastrar(solicitante));
    }catch (Exception ex){
                System.out.println("Problemas na DAO ao cadastrar Pessoa! Erro: "+ex.getMessage());
                ex.printStackTrace();
            }
            stmt.execute();
            return true;       
        }catch(SQLException ex){
            System.out.println("Problemas na DAO ao cadastrar Solicitante! Erro: "+ex.getMessage());
            ex.printStackTrace();
            return false;
        }finally{
        try{
            ConnectionFactory.closeConnection(conn, stmt);
        }catch(Exception ex){
            System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: "+ex.getMessage());
            ex.printStackTrace();
}
    }
    
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<Object>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
            String sql="select p.*, s.* "
               + "from pessoa p, solicitante s "
               + "where p.id_pessoa = s.id_pessoa;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Solicitante solicitante = new Solicitante();
                solicitante.setIdPessoa(rs.getInt("id_pessoa"));
                solicitante.setTipoPessoa(rs.getString("tipo_pessoa"));
                solicitante.setNomeRazaoPessoa(rs.getString("nome_razao_pessoa"));
                solicitante.setCpfCnpjPessoa(rs.getString("cpf_cnpj_pessoa"));
                solicitante.setRgIePessoa(rs.getString("rg_ie_pessoa"));
                solicitante.setEmailPessoa(rs.getString("email_pessoa"));
                solicitante.setLoginPessoa(rs.getString("login_pessoa"));
                solicitante.setSenhaPessoa(rs.getString("senha_pessoa"));
                
                resultado.add(solicitante);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Solicitante! Erro: " + ex.getMessage());
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
        
        String sql="Delete from solicitante where id_pessoa= ?;"
                +"commit; Delete from pessoa where id_pessoa= ?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.setInt(2, idObject);
            stmt.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Problemas ao excluir solicitante! Erro: "+ex.getMessage());
            ex.printStackTrace();
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt);
            }catch (Exception ex){
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: "+ex.getMessage());
                ex.printStackTrace();
            }
        }
    }


    @Override
    public Object carregar(Integer idObject) {
      PreparedStatement stmt = null;
      ResultSet rs = null;
      Solicitante solicitante = null;
      String sql = "select p.* from pessoa p, solicitante s where p.id_pessoa = s.id_pessoa and s.id_pessoa = ?;";
      try{
          stmt = conn.prepareStatement(sql);
          stmt.setInt(1, idObject);
          rs = stmt.executeQuery();
          while (rs.next()){
              solicitante = new Solicitante();
              solicitante.setIdPessoa(rs.getInt("id_pessoa"));
              solicitante.setTipoPessoa(rs.getString("tipo_pessoa"));
              solicitante.setNomeRazaoPessoa(rs.getString("nome_razao_pessoa"));
              solicitante.setCpfCnpjPessoa(rs.getString("cpf_cnpj_pessoa"));
              solicitante.setRgIePessoa(rs.getString("rg_ie_pessoa"));
              solicitante.setTelefonePessoa(rs.getString("telefone_pessoa"));
              solicitante.setRuaPessoa(rs.getString("rua_pessoa"));
              solicitante.setNumeroPessoa(rs.getInt("numero_pessoa"));
              solicitante.setComplementoPessoa(rs.getString("complemento_pessoa"));
              solicitante.setBairroPessoa(rs.getString("bairro_pessoa"));
              solicitante.setCidadePessoa(rs.getString("cidade_pessoa"));
              solicitante.setEstadoPessoa(rs.getString("estado_pessoa"));
              solicitante.setCepPessoa(rs.getString("cep_pessoa"));
              solicitante.setEmailPessoa(rs.getString("email_pessoa"));
              solicitante.setLoginPessoa(rs.getString("login_pessoa"));
              solicitante.setSenhaPessoa(rs.getString("senha_pessoa"));
              

          } 
      }catch (SQLException ex){
          System.out.println("Problemas ao carregar dados Solicitante! Erro: "+ex.getMessage());
          ex.printStackTrace();
      }finally{
          try{
              ConnectionFactory.closeConnection(conn, stmt, rs);
          }catch (Exception ex){
              System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: "+ex.getMessage());
              ex.printStackTrace();
          }
          return solicitante;
      }
    }


    @Override
    public Boolean alterar(Object object) {
       Solicitante solicitante = (Solicitante) object;
        PreparedStatement stmt = null;
        
        try{
                PessoaDAOImpl daoPessoa = new PessoaDAOImpl();
                if(daoPessoa.alterarPessoa(solicitante)){
              
                return true;
        }else{
                    return false;
                }
            }catch (Exception ex){
                System.out.println("Problemas ao alterar Pessoa! Erro: "+ex.getMessage());
                return false;
           
        
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt);
            }catch (Exception ex){
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: "+ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
            
    
    public Integer retornarIdSolicitantePeloIdPessoa(Integer idPessoa){
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer idSolicitante = null;
        
        String sql = "select s.id_solicitante from solicitante s, pessoa p where p.id_pessoa = s.id_pessoa and s.id_pessoa = ?;";
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPessoa);
            
            rs = stmt.executeQuery();
            
            while (rs.next()){
                idSolicitante = rs.getInt("id_solicitante");
            }
        } catch (SQLException ex){
            System.out.println("Problemas ao trazer o id do Solicitante! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try{
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex){
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        
        return idSolicitante;
        
    }

    @Override
    public List<Object> consultar(String descricao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

    

