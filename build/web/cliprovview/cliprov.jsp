<%-- 
    Document   : cliprov.jsp
    Created on : 25-oct-2018, 10:19:57
    Author     : esteban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/estilo.css" media="screen" />
<meta name="viewport" content="width=device-width, initial-scale=1"> <!?Con esto garantizamos que se vea bien en dispositivos móviles?> 
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> 
<script src="scripts/CliProv.js"> </script>
<script src="scripts/ajax.js"> </script>
<title>MANTENCION CLIENTE PROVEEDOR</title>
</head>
<body>       
<div align="center">  
<h1>MANTENCION CLIENTE PROVEEDOR</h1>     
<div id="divform">
<%@include file="../cliprovview/formcliprov.jsp" %>    
</div>
<%@include file="../cliprovview/divlistacliprov.jsp" %>   
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
 
</div>    
</body>
</html>
