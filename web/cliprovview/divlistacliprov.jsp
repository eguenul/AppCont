<div id="divcliprov" class="modal fade" role="dialog">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">LISTADO CLIENTE PROVEEDOR</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">

              
<table class="table">
       <thead>  
            
<tr>
    <th>CODIGO CLIENTE/PROVEEDOR</th>
    <th>RAZON SOCIAL </th>
    <th>RUT</th>
  </tr>
       </thead>
  <tr>
      <td><input id="CliProvCod2" name="CliProvCod2"  onkeypress="return isNumberKey(event);" onkeyup="if(this.value.length>0){ cargarAjax('cliprov','ACC=BUSQUEDACOD&CliProvCod='+this.value,'contenido');}"></td>
      <td><input id="CliProvRaz2" name="CliProvRaz2" onkeyup="if(this.value.length>0){ cargarAjax('cliprov','ACC=BUSQUEDARAZ&CliProvRaz='+this.value,'contenido');}"></td>
      <td><input id="CliProvRut2" name="CliProvRut2" onkeyup="if(this.value.length>0){ cargarAjax('cliprov','ACC=BUSQUEDARUT&CliProvRut='+this.value,'contenido');}">
         <button onclick="CliProvCod2.value='';CliProvRaz2.value=''; CliProvRut2.value=''; cargarAjax('cliprov','ACC=REFRESH','contenido');" type="button" name="btnRefresh" id="btnRefresh" class="btn btn-primary btn-sm">
            <span class="glyphicon glyphicon-refresh"></span> 
        </button>
      </td>
   
  </tr>
</table>    
<div id="listacliprov">  
    <br>
    <div id="contenido">
     <%@include file="../cliprovview/divlistacliprov2.jsp" %>    
    </div>
</div>

    

<input type="hidden" id="pagina" name="pagina" value="">
</div>
</div>    
</div>
</div>    