/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.controller;

import br.com.projetosiel.DAO.ColetaDAOImpl;
import br.com.projetosiel.model.Coleta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
public class RegistrarColeta extends HttpServlet {

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
        Integer numeroControleColeta = Integer.parseInt(request.getParameter("numeroControleColeta"));
       String statusColeta = "concluido";
       String statusMaterialColeta = "ncadastrado";
       String sucesso = null;
    
       Coleta coleta = new Coleta();
       coleta.setNumeroControleColeta(numeroControleColeta);
       coleta.setStatusColeta(statusColeta);
       coleta.setStatusMaterialColeta(statusMaterialColeta);
       
        try {
           ColetaDAOImpl dao = new ColetaDAOImpl();
           if(dao.alterarStatus(coleta)){
               sucesso = "Coleta alterada com sucesso!";
           }else{
               sucesso = "Problemas ao alterar Coleta!";
           }
           request.setAttribute("sucesso", sucesso);
           request.getRequestDispatcher("receptor/index1.jsp").forward(request, response);
        } catch (Exception ex){
            System.out.println("Problemas no servlet ao alterar Coleta! Erro:"+ex.getMessage());
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
