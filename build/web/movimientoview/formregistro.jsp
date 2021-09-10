<%@page import="java.util.List"%>
<%@page import="appcont.documento.Documento"%>
<%@page import="appcont.documento.DocumentoModel"%>
<%@page import="appcont.cliprov.CliProv"%>
<%    DocumentoModel objDocumentoModel = new DocumentoModel();
      List<Documento> arraylistdocumento = objDocumentoModel.listDocuments();
%>     
<% CliProv objcliprov = new CliProv(); %>
<form>
           <table   id="tabla1" class="table table-bordered table-striped">
  
<tr>
<th colspan="4">DATOS CLIENTE/PROVEEDOR</th>
</tr>
<tr>      
      <td colspan="4" align="right">
       
          <button type="button" name="btnLimpiar" onClick="window.location.href='movimiento';" class="btn btn-primary btn-sm">
          <span class="glyphicon glyphicon-file"></span>Nuevo 
           </button>
                     
              <button onclick="window.location='index.jsp';" type="button" name="btnLimpiar" class="btn btn-primary btn-sm">
          <span class="glyphicon glyphicon-home"></span>Home 
           </button>
       
      </td>
    </tr>
    <tr>
      <td>CODIGO CLIENTE/PROVEEDOR</td>
      <td><input readonly="yes" value="<% if(objcliprov.getCliprovcod()==0){out.print(""); }else{   out.print(objcliprov.getCliprovcod());} %>"   name="CliProvCod" type="text" id="CliProvCod"  size="8" maxlength="6">
            <button name="btnListadoCliProv" type="button" id="btnListadoCliProv" data-toggle="modal" data-target="#divcliprov"  class="btn btn-primary btn-sm">
          <span class="glyphicon glyphicon-search"></span>Buscar
        </button>
        
      </td>
      <td>RUT CLIENTE/PROVEEDOR</td>
      <td><input  name="CliProvRut" value="<% out.print(objcliprov.getCliprovrut()); %>"   readonly="yes" type="text" id="CliProvRut" size="8" maxlength="8">
      </td>
    </tr>
    <tr>
      <td>RAZON SOCIAL</td>
      <td><input  readonly="yes" name="CliProvRaz" value="<% out.print(objcliprov.getCliprovraz()); %>"  type="text" id="CliProvRaz"></td>
      <td>GIRO</td>
      <td><input   readonly="yes" name="CliProvGir" value="<% out.print(objcliprov.getCliprovgir()); %>" type="text" id="CliProvGir"></td>
    </tr>
    <tr>
      <td>COMUNA</td>
      <td><input   readonly="yes" name="CliProvCom" value="<% out.print(objcliprov.getCliprovcom()); %>" type="text" id="CliProvCom"></td>
      <td>CIUDAD</td>
      <td><input   readonly="yes" name="CliProvCiu" value="<% out.print(objcliprov.getCliprovciu()); %>" type="text" id="CliProvCiu"></td>
    </tr>
    <tr>
    <td>DIRECCION</td>
    <td><input readonly="yes" name="CliProvdIR" value="<% out.print(objcliprov.getCliprovdir()); %>" type="text" id="CliProvGir"></td>
    <td>FONO</td>
    <td><input  readonly="yes" name="CliProvdIR" value="<% out.print(objcliprov.getCliprovfon()); %>" type="text" id="CliProvGir"></td>
   
    </tr>
    
    <tr>
<th colspan="4">DATOS DEL DOCUMENTO</th>
</tr>
    
    
<tr>
        <td>
            TIPO DE DOCUMENTO
        </td>
                <td><select>
          <%   for(Documento i:arraylistdocumento){
           
                    %> 
            <option value="<%  out.print(i.getIddoc());  %>"><%  out.print(i.getNombredoc());  %></option> 
                <% }   %>
                        
                        
                        
            </select></td>
       
        
         <td>
            NRO DOCUMENTO
        </td>
        <td><input></td>
        
        
</tr>
 <tr>
        <td>
           FECHA DOCUMENTO
        </td>
        <td><input></td>
       
        
         <td>
           &nbsp;
        </td>
        <td>&nbsp;</td>
        
        
</tr>
    
<tr>
    <th colspan="4">
             TOTALES DOCUMENTO
        </th>
        
        
</tr>

<tr> 
    <td>MONTO EXENTO</td>
    <td>MONTO NETO</td>
    <td>IVA</td>
    <td>TOTAL BRUTO</td>
</tr>
<tr> 
    <td><input></td>
    <td><input></td>
    <td><input></td>
    <td><input></td>
</tr>




    
    
           </table>
                <input type="hidden" name="ACC" id="ACC" value="GRABAR">
        </form>
