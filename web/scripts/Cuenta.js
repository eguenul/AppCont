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
     cerrarModal();   
}

function cerrarModal(){
    $(function () {
         $('#listCuentas').modal(toggle)
   });
    
}



function showUpdateCuenta(parmcodcuenta,parmcuentades,origen,parmnivelcuenta,cuentaid){
    document.getElementById('CuentaNivel').value = parmnivelcuenta;  
    document.getElementById('CuentaCod').value = parmcodcuenta;
    document.getElementById('CuentaDes').value = parmcuentades;
    document.getElementById('CuentaPadre').value = origen;
   
    $("#divaddcuenta").modal('show');
    auxnivelcuenta = parmnivelcuenta;  
}


function updateCuenta(){
    
    
    
}



function showDeleteCuenta(parmcodcuenta,parmcuentades,origen,parmnivelcuenta,cuentaid){
   document.getElementById('CuentaNivel').value = parmnivelcuenta;  
    document.getElementById('CuentaCod').value = parmcodcuenta;
    document.getElementById('CuentaDes').value = parmcuentades;
    document.getElementById('CuentaPadre').value = origen;
    var parametro = "CuentaCod="+document.getElementById('CuentaCod').value;
    cargarAjax('deleteCuenta',parametro,'listCuentas');
    cerrarModal();
}

function deleteCeunta(){
    
    
}