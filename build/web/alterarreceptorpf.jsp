<%-- 
    Document   : alterarreceptor
    Created on : 03/06/2013, 12:53:19
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Cadastro de Receptor - Siel - Sistema Integrado do E-Lixo</title>
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
        <form id="formpattern" method="post" action="AlterarReceptor">
        	<h2>Alterar Receptor</h3>
                <h1>${sucessoa}</h1>
          		<h4>Tipo Pessoa Física</h4>
                        <input type="checkbox" class="input" name="tiporeceptor" value="fisica" checked style="display:none"/>
	  	  <div class="field">
                      <label for="nome">ID</label>
                        <input type="text" name="idpessoa" readonly="" size="2" value="${receptor.idPessoa}"/> <br>
                  </div>
                        <div class="field">
       			<label for="nome">Nome</label>
       				<span id="validationnome">
       				<input name="nomerazaoreceptor" type="text" class="input" maxlength="80" value="${receptor.nomeRazaoPessoa}"/>
       				<span class="textfieldRequiredMsg">Digite o Nome.</span></span></div>
         	<div class="field">
         		<label for="cpf">CPF</label>
         			<span id="validationcpf">
                	<input type="text" class="input" name="cpfcnpjreceptor" value="${receptor.cpfCnpjPessoa}"/>
                	<span class="textfieldRequiredMsg">Digite o CPF.</span><span class="textfieldInvalidFormatMsg">Formato inválido de CPF.</span></span></div>
          	<div class="field">
         		<label for="rg">RG</label>
         			<span id="validationrg">
                	<input type="text" class="input" name="rgiereceptor" value="${receptor.rgIePessoa}" />
                	<span class="textfieldRequiredMsg">Digite o RG.</span><span class="textfieldInvalidFormatMsg">Formato inválido de RG.</span></span>
          </div> 
	 	  <div class="field">
            <div class="field">
    			<label for="tel">Telefone</label>
	  		  		<span id="validationtel">
    				<input type="text" class="input" name="telefonereceptor" placeholder="(00) 0000-0000" value="${receptor.telefonePessoa}"/>
    				<span class="textfieldRequiredMsg"> Digite o telefone.</span><span class="textfieldInvalidFormatMsg">Formato inválido de telefone.</span></span>
			</div>
			<div class="field">
    			<label for="rua">Rua</label>
	  		  <span id="validationrua">
    				<input type="text" class="input" name="ruareceptor" maxlength="80" value="${receptor.ruaPessoa}"/>
    				<span class="textfieldRequiredMsg">Digite a rua.</span></span>
			</div>
            <div class="field">
    			<label for="numero">Número</label>
	  		  		<span id="validationnumero">
    				<input type="text" class="input" name="numeroreceptor" maxlength="10" value="${receptor.numeroPessoa}"/>
    				<span class="textfieldRequiredMsg">Digite o número.</span></span>
			</div>
			<div class="field">
    			<label for="bairro">Bairro</label>
	  		  		<span id="validationbairro">
    				<input type="text" class="input" name="bairroreceptor" maxlength="80" value="${receptor.bairroPessoa}"/>
    				<span class="textfieldRequiredMsg">Digite o bairro.</span></span>
			</div>
			<div class="field">
    			<label for="complemento">Complemento</label>
	  		  		<span id="validationcomplemento">
    				<input type="text" class="input" name="complementoreceptor" maxlength="100" value="${receptor.complementoPessoa}"/>
			 		 </span>
    				<p class="hint">Digite o Complemento - se tiver</p>
			</div>
			<div class="field">
    			<label for="cidade">Cidade</label>
	  		 	 	<span id="validationcidade">
    				<input type="text" class="input" name="cidadereceptor" maxlength="80" value="${receptor.cidadePessoa}"/>
    				<span class="textfieldRequiredMsg">Digite a cidade.</span></span>
			</div>
		  	<div class="field">
    			<label for="estado">Estado</label>
			  <span id="validationestado">
					<select name="estadoreceptor" class="select">
      					<option value="" selected="">Estado</option>
			  			<option value="sp">São Paulo</option>
			  			<option value="go">Goiás</option>
					</select>
					<span class="selectRequiredMsg">Selecione um estado.</span></span>
		</div>
		<div class="field">
    			<label for="cep">CEP</label>
		  			<span id="validationcep">
    				<input type="text" class="input" name="cepreceptor" value="${receptor.cepPessoa}"/>
    				<span class="textfieldRequiredMsg">Digite o CEP.</span><span class="textfieldInvalidFormatMsg">Formato de CEP inválido.</span></span>
		</div>
        <div class="field">
		  	<label for="email">Email</label>
		  		<span id="validationemail">
          		<input type="text" class="input" name="emailreceptor" maxlength="30" placeholder="exemplo@exemplo.com.br" value="${receptor.emailPessoa}"/>
          		<span class="textfieldRequiredMsg">Digite um email.</span><span class="textfieldInvalidFormatMsg">Formato de email inválido.</span></span>
		</div>
                <div class="field">
		 	 <label for="site">Site</label>
          		 <input type="text" class="input" name="sitereceptor" maxlength="60" value="${receptor.siteReceptor}"/>
		</div>
		<div class="field">
    			<label for="login">Login</label>
		  			<span id="validationlogin">
    				<input type="text" class="input" name="loginreceptor"  maxlength="20" value="${receptor.loginPessoa}"/>
    				<span class="textfieldRequiredMsg">Digite um login.</span></span>
   		</div>
		<div class="field">
    			<label for="senha">Senha</label>
		 			 <span id="validationsenha">
    				<input type="password" class="input" name="senhareceptor" maxlength="20" value="${receptor.senhaPessoa}"/>
    				<span class="textfieldRequiredMsg">Digite a senha.</span></span>
		</div>
        		<input type="hidden" name="atorreceptor" value="R" /><br />
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

