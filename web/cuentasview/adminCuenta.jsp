<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="scripts/addCuenta.js"></script>
  <script src="scripts/ajax.js"></script>   
  </head>
<body>
    
<nav class="navbar navbar-default">
    
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    
       <div class="nav navbar-nav navbar-left">
           <button   id="btnaddcuenta" type="button" class="btn btn-primary navbar-btn">
          <span class="glyphicon glyphicon-plus"></span>
          Agrega Cuenta
        </button>
       </div>
      
      <div class="nav navbar-nav navbar-left">
        <button type="button" class="btn btn-primary navbar-btn">
          <span class="glyphicon glyphicon-trash"></span>
          Eliminar Cuenta
        </button>
        </div>
 
      <div class="nav navbar-nav navbar-right">
        <button type="button" class="btn btn-primary navbar-btn">
          <span class="glyphicon glyphicon-plus"></span>
          Activiteit toevoegen
        </button>
       </div>
  
  
  </div>
</nav>
  
<div id="listCuentas">     
     <%@include file="../cuentasview/listcuenta.jsp" %>    
</div>
   
   
   
   <%@include file="../cuentasview/addCuenta.jsp" %>    

   </body>
</html>   
