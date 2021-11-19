 
 
 /*
 $(document).ready(function(){
        $("#btnaddcuenta").click(function(){
        $("#divaddcuenta").modal('show');
        });
    });
*/

function showAddCuenta(parmcodcuenta,parmnivelcuenta){
    auxnivelcuenta = parseInt(parmnivelcuenta)+1;
    document.getElementById('CuentaNivel').value = auxnivelcuenta;  
     document.getElementById('CuentaOrigen').value = parmcodcuenta;  
    $("#divaddcuenta").modal('show');
    auxnivelcuenta = parmnivelcuenta;  
}



function addCuentaBd(){
  if(validaForm()==true){
        
        
        
  }
}

function cierraModal(){
    
    
}

function validaForm(){
    
    
    
    return true;
}



function loadCuentas(){
    
    
    
}