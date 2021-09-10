
<html>
    <head>
        <title>TODO supply a title</title>
     <link rel="stylesheet" type="text/css" href="css/estilo.css" media="screen" />
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"> <!?Con esto garantizamos que se vea bien en dispositivos móviles?> 
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> 
   <script src="scripts/ajax.js"></script>
    
    </head>
    <body>
        <h1>IMPORTACION DTE COMPRA</h1>
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th colspan="5">DTE DE COMPRA</th>
            </tr>
            </thead>
            <tr>
                <td>
                  MES  
                </td>  
                <td>
                    <select id="MES">
                        <option value="01">ENERO</option>
                        <option value="02">FEBRERO</option>
                        <option value="03">MARZO</option>
                       <option value="04">ABRIL </option>
                       <option value="05">MAYO</option>
                       <option value="06">JUNIO</option>
                       <option value="07">JULIO</option>
                       <option value="08">AGOSTO</option>
                       <option value="09">SEPTIEMBRE</option>
                       <option value="10">OCTUBRE</option>
                       <option value="11">NOVIEMBRE</option>
                       <option value="12">DICIEMBRE</option>
                    </select>
                </td>
                <td>
                  AÑO 
                </td>  
                <td>
                 <input id="YEAR">
                </td>
                <td><button onclick="cargarAjax('getCompra','ACC=COMPRA&MES='+document.getElementById('MES').value+'&YEAR='+document.getElementById('YEAR').value,'listadocompras');" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-download"></span> Importar RC</button>
                 <button onclick="window.location='index.jsp';" type="button" name="btnLimpiar" class="btn btn-primary btn-sm">
          <span class="glyphicon glyphicon-home"></span>Home 
           </button>
                
                
                </td>
            </tr>  
        </table>
        <div id="listadocompras"></div>  
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </body>
</html>
