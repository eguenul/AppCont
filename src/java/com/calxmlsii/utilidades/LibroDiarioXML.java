/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.calxmlsii.utilidades;

import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

/**
 *
 * @author esteban
 */
public class LibroDiarioXML {
    
    private final Document doc;

    public LibroDiarioXML() throws ParserConfigurationException{
         DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        this.doc = docBuilder.newDocument();

    }
   
    
    public void addComprobanteXML(){
        
        
    }
    
public StringWriter generarXML() throws TransformerConfigurationException, TransformerException{
    
    
    
   /* inicializo un objeto StringWriter */    
   StringWriter objStringWriter = new StringWriter();
   
   /* preparo el guardado del documento xml */
   TransformerFactory tf = TransformerFactory.newInstance();
   Transformer trans = tf.newTransformer();
   trans.setOutputProperty(OutputKeys.ENCODING, "Windows-1252");
   trans.setOutputProperty(OutputKeys.METHOD, "xml");
   trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
   
   /* dejaré el documento indentando */
   trans.setOutputProperty(OutputKeys.INDENT, "yes");
    
   /* especifico el origen del source */
   DOMSource source = new DOMSource(this.doc);          
   
   /* espefico que el result será guardado en el stringwirter */
   StreamResult result = new StreamResult(objStringWriter);
 
   /* guardo el documento en el stringwriter */
   trans.transform(source, result);
   
   System.out.print( objStringWriter.toString());
   
   
   
   
   return objStringWriter;
    
}        
    
    
    
    
}
