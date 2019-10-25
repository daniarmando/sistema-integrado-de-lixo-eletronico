<%-- 
    Document   : cadastrarequipamento_m
    Created on : 23/06/2013, 19:28:10
    Author     : Daniel
--%>

<%@page import="br.com.projetosiel.model.ListaPeca"%>
<%@page import="br.com.projetosiel.model.Categoria"%>
<%@page import="br.com.projetosiel.model.ListaEquipamento"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Cadastro de Equipamento - Siel - Sistema Integrado do E-Lixo</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<!--css para validar formulario-->
<link href="SpryAssets/SpryValidationTextField.css" rel="stylesheet" type="text/css">
<link href="SpryAssets/SpryValidationSelect.css" rel="stylesheet" type="text/css">
<!--scripts para validar formulario-->
<script src="SpryAssets/SpryValidationTextField.js" type="text/javascript"></script>
<script src="SpryAssets/SpryValidationSelect.js" type="text/javascript"></script>
<script type="text/javascript" src="scripts/jquery.min.js"></script>
<script type="text/javascript">
$(function () {
  function removeCampo() {
	$(".removerCampo").unbind("click");
	$(".removerCampo").bind("click", function () {
	   if($("tr.linhas").length > 1){
		$(this).parent().parent().remove();
	   }
	});
  }
 
  $(".adicionarCampo").click(function () {
	novoCampo = $("tr.linhas:first").clone();
	novoCampo.find("input").val("");
	novoCampo.insertAfter("tr.linhas:last");
	removeCampo();
  });
});
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
            ${sucesso}</br></br>
			<div id="wrapper">
 				<h1>Cadastrar Equipamento</h1>
			</div>
            
        <form id="formpattern" class="rounded" method="post" action="CadastrarEquipamento">
			 <h2 align="center">Digite as informações Equipamento</h2><hr>
                         
                         <div class="field">
   			<label for="categoria">Procotolo Coleta</label>
                         
                          <input type="text" name="numerocontrolecoleta" readonly size="2" value="${coleta.numeroControleColeta}"/>
                         </div>
                          
                        <div class="field">
   			<label for="categoria">Selecione a categoria</label>
   
    <select name="idcategoria" class="select">
    	
             <%
                List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
                for (Categoria categoria : categorias){                                   
             %>
             
                    <option value="<%= categoria.getIdCategoria() %>"><%= categoria.getNomeCategoria() %></option>
             
             <% } %>
	</select>
                </div><br>
    
                 <div class="field">
		  <label for="equipamento">Nome do Equipamento</label>
                  
                  <input type="text" name="nomeequipamento" class="input"/>
          </div><br>
             
             <div class="field">
       			<label for="estado">Estado</label>
                        <select name="estadoequipamento" class="select">
                            <option value="funcionando">Funcionando</option>
                            <option value="nao funcionando">Não Funcionando</option>
                        </select>
                    </div><br>
                    
                    <h2 align="center">Digite as informações das peças</h2><hr>
                     <div class="field">
                        <table border="0" cellpadding="2" cellspacing="4">
  
  <tr class="linhas">
      <td><label for="pecas">Peça</label><input type="text" name="nomepeca"  class="input1" /></td>
      <td><label for="detalhe">Detalhe</label><input type="text" name="detalhepeca" class="input1"/></td>
      <td>
          <label for="detalhe">Status</label><select name="statuspeca" class="select">
              <option value="disponivel">Disponível</option>
              <option value="indisponivel">Indisponível</option>
          </select>
      </td>
    
    <td><a class="removerCampo" title="Remover linha"><img src="images/minus.png" border="0" /></a></td>
  </tr>
  <tr><td colspan="4">
        <a class="adicionarCampo" title="Adicionar item"><img src="images/plus.png" border="0" /></a>
	</td></tr>
</table>
                     </div>

                    <input type="hidden" name="tipoequipamento" value="coletado" />
                    <input type="hidden" name="statusequipamento" value="disponivel" />
                    <input type="submit" name="Submit"  class="button" value="Cadastrar" />
                    <input type="reset" name="btreset" class="button" value="Limpar"/>   
       
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
<!--scripts para validar formulario-->
<script type="text/javascript">
var sprytextfield3 = new Spry.Widget.ValidationTextField("validationnome", "none", {validateOn:["blur"]});
var sprytextfield1 = new Spry.Widget.ValidationTextField("validationfuncao", "none", {validateOn:["blur"]});
var sprytextfield10 = new Spry.Widget.ValidationTextField("validationlogin", "none", {validateOn:["blur"]});
var sprytextfield11 = new Spry.Widget.ValidationTextField("validationsenha", "none", {validateOn:["blur"]});
</script>
</body>
</html>