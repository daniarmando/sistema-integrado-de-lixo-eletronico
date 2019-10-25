/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.controller;

import br.com.projetosiel.DAO.GenericDAO;
import br.com.projetosiel.DAO.PontoColetaDAOImpl;
import br.com.projetosiel.model.PontoColeta;
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
public class AlterarPontoColeta extends HttpServlet {

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
       Integer idPontoCoelta = Integer.parseInt(request.getParameter("idpontocoleta"));
       String nomePontoColeta = request.getParameter("nomepontocoleta");
       String telefonePontoColeta = request.getParameter("telefonepontocoleta");
       String ruaPontoColeta = request.getParameter("ruapontocoleta");
       Integer numeroPontoColeta = Integer.parseInt(request.getParameter("numeropontocoleta"));
       String bairroPontoColeta = request.getParameter("bairropontocoleta");
       String complementoPontoColeta = request.getParameter("complementopontocoleta");
       String cidadePontoColeta = request.getParameter("cidadepontocoleta");
       String estadoPontoColeta = request.getParameter("estadopontocoleta");
       String cepPontoColeta = request.getParameter("ceppontocoleta");
       
       PontoColeta pontoColeta = new PontoColeta();
       pontoColeta.setIdPontoColeta(idPontoCoelta);
       pontoColeta.setNomePontoColeta(nomePontoColeta);
       pontoColeta.setTelefonePontoColeta(telefonePontoColeta);
       pontoColeta.setRuaPontoColeta(ruaPontoColeta);
       pontoColeta.setNumeroPontoColeta(numeroPontoColeta);
       pontoColeta.setBairroPontoColeta(bairroPontoColeta);
       pontoColeta.setComplementoPontoColeta(complementoPontoColeta);
       pontoColeta.setCidadePontoColeta(cidadePontoColeta);
       pontoColeta.setEstadoPontoColeta(estadoPontoColeta);
       pontoColeta.setCepPontoColeta(cepPontoColeta);
       
        try {
           GenericDAO dao = new PontoColetaDAOImpl();
           if(dao.alterar(pontoColeta)){
               sucesso = "Ponto de Coleta alterado com sucesso!";
           }else{
               sucesso = "Problemas ao alterar Ponto de Coleta!";
           }
           request.setAttribute("sucesso", sucesso);
           request.getRequestDispatcher("ListarPontoColeta").forward(request, response);
        } catch (Exception ex){
            System.out.println("Problemas no servlet ao alterar PontoColeta! Erro:"+ex.getMessage());
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
