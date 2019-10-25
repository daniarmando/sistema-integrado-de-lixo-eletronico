<%-- 
    Document   : cadastrarbeneficiariopf
    Created on : 19/05/2013, 15:59:09
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Cadastro de Solicitante - Siel - Sistema Integrado do E-Lixo</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<!--css para validar formulario-->
<link href="SpryAssets/SpryValidationTextField.css" rel="stylesheet" type="text/css">
<link href="SpryAssets/SpryValidationSelect.css" rel="stylesheet" type="text/css">
<!--scripts para validar formulario-->
<script src="SpryAssets/SpryValidationTextField.js" type="text/javascript"></script>
<script src="SpryAssets/SpryValidationSelect.js" type="text/javascript"></script>
</head>
<body>

<!--inicio da conteudo-->
<div id="content">
  
		<!--formulario cadastrar beneficiario pessoa fisica-->        
        <form id="formpattern" method="post" action="CadastrarSolicitante">
        	 <h2 align="center">Digite as informações do Solicitante</h2><hr>
       				
         	<div class="field">
            		<input type="checkbox" class="input" name="tiposolicitante" value="fisica" checked style="display:none"/>
                </div>        
	  	  <div class="field">
       			<label for="nome">Nome</label>
       				<span id="validationnome">
       				<input name="nomerazaosolicitante" type="text" class="input" maxlength="80" />
       				<span class="textfieldRequiredMsg">Digite o Nome.</span></span>
                  </div>
         	<div class="field">
         		<label for="cpf">CPF</label>
         			<span id="validationcpf">
                	<input type="text" class="input" name="cpfcnpjsolicitante"/>
                	<span class="textfieldRequiredMsg">Digite o CPF.</span><span class="textfieldInvalidFormatMsg">Formato inválido de CPF.</span></span>
                </div>
          	<div class="field">
         		<label for="rg">RG</label>
         			<span id="validationrg">
                	<input type="text" class="input" name="rgiesolicitante"  />
                	<span class="textfieldRequiredMsg">Digite o RG.</span><span class="textfieldInvalidFormatMsg">Formato inválido de RG.</span></span>
          </div> 
          <div class="field">
	 	  <label for="tel">Telefone</label>
	  		  		<span id="validationtel">
    				<input type="text" class="input" name="telefonesolicitante" placeholder="(00) 0000-0000"/>
    				<span class="textfieldRequiredMsg"> Digite o telefone.</span><span class="textfieldInvalidFormatMsg">Formato inválido de telefone.</span></span>
		  </div>
			<div class="field">
    			<label for="rua">Rua</label>
	  		  <span id="validationrua">
    				<input type="text" class="input" name="ruasolicitante" maxlength="80" />
    				<span class="textfieldRequiredMsg">Digite a rua.</span></span>
			</div>
            <div class="field">
    			<label for="numero">Número</label>
	  		  		<span id="validationnumero">
    				<input type="text" class="input" name="numerosolicitante" maxlength="10" />
    				<span class="textfieldRequiredMsg">Digite o número.</span></span>
			</div>
			<div class="field">
    			<label for="bairro">Bairro</label>
	  		  		<span id="validationbairro">
    				<input type="text" class="input" name="bairrosolicitante" maxlength="80" />
    				<span class="textfieldRequiredMsg">Digite o bairro.</span></span>
			</div>
			<div class="field">
    			<label for="complemento">Complemento</label>
	  		  		<span id="validationcomplemento">
    				<input type="text" class="input" name="complementosolicitante" maxlength="100" />
			 		 </span>
    				<p class="hint">Digite o Complemento - se tiver</p>
			</div>
			<div class="field">
    			<label for="cidade">Cidade</label>
	  		 	 	<span id="validationcidade">
    				<input type="text" class="input" name="cidadesolicitante" maxlength="80" />
    				<span class="textfieldRequiredMsg">Digite a cidade.</span></span>
			</div>
		  	<div class="field">
    			<label for="estado">Estado</label>
			  <span id="validationestado">
					<select name="estadosolicitante" class="select">
      					<option value="" selected="">Estado</option>
			  			<option value="sp">São Paulo</option>
			  			<option value="go">Goiás</option>
					</select>
					<span class="selectRequiredMsg">Selecione um estado.</span></span>
		</div>
		<div class="field">
    			<label for="cep">CEP</label>
		  			<span id="validationcep">
    				<input type="text" class="input" name="cepsolicitante" />
    				<span class="textfieldRequiredMsg">Digite o CEP.</span><span class="textfieldInvalidFormatMsg">Formato de CEP inválido.</span></span>
		</div>
        <div class="field">
		  	<label for="email">Email</label>
		  		<span id="validationemail">
          		<input type="text" class="input" name="emailsolicitante" maxlength="30" placeholder="exemplo@exemplo.com.br" />
          		<span class="textfieldRequiredMsg">Digite um email.</span><span class="textfieldInvalidFormatMsg">Formato de email inválido.</span></span>
		</div>
		<div class="field">
    			<label for="login">Login</label>
		  			<span id="validationlogin">
    				<input type="text" class="input" name="loginsolicitante"  maxlength="20"/>
    				<span class="textfieldRequiredMsg">Digite um login.</span></span>
   		</div>
		<div class="field">
    			<label for="senha">Senha</label>
		 			 <span id="validationsenha">
    				<input type="password" class="input" name="senhasolicitante" maxlength="20"/>
    				<span class="textfieldRequiredMsg">Digite a senha.</span></span>
		</div>
        		<input type="hidden" name="atorsolicitante" value="S" /><br />
         	        <input type="submit" name="Submit"  class="button" value="Cadastrar" />
                        <input type="reset" name="btreset" class="button" value="Limpar"/>
       
		</form>
        
</div>
<!--fim da conteudo-->
<!--inicio rodape da pagina-->
<div id="footer"><table id="tblefooter" align="center" >
        <tr>	
           <td></td>
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
