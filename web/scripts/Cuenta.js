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
    $(function () {
         $('#listCuentas').modal(toggle)
   });
}

function cargaPagina(acc,pagina){
    parametrolist = "ACC="+acc + "&PAGINA="+pagina;  
    cargarAjax('listCuenta',parametrolist,'listCuentas');

    
}