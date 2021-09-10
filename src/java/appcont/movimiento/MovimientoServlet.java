/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcont.movimiento;

import appcont.cliprov.CliProv;
import appcont.cliprov.CliProvModel;
import java.io.IOException;
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
public class MovimientoServlet extends HttpServlet{
           
    @Override  
  public void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            int empresaid = (int) request.getSession().getAttribute("empresaid");
            request.getSession().setAttribute("modulo","movimiento");
            CliProvModel objCliProvModel = new CliProvModel(empresaid);
            ArrayList<CliProv> arraylistcliprov = objCliProvModel.listaCliProv(0);
            request.getSession().setAttribute("arraylistcliprov", arraylistcliprov);
            getServletConfig().getServletContext().getRequestDispatcher("/movimientoview/registrodoc.jsp").forward(request,response);
        } catch (SQLException | ClassNotFoundException | ParserConfigurationException | SAXException ex) {
            Logger.getLogger(MovimientoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
  
  }
  
@Override  
public void  doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
  
  
        try{
            
            int empresaid = (int) request.getSession().getAttribute("empresaid");
            request.getSession().setAttribute("modulo","movimiento");
         
            CliProvModel objCliProvModel = new CliProvModel(empresaid);
            ArrayList<CliProv> arraylistcliprov = objCliProvModel.listaCliProv(0);
        
            getServletConfig().getServletContext().getRequestDispatcher("/movimientoview/registrodoc.jsp").forward(request,response);
    
        
        } catch (SQLException | ClassNotFoundException | ParserConfigurationException | SAXException ex) {
            Logger.getLogger(MovimientoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
  
  }     
        
    
}
