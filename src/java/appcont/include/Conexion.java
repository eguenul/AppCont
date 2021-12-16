/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcont.include;
import java.io.IOException;
import java.sql.*;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
public class Conexion {
   private final String pathservlet;
   public Conexion(String pathservlet){
       this.pathservlet = pathservlet;
       
   }         
            
    
    
    
   private static Connection cnx = null;
   public Connection obtener() throws SQLException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException {
      if (cnx == null) {
         try {
             
          ConfigEnvirontment objconfig = new ConfigEnvirontment(pathservlet);
               
          Class.forName("com.mysql.cj.jdbc.Driver");
          cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/AppCont?useSSL=false", "root" ,"Esther65@");
            
          Statement stmt2 = cnx.createStatement();
          stmt2.execute("SET CHARACTER SET utf8");
            
         } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
      }
      return cnx;
   }
   public static void cerrar() throws SQLException {
      if (cnx != null) {
         cnx.close();
      }
   }
}

