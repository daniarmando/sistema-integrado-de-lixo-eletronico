<%-- 
    Document   : cadastrarbeneficiariopj
    Created on : 19/05/2013, 15:58:52
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Cadastro de Beneficiário - Siel - Sistema Integrado do E-Lixo</title>
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
 ${sucesso}</br></br>
            <div id="wrapper">
 				<h1>Cadastrar Beneficiário Pessoa Jurídica</h1>
			</div>
        <form id="formpattern" class="rounded" method="post" action="../CadastrarBeneficiario">
			 <h2 align="center">Digite as informações do Beneficiário</h2><hr>
             		<input type="checkbox" class="input" name="tipobeneficiario" value="juridica" checked style="display:none"/>
         <div class="field">
         		<label for="razao">Razão</label>
   		   			<span id="validationrazao">
                    <input type="text" class="input" name="nomerazaobeneficiario"  />
                    <span class="textfieldRequiredMsg">Digite a Razão Social</span></span>
                    <p class="hint">Digite a Razão Social</p>
         </div>
         <div class="field">
         		<label for="cnpj">CNPJ</label>
         			<span id="validationcnpj">
                	<input type="text" class="input" name="cpfcnpjbeneficiario"  />
                	<span class="textfieldRequiredMsg">Digite o CNPJ</span><span class="textfieldInvalidFormatMsg">Formato inválido de CNPJ.</span></span>
                    <p class="hint">Digite o Cadastro Nacional de Pessoa Jurídica - CNPJ</p>
         </div>
         <div class="field">
         		<label for="ie">I.E.</label>
         			<span id="validationie">
                	<input type="text" class="input" name="rgiebeneficiario"  />
                	<span class="textfieldRequiredMsg">Digite a Inscrição Estadual.</span><span class="textfieldInvalidFormatMsg">Formato inválido de Inscrição Estadual.</span></span>
                    <p class="hint">Digite a Inscrição Estadual</p>
          </div>
          <div class="field">
		 <label for="tel">Telefone</label>
	  		  		<span id="validationtel">
    				<input type="text" class="input" name="telefonebeneficiario" placeholder="(00) 0000-0000"/>
    				<span class="textfieldRequiredMsg"> Digite o telefone.</span><span class="textfieldInvalidFormatMsg">Formato inválido de telefone.</span></span>
			</div>
			<div class="field">
    			<label for="rua">Rua</label>
			  		<span id="validationrua">
    				<input type="text" class="input" name="ruabeneficiario" maxlength="80" />
    				<span class="textfieldRequiredMsg">Digite a rua.</span></span>
			</div>
            <div class="field">
    			<label for="numero">Número</label>
			  		<span id="validationnumero">
    				<input type="text" class="input" name="numerobeneficiario" maxlength="10" />
    				<span class="textfieldRequiredMsg">Digite o número.</span><span class="textfieldInvalidFormatMsg">Formato inválido.</span></span>
			</div>
			<div class="field">
    			<label for="bairro">Bairro</label>
			  		<span id="validationbairro">
    				<input type="text" class="input" name="bairrobeneficiario" maxlength="80" />
    				<span class="textfieldRequiredMsg">Digite o bairro.</span></span>
			</div>
			<div class="field">
    			<label for="complemento">Complemento</label>
		   		  	<span id="validationcomplemento">
    				<input type="text" class="input" name="complementobeneficiario" maxlength="100" />
					</span>
    				<p class="hint">Digite o Complemento - se tiver</p>
			</div>
			<div class="field">
    			<label for="cidade">Cidade</label>
			  		<span id="validationcidade">
    				<input type="text" class="input" name="cidadebeneficiario" maxlength="80" />
    				<span class="textfieldRequiredMsg">Digite a cidade.</span></span>
			</div>
		  	<div class="field">
    			<label for="estado">Estado</label>
					<span id="validationestado">
					<select name="estadobeneficiario" class="select">
      					<option value="" selected="">Estado</option>
			  			<option value="sp">São Paulo</option>
			  			<option value="go">Goiás</option>
					</select>
					<span class="selectRequiredMsg">Selecione um estado</span></span>
			<div class="field">
    			<label for="cep">CEP</label>
		  			<span id="validationcep">
    				<input type="text" class="input" name="cepbeneficiario" />
    				<span class="textfieldRequiredMsg">Digite o CEP.</span><span class="textfieldInvalidFormatMsg">Formato inválido de CEP.</span></span>
		</div>
        <div class="field">
		 	 	<label for="email">Email</label>
	  	  			<span id="validationemail">
          			<input type="text" class="input" name="emailbeneficiario" maxlength="30" placeholder="exemplo@exemplo.com.br" />
          	<span class="textfieldRequiredMsg">Digite o email.</span><span class="textfieldInvalidFormatMsg">Formato inválido de email.</span></span>
		</div>
		<div class="field">
    			<label for="login">Login</label>
				  	<span id="validationlogin">
    				<input type="text" class="input" name="loginbeneficiario" maxlength="20" />
    				<span class="textfieldRequiredMsg">Digite o login</span></span>
		</div>
		<div class="field">
    			<label for="senha">Senha</label>
		  			<span id="validationsenha">    				
                    <input type="password" class="input" name="senhabeneficiario" maxlength="" />
    				<span class="textfieldRequiredMsg">Digite a senha.</span></span>
		</div>
                        <input type="hidden" value="<%= session.getAttribute("idReceptor")%>" name="idreceptor" />
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
var sprytextfield2 = new Spry.Widget.ValidationTextField("validationtel", "custom", {useCharacterMasking:true, pattern:"(00) 0000-0000", validateOn:["blur"]});
var sprytextfield4 = new Spry.Widget.ValidationTextField("validationrua", "none", {validateOn:["blur"]});
var sprytextfield5 = new Spry.Widget.ValidationTextField("validationnumero", "integer", {validateOn:["blur"]});
var sprytextfield6 = new Spry.Widget.ValidationTextField("validationbairro", "none", {validateOn:["blur"]});
var sprytextfield7 = new Spry.Widget.ValidationTextField("validationcomplemento", "none", {isRequired:false, validateOn:["blur"]});
var sprytextfield8 = new Spry.Widget.ValidationTextField("validationcidade", "none", {validateOn:["blur"]});
var spryselect1 = new Spry.Widget.ValidationSelect("validationestado", {validateOn:["blur"]});
var sprytextfield9 = new Spry.Widget.ValidationTextField("validationcep", "zip_code", {format:"zip_custom", useCharacterMasking:true, pattern:"00000-000", validateOn:["blur"]});
var sprytextfield10 = new Spry.Widget.ValidationTextField("validationlogin", "none", {validateOn:["blur"]});
var sprytextfield11 = new Spry.Widget.ValidationTextField("validationsenha", "none", {validateOn:["blur"]});
var sprytextfield13 = new Spry.Widget.ValidationTextField("validationrazao", "none", {validateOn:["blur"]});
var sprytextfield14 = new Spry.Widget.ValidationTextField("validationcnpj", "custom", {validateOn:["blur"], useCharacterMasking:true, pattern:"00.000.000/0000-00"});
var sprytextfield20 = new Spry.Widget.ValidationTextField("validationie", "custom", {validateOn:["blur"], useCharacterMasking:true, pattern:"000.000.000.000"});
var sprytextfield14 = new Spry.Widget.ValidationTextField("validationemail", "email", {validateOn:["blur"]});
</script>
</body>
</html>
