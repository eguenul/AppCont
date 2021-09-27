/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcont.login;


import appcont.include.ConfigEnvirontment;
import java.io.File;
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

public class LoginServlet  extends HttpServlet {
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
   
      try {
          String login = request.getParameter("login");
          String clave = request.getParameter("clave");
          LoginModel objLoginModel = new LoginModel();
          if( objLoginModel.authLogin(login, clave)==true){
              
              
              request.getSession().setAttribute("login",login);
              request.getSession().setAttribute("loginauth", "yes");
              
              /* BUSCO SI EXISTE CERTIFICADO DIGITAL */
             
              ConfigEnvirontment objConfig = new ConfigEnvirontment();
                         
              String sFichero = objConfig.getPathcert()+login;
              System.out.print(sFichero);
              File fichero = new File(sFichero);
              
              if("admin".equals(login)==false){
                  if(fichero.exists()){
                      
                      
                      response.sendRedirect("index.jsp");
                      
                  }else{
                      response.sendRedirect("messageview/errorcertificado.html");
                      
                  }
              }else{
                  response.sendRedirect("index.jsp");
              }
              
          }else{
              response.sendRedirect("messageview/errorlogin.html");
          } 
      } catch (SQLException | ClassNotFoundException | ParserConfigurationException | SAXException ex) {
          Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
      }
          
              
              
       }
  
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
  
   if(request.getSession().getAttribute("loginauth") != "yes"){
      getServletConfig().getServletContext().getRequestDispatcher("/loginview/login.jsp").forward(request,response);   
   }else{
       
       response.sendRedirect("index"); 
   }
      
  }
 
  
 
  
  
  
}
