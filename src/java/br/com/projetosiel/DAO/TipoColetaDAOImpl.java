/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.DAO;

import br.com.projetosiel.model.TipoColeta;
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
public class TipoColetaDAOImpl implements GenericDAO{
    private Connection conn;
    public TipoColetaDAOImpl() throws Exception{
        try{
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        }catch (Exception ex){
            throw new Exception("Problemas ao conectar no banco de dados! Erro: "+ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        TipoColeta tipoColeta = (TipoColeta)object;
        PreparedStatement stmt = null;
        String sql="INSERT INTO tipo_coleta(nome_tipo_coleta)VALUES (?);";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, tipoColeta.getNomeTipoColeta());
            stmt.execute(); 
            return true;
    }catch(SQLException ex){
            System.out.println("Problemas no SQL ao cadastrar TipoColeta! Erro: "+ex.getMessage());
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
       String sql="select tc.* from tipo_coleta tc order by tc.nome_tipo_coleta;";
       try{
           stmt = conn.prepareStatement(sql);
           rs = stmt.executeQuery();
           while(rs.next()){
              TipoColeta tipoColeta = new TipoColeta();
               tipoColeta.setIdTipoColeta(rs.getInt("id_tipo_coleta"));
               tipoColeta.setNomeTipoColeta(rs.getString("nome_tipo_coleta"));
               resultado.add(tipoColeta);
           }
       }catch (SQLException ex){
           System.out.println("Problemas ao listar Tipo Coleta! Erro: "+ex.getMessage());
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
        
        String sql="Delete from tipo_coleta where id_tipo_coleta=?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Problemas ao excluir Tipo Coleta! Erro: "+ex.getMessage());
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
        throw new UnsupportedOperationException("Not supported yet.");
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
