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
public class LoginModel {
    Connection objconexion;
    
    public LoginModel() throws SQLException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException{
          Conexion auxconexion = new Conexion();
          this.objconexion = auxconexion.obtener();
        
    }
    
   public boolean authLogin(String loginname,String password) throws SQLException{
       boolean authlogin = false;
       String sql;
       Statement stmt = objconexion.createStatement();
       sql = "Select * from Usuario where UsuarioLogin='"+loginname+"' and UsuarioPass='"+password+"'";
     
       ResultSet objrecordset = stmt.executeQuery(sql);
       
       if(objrecordset.next()==true){
                authlogin=true;
       }
       
       return authlogin;
   }
   
   public String getRut(String loginname) throws SQLException{
   
    String sql;
       Statement stmt = objconexion.createStatement();
       sql = "Select * from Usuario where UsuarioLogin='"+loginname+"'";
       String rutusuario  = "";
       ResultSet objrecordset = stmt.executeQuery(sql);
       
       if(objrecordset.next()==true){
                rutusuario = objrecordset.getString("UsuarioRut");
       }
   
       return rutusuario;
   
   }
    
}
