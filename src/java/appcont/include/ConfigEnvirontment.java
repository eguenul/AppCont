package appcont.include;

        
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigEnvirontment {
    
    
    

    private final String pathcert;
    private final String pathpdf;
    private final String pathenvironment;
    private final String serverauth;
   
    
    

    public ConfigEnvirontment(String pathservlet) throws FileNotFoundException, IOException {  
         Properties propiedades = new Properties();
         System.out.print("EL PATH SERVLET OBTENIDO ES:"+pathservlet);
         
         propiedades.load(new FileReader(pathservlet + "/WEB-INF/properties/" + "appcont.properties"));
        
         this.pathcert = propiedades.getProperty("path_certificate");
         this.pathpdf= propiedades.getProperty("pathpdf");
         this.pathenvironment= propiedades.getProperty("pathenvironment");
         this.serverauth= propiedades.getProperty("serverauth");
         
   
     }

    public String getPathcert() {
        return pathcert;
    }

    public String getPathpdf() {
        return pathpdf;
    }


  
    public String getPathenvironment() {
        return pathenvironment;
    }
     
    

    public String getServerauth() {
        return serverauth;
    }

    
    






}
