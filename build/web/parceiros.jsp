<%-- 
    Document   : parceiros
    Created on : 01/07/2013, 20:32:12
    Author     : Daniel
--%>

<%@page import="javax.xml.ws.http.HTTPBinding"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>--Parceiros--</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
 <!--visualizador de imagens-->
<link href="scripts/css/lightbox.css" rel="stylesheet" />
<script src="scripts/js/jquery-1.7.2.min.js"> </script>
<script src="scripts/js/lightbox.js"> </script>

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
                        <td><a href="receptor"><img src="images/menu_topo/home.png" alt="home" title="home"/></a></td>
                        <td class="separador"><img src="images/menu_topo/separador.png"/></a></td>
                        <td><a href="#"><img src="images/menu_topo/mensagem.png" alt="mensagens" title="mensagens" /></a></td>
                        <td class="separador"><img src="images/menu_topo/separador.png"/></a></td>
                        <td><a href="#"><img src="images/menu_topo/config.png" alt="configurações" title="configurações" /></a></td>					
                        <td class="separador"><img src="images/menu_topo/separador.png"/></a></td>
                        <td><a href="../index.jsp" onclick=" "><img src="images/menu_topo/sair.png" alt="sair" title="sair" /></a></td>
                        <td class="separador"><img src="images/menu_topo/separador.png"/></a></td>
                        <td class="logo"><img src="images/logo1.png" alt="logo" title="Siel" width="70px" height="50px"/></td>
                    </tr>
    </table>
     </tr>
            </table>    
        
</div>	
<!--fim menu do topo-->

<div id="content">
    <br>
    <div id="wrapper">
    <h1>Parceiros</h1>
    </div>
    
    <div id="parceiros">
        <p align="center">Ilista</p>
					 <center><a href="images/ILISTA.jpg" rel="lightbox[roadtrip]" title="*Ilista de Presentes"><img src="images/ILISTA.jpg" width="300" height="200"></img></a></center>
                     
                     <p align="center">ICivil</p>
                    <center> <a href="images/LOGOICIVIL(casa).png" rel="lightbox[roadtrip]" title="*Icivil"> <img src="images/LOGOICIVIL(casa).png" width="300" height="200"></a></a></center>
                      
                       <p align="center">A.S System</p> 
                       <center><a href="images/logoAsSystem.png" rel="lightbox[roadtrip]" title="*A.S System"><img src="images/logoAsSystem.png" width="300" height="200"></img></a> </center>   
                                
                    
    </div>
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
