<%@page import="java.util.List"%>
<%@page import="appcont.documento.Documento"%>
<%@page import="appcont.documento.DocumentoModel"%>

<%    
    ServletContext context = request.getServletContext();
         String pathservlet = context.getRealPath("/");
    
    DocumentoModel objDocumentoModel = new DocumentoModel(pathservlet);
      List<Documento> arraylistdocumento = objDocumentoModel.listDocuments();
      String estadodoc = (String) request.getSession().getAttribute("ESTADODOC");



if(estadodoc=="OK"){ %>
<div aligin="center">
 <div class="alert alert-success">
  <strong>OPERACION REALIZADA</strong> DOCUMENTO AGREGADO.
</div>

</div>
<%    request.getSession().setAttribute("ESTADODOC",null); }
%>     

<ul class="nav nav-tabs">
  <li class="active"><a data-toggle="tab" href="#home">DATOS GENERALES</a></li>
  <li><a data-toggle="tab" href="#menu1">INFORMACION GLOSA</a></li>
  <li><a data-toggle="tab" href="#menu2">Menu 2</a></li>
</ul>


<div class="tab-content">
  <div id="home" class="tab-pane fade in active">
    
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
                     
         <button type="button" name="btnLimpiar" onClick="addDocumento();" class="btn btn-primary btn-sm">
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
                <td><select name="TipoDoc" id="TipoDoc">
          <%   for(Documento i:arraylistdocumento){
           
                    %> 
            <option value="<%  out.print(i.getIddoc());  %>"><%  out.print(i.getNombredoc());  %></option> 
                <% }   %>
                        
                        
                        
            </select></td>
       
        
         <td>
            NRO DOCUMENTO
        </td>
        <td><input size="8" name="NumDoc" id="NumDoc">
         <button name="btnsearchDoc" type="button" id="btnsearchDoc" data-toggle="modal" data-target="#divsearchdoc"  class="btn btn-primary btn-sm">
          <span class="glyphicon glyphicon-search"></span>Buscar
        </button>
        
        </td>
        
        
</tr>
 <tr>
        <td>
           FECHA DOCUMENTO
        </td>
        <td><input size="8" name="FechaDoc" id="FechaDoc" type="date"></td>
       
        
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
    <td>MONTO TOTAL</td>
</tr>
<tr> 
    <td><input size="8" name="MontoExento" id="MontoExento"></td>
    <td><input size="8" name="MontoNeto" id="MontoNeto"></td>
    <td><input size="8" name=MontoIva" id="MontoIva"></td>
    <td><input size="8" name="MontoTotal" id="MontoTotal"></td>
</tr>




    
    
           </table>
                <input type="hidden" name="ACC" id="ACC" value="GRABAR">
        </form>
 </div>
  <div id="menu1" class="tab-pane fade">
        <table>
        <tr>
            <td>
            GLOSA
            </td>
        </tr>
     <tr>
            <td>
                <input>
            </td>
        </tr>
     
      
    </table>
  
  
  
  
  </div>
  <div id="menu2" class="tab-pane fade">
    <h3>Menu 2</h3>
    <p>Some content in menu 2.</p>
  </div>
</div>






