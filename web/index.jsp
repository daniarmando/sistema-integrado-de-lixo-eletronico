<%-- 
    Document   : index
    Created on : 12/05/2013, 15:22:55
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/styles.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>--SIEL--</title>
    </head>
    <body>
    <div id="logotop">
       <img src="images/logo1.png" alt="siel" width="243" height="335"/>
      
        </div>
   
            
         
          <!-- Begin Page Content -->
 
    <div id="container">
 
        <form name="logarpessoa" action="LogarUsuario" method="POST">
         
             <label>Login: </label>
             <input type="text" name="login"  maxlength="20" />
 
            <label>Senha: </label>
 
           
 
             <input type="password" name="senha" maxlength="20" />
  <!--<p><a href="#">Forgot your password?</a></p>-->
            <div id="lower">
 
                <p><a href="cadastrarusuario.jsp">Cadastrar-me</a></p><!--<input type="checkbox"><label class="check" for="checkbox">Keep me logged in</label>-->
 
                 <input type="hidden" name="acao" value="logar" />
                <input type="submit" value="Entrar" name="logar" />
                
 
            </div><!--/ lower-->
 
        </form>
 
    </div><!--/ container--><br >
   
   <!-- ${mensagem}--><h3 align="center"></h3>
		    
    	<h1 align="center"></font><font class="descricao1">faça</font> Coleta, <font class="descricao1">faça</font> Doação, <font class="descricao1">faça</font> Sustentabilidade.</font></h1>

    </body>
</html>
