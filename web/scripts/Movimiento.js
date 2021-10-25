
function addDocumento(){
    
   grabarDoc();
}

function grabarDoc(){
    
    
    
    valorparm = 'ACC=GRABAR&CliProvCod='+document.getElementById('CliProvCod').value+
                '&TipoDoc='+document.getElementById('TipoDoc').value+
                 '&FechaDoc='+document.getElementById('FechaDoc').value+ 
                 '&NumDoc='+document.getElementById('NumDoc').value+ 
                 '&MontoNeto='+document.getElementById('MontoNeto').value+ 
                '&MontoIva='+document.getElementById('MontoIva').value+ 
                '&MontoExento='+document.getElementById('MontoExento').value+ 
                '&MontoTotal='+document.getElementById('MontoTotal').value;    
  alert(valorparm);
    cargarAjax('addMovimiento', valorparm,'divform');
    
}



function validaForm(){
    
    
    
    
}