


function validaForm(){
    
    if(document.formcliprov.CliProvRaz.value.length<1){
        alert('DEBE INGRESAR RAZON SOCIAL');
        return false;
    }
    
    
    if(document.formcliprov.CliProvRut.value.length<1){
        alert('DEBE INGRESAR RUT');
        return false;
    }
    
    
    if(document.formcliprov.CliProvGir.value.length<1){
        alert('DEBE INGRESAR GIRO');
        return false;    
    }
    
    
    
    
    if(document.formcliprov.CliProvDir.value.length<1){
        alert('DEBE INGRESAR DIRECCION');
        return false;    
    }
    
    
    if(document.formcliprov.CliProvCom.value.length<1){
        alert('DEBE INGRESAR COMUNA');
        return false;    
    }
    
    
    if(document.formcliprov.CliProvCiu.value.length<1){
        alert('DEBE INGRESAR CIUDAD');
        return false;    
    }
    
    
    if(document.formcliprov.CliProvEma.value.length<1){
        alert('DEBE INGRESAR EMAIL');
        return false;    
    }
    
    
    if(document.formcliprov.CliProvFon.length<1){
        alert('DEBE INGRESAR FONO');
        return false;    
    }
    
    
    return true;
}


function addCliProv(){
    
if(validaForm()==true){
       
       var CliProvRut = document.getElementById('CliProvRut').value; 
       var CliProvRaz = document.getElementById('CliProvRaz').value; 
       var CliProvDir = document.getElementById('CliProvDir').value;
       var CliProvGir = document.getElementById('CliProvGir').value;
       var CliProvCom = document.getElementById('CliProvCom').value;
       var CliProvCiu = document.getElementById('CliProvCiu').value;
       var CliProvFon = document.getElementById('CliProvFon').value;
       var CliProvEma = document.getElementById('CliProvEma').value;
     
       
    var parametro = '';
     parametro = parametro+'CliProvRut='+CliProvRut;
     parametro = parametro+'&CliProvRaz='+CliProvRaz;
     parametro = parametro+'&CliProvDir='+CliProvDir;
     parametro = parametro+'&CliProvGir='+CliProvGir;
     parametro = parametro+'&CliProvCom='+CliProvCom;
     parametro = parametro+'&CliProvCiu='+CliProvCiu;
     parametro = parametro+'&CliProvFon='+CliProvFon;
     parametro = parametro+'&CliProvEma='+CliProvEma;
     parametro = parametro+'&ACC='+'GRABAR';   
        
    cargarAjax('cliprov',parametro,'divform');
}
}





function buscaCliProv(cod){ 
       
   varpost = "CliProvCod="+cod;
   varpost =  varpost+"&ACC="+'BUSCAR';
   cargarAjax('cliprov',varpost,'divcliprov');
    
    
    
    
    
    
    }


function updateCliProv(){
    
    if(validaForm()==true){
       
       var CliProvRut = document.getElementById('CliProvRut').value; 
       var CliProvRaz = document.getElementById('CliProvRaz').value; 
       var CliProvDir = document.getElementById('CliProvDir').value;
       var CliProvGir = document.getElementById('CliProvGir').value;
       var CliProvCom = document.getElementById('CliProvCom').value;
       var CliProvCiu = document.getElementById('CliProvCiu').value;
       var CliProvFon = document.getElementById('CliProvFon').value;
       var CliProvEma = document.getElementById('CliProvEma').value;
       var CliProvCod = document.getElementById('CliProvCod').value;
      
    
    var parametro2 = '';
     parametro2 = 'CliProvCod='+document.getElementById('CliProvCod').value; 
     parametro2 = parametro2+'&CliProvRut='+CliProvRut;
     parametro2 = parametro2+'&CliProvRaz='+CliProvRaz;
     parametro2 = parametro2+'&CliProvDir='+CliProvDir;
     parametro2 = parametro2+'&CliProvGir='+CliProvGir;
     parametro2 = parametro2+'&CliProvCom='+CliProvCom;
     parametro2 = parametro2+'&CliProvCiu='+CliProvCiu;
     parametro2 = parametro2+'&CliProvFon='+CliProvFon;
     parametro2 = parametro2+'&CliProvEma='+CliProvEma;
     parametro2 = parametro2+'&ACC='+'UPDATE';   
      cargarAjax('cliprov',parametro2,'divform');
    }
}
