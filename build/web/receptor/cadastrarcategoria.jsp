<%-- 
    Document   : cadastrarcategoria
    Created on : 22/05/2013, 17:00:27
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Cadastro de Categorias - Siel - Sistema Integrado do E-Lixo</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<!--css para validar formulario-->
<link href="SpryAssets/SpryValidationTextField.css" rel="stylesheet" type="text/css">
<link href="SpryAssets/SpryValidationSelect.css" rel="stylesheet" type="text/css">
<!--scripts para validar formulario-->
<script src="SpryAssets/SpryValidationTextField.js" type="text/javascript"></script>
<script src="SpryAssets/SpryValidationSelect.js" type="text/javascript"></script>
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
    ${sucesso}<br><br>
     <div id="wrapper">
 				<h1>Cadastrar Categoria</h1>
			</div>
		<!--formulario cadastrar beneficiario pessoa fisica-->        
        <form id="formpattern" method="post" action="../CadastrarCategoria">
        	<h2 align="center">Selecione a(s) catgeoria(s)</h2><hr>
          		
            		
	  	  <div class="field">
   			<table border="0" cellpadding="2" cellspacing="4">
  
  <tr class="linhas">
    <td><select name="idcategoria" class="select">
    	
            
                    <option value="" />
             
       
            
            
	</select>
    </td>
    
    <td><a class="removerCampo" title="Remover linha"><img src="images/minus.png" border="0" /></a></td>
  </tr>
  <tr><td colspan="4">
        <a class="adicionarCampo" title="Adicionar item"><img src="images/plus.png" border="0" /></a>
	</td></tr>
 
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
        	<td><p><a href="sobre.jsp" >Sobre<a href="parceiros.jsp" >Parceiros</a><a href="desenvolvedores.jsp" >Desenvolvedores</p></td>
             <td></td>
        </tr>
        
    	
        </table>
        </div>
<!--fim rodape da pagina-->
<!--scripts para validar o formulario-->
<script type="text/javascript">
var spryselect1 = new Spry.Widget.ValidationSelect("validationcategoria", {validateOn:["blur"]});
</script>        
</body>
</html>