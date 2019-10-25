/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.DAO;

import br.com.projetosiel.model.Equipamento;
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
public class EquipamentoDAOImpl implements GenericDAO{
     private Connection conn;
    public EquipamentoDAOImpl() throws Exception{
        try{
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        }catch (Exception ex){
            throw new Exception("Problemas ao conectar no banco de dados! Erro: "+ex.getMessage());
        }
    }

    public Integer cadastrarEquipamento(Object object) {
        Equipamento equipamento = (Equipamento)object;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer codigoEquipamento = null;
        
        String sql ="INSERT INTO equipamento (nome_equipamento, tipo_equipamento, status_equipamento,"
                + " estado_equipamento, numerocontrole_coleta, id_categoria) VALUES (?, ?, ?, ?, ?, ?) RETURNING codigo_equipamento;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, equipamento.getNomeEquipamento());
            stmt.setString(2, equipamento.getTipoEquipamento());
            stmt.setString(3, equipamento.getStatusEquipamento());
            stmt.setString (4, equipamento.getEstadoEquipamento());
            stmt.setInt(5, equipamento.getColeta().getNumeroControleColeta());
            stmt.setInt(6, equipamento.getCategoria().getIdCategoria());
           
            rs = stmt.executeQuery();
            
             while (rs.next()){
                codigoEquipamento = rs.getInt("codigo_equipamento");
            }
            } catch (SQLException ex) {
            System.out.println("Problemas na DAO ao cadastrar Equipamento! Erro: " + ex.getMessage());
            ex.printStackTrace();            
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        
        return codigoEquipamento;

    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<Object>();
       PreparedStatement stmt = null;
       ResultSet rs = null;     
       
            String sql="select * from equipamento;";
       
       try{
           stmt = conn.prepareStatement(sql);
           rs = stmt.executeQuery();
           while(rs.next()){
               Equipamento equipamento = new Equipamento();
               equipamento.setNomeEquipamento(rs.getString("nome_equipamento"));
               equipamento.setTipoEquipamento(rs.getString("tipo_equipamento"));
               equipamento.setStatusEquipamento(rs.getString("status_equipamento"));
               equipamento.setEstadoEquipamento(rs.getString("estado_equipamento"));
               equipamento.setCodigoEquipamento(rs.getInt("codigo_equipamento"));
              
               resultado.add(equipamento);
           }
       }catch (SQLException ex){
           System.out.println("Problemas ao listar Equipamento! Erro: "+ex.getMessage());
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
        String sql="Delete from equipamento WHERE codigo_equipamento = ?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Problemas ao excluir Equipamento! Erro: "+ex.getMessage());
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
      Equipamento equipamento = null;
      String sql = "select * from equipamento where codigo_equipamento = ?;";
       try{
          stmt = conn.prepareStatement(sql);
          stmt.setInt(1, idObject);
          rs = stmt.executeQuery();
          while (rs.next()){
             equipamento = new Equipamento();
              equipamento.setNomeEquipamento(rs.getString("nome_equipamento"));
              equipamento.setTipoEquipamento(rs.getString("tipo_equipamento"));
              equipamento.setStatusEquipamento(rs.getString("status_equipamento"));
              equipamento.setEstadoEquipamento(rs.getString("estado_equipamento"));
              equipamento.setCodigoEquipamento(rs.getInt("codigo_equipamento"));
          } 
      }catch (SQLException ex){
          System.out.println("Problemas ao carregar dados Equipamento! Erro: "+ex.getMessage());
          ex.printStackTrace();
      }finally{
          try{
              ConnectionFactory.closeConnection(conn, stmt, rs);
          }catch (Exception ex){
              System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: "+ex.getMessage());
              ex.printStackTrace();
          }
          return equipamento;
      }
    }

    @Override
    public Boolean alterar(Object object) {
         Equipamento equipamento = (Equipamento) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE equipamento SET nome_equipamento=? WHERE codigo_equipamento=?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, equipamento.getNomeEquipamento());
            stmt.setInt(2, equipamento.getCodigoEquipamento());
           
            stmt.executeUpdate();
            return true;
        }catch (SQLException ex){
            System.out.println("Problemas ao alterar o Equipamento! Erro: "+ex.getMessage());
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean cadastrar(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
            
}
