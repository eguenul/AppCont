/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcont.cuentas;

import java.io.IOException;
import static java.lang.Integer.parseInt;

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
public class addCuenta extends HttpServlet {
    

@Override
 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
 
   
        
    try {
         String cuentades = request.getParameter("CuentaDes");
         String cuentanivel = request.getParameter("CuentaNivel");
         String cuentapadre = request.getParameter("CuentaPadre");
         
         
        CuentaModel objCuentasModel = new CuentaModel();
        ArrayList<Cuenta> arraylistCuenta = objCuentasModel.listCuenta();
        
        int cantidadCuenta = objCuentasModel.cantCuentas(parseInt(cuentapadre), parseInt(cuentanivel));
        cantidadCuenta = cantidadCuenta+1;
        String codigocuenta = String.valueOf(cuentapadre)+String.valueOf(cantidadCuenta);
        objCuentasModel.addCuenta(codigocuenta,parseInt(cuentanivel), parseInt(cuentapadre), cuentades, 0);
        request.getSession().setAttribute("arraylistCuenta", arraylistCuenta);
        getServletConfig().getServletContext().getRequestDispatcher("/cuentasview/listcuenta.jsp").forward(request,response);
    } catch (SQLException | ClassNotFoundException | ParserConfigurationException | SAXException ex) {
        Logger.getLogger(addCuenta.class.getName()).log(Level.SEVERE, null, ex);
    }
    
        
    
    
 }
 
 
 
 

}
