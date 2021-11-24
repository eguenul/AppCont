 
 
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
     document.getElementById('CuentaPadre').value = parmcodcuenta;  
    $("#divaddcuenta").modal('show');
    auxnivelcuenta = parmnivelcuenta;  
}



function addCuentaBd(){
     var cuentanivel = document.getElementById('CuentaNivel').value;
     var cuentades = document.getElementById('CuentaDes').value;
     var cuentapadre = document.getElementById('CuentaPadre').value;
     var parametro = "CuentaNivel="+cuentanivel+"&CuentaDes="+cuentades+"&CuentaPadre="+cuentapadre;
    alert(parametro); 
    cargarAjax('addCuenta',parametro,'listCuentas');
}

function cierraModal(){
    
    
}

function validaForm(){
    
    
    
    return true;
}



function loadCuentas(){
    
    
    
}