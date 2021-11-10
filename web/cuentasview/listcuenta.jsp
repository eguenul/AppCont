<%@page import="appcont.cuentas.Cuenta"%>
<%@page import="java.util.ArrayList"%>

<% ArrayList<Cuenta> arraylistCuenta = (ArrayList<Cuenta>) request.getSession().getAttribute("arraylistCuenta");
       request.getSession().setAttribute("arraylistCuenta", arraylistCuenta);
 %>   
 
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/themes/default/style.min.css" />
   
 <div cuentas>
  <div id="jstree">
    <!-- in this example the tree is populated from inline HTML -->
    <ul>
        <% int x=0; %>
    <%   for(Cuenta i:arraylistCuenta){ %>  
      <li> <% out.print(i.getCuentacod()); %> -  <%  out.print(i.getCuentanom());   %> 
        <ul>
            <li id="child_node_<% out.print(x); %>">Child node 1</li>
          <li>Child node 2</li>
        </ul>
      </li>
    <% x++; } %>
      <li>Root node 2</li>
    </ul>
  </div>
 
 </div>
      
      
      
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/jstree.min.js"></script>
  <script>
      $(function () {
    // 6 create an instance when the DOM is ready
    $('#jstree').jstree();
    // 7 bind to events triggered on the tree
    $('#jstree').on("changed.jstree", function (e, data) {
      console.log(data.selected);
    });
    // 8 interact with the tree - either way is OK
  
  });
  </script>
 
      
   
      
  
