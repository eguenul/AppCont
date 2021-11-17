<%@page import="appcont.cuentas.Cuenta"%>
<%@page import="java.util.ArrayList"%>

<% ArrayList<Cuenta> arraylistCuenta = (ArrayList<Cuenta>) request.getSession().getAttribute("arraylistCuenta");
       request.getSession().setAttribute("arraylistCuenta", arraylistCuenta);
 %>   
     <table id="tabla1" class="table table-bordered table-striped">
        <tr>
            <th>PLAN DE CUENTAS</th>          
        </tr>
 <% int x=0; %>
    <%   for(Cuenta i:arraylistCuenta){ 
            int nivelcuenta = 1;
    %> 
    <tr>
 <td  onclick="showAddCuenta('<% out.print(nivelcuenta); %>');"> <% out.print(i.getCuentacod()); %> -  <%  out.print(i.getCuentanom());   %> 
       <% nivelcuenta = nivelcuenta+1; %>
 </td> 
 </tr>
 <tr>
 <td onclick="showAddCuenta('<% out.print(nivelcuenta); %>');">Child node 1</td>
 </tr>      
 <% x++; } %>
  </table>
      
