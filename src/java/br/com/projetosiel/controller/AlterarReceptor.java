/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.controller;

import br.com.projetosiel.DAO.GenericDAO;
import br.com.projetosiel.DAO.ReceptorDAOImpl;
import br.com.projetosiel.model.Receptor;
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
public class AlterarReceptor extends HttpServlet {

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
        String nomeRazaoReceptor = request.getParameter("nomerazaoreceptor");
        String cpfCnpjReceptor = request.getParameter("cpfcnpjreceptor");
        String rgIeReceptor = request.getParameter("rgiereceptor");
        String telefoneReceptor = request.getParameter("telefonereceptor");
        String ruaReceptor = request.getParameter("ruareceptor");
        Integer numeroReceptor = Integer.parseInt(request.getParameter("numeroreceptor"));
        String complementoReceptor = request.getParameter("complementoreceptor");
        String bairroReceptor = request.getParameter("bairroreceptor");
        String cidadeReceptor = request.getParameter("cidadereceptor");
        String cepReceptor = request.getParameter("cepreceptor");
        String estadoReceptor = request.getParameter("estadoreceptor");
        String emailReceptor = request.getParameter("emailreceptor");
        String siteReceptor = request.getParameter("sitereceptor");
        String loginReceptor = request.getParameter("loginreceptor");
        String senhaReceptor = request.getParameter("senhareceptor");
        Integer idReceptor = Integer.parseInt(request.getParameter("idpessoa"));

        Receptor receptor = new Receptor();
        receptor.setNomeRazaoPessoa(nomeRazaoReceptor);
        receptor.setCpfCnpjPessoa(cpfCnpjReceptor);
        receptor.setRgIePessoa(rgIeReceptor);
        receptor.setTelefonePessoa(telefoneReceptor);
        receptor.setRuaPessoa(ruaReceptor);
        receptor.setNumeroPessoa(numeroReceptor);
        receptor.setComplementoPessoa(complementoReceptor);
        receptor.setBairroPessoa(bairroReceptor);
        receptor.setCidadePessoa(cidadeReceptor);
        receptor.setEstadoPessoa(estadoReceptor);
        receptor.setCepPessoa(cepReceptor);
        receptor.setEmailPessoa(emailReceptor);
        receptor.setSiteReceptor(siteReceptor);
        receptor.setLoginPessoa(loginReceptor);
        receptor.setSenhaPessoa(senhaReceptor);
        receptor.setIdPessoa(idReceptor);
        
        try {
           GenericDAO dao = new ReceptorDAOImpl();
           if(dao.alterar(receptor)){
               sucesso = "Receptor alterado com sucesso!";
           }else{
               sucesso = "Problemas ao alterar Receptor!";
           }
           request.setAttribute("sucesso", sucesso);
           request.getRequestDispatcher("ListarReceptor").forward(request, response);
        } catch (Exception ex){
            System.out.println("Problemas no servlet ao alterar Promotor! Erro:"+ex.getMessage());
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
