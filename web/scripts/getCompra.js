function addCompra(rutproveedor,tipodoc, fechadoc,foliodoc,montoexento,montoneto, montototal,botonaceptar){
   
    
   

   var parametro =  "CliProvRut=" + rutproveedor + "&TipoDoc="+tipodoc+
                 "&FechaDoc="+fechadoc+"&FolioDoc="+foliodoc+
                 "&MontoExento="+montoexento+"&MontoNeto="+montoneto+
                 "&MontoTotal="+montototal;
              
    cargarAjax('addDTECompra',parametro,'divdocumento');
                 
                  detalles = document.getElementById(botonaceptar);
                  detalles.disabled = 'true';
                 
                  
                 
}


function getCompra(year,mes){
    
 var parametro = "ACC=COMPRA&YEAR="+year+"&MES="+mes;   
    
    cargarAjax('getCompra',parametro,'div_detallecompra');
    
}