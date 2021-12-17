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
   
    private final String dbserver_address;
    private final String dbserver_user;
    private final String dbserver_password;
    private final String dbserver_database;
  
    

    public ConfigEnvirontment(String pathservlet) throws FileNotFoundException, IOException {  
         Properties propiedades = new Properties();
         System.out.print("EL PATH SERVLET OBTENIDO ES:"+pathservlet);
         
         propiedades.load(new FileReader(pathservlet + "/WEB-INF/properties/" + "appcont.properties"));
        
         this.pathcert = propiedades.getProperty("path_certificate");
         this.pathpdf= propiedades.getProperty("pathpdf");
         this.pathenvironment= propiedades.getProperty("environment_cal");
         this.serverauth= propiedades.getProperty("environment_dte");
         
         
         
    this.dbserver_address = propiedades.getProperty("dbserver_address");
    this.dbserver_user = propiedades.getProperty("dbserver_user");
    this.dbserver_password = propiedades.getProperty("dbserver_password");
    this.dbserver_database = propiedades.getProperty("dbserver_database");
  
         
         
   
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

    public String getDbserver_address() {
        return dbserver_address;
    }

    public String getDbserver_user() {
        return dbserver_user;
    }

    public String getDbserver_password() {
        return dbserver_password;
    }

    public String getDbserver_database() {
        return dbserver_database;
    }

    
    






}
