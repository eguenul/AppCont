<%-- 
    Document   : index
    Created on : 16-oct-2018, 10:50:57
    Author     : esteban
--%>
<%@page import="appcont.empresa.Empresa"%>
<%
if(request.getSession().getAttribute("loginauth")==null){
         request.getRequestDispatcher("login").forward(request, response); 
}

if(request.getSession().getAttribute("empresaid")==null){
         request.getRequestDispatcher("selempresa").forward(request, response); 
}
Empresa objEmpresa = (Empresa) request.getSession().getAttribute("Empresa");


if(objEmpresa.getEmpresaid()==0){
    request.getRequestDispatcher("selempresa").forward(request, response); 
}
%>
 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>    
<meta charset="utf-8"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> <!?Con esto garantizamos que se vea bien en dispositivos móviles?> 
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> 
<link rel="stylesheet" type="text/css" href="css/estilo.css" media="screen" />
<title>APPCONT</title>
    </head>
    <body>
<nav class="navbar navbar-default" role="navigation">
<div  class="navbar-header">
    <!-- <a class="navbar-brand" href="#">WebSiteName</a>  -->
   <!--  <a class="navbar-brand" href="#"><img src="../static/img/logo2.jpg" style="margin-top:-15px; margin-left: -15px;"></a>
 -->
    </div>
 
  
  <div class="collapse navbar-collapse navbar-ex1-collapse">
    <ul class="nav navbar-nav">
   
       <li class="dropdown">   
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
           <span class="glyphicon glyphicon-cog">  
               </span> 
            MANTENCION<b class="caret"></b>
        </a>
        <ul class="dropdown-menu">
          <li><a href=empresa>EMPRESAS</a></li>
         <li><a href="cliprov">CLIENTE/PROVEEDOR</a></li>
           <li><a href="cesionario">CESIONARIOS</a></li>
          <li><a href="usuario">USUARIOS</a></li>
          <li><a href="correlativo">CORRELATIVOS</a></li>
           <li><a href="setpass">CAMBIO PASSWORD ADMINISTRADOR</a></li>
     </ul>
       </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
           <span class="glyphicon glyphicon-tasks">  
           </span>
          PROCESOS <b class="caret"></b>
          </a>
            <ul class="dropdown-menu">
                <li><a href="addVenta">INGRESO DE VENTAS</a></li>
                <li><a href="addCompra">INGRESO COMPRAS</a></li>
                <li><a href="getVenta">IMPORTACION DTE VENTA</a></li>
                <li><a href="getCompra">IMPORTACION DTE COMPRA</a></li>
                <li><a href="getCompra">CENTRALIZACION VENTAS</a></li>
            
                <li><a href="getCompra">CENTRALIZACION COMPRAS</a></li>
                
                <li><a href="selempresa">SELECCION EMPRESA</a></li>
                
            </ul>
       </li>
       
        
       
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
           <span class="glyphicon glyphicon-tasks">  
           </span>
          PROCESOS SII <b class="caret"></b>
          </a>
            <ul class="dropdown-menu">
               <li><a href="getVenta">ENVIO LIBRO DIARIO</a></li>
               <li><a href="getVenta">ENVIO BALANCE</a></li>
               <li><a href="getVenta">ENVIO LIBRO DIARIO</a></li>
             
                
            </ul>
       </li>
       
        
       
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
           <span class="glyphicon glyphicon-tasks">  
           </span>
          REPORTES<b class="caret"></b>
          </a>
            <ul class="dropdown-menu">
                <li><a href="getVenta">INGRESO DE VENTAS</a></li>
                <li><a href="getVenta">INGRESO COMPRAS</a></li>
                <li><a href="getVenta">IMPORTACION DTE VENTA</a></li>
                <li><a href="getCompra">IMPORTACION DTE COMPRA</a></li>
                <li><a href="getCompra">CENTRALIZACION</a></li>
                
                <li><a href="selempresa">SELECCION EMPRESA</a></li>
                
            </ul>
       </li>
       
       
       
       
       
       
       

    
    
       <li class="dropdown">
         <a href="logout.jsp">
          <span class="glyphicon glyphicon-log-out"></span>SALIR
        </a>
       </li>
  
        </div>
  </nav>
        <div align="center">
            <table>
                <tr>
                    <th colspan="2">
                        EMPRESA SELECCIONADA
                    </th>
                </tr>
                <tr>
                    <td>
                        RAZON SOCIAL
                    </td>
                    <td>
                        <% out.print(objEmpresa.getEmpresaraz()); %>
                    </td>               
                </tr>
                <tr>
                    <td>
                        RUT
                    </td>
                    <td>
                        <% out.print(objEmpresa.getEmpresarut()); %>
                    </td>               
                </tr>
                
            </table>
            
            
        </div>
                 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </body>
</html>
