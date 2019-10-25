/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.controller;

import br.com.projetosiel.DAO.EquipamentoDAOImpl;
import br.com.projetosiel.DAO.GenericDAO;
import br.com.projetosiel.DAO.PecaDAOImpl;
import br.com.projetosiel.DAO.PecaEquipamentoDAOImpl;
import br.com.projetosiel.model.Categoria;
import br.com.projetosiel.model.Coleta;
import br.com.projetosiel.model.Equipamento;
import br.com.projetosiel.model.Peca;
import br.com.projetosiel.model.PecaEquipamento;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
public class CadastrarEquipamento extends HttpServlet {

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

        Integer numeroControleColeta = Integer.parseInt(request.getParameter("numerocontrolecoleta"));
        Coleta coleta = new Coleta();
        coleta.setNumeroControleColeta(numeroControleColeta);
       
        Integer idCategoria = Integer.parseInt(request.getParameter("idcategoria"));
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(idCategoria);
        
        String nomeEquipamento = request.getParameter("nomeequipamento");
        String tipoEquipamento = request.getParameter("tipoequipamento");
        String statusEquipamento = request.getParameter("statusequipamento");
        String estadoEquipamento = request.getParameter("estadoequipamento");

        Equipamento equipamento = new Equipamento();
        equipamento.setNomeEquipamento(nomeEquipamento);
        equipamento.setTipoEquipamento(tipoEquipamento);
        equipamento.setStatusEquipamento(statusEquipamento);
        equipamento.setEstadoEquipamento(estadoEquipamento);
        
        equipamento.setCategoria(categoria);
        equipamento.setColeta(coleta);        
        
        String[] nomePecas = request.getParameterValues("nomepeca");
        String[] statusPecas = request.getParameterValues("statuspeca");
        String[] detalhePecas = request.getParameterValues("detalhepeca");
        Integer quantidadePecas = nomePecas.length;
        
        Integer codigoEquipamento = null;        
        List<Peca> pecas = new ArrayList<Peca>();

        String mensagem = null;                            

        try {
        
            //Cadastrar o Equipamento
            EquipamentoDAOImpl daoEquipamento = new EquipamentoDAOImpl();
            codigoEquipamento = daoEquipamento.cadastrarEquipamento(equipamento);
            equipamento.setCodigoEquipamento(codigoEquipamento);
            //Fim do cadastro do Equipamento
            
            if (codigoEquipamento > 0) {
                
                //Agora cadastra as peças
                for (int i = 0; i < quantidadePecas; i++) {

                    Peca peca = new Peca();
                    peca.setNomePeca(nomePecas[i]);
                    peca.setStatusPeca(statusPecas[i]);
                    peca.setDetalhePeca(detalhePecas[i]);
                    peca.setColeta(coleta);

                    PecaDAOImpl daoPeca = new PecaDAOImpl();
                    peca.setCodigoPeca(daoPeca.cadastrarPeca(peca));
                    
                    if (peca.getCodigoPeca() > 0) {                    
                        pecas.add(peca);                                                                                                                    
                    } else {
                        mensagem = "Problemas ao cadastrar o Equipamento e suas peças!";
                    }
                } //fim do cadastro de Peças
                
                Boolean statusPecaEquipamento = null;                
                for (Peca peca : pecas){
                    
                    GenericDAO daoPecasEquipamento = new PecaEquipamentoDAOImpl();
                    
                    PecaEquipamento pecaEquipamento = new PecaEquipamento();
                    pecaEquipamento.setEquipamento(equipamento);
                    pecaEquipamento.setPeca(peca);                    
                    
                    statusPecaEquipamento = daoPecasEquipamento.cadastrar(pecaEquipamento);                                        
                }
                
                if (statusPecaEquipamento){
                    mensagem = "Equipamento e suas Peças caastrados com sucesso!";
                } else {
                    mensagem = "Problemas ao cadastrar o Equipamento e suas Peças!";
                }                                                
                
            } else {
                mensagem = "Problemas ao cadastrar o Equipamento e suas Peças!";
            }

            request.setAttribute("sucesso", mensagem);
            request.getRequestDispatcher("receptor/index.jsp").forward(request, response);
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
