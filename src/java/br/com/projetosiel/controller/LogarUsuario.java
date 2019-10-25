/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetosiel.controller;

import br.com.projetosiel.DAO.BeneficiarioDAOImpl;
import br.com.projetosiel.DAO.ColaboradorDAOImpl;
import br.com.projetosiel.DAO.PessoaDAOImpl;
import br.com.projetosiel.DAO.ReceptorDAOImpl;
import br.com.projetosiel.DAO.SolicitanteDAOImpl;
import br.com.projetosiel.model.Colaborador;
import br.com.projetosiel.model.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Daniel
 */
public class LogarUsuario extends HttpServlet {

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

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String mensagem = null;
        Pessoa pessoa = null;
        Colaborador colaborador = null;

        if (!login.equals("") || !senha.equals("")) {

            if (request.getParameter("acao").equals("logar")) {

                try {
                   
                    PessoaDAOImpl daoPessoa = new PessoaDAOImpl();
                    pessoa = daoPessoa.verificarPessoa(login, senha);
                    
                    ColaboradorDAOImpl daoColaborador = new ColaboradorDAOImpl();
                    colaborador = daoColaborador.verificarColaborador(login, senha);

                    if (pessoa != null){

                        HttpSession sessao = request.getSession(true);
                        
                        sessao.setAttribute("id", pessoa.getIdPessoa());
                        sessao.setAttribute("nome", pessoa.getNomeRazaoPessoa());
                        sessao.setAttribute("ator", pessoa.getAtorPessoa());
                        mensagem = "Seja bem-vindo Sr.(a) " + pessoa.getNomeRazaoPessoa() + "!";
                        sessao.setAttribute("mensagem", mensagem);

                        if (pessoa.getAtorPessoa().equals("R")) {
                            
                            ReceptorDAOImpl daoReceptor = new ReceptorDAOImpl();
                            sessao.setAttribute("idReceptor", daoReceptor.retornarIdReceptorPeloIdPessoa(pessoa.getIdPessoa()));
                                                        
                            ReceptorDAOImpl receptorDAOImpl = new ReceptorDAOImpl();
                            Integer quantidadeColetasEspera = receptorDAOImpl.listarQuantidadeColetasEspera(pessoa.getIdPessoa());
                            
                            mensagem = "Seja bem-vindo Sr.(a) " + pessoa.getNomeRazaoPessoa() + "! Você possui " + quantidadeColetasEspera + " coletas em espera!";
                            sessao.setAttribute("mensagem", mensagem);
                            
                            request.getRequestDispatcher("receptor/index1.jsp").forward(request, response);
                            
                        } else if (pessoa.getAtorPessoa().equals("S")) {
                            
                            SolicitanteDAOImpl daoSolicitante = new SolicitanteDAOImpl();
                            sessao.setAttribute("idSolicitante", daoSolicitante.retornarIdSolicitantePeloIdPessoa(pessoa.getIdPessoa()));
                            
                            request.getRequestDispatcher("solicitante/index1.jsp").forward(request, response);
                            
                        } else if (pessoa.getAtorPessoa().equals("B")) {
                            
                            BeneficiarioDAOImpl daoBeneficiario = new BeneficiarioDAOImpl();
                            sessao.setAttribute("idBeneficiario", daoBeneficiario.retornarIdBeneficiarioPeloIdPessoa(pessoa.getIdPessoa()));
                            
                            request.getRequestDispatcher("beneficiario/index.jsp").forward(request, response);
                        }
                        
                    } if ((colaborador != null)) {

                        HttpSession sessao = request.getSession(true);
                        sessao.setAttribute("id", colaborador.getIdColaborador());
                        sessao.setAttribute("nome", colaborador.getNomeColaborador());
                        sessao.setAttribute("ator", colaborador.getAtorColaborador());
                        mensagem = "Seja bem-vindo Sr.(a) " + colaborador.getNomeColaborador() + "!";
                        sessao.setAttribute("mensagem", mensagem);

                        if (colaborador.getAtorColaborador().equals("C")) {
                          
                            sessao.setAttribute("idReceptor", daoColaborador.retornarIdReceptorPeloIdColaborador(colaborador.getIdColaborador()));
                            
                            request.getRequestDispatcher("colaborador/index.jsp").forward(request, response);
                            
                        } 
                        
                    }else {
                        mensagem = "Usuário ou Senha inválidos! Confira os dados e tente novamente!";
                        request.setAttribute("mensagem", mensagem);
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }

                } catch (Exception ex) {
                    System.out.println("Problemas ao logar Pessoa! Erro: " + ex.getMessage());
                    ex.printStackTrace();
                }
               
            } else if (request.getParameter("acao").equals("logout")) {
                HttpSession sessao = request.getSession(true);
                sessao.invalidate();

                response.sendRedirect("index.jsp");
            }

        } else {
            mensagem = "Usuário ou Senha inválidos! Confira os dados e tente novamente!";
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
