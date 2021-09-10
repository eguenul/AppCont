
<table>
<tr>
    <th>
        CODIGO    
    </th>
    <th>
        RUT
    </th>
    <th>
        RAZON SOCIAL
    </th>
</tr>
<tr>
    <td>
        <input name="EmpresaCod2" id="EmpresaCod2" onkeypress="return isNumberKey(event);" onkeyup="if(this.value.length>0){ cargarAjax('empresa','ACC=BUSQUEDACOD&EmpresaCod='+this.value,'divempresa2');}">
    </td>
     
      <td>
          <input name="EmpresaRut2" id="EmpresaRut2"  onkeyup="if(this.value.length>0){ cargarAjax('empresa','ACC=BUSQUEDARUT&EmpresaRut='+this.value,'divempresa2');}" >
    </td>
      <td>
          <input name="EmpresaRaz2" id="EmpresaRaz2" onkeyup="if(this.value.length>0){ cargarAjax('empresa','ACC=BUSQUEDARAZ&EmpresaRaz='+this.value,'divempresa2');}">
           <button onclick="EmpresaCod2.value='';EmpresaRaz2.value=''; EmpresaRut2.value=''; cargarAjax('empresa','ACC=LISTADO','divempresa2');" type="button" name="btnRefresh" id="btnRefresh" class="btn btn-primary btn-sm">
            <span class="glyphicon glyphicon-refresh"></span> 
        </button>   
    </td>  
</tr>    
</table>
<div id="divempresa2">
<%@include file="../empresaview/listempresa2.jsp" %>
</div>