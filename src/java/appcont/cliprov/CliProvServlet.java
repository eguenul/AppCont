
package appcont.cliprov;


import appcont.include.comonFunc;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

/**
 *
 * @author esteban
 */
public class CliProvServlet extends HttpServlet {  

    @Override
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
         
      
       if(request.getSession().getAttribute("loginauth")==null){
         request.getRequestDispatcher("login").forward(request, response); 
       }
       
              
              
              
       int empresaid = (int) request.getSession().getAttribute("empresaid");
       
       
       request.getSession().setAttribute("modulo", "cliprov");
         try {
             
             
             
              
              CliProvModel objCliProvModel;
              objCliProvModel = new CliProvModel(empresaid);
              ArrayList<CliProv> arraylistcliprov = objCliProvModel.listaCliProv(0);          
              
              request.getSession().setAttribute("arraylistcliprov",arraylistcliprov);
              request.getSession().setAttribute("ACC","GRABAR");
               request.getSession().setAttribute("CliProvCod", ""); 
                 request.getSession().setAttribute("CliProvRaz", ""); 
                 request.getSession().setAttribute("CliProvRut", ""); 
                 request.getSession().setAttribute("CliProvDir", "");
                 request.getSession().setAttribute("CliProvGir", "");
                 request.getSession().setAttribute("CliProvCom", "");
                 request.getSession().setAttribute("CliProvCiu", "");
                 request.getSession().setAttribute("CliProvFon", "");
                 request.getSession().setAttribute("CliProvEma", "");
                
          request.getRequestDispatcher("/cliprovview/cliprov.jsp").forward(request,response);
  
         } catch (SQLException | ClassNotFoundException | ParserConfigurationException | SAXException ex) {
             Logger.getLogger(CliProvServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
         
                
    
     }
     
     
     
         
     @Override
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acc = request.getParameter("ACC");
         
         int empresaid =   (int) request.getSession().getAttribute("empresaid");
         request.getSession().setAttribute("modulo", "cliprov");
         try {
             
              if("UPDATE".equals(acc)){ 
             CliProv objCliProv = new CliProv();
             objCliProv.setCliprovraz(request.getParameter("CliProvRaz"));
             objCliProv.setCliprovrut(request.getParameter("CliProvRut").trim());
             objCliProv.setCliprovdir(request.getParameter("CliProvDir"));
             objCliProv.setCliprovgir(request.getParameter("CliProvGir"));
             objCliProv.setCliprovcom(request.getParameter("CliProvCom"));
             objCliProv.setCliprovciu(request.getParameter("CliProvCiu"));
             objCliProv.setCliprovfon(request.getParameter("CliProvFon"));
             objCliProv.setCliprovema(request.getParameter("CliProvEma"));
             objCliProv.setCliprovcod(Integer.parseInt(request.getParameter("CliProvCod")));
            
             if(comonFunc.validaRut(objCliProv.getCliprovrut())==true){
                CliProvModel objCliProvModel;           
                objCliProvModel = new CliProvModel(empresaid);
                objCliProvModel.updateCliProv(objCliProv);                    
                /*
                request.getSession().setAttribute("titulo","OPERACION EXITOSA");
                request.getSession().setAttribute("mensaje","Registro de Cliente/Proveedor actualizado");
                */
                request.getSession().setAttribute("estado", "OK");
                request.getSession().setAttribute("CliProvCod", ""); 
                request.getSession().setAttribute("CliProvRaz", ""); 
                request.getSession().setAttribute("CliProvRut", ""); 
                request.getSession().setAttribute("CliProvDir", "");
                request.getSession().setAttribute("CliProvGir", "");
                request.getSession().setAttribute("CliProvCom", "");
                request.getSession().setAttribute("CliProvCiu", "");
                request.getSession().setAttribute("CliProvFon", "");
                request.getSession().setAttribute("CliProvEma", "");
                getServletConfig().getServletContext().getRequestDispatcher("/cliprovview/formcliprov.jsp").forward(request,response);            
            }else{
            
                 request.getSession().setAttribute("CliProvRaz", objCliProv.getCliprovraz()); 
                 request.getSession().setAttribute("CliProvRut", objCliProv.getCliprovrut()); 
                 request.getSession().setAttribute("CliProvDir", objCliProv.getCliprovdir());
                 request.getSession().setAttribute("CliProvGir", objCliProv.getCliprovgir());
                 request.getSession().setAttribute("CliProvCom", objCliProv.getCliprovcom());
                 request.getSession().setAttribute("CliProvCiu", objCliProv.getCliprovciu());
                 request.getSession().setAttribute("CliProvFon", objCliProv.getCliprovfon());
                 request.getSession().setAttribute("CliProvEma", objCliProv.getCliprovema());
                 request.getSession().setAttribute("estado", "RUTERROR");
                 getServletConfig().getServletContext().getRequestDispatcher("/cliprovview/formcliprov.jsp").forward(request,response);    
    
             } 
             
              }
              
              
            if("GRABAR".equals(acc)){  
             CliProv objCliProv = new CliProv();
             objCliProv.setCliprovraz(request.getParameter("CliProvRaz"));
             objCliProv.setCliprovrut(request.getParameter("CliProvRut").trim());
             objCliProv.setCliprovdir(request.getParameter("CliProvDir"));
             objCliProv.setCliprovgir(request.getParameter("CliProvGir"));
             objCliProv.setCliprovcom(request.getParameter("CliProvCom"));
             objCliProv.setCliprovciu(request.getParameter("CliProvCiu"));
             objCliProv.setCliprovfon(request.getParameter("CliProvFon"));
             objCliProv.setCliprovema(request.getParameter("CliProvEma"));
             if(comonFunc.validaRut(objCliProv.getCliprovrut())==true){
                CliProvModel objCliProvModel;           
                objCliProvModel = new CliProvModel(empresaid);
                objCliProv.setCliprovcod(objCliProvModel.getCorrelativo());
                objCliProvModel.addCliProv(objCliProv);                    
                /*
                request.getSession().setAttribute("titulo","OPERACION EXITOSA");
                request.getSession().setAttribute("mensaje","Registro de Cliente/Proveedor actualizado");
                */
                request.getSession().setAttribute("estado", "OK");
                request.getSession().setAttribute("CliProvCod", ""); 
                request.getSession().setAttribute("CliProvRaz", ""); 
                request.getSession().setAttribute("CliProvRut", ""); 
                request.getSession().setAttribute("CliProvDir", "");
                request.getSession().setAttribute("CliProvGir", "");
                request.getSession().setAttribute("CliProvCom", "");
                request.getSession().setAttribute("CliProvCiu", "");
                request.getSession().setAttribute("CliProvFon", "");
                request.getSession().setAttribute("CliProvEma", "");
                getServletConfig().getServletContext().getRequestDispatcher("/cliprovview/formcliprov.jsp").forward(request,response);            
            }else{
            
                 request.getSession().setAttribute("CliProvRaz", objCliProv.getCliprovraz()); 
                 request.getSession().setAttribute("CliProvRut", objCliProv.getCliprovrut()); 
                 request.getSession().setAttribute("CliProvDir", objCliProv.getCliprovdir());
                 request.getSession().setAttribute("CliProvGir", objCliProv.getCliprovgir());
                 request.getSession().setAttribute("CliProvCom", objCliProv.getCliprovcom());
                 request.getSession().setAttribute("CliProvCiu", objCliProv.getCliprovciu());
                 request.getSession().setAttribute("CliProvFon", objCliProv.getCliprovfon());
                 request.getSession().setAttribute("CliProvEma", objCliProv.getCliprovema());
                 request.getSession().setAttribute("estado", "RUTERROR");
                 getServletConfig().getServletContext().getRequestDispatcher("/cliprovview/formcliprov.jsp").forward(request,response);    
    
             }      
       }
/*
        if("LISTADO".equals(acc)){    
            
            ConfigClass objconfig = new ConfigClass();
            Report objReport = new Report("cliprov",objconfig.getPathdownload(),"listcliprov"+String.valueOf(31)+".pdf");
            objReport.setParameters("parmEmpresaId", String.valueOf(empresaid));
            objReport.showReport();     
            request.getSession().setAttribute("nombredocumento", "listcliprov"+String.valueOf(31));
            PrintWriter out = response.getWriter();
            out.print("<div class=\"container\">");
            out.print("<div class=\"alert alert-success\">");
            out.print("<strong>Iniciar descarga</strong>");
            out.print ("<a target=\"blank\" href=\"pdfservlet\"  class=\"btn btn-primary btn-sm\">");
            out.print("<span class=\"glyphicon glyphicon-download\"></span>Descargar"); 
            out.print("</a>");
            out.print("</div>");
            out.print("</div>");
               
        
        }    
        
        */
        if("REFRESH".equals(acc)){    
           CliProvModel objCliProvModel;
           objCliProvModel = new CliProvModel(empresaid);
           ArrayList<CliProv> arraylistcliprov = objCliProvModel.listaCliProv(0);           
           request.getSession().setAttribute("arraylistcliprov",arraylistcliprov);
           getServletConfig().getServletContext().getRequestDispatcher("/cliprovview/divlistacliprov2.jsp").forward(request,response);    
        }    
        
        
        
        
        
        
        if("BUSQUEDACOD".equals(acc)){
         if(request.getParameter("CliProvCod").isEmpty()==true){
           
         }else{
            int cliprovcod = Integer.parseInt(request.getParameter("CliProvCod"));
           CliProvModel objCliProvModel = new CliProvModel(empresaid);
           ArrayList<CliProv> arraylistcliprov = objCliProvModel.searchCod(cliprovcod);
           request.getSession().setAttribute("arraylistcliprov", arraylistcliprov);
           getServletConfig().getServletContext().getRequestDispatcher("/cliprovview/divlistacliprov2.jsp").forward(request,response);
         } 
        }    
        
        
        if("BUSQUEDARAZ".equals(acc)){
         if(request.getParameter("CliProvRaz").isEmpty()==true){
           
         }else{
            String cliprovraz = request.getParameter("CliProvRaz");
           CliProvModel objCliProvModel = new CliProvModel(empresaid);
           ArrayList<CliProv> arraylistcliprov = objCliProvModel.searchRaz(cliprovraz);
           request.getSession().setAttribute("arraylistcliprov", arraylistcliprov);
           getServletConfig().getServletContext().getRequestDispatcher("/cliprovview/divlistacliprov2.jsp").forward(request,response);
         } 
        }    
        
        
        
        if("BUSQUEDARUT".equals(acc)){
         if(request.getParameter("CliProvRut").isEmpty()==true){
           
         }else{
         
             
             
           String cliprovrut = request.getParameter("CliProvRut");
           
            if(comonFunc.validaRut(cliprovrut)==true){
               CliProvModel objCliProvModel = new CliProvModel(empresaid);
               ArrayList<CliProv> arraylistcliprov = objCliProvModel.searchRut(cliprovrut);
               request.getSession().setAttribute("arraylistcliprov", arraylistcliprov);
               getServletConfig().getServletContext().getRequestDispatcher("/cliprovview/divlistacliprov2.jsp").forward(request,response);
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
        }    
        
        
      
        
            
         
         } catch (SQLException | ClassNotFoundException | ParserConfigurationException | SAXException ex) { 
              response.setContentType("text/html");
             //ya podemos enviar al navegador
             try ( //Objetemos el escritor hacia el Cliente
                     PrintWriter out = response.getWriter()) {
                 //ya podemos enviar al navegador
                 out.print("error al grabar");
             } 
                     Logger.getLogger(CliProvServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
        //ya podemos enviar al navegador
        //Objetemos el escritor hacia el Cliente
        //ya podemos enviar al navegador
         
        if("BUSCAR".equals(acc)){
            
            
            try {
                CliProvModel objCliProvModel = new CliProvModel(empresaid);
                
                 int cliprovcod = Integer.parseInt(request.getParameter("CliProvCod"));
                
                 
                 CliProv objCliProv = objCliProvModel.searchCliProv(cliprovcod);
                 
                request.getSession().setAttribute("CliProvCod",cliprovcod);
                request.getSession().setAttribute("CliProvRaz",objCliProv.getCliprovraz());
                request.getSession().setAttribute("CliProvRut", objCliProv.getCliprovrut());
                request.getSession().setAttribute("CliProvDir", objCliProv.getCliprovdir());
                request.getSession().setAttribute("CliProvGir", objCliProv.getCliprovgir());
                request.getSession().setAttribute("CliProvCom", objCliProv.getCliprovcom());
                request.getSession().setAttribute("CliProvCiu", objCliProv.getCliprovciu());
                request.getSession().setAttribute("CliProvFon", objCliProv.getCliprovfon());
                request.getSession().setAttribute("CliProvEma", objCliProv.getCliprovema());
                 request.getSession().setAttribute("ACC", "UPDATE");
                getServletConfig().getServletContext().getRequestDispatcher("/cliprovview/cliprov.jsp").forward(request,response);
            
            } catch (SQLException | ClassNotFoundException | ParserConfigurationException | SAXException ex) {
                Logger.getLogger(CliProvServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
  
            
            
        } 
         
         
       
       
     }
     
     
     }
