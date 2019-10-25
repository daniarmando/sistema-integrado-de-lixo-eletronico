/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.controller;

import br.com.projetosiel.DAO.BeneficiarioDAOImpl;
import br.com.projetosiel.DAO.GenericDAO;
import br.com.projetosiel.model.Beneficiario;
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
public class CadastrarBeneficiario extends HttpServlet {

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
        
        String tipoBeneficiario = request.getParameter("tipobeneficiario");
        String nomeRazaoBeneficiario = request.getParameter("nomerazaobeneficiario");
        String cpfCnpjBeneficiario = request.getParameter("cpfcnpjbeneficiario");
        String rgIeBeneficiario = request.getParameter("rgiebeneficiario");
        String telefoneBeneficiario = request.getParameter("telefonebeneficiario");
        String ruaBeneficiario = request.getParameter("ruabeneficiario");
        Integer numeroBeneficiario = Integer.parseInt(request.getParameter("numerobeneficiario"));
        String complementoBeneficiario = request.getParameter("complementobeneficiario");
        String bairroBeneficiario = request.getParameter("bairrobeneficiario");
        String cidadeBeneficiario = request.getParameter("cidadebeneficiario");
        String cepBeneficiario = request.getParameter("cepbeneficiario");
        String estadoBeneficiario = request.getParameter("estadobeneficiario");
        String emailBeneficiario = request.getParameter("emailbeneficiario");
        String loginBeneficiario = request.getParameter("loginbeneficiario");
        String senhaBeneficiario = request.getParameter("senhabeneficiario");
        String mensagem = null;
        
       Integer idReceptor = Integer.parseInt(request.getParameter("idreceptor"));
       Receptor receptor = new Receptor();
       receptor.setIdReceptor(idReceptor);
        
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setTipoPessoa(tipoBeneficiario);
        beneficiario.setNomeRazaoPessoa(nomeRazaoBeneficiario);
        beneficiario.setCpfCnpjPessoa(cpfCnpjBeneficiario);
        beneficiario.setRgIePessoa(rgIeBeneficiario);
        beneficiario.setTelefonePessoa(telefoneBeneficiario);
        beneficiario.setRuaPessoa(ruaBeneficiario);
        beneficiario.setNumeroPessoa(numeroBeneficiario);
        beneficiario.setComplementoPessoa(complementoBeneficiario);
        beneficiario.setBairroPessoa(bairroBeneficiario);
        beneficiario.setCidadePessoa(cidadeBeneficiario);
        beneficiario.setCepPessoa(cepBeneficiario);
        beneficiario.setEstadoPessoa(estadoBeneficiario);
        beneficiario.setEmailPessoa(emailBeneficiario);
        beneficiario.setLoginPessoa(loginBeneficiario);
        beneficiario.setSenhaPessoa(senhaBeneficiario);
        beneficiario.setAtorPessoa("B");
        beneficiario.setReceptor(receptor);
        
        
        try {
            GenericDAO daoBeneficiario = new BeneficiarioDAOImpl();
            if (daoBeneficiario.cadastrar(beneficiario)) {
                mensagem = "Beneficiario cadastrado com sucesso!";
            } else {
                mensagem = "Problemas ao cadastrar Beneficiario!";
            }
            request.setAttribute("sucesso", mensagem);
            request.getRequestDispatcher("ListarBeneficiario").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Beneficiario! Erro " + ex.getMessage());
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
