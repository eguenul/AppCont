/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcont.movimiento;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esteban
 */
public class addCompra extends HttpServlet {
    
@Override 
 public void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    
    request.getSession().setAttribute("tipo_movimiento", "COMPRA");
    response.sendRedirect("addMovimiento");
 
 }
     
    
   
}
