/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.calxmlsii.utilidades;

import com.calxmlsii.json.Movimiento;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;

/**
 *
 * @author esteban
 */
public class ComprobanteXML {
      private final Document doc;
    
public ComprobanteXML() throws ParserConfigurationException{
    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
    this.doc = docBuilder.newDocument();
} 
    
    
public void creaComprobante(ArrayList<Movimiento> arraymovimiento) throws ParserConfigurationException, TransformerException{
      MovimientoXML objMovimientoXML = new MovimientoXML();
      objMovimientoXML.addDetalle(arraymovimiento);
      StringWriter objStringWriter = objMovimientoXML.generarXML();
     
}   
    
public StringWriter getComprobanteXML(){
        StringWriter objStringWriter = null;
             
             
    
       return objStringWriter;
}
 
}
