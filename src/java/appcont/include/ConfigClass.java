/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcont.include;



import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author esteban
 */
public class ConfigClass {
    private final String serveraddress;
    private final String username;
    private final String userpass;
    private final String databasename;
    private final String pathreports;
    
    public ConfigClass() throws ParserConfigurationException, SAXException, IOException{
         String filepath;
        filepath = "appventa.xml";
	
         DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	 DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 Document doc = docBuilder.parse(filepath);
         
   
         NodeList nodeserveraddress =  doc.getElementsByTagName("server-address");
         Element elserveraddress =  (Element) nodeserveraddress.item(0);  
         this.serveraddress = elserveraddress.getFirstChild().getNodeValue();
           
         NodeList nodeusername =  doc.getElementsByTagName("user-name");
         Element elusername =  (Element) nodeusername.item(0);  
         this.username = elusername.getFirstChild().getNodeValue();
    
         NodeList nodeuserpass =  doc.getElementsByTagName("user-pass");
         Element eluserpass =  (Element) nodeuserpass.item(0);  
         this.userpass = eluserpass.getFirstChild().getNodeValue();
    
         NodeList nodedatabasename =  doc.getElementsByTagName("database-name");
         Element eldatabasename =  (Element) nodedatabasename.item(0);  
         this.databasename = eldatabasename.getFirstChild().getNodeValue();
         
         NodeList nodepathreports =  doc.getElementsByTagName("path-reports");
         Element elpathreports =  (Element) nodepathreports.item(0);  
         this.pathreports = elpathreports.getFirstChild().getNodeValue();
         
         
         
    
    }

    public String getUserpass() {
        return userpass;
    }

    public String getServeraddress() {
        return serveraddress;
    }

    public String getUsername() {
        return username;
    }
    
    
  

    public String getDatabasename() {
        return databasename;
    }

    public String getPathreports() {
        return pathreports;
    }


    
}