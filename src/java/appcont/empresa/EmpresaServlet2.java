/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcont.empresa;
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
public class EmpresaServlet2 extends HttpServlet{
    


@Override
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     if(request.getSession().getAttribute("loginauth")==null){
         request.getRequestDispatcher("login").forward(request, response); 
       }
 
    try {
        
      
        EmpresaModel objEmpresaModel = new EmpresaModel();
        ArrayList<Empresa> arraylistempresa = objEmpresaModel.listEmpresa();
        request.getSession().setAttribute("arraylistempresa", arraylistempresa);
        getServletConfig().getServletContext().getRequestDispatcher("/empresaview/selectempresa.jsp").forward(request,response);
    } catch (SQLException | ClassNotFoundException | ParserConfigurationException | SAXException ex) {
        Logger.getLogger(EmpresaServlet2.class.getName()).log(Level.SEVERE, null, ex);
    }
      

 }

@Override
 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
    try {
        EmpresaModel objEmpresaModel = new EmpresaModel();
        int empresaid = Integer.parseInt(request.getParameter("EmpresaId"));
        Empresa objEmpresa = objEmpresaModel.getData(empresaid);
        request.getSession().setAttribute("Empresa",objEmpresa);
        request.getSession().setAttribute("empresaid", empresaid);    
        response.sendRedirect("index.jsp");
    } catch (SQLException | ClassNotFoundException | ParserConfigurationException | SAXException ex) {
        Logger.getLogger(EmpresaServlet2.class.getName()).log(Level.SEVERE, null, ex);
    }
 }

}
