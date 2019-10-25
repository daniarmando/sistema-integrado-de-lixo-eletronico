/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.DAO;

import br.com.projetosiel.model.Coleta;
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
public class ColetaDAOImpl implements GenericDAO{
     private Connection conn;
    public ColetaDAOImpl() throws Exception{
        try{
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        }catch (Exception ex){
            throw new Exception("Problemas ao conectar no banco de dados! Erro: "+ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Coleta coleta = (Coleta)object;
        PreparedStatement stmt = null;
        String sql="INSERT INTO coleta (descricao_coleta, status_coleta, "
                + "datasolicitacao_coleta, id_tipo_coleta, "
                + "id_solicitante, id_receptor, id_pontocoleta, nome_solicitante_coleta) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, coleta.getDescricaoColeta());
            stmt.setString(2, coleta.getStatusColeta());
            stmt.setDate(3, new java.sql.Date(coleta.getDataSolicitacaoColeta().getTime()));
            stmt.setInt(4, coleta.getTipoColeta().getIdTipoColeta());
            stmt.setInt(5, coleta.getSolicitante().getIdSolicitante());
            stmt.setInt(6, coleta.getReceptor().getIdReceptor());
            stmt.setInt(7, coleta.getPontoColeta().getIdPontoColeta());
            stmt.setString(8, coleta.getNomeSolicitanteColeta());
            stmt.execute(); 
            return true;
    }catch(SQLException ex){
            System.out.println("Problemas no SQL ao cadastrar Coleta! Erro: "+ex.getMessage());
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
        String sql = "select c.* from coleta c order by c.numerocontrole_coleta;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Coleta coleta = new Coleta();
                coleta.setNumeroControleColeta(rs.getInt("numerocontrole_coleta"));
                coleta.setDescricaoColeta(rs.getString("descricao_coleta"));
                coleta.setStatusColeta(rs.getString("status_coleta"));
                coleta.setDataSolicitacaoColeta(rs.getDate("datasolicitacao_coleta"));
                coleta.setDataConclusaoColeta(rs.getDate("dataconclusao_coleta"));
                coleta.setNomeSolicitanteColeta(rs.getString("nome_solicitante_coleta"));
                resultado.add(coleta);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar coleta! Erro: " + ex.getMessage());
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object carregar(Integer idObject) {
     PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select c.* from coleta c where c.numerocontrole_coleta=?;";
        Coleta coleta = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                coleta = new Coleta();
                coleta.setNumeroControleColeta(rs.getInt("numerocontrole_coleta"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar dados Coleta! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
            return coleta;
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
    
     public List<Object> listarStatusColeta(String descricao) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> resultadoConsulta = new ArrayList<Object>();
        String sql ="select c.*, p.nome_razao_pessoa from coleta c, pessoa p, solicitante s where c.id_solicitante = "
                + "s.id_solicitante and s.id_pessoa = p.id_pessoa and c.status_coleta = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, descricao);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Coleta coleta = new Coleta();
                coleta.setNumeroControleColeta(rs.getInt("numerocontrole_coleta"));
                coleta.setDescricaoColeta(rs.getString("descricao_coleta"));
                coleta.setStatusColeta(rs.getString("status_coleta"));
                coleta.setDataSolicitacaoColeta(rs.getDate("datasolicitacao_coleta"));
                coleta.setDataConclusaoColeta(rs.getDate("dataconclusao_coleta"));
                coleta.setNomeSolicitanteColeta(rs.getString("nome_solicitante_coleta"));
                
                resultadoConsulta.add(coleta);
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
     
     public List<Object> listarStatusMaterialColeta(String descricao) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> resultadoConsulta = new ArrayList<Object>();
        String sql ="select c.*, p.nome_razao_pessoa from coleta c, pessoa p, solicitante s where c.id_solicitante = "
                + "s.id_solicitante and s.id_pessoa = p.id_pessoa and c.status_material_coleta = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, descricao);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Coleta coleta = new Coleta();
                coleta.setNumeroControleColeta(rs.getInt("numerocontrole_coleta"));
                coleta.setDescricaoColeta(rs.getString("descricao_coleta"));
                coleta.setNomeSolicitanteColeta(rs.getString("nome_solicitante_coleta"));
                coleta.setStatusColeta(rs.getString("status_coleta"));
                coleta.setDataSolicitacaoColeta(rs.getDate("datasolicitacao_coleta"));
                coleta.setDataConclusaoColeta(rs.getDate("dataconclusao_coleta"));
                coleta.setStatusMaterialColeta(rs.getString("status_material_coleta"));
                
                resultadoConsulta.add(coleta);
            }
             } catch (SQLException ex) {
            System.out.println("Problemas ao consultar StatusMaterialColeta! Erro: " + ex.getMessage());
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
     
      public Boolean alterarStatus(Object object) {
        Coleta coleta = (Coleta) object;
        PreparedStatement stmt = null;
        String sql = "update coleta set status_coleta = ?, status_material_coleta = ? where numerocontrole_coleta = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, coleta.getStatusColeta());
            stmt.setString(2, coleta.getStatusMaterialColeta());
            stmt.setInt(3, coleta.getNumeroControleColeta());
            
            
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

}
