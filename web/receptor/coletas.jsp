<%-- 
    Document   : coletas
    Created on : 24/06/2013, 19:39:36
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
    <!--inicio menu do topo-->
<div id="menutopo">
	<table id="menudireita">
    	<tr>	
        	<td>Logado como: <%= session.getAttribute("nome")%></td>
				<!--inicio do campo de pesquisa-->
        	<td><form action='/search' class='right' id='searchthis' method='get'>
					<input class="input-text" id="searchBox" name="q" onblur="if(this.value==&quot;&quot;)this.value=this.defaultValue;" onfocus="if(this.value==this.defaultValue)this.value=&quot;&quot;;" type="text" value="Pesquisar..." vinput="" />
					<input class="searchbutton" id="submit-button" type="submit" value="Go" /></form></td>
        		<!--fim do campo de pesquisa-->
    <table id="menuesquerda">
    	 <tr>
                        <td><a href="index.jsp"><img src="images/menu_topo/home.png" alt="home" title="home"/></a></td>
                        <td class="separador"><img src="images/menu_topo/separador.png"/></a></td>
                        <td><a href="#"><img src="images/menu_topo/mensagem.png" alt="mensagens" title="mensagens" /></a></td>
                        <td class="separador"><img src="images/menu_topo/separador.png"/></a></td>
                        <td><a href="#"><img src="images/menu_topo/config.png" alt="configurações" title="configurações" /></a></td>					
                        <td class="separador"><img src="images/menu_topo/separador.png"/></a></td>
                        <td><a href="#"><img src="images/menu_topo/sair.png" alt="sair" title="sair" /></a></td>
                        <td class="separador"><img src="images/menu_topo/separador.png"/></a></td>
                        <td class="logo"><img src="images/logo1.png" alt="logo" title="Siel" width="70px" height="50px"/></td>
                    </tr>
    </table>    
        </tr>
    </table>
	
</div>
<!--fim menu do topo-->
        	
<!--inicio da conteudo-->
<div id="content">

        
        <h1>${sucesso}</h1><br />
        <!--formulario chama os formularios de cadastro-->
        <div id="wrapper">
        <h1>Coletas</h1>
        </div>
         <form id="formpattern" class="rounded">
          	
          		<h4>Selecione o status da coleta</h4>
        	<select name="statuscoleta" class="select" onchange="javascript: abreJanela(this.value)">
            	<option value="" selected="selected">Status</option>
            	<option value="../ListarStatusColeta?status=espera">Espera</option>
                <option value="../ListarStatusColeta?status=andamento">Andamento</option>
                <option value="../ListarStatusColeta?status=concluido">Concluído</option>
                <option value="../ListarStatusColeta?status=cancelado">Cancelado</option>
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