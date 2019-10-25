<%-- 
    Document   : listarsolicitante
    Created on : 03/06/2013, 19:16:33
    Author     : Daniel
--%>

<%@page import="br.com.projetosiel.model.Solicitante"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Solicitante</title>
    </head>
    <body>
        <h1 align="center">Solicitantes</h1>
        <div id="tabela" style="margin-left: 28%;width:600px; height:auto; background-color:gray">
        <table align="center" border="0">
            <thead>
                <tr>
                   
                    <th>ID</th>
                    <th>Tipo Pessoa</th>
                    <th>Nome/Razão</th>
                    <th>CPF/CNPJ</th>
                    <th>RG/IE</th>
                    <th>Email</th>
                    <th>Login</th>
                    <th>Senha</th>
                    <th colspan="2" align="center">Editar</th>
               </tr>     
            </thead>
            <tbody>
                <%
                List <Solicitante> solicitantes = (List<Solicitante>)request.getAttribute("solicitantes");
                for (Solicitante solicitante : solicitantes){
                %>
                <tr>
                    <td><%= solicitante.getIdPessoa() %></td>
                    <td><%= solicitante.getTipoPessoa() %></td>
                    <td><%= solicitante.getNomeRazaoPessoa() %></td>
                    <td><%= solicitante.getCpfCnpjPessoa() %></td>
                    <td><%= solicitante.getRgIePessoa() %></td>
                    <td><%= solicitante.getEmailPessoa() %></td>
                    <td><%= solicitante.getLoginPessoa() %></td>
                    <td><%= solicitante.getSenhaPessoa() %></td>
                    <td align="center"><a href="ExcluirSolicitante?idPessoa=<%= solicitante.getIdPessoa()%>">Excluir</a></td>
            <form method="POST" action="CarregarSolicitante">
                <input type="hidden" name="idPessoa" value="<%= solicitante.getIdPessoa()%>">
                <input type="hidden" name="tipoPessoa" value="<%= solicitante.getTipoPessoa()%>">
                <td align="center"><input type="submit" value="Alterar"/></td>
            </form>
                </tr>
                <%}%>
            </tbody>
        </table>
            <a href="index.jsp">Voltar</a>
        </div>
            
            <!--inicio rodape da pagina-->
<div id="footer"><table id="tblefooter" align="center" >
        <tr>	<td></td>
        <td><img src="images/logo.jpg" alt="siel" width="243" height="335"/></td>
        <td></td>
        </tr>
        <tr>
        	<td></td>
        	<td><p><a href="sobre.jsp" >Sobre<a href="parceiros.jsp" >Parceiros</a><a href="desenvolvedores.jsp" >Desenvolvedores</p></td>
             <td></td>
        </tr>
        
    	
        </table>
        </div>
<!--fim rodape da pagina-->
            
    </body>
</html>

