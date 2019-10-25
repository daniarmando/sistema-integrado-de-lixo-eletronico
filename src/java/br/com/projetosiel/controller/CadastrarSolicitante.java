/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.controller;

import br.com.projetosiel.DAO.GenericDAO;
import br.com.projetosiel.DAO.SolicitanteDAOImpl;
import br.com.projetosiel.model.Solicitante;
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
public class CadastrarSolicitante extends HttpServlet {

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
        String tipoSolicitante = request.getParameter("tiposolicitante");
        String nomeRazaoSolicitante = request.getParameter("nomerazaosolicitante");
        String cpfCnpjSolicitante = request.getParameter("cpfcnpjsolicitante");
        String rgIeSolicitante = request.getParameter("rgiesolicitante");
        String telefoneSolicitante = request.getParameter("telefonesolicitante");
        String ruaSolicitante = request.getParameter("ruasolicitante");
        Integer numeroSolicitante = Integer.parseInt(request.getParameter("numerosolicitante"));
        String complementoSolicitante = request.getParameter("complementosolicitante");
        String bairroSolicitante = request.getParameter("bairrosolicitante");
        String cidadeSolicitante = request.getParameter("cidadesolicitante");
        String cepSolicitante = request.getParameter("cepsolicitante");
        String estadoSolicitante = request.getParameter("estadosolicitante");
        String emailSolicitante = request.getParameter("emailsolicitante");
        String loginSolicitante = request.getParameter("loginsolicitante");
        String senhaSolicitante = request.getParameter("senhasolicitante");
        String mensagem = null;
        
        Solicitante solicitante = new Solicitante();
        solicitante.setTipoPessoa(tipoSolicitante);
        solicitante.setNomeRazaoPessoa(nomeRazaoSolicitante);
        solicitante.setCpfCnpjPessoa(cpfCnpjSolicitante);
        solicitante.setRgIePessoa(rgIeSolicitante);
        solicitante.setTelefonePessoa(telefoneSolicitante);
        solicitante.setRuaPessoa(ruaSolicitante);
        solicitante.setNumeroPessoa(numeroSolicitante);
        solicitante.setComplementoPessoa(complementoSolicitante);
        solicitante.setBairroPessoa(bairroSolicitante);
        solicitante.setCidadePessoa(cidadeSolicitante);
        solicitante.setCepPessoa(cepSolicitante);
        solicitante.setEstadoPessoa(estadoSolicitante);
        solicitante.setEmailPessoa(emailSolicitante);
        solicitante.setLoginPessoa(loginSolicitante);
        solicitante.setSenhaPessoa(senhaSolicitante);
        solicitante.setAtorPessoa("S");
       
        
        try {
            GenericDAO daoSolicitante = new SolicitanteDAOImpl();
            if (daoSolicitante.cadastrar(solicitante)) {
                mensagem = "Solicitante cadastrado com sucesso!";
            } else {
                mensagem = "Problemas ao cadastrar Solicitante!";
            }
            request.setAttribute("sucesso", mensagem);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Solicitante! Erro " + ex.getMessage());
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
