/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.controller;

import br.com.projetosiel.DAO.ColetaDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
public class ListarStatusColeta extends HttpServlet {

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
       String status = request.getParameter("status");
       
       try {
           ColetaDAOImpl dao = new ColetaDAOImpl();
           request.setAttribute("coletas" , dao.listarStatusColeta(status));                  
           
           if(status.equals("espera")){
               
               request.getRequestDispatcher("receptor/listarcoletas_espera.jsp").forward(request, response);
           } else if(status.equals("cancelado")){
               
               request.getRequestDispatcher("receptor/listarcoletas_cancelado.jsp").forward(request, response);
           } else if(status.equals("andamento")){
               
               request.getRequestDispatcher("receptor/listarcoletas_andamento.jsp").forward(request, response);
           } else {
               
             request.getRequestDispatcher("receptor/listarcoletas_concluida.jsp").forward(request, response);       
           }
           
        }catch (Exception ex){
            System.out.println("Problemas no servlet ao listar StatusColetas! Erro:"+ex.getMessage());
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
