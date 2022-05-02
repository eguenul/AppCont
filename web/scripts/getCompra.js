function addCompra(rutproveedor,razproveedor ,tipodoc, fechadoc,foliodoc,montoexento,montoneto, montototal,botonaceptar){
   
    
   

   var parametro = "ACC=COMPRA&CliProvRut=" + rutproveedor + "&TipoDoc="+tipodoc+
                 "&CliProvRaz="+razproveedor+     
                 "&FechaDoc="+fechadoc+"&FolioDoc="+foliodoc+
                 "&MontoExento="+montoexento+"&MontoNeto="+montoneto+
                 "&MontoTotal="+montototal;
              
    cargarAjax('addDTECompra',parametro,'divdocumento');
                detalles = document.getElementById(botonaceptar);
            /*
              detalles.disabled = 'true';
            */     
                  
                 
}


function getCompra(year,mes){
    
 var parametro = "ACC=COMPRA&YEAR="+year+"&MES="+mes;   
  
 cargarAjax('getCompra',parametro,'div_detallecompra');
    
}