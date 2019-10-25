<%-- 
    Document   : cadastrarcategoria
    Created on : 13/06/2013, 22:11:21
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

<style type="text/css" media="all">
body{ font-family:Arial, Helvetica, sans-serif}
#tudo{border:#CCCCCC 1px solid;width:680px;margin:0 auto}
.bd_titulo{
  text-align:center;
  background-color:#CCCCCC;
  font-weight:bold
}
</style>
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

<!--inicio da conteudo-->
<div id="content">
    ${sucesso}<br><br>
		<!--formulario cadastrar beneficiario pessoa fisica-->        
        <form id="formpattern" method="post" action="CadastrarCategoria">
        	<h2>Cadastrar Categoria</h3>
          		
                <input type="hidden" name="idreceptor" value="" />	
	  	  <div class="field">
   			<label for="categoria">Selecione a categoria</label>
   			

<table border="0" cellpadding="2" cellspacing="4">
  
  <tr class="linhas">
    <td><select name="nomecategoria" class="select">
    	
             <option value="" selected="">Escolha a categoria</option>
                            <option value="1. Grandes Equipamentos">1. Grandes Equipamentos -
Frigoríficos, máquinas de lavar e secar roupa, etc.</option>
                            <option value="2. Pequenos Equipamentos">2. Pequenos Equipamentos -
Aspiradores, torradeiras, ferros de engomar, máquinas de café, etc.</option>
		   
           
           <option value="3. Equipamentos Informáticos e de Telecomunicações">3. Equipamentos Informáticos e de Telecomunicações -
Computadores, teclados, telemóveis, impressoras, copiadoras, etc.</option>
		   
           <option value="4. Equipamentos de Consumo">4. Equipamentos de Consumo -
Aparelhos de rádio, televisores, leitores de MP3, câmaras de vídeo, instrumentos musicais, etc.</option>
		   
           <option value="5. Equipamentos de Iluminação">5. Equipamentos de Iluminação -
Lâmpadas fluorescentes, compactas, aparelhos de iluminação para lâmpadas fluorescentes, etc.</option>
		   
           <option value="6. Ferramentas Elétricas e Eletrónicas">6. Ferramentas Elétricas e Eletrónicas -
Berbequins, ferramentas de jardinagens, etc.</option>
		   
           <option value="7. Brinquedos e Equipamentos de Desporto e Lazer">7. Brinquedos e Equipamentos de Desporto e Lazer - Comboios eléctricos, consolas de jogos, equipamentos desportivos elétricos, etc.</option>
		   
           <option value="8. Aparelhos Médicos">8. Aparelhos Médicos -
Medidores de tensão arterial, etc.</option>
		   
           <option value="9. Instrumentos de Monitorização e Controle">9. Instrumentos de Monitorização e Controle - 
Reguladores de aquecimento, detetores de fumo, termóstatos, etc.</option>
		   
           <option value="10. Distribuidores Automáticos">10. Distribuidores Automáticos -
Máquinas de venda automática de bebidas e produtos alimentares, etc.</option>
	</select>
   
                            </div>
		   
    </td>
    
    <td><a href="#" class="removerCampo" title="Remover linha"><img src="images/minus.png" border="0" /></a></td>
  </tr>
  <tr><td colspan="4">
        <a href="#" class="adicionarCampo" title="Adicionar item"><img src="images/plus.png" border="0" /></a>
	</td></tr>
 
</table>

   		
          
           <input type="hidden" value="<%= session.getAttribute("idReceptor")%>" name="idreceptor" />
          <input type="submit" name="Submit"  class="button" value="Cadastrar" />
                   
       
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
<!--scripts para validar o formulario-->
<script type="text/javascript">
var spryselect1 = new Spry.Widget.ValidationSelect("validationcategoria", {validateOn:["blur"]});
</script>        
</body>
</html>
