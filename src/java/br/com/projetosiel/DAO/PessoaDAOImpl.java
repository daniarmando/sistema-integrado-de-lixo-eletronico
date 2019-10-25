/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.DAO;

import br.com.projetosiel.model.Pessoa;
import br.com.projetosiel.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Daniel
 */
public class PessoaDAOImpl {
    private Connection conn;
    public PessoaDAOImpl() throws Exception{
        try{
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        }catch (Exception ex){
             throw new Exception("Problemas ao conectar no banco de dados! Erro: "+ex.getMessage());
        }
    }
    
     public Integer cadastrar(Pessoa pessoa) throws SQLException{
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer idPessoa = null;
    String sql = "INSERT INTO pessoa(tipo_pessoa, nome_razao_pessoa, cpf_cnpj_pessoa, rg_ie_pessoa, telefone_pessoa, rua_pessoa, numero_pessoa, complemento_pessoa, bairro_pessoa, cidade_pessoa, estado_pessoa, cep_pessoa, email_pessoa, login_pessoa, senha_pessoa, ator_pessoa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id_pessoa;";

       try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getTipoPessoa());
            stmt.setString(2, pessoa.getNomeRazaoPessoa());
            stmt.setString(3, pessoa.getCpfCnpjPessoa());
            stmt.setString(4, pessoa.getRgIePessoa());
            stmt.setString(5, pessoa.getTelefonePessoa());
            stmt.setString(6, pessoa.getRuaPessoa());
            stmt.setInt(7, pessoa.getNumeroPessoa());
            stmt.setString(8, pessoa.getComplementoPessoa());
            stmt.setString(9, pessoa.getBairroPessoa());
            stmt.setString(10, pessoa.getCidadePessoa());
            stmt.setString(11, pessoa.getEstadoPessoa());
            stmt.setString(12, pessoa.getCepPessoa());
            stmt.setString(13, pessoa.getEmailPessoa());
            stmt.setString(14, pessoa.getLoginPessoa());
            stmt.setString(15, pessoa.getSenhaPessoa());            
            stmt.setString(16, pessoa.getAtorPessoa());
            rs = stmt.executeQuery();
            while (rs.next()){
                idPessoa = rs.getInt("id_pessoa");
            }
            }catch (SQLException ex){
            System.out.println("Problemas ao cadastrar Pessoa! Erro: "+ex.getMessage());
            ex.printStackTrace();
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt, rs);
            }catch (Exception ex){
                System.out.println("Problemas ao fechar os paramêtros de conexão! Erro: "+ex.getMessage());
                ex.printStackTrace();
            }
        }
        return idPessoa;
    }
     
     public Boolean alterarPessoa(Pessoa pessoa){
    PreparedStatement stmt = null;
    String sql = "UPDATE pessoa SET nome_razao_pessoa=?, cpf_cnpj_pessoa=?, rg_ie_pessoa=?, "
                + "telefone_pessoa=?, rua_pessoa=?, numero_pessoa=?, complemento_pessoa=?, bairro_pessoa=?, "
                + "cidade_pessoa=?, estado_pessoa=?, cep_pessoa=?, email_pessoa=?, login_pessoa=?, "
                + "senha_pessoa=? WHERE id_pessoa = ?;";
     try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNomeRazaoPessoa());
            stmt.setString(2, pessoa.getCpfCnpjPessoa());
            stmt.setString(3, pessoa.getRgIePessoa());
            stmt.setString(4, pessoa.getTelefonePessoa());
            stmt.setString(5, pessoa.getRuaPessoa());
            stmt.setInt(6, pessoa.getNumeroPessoa());
            stmt.setString(7, pessoa.getComplementoPessoa());
            stmt.setString(8, pessoa.getBairroPessoa());
            stmt.setString(9, pessoa.getCidadePessoa());
            stmt.setString(10, pessoa.getEstadoPessoa());
            stmt.setString(11, pessoa.getCepPessoa());
            stmt.setString(12, pessoa.getEmailPessoa());
            stmt.setString(13, pessoa.getLoginPessoa());
            stmt.setString(14, pessoa.getSenhaPessoa());
            stmt.setInt(15, pessoa.getIdPessoa());
            stmt.executeUpdate();
            return true;
        }catch (SQLException ex){
            System.out.println("Problemas ao alterar a Pessoa! Erro: "+ex.getMessage());
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
     
     public Pessoa verificarPessoa(String login, String senha){
         
         PreparedStatement stmt = null;
         ResultSet rs = null;
         String sql = "select p.* from pessoa p where p.login_pessoa = ? and p.senha_pessoa = ?;";
         
         Pessoa pessoa = null;
         
         try{
             stmt = conn.prepareStatement(sql);
             stmt.setString(1, login);
             stmt.setString(2, senha);
             rs = stmt.executeQuery();
             
             while (rs.next()){
                 pessoa = new Pessoa();
                 pessoa.setIdPessoa(rs.getInt("id_pessoa"));
                 pessoa.setNomeRazaoPessoa(rs.getString("nome_razao_pessoa"));
                 pessoa.setAtorPessoa(rs.getString("ator_pessoa"));
                 
             }
         } catch (SQLException ex){
             System.out.println("Problemas ao logar pessoa! Erro: " + ex.getMessage());
             ex.printStackTrace();
         } finally {
             try{
                 ConnectionFactory.closeConnection(conn, stmt, rs);
             } catch (Exception ex){
                 System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                 ex.printStackTrace();
             }
         }
         
         return pessoa;
         
     }
     
}