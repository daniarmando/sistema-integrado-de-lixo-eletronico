<%-- 
    Document   : cadastrarusuaio
    Created on : 14/06/2013, 11:25:22
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Cadastrar - Siel - Sistema Integrado do E-Lixo</title>
<link href="css/style.css" rel="stylesheet" type="text/css" /> 
<!--inicio-script-abre-pagina-pelo-select-->
<script type="text/javascript">
function abreJanela(URL) {
location.href = URL; 
}
</script>
</head>
<body>
        	
<!--inicio da conteudo-->
<div id="content">

        
        <h1>${sucesso}</h1><br />
        <!--formulario chama os formularios de cadastro-->
         <form id="formpattern" class="rounded">
          	<h2>Cadastro SIEL</h3>
          		<h4>Selecione o Usuário</h4>
        	<select name="tipousuario" class="select" onchange="javascript: abreJanela(this.value)">
            	<option value="" selected="selected">Usuário</option>
            	<option value="cadastrarreceptor.jsp">Receptor</option>
                <option value="cadastrarsolicitante.jsp">Solicitante</option>
            </select>
		</form>
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
