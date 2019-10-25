<%-- 
    Document   : listarreceptor
    Created on : 28/05/2013, 19:24:57
    Author     : Daniel
--%>

<%@page import="com.sun.xml.internal.ws.encoding.soap.SOAP12Constants"%>
<%@page import="br.com.projetosiel.model.Receptor"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Receptor</title>
    </head>
    <body>
        <h1 align="center">Receptores</h1>
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
                    <th>Site</th>
                    <th>Login</th>
                    <th colspan="2" align="center">Editar</th>
               </tr>     
            </thead>
            <tbody>
                <%
                List <Receptor> receptores = (List<Receptor>)request.getAttribute("receptores");
                for (Receptor receptor : receptores){
                %>
                <tr>
                    <td><%= receptor.getIdPessoa() %></td>
                    <td><%= receptor.getTipoPessoa() %></td>
                    <td><%= receptor.getNomeRazaoPessoa() %></td>
                    <td><%= receptor.getCpfCnpjPessoa() %></td>
                    <td><%= receptor.getRgIePessoa() %></td>
                    <td><%= receptor.getEmailPessoa() %></td>
                    <td><%= receptor.getSiteReceptor() %></td>
                    <td><%= receptor.getLoginPessoa() %></td>
                    <td align="center"><a href="ExcluirReceptor?idPessoa=<%= receptor.getIdPessoa()%>">Excluir</a></td>
                    <form method="POST" action="CarregarReceptor">
                <input type="hidden" name="idPessoa" value="<%= receptor.getIdPessoa()%>">
                <input type="hidden" name="tipoPessoa" value="<%= receptor.getTipoPessoa()%>">
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

