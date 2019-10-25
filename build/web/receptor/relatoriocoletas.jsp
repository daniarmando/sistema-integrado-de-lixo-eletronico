<%-- 
    Document   : relatoriocoletas
    Created on : 21/06/2013, 13:01:46
    Author     : Daniel
--%>

<%@page import="br.com.projetosiel.model.Coleta"%>
<%@page import="br.com.projetosiel.model.Colaborador"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Relatório Coletas - Siel - Sistema Integrado do E-Lixo</title>
<link href="receptor/css/style.css" rel="stylesheet" type="text/css" />
<style>

#tablelist {
    width: 600px;
    margin: 40px auto;
    font-family: 'trebuchet MS', 'Lucida sans', Arial;
    font-size: 14px;
    color: #444;
}

#list {
    *border-collapse: collapse; /* IE7 and lower */
    border-spacing: 0;
    width: 100%;    
}

/*----------------------*/

#list td, #list th {
    padding: 10px;
    border-bottom: 1px solid #f2f2f2;    
}

#list tbody tr:nth-child(even) {
    background: #f5f5f5;
    -webkit-box-shadow: 0 1px 0 rgba(255,255,255,.8) inset; 
    -moz-box-shadow:0 1px 0 rgba(255,255,255,.8) inset;  
    box-shadow: 0 1px 0 rgba(255,255,255,.8) inset;        
}

#list th {
    text-align: left;
    text-shadow: 0 1px 0 rgba(255,255,255,.5); 
    border-bottom: 1px solid #ccc;
    background-color: #eee;
    background-image: -webkit-gradient(linear, left top, left bottom, from(#f5f5f5), to(#eee));
    background-image: -webkit-linear-gradient(top, #f5f5f5, #eee);
    background-image:    -moz-linear-gradient(top, #f5f5f5, #eee);
    background-image:     -ms-linear-gradient(top, #f5f5f5, #eee);
    background-image:      -o-linear-gradient(top, #f5f5f5, #eee); 
    background-image:         linear-gradient(top, #f5f5f5, #eee);
}

#list th:first-child {
    -moz-border-radius: 6px 0 0 0;
    -webkit-border-radius: 6px 0 0 0;
    border-radius: 6px 0 0 0;  
}

#list th:last-child {
    -moz-border-radius: 0 6px 0 0;
    -webkit-border-radius: 0 6px 0 0;
    border-radius: 0 6px 0 0;
}

#list th:only-child{
    -moz-border-radius: 6px 6px 0 0;
    -webkit-border-radius: 6px 6px 0 0;
    border-radius: 6px 6px 0 0;
}

#list tfoot td {
    border-bottom: 0;
    border-top: 1px solid #fff;
    background-color: #f1f1f1;  
}

#list tfoot td:first-child {
    -moz-border-radius: 0 0 0 6px;
    -webkit-border-radius: 0 0 0 6px;
    border-radius: 0 0 0 6px;
}

#list tfoot td:last-child {
    -moz-border-radius: 0 0 6px 0;
    -webkit-border-radius: 0 0 6px 0;
    border-radius: 0 0 6px 0;
}
#list tfoot td:only-child{
    -moz-border-radius: 0 0 6px 6px;
    -webkit-border-radius: 0 0 6px 6px;
    border-radius: 0 0 6px 6px;
}
  
</style>
</head>
<body onload="window.print();window.close()">


<!--inicio da conteudo-->
<div id="content">
    ${sucesso}</br></br>
    <div id="wrapper">
 	<h2>Relatório de Coletas</h2><hr>
	</div>
            
        <div id="tablelist">
<table id="list" class="zebra">
    <thead>
    <tr>
        <th>Protocolo</th>
        <th>Nome Solicitante</th> 
        <th colspan="4" align="center">Descrição</th>
        <th>Status</th>
        <th>Data Solicitação</th>
        
    </tr>
    </thead>
    <tfoot>
    <tr>
        <td>&nbsp;</td>        
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        
    </tr>
    </tfoot>    
            <tbody>
                <%
                List <Coleta> coletas = (List<Coleta>)request.getAttribute("coletas");
                for (Coleta coleta : coletas){
                %>
                <tr>
                    <td><%= coleta.getNumeroControleColeta() %></td>
                    <td><%= coleta.getNomeSolicitanteColeta() %>
                    <td><%= coleta.getDescricaoColeta() %></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><%= coleta.getStatusColeta() %></td>
                    <td><%= coleta.getDataSolicitacaoColeta() %></td>
                  

                </tr>
                <%}%>
            </tbody>
        </table>
        </div>
            
           
           
   </div>
<!--fim da conteudo-->
  <!--inicio rodape da pagina-->
<div id="footer"><table id="tblefooter" align="center" >
        <tr>	<td></td>
        <td><img src="images/logo.jpg" alt="siel" width="243" height="335"/></td>
        <td></td>
        </tr>
        <tr>
        	<td></td>
        	
             <td></td>
        </tr>
        
    	
        </table>
       
            
   </div>
<!--fim da conteudo-->
  <!--inicio rodape da pagina-->
<div id="footer"><table id="tblefooter" align="center" >
        <tr>	<td></td>
        <td><img src="images/logo.jpg" alt="siel" width="243" height="335"/></td>
        <td></td>
        </tr>
        <tr>
        	<td></td>
        	
             <td></td>
        </tr>
        
    	
        </table>
        </div>
<!--fim rodape da pagina-->        
</body>
</html>

