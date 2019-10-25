/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.controller;

import br.com.projetosiel.DAO.CategoriaReceptorDAOImpl;
import br.com.projetosiel.DAO.GenericDAO;
import br.com.projetosiel.DAO.ReceptorDAOImpl;
import br.com.projetosiel.model.Categoria;
import br.com.projetosiel.model.CategoriaReceptor;
import br.com.projetosiel.model.Receptor;
import br.com.projetosiel.model.TipoColeta;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
public class CadastrarReceptor extends HttpServlet {

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
        String tipoReceptor = request.getParameter("tiporeceptor");
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
        Integer idTipoColeta = Integer.parseInt(request.getParameter("idtipocoleta"));

        String[] idCategorias = request.getParameterValues("idcategoria");
        Integer quantidadeCategorias = idCategorias.length;

        Integer idReceptor = null;

        String mensagem = null;

        Receptor receptor = new Receptor();
        receptor.setTipoPessoa(tipoReceptor);
        receptor.setNomeRazaoPessoa(nomeRazaoReceptor);
        receptor.setCpfCnpjPessoa(cpfCnpjReceptor);
        receptor.setRgIePessoa(rgIeReceptor);
        receptor.setTelefonePessoa(telefoneReceptor);
        receptor.setRuaPessoa(ruaReceptor);
        receptor.setNumeroPessoa(numeroReceptor);
        receptor.setComplementoPessoa(complementoReceptor);
        receptor.setBairroPessoa(bairroReceptor);
        receptor.setCidadePessoa(cidadeReceptor);
        receptor.setCepPessoa(cepReceptor);
        receptor.setEstadoPessoa(estadoReceptor);
        receptor.setEmailPessoa(emailReceptor);
        receptor.setSiteReceptor(siteReceptor);
        receptor.setLoginPessoa(loginReceptor);
        receptor.setSenhaPessoa(senhaReceptor);
        receptor.setAtorPessoa("R");
        
        TipoColeta tipoColeta = new TipoColeta();
        tipoColeta.setIdTipoColeta(idTipoColeta);
        receptor.setTipoColeta(tipoColeta);

        try {
            ReceptorDAOImpl daoReceptor = new ReceptorDAOImpl();
            idReceptor = daoReceptor.cadastrarReceptor(receptor);
            receptor.setIdReceptor(idReceptor);
            if (idReceptor > 0) {

                for (int i = 0; i < quantidadeCategorias; i++) {

                    CategoriaReceptor categoriaReceptor = new CategoriaReceptor();
                    categoriaReceptor.setReceptor(receptor);

                    Categoria categoria = new Categoria();
                    categoria.setIdCategoria(Integer.parseInt(idCategorias[i]));
                    categoriaReceptor.setCategoria(categoria);

                    GenericDAO daoCategoriaReceptor = new CategoriaReceptorDAOImpl();
                    if (daoCategoriaReceptor.cadastrar(categoriaReceptor)) {
                        mensagem = "Receptor cadastrado com sucesso! Favor Selecionar as categorias...";
                    } else {
                        mensagem = "Problemas ao cadastrar Receptor!";
                    }

                }
            } else {
                mensagem = "Problemas ao cadastrar Receptor!";
            }

            request.setAttribute("sucesso", mensagem);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Receptor! Erro " + ex.getMessage());
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
