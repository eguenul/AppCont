/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcont.movimiento;

import appcont.cliprov.CliProv;
import appcont.cliprov.CliProvModel;
import appcont.documento.Documento;
import appcont.documento.DocumentoModel;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
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
public class addMovimiento extends HttpServlet{
           
    @Override  
  public void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            ServletContext context = request.getServletContext();
         String pathservlet = context.getRealPath("/");

          
            request.getSession().setAttribute("CliProvCod", "");
            request.getSession().setAttribute("CliProvRut", "");
            request.getSession().setAttribute("CliProvRaz", "");
            request.getSession().setAttribute("CliProvGir", "");
            request.getSession().setAttribute("CliProvDir", "");
            request.getSession().setAttribute("CliProvFon", "");
            request.getSession().setAttribute("CliProvCiu", "");
            request.getSession().setAttribute("CliProvCom", "");
        
            
            
            
            int empresaid = (int) request.getSession().getAttribute("empresaid");
            request.getSession().setAttribute("modulo","addMovimiento");
            CliProvModel objCliProvModel = new CliProvModel(empresaid,pathservlet);
            ArrayList<CliProv> arraylistcliprov = objCliProvModel.listaCliProv(0);
            request.getSession().setAttribute("arraylistcliprov", arraylistcliprov);
            getServletConfig().getServletContext().getRequestDispatcher("/movimientoview/registrodoc.jsp").forward(request,response);
        
        
        
        
        
        
        
        
        
        } catch (SQLException | ClassNotFoundException | ParserConfigurationException | SAXException ex) {
            Logger.getLogger(addMovimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
  
  }
  
@Override  
public void  doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
  
  
        try{
              ServletContext context = request.getServletContext();
         String pathservlet = context.getRealPath("/");

            int empresaid = (int) request.getSession().getAttribute("empresaid");
            request.getSession().setAttribute("modulo","addMovimiento");
         
            CliProvModel objCliProvModel = new CliProvModel(empresaid,pathservlet);
           /* ArrayList<CliProv> arraylistcliprov = objCliProvModel.listaCliProv(0); */
        
             String acc = request.getParameter("ACC");
            int cliprovcod = 0;
            
            CliProv objCliProv = new CliProv(); 
            
             switch (acc){
                 
                 case "BUSCAR":
                                 cliprovcod = Integer.parseInt(request.getParameter("CliProvCod").trim());
                                 objCliProv = objCliProvModel.searchCliProv(cliprovcod);
                     
                                   request.getSession().setAttribute("CliProvCod", cliprovcod);
                                   request.getSession().setAttribute("CliProvRut", objCliProv.getCliprovrut());
                                   request.getSession().setAttribute("CliProvRaz", objCliProv.getCliprovraz());
                                   request.getSession().setAttribute("CliProvGir", objCliProv.getCliprovgir());
                                   request.getSession().setAttribute("CliProvDir", objCliProv.getCliprovdir());
                                   request.getSession().setAttribute("CliProvFon", objCliProv.getCliprovfon());
                                   request.getSession().setAttribute("CliProvCiu", objCliProv.getCliprovciu());
                                   request.getSession().setAttribute("CliProvCom", objCliProv.getCliprovcom());
                                   System.out.print(request.getSession().getAttribute("CliProvRaz"));
                                
                                
                                  ArrayList<CliProv> arraylistcliprov = objCliProvModel.listaCliProv(0);
                                  request.getSession().setAttribute("arraylistcliprov", arraylistcliprov);
                              
                                  getServletConfig().getServletContext().getRequestDispatcher("/movimientoview/registrodoc.jsp").forward(request,response);
         
                     
                       break;
                 
                       
                       
                       
                 case "BUSCADOC":
                     
                     
                     
                     break;
                     
                 case "UPDATE":     
                     
                 break;
                 
                 case "DELETE":
                     
                 break;    
                     
                 case "GRABAR":
                     
                     
                     
                     cliprovcod = Integer.parseInt(request.getParameter("CliProvCod").trim());
                     int tipodocid = Integer.parseInt(request.getParameter("TipoDoc").trim());
                     
                     Documento objDoc = new Documento();
                     DocumentoModel objDocModel = new DocumentoModel(pathservlet);   
                     objDoc = objDocModel.getObjDoc(tipodocid);
                     
                     objCliProv = objCliProvModel.searchCliProv(cliprovcod);
                                                                         
                     
                     int numdoc = Integer.parseInt(request.getParameter("NumDoc").trim());
                     int montoneto = Integer.parseInt(request.getParameter("MontoNeto").trim());
                     int montoexento = Integer.parseInt(request.getParameter("MontoExento").trim());
                     int montoiva = Integer.parseInt(request.getParameter("MontoIva").trim());
                     int montototal =Integer.parseInt(request.getParameter("MontoTotal").trim());
                     String fechadoc = request.getParameter("FechaDoc");
                     
                     Movimiento objMovimiento = new Movimiento();
                     objMovimiento.setNumdoc(numdoc);
                     objMovimiento.setMontoafecto(montoneto);
                     objMovimiento.setMontoexento(montoexento);
                     objMovimiento.setMontoiva(montoiva);
                     objMovimiento.setMontototal(montototal);
                     objMovimiento.setFechadoc(fechadoc);
                     
                     request.getSession().setAttribute("CliProvCod", "");
                     request.getSession().setAttribute("CliProvRut", "");
                     request.getSession().setAttribute("CliProvRaz", "");
                     request.getSession().setAttribute("CliProvGir", "");
                     request.getSession().setAttribute("CliProvDir", "");
                     request.getSession().setAttribute("CliProvFon", "");
                     request.getSession().setAttribute("CliProvCiu", "");
                     request.getSession().setAttribute("CliProvCom", "");
                    
                    
                     objMovimiento.setCliprov(objCliProv);
                     objMovimiento.setTipodocumento(objDoc);
                     
                     MovimientoModel objMovimientoModel = new MovimientoModel(empresaid, pathservlet);
                   
                     String desTipomovimiento = (String) request.getSession().getAttribute("tipo_movimiento");
                     int codTipoMovimiento = objMovimientoModel.get_idTipoMovmiento(desTipomovimiento.trim());
                    
                     objMovimientoModel.addDoc(objMovimiento,codTipoMovimiento);
                    
                     request.getSession().setAttribute("ESTADODOC","OK");
                     getServletConfig().getServletContext().getRequestDispatcher("/movimientoview/formregistro.jsp").forward(request,response);
         
                    break;
                    
             }
            
            
            
        } catch (SQLException | ClassNotFoundException | ParserConfigurationException | SAXException ex) {
            Logger.getLogger(addMovimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
            
  
  }     
        
    
}
