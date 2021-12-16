package appcont.empresa;

import appcont.include.comonFunc;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class EmpresaServlet extends HttpServlet {

 @Override
 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     try {
         String acc = request.getParameter("ACC");
       
         ServletContext context = request.getServletContext();
         String pathservlet = context.getRealPath("/");

            
           Empresa objEmpresa = new Empresa();
          
           EmpresaModel objEmpresaModel = new EmpresaModel(pathservlet);
         
           switch(acc){
             
             case "GRABAR":
                 
                           objEmpresa.setEmpresarut(request.getParameter("EmpresaRut"));
                          
                     
                           
                            objEmpresa.setEmpresaraz(request.getParameter("EmpresaRaz"));
                            objEmpresa.setEmpresarut(request.getParameter("EmpresaRut").trim());
                            objEmpresa.setEmpresagir(request.getParameter("EmpresaGir"));
                            objEmpresa.setEmpresadir(request.getParameter("EmpresaDir"));
                            objEmpresa.setEmpresacom(request.getParameter("EmpresaCom"));
                            objEmpresa.setEmpresaciu(request.getParameter("EmpresaCiu"));
                            objEmpresa.setEmpresafon(request.getParameter("EmpresaFon"));
                            objEmpresa.setEmpresaema(request.getParameter("EmpresaEma"));
                           
                            
                            
                            objEmpresa.setEmpresaacteco(Integer.parseInt(request.getParameter("ActEco")));
                            objEmpresa.setEmpresanumresol(Integer.parseInt(request.getParameter("ResolSii")));
                            objEmpresa.setEmpresafechresol(request.getParameter("FechResol"));
                            objEmpresa.setSucursalsiicod(Integer.parseInt(request.getParameter("SucurSiiCod")));
                            objEmpresa.setOficinasii(request.getParameter("OficinaSii"));


                  if(comonFunc.validaRut(objEmpresa.getEmpresarut().trim())==true){
              
                            objEmpresaModel.addEmpresa(objEmpresa);
                            
                            objEmpresa.setEmpresaraz("");
                            objEmpresa.setEmpresarut("");
                            objEmpresa.setEmpresagir("");
                            objEmpresa.setEmpresadir("");
                            objEmpresa.setEmpresacom("");
                            objEmpresa.setEmpresaciu("");
                            objEmpresa.setEmpresafon("");
                            objEmpresa.setEmpresaema("");
                            objEmpresa.setEmpresanumresol(0);
                            objEmpresa.setEmpresafechresol("");
                            objEmpresa.setSucursalsiicod(1);
                             objEmpresa.setEmpresacod(0);
                          
                            

                            request.getSession().setAttribute("Empresa", objEmpresa);
                            request.getSession().setAttribute("estado", "OK");
                            
                          }else{
                            request.getSession().setAttribute("Empresa", objEmpresa);
                            request.getSession().setAttribute("estado", "RUTERROR");
                              
                              
                          }
                            
                            
                            getServletConfig().getServletContext().getRequestDispatcher("/empresaview/formempresa.jsp").forward(request,response);

                            break;
                 
             case "UPDATE":
                            objEmpresa.setEmpresacod(Integer.parseInt(request.getParameter("EmpresaCod")));
                            
                            objEmpresa.setEmpresaraz(request.getParameter("EmpresaRaz"));
                            objEmpresa.setEmpresarut(request.getParameter("EmpresaRut").trim());
                            objEmpresa.setEmpresagir(request.getParameter("EmpresaGir"));
                            objEmpresa.setEmpresadir(request.getParameter("EmpresaDir"));
                            objEmpresa.setEmpresacom(request.getParameter("EmpresaCom"));
                            objEmpresa.setEmpresaciu(request.getParameter("EmpresaCiu"));
                            objEmpresa.setEmpresafon(request.getParameter("EmpresaFon"));
                            objEmpresa.setEmpresaema(request.getParameter("EmpresaEma"));
                           
                            
                            
                            objEmpresa.setEmpresaacteco(Integer.parseInt(request.getParameter("ActEco")));
                            objEmpresa.setEmpresanumresol(Integer.parseInt(request.getParameter("ResolSii")));
                            objEmpresa.setEmpresafechresol(request.getParameter("FechResol"));
                            objEmpresa.setSucursalsiicod(Integer.parseInt(request.getParameter("SucurSiiCod")));
                            objEmpresa.setOficinasii(request.getParameter("OficinaSii"));

  if(comonFunc.validaRut(objEmpresa.getEmpresarut().trim())==true){
              

                            objEmpresaModel.updateEmpresa(objEmpresa);
                            
                            objEmpresa.setEmpresaraz("");
                            objEmpresa.setEmpresarut("");
                            objEmpresa.setEmpresagir("");
                            objEmpresa.setEmpresadir("");
                            objEmpresa.setEmpresacom("");
                            objEmpresa.setEmpresaciu("");
                            objEmpresa.setEmpresafon("");
                            objEmpresa.setEmpresaema("");
                            objEmpresa.setEmpresanumresol(0);
                            objEmpresa.setEmpresafechresol("");
                            objEmpresa.setSucursalsiicod(1);
                            objEmpresa.setEmpresacod(0);
                            request.getSession().setAttribute("Empresa", objEmpresa);
                            request.getSession().setAttribute("estado", "OK");
                       }else{
                            request.getSession().setAttribute("Empresa", objEmpresa);
                            request.getSession().setAttribute("estado", "RUTERROR");
                        }
         
                            getServletConfig().getServletContext().getRequestDispatcher("/empresaview/formempresa.jsp").forward(request,response);

                 break;
                 
                 
             case "LISTADO":
                                ArrayList<Empresa> arraylistempresa = objEmpresaModel.listEmpresa2();
                                request.getSession().setAttribute("arraylistempresa", arraylistempresa);
                                getServletConfig().getServletContext().getRequestDispatcher("/empresaview/listempresa2.jsp").forward(request,response);
                 
                        
                 break;
                 
             case "BUSCAR":
                            request.getSession().setAttribute("estado", null);
                 
                         
                           
                            objEmpresa = objEmpresaModel.searchEmpresa(Integer.parseInt(request.getParameter("EmpresaCod")));
                          
                            request.getSession().setAttribute("acc", "UPDATE");                
                            request.getSession().setAttribute("Empresa", objEmpresa);
                            getServletConfig().getServletContext().getRequestDispatcher("/empresaview/formempresa.jsp").forward(request,response);
                            break;
                            
                            
             case "BUSQUEDACOD":
                                  if(request.getParameter("EmpresaCod").isEmpty()==true){
           
                                }else{
                                        int empresacod = Integer.parseInt(request.getParameter("EmpresaCod"));
                                        arraylistempresa = objEmpresaModel.searchCod(empresacod);
                                       request.getSession().setAttribute("arraylistempresa", arraylistempresa);
                                       getServletConfig().getServletContext().getRequestDispatcher("/empresaview/listempresa2.jsp").forward(request,response);
                                      } 
                                 break;
                            
             case "BUSQUEDARAZ":
                                if(request.getParameter("EmpresaRaz").isEmpty()==true){
           
                                 }else{
                                    String empresarazraz = request.getParameter("EmpresaRaz");
                                    arraylistempresa = objEmpresaModel.searchRaz(empresarazraz);
                                    request.getSession().setAttribute("arraylistempresa", arraylistempresa);
                                    getServletConfig().getServletContext().getRequestDispatcher("/empresaview/listempresa2.jsp").forward(request,response);
                                  }     
                                break;
                            
             case "BUSQUEDARUT":
                                  if(request.getParameter("EmpresaRut").isEmpty()==true){
           
                                    }else{
                                            String empresarut = request.getParameter("EmpresaRut");

                                             if(comonFunc.validaRut(empresarut.trim())==true){
                                                
                                                 arraylistempresa = objEmpresaModel.searchRut(empresarut);
                                                request.getSession().setAttribute("arraylistempresa", arraylistempresa);
                                                getServletConfig().getServletContext().getRequestDispatcher("/empresaview/listempresa2.jsp").forward(request,response);
                                             }else{
                                                 response.setContentType("text/html");

                                                //ya podemos enviar al navegador
                                                try ( //Objetemos el escritor hacia el Cliente
                                                        PrintWriter out = response.getWriter()) {
                                                    //ya podemos enviar al navegador
                                                    String mensaje = "<div class=\"alert alert-danger\"> <strong>ERROR</strong> RUT NO VALIDO</div>";
                                                    out.println(mensaje);
                                                }
                                             }

            
            
            
                                     } 
                 
                                  break;
                            
                            
                            
                            
                            
                            
                            
         }
     } catch (SQLException | ClassNotFoundException | ParserConfigurationException | SAXException ex) {
           Logger.getLogger(EmpresaServlet.class.getName()).log(Level.SEVERE, null, ex);
     }
 
 
 }

