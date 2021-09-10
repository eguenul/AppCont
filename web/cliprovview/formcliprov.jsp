<% 
String login = (String)request.getSession().getAttribute("login");

%>
<div id="reporte">
<%
           if((String)request.getSession().getAttribute("estado")=="OK"){
       %> 
       
<div class="alert alert-success">
  <strong>OPERACION REALIZADA</strong> REGISTRO DE CLIENTES ACTUALIZADO.
</div>
      <%  request.getSession().setAttribute("estado",null);             
           }       
       %>
<%
           if((String)request.getSession().getAttribute("estado")=="RUTERROR"){
       %> 
       
<div class="alert alert-danger">
  <strong>OPERACION FALLIDA</strong> RUT ERRONEO.
</div>
      <%  request.getSession().setAttribute("estado",null);             
           }       
       %>      
        <% request.getSession().setAttribute("estado", null); %>
</div>       
       
        <form name="formcliprov" method="POST" id="formcliprov" action="cliprov">
        <table class="table table-bordered table-striped table-highlight">
              <tr>
                <th colspan="2">DATOS GENERALES</th>
              </tr>
            <tr>
                <td align="right" colspan="2">
                <button <% if("admin".equals(login)==false){ %> disabled <% } %>  onclick="if (ACC.value=='GRABAR'){addCliProv();} if(ACC.value=='UPDATE') { updateCliProv();  }"  type="button" class="btn btn-primary btn-sm">
              <span class="glyphicon glyphicon-floppy-disk"></span>Grabar
          </button> 
            <button onclick="cargarAjax('cliprov','ACC=LISTADO','reporte');" type="button" class="btn btn-primary btn-sm">
              <span class="glyphicon glyphicon-print"></span>Listado
          </button> 
                              
                    
                    
          <button type="button" onclick="window.location='cliprov';" name="btnLimpiar" class="btn btn-primary btn-sm">
          <span class="glyphicon glyphicon-file"></span>Nuevo 
           </button>
                    
              <button onclick="window.location='index.jsp';" type="button" name="btnLimpiar" class="btn btn-primary btn-sm">
          <span class="glyphicon glyphicon-home"></span>Home 
           </button>
                     
                    
          </td>
          </tr>            
            <tr>
                <td>CODIGO</td>
                <td><input value="<% out.print(request.getSession().getAttribute("CliProvCod")); %>" readonly id="CliProvCod" name="CliProvCod">
                <button   name="btnListadoCliProv" type="button" id="btnListadoCliProv" data-toggle="modal" data-target="#divcliprov"  class="btn btn-primary btn-sm">
          <span class="glyphicon glyphicon-search"></span>Buscar 
        </button>
      </td>
            </tr>
            <tr>
                <td>RAZON SOCIAL</td>
                <td> <input value="<% out.print(request.getSession().getAttribute("CliProvRaz")); %>" id="CliProvRaz" name="CliProvRaz"></td>
            </tr>
            <tr>
                <td>RUT</td>
                <td> <input value="<% out.print(request.getSession().getAttribute("CliProvRut")); %>" id="CliProvRut" name="CliProvRut"></td>
            </tr>
            <tr>
                <td>GIRO</td>
                <td><input value="<% out.print(request.getSession().getAttribute("CliProvGir")); %>" id="CliProvGir" name="CliProvGir"></td>
           
            </tr>
            <tr>
                <td>DIRECCION</td>
                <td> <input value="<% out.print(request.getSession().getAttribute("CliProvDir")); %>" id="CliProvDir" name="CliProvDir"></td>
            </tr>
            <tr>
                <td>COMUNA</td>
                <td><input value="<% out.print(request.getSession().getAttribute("CliProvCom")); %>" id="CliProvCom" name="CliProvCom"></td>
        
            </tr>
            <tr>
                <td>CIUDAD</td>
                <td>  <input value="<% out.print(request.getSession().getAttribute("CliProvCiu")); %>" id="CliProvCiu" name="CliProvCiu"></td>
            </tr>
            <tr>
                <td>TELEFONO</td>
                <td><input value="<% out.print(request.getSession().getAttribute("CliProvFon")); %>" id="CliProvFon" name="CliProvFon"></td>
            </tr>
            <tr>
                <td>EMAIL</td>
                <td> <input value="<% out.print(request.getSession().getAttribute("CliProvEma")); %>" id="CliProvEma" name="CliProvEma"></td>
            </tr> 
        </table>
        <% String acc = (String) request.getSession().getAttribute("ACC"); %>
        <input type="hidden" id="ACC" name="ACC" value="<% out.print(acc); %>" >
        </form>
