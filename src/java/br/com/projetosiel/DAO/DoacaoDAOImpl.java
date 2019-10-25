/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.DAO;

import br.com.projetosiel.model.Doacao;
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
public class DoacaoDAOImpl implements GenericDAO{
    private Connection conn;
    public DoacaoDAOImpl() throws Exception{
        try{
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        }catch (Exception ex){
            throw new Exception("Problemas ao conectar no banco de dados! Erro: "+ex.getMessage());
        }
    }

   @Override
    public Boolean cadastrar(Object object) {
       Doacao doacao = (Doacao) object;
        PreparedStatement stmt = null;
        String sql ="INSERT INTO doacao(descricao_doacao, datasolicitacao_docao, status_doacao, id_beneficiario) VALUES (?, ?, ?, ?);";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, doacao.getDescricaoDoacao());
            stmt.setDate(2, new java.sql.Date(doacao.getDataSolicitacaoDoacao().getTime()));
            stmt.setString(3, doacao.getStatusDoacao());
            stmt.setInt(4, doacao.getBeneficiario().getIdBeneficiario());
            
            stmt.execute();
            return true;       
        }catch(SQLException ex){
            System.out.println("Problemas na DAO ao cadastrar Doação! Erro: "+ex.getMessage());
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
       
            String sql="select d.* from doacao d order by d.numerocontrole_doacao;";
       try{
           stmt = conn.prepareStatement(sql);
           rs = stmt.executeQuery();
           while(rs.next()){
               Doacao doacao = new Doacao();
               doacao.setNumeroControleDoacao(rs.getInt("numerocontrole_doacao"));
               doacao.setDescricaoDoacao(rs.getString("descricao_doacao"));
               doacao.setDataSolicitacaoDoacao(rs.getDate("datasolicitacao_doacao"));
               doacao.setDataConclusaoDoacao(rs.getDate("dataconclusao_doacao"));
               doacao.setStatusDoacao(rs.getString("status_doacao"));
               
               resultado.add(doacao);
           }
       }catch (SQLException ex){
           System.out.println("Problemas ao listar Doação! Erro: "+ex.getMessage());
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
        String sql="Delete from doacao where numerocontrole_doacao= ?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Problemas ao excluir Doação! Erro: "+ex.getMessage());
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
      Doacao doacao = null;
      String sql = "select * from doacao;";
       try{
          stmt = conn.prepareStatement(sql);
          stmt.setInt(1, idObject);
          rs = stmt.executeQuery();
          while (rs.next()){
              doacao = new Doacao();
              doacao.setDescricaoDoacao(rs.getString("descricao_doacao"));
              doacao.setDataSolicitacaoDoacao(rs.getDate("datasolicitacao_doacao"));
              doacao.setDataConclusaoDoacao(rs.getDate("dataconclusao_doacao"));
              doacao.setStatusDoacao(rs.getString("status_doacao"));
          } 
      }catch (SQLException ex){
          System.out.println("Problemas ao carregar dados Doação! Erro: "+ex.getMessage());
          ex.printStackTrace();
      }finally{
          try{
              ConnectionFactory.closeConnection(conn, stmt, rs);
          }catch (Exception ex){
              System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: "+ex.getMessage());
              ex.printStackTrace();
          }
          return doacao;
      }
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
