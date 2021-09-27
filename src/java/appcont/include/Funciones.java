/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcont.include;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import java.io.File;
import java.sql.ResultSet;

/**
 *
 * @author esteban
 */
public class Funciones {
    public boolean buscaFolios(int empresaid, String codsii) throws SQLException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException{
    
        Connection objconexion;
        String sql;
        sql="Select EmpresaRut from Empresa where EmpresaId="+String.valueOf(empresaid);
        
        ConfigEnvirontment objconfig = new ConfigEnvirontment();
        Conexion obj= new Conexion();
        objconexion = obj.obtener();
        Statement stm = objconexion.createStatement();
        String pathcaf ="";
       
        ResultSet objrecordset = stm.executeQuery(sql);
        objrecordset.next();
        String empresarut = objrecordset.getString("EmpresaRut");
        
        String[] parts = empresarut.split("-");
        String rut = parts[0];
        
        String nombrefolio = pathcaf.trim()+"F"+rut.trim()+"T"+codsii+".xml";
        
        
       File archivo = new File(nombrefolio.trim());
       if (!archivo.exists()) {
          System.out.println("ERROR: ¡¡No existe el archivo de folios!!");
          return false;
      }
        return true;  
    }
}
