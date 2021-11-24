
<%@page import="appcont.cuentas.Cuenta"%>
<%@page import="java.util.ArrayList"%>

<% ArrayList<Cuenta> arraylistCuenta = (ArrayList<Cuenta>) request.getSession().getAttribute("arraylistCuenta");
       request.getSession().setAttribute("arraylistCuenta", arraylistCuenta);
 %>   
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
      