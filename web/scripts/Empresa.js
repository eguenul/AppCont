




function grabarEmpresa(){
	
	var Rut;
	var RazonSocial;
	var Giro;
	var Direccion;
	var Fono;
	var Ciudad;
	var Email;
	var RutRep;
	var NomRep;
	var parametro;
	var Digitov;
	var Comuna;
        
	/*
	 Codigo = document.getElementById('EmpresaCod').value;
	*/
	
        
 if(validaForm()==true){       
        parametro = '';
        Rut = document.getElementById('EmpresaRut').value;
	RazonSocial = document.getElementById('EmpresaRaz').value;
	Giro = document.getElementById('EmpresaGir').value;
	Direccion = document.getElementById('EmpresaDir').value;
	Fono = document.getElementById('EmpresaFon').value;
	Ciudad =  document.getElementById('EmpresaCiu').value;
	Email = document.getElementById('EmpresaEma').value;
	Comuna = document.getElementById('EmpresaCom').value;
	parametro = parametro+"EmpresaRut="+Rut;
	parametro = parametro+"&EmpresaCom="+Comuna;
	parametro = parametro+"&EmpresaRaz="+RazonSocial;
        parametro = parametro+"&EmpresaGir="+Giro;
        parametro = parametro+"&EmpresaDir="+Direccion;
        parametro = parametro+"&EmpresaFon="+Fono;
	parametro = parametro+"&EmpresaCiu="+Ciudad;
        parametro = parametro+"&EmpresaEma="+Email;
        parametro = parametro+"&FechResol="+document.getElementById("FechResol").value;
        parametro = parametro+"&ResolSii="+document.getElementById("ResolSii").value;
        parametro = parametro+"&ActEco="+document.getElementById("ActEco").value;
        parametro = parametro+"&OficinaSii="+document.getElementById('OficinaSii').value;
         parametro = parametro+"&SucurSiiCod="+document.getElementById('SucurSiiCod').value;
        
        if(document.getElementById('ACC').value=="UPDATE"){
            parametro = parametro+"&EmpresaCod="+document.getElementById('EmpresaCod').value;
        }
        parametro = parametro+"&ACC="+ document.getElementById("ACC").value;
	cargarAjax('empresa',parametro,'divform');
        
    }
}

function buscaEmpresa(){
    var empresacod = document.getElementById('EmpresaCod').value;
    parametro = "EmpresaCod="+empresacod;
    parametro = parametro+"&ACC="+'BUSCAR';
    cargarAjax('empresa',parametro,'divform');
}


function validaForm(){
    
  if( document.getElementById('EmpresaRut').value.length<1){
      alert('DEBE INGRESAR RUT EMPRESA');
      return false;
  }
  
  if(document.getElementById('EmpresaRaz').value.length<1){
      alert('DEBE INGRESAR RAZON SOCIAL');
      return false;
  }
  if(document.getElementById('EmpresaGir').value.length<1){
      alert('DEBE INGRESAR GIRO');
     return false;
  }
   if(document.getElementById('EmpresaDir').value.length<1){
       alert('DEBE INGRESAR DIRECCION');
       return false;
   }
    if(   document.getElementById('EmpresaFon').value.length<1){
        alert('DEBE INGRESAR FONO');
        return false;
    }
	if(document.getElementById('EmpresaCiu').value.length<1){
            alert('DEBE INGRESAR CIUDAD');
            return false;
        }
	
      if(document.getElementById('EmpresaEma').value.length<1){
          alert('DEBE INGRESAR EMIAL');
          return false;
      }
      if(document.getElementById('EmpresaCom').value.length<1){
          alert('DEBE INGRESAR COMUNA');
          return false;
      }
	
        
      if(document.getElementById('ResolSii').value.length<1){
          alert('DEBE INGRESAR RESOLUCION SII');
          return false;
      }
        
        
        
        if(document.getElementById('FechResol').value.length<1){
          alert('DEBE INGRESAR FECHA RESOLUCION SII');
          return false;
      }

    
   
    
    
    if(document.getElementById('SucurSiiCod').value.length<1){
          alert('Debe ingresar Código Sucursal SII');
          return false;
      }
      
      
     if(document.getElementById("ActEco").value.length<1){
         alert('Debe ingresar código de actividad economica');
          return false;
         
     }
        
        return true;
}