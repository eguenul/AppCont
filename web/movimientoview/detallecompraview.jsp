<%@page import="getdte.DetalleCompra"%>
<%@page import="appcont.documento.DocumentoModel"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
   List<DetalleCompra> arraydetallecompra = (ArrayList<DetalleCompra>) request.getSession().getAttribute("arraydetallecompra");
   
   
     ServletContext context = request.getServletContext();
     String pathservlet = context.getRealPath("/");
     DocumentoModel objdocumentomodel = new DocumentoModel(pathservlet);
     

%>
<div id="documento">
    
</div>
<table  class="table table-bordered table-striped">
    <tr>
  
    <th>
        TIPO DOCUMENTO
    </th>
    <th>
       FECHA DOCUMENTO
    </th>
    <th>
      FOLIO
    </th>
     <th>
       RUT PROVEEDOR
    </th>
     <th>
       RAZON SOCIAL
    </th>
    
        <th>
        MONTO TOTAL
    </th>
   
    
    <!--
     <th>
       MONTO EXENTO
    </th> <th>
      MONTO NETO
    </th>
    
   --> 
    
    <th>
      ACCION
    </th>
    
    <th>
      ESTADO
    </th>
    
    
    <!--
     <th>
       ACCION
    </th>
    
    -->
    </tr>
    <%
        int i=0;
        for (DetalleCompra objdetallecompra :  arraydetallecompra){
     %>
     
     <tr>
 
    <td>
        <%   out.print(objdocumentomodel.getNombreDocCodSii(objdetallecompra.getTipo_Doc()));  %>
    
        
    </td>
    
     <td>
        <% out.print(objdetallecompra.getFecha_Docto()); %>
    </td>
    
    <td>
   
        <%  out.print(objdetallecompra.getFolio());  %>
    </td>
    <!--
     <td>
        <% /* out.print(objdetallecompra.getTipo_Compra()); */ %>
        <select>
            <option>IVA DE USO COMUN</option>
             <option>COMPRAS DEL GIRO</option>
            <option>IVA NO RECUPERABLE</option>
           <option>COMPRA DE SUPERMERCADO</option>
        </select>
    -->
     </td>
        <td>
      <% out.print(objdetallecompra.getRUT_Proveedor()); %>
    </td>
     <td>
      <% out.print(objdetallecompra.getRazon_Social()); %>
    </td>
    
   <!-- <td> -->
        <% /*  out.print(objdetallecompra.getMonto_Exento()); */%>
 <!--   </td> -->
 <!--   <td> -->
          <% /* out.print(objdetallecompra.getMonto_Neto()); */ %>
 <!--   </td> -->
    
 <td>
        <% out.print(objdetallecompra.getMonto_Total());  %>
  
    
 </td>
    <td>
        
        
        <button  id="botonaceptar<% out.print(i); %>"   onclick="addCompra('<% out.print( objdetallecompra.getRUT_Proveedor()); %>','<% out.print( objdetallecompra.getTipo_Doc()); %>','<% out.print( objdetallecompra.getFecha_Docto()); %>','<% out.print( objdetallecompra.getFolio()); %>' ,'<% out.print( objdetallecompra.getMonto_Exento()); %>','<% out.print( objdetallecompra.getMonto_Neto()); %>', '<% out.print( objdetallecompra.getMonto_Iva_No_Recuperable()); %>' ,'botonaceptar'+<% out.print(i); %>);" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-ok"></span>Aceptar</button>
        
            <!--
        <button class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-remove"></span>Rechazar</button>
   -->
        <!--      <button>Rechazar</button> -->
    </td>
    <td>
        PENDIENTE
    </td>
    </tr>
   <% i++; %>
    <% } %>
    
</table>
    <input type="hidden" id="empresaid" value="<% out.print(request.getSession().getAttribute("empresaid")); %>">