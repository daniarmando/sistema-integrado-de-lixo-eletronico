/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.controller;

import br.com.projetosiel.DAO.GenericDAO;
import br.com.projetosiel.DAO.TipoColetaDAOImpl;
import br.com.projetosiel.model.Receptor;
import br.com.projetosiel.model.TipoColeta;
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
public class CadastrarTipoColeta extends HttpServlet {

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
        
        String nomeTipoColeta = request.getParameter("nometipocoleta");
        
        Integer idReceptor = Integer.parseInt(request.getParameter("idreceptor"));
        Receptor receptor = new Receptor();
        receptor.setIdReceptor(idReceptor);
        
        String mensagem = null;
        
        TipoColeta tipoColeta = new TipoColeta();
        tipoColeta.setNomeTipoColeta(nomeTipoColeta);
        tipoColeta.setReceptor(receptor);
        
        try {
            GenericDAO daoTipoColeta = new TipoColetaDAOImpl();
            if (daoTipoColeta.cadastrar(tipoColeta)) {
                mensagem = "Tipo de Coleta cadastrado com sucesso!";
            } else {
                mensagem = "Problemas ao cadastrar Tipo Coletas!";
            }
            request.setAttribute("sucesso", mensagem);
            request.getRequestDispatcher("receptor/cadastrartipocoleta.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar TipoColeta! Erro " + ex.getMessage());
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
