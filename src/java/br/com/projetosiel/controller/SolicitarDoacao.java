/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.controller;

import br.com.projetosiel.DAO.DoacaoDAOImpl;
import br.com.projetosiel.DAO.GenericDAO;
import br.com.projetosiel.model.Beneficiario;
import br.com.projetosiel.model.Doacao;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
public class SolicitarDoacao extends HttpServlet {
     public Date converterData(String data) throws ParseException {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        if (data == null || data.trim().equals("")) {
            return null;
        } else {
            Date date = fmt.parse(data);
            return date;
        }
     }

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
            throws ServletException, IOException, ParseException {
       String descricaoDoacao = request.getParameter("descricaodoacao");
       Date dataSolicitacaoDoacao = converterData(request.getParameter("datasolicitacaodoacao"));
       String statusDoacao = request.getParameter("statuscoleta");
       
       String mensagem = null;
       
       Integer idBeneficiario = Integer.parseInt(request.getParameter("idbeneficiario"));
       Beneficiario beneficiario = new Beneficiario();
       beneficiario.setIdBeneficiario(idBeneficiario);
       
       Doacao doacao= new Doacao();
       doacao.setDescricaoDoacao(descricaoDoacao);
       doacao.setDataSolicitacaoDoacao(dataSolicitacaoDoacao);
       doacao.setStatusDoacao(statusDoacao);
       doacao.setBeneficiario(beneficiario);
       
       try {
            GenericDAO daoDoacao = new DoacaoDAOImpl();
            if (daoDoacao.cadastrar(doacao)) {
                mensagem = "Solicitação Doação cadastrada com sucesso!";
            } else {
                mensagem = "Problemas ao cadastrar Doação!";
            }
            request.setAttribute("sucesso", mensagem);
            request.getRequestDispatcher("beneficiario/solicitardoacao.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Doação! Erro " + ex.getMessage());
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(SolicitarDoacao.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(SolicitarDoacao.class.getName()).log(Level.SEVERE, null, ex);
        }
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
