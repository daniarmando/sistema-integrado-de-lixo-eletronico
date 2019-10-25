/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.DAO;

import br.com.projetosiel.model.PontoColeta;
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
public class PontoColetaDAOImpl implements GenericDAO{
    private Connection conn;
    public PontoColetaDAOImpl() throws Exception{
        try{
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        }catch (Exception ex){
            throw new Exception("Problemas ao conectar no banco de dados! Erro: "+ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
       PontoColeta pontoColeta = (PontoColeta)object;
        PreparedStatement stmt = null;
        String sql="INSERT INTO pontocoleta (nome_pontocoleta, telefone_pontocoleta, rua_pontocoleta, "
                + "numero_pontocoleta, bairro_pontocoleta, complemento_pontocoleta, "
                + "cidade_pontocoleta, estado_pontocoleta, cep_pontocoleta, id_receptor) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pontoColeta.getNomePontoColeta());
            stmt.setString(2, pontoColeta.getTelefonePontoColeta());
            stmt.setString(3, pontoColeta.getRuaPontoColeta());
            stmt.setInt(4, pontoColeta.getNumeroPontoColeta());
            stmt.setString(5, pontoColeta.getBairroPontoColeta());
            stmt.setString(6, pontoColeta.getComplementoPontoColeta());
            stmt.setString(7, pontoColeta.getCidadePontoColeta());
            stmt.setString(8, pontoColeta.getEstadoPontoColeta());
            stmt.setString(9, pontoColeta.getCepPontoColeta());
            stmt.setInt(10, pontoColeta.getReceptor().getIdReceptor());
            stmt.execute();
            return true;
    }catch(SQLException ex){
            System.out.println("Problemas no SQL ao cadastrar PontoColeta! Erro: "+ex.getMessage());
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
        PreparedStatement stmt = null;
       ResultSet rs = null;
       List<Object> resultado = new ArrayList<Object>();
       String sql="select pc.* from pontocoleta pc order by pc.nome_pontocoleta;";
       try{
           stmt = conn.prepareStatement(sql);
           rs = stmt.executeQuery();
           while(rs.next()){
               PontoColeta pontoColeta = new PontoColeta();
               pontoColeta.setIdPontoColeta(rs.getInt("id_pontocoleta"));
               pontoColeta.setNomePontoColeta(rs.getString("nome_pontocoleta"));
               pontoColeta.setTelefonePontoColeta(rs.getString("telefone_pontocoleta"));
               pontoColeta.setRuaPontoColeta(rs.getString("rua_pontocoleta"));
               pontoColeta.setNumeroPontoColeta(rs.getInt("numero_pontocoleta"));
               pontoColeta.setComplementoPontoColeta(rs.getString("complemento_pontocoleta"));
               pontoColeta.setBairroPontoColeta(rs.getString("bairro_pontocoleta"));
               pontoColeta.setCidadePontoColeta(rs.getString("cidade_pontocoleta"));
               pontoColeta.setEstadoPontoColeta(rs.getString("estado_pontocoleta"));
               pontoColeta.setCepPontoColeta(rs.getString("cep_pontocoleta"));
               resultado.add(pontoColeta);
           }
       }catch (SQLException ex){
           System.out.println("Problemas ao listar PontoColeta! Erro: "+ex.getMessage());
           ex.printStackTrace();
       }finally{
           try{
               ConnectionFactory.closeConnection(conn, stmt, rs);
           }catch (Exception ex){
               System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: "+ex.getMessage());
           }
       }
       return resultado;
}

    @Override
    public void excluir(int idObject) {
        PreparedStatement stmt = null;
        
        String sql="Delete from pontocoleta where id_pontocoleta=?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Problemas ao excluir PontoColeta! Erro: "+ex.getMessage());
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
      String sql = "select pc.* from pontocoleta pc where pc.id_pontocoleta=?;";
      PontoColeta pontoColeta = null;
      try{
          stmt = conn.prepareStatement(sql);
          stmt.setInt(1, idObject);
          rs = stmt.executeQuery();
          while (rs.next()){
              pontoColeta = new PontoColeta();
              pontoColeta.setIdPontoColeta(rs.getInt("id_pontocoleta"));
              pontoColeta.setNomePontoColeta(rs.getString("nome_pontocoleta"));
              pontoColeta.setTelefonePontoColeta(rs.getString("telefone_pontocoleta"));
              pontoColeta.setRuaPontoColeta(rs.getString("rua_pontocoleta"));
              pontoColeta.setNumeroPontoColeta(rs.getInt("numero_pontocoleta"));
              pontoColeta.setComplementoPontoColeta(rs.getString("complemento_pontocoleta"));
              pontoColeta.setBairroPontoColeta(rs.getString("bairro_pontocoleta"));
              pontoColeta.setCidadePontoColeta(rs.getString("cidade_pontocoleta"));
              pontoColeta.setEstadoPontoColeta(rs.getString("estado_pontocoleta"));
              pontoColeta.setCepPontoColeta(rs.getString("cep_pontocoleta"));
          } 
      }catch (SQLException ex){
          System.out.println("Problemas ao carregar dados PontoColeta! Erro: "+ex.getMessage());
          ex.printStackTrace();
      }finally{
          try{
              ConnectionFactory.closeConnection(conn, stmt, rs);
          }catch (Exception ex){
              System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: "+ex.getMessage());
              ex.printStackTrace();
          }
          return pontoColeta;
      }
    }


    @Override
    public Boolean alterar(Object object) {
        PontoColeta pontoColeta = (PontoColeta) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE pontocoleta SET nome_pontocoleta=?, telefone_pontocoleta=?,"
                + " rua_pontocoleta=?, numero_pontocoleta=?, bairro_pontocoleta=?, "
                + "complemento_pontocoleta=?, cidade_pontocoleta=?, estado_pontocoleta=?, "
                + "cep_pontocoleta=? where id_pontocoleta=?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pontoColeta.getNomePontoColeta());
            stmt.setString(2, pontoColeta.getTelefonePontoColeta());
            stmt.setString(3, pontoColeta.getRuaPontoColeta());
            stmt.setInt(4, pontoColeta.getNumeroPontoColeta());
            stmt.setString(5, pontoColeta.getBairroPontoColeta());
            stmt.setString(6, pontoColeta.getComplementoPontoColeta());
            stmt.setString(7, pontoColeta.getCidadePontoColeta());
            stmt.setString(8, pontoColeta.getEstadoPontoColeta());
            stmt.setString(9, pontoColeta.getCepPontoColeta());
            stmt.setInt(10, pontoColeta.getIdPontoColeta());
            stmt.executeUpdate();
            return true;
        }catch (SQLException ex){
            System.out.println("Problemas ao alterar o PontoColeta! Erro: "+ex.getMessage());
            ex.printStackTrace();
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

    @Override
    public List<Object> consultar(String descricao) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> resultadoConsulta = new ArrayList<Object>();
        String sql = "select pc.* from pontocoleta pc where nome_pontocoleta like ? order by pc.nome_pontocoleta;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, descricao + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                PontoColeta pontoColeta = new PontoColeta();
                pontoColeta.setIdPontoColeta(rs.getInt("id_pontocoleta"));
                pontoColeta.setNomePontoColeta(rs.getString("nome_pontocoleta"));
                pontoColeta.setTelefonePontoColeta(rs.getString("telefone_pontocoleta"));
                pontoColeta.setRuaPontoColeta(rs.getString("rua_pontocoleta"));
                pontoColeta.setNumeroPontoColeta(rs.getInt("numero_pontocoleta"));
                pontoColeta.setComplementoPontoColeta(rs.getString("complemento_pontocoleta"));
                pontoColeta.setBairroPontoColeta(rs.getString("bairro_pontocoleta"));
                pontoColeta.setCidadePontoColeta(rs.getString("cidade_pontocoleta"));
                pontoColeta.setEstadoPontoColeta(rs.getString("estado_pontocoleta"));
                pontoColeta.setCepPontoColeta(rs.getString("cep_pontocoleta"));
                resultadoConsulta.add(pontoColeta);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao consultar PontoColeta! Erro: " + ex.getMessage());
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

