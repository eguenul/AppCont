
package appcont.documento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import appcont.include.Conexion;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
public class DocumentoModel {

    Connection objconexion; 
    String pathservlet;
public DocumentoModel(String pathservlet) throws SQLException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException{
  Conexion auxconexion = new Conexion(pathservlet);
  this.objconexion = auxconexion.obtener();
    this.pathservlet = pathservlet;
}
    
public List<Documento> listDocuments() throws SQLException{

    String sql = "Select * from TipoDocumentos";     
    Statement stm = this.objconexion.createStatement();
    ResultSet objrecordset = stm.executeQuery(sql);
    
    List<Documento> arrayDocumento = new ArrayList<>();
    
    
while(objrecordset.next()){
    Documento objDocumento = new Documento();
    objDocumento.setCodsii(objrecordset.getInt("CodigoSii"));
    objDocumento.setNombredoc(objrecordset.getString("TipoDocumentoDes"));
    objDocumento.setIddoc(objrecordset.getInt("TipoDocumentoId"));
    
    arrayDocumento.add(objDocumento);
    
}   
      
return arrayDocumento;
}  
    

        
public int getSiiCod(int iddocumento) throws SQLException, ClassNotFoundException, ParserConfigurationException{
        try {
            Conexion auxconexion = new Conexion(pathservlet);
            this.objconexion = auxconexion.obtener();
            
            String sql = "Select *  from TipoDocumentos where TipoDocumentoId="+iddocumento;
            Statement stm = this.objconexion.createStatement();
            ResultSet objrecordset = stm.executeQuery(sql);
            objrecordset.next();
            return objrecordset.getInt("CodigoSii");
        } catch (SAXException | IOException ex) {
            Logger.getLogger(DocumentoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
}        




public String getNombreDoc(int iddocumento) throws SQLException{
    String sql = "Select *  from TipoDocumentos where TipoDocumentoId="+iddocumento;     
    Statement stm = this.objconexion.createStatement();
    ResultSet objrecordset = stm.executeQuery(sql);
     objrecordset.next();   
    return objrecordset.getString("TipoDocumentoDes");
}        





public int getId(String codsii) throws SQLException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException{
    
    Conexion auxconexion = new Conexion(pathservlet);
    this.objconexion = auxconexion.obtener();
            
    int tipodocumentoid = 0;
    String sql = "Select * from TipoDocumentos where CodigoSii="+codsii;     
    System.out.print(sql);
    Statement stm = this.objconexion.createStatement();
    ResultSet objrecordset = stm.executeQuery(sql);
    if (objrecordset.next()){
        tipodocumentoid = objrecordset.getInt("TipoDocumentoId");
 }
    return tipodocumentoid;
}


public String getNombreDocCodSii(String codsii) throws SQLException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException{
    Conexion auxconexion = new Conexion(pathservlet);
      this.objconexion = auxconexion.obtener();
    String sql = "Select * from TipoDocumentos where CodigoSii="+codsii;     
System.out.print(sql);
    Statement stm = this.objconexion.createStatement();
    ResultSet objrecordset = stm.executeQuery(sql);
    objrecordset.next();
    return objrecordset.getString("TipoDocumentoDes");
 
   
}

public Documento getObjDoc(int idDoc) throws SQLException{
    Documento objDoc = new Documento();
    String sql = "Select *  from TipoDocumentos where TipoDocumentoId="+idDoc;     
    Statement stm = this.objconexion.createStatement();
    ResultSet objrecordset = stm.executeQuery(sql);
    
    objrecordset.next();
    objDoc.setCodsii(objrecordset.getInt("CodigoSii"));
    objDoc.setNombredoc(objrecordset.getString("TipoDocumentoDes"));
    objDoc.setIddoc(idDoc);
    
    return objDoc;
} 



}
