<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    
      <!--
      <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">Page 1</a></li>
      <li><a href="#">Page 2</a></li>
      <li><a href="#">Page 3</a></li>
    </ul>
      -->
       <div class="nav navbar-nav navbar-left">
        <button type="button" class="btn btn-primary navbar-btn"  data-toggle="modal" data-target="#divaddcuenta">
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
  
     <%@include file="../cuentasview/listcuenta.jsp" %>    
    <%@include file="../cuentasview/addCuenta.jsp" %>    
</body>
</html>   
<!--     
        </div>
</div>

    

<input type="hidden" id="pagina" name="pagina" value="">
</div>
</div>    
</div>
</div>    

-->