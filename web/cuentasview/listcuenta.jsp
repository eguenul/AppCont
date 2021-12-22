
<%@page import="appcont.cuentas.Cuenta"%>
<%@page import="java.util.ArrayList"%>

<% ArrayList<Cuenta> arraylistCuenta = (ArrayList<Cuenta>) request.getSession().getAttribute("arraylistCuenta");
       request.getSession().setAttribute("arraylistCuenta", arraylistCuenta);
 %>  
<div id="botonera1" align="center">
    <button onclick="cargaPagina('ANT','<% out.print(request.getSession().getAttribute("PAGINA")); %>')">ANTERIOR</button>
    <% out.print(request.getSession().getAttribute("PAGINA")); %> de   <% out.print(request.getSession().getAttribute("TOTAL_PAGINAS")); %>
  <button onclick="cargaPagina('SIG','<% out.print(request.getSession().getAttribute("PAGINA")); %>')">SIGUIENTE</button>
  </div> 
     <table id="tabla1" class="table table-bordered table-striped">
        <tr>
            <th>PLAN DE CUENTAS</th>          
        </tr>
 
    <%  
        for(Cuenta i:arraylistCuenta){ 
            
    %> 
<tr>
 <td  onclick="showAddCuenta('<% out.print(i.getCuentacod()); %>','<% out.print(i.getCuentanivel()); %>');"> <% out.print(i.getCuentacod()); %> -  <%  out.print(i.getCuentanom());   %> 
     
 </td> 
 </tr>
 <%  } %>
  </table>
  <div id="botonera2" align="center">
  <button  onclick="cargaPagina('ANT','<% out.print(request.getSession().getAttribute("PAGINA")); %>')">ANTERIOR</button>
    <% out.print(request.getSession().getAttribute("PAGINA")); %> de <% out.print(request.getSession().getAttribute("TOTAL_PAGINAS")); %>
  <button onclick="cargaPagina('SIG','<% out.print(request.getSession().getAttribute("PAGINA")); %>')">SIGUIENTE</button>
  </div>
  
  