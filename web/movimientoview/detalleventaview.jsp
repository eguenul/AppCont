
<%@page import="getdte.DetalleVenta"%>
<%@page import="appcont.documento.DocumentoModel"%>
<%@page import="java.util.List"%>
<%@page import="getdte.DetalleCompra"%>
<%@page import="java.util.ArrayList"%>
<%
   List<DetalleVenta> arraydetalleventa = (ArrayList<DetalleVenta>) request.getSession().getAttribute("arraydetalleventa");
    ServletContext context = request.getServletContext();
     String pathservlet = context.getRealPath("/");
   DocumentoModel objdocumentomodel = new DocumentoModel(pathservlet);
%>

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
        TIPO COMPRA
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
    
     <th>
       ACCION
    </th>
    </tr>
    <%
        for (DetalleVenta objdetalleventa :  arraydetalleventa){
     %>
     
     <tr>
 
    <td>
        <%  out.print(objdocumentomodel.getNombreDocCodSii(objdetalleventa.getTipo_Doc())); %>
    
        
    </td>
    
     <td>
        <% out.print(objdetalleventa.getFecha_Docto()); %>
    </td>
    
    <td>
   
        <%  out.print(objdetalleventa.getFolio());  %>
    </td>
     <td>
        <% /* out.print(objdetallecompra.getTipo_Compra()); */ %>
        <select>
            <option>IVA DE USO COMUN</option>
             <option>COMPRAS DEL GIRO</option>
            <option>IVA NO RECUPERABLE</option>
           <option>COMPRA DE SUPERMERCADO</option>
        </select>
    </td>
        <td>
      <% out.print(objdetalleventa.getRUT_cliente()); %>
    </td>
    <td>
        <% out.print(objdetalleventa.getRazon_Social()); %>
    </td>
   <!-- <td> -->
        <% /*  out.print(objdetallecompra.getMonto_Exento()); */%>
 <!--   </td> -->
 <!--   <td> -->
          <% /* out.print(objdetallecompra.getMonto_Neto()); */ %>
 <!--   </td> -->
    
 <td>
        <% out.print(objdetalleventa.getMonto_Total());  %>
  
    
 </td>
    <td>
        
        <button class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-ok"></span>Aceptar</button>
   <!--      <button>Rechazar</button> -->
    </td>
    </tr>
    
    <% } %>
    
</table>