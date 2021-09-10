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
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class MovimientoXML {
   
    private final Document doc;
public MovimientoXML() throws ParserConfigurationException{
    
    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
    this.doc = docBuilder.newDocument();
		
}
        
public void addDetalle(ArrayList<Movimiento> arraymovimiento){
  
    
    
    arraymovimiento.stream().map((i) -> {
        Element Movimientos = this.doc.createElement("Movimientos");
        Element CodigoCuenta = this.doc.createElement("CodigoCuenta");
        CodigoCuenta.setTextContent(i.getCodigoCuenta());
        Element Rut = this.doc.createElement("Rut");
        Element TpoDocum = this.doc.createElement("TpoDocum");
        Element Numero = this.doc.createElement("Numero");
        Element Debe = this.doc.createElement("Debe");
        Movimientos.appendChild(CodigoCuenta);
        Movimientos.appendChild(Rut);
        Movimientos.appendChild(TpoDocum);
        Movimientos.appendChild(Numero);
        Movimientos.appendChild(Debe);
            return Movimientos;
        }).forEachOrdered((Movimientos) -> {
            this.doc.appendChild(Movimientos);
        });

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
