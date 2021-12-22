function cargaPagina(acc,pagina){
    parametrolist = "ACC="+acc + "&PAGINA="+pagina;  
    cargarAjax('listCuenta',parametrolist,'listCuentas');

    
}
