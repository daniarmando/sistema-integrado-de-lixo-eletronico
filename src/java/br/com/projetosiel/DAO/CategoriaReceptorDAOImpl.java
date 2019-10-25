/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.DAO;

import br.com.projetosiel.model.Categoria;
import br.com.projetosiel.model.CategoriaReceptor;
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
public class CategoriaReceptorDAOImpl implements GenericDAO {

    private Connection conn;

    public CategoriaReceptorDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar no banco de dados! Erro: " + ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        CategoriaReceptor categoriaReceptor = (CategoriaReceptor) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO categoria_receptor(id_categoria, id_receptor) VALUES (?,?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoriaReceptor.getCategoria().getIdCategoria());
            stmt.setInt(2, categoriaReceptor.getReceptor().getIdReceptor());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas no SQL ao cadastrar CategoriaEquipamento! Erro: " + ex.getMessage());
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
       String sql="select cr.*, c.nome_categoria from categoria_receptor cr, categoria c "
               + "where cr.id_categoria_receptor = c.id_categoria and cr.id_receptor = ?;";
       try{
           stmt = conn.prepareStatement(sql);
           rs = stmt.executeQuery();
           while(rs.next()){
               Categoria categoriaReceptor = new Categoria();
               resultado.add(categoriaReceptor);
           }
       }catch (SQLException ex){
           System.out.println("Problemas ao listar Categoria Receptor! Erro: "+ex.getMessage());
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
        
        String sql="Delete from categoria_receptor where id_categoria_receptor=?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Problemas ao excluir Categoria Receptor! Erro: "+ex.getMessage());
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
