<%-- 
    Document   : solicitardoacao
    Created on : 28/05/2013, 21:46:06
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Solicitar Doação - Siel - Sistema Integrado do E-Lixo</title>
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
                        <td><a href="../index.jsp"><img src="images/menu_topo/sair.png" alt="sair" title="sair" /></a></td>
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
 				<h1>Solicitar Doação</h1>
			</div>
			
        <form id="formpattern" class="rounded" method="post" action="../SolicitarDoacao">
			<h2 align="center">Solicitar Doação</h2><hr>
        <div class="field">
       			<label for="nome">Descreva a doação</label>
       				
		  <textarea name="descricaodoacao" type="text" class="input" cols="10" rows="6" /></textarea>
       				
          </div>
                        
                                 	
                      
                        <input type="hidden" id="Data" name="datasolicitacaodoacao" />
                    
         
                    <input type="hidden" value="<%= session.getAttribute("idBeneficiario")%>" name="idbeneficiario" />
                    <input type="hidden" value="espera" name="statuscoleta"/>
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
</script>

<script type="text/javascript">
    
            function Data()
            {
                data = new Date();
                dia = data.getDate();
                mes = data.getMonth()+1;
                ano = data.getFullYear();
				if (dia < 10) dia = "0" + dia
				if (mes < 10) mes = "0" + mes
				
				
                dataCompleta = dia+'/'+mes+'/'+ano;

                return dataCompleta;
            }
            
            window.onload = function(){
                document.getElementById("Data").value = Data();
            }
    </script>   
</body>
</html>


