/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcont.cuentas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
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
public class listCuenta extends HttpServlet {
    
    
    
@Override
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ServletContext context = request.getServletContext();
         String pathservlet = context.getRealPath("/");

     try {
         CuentaModel objCuentasModel = new CuentaModel(pathservlet);

         int cantRegistros = objCuentasModel.conteoCuentas();
         int pagesize = 10;  				
	int totalPage = (cantRegistros-1)/pagesize+1;
        System.out.print(totalPage); 
        int pageNo = 1;
         /*  calculo de indice; */
            int begin = (pageNo-1)*pagesize;
	    
        
        
        
        ArrayList<Cuenta> arraylistCuenta = objCuentasModel.listCuentalimit(begin, pagesize);
         request.getSession().setAttribute("arraylistCuenta", arraylistCuenta);
        request.getSession().setAttribute("PAGINA", pageNo);
        request.getSession().setAttribute("TOTAL_PAGINAS", totalPage);
         getServletConfig().getServletContext().getRequestDispatcher("/cuentasview/adminCuenta.jsp").forward(request,response);
         
          } 
    catch (SQLException | ClassNotFoundException | ParserConfigurationException | SAXException ex) {
        Logger.getLogger(listCuenta.class.getName()).log(Level.SEVERE, null, ex);
    }
 
     
     
     
 }  
 
 @Override
 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        ServletContext context = request.getServletContext();
        String pathservlet = context.getRealPath("/");
        
        CuentaModel objCuentasModel = new CuentaModel(pathservlet);
        
        int cantRegistros = objCuentasModel.conteoCuentas();
        int pagesize = 10;
        int totalPage = (cantRegistros-1)/pagesize+1;
        System.out.print(totalPage);

        String ACC = request.getParameter("ACC");
         int pageNo = Integer.parseInt(request.getParameter("PAGINA"));
         
         switch(ACC){
             
             case "ANT":
                        
                      
                       pageNo = pageNo - 1;
                               
                       if(pageNo<1){
                           pageNo = totalPage;
                 
                        }
             
                        break;
             
             
             case "SIG":
                        
                        pageNo = (pageNo  + 1);
                       if(pageNo>totalPage){
                           pageNo=1;
                            
                        }
                        break;
             
             
             
         }
         
         
         
         
         /*  calculo de indice; */
            int begin = (pageNo-1)*pagesize;
	    
        
        
        
        ArrayList<Cuenta> arraylistCuenta = objCuentasModel.listCuentalimit(begin, pagesize);
         request.getSession().setAttribute("arraylistCuenta", arraylistCuenta);
        request.getSession().setAttribute("PAGINA", pageNo);
        request.getSession().setAttribute("TOTAL_PAGINAS", totalPage);
         getServletConfig().getServletContext().getRequestDispatcher("/cuentasview/listcuenta.jsp").forward(request,response);
         
        
        
        
    } catch (SQLException | ClassNotFoundException | ParserConfigurationException | SAXException ex) {
        Logger.getLogger(listCuenta.class.getName()).log(Level.SEVERE, null, ex);
    }
 
     
     
 
 }   
    
}
