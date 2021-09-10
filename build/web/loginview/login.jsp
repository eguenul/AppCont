<%-- 
    Document   : login
    Created on : 30-nov-2018, 15:51:07
    Author     : esteban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> <!?Con esto garantizamos que se vea bien en dispositivos móviles?> 
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> 
<link rel="stylesheet" type="text/css" href="css/estilo.css" media="screen" />        
 <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
        <h1>ACCESO USUARIOS</h1>
        </div>
        <div class="container">
            <div align="center">
            <form name="formlogin" action="login" method="POST">
            <table>
            <th colspan="2">USUARIO</th>
            <tr>
               <td>
                LOGIN   
                </td>
                <td>
                    <input name="login">
                </td>
            </tr>
            <tr>
                <td>
                    PASSWORD
                </td>
                <td>
            <input type="password" name="clave">
                </td>
            </tr>
          </table>
            <button  class="btn btn-primary btn-sm" onclick="document.formlogin.submit();">LOGIN</button>
            <button type="button"  class="btn btn-primary btn-sm" onclick="document.formlogin.reset();">LIMPIAR</button>
        
            </form>
            </div>
       </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
