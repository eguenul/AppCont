<% 
     String mensaje = (String) request.getSession().getAttribute("MENSAJE");
     request.getSession().setAttribute("MENSAJE",null);
      
%>
<html>
<head>
<meta charset="utf-8"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> <!?Con esto garantizamos que se vea bien en dispositivos móviles?> 
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> 
<link rel="stylesheet" type="text/css" href="css/estilo.css" media="screen" />
</head>
<body>
<div class="alert alert-danger" role="alert">
 NO SE PUEDE CESIONAR ESTE DOCUMENTO
</div>
    <p> <% out.print(mensaje); %>  </p>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    </body>
</html>

