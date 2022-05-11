/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcont.movimiento;

import appcont.cliprov.CliProv;
import appcont.documento.Documento;
import appcont.include.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author esteban
 */
public class MovimientoModel {

private final int empresaid;
private final String pathservlet;    
public MovimientoModel(int empresaid, String pathservlet){
 this.empresaid = empresaid;
 this.pathservlet = pathservlet;
}
        
    

public int searchDocSii(int cliprovid, int iddoc, String folio) throws SQLException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException{

   Conexion objconexion = new Conexion(pathservlet);
    try (Connection auxconexion = objconexion.obtener()) {
       
        Statement stmt = auxconexion.createStatement();
        
        String sqlQuery = "Select Count(*) as Conteo from Movimiento where TipoDocumentoId=" + String.valueOf(iddoc) + "\n"
        + " and CliProvId="+  cliprovid + " and NumDoc=" + folio;
       int conteo = 0;
       
        ResultSet objRecordset = stmt.executeQuery(sqlQuery);
        while (objRecordset.next()){
            
            conteo = objRecordset.getInt("Conteo");
        }
        
        return conteo;
       
    } 

}


public int searchDocSiiRut(String cliprovrut, int iddoc, String folio) throws SQLException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException{

   Conexion objconexion = new Conexion(pathservlet);
 
   Connection auxconexion = objconexion.obtener();
       
        Statement stmt = auxconexion.createStatement();
      
        String sqlQuery = "Select Count(*) as Conteo from Movimiento \n"+ 
 "inner join CliProv on Movimiento.CliProvId = CliProv.CliProvId \n"+
 "where TipoDocumentoId=" + String.valueOf(iddoc) + "\n"+
 "and NumDoc=" + String.valueOf(folio)+  " and CliProv.CliProvRut = '" + cliprovrut + "'";

        System.out.print(sqlQuery);
        int conteo = 0;
       
        ResultSet objRecordset = stmt.executeQuery(sqlQuery);
        while (objRecordset.next()){
            
            conteo = objRecordset.getInt("Conteo");
        }
        

       
    

 return conteo;
}






public void addDoc(Movimiento objMovimiento, int codTipoMovimiento) throws SQLException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException{
 Conexion objconexion = new Conexion(pathservlet);
 Connection conexion = objconexion.obtener();
 
CliProv objCliProv = objMovimiento.getCliprov();
Documento objDoc = objMovimiento.getTipodocumento();



int montoexento = objMovimiento.getMontoexento();
int montoafecto = objMovimiento.getMontoafecto();
int montoiva = objMovimiento.getMontoiva();
int montototal = objMovimiento.getMontototal();
int numdoc = objMovimiento.getNumdoc();
int tipodoc = objDoc.getIddoc();
int cliprovid = objCliProv.getCliprovid();
String fechadoc = objMovimiento.getFechadoc();

String sql = "INSERT INTO Movimiento(EmpresaId,CliProvId, FechaDoc,NumDoc,"
             + "TipoDocumentoId,"
             + "MontoExento,"
             + "MontoNeto,"
             + "MontoIva,"
             + "MontoTotal,"  
             +  "idTipoMovimiento" + ") \n"+
             "values( \n"+
             String.valueOf(this.empresaid)+","+
             String.valueOf(cliprovid)+","+
             "'"+ fechadoc  +"',"+
             String.valueOf(numdoc)+","+ 
             String.valueOf(tipodoc)+","+ 
             String.valueOf(montoexento)+","+
             String.valueOf(montoafecto)+","+
             String.valueOf(montoiva)+","+
             String.valueOf(montototal)+","+
             String.valueOf(codTipoMovimiento)+""+
         
              ")";






 
    System.out.print(sql);
    Statement smt1 = conexion.createStatement();
    smt1.execute(sql);
   

}

public int get_idTipoMovmiento(String desMovimiento) throws SQLException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException{
    Conexion objconexion = new Conexion(pathservlet);
    Connection auxconexion = objconexion.obtener();
     Statement stmt = auxconexion.createStatement();
        
        String sqlQuery = "Select * from TipoMovimiento where MovimientoDes='" + desMovimiento + "'\n";
       
        ResultSet objRecordset = stmt.executeQuery(sqlQuery);
        objRecordset.next();
        return objRecordset.getInt("idTipoMovimiento");
   
} 

public ArrayList<Object> listMovimientos() throws SQLException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException{
    
    
    
    Conexion objconexion = new Conexion(pathservlet);
    Connection auxconexion = objconexion.obtener();
    Statement stmt = auxconexion.createStatement();
    
    String sqlQuery = "Select Empresa.EmpresaId, CliProv.CliProvRaz,CliProv.CliProvRut, TipoDocumentos.TipoDocumentoDes, Movimiento.* from Movimiento \n"+
"inner join TipoDocumentos on TipoDocumentos.TipoDocumentoId = Movimiento.TipoDocumentoId \n"+
"inner join CliProv on CliProv.CliProvId = Movimiento.CliProvId \n"+
"inner join Empresa on Empresa.EmpresaId = Movimiento.EmpresaId";
       
  ResultSet objRecordset = stmt.executeQuery(sqlQuery);
  
  ArrayList<Object> arrayObject = new ArrayList<>();
  
  while(objRecordset.next()){
            Object[] objDetalle = new Object[12];
            objDetalle[0] = objRecordset.getInt("EmpresaId");
            objDetalle[1] = objRecordset.getString("CliProvRaz");
            objDetalle[2] = objRecordset.getString("CliProvRut");
            objDetalle[3] = objRecordset.getString("TipoDocumentoDes");
            objDetalle[4] = objRecordset.getInt("NumDoc");
            objDetalle[5] = objRecordset.getDate("FechaDoc");
            objDetalle[6] = objRecordset.getInt("MontoTotal");
            arrayObject.add(objDetalle);
           }

return arrayObject;


}







public void deleteDoc(){
    
    
    
}


public void updateDoc(){
    
    
    
}


public void listDocumentos(){
    
    
    
    
    
}





}







