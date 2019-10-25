/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.controller;

import br.com.projetosiel.DAO.ColetaDAOImpl;
import br.com.projetosiel.DAO.GenericDAO;
import br.com.projetosiel.model.Coleta;
import br.com.projetosiel.model.PontoColeta;
import br.com.projetosiel.model.Receptor;
import br.com.projetosiel.model.Solicitante;
import br.com.projetosiel.model.TipoColeta;
import java.io.IOException;
import java.io.PrintWriter;
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
public class SolicitarColeta extends HttpServlet {
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
       String descricaoColeta = request.getParameter("descricaocoleta");
       String statusColeta = request.getParameter("statuscoleta");
       Date dataSolicitacaoColeta = converterData(request.getParameter("datasolicitacaocoleta"));
       String nomeSolicitanteColeta = request.getParameter("nomesolicitantecoleta");
       
       Integer idTipoColeta = Integer.parseInt(request.getParameter("idtipocoleta"));
       TipoColeta tipoColeta = new TipoColeta();
       tipoColeta.setIdTipoColeta(idTipoColeta);
       
       Integer idSolicitante = Integer.parseInt(request.getParameter("idsolicitante"));
       Solicitante solicitante = new Solicitante();
       solicitante.setIdSolicitante(idSolicitante);
       
       Integer idReceptor = Integer.parseInt(request.getParameter("idreceptor"));
       Receptor receptor = new Receptor();
       receptor.setIdReceptor(idReceptor);
       
       Integer idPontoColeta = Integer.parseInt(request.getParameter("idpontocoleta"));
       PontoColeta pontoColeta = new PontoColeta();
       pontoColeta.setIdPontoColeta(idPontoColeta);
       
       String mensagem = null;
       
       Coleta coleta = new Coleta();
       coleta.setDescricaoColeta(descricaoColeta);
       coleta.setStatusColeta(statusColeta);
       coleta.setDataSolicitacaoColeta(dataSolicitacaoColeta);
       coleta.setNomeSolicitanteColeta(nomeSolicitanteColeta);
       coleta.setTipoColeta(tipoColeta);
       coleta.setSolicitante(solicitante);
       coleta.setReceptor(receptor);
       coleta.setPontoColeta(pontoColeta);
       
        try {
            GenericDAO daoColeta = new ColetaDAOImpl();
            if (daoColeta.cadastrar(coleta)) {
                mensagem = "Solicitação Coleta cadastrado com sucesso!";
            } else {
                mensagem = "Problemas ao cadastrar Coleta!";
            }
            request.setAttribute("sucesso", mensagem);
            request.getRequestDispatcher("ListarColeta").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Coleta! Erro " + ex.getMessage());
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
            Logger.getLogger(SolicitarColeta.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SolicitarColeta.class.getName()).log(Level.SEVERE, null, ex);
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
