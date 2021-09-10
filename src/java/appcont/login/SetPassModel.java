/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcont.login;

import appcont.include.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author esteban
 */
public class SetPassModel {
    
public void setPassAdmin(String password) throws SQLException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException{    
  
 Conexion auxconexion = new Conexion();
 Connection objconexion = auxconexion.obtener();
  
 String sql = "Update Usuario set UsuarioPass='"+ password+  "' where UsuarioLogin='admin'";
 Statement stm = objconexion.createStatement();
 stm.execute(sql);
 }   


public boolean validaPass(String password) throws SQLException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException{
 Conexion auxconexion = new Conexion();
 Connection objconexion = auxconexion.obtener();
  
 String sql = "Select * from Usuario where UsuarioPass='"+ password+  "' and UsuarioLogin='admin'";
 Statement stm = objconexion.createStatement();
 ResultSet objrecordset =   stm.executeQuery(sql);
return objrecordset.next();
}




}
