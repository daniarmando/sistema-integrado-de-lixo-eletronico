/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.controller;

import br.com.projetosiel.DAO.CategoriaDAOImpl;
import br.com.projetosiel.DAO.GenericDAO;
import br.com.projetosiel.DAO.PontoColetaDAOImpl;
import br.com.projetosiel.DAO.ReceptorDAOImpl;
import br.com.projetosiel.DAO.TipoColetaDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
public class DadosColeta extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try{
           
            GenericDAO daoCategoria = new CategoriaDAOImpl();
            request.setAttribute("categorias", daoCategoria.listar());
            
            GenericDAO daoTipoColeta = new TipoColetaDAOImpl();
            request.setAttribute("tipos", daoTipoColeta.listar());
            
            GenericDAO daoReceptor = new ReceptorDAOImpl();
            request.setAttribute("receptores", daoReceptor.listar());
            
            GenericDAO daoPontoColeta = new PontoColetaDAOImpl();
            request.setAttribute("pontocoletas", daoPontoColeta.listar());
           
                request.getRequestDispatcher("solicitante/solicitarcoleta.jsp").forward(request, response);
           
        } catch (Exception ex){
            System.out.println("Problemas no Servlet ao carregar os dados da coleta! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
