<%@page import="appcont.documento.DocumentoModel"%>
<%@page import="java.util.List"%>
<%@page import="com.sii.utilidades.DetalleCompra"%>
<%@page import="java.util.ArrayList"%>
<%
   List<DetalleCompra> arraydetallecompra = (ArrayList<DetalleCompra>) request.getSession().getAttribute("arraydetallecompra");
   DocumentoModel objdocumentomodel = new DocumentoModel();
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
    
    <!--
     <th>
       MONTO EXENTO
    </th> <th>
      MONTO NETO
    </th>
    
   --> 
    
    <th>
      MONTO TOTAL
    </th>
    
     <th>
       ACCION
    </th>
    </tr>
    <%
        for (DetalleCompra objdetallecompra :  arraydetallecompra){
     %>
     
     <tr>
 
    <td>
        <%  out.print(objdocumentomodel.getNombreDocCodSii(objdetallecompra.getTipo_Doc())); %>
    
        
    </td>
    
     <td>
        <% out.print(objdetallecompra.getFecha_Docto()); %>
    </td>
    
    <td>
   
        <%  out.print(objdetallecompra.getFolio());  %>
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
        
        <button class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-ok"></span>Aceptar</button>
   <!--      <button>Rechazar</button> -->
    </td>
    </tr>
    
    <% } %>
    
</table>