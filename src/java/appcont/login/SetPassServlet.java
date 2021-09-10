/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcont.login;

import java.io.IOException;
import java.sql.SQLException;
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
public class SetPassServlet extends HttpServlet {
    
@Override 
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if(request.getSession().getAttribute("loginauth")==null){
         request.getRequestDispatcher("login").forward(request, response); 
}else{
            String login = (String) request.getSession().getAttribute("login");
            if("admin".equals(login)==false){
                
                response.sendRedirect("messageview/erroradmin.html");
            }else{
                
             getServletConfig().getServletContext().getRequestDispatcher("/parametrosview/setpass.jsp").forward(request,response);
      
            }
        }
  
}   


    
@Override 
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
  
    try {
        String passwordant = request.getParameter("passwordant");
        String passwordnueva = request.getParameter("passwordnueva");
        SetPassModel objSetPassModel = new SetPassModel();
        
        if( objSetPassModel.validaPass(passwordant)==true){
             objSetPassModel.setPassAdmin(passwordnueva);
             request.getSession().setAttribute("ESTADO", "ok");
        }else{
            
            response.sendRedirect("messageview/errorpass.html");
        }
    
    
    
    } catch (SQLException | ClassNotFoundException | ParserConfigurationException | SAXException ex) {
        Logger.getLogger(SetPassServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
} 


    
    
}
