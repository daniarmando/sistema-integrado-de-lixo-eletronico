<%-- 
    Document   : alterarbeneficiario
    Created on : 08/06/2013, 18:21:56
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Alterar Beneficiário - Siel - Sistema Integrado do E-Lixo</title>
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
		<!--formulario cadastrar beneficiario pessoa fisica-->  
                <div id="wrapper">
                    <h1>Alterar Beneficiário<h1>
                </div>
                
                <form id="formpattern" method="post" action="AlterarBeneficiario">
                    
        	<h2 align="center">Digite as informações do Beneficiário</h2><hr>
          
            		
	  	  <div class="field">
       			<label for="id">ID</label>
                            <input type="text" name="idpessoa" readonly size="2" value="${beneficiario.idPessoa}"/> <br>
                        </div>
                        <div class="field">
       			<label for="nome">Nome</label>
       				<span id="validationnome">
       				<input name="nomerazaobeneficiario" type="text" class="input" maxlength="80" value="${beneficiario.nomeRazaoPessoa}"/>
       				<span class="textfieldRequiredMsg">Digite o Nome.</span></span></div>
         	<div class="field">
         		<label for="cpf">CPF</label>
         			<span id="validationcpf">
                	<input type="text" class="input" name="cpfcnpjbeneficiario" value="${beneficiario.cpfCnpjPessoa}"/>
                	<span class="textfieldRequiredMsg">Digite o CPF.</span><span class="textfieldInvalidFormatMsg">Formato inválido de CPF.</span></span></div>
          	<div class="field">
         		<label for="rg">RG</label>
         			<span id="validationrg">
                	<input type="text" class="input" name="rgiebeneficiario" value="${beneficiario.rgIePessoa}" />
                	<span class="textfieldRequiredMsg">Digite o RG.</span><span class="textfieldInvalidFormatMsg">Formato inválido de RG.</span></span>
          </div> 
          <div class="field">
	 	  <label for="tel">Telefone</label>
	  		  		<span id="validationtel">
    				<input type="text" class="input" name="telefonebeneficiario" placeholder="(00) 0000-0000" value="${beneficiario.telefonePessoa}"/>
    				<span class="textfieldRequiredMsg"> Digite o telefone.</span><span class="textfieldInvalidFormatMsg">Formato inválido de telefone.</span></span>
			</div>
			<div class="field">
    			<label for="rua">Rua</label>
	  		  <span id="validationrua">
    				<input type="text" class="input" name="ruabeneficiario" maxlength="80" value="${beneficiario.ruaPessoa}"/>
    				<span class="textfieldRequiredMsg">Digite a rua.</span></span>
			</div>
            <div class="field">
    			<label for="numero">Número</label>
	  		  		<span id="validationnumero">
    				<input type="text" class="input" name="numerobeneficiario" maxlength="10" value="${beneficiario.numeroPessoa}"/>
    				<span class="textfieldRequiredMsg">Digite o número.</span></span>
			</div>
			<div class="field">
    			<label for="bairro">Bairro</label>
	  		  		<span id="validationbairro">
    				<input type="text" class="input" name="bairrobeneficiario" maxlength="80" value="${beneficiario.bairroPessoa}"/>
    				<span class="textfieldRequiredMsg">Digite o bairro.</span></span>
			</div>
			<div class="field">
    			<label for="complemento">Complemento</label>
	  		  		<span id="validationcomplemento">
    				<input type="text" class="input" name="complementobeneficiario" maxlength="100" value="${beneficiario.complementoPessoa}"/>
			 		 </span>
    				<p class="hint">Digite o Complemento - se tiver</p>
			</div>
			<div class="field">
    			<label for="cidade">Cidade</label>
	  		 	 	<span id="validationcidade">
    				<input type="text" class="input" name="cidadebeneficiario" maxlength="80" value="${beneficiario.cidadePessoa}"/>
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
					<span class="selectRequiredMsg">Selecione um estado.</span></span>
		</div>
		<div class="field">
    			<label for="cep">CEP</label>
		  			<span id="validationcep">
    				<input type="text" class="input" name="cepbeneficiario" value="${beneficiario.cepPessoa}" />
    				<span class="textfieldRequiredMsg">Digite o CEP.</span><span class="textfieldInvalidFormatMsg">Formato de CEP inválido.</span></span>
		</div>
        <div class="field">
		  	<label for="email">Email</label>
		  		<span id="validationemail">
          		<input type="text" class="input" name="emailbeneficiario" maxlength="30" placeholder="exemplo@exemplo.com.br" value="${beneficiario.emailPessoa}"/>
          		<span class="textfieldRequiredMsg">Digite um email.</span><span class="textfieldInvalidFormatMsg">Formato de email inválido.</span></span>
		</div>
		<div class="field">
    			<label for="login">Login</label>
		  			<span id="validationlogin">
    				<input type="text" class="input" name="loginbeneficiario"  maxlength="20" value="${beneficiario.loginPessoa}"/>
    				<span class="textfieldRequiredMsg">Digite um login.</span></span>
   		</div>
		<div class="field">
    			<label for="senha">Senha</label>
		 			 <span id="validationsenha">
    				<input type="password" class="input" name="senhabeneficiario" maxlength="20" value="${beneficiario.senhaPessoa}"/>
    				<span class="textfieldRequiredMsg">Digite a senha.</span></span>
		</div>
        		
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
<!--scripts para validar o formulario-->
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
var sprytextfield3 = new Spry.Widget.ValidationTextField("validationnome", "none", {validateOn:["blur"]});
var sprytextfield12 = new Spry.Widget.ValidationTextField("validationcpf", "custom", {validateOn:["blur"], useCharacterMasking:true, pattern:"000.000.000-00"});
var sprytextfield13 = new Spry.Widget.ValidationTextField("validationrg", "custom", {validateOn:["blur"], useCharacterMasking:true, pattern:"00.000.000-0"});
var sprytextfield14 = new Spry.Widget.ValidationTextField("validationemail", "email", {validateOn:["blur"]});
</script>        
</body>
</html>