@Override
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      ServletContext context = request.getServletContext();
         String pathservlet = context.getRealPath("/");

     
       if(request.getSession().getAttribute("loginauth")==null){
         request.getRequestDispatcher("login").forward(request, response); 
       }

     try {
    
       request.getSession().setAttribute("estado", "");
     
    Empresa objEmpresa = new Empresa();   

    objEmpresa.setEmpresaacteco(1);
    objEmpresa.setEmpresaraz("");
    objEmpresa.setEmpresagir("");
    objEmpresa.setEmpresarut("");
    objEmpresa.setEmpresadir("");
    objEmpresa.setEmpresaciu("");
    objEmpresa.setEmpresacom("");
 
    objEmpresa.setEmpresafon("");
    objEmpresa.setEmpresaema("");
    objEmpresa.setEmpresafechresol("");
    objEmpresa.setSucursalsiicod(1);
    objEmpresa.setEmpresanumresol(0);
    objEmpresa.setOficinasii("");
    
    request.getSession().setAttribute("Empresa", objEmpresa);
    request.getSession().setAttribute("acc", "GRABAR");
 
    EmpresaModel objEmpresaModel = new EmpresaModel(pathservlet);
    ArrayList<Empresa> arraylistempresa = objEmpresaModel.listEmpresa2();
    request.getSession().setAttribute("arraylistempresa", arraylistempresa);
    getServletConfig().getServletContext().getRequestDispatcher("/empresaview/addempresa.jsp").forward(request,response);
  
  } catch (SQLException | ClassNotFoundException | ParserConfigurationException | SAXException ex) {
         Logger.getLogger(EmpresaServlet.class.getName()).log(Level.SEVERE, null, ex);
     }
    
     
     
     
     
     }

 
 
 
 
}