
<%@page import="appcont.cuentas.Cuenta"%>
<%@page import="java.util.ArrayList"%>

<% ArrayList<Cuenta> arraylistCuenta = (ArrayList<Cuenta>) request.getSession().getAttribute("arraylistCuenta");
       request.getSession().setAttribute("arraylistCuenta", arraylistCuenta);
 %>  
 <div id="listCuentas">  
<div id="botonera1" align="center">
    <button onclick="cargaPagina('ANT','<% out.print(request.getSession().getAttribute("PAGINA")); %>')">ANTERIOR</button>
    <% out.print(request.getSession().getAttribute("PAGINA")); %> de   <% out.print(request.getSession().getAttribute("TOTAL_PAGINAS")); %>
  <button onclick="cargaPagina('SIG','<% out.print(request.getSession().getAttribute("PAGINA")); %>')">SIGUIENTE</button>
  </div> 
     <table id="tabla1" class="table table-bordered table-striped">
        <tr>
            <th colspan="2">PLAN DE CUENTAS</th>          
        </tr>
 
    <%  
        for(Cuenta i:arraylistCuenta){ 
            
    %> 
<tr>
 <td> <% out.print(i.getCuentacod()); %> -  <%  out.print(i.getCuentanom());   %> 
     
 </td> 
 <td align="right">
  
     <button   onclick="btnaddCuenta.disabled=false; btndeleteCuenta.disabled=true; btnUpdateCuenta.disabled=true; showAddCuenta('<% out.print(i.getCuentacod()); %>','<% out.print(i.getCuentanivel()); %>');">Agregar</button>
        <% if(i.getCuentanivel()>1){ %>
     <button onclick="btnaddCuenta.disabled=true; btndeleteCuenta.disabled=true; btnUpdateCuenta.disabled=false;  showAddCuenta('<% out.print(i.getCuentacod()); %>','<% out.print(i.getCuentanivel()); %>');">Actualizar</button>
     <button  onclick="btnaddCuenta.disabled=true; btndeleteCuenta.disabled=false; btnUpdateCuenta.disabled=true;   showAddCuenta('<% out.print(i.getCuentacod()); %>','<% out.print(i.getCuentanivel()); %>');">Eliminar</button>
    <% }else{ %>     
    
    &nbsp;
    <% } %>
 </td>
 </tr>
 <%  } %>
  </table>
  <div id="botonera2" align="center">
  <button  onclick="cargaPagina('ANT','<% out.print(request.getSession().getAttribute("PAGINA")); %>')">ANTERIOR</button>
    <% out.print(request.getSession().getAttribute("PAGINA")); %> de <% out.print(request.getSession().getAttribute("TOTAL_PAGINAS")); %>
  <button onclick="cargaPagina('SIG','<% out.print(request.getSession().getAttribute("PAGINA")); %>')">SIGUIENTE</button>
  </div>
  
  </div>
