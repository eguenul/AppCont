<%@page import="appcont.empresa.Empresa"%>
<%
   String login = (String)request.getSession().getAttribute("login");
   Empresa objEmpresa =  (Empresa) request.getSession().getAttribute("Empresa");
    
%> 
<div id="resultado">
    <% 
        if(request.getSession().getAttribute("estado")=="OK"){ %>        
        <div class="alert alert-success" role="alert">
            REGISTRO DE EMPRESA ACTUALIZADO.
        </div>
   <%    }
    %>
  <% 
        if(request.getSession().getAttribute("estado")=="RUTERROR"){ %>        
        <div class="alert alert-danger" role="alert">
            RUT ERRONEO
        </div>
   <%    }
   %>

<% 
        if(request.getSession().getAttribute("estado")=="ERROR"){ %>        
        <div class="alert alert-danger" role="alert">
           ERROR DE CONEXION
        </div>
   <%    }   %>

 <% request.getSession().setAttribute("estado", null); %>
</div>
<form>
        <table class="table table-bordered table-striped table-highlight">
            <tr>
                <th colspan="2">
                    DATOS GENERALES
 
                </th>
                    
            
            </tr>
            <tr>
                <td align="right" colspan="2">
                    <button <% if("admin".equals(login)==false){ %> disabled <% } %> onclick="grabarEmpresa();" type="button" class="btn btn-primary btn-sm"> <span class="glyphicon glyphicon-floppy-disk"></span>Grabar</button>
                 
                    <button  type="button" name="btnLimpiar" onClick="window.location.href='empresa';" class="btn btn-primary btn-sm">
          <span class="glyphicon glyphicon-file"></span>Nuevo 
           </button>
           
                    
                    
                    <button onclick="window.location='index.jsp';" type="button" name="btnLimpiar" class="btn btn-primary btn-sm">
                         <span class="glyphicon glyphicon-home"></span>Home 
                         </button>
                </td>               
            </tr>
            
            <tr>
                <td>
                 CODIGO   
                </td>
            <td>
                <input readonly name="EmpresaCod" value="<% if(objEmpresa.getEmpresacod()==0){}else{  out.print(objEmpresa.getEmpresacod()); } %>" id="EmpresaCod">
              <button type="button" data-toggle="modal" data-target="#divlistaempresa" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-search"></span>Buscar</button>
            
            
          <!--  <button type="button" onclick="buscaEmpresa();" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-search"></span>Buscar</button>
          -->    
          </td>   
            </tr>  
           <tr>
                <td>
                 RAZON SOCIAL   
                </td>
            <td>
                <input name="EmpresaRaz" id="EmpresaRaz" value="<% out.print(objEmpresa.getEmpresaraz()); %>">
            </td>              
            </tr>  
           <tr>
                <td>
                 RUT   
                </td>
            <td>
                <input name="EmpresaRut" id="EmpresaRut" value="<% out.print(objEmpresa.getEmpresarut()); %> ">
            </td>
             <tr>
                <td>
                 GIRO   
                </td>
            <td>
                <input name="EmpresaGir" id="EmpresaGir" value="<% out.print(objEmpresa.getEmpresagir()); %>">
            </td>
              <tr>
                <td>
                 DIRECCION   
                </td>
            <td>
                <input name="EmpresaDir" id="EmpresaDir" value="<% out.print(objEmpresa.getEmpresadir()); %>">
            </td>
              </tr>
             
            <tr>
                <td>
                 COMUNA   
                </td>
            <td>
                <input name="EmpresaCom" id="EmpresaCom" value="<% out.print(objEmpresa.getEmpresacom()); %>">
            </td>
            </tr>  
            <tr>
                <td>
                 CIUDAD   
                </td>
            <td>
                <input name="EmpresaCiu" id="EmpresaCiu" value="<% out.print(objEmpresa.getEmpresaciu()); %>">
            </td>
            </tr>  
            <tr>
                <td>
                 FONO   
                </td>
            <td>
                <input name="EmpresaFon" id="EmpresaFon" value="<% out.print(objEmpresa.getEmpresafon()); %>">
            </td>
            </tr>
            <tr>
            
            <td>EMAIL</td>
            <td>    
            <input name="EmpresaEma" id="EmpresaEma" value="<% out.print(objEmpresa.getEmpresaema()); %>">
            </td>
            </tr>
            
            
            
            
       </table>
              
        
  <div id="DatosSii" class="modal fade" role="dialog">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">DATOS SII</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">

          <table class="table table-bordered table-striped table-highlight">
              <th colspan="2">
                  PARAMETROS
                  
              </th>
              <tr>
                <td>
                 RESOLUCION SII  
                </td>
            <td>
                <input name="ResolSii" id="ResolSii" value="<% out.print(objEmpresa.getEmpresanumresol()); %>">
            </td>
            
            <tr>
                <td>
                 FECHA RESOLUCION   
                </td>
            <td>
                <input type="date" id="FechResol" name="FechResol"  value="<% out.print(objEmpresa.getEmpresafechresol()); %>">
            </td>
            
            
            
            </tr>  
            
              <tr>
                <td>
                 CODIGO SUCURSAL SII   
                </td>
            <td>
                <input id="SucurSiiCod"  value="<% out.print(objEmpresa.getSucursalsiicod()); %>">
            </td>
            
            
            
            </tr>  
            
            
               <tr>
                <td>
               CODIGO ACTIVIDAD ECONOMICA
                </td>
            <td>
                <input id="ActEco" value="<% out.print(objEmpresa.getEmpresaacteco()); %>">
            </td>
            
            
            
            </tr>  
            
              <tr>
                <td>
               OFICINA SII
                </td>
            <td>
                <input id="OficinaSii" value="<% out.print(objEmpresa.getOficinasii()); %>">
            </td>
            
            
            
            </tr>  
            
              
          </table>
          </div>
            
</div>    
</div>
</div>   
<input type="hidden" name="ACC" id="ACC" value="<% out.print(request.getSession().getAttribute("acc")); %>">   
</form>