/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.controller;

import br.com.projetosiel.DAO.ColaboradorDAOImpl;
import br.com.projetosiel.DAO.GenericDAO;
import br.com.projetosiel.model.Colaborador;
import br.com.projetosiel.model.Receptor;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
public class CadastrarColaborador extends HttpServlet {

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
    
        String nomeColaborador = request.getParameter("nomecolaborador");
        String funcaoColaborador = request.getParameter("funcaocolaborador");
        String loginColaborador = request.getParameter("logincolaborador");
        String senhaColaborador = request.getParameter("senhacolaborador");
        
       Integer idReceptor = Integer.parseInt(request.getParameter("idreceptor"));
       Receptor receptor = new Receptor();
       receptor.setIdReceptor(idReceptor);
       
        String mensagem = null;
        
        Colaborador colaborador = new Colaborador();
        colaborador.setNomeColaborador(nomeColaborador);
        colaborador.setFuncaoColaborador(funcaoColaborador);
        colaborador.setLoginColaborador(loginColaborador);
        colaborador.setSenhaColaborador(senhaColaborador);
        colaborador.setReceptor(receptor);
        colaborador.setAtorColaborador("C");
    
        try {
            GenericDAO daoColaborador = new ColaboradorDAOImpl();
            if (daoColaborador.cadastrar(colaborador)) {
                mensagem = "Colaborador cadastrado com sucesso!";
            } else {
                mensagem = "Problemas ao cadastrar Colaborador!";
            }
            request.setAttribute("sucesso", mensagem);
            request.getRequestDispatcher("ConsultarColaborador").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Colaborador! Erro " + ex.getMessage());
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
