<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="appcont.empresa.Empresa"%>
<% List<Empresa> empresas = (ArrayList<Empresa>) request.getSession().getAttribute("arraylistempresa");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">      
<meta name="viewport" content="width=device-width, initial-scale=1"> <!?Con esto garantizamos que se vea bien en dispositivos móviles?> 
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> 
<link rel="stylesheet" type="text/css" href="css/estilo.css" media="screen" />
      
<title>SELECCION EMPRESA</title>
</head>
<body>
        <div align="center">
        <h1>SELECCION EMPRESA</h1>
        <form method="POST" action="empresa2">
        <table>
            <tr>
            <th colspan="3">
               DATOS GENERALES 
            </th>
            </tr>
            <tr>
            <td>
                RAZON SOCIAL
            </td>
            <td>
                <select  class="style-select" name="EmpresaId">
                  <%
                     for(Empresa empresa:empresas){
                  %>
                  <option value="<% out.print(empresa.getEmpresaid()); %>"><% out.print(empresa.getEmpresaraz()); %></option>
                  <%} %>  
                </select>
                <button  name="btnLimpiar" class="btn btn-primary btn-sm">
          <span class="glyphicon glyphicon-ok"></span>Seleccionar 
           </button>     
          <button type="button" onclick="window.location='empresa';"  name="btnCrea" class="btn btn-primary btn-sm">
          <span class="glyphicon glyphicon-file"></span>Nuevo 
           </button>
          </td>
        </tr>
        </table>
        </form>
        </div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </body>
</html>
