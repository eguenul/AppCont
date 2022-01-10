package appcont.movimiento;

import appcont.cliprov.CliProvModel;
import appcont.documento.DocumentoModel;
import java.io.IOException;
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
        String tipodocsii = request.getParameter("TipoDoc");
        
        
        
        String fechadoc = request.getParameter("FechaDoc");
        String foliodoc = request.getParameter("FolioDoc");
        String montoexentro = request.getParameter("MontoExento");
        String montoneto = request.getParameter("MontoNeto");
        String montototal = request.getParameter("MontoTotal");
        
        DocumentoModel objDocumentoModel = new DocumentoModel(pathservlet);
        
        int iddocumento =   objDocumentoModel.getId(tipodocsii);
        
        
        
        
        int empresaid = (int) request.getSession().getAttribute("empresaid");
        request.getSession().setAttribute("modulo","addMovimiento");
        CliProvModel objCliProvModel = new CliProvModel(empresaid,pathservlet);
        
        if(objCliProvModel.flagCliProv(cliprovrut)==true){
            
            
         System.out.print("proveedor existente");
        }else{
            System.out.print("proveedor no existente");
            
        }
        
        
    } catch (SQLException | ClassNotFoundException | ParserConfigurationException | SAXException ex) {
        Logger.getLogger(addDTECompra.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
  }
}