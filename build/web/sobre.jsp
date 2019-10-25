<%-- 
    Document   : sobre
    Created on : 01/07/2013, 20:22:09
    Author     : Daniel
--%>

<%@page import="javax.xml.ws.http.HTTPBinding"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>--Sobre--</title>
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
    <h1>Sobre o Projeto SIEL</h1>
    </div>
    
    <p>Diante da modernidade tecnológica que nos acerca, todo o mundo tem se deparado com problemas para conter os níveis de poluição que degradam o planeta. Cada vez mais, governos de diversos países se preocupam com a conservação do meio ambiente, criando legislações e normas para adequar os cidadãos e empresas ao nível ideal.</p>
 <p>As tecnologias da informação tem buscado minimizar prejuízos causados à natureza, inovando na utilização de materiais usados na fabricação de equipamentos e criando novas tecnologias que possam reduzir gastos com energia elétrica. Outra grande preocupação é o lixo eletrônico gerado pela troca constante desses bens de consumo devido aos superlançamentos de novas tecnologias.</p>
 <p>Preocupados com o futuro, este projeto pretende contribuir com a preservação do meio ambiente, buscando assim formas alternativas de retirar os resíduos da natureza. Outro fator importante é a conscientização da população com relação às consequências do mau uso do e-lixo.</p>
 <p>Funcionalmente o sistema web realizará diversas tarefas como o cadastro de empresas coletoras e de doadores de lixo eletrônico. Contudo ajudará também no agendamento e contato com os parceiros que recolherão e descartarão para os devidos fins os equipamentos sem utilidade.</p>
 <p> A divulgação de matérias e dados estatísticos de todo e-lixo coletado e reaproveitado através do sistema é inclusive um serviço de utilidade pública. O Sistema Verde SIEL (Sistema Integrado de Lixo Eletrônico (E-Lixo) ) Sistema de Tecnologia da Informação e Comunicação(TIC's') é uma necessidade do mundo atual, é a concretização de um projeto idealizado para contribuir diariamente com o Meio Ambiente e contudo com os seres existentes de todas as espécies.</p> 
    
    	
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

