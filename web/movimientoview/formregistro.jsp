<%@page import="java.util.List"%>
<%@page import="appcont.documento.Documento"%>
<%@page import="appcont.documento.DocumentoModel"%>

<%    DocumentoModel objDocumentoModel = new DocumentoModel();
      List<Documento> arraylistdocumento = objDocumentoModel.listDocuments();
%>     
<form name="formregistro" action="addMovimiento" method="POST">
           <table   id="tabla1" class="table table-bordered table-striped">
  
<tr>
<th colspan="4">DATOS CLIENTE/PROVEEDOR</th>
</tr>
<tr>      
      <td colspan="4" align="right">
       
          <button type="button" name="btnLimpiar" onClick="window.location.href='addMovimiento';" class="btn btn-primary btn-sm">
          <span class="glyphicon glyphicon-file"></span>Nuevo 
           </button>
                     
         <button type="button" name="btnLimpiar" onClick="window.location.href='addMovimiento';" class="btn btn-primary btn-sm">
          <span class="glyphicon glyphicon-floppy-disk"></span>Grabar 
           </button>
                     
       
          
          
          
          
          <button onclick="window.location='index.jsp';" type="button" name="btnHome" class="btn btn-primary btn-sm">
          <span class="glyphicon glyphicon-home"></span>Home 
          </button>
       
             <button onclick="window.location='index.jsp';" type="button" name="btnHome" class="btn btn-primary btn-sm">
          <span class="glyphicon glyphicon-trash"></span>Borrar 
           </button>
          
          
          
      </td>
    </tr>
    <tr>
      <td>CODIGO CLIENTE/PROVEEDOR</td>
      <td><input readonly="yes" value="<% out.print(request.getSession().getAttribute("CliProvCod")); %>"   name="CliProvCod" type="text" id="CliProvCod"  size="8" maxlength="6">
            <button name="btnListadoCliProv" type="button" id="btnListadoCliProv" data-toggle="modal" data-target="#divcliprov"  class="btn btn-primary btn-sm">
          <span class="glyphicon glyphicon-search"></span>Buscar
        </button>
        
      </td>
      <td>RUT CLIENTE/PROVEEDOR</td>
      <td><input  name="CliProvRut" value="<% out.print(request.getSession().getAttribute("CliProvRut")); %>"   readonly="yes" type="text" id="CliProvRut" size="8" maxlength="8">
      </td>
    </tr>
    <tr>
      <td>RAZON SOCIAL</td>
      <td><input  readonly="yes" name="CliProvRaz" value="<% out.print(request.getSession().getAttribute("CliProvRaz")); %>"  type="text" id="CliProvRaz"></td>
      <td>GIRO</td>
      <td><input   readonly="yes" name="CliProvGir" value="<% out.print(request.getSession().getAttribute("CliProvGir")); %>" type="text" id="CliProvGir"></td>
    </tr>
    <tr>
      <td>COMUNA</td>
      <td><input   readonly="yes" name="CliProvCom" value="<% out.print(request.getSession().getAttribute("CliProvCom")); %>" type="text" id="CliProvCom"></td>
      <td>CIUDAD</td>
      <td><input   readonly="yes" name="CliProvCiu" value="<% out.print(request.getSession().getAttribute("CliProvCiu")); %>" type="text" id="CliProvCiu"></td>
    </tr>
    <tr>
    <td>DIRECCION</td>
    <td><input readonly="yes" name="CliProvDir" value="<% out.print(request.getSession().getAttribute("CliProvDir")); %>" type="text" id="CliProvDir"></td>
    <td>FONO</td>
    <td><input  readonly="yes" name="CliProvFon" value="<% out.print(request.getSession().getAttribute("CliProvFon")); %>" type="text" id="CliProvFon"></td>
   
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
        <td><input>
         <button name="btnListadoCliProv" type="button" id="btnListadoCliProv" data-toggle="modal" data-target="#divcliprov"  class="btn btn-primary btn-sm">
          <span class="glyphicon glyphicon-search"></span>Buscar
        </button>
        
        </td>
        
        
</tr>
 <tr>
        <td>
           FECHA DOCUMENTO
        </td>
        <td><input type="date"></td>
       
        
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
