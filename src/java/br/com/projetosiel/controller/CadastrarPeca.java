/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.controller;

import br.com.projetosiel.DAO.GenericDAO;
import br.com.projetosiel.DAO.PecaDAOImpl;
import br.com.projetosiel.model.Coleta;
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
public class CadastrarPeca extends HttpServlet {

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
       String nomePeca = request.getParameter("nomepeca");
       String detalhePeca = request.getParameter("detalhepeca");
       String statusPeca = request.getParameter("statuspeca");
       
       String mensagem = null;
       
       Integer numeroControleColeta = Integer.parseInt(request.getParameter("numerocontrolecoleta"));
       Coleta coleta = new Coleta();
       coleta.setNumeroControleColeta(numeroControleColeta);
       
       Peca peca = new Peca();
       peca.setNomePeca(nomePeca);
       peca.setDetalhePeca(detalhePeca);
       peca.setStatusPeca(statusPeca);
       peca.setColeta(coleta);
       
       try {
            GenericDAO daoPeca = new PecaDAOImpl();
            if (daoPeca.cadastrar(peca)) {
                mensagem = "Peça cadastrada com sucesso!";
            } else {
                mensagem = "Problemas ao cadastrar Peça!";
            }
            request.setAttribute("sucesso", mensagem);
            request.getRequestDispatcher("receptor/cadastrarpeca.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Peça! Erro " + ex.getMessage());
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
