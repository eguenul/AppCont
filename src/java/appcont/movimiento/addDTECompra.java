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
       /*
        String cliprovraz = request.getParameter("CliProvRaz");
        */
        String tipodocsii = request.getParameter("TipoDoc");
        
        
        
        String fechadoc = request.getParameter("FechaDoc");
        String foliodoc = request.getParameter("FolioDoc");
        String montoexentro = request.getParameter("MontoExento");
        String montoneto = request.getParameter("MontoNeto");
        String montototal = request.getParameter("MontoTotal");
        
        DocumentoModel objDocumentoModel = new DocumentoModel(pathservlet);
        
     
        
        
        
        
        int empresaid = (int) request.getSession().getAttribute("empresaid");
        request.getSession().setAttribute("modulo","addMovimiento");
        CliProvModel objCliProvModel = new CliProvModel(empresaid,pathservlet);
        PrintWriter out = response.getWriter();
        out.print("buscando");
        if(objCliProvModel.flagCliProv(cliprovrut)==1){
          
     
        
         int cliprovid =  objCliProvModel.getIdCliProv(cliprovrut);   
         int iddoc = objDocumentoModel.getId(tipodocsii);  
         
       MovimientoModel objMovimientoModel = new MovimientoModel(empresaid,pathservlet);
        if(objMovimientoModel.searchDocSii(cliprovid, iddoc, foliodoc)==1){
         
            out.print("DOCUMENTO EXISTENTE");
            
        }else{
            
            out.print("DOCUMENTO NO INGRESADO");
            
        }
            
            
            
            
            
        
        }else{
            System.out.print("proveedor no existente");
           
             CliProv objCliProv = new CliProv();
             /*
             objCliProv.setCliprovraz(cliprovraz);
 */             
             objCliProv.setCliprovrut(cliprovrut);
             objCliProv.setCliprovdir("-");
             objCliProv.setCliprovgir("-");
             objCliProv.setCliprovcom("-");
             objCliProv.setCliprovciu("-");
             objCliProv.setCliprovfon("-");
             objCliProv.setCliprovema(request.getParameter("CliProvEma"));
             CliProvModel objCliProvModel2 = new CliProvModel(empresaid,pathservlet);
             objCliProv.setCliprovcod(objCliProvModel2.getCorrelativo());
             objCliProvModel2.addCliProv(objCliProv);  
            
        }
        
        
    } catch (SQLException | ClassNotFoundException | ParserConfigurationException | SAXException ex) {
        Logger.getLogger(addDTECompra.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
  }
}