<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<html> 
    <head>
        <meta charset="utf-8"> 
        
        
<meta name="viewport" content="width=device-width, initial-scale=1"> <!?Con esto garantizamos que se vea bien en dispositivos móviles?> 
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> 
<!--
<link rel="stylesheet" type="text/css" href="css/estilo.css" media="screen" />
-->
</head>
    <body>
        <h1>CENTRALIZACION</h1>
        <div align="center">   
    <form>
        <table  class="table tab-striped">
            <tr>
            <th colspan="7">DOCUMENTOS</th>   
            </tr>
            
            <tr>
                <td align="right" colspan="7"><button class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-file"></span>Nuevo</button><button class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-floppy-disk"></span>Centralizar</button><button class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-home"></span>Home</button></td>   
            </tr>
            
            <tr>
                <td>
                    CUENTA                    
                </td>
                <td>
                    <input size="8"  maxlength="8"><button>Buscar</button>
               </td>
               <td>
                   MONTO                   
               </td>
               <td>
                   <input size="8" maxlength="8" >
               </td>
               <td>
                   &nbsp;
                   
               </td>
                <td>
                   &nbsp;
                   
               </td>
                <td>
                   &nbsp;
                   
               </td>
            </tr>  
                <tr>
                <td>
                    CUENTA                    
                </td>
                <td>
                    <input size="8">  <button>Buscar</button>
                </td>
               <td>
                   MONTO                   
               </td>
               <td>
                   <input size="8">
               </td>
               <td>
                   &nbsp;
                   
               </td>
                <td>
                   &nbsp;
                   
               </td>
                <td>
                    &nbsp;
                   
               </td>
            </tr>  
            <tr>
                <td>
                   RUT PROVEEDOR
                </td>
                 <td>
                   RAZON SOCIAL
                </td>
                <td>
                   NRO DE DOCUMENTO
                </td>
             <td>
                   TIPO DOCUMENTO
                </td>
                <td>
                   FECHA DOCUMENTO
                </td>
            
                <td>
                   MONTO TOTAL
             </td>
             
             <td>
               SELECCIONAR
             </td>
            </tr>
            
            <%     List<Object[]> arraylistmovimiento = (ArrayList<Object[]>)request.getSession(true).getAttribute("arraylistmovimiento");
        for(Object[] i:arraylistmovimiento){ %>
            <tr>
                <td>
                    <input size="8" value="<% out.print(i[2]); %>" readonly="yes">     
                </td>
                <td>
                    <input value="<% out.print(i[1]); %>"  readonly="yes">     
                </td>
                <td>
                    <input size="8" value="<% out.print(i[4]); %>"  readonly="yes">     
                </td>
                
                <td>
                    <input size="8" value="<% out.print(i[3]); %>"  readonly="yes">     
                </td>
                
                
                <td>
                    <input type="date" value="<% out.print(i[5]); %>" readonly="yes">     
                </td>
                
                <td>
                    <input size="8" value="<% out.print(i[6]); %>" readonly="yes">     
                </td>
              
                
                
                
                <td>
                    <input type="checkbox" >     
                </td>
                
                
                
            </tr>
            
            <%   
               } 
            %>
            
        </table>
            
        </form>
        
        </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </body>    
</html>
