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
    try {
         CuentaModel objCuentasModel = new CuentaModel();
         ArrayList<Cuenta> arraylistCuenta = objCuentasModel.listCuenta();
         request.getSession().setAttribute("arraylistCuenta", arraylistCuenta);
         getServletConfig().getServletContext().getRequestDispatcher("/cuentasview/adminCuenta.jsp").forward(request,response);
         
          } 
    catch (SQLException | ClassNotFoundException | ParserConfigurationException | SAXException ex) {
        Logger.getLogger(listCuenta.class.getName()).log(Level.SEVERE, null, ex);
    }
 
     
     
     
 }  
    
    
}
