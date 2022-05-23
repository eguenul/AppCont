package appcont.movimiento;

import appcont.cliprov.CliProv;
import appcont.cliprov.CliProvModel;
import appcont.documento.DocumentoModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


public class addDTECompra extends HttpServlet{

@Override  
public void  doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
  
    try {
        
        
         
        
        
        
        
        ServletContext context = request.getServletContext();
        String pathservlet = context.getRealPath("/");
        
        
        String cliprovrut = request.getParameter("CliProvRut");
       
        String cliprovraz = request.getParameter("CliProvRaz");
       
        String tipodocsii = request.getParameter("TipoDoc");
        
        
        
        String fechadoc = request.getParameter("FechaDoc");
        String foliodoc = request.getParameter("FolioDoc");
        String montoexento = request.getParameter("MontoExento");
        String montoneto = request.getParameter("MontoNeto");
        String montototal = request.getParameter("MontoTotal");
        DocumentoModel objDocumentoModel = new DocumentoModel(pathservlet);
        
     
        
        
        
        
        int empresaid = (int) request.getSession().getAttribute("empresaid");
        request.getSession().setAttribute("modulo","addMovimiento");
        CliProvModel objCliProvModel = new CliProvModel(empresaid,pathservlet);
        PrintWriter out = response.getWriter();
        /* verifico si existe el proveeedor */
        if(objCliProvModel.flagCliProv(cliprovrut)==1){
          
     
        
         int cliprovid =  objCliProvModel.getIdCliProv(cliprovrut);   
         int iddoc = objDocumentoModel.getId(tipodocsii);  
         
          CliProv objCliProv = objCliProvModel.getCliProvRut(cliprovrut);
       
   
       
       
       MovimientoModel objMovimientoModel = new MovimientoModel(empresaid,pathservlet);
       
       if(objMovimientoModel.searchDocSii(cliprovid, iddoc, foliodoc)==1){
           
           
          
        
         /* si el proveedor existen entonces empiezo a verificar el documento */
        /*    out.print("DOCUMENTO EXISTENTE");
            
              getServletConfig().getServletContext().getRequestDispatcher("/movimientoview/detallecompraview.jsp").forward(request,response);
   
          */ 
        /*
          getServletConfig().getServletContext().getRequestDispatcher("/movimientoview/detallecompraview.jsp").forward(request,response);
   */
        
        Movimiento objMovimiento = new Movimiento();
        objMovimiento.setCliprov(objCliProv);
      
        objMovimientoModel.addDoc(objMovimiento, 0);
        
        
        }else{
            /* si el documento no existe entonces commienzo a agregar el documento */
            /*
            out.print("DOCUMENTO NO INGRESADO");
            */
            
            
            /*
            getServletConfig().getServletContext().getRequestDispatcher("/movimientoview/detallecompraview.jsp").forward(request,response);
   
            */
        }
            
            
            
            
            
        
        }else{
            System.out.print("proveedor no existente");
           
             CliProv objCliProv = new CliProv();
             /*
             objCliProv.setCliprovraz(cliprovraz);
 */          /* si el proveedor no existe se procede a agregar */   
             objCliProv.setCliprovrut(cliprovrut);
             objCliProv.setCliprovraz(cliprovraz);
             objCliProv.setCliprovdir("-");
             objCliProv.setCliprovgir("-");
             objCliProv.setCliprovcom("-");
             objCliProv.setCliprovciu("-");
             objCliProv.setCliprovfon("-");
             objCliProv.setCliprovema("-");
             CliProvModel objCliProvModel2 = new CliProvModel(empresaid,pathservlet);
             objCliProv.setCliprovcod(objCliProvModel2.getCorrelativo());
             objCliProvModel2.addCliProv(objCliProv);  
             
            int cliprovid = objCliProvModel2.getIdCliProv(cliprovrut);
            int iddoc = objDocumentoModel.getId(tipodocsii);  
            /* luego procedo a insertar el documento */
            /*
            getServletConfig().getServletContext().getRequestDispatcher("/movimientoview/detallecompraview.jsp").forward(request,response);
             */
                 
        }
        
        
    } catch (SQLException | ClassNotFoundException | ParserConfigurationException | SAXException ex) {
        Logger.getLogger(addDTECompra.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
  }
}