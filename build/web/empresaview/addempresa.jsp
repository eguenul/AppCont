<html>
<head>
 <meta charset="utf-8"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> <!?Con esto garantizamos que se vea bien en dispositivos móviles?> 
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> 

<link rel="stylesheet" type="text/css" href="css/estilo.css" media="screen" />
<script src="scripts/Empresa.js"></script>    
<script src="scripts/ajax.js"></script>    

</head>
    <body>
   <div id="exTabs2"  class="w3-bar w3-border w3-light-grey  w3-round-xlarge">
  <button class="w3-bar-item w3-button w3-border-right">DATOS GENERALES</button>
   <button class="w3-bar-item w3-button w3-border-right" data-toggle="modal" data-target="#DatosSii">DATOS SII</button>   
</div>
    
        <div align="center">
        <h1>MANTENCION EMPRESAS</h1>
        
        
        
        <div align="center">
            <div id="divform">
        <%@include file="../empresaview/formempresa.jsp" %>    
</div>            
            
 <div id="divlistaempresa" class="modal fade" role="dialog">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">LISTADO EMPPRESA</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">

        <%@include file="../empresaview/listempresa.jsp" %>
          </div>
            
</div>    
</div>
</div>   
                  
            
            
            
            
            
        </div>
        
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>    
</html>
