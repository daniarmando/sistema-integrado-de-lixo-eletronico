/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.controller;

import br.com.projetosiel.DAO.GenericDAO;
import br.com.projetosiel.DAO.PecaDAOImpl;
import br.com.projetosiel.model.Peca;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
public class AlterarPeca extends HttpServlet {

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
      String sucesso = "";
      Integer codigoPeca = Integer.parseInt(request.getParameter("codigoPeca"));
      String nomePeca = request.getParameter("nomepeca");
      String detalhePeca = request.getParameter("detalhepeca");
      
      Peca peca = new Peca();
      peca.setCodigoPeca(codigoPeca);
      peca.setNomePeca(nomePeca);
      peca.setDetalhePeca(detalhePeca);
      
       try {
           GenericDAO dao = new PecaDAOImpl();
           if(dao.alterar(peca)){
               sucesso = "Peça alterada com sucesso!";
           }else{
               sucesso = "Problemas ao alterar Peça!";
           }
           request.setAttribute("sucesso", sucesso);
           request.getRequestDispatcher("ListarPeca").forward(request, response);
        } catch (Exception ex){
            System.out.println("Problemas no servlet ao alterar Peça! Erro:"+ex.getMessage());
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
