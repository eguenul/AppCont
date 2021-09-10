var parmiddiv
function crearXMLHttpRequest()  //funcion que cre la conexion Ajax ya sea el ActiveXObject o el nativo de Javascript si el primero no está disponible
{
  var xmlHttp=null;
  if (window.ActiveXObject) 
    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP"); //creamos la conexion usando el ActiveXObject
  else 
    if (window.XMLHttpRequest) 
      xmlHttp = new XMLHttpRequest(); //Creamos la conexion nativa de javscript
  return xmlHttp;
}
 function cargarAjax(parmurl, parmvalor,parmdiv)
{ 
   parmiddiv = parmdiv;
    conexion=crearXMLHttpRequest(parmurl,parmvalor); //Creamos el Objeto para manejar Ajax
  
     
     conexion.onreadystatechange = procesarEventos; //Indicamos que función ejecutar cuando se obtiene respuesta del servidor
    conexion.open('POST', parmurl, true); //indicamos como vamos a enviar los datos, en este caso con el metodo GET al archivo meses.php?num= el valor que le indiquemos en el textbox
    //Enviar cabeceras para que acepte POST:
    conexion.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    conexion.setRequestHeader("Content-length", parmvalor.length);
    conexion.setRequestHeader("Connection", "close");
	conexion.send(parmvalor); //Enviamos los datos y esperamos respuesta
}
 function procesarEventos()
{
  var detalles = document.getElementById(parmiddiv); //Obtenemos el control del TAG que contendrá la respuesta
  if(conexion.readyState == 4) //cuando ya obtenemos respuesta = 4
  {
    detalles.innerHTML = conexion.responseText; //ponemos lo que nos respondió meses.php dentro del TAG don el id resultado
  } 
  else 
  {
    detalles.innerHTML = 'Cargando...'; //Mensaje que se mostrará mientras se espera una respuesta
  }
}


function cargarAjaxGet(parmurl, parmdiv)
{ parmiddiv = parmdiv;
    conexion=crearXMLHttpRequest(parmurl); //Creamos el Objeto para manejar Ajax
    conexion.onreadystatechange = procesarEventos; //Indicamos que función ejecutar cuando se obtiene respuesta del servidor
    conexion.open('GET', parmurl, true); //indicamos como vamos a enviar los datos, en este caso con el metodo GET al archivo meses.php?num= el valor que le indiquemos en el textbox
    conexion.send(null);  

}