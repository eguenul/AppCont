/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcont.movimiento;

import appcont.empresa.Empresa;
import appcont.empresa.EmpresaModel;
import getdte.DetalleCompra;
import getdte.ICVCompra;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.xml.sax.SAXException;

/**
 *
 * @author esteban
 */
public class getCompra extends HttpServlet {
    
   
    @Override  
  public void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      
        getServletConfig().getServletContext().getRequestDispatcher("/movimientoview/getcompraview.jsp").forward(request,response);
  
  }
  
   @Override  
  public void  doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ServletContext context = request.getServletContext();
         String pathservlet = context.getRealPath("/");

      
      try {
            String acc = request.getParameter("ACC");
            
            int empresaid = (int) request.getSession().getAttribute("empresaid");
            EmpresaModel objEmpresaModel = new EmpresaModel(pathservlet); 
            Empresa objEmpresa = objEmpresaModel.getData(empresaid);
            String rutempresa = objEmpresa.getEmpresarut();
            
            
            switch(acc){
                
                
               
                    
                
                case "COMPRA":
                    ICVCompra objICVCompra = new ICVCompra();
                    String mes_periodo = request.getParameter("MES").trim();
                    String year_periodo = request.getParameter("YEAR").trim();
                    String periodo = year_periodo+mes_periodo;
                    
                    
                   /* realizo la peticion HTTP PARA OBTENER LAS COMPRAS */ 
                     String stringCSV =  objICVCompra.obtieneCompras("/home/esteban/appdte/certificate/eguenul", "amulen1956", "77813960-K", periodo,"");
                  
                    /* PROCEDO A FORMATEAR EL RESULTADO CSV */
                    ArrayList<DetalleCompra>  arraydetallecompra =    objICVCompra.formatCSV(stringCSV); 
                     
               request.getSession().setAttribute("arraydetallecompra", arraydetallecompra);
               getServletConfig().getServletContext().getRequestDispatcher("/movimientoview/detallecompraview.jsp").forward(request,response);
   
                     
                    
                    break;
                    
                    
                    
                    
            } } catch (SAXException ex) {
            Logger.getLogger(getCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(getCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
    
  }
  
  
  
  
  
  
}
