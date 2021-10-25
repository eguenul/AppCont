/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcont.movimiento;

import appcont.cliprov.CliProv;
import appcont.cliprov.CliProvModel;
import appcont.documento.Documento;
import appcont.documento.DocumentoModel;
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
public class MovimientoModel {

private final int empresaid;
    
public MovimientoModel(int empresaid){
 this.empresaid = empresaid;
}
        
    

public boolean searchDocSii(String cliprovrut, String codsii, String folio) throws SQLException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException{

   Conexion objconexion = new Conexion();
    try (Connection auxconexion = objconexion.obtener()) {
        CliProvModel objCliProvModel = new CliProvModel(this.empresaid);
        DocumentoModel objDocumentoModel = new DocumentoModel();
        int cliprovid = objCliProvModel.getIdCliProv(cliprovrut);
        int iddoc = objDocumentoModel.getId(codsii);
        
        Statement stmt = auxconexion.createStatement();
        
        String sqlQuery = "Select * from Movimiento where TipoDocumentoId=" + String.valueOf(iddoc) + "\n"
        + " and CliProvId="+  cliprovid + " and NumDoc=" + folio;
        ResultSet objRecordset = stmt.executeQuery(sqlQuery);
        
       return objRecordset.next() != false;
        
        
       
    }
   
   
   
   
   

}


public void addDocSii(String cliprovrut, String codsii, String folio, int tipomovimiento) throws SQLException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException{

if (searchDocSii(cliprovrut, codsii, folio)==true){    
   CliProvModel objCliProvModel = new CliProvModel(this.empresaid);
   DocumentoModel objDocumentoModel = new DocumentoModel();
   /*
   int cliprovid = objCliProvModel.getIdCliProv(cliprovrut);
   int iddoc = objDocumentoModel.getId(codsii);
   addDoc(cliprovid,iddoc, tipomovimiento); 
   
   */
   
}
}

public void addDoc(Movimiento objMovimiento, int codTipoMovimiento) throws SQLException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException{
 Conexion objconexion = new Conexion();
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
    Conexion objconexion = new Conexion();
    Connection auxconexion = objconexion.obtener();
     Statement stmt = auxconexion.createStatement();
        
        String sqlQuery = "Select * from TipoMovimiento where MovimientoDes='" + desMovimiento + "'\n";
       
        ResultSet objRecordset = stmt.executeQuery(sqlQuery);
        objRecordset.next();
        return objRecordset.getInt("idTipoMovimiento");
   
} 




public void deleteDoc(){
    
    
    
}


public void updateDoc(){
    
    
    
}


public void listDocumentos(){
    
    
    
    
    
}





}







