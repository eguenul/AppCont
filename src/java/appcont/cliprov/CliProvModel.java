/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcont.cliprov;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import appcont.include.Conexion;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
public class CliProvModel {
private final int empresaid;
    
public CliProvModel(int empresaid) throws SQLException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException{
this.empresaid = empresaid;   
    
}
    
    
public ArrayList<CliProv> listaCliProv(int indice) throws SQLException{
   
    try {
        Conexion auxconexion = new Conexion();
        Connection objconexion = auxconexion.obtener();
        
        
        ArrayList<CliProv> arrayCliProv = new ArrayList();
        Statement stm = objconexion.createStatement();
        String sql = "select * from CliProv where EmpresaId="+String.valueOf(empresaid) + " limit " + String.valueOf(indice)+",10";
        ResultSet objrecordset = stm.executeQuery(sql);
        
        while(objrecordset.next()){
            CliProv objCliProv = new CliProv();
            
            objCliProv.setCliprovciu(objrecordset.getString("CliProvCiu"));
            objCliProv.setCliprovcod(objrecordset.getInt("CliProvCod"));
            objCliProv.setCliprovcom(objrecordset.getString("CliProvCom"));
            objCliProv.setCliprovdir(objrecordset.getString("CliProvDir"));
            objCliProv.setCliprovema(objrecordset.getString("CliProvEma"));
            objCliProv.setCliprovraz(objrecordset.getString("CliProvRaz"));
            objCliProv.setCliprovfon(objrecordset.getString("CliProvFon"));
            objCliProv.setCliprovgir(objrecordset.getString("CliProvGir"));
            objCliProv.setCliprovrut(objrecordset.getString("CliProvRut"));
            arrayCliProv.add(objCliProv);
            
            
        }
        
        return arrayCliProv;
    } catch (ClassNotFoundException | ParserConfigurationException | SAXException | IOException ex) {
        Logger.getLogger(CliProvModel.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}   
 
public CliProv searchCliProv(int cliprovcod) throws SQLException{
    
    try {
        CliProv objCliProv = new CliProv();
        Conexion auxconexion = new Conexion();
        Connection objconexion = auxconexion.obtener();
        
        Statement stm = objconexion.createStatement();
        String sql = "select * from CliProv where CliProvCod="+String.valueOf(cliprovcod) + " and EmpresaId="+String.valueOf(empresaid);
        
        ResultSet objrecordset = stm.executeQuery(sql);
        
        
        objrecordset.next();
        objCliProv.setCliprovciu(objrecordset.getString("CliProvCiu"));
        objCliProv.setCliprovcod(objrecordset.getInt("CliProvCod"));
        objCliProv.setCliprovcom(objrecordset.getString("CliProvCom"));
        objCliProv.setCliprovdir(objrecordset.getString("CliProvDir"));
        objCliProv.setCliprovema(objrecordset.getString("CliProvEma"));
        objCliProv.setCliprovraz(objrecordset.getString("CliProvRaz"));
        objCliProv.setCliprovfon(objrecordset.getString("CliProvFon"));
        objCliProv.setCliprovrut(objrecordset.getString("CliProvRut"));
        objCliProv.setCliprovgir(objrecordset.getString("CliProvGir")); 
        objCliProv.setCliprovid(objrecordset.getInt("CliProvId"));
        objrecordset = null;
        return objCliProv;
    } catch (ClassNotFoundException | ParserConfigurationException | SAXException | IOException ex) {
        Logger.getLogger(CliProvModel.class.getName()).log(Level.SEVERE, null, ex);
    }
    
return null;
}    



public void addCliProv(CliProv objCliProv) throws SQLException{
    try {
        Conexion auxconexion = new Conexion();
        Connection objconexion = auxconexion.obtener();     
        int cliprovcod = objCliProv.getCliprovcod();
        String cliprovraz = objCliProv.getCliprovraz();
        String cliprovciu = objCliProv.getCliprovciu();
        String cliprovcom = objCliProv.getCliprovcom();
        String cliprovdir = objCliProv.getCliprovdir();
        String cliprovgir = objCliProv.getCliprovgir();
        String cliprovrut = objCliProv.getCliprovrut();
        String cliprovfon = objCliProv.getCliprovfon();
        String cliprovema = objCliProv.getCliprovema();
        Statement stm = objconexion.createStatement();
        String sql = "Insert into CliProv (CliProvCod,CliProvRut,CliProvRaz,CliProvGir,CliProvDir,CliProvCiu,CliProvCom,CliProvFon,CliProvEma,EmpresaId) \n"+
                "values("+String.valueOf(cliprovcod)+",'"+cliprovrut+"','"+cliprovraz+"','"+cliprovgir+"','"+cliprovdir+"',\n"+
                "'"+cliprovciu+"','"+cliprovcom+"','"+cliprovfon +"','"+cliprovema+"',"+String.valueOf(empresaid)+")";
        stm.execute(sql);
        updateCorrelativo();
    } catch (ClassNotFoundException | ParserConfigurationException | SAXException | IOException ex) {
        Logger.getLogger(CliProvModel.class.getName()).log(Level.SEVERE, null, ex);
    }
  
    
}

public void updateCliProv(CliProv objCliProv) throws SQLException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException{
        Conexion auxconexion = new Conexion();
        Connection objconexion = auxconexion.obtener();     
        int cliprovcod = objCliProv.getCliprovcod();
        String cliprovraz = objCliProv.getCliprovraz();
        String cliprovciu = objCliProv.getCliprovciu();
        String cliprovcom = objCliProv.getCliprovcom();
        String cliprovdir = objCliProv.getCliprovdir();
        String cliprovgir = objCliProv.getCliprovgir();
        String cliprovrut = objCliProv.getCliprovrut();
        String cliprovfon = objCliProv.getCliprovfon();
        String cliprovema = objCliProv.getCliprovema();
        Statement stm = objconexion.createStatement();
        String sql = "Update CliProv set \n"+
        "CliProvRaz='"+cliprovraz+"', \n"+
        "CliProvCiu='"+cliprovciu+"', \n"+
        "CliProvCom='"+cliprovcom+"', \n"+
        "CliProvDir='"+cliprovdir+"', \n"+
        "CliProvGir='"+cliprovgir+"', \n"+
        "CliProvRut='"+cliprovrut+"', \n"+
        "CliProvFon='"+cliprovfon+"', \n"+      
        "CliProvEma='"+cliprovema+"' \n"+
        "where CliProvCod=" + String.valueOf(cliprovcod)+"\n"+
        "And EmpresaId="+String.valueOf(this.empresaid);        
         stm.executeUpdate(sql);
        
        System.out.print(sql);
        
        
    
}







 private void updateCorrelativo() throws SQLException{
    try {
        Conexion auxconexion = new Conexion();
        Connection objconexion = auxconexion.obtener();
        
        String sql = "Update Correlativo SET ClienteProveedorCod=ClienteProveedorCod+1 where EmpresaId="+String.valueOf(empresaid);
        Statement stm = objconexion.createStatement();
        stm.executeUpdate(sql);     
    } catch (ClassNotFoundException | ParserConfigurationException | SAXException | IOException ex) {
        Logger.getLogger(CliProvModel.class.getName()).log(Level.SEVERE, null, ex);
    }
 }

public int getCorrelativo() throws SQLException{
    try {
        Conexion auxconexion = new Conexion();
        Connection objconexion = auxconexion.obtener();
        
        int correlativo =  0;
        String sql ="Select * from Correlativo where EmpresaId="+String.valueOf(empresaid);
        Statement stmt = objconexion.createStatement();
        ResultSet objrecordset = stmt.executeQuery(sql);
        while(objrecordset.next()){
        correlativo =  objrecordset.getInt("ClienteProveedorCod");
        }
        return correlativo;
    } catch (ClassNotFoundException | ParserConfigurationException | SAXException | IOException ex) {
        Logger.getLogger(CliProvModel.class.getName()).log(Level.SEVERE, null, ex);
    }
    return 0;
}



public ArrayList<CliProv> searchCod(int cliprovcod) throws SQLException, ClassNotFoundException{
    try {
        Conexion auxconexion = new Conexion();
        Connection objconexion = auxconexion.obtener();
        
        
        
        
        
        ArrayList<CliProv> arraylista = new ArrayList();
        String sql ="Select * from CliProv where CliProvCod="+String.valueOf(cliprovcod)+" and EmpresaId="+String.valueOf(empresaid);
        Statement stmt = objconexion.createStatement();
        ResultSet objrecordset = stmt.executeQuery(sql);
        
        while(objrecordset.next()){
            CliProv objCliProv = new CliProv();
            objCliProv.setCliprovciu(objrecordset.getString("CliProvCiu"));
            objCliProv.setCliprovcod(objrecordset.getInt("CliProvCod"));
            objCliProv.setCliprovcom(objrecordset.getString("CliProvCom"));
            objCliProv.setCliprovdir(objrecordset.getString("CliProvDir"));
            objCliProv.setCliprovema(objrecordset.getString("CliProvEma"));
            objCliProv.setCliprovraz(objrecordset.getString("CliProvRaz"));
            objCliProv.setCliprovfon(objrecordset.getString("CliProvFon"));
            objCliProv.setCliprovgir(objrecordset.getString("CliProvGir"));
            objCliProv.setCliprovrut(objrecordset.getString("CliProvRut"));
            arraylista.add(objCliProv);
        }
        return arraylista;
    } catch (ParserConfigurationException | SAXException | IOException ex) {
        Logger.getLogger(CliProvModel.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}


public ArrayList<CliProv> searchRaz(String cliprovraz) throws SQLException, ClassNotFoundException{  
    try {
        Conexion auxconexion = new Conexion();
        Connection objconexion = auxconexion.obtener();
        ArrayList<CliProv> arraylista = new ArrayList();
        String sql ="Select * from CliProv where CliProvRaz LIKE '"+cliprovraz+"%' and EmpresaId="+String.valueOf(empresaid);
        Statement stmt = objconexion.createStatement();
        ResultSet objrecordset = stmt.executeQuery(sql);
        
        while(objrecordset.next()){
            CliProv objCliProv = new CliProv();
            objCliProv.setCliprovciu(objrecordset.getString("CliProvCiu"));
            objCliProv.setCliprovcod(objrecordset.getInt("CliProvCod"));
            objCliProv.setCliprovcom(objrecordset.getString("CliProvCom"));
            objCliProv.setCliprovdir(objrecordset.getString("CliProvDir"));
            objCliProv.setCliprovema(objrecordset.getString("CliProvEma"));
            objCliProv.setCliprovraz(objrecordset.getString("CliProvRaz"));
            objCliProv.setCliprovfon(objrecordset.getString("CliProvFon"));
            objCliProv.setCliprovgir(objrecordset.getString("CliProvGir"));
            objCliProv.setCliprovrut(objrecordset.getString("CliProvRut"));
            arraylista.add(objCliProv);
        }
        return arraylista;
    } catch (ParserConfigurationException | SAXException | IOException ex) {
        Logger.getLogger(CliProvModel.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}



public ArrayList<CliProv> searchRut(String cliprovrut) throws SQLException, ClassNotFoundException{
       
    try {
        Conexion auxconexion = new Conexion();
        Connection objconexion = auxconexion.obtener();
        
        
        ArrayList<CliProv> arraylista = new ArrayList();
        String sql ="Select * from CliProv where CliProvRut LIKE '"+cliprovrut+"%' and EmpresaId="+String.valueOf(empresaid);
        Statement stmt = objconexion.createStatement();
        ResultSet objrecordset = stmt.executeQuery(sql);
        
        while(objrecordset.next()){
            CliProv objCliProv = new CliProv();
            objCliProv.setCliprovciu(objrecordset.getString("CliProvCiu"));
            objCliProv.setCliprovcod(objrecordset.getInt("CliProvCod"));
            objCliProv.setCliprovcom(objrecordset.getString("CliProvCom"));
            objCliProv.setCliprovdir(objrecordset.getString("CliProvDir"));
            objCliProv.setCliprovema(objrecordset.getString("CliProvEma"));
            objCliProv.setCliprovraz(objrecordset.getString("CliProvRaz"));
            objCliProv.setCliprovfon(objrecordset.getString("CliProvFon"));
            objCliProv.setCliprovgir(objrecordset.getString("CliProvGir"));
            objCliProv.setCliprovrut(objrecordset.getString("CliProvRut"));
            arraylista.add(objCliProv);
        }
        return arraylista;
    } catch (ParserConfigurationException | SAXException | IOException ex) {
        Logger.getLogger(CliProvModel.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}


public int getIdCliProv(String cliprovrut) throws SQLException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException{
    
        Conexion auxconexion = new Conexion();
        Connection objconexion = auxconexion.obtener();
        
        
        String sql ="Select * from CliProv where CliProvRut='"+cliprovrut+"' and EmpresaId="+String.valueOf(empresaid);
        Statement stmt = objconexion.createStatement();
        
        ResultSet objresultset = stmt.executeQuery(sql);
        int id = objresultset.getInt("CliProvId");
    
    
    return id;
}
        





}
