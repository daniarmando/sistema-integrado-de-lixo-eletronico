/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.DAO;

import br.com.projetosiel.model.Categoria;
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
public class CategoriaDAOImpl implements GenericDAO{
    private Connection conn;
    public CategoriaDAOImpl() throws Exception{
        try{
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        }catch (Exception ex){
            throw new Exception("Problemas ao conectar no banco de dados! Erro: "+ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Categoria categoria = (Categoria)object;
        PreparedStatement stmt = null;
        String sql="INSERT INTO categoria(nome_categoria) VALUES (?);";
         try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, categoria.getNomeCategoria());
            stmt.execute(); 
            return true;
    }catch(SQLException ex){
            System.out.println("Problemas no SQL ao cadastrar Categoria! Erro: "+ex.getMessage());
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
       String sql="select c.* from categoria c order by c.nome_categoria;";
       try{
           stmt = conn.prepareStatement(sql);
           rs = stmt.executeQuery();
           while(rs.next()){
               Categoria categoria = new Categoria();
               categoria.setIdCategoria(rs.getInt("id_categoria"));
               categoria.setNomeCategoria(rs.getString("nome_categoria"));
               resultado.add(categoria);
           }
       }catch (SQLException ex){
           System.out.println("Problemas ao listar categoria! Erro: "+ex.getMessage());
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
        throw new UnsupportedOperationException("Not supported yet.");
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
