/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.controller;

import br.com.projetosiel.DAO.GenericDAO;
import br.com.projetosiel.DAO.ListaEquipamentoDAOImpl;
import br.com.projetosiel.DAO.ListaPecaDAOImpl;
import br.com.projetosiel.model.ListaEquipamento;
import br.com.projetosiel.model.ListaPeca;
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
public class CadastrarListaEquipamento extends HttpServlet {

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
       String nomeListaEquipamento = request.getParameter("nomelistaequipamento");
       Integer idReceptor = Integer.parseInt(request.getParameter("idreceptor"));       
       
        String[] nomeListaPecas = request.getParameterValues("nomelistapeca");
        Integer quantidadePecas = nomeListaPecas.length;
        
       Integer idListaEquipamento = null;
       
        String mensagem = null;
        
        ListaEquipamento listaEquipamento = new ListaEquipamento();
        listaEquipamento.setNomeListaEquipamento(nomeListaEquipamento);
        
       Receptor receptor = new Receptor();
       receptor.setIdReceptor(idReceptor);
       
       listaEquipamento.setReceptor(receptor);
        
       try {
            ListaEquipamentoDAOImpl daoListaEquipamento = new ListaEquipamentoDAOImpl();
            idListaEquipamento = daoListaEquipamento.cadastrarListaEquipamento(listaEquipamento);
            listaEquipamento.setIdListaEquipamento(idListaEquipamento);
            if (idListaEquipamento > 0) {

                for (int i = 0; i < quantidadePecas; i++) {

                    ListaPeca listaPeca = new ListaPeca();
                    listaPeca.setNomeListaPeca(nomeListaPecas[i]);
                    listaPeca.setListaEquipamento(listaEquipamento);

                    GenericDAO daoListaPeca = new ListaPecaDAOImpl();
                    if (daoListaPeca.cadastrar(listaPeca)) {
                        mensagem = "Lista Equipamento cadastrado com sucesso!";
                    } else {
                        mensagem = "Problemas ao cadastrar Lista Equipamento!";
                    }

                }
            } else {
                mensagem = "Problemas ao cadastrar Lista Equipamento!";
            }

            request.setAttribute("sucesso", mensagem);
            request.getRequestDispatcher("ListarListaEquipamento").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Lista Equipamento! Erro " + ex.getMessage());
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
