<%@page import="appcont.empresa.Empresa"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<table class="table"> 
    <thead>  
                <tr>  
                    <th>CODIGO</th>  
                    <th>RAZON SOCIAL</th>  
                    <th>RUT</th>                  
    </tr>  
    </thead>  
    <% 
 List<Empresa> empresas = (ArrayList<Empresa>)request.getSession(true).getAttribute("arraylistempresa");
 
    for(Empresa empresa : empresas)
    { %>
    <tr>
        <td onclick="cargarAjax('empresa','ACC=BUSCAR&EmpresaCod=<% out.print(empresa.getEmpresacod()); %>' ,'divform'); $(function () { $('#divlistaempresa').modal('toggle');});"><% out.print(empresa.getEmpresacod()); %></td>   
    <td><% out.print(empresa.getEmpresaraz()); %></td>
 
    <td><% out.print(empresa.getEmpresarut()); %></td>
    </tr>
   <% } %> 
</table>

