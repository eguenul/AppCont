<div id="divaddcuenta" class="modal fade" role="dialog">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">ADMINISTRACION DE CUENTAS</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">

   
<table class="table table-bordered table-striped">
    <tr>
        <th colspan="2">
        DATOS CUENTA
        </th>
    </tr>
    
    
    
    <tr>
    <td align="right" colspan="2">
        <button  id="btnaddCuenta" onclick="addCuentaBd();">Grabar Cuenta</button>
    <button   id="btnUpdateCuenta" onclick="addCuentaBd();">Actualizar Cuenta</button>
    <button   id="btndeleteCuenta" onclick="addCuentaBd();">Eliminar Cuenta</button>
    </td> 
    </tr>     
        
   
    <tr>
        <td>
            CODIGO            
        </td>
        <td>
            <input readonly="yes" id="CuentaCod">     
         </td>
    </tr>
    
    <tr>
        <td>
            NOMBRE            
        </td>
        <td>
            <input id="CuentaDes">     
         </td>
</tr>

    <tr>
        <td>
            NIVEL            
        </td>
        <td>
            <input readonly="yes" id="CuentaNivel">     
         </td>
</tr>

    <tr>
        <td>
            CUENTA ORIGEN            
        </td>
        <td>
            <input readonly="yes" id="CuentaPadre">     
         </td>
</tr>



</table>    
</div>
</div>    
</div>
</div>   

