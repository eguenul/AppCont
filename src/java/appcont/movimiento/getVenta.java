/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcont.movimiento;

import appcont.empresa.Empresa;
import appcont.empresa.EmpresaModel;
import getdte.DetalleVenta;
import getdte.ICVVenta;
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
public class getVenta extends HttpServlet {
    
    
      
 @Override  
  public void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
  
  getServletConfig().getServletContext().getRequestDispatcher("/movimientoview/getventaview.jsp").forward(request,response);
   
  
  
  }
  
  
   @Override  
  public void  doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
  
   
     try {
         String acc = request.getParameter("ACC");
         
         int empresaid = (int) request.getSession().getAttribute("empresaid");
         EmpresaModel objEmpresaModel = new EmpresaModel();
         Empresa objEmpresa = objEmpresaModel.getData(empresaid);
         String rutempresa = objEmpresa.getEmpresarut();
         
         
         switch(acc){
             
             
             
             
             
             case "VENTA":
                 ICVVenta objICVVenta = new ICVVenta();
                 String mes_periodo = request.getParameter("MES").trim();
                 String year_periodo = request.getParameter("YEAR").trim();
                 String periodo = year_periodo+mes_periodo;
                 
                 
                 /* realizo la peticion HTTP PARA OBTENER LAS VENTAS */
                 String stringCSV =  objICVVenta.obtieneVentas("eguenul", "amulen1956", rutempresa, periodo,"palena.sii.cl");
                 objICVVenta.formatCSV(stringCSV);
                 /* PROCEDO A FORMATEAR EL RESULTADO CSV */
                 
                 ArrayList<DetalleVenta>  arraydetalleventa = objICVVenta.formatCSV(stringCSV);
                 
                 request.getSession().setAttribute("arraydetalleventa", arraydetalleventa);
                 getServletConfig().getServletContext().getRequestDispatcher("/movimientoview/detalleventaview.jsp").forward(request,response);
                 
                 
                 
                 break;
                 
                 
                 
                  
         }
     } catch (SQLException | ClassNotFoundException | ParserConfigurationException | SAXException ex) {
         Logger.getLogger(getVenta.class.getName()).log(Level.SEVERE, null, ex);
     } catch (Exception ex) {
         Logger.getLogger(getVenta.class.getName()).log(Level.SEVERE, null, ex);
     }
    
  }
  
  
  }
    

