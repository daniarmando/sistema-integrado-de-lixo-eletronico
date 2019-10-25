<%-- 
    Document   : cadastrarbeneficiario
    Created on : 28/04/2013, 16:19:55
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Cadastro de Receptor - Siel - Sistema Integrado do E-Lixo</title>
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
          	<h2>Cadastro de Receptor</h3>
          		<h4>Favor informar o tipo de Receptor</h4>
        	<select name="tipopessoa" class="select" onchange="javascript: abreJanela(this.value)">
            	<option value="" selected="selected">Tipo Pessoa</option>
            	<option value="DadosReceptor?tipo=PF">Física - CPF</option>
                <option value="DadosReceptor?tipo=PJ">Jurídica - CNPJ</option>
            </select>
		</form>
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
        	<td><p><a href="sobre.jsp" >Sobre<a href="parceiros.jsp" >Parceiros</a><a href="desenvolvedores.jsp" >Desenvolvedores</p></td>
             <td></td>
        </tr>
        
    	
        </table>
        </div>
<!--fim rodape da pagina-->
</body>
</html>