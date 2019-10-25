/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.DAO;

import br.com.projetosiel.model.Beneficiario;
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
public class BeneficiarioDAOImpl implements GenericDAO{
    private Connection conn;
    public BeneficiarioDAOImpl() throws Exception{
        try{
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        }catch (Exception ex){
            throw new Exception("Problemas ao conectar no banco de dados! Erro: "+ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
       Beneficiario beneficiario = (Beneficiario) object;
        PreparedStatement stmt = null;
        String sql ="INSERT INTO beneficiario(id_pessoa, id_receptor) VALUES (?, ?) RETURNING id_beneficiario;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(2, beneficiario.getReceptor().getIdReceptor());
            try{
                PessoaDAOImpl daoPessoa = new PessoaDAOImpl();
                stmt.setInt(1, daoPessoa.cadastrar(beneficiario));
                 }catch (Exception ex){
                System.out.println("Problemas na DAO ao cadastrar Beneficiário! Erro: "+ex.getMessage());
                ex.printStackTrace();
            }
            stmt.execute();
            return true;       
        }catch(SQLException ex){
            System.out.println("Problemas na DAO ao cadastrar Beneficiario! Erro: "+ex.getMessage());
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
       
       
            String sql="select p.*, b.* "
               + "from pessoa p, beneficiario b "
               + "where p.id_pessoa = b.id_pessoa;";
       
       try{
           stmt = conn.prepareStatement(sql);
           rs = stmt.executeQuery();
           while(rs.next()){
               Beneficiario beneficiario = new Beneficiario();
              beneficiario.setIdPessoa(rs.getInt("id_pessoa"));
              beneficiario.setIdBeneficiario(rs.getInt("id_beneficiario"));
              beneficiario.setNomeRazaoPessoa(rs.getString("nome_razao_pessoa"));
              beneficiario.setCpfCnpjPessoa(rs.getString("cpf_cnpj_pessoa"));
              beneficiario.setRgIePessoa(rs.getString("rg_ie_pessoa"));
              beneficiario.setTelefonePessoa(rs.getString("telefone_pessoa"));
              beneficiario.setRuaPessoa(rs.getString("rua_pessoa"));
              beneficiario.setNumeroPessoa(rs.getInt("numero_pessoa"));
              beneficiario.setComplementoPessoa(rs.getString("complemento_pessoa"));
              beneficiario.setBairroPessoa(rs.getString("bairro_pessoa"));
              beneficiario.setCidadePessoa(rs.getString("cidade_pessoa"));
              beneficiario.setEstadoPessoa(rs.getString("estado_pessoa"));
              beneficiario.setCepPessoa(rs.getString("cep_pessoa"));
              beneficiario.setEmailPessoa(rs.getString("email_pessoa"));
              beneficiario.setLoginPessoa(rs.getString("login_pessoa"));
              beneficiario.setSenhaPessoa(rs.getString("senha_pessoa"));
               
               resultado.add(beneficiario);
           }
       }catch (SQLException ex){
           System.out.println("Problemas ao listar Beneficiario! Erro: "+ex.getMessage());
           ex.printStackTrace();
       }finally{
           try{
               ConnectionFactory.closeConnection(conn, stmt, rs);
           }catch(Exception ex){
               System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: "+ex.getMessage());
               ex.printStackTrace();
           }
       }
       return resultado;
       
    }


    @Override
    public void excluir(int idObject) {
        PreparedStatement stmt = null;
        String sql="Delete from beneficiario where id_pessoa= ?;"
                +"commit; Delete from pessoa where id_pessoa= ?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.setInt(2, idObject);
            stmt.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Problemas ao excluir Beneficiário! Erro: "+ex.getMessage());
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
      Beneficiario beneficiario = null;
      String sql = "select p.* from pessoa p, beneficiario b where p.id_pessoa = b.id_pessoa and b.id_pessoa = ?;";
       try{
          stmt = conn.prepareStatement(sql);
          stmt.setInt(1, idObject);
          rs = stmt.executeQuery();
          while (rs.next()){
              beneficiario = new Beneficiario();
              beneficiario.setIdPessoa(rs.getInt("id_pessoa"));

              beneficiario.setNomeRazaoPessoa(rs.getString("nome_razao_pessoa"));
              beneficiario.setCpfCnpjPessoa(rs.getString("cpf_cnpj_pessoa"));
              beneficiario.setRgIePessoa(rs.getString("rg_ie_pessoa"));
              beneficiario.setTelefonePessoa(rs.getString("telefone_pessoa"));
              beneficiario.setRuaPessoa(rs.getString("rua_pessoa"));
              beneficiario.setNumeroPessoa(rs.getInt("numero_pessoa"));
              beneficiario.setComplementoPessoa(rs.getString("complemento_pessoa"));
              beneficiario.setBairroPessoa(rs.getString("bairro_pessoa"));
              beneficiario.setCidadePessoa(rs.getString("cidade_pessoa"));
              beneficiario.setEstadoPessoa(rs.getString("estado_pessoa"));
              beneficiario.setCepPessoa(rs.getString("cep_pessoa"));
              beneficiario.setEmailPessoa(rs.getString("email_pessoa"));
              beneficiario.setLoginPessoa(rs.getString("login_pessoa"));
              beneficiario.setSenhaPessoa(rs.getString("senha_pessoa"));

          } 
      }catch (SQLException ex){
          System.out.println("Problemas ao carregar dados Beneficiario! Erro: "+ex.getMessage());
          ex.printStackTrace();
      }finally{
          try{
              ConnectionFactory.closeConnection(conn, stmt, rs);
          }catch (Exception ex){
              System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: "+ex.getMessage());
              ex.printStackTrace();
          }
          return beneficiario;
      }
    }

    @Override
    public Boolean alterar(Object object) {
        Beneficiario beneficiario = (Beneficiario) object;
        PreparedStatement stmt = null;
            try{
                PessoaDAOImpl daoPessoa = new PessoaDAOImpl();
                if(daoPessoa.alterarPessoa(beneficiario)){
              
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
    
     public Integer retornarIdBeneficiarioPeloIdPessoa(Integer idPessoa){
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer idBeneficiario = null;
        
        String sql = "select b.id_beneficiario from beneficiario b, pessoa p where p.id_pessoa = b.id_pessoa and b.id_pessoa = ?;";
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPessoa);
            
            rs = stmt.executeQuery();
            
            while (rs.next()){
                idBeneficiario = rs.getInt("id_beneficiario");
            }
        } catch (SQLException ex){
            System.out.println("Problemas ao trazer o id do Beneficiario! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try{
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex){
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        
        return idBeneficiario;
        
    }

    @Override
    public List<Object> consultar(String descricao) {
       PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> resultadoConsulta = new ArrayList<Object>();
        String sql = "select p.* from pessoa p, beneficiario b where p.id_pessoa = b.id_pessoa and b.id_pessoa = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, descricao + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                 Beneficiario beneficiario = new Beneficiario();
               beneficiario.setIdPessoa(rs.getInt("id_pessoa"));
               beneficiario.setIdBeneficiario(rs.getInt("id_beneficiario"));
               beneficiario.setNomeRazaoPessoa(rs.getString("nome_razao_pessoa"));
               beneficiario.setCpfCnpjPessoa(rs.getString("cpf_cnpj_pessoa"));
               beneficiario.setRgIePessoa(rs.getString("rg_ie_pessoa"));
               beneficiario.setTelefonePessoa(rs.getString("telefone_pessoa"));
               beneficiario.setRuaPessoa("rua_pessoa");
               beneficiario.setBairroPessoa("bairro_pessoa");
               beneficiario.setComplementoPessoa("complemento_pessoa");
               beneficiario.setCidadePessoa("cidade_pessoa");
               beneficiario.setEstadoPessoa("estado_pessoa");
               beneficiario.setCepPessoa("cep_pessoa");
               beneficiario.setEmailPessoa(rs.getString("email_pessoa"));
               beneficiario.setLoginPessoa(rs.getString("login_pessoa"));
               beneficiario.setSenhaPessoa(rs.getString("senha_pessoa"));
                resultadoConsulta.add(beneficiario);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao consultar Beneficiario! Erro: " + ex.getMessage());
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
}
    
            
    
    

