
<%@page import="java.util.List"%>
<%@page import="appcont.cliprov.CliProv"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<table class="table"> 
    <thead>  
                <tr>  
                    <th>CODIGO CLIENTE PROVEEDOR</th>  
                    <th>RAZON SOCIAL</th>  
                    <th>RUT</th>                  
    </tr>  
    </thead>  
    <% 

 List<CliProv> cliprovs = (ArrayList<CliProv>)request.getSession(true).getAttribute("arraylistcliprov");
 
    for(CliProv cliprov : cliprovs)
    { %>
    <% 
    if(   request.getSession().getAttribute("modulo")=="addMovimiento"){
    %>
    <tr>
        <td onclick="ACC.value='BUSCAR'; CliProvCod.value='<% out.print(cliprov.getCliprovcod()); %>'; document.formregistro.submit();"  ><% out.print(cliprov.getCliprovcod()); %></td>   
    <td><% out.print(cliprov.getCliprovraz()); %></td>
 
    <td><% out.print(cliprov.getCliprovrut()); %></td>
    </tr>
   <% }
    if(request.getSession().getAttribute("modulo")=="cesion"){
    %>
    <tr>
        <td onclick="ACC.value='BUSCAR'; CliProvCod.value='<% out.print(cliprov.getCliprovcod()); %>'; document.getElementById('formcesion').submit();"  ><% out.print(cliprov.getCliprovcod()); %></td>   
    <td><% out.print(cliprov.getCliprovraz()); %></td>
 
    <td><% out.print(cliprov.getCliprovrut()); %></td>
    </tr>
   <% } %> 
   
  <%   if(request.getSession().getAttribute("modulo")=="cliprov"){
    %>
    <tr>
        <td onclick="ACC.value='BUSCAR'; CliProvCod.value='<% out.print(cliprov.getCliprovcod()); %>'; document.getElementById('formcliprov').submit();""><% out.print(cliprov.getCliprovcod()); %></td>   
    <td><% out.print(cliprov.getCliprovraz()); %></td>
 
    <td><% out.print(cliprov.getCliprovrut()); %></td>
    </tr>
   <% } %> 
   
   
   
   
  <%   
   }
 %> 
</table>
