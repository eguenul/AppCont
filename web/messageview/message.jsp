<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String titulo =(String) request.getSession(true).getAttribute("titulo");
   String mensaje =(String) request.getSession(true).getAttribute("mensaje");
   String flag_estado = (String) request.getSession(true).getAttribute("estado"); 
%>   
<!DOCTYPE html>
<html>
<head>       
<meta charset="utf-8"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> <!?Con esto garantizamos que se vea bien en dispositivos móviles?> 
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title><% out.print(titulo); %></title>
</head>
<body>
<div <% if(flag_estado=="OK"){  out.print("class=\"alert alert-success\"");  } %><% if(flag_estado=="ERROR"){  out.print("class=\"alert alert-danger\"");  } %>>
    <strong><% out.print(titulo); %> </strong> <% out.print(mensaje); %>. <a <% if(flag_estado=="ERROR"){ %> onclick="window.history.back();"  href="#" <% }else{ %> href="../<% out.print(request.getSession(true).getAttribute("link")); %>"  <% } %> class="btn btn-primary" role="button">Volver</a>
</div>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>