<%-- 
    Document   : index
    Created on : 12/05/2013, 15:36:39
    Author     : Daniel
--%>

<%@page import="javax.xml.ws.http.HTTPBinding"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>--SIEL--</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!--inicio menu do topo-->
<div id="menutopo">
	<table id="menudireita">
    	<tr>	
        	<td>${mensagem}<br /></td>
        		<!--inicio campo de pesquisa-->
        	<td><form action="ConsultarColaborador" class='right' id='searchthis' method='get'>
					<input class="input-text" id="searchBox" name="nomecolaborador" onblur="if(this.value==&quot;&quot;)this.value=this.defaultValue;" onfocus="if(this.value==this.defaultValue)this.value=&quot;&quot;;" type="text" value="Pesquisar Colaborador..." vinput="" />
					<input class="searchbutton" id="submit-button" type="submit" value="Go" /></form></a></td>
                <!--fim campo de pesquisa-->
    <table id="menuesquerda">
    	 <tr>
                        <td><a href="colaborador"><img src="images/menu_topo/home.png" alt="home" title="home"/></a></td>
                        <td class="separador"><img src="images/menu_topo/separador.png"/></a></td>
                        <td><a href="#"><img src="images/menu_topo/mensagem.png" alt="mensagens" title="mensagens" /></a></td>
                        <td class="separador"><img src="images/menu_topo/separador.png"/></a></td>
                        <td><a href="#"><img src="images/menu_topo/config.png" alt="configurações" title="configurações" /></a></td>					
                        <td class="separador"><img src="images/menu_topo/separador.png"/></a></td>
                        <td><a href="index.jsp" onclick=" "><img src="images/menu_topo/sair.png" alt="sair" title="sair" /></a></td>
                        <td class="separador"><img src="images/menu_topo/separador.png"/></a></td>
                        <td class="logo"><img src="images/logo1.png" alt="logo" title="Siel" width="70px" height="50px"/></td>
                    </tr>
    </table>
     </tr>
            </table>    
        
</div>	
<!--fim menu do topo-->
<!--inicio estrutura da grade de aplicativos-->
<div id="structurecolaborador">
<!--inicio da grade aplicativos--> 
<div id="grid_applications">
	<!--inicio cabeçalho da tabela com os aplicativos-->
  	<div id="header_applications"><font class="aplications">Aplicações</font></div>
        <!--fim cabeçalho da tabela com os aplicativos-->
        	<!--tabela de aplicativos-->
			<table id="applications" align="center">
    			<tr>
        		<td><a href="receptor/coletas.jsp"><img src="images/cadastrar coleta.png" alt="" /></br>Coletas</a></td>
            		<td><a href="receptor/doacoes.jsp"><img src="images/cadastrar doação.png" alt="" /></br>Doações</a></td>
            		
                    <td><a href="receptor/equipamentos.jsp"><img src="images/relatorios.png" alt="" /></br>Lista Equipamentos</a></td>

      		
       			
        			<td><a href="ListarPeca"><img src="images/cadastrar peça.png" alt="" /></br>Peças</a></td>
            		<td><a href="DadosMontarEquipamento"><img src="images/criar equipamento.png" alt="" /></br>Montar Equipamento</a></td>
                    </tr>
                    <tr>
           			<td><a href="RelatorioColetas" target="_blank"><img src="images/consultar coleta.png" alt="" /></br>Relatório Coletas</a></td>
                                <td><a href="#" ><img src="images/consultar doação.png" alt="" /></br>Relatório Doações</a></td>
                    

     			</tr>
    		</table>
   			<!--fim da tabela de aplicativos-->
    </div>
 	<!--fim grade que contorna a tabela com os aplicativos-->
    	
</div>
<!--fim estrutura da grade de aplicativos-->
<!--inicio rodape da pagina-->
<div id="footerindex"><table id="tblefooter" align="center" >
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
