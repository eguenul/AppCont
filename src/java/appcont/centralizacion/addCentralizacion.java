/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcont.centralizacion;

import appcont.movimiento.MovimientoModel;
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
public class addCentralizacion extends HttpServlet{
    
    
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
    MovimientoModel objMovimientoModel = new MovimientoModel(31);
    /*
    ArrayList<Object> objListMovimiento =  objMovimientoModel.listMovimientos();
    request.getSession().setAttribute("objListMovimiento", objListMovimiento);
    */

}


@Override
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
    try {
        MovimientoModel objMovimientoModel = new MovimientoModel(31);
        ArrayList<Object> arrayObjetos = objMovimientoModel.listMovimientos();
        request.getSession().setAttribute("arraylistmovimiento", arrayObjetos);
        getServletConfig().getServletContext().getRequestDispatcher("/centralizaview/centraliza.jsp").forward(request,response);
    } catch (SQLException | ClassNotFoundException | ParserConfigurationException | SAXException ex) {
        Logger.getLogger(addCentralizacion.class.getName()).log(Level.SEVERE, null, ex);
    }
  


}




}
