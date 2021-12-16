/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and oponten the template in the editor.
 */
package appcont.empresa;

import appcont.include.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class EmpresaModel {

    private int empresacod;     
    private String empresaraz;
    private String empresarut;
    private String empresagir;
    private String empresaema;
    private String empresadir;
    private String empresafon;
    private String empresaciu;
    private final Connection conexion;
    private int sucursalsiicod;
    private int empresaacteco;
    private int nroresol;
    private String fecharesol;
    private String empresacom;
    private String oficinasii;
    
    public EmpresaModel(String pathservlet) throws SQLException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException{
        Conexion auxconexion = new Conexion(pathservlet);
        conexion = auxconexion.obtener();
      
  }  
    
 
public void addEmpresa(Empresa objEmpresa) throws SQLException{
    Statement smt1 = conexion.createStatement();
    ResultSet objrecordset = smt1.executeQuery("Select * from Correlativo2");
    
    while(objrecordset.next()){
       empresacod = objrecordset.getInt("EmpresaCod");
    }
    
    empresaraz = objEmpresa.getEmpresaraz();
    empresarut = objEmpresa.getEmpresarut();
    empresagir = objEmpresa.getEmpresagir();
    empresadir = objEmpresa.getEmpresadir();
    empresaema = objEmpresa.getEmpresaema();
    empresafon = objEmpresa.getEmpresafon();
    empresaciu = objEmpresa.getEmpresaciu();
    empresacom = objEmpresa.getEmpresacom();
    empresaacteco = objEmpresa.getEmpresaacteco();
    sucursalsiicod = objEmpresa.getSucursalsiicod();
    nroresol = objEmpresa.getEmpresanumresol();
    fecharesol = objEmpresa.getEmpresafechresol();  
    oficinasii = objEmpresa.getOficinasii();
    String sql;
    sql = "insert into Empresa (EmpresaCod,EmpresaRaz,EmpresaRut,EmpresaGir, \n"+
    "EmpresaDir,EmpresaFon,EmpresaCom,EmpresaCiu,EmpresaEma,EmpresaActeco,EmpresaFechaResolucion,EmpresaResolucionNum, \n"+        
    "SucursalSiiCod, EmpresaOficinaSii) values("+String.valueOf(empresacod)+",'"+ empresaraz+"','"+empresarut+"','"+empresagir+"' \n"+
    ",'"+empresadir+"',"+"'"+empresafon +"','"+empresacom+"','"+empresaciu+"'\n"+
    ",'"+empresaema+"',"+String.valueOf(empresaacteco)+",'"+fecharesol+"',"+String.valueOf(nroresol)+","+String.valueOf(sucursalsiicod)+",'"+ oficinasii + "'"+  ")";        
    System.out.print(sql);
    Statement smt = conexion.createStatement();
    smt.execute(sql);
    smt.execute("Update Correlativo2 set EmpresaCod = EmpresaCod+1");
    objEmpresa = searchEmpresa(empresacod);
    smt.execute("Insert into Correlativo (EmpresaId) values("+String.valueOf(objEmpresa.getEmpresaid()) +")");
  
}


public void updateEmpresa(Empresa objEmpresa) throws SQLException{
    
    
    empresacod = objEmpresa.getEmpresacod(); 
    empresaraz = objEmpresa.getEmpresaraz();
    empresarut = objEmpresa.getEmpresarut();
    empresagir = objEmpresa.getEmpresagir();
    empresadir = objEmpresa.getEmpresadir();
    empresaema = objEmpresa.getEmpresaema();
    empresafon = objEmpresa.getEmpresafon();
    empresaciu = objEmpresa.getEmpresaciu();
    empresacom = objEmpresa.getEmpresacom();
    empresaacteco = objEmpresa.getEmpresaacteco();
    sucursalsiicod = objEmpresa.getSucursalsiicod();
    
    nroresol = objEmpresa.getEmpresanumresol();
    fecharesol = objEmpresa.getEmpresafechresol();  
     oficinasii = objEmpresa.getOficinasii();
    String sql;
    sql = "Update Empresa set EmpresaRaz='"+empresaraz+"',\n"+
           "EmpresaRut='"+empresarut+"',\n"+
           "EmpresaGir='"+empresagir+"',\n"+
           "EmpresaDir='"+empresadir+"',\n"+
           "EmpresaEma='"+empresaema+"',\n"+
           "EmpresaFon='"+empresafon+"',\n"+
           "EmpresaCiu='"+empresaciu+"',\n"+
           "EmpresaCom='"+empresacom+"',\n"+
           "EmpresaResolucionNum="+String.valueOf(nroresol)+",\n"+  
           "EmpresaActeco="+String.valueOf(empresaacteco)+", \n"+
           "SucursalSiiCod="+String.valueOf(sucursalsiicod)+",\n"+
           "EmpresaFechaResolucion='"+fecharesol+"',\n"+         
            "EmpresaOficinaSii='"+oficinasii+"' \n"+
            "Where EmpresaCod="+String.valueOf(empresacod);
    
    System.out.print(sql);
    Statement smt = conexion.createStatement();
    smt.execute(sql);
   
   
}




public ArrayList<Empresa> listEmpresa() throws SQLException{
    
    ArrayList<Empresa> arraylista = new ArrayList<>();
    String sql = "Select * from Empresa";
    
    Statement smt = conexion.createStatement();
    
    ResultSet objrecordset = smt.executeQuery(sql);
    
    while(objrecordset.next()){
       
        Empresa objEmpresa = new Empresa();
        objEmpresa.setEmpresarut(objrecordset.getString("EmpresaRut"));
        objEmpresa.setEmpresacod(objrecordset.getInt("EmpresaCod"));
        objEmpresa.setEmpresaraz(objrecordset.getString("EmpresaRaz")); 
        objEmpresa.setEmpresaid(objrecordset.getInt("EmpresaId"));
        arraylista.add(objEmpresa);
        
    }
    
    
    return arraylista;
}





public ArrayList<Empresa> listEmpresa2() throws SQLException{
    
    ArrayList<Empresa> arraylista = new ArrayList<>();
    String sql = "Select * from Empresa limit 0,10";
    
    Statement smt = conexion.createStatement();
    
    ResultSet objrecordset = smt.executeQuery(sql);
    
    while(objrecordset.next()){
       
        Empresa objEmpresa = new Empresa();
        objEmpresa.setEmpresarut(objrecordset.getString("EmpresaRut"));
        objEmpresa.setEmpresacod(objrecordset.getInt("EmpresaCod"));
        objEmpresa.setEmpresaraz(objrecordset.getString("EmpresaRaz")); 
        arraylista.add(objEmpresa);
        
    }
    
    
    return arraylista;
}






public Empresa searchEmpresa(int parametro) throws SQLException{
    
        Empresa  objEmpresa = new Empresa();
        Statement stm = conexion.createStatement();
        String sql = "select * from Empresa where EmpresaCod="+String.valueOf(parametro);
        System.out.print(sql);
        ResultSet objrecordset = stm.executeQuery(sql);

    
        objrecordset.next();
        objEmpresa.setEmpresaciu(objrecordset.getString("EmpresaCiu"));
        objEmpresa.setEmpresacod(objrecordset.getInt("EmpresaCod"));
        objEmpresa.setEmpresacom(objrecordset.getString("EmpresaCom"));
        objEmpresa.setEmpresadir(objrecordset.getString("EmpresaDir"));
      /*
        objEmpresa.setEmpresaema(objrecordset.getString("CliProvEma"));
      */        
        objEmpresa.setEmpresaraz(objrecordset.getString("EmpresaRaz"));
        objEmpresa.setEmpresafon(objrecordset.getString("EmpresaFon"));
        objEmpresa.setEmpresarut(objrecordset.getString("EmpresaRut"));
        objEmpresa.setEmpresagir(objrecordset.getString("EmpresaGir")); 
        objEmpresa.setEmpresaid(objrecordset.getInt("EmpresaId"));
        
        objEmpresa.setEmpresaacteco(objrecordset.getInt("EmpresaActeco"));
        objEmpresa.setEmpresafechresol(objrecordset.getString("EmpresaFechaResolucion"));
        objEmpresa.setEmpresanumresol(objrecordset.getInt("EmpresaResolucionNum"));
        objEmpresa.setSucursalsiicod(objrecordset.getInt("SucursalSiiCod"));
        objEmpresa.setEmpresaema(objrecordset.getString("EmpresaEma"));
        objEmpresa.setOficinasii(objrecordset.getString("EmpresaOficinaSii"));
        return objEmpresa;
   
}






public ArrayList<Empresa> searchCod(int empresacod) throws SQLException, ClassNotFoundException{
       ArrayList<Empresa> arraylista = new ArrayList<>();
       String sql ="Select * from Empresa where EmpresaCod="+String.valueOf(empresacod);
       Statement stmt = conexion.createStatement();
       ResultSet objrecordset = stmt.executeQuery(sql);
       
    while(objrecordset.next()){
       Empresa objEmpresa = new Empresa(); 
        objEmpresa.setEmpresaciu(objrecordset.getString("EmpresaCiu"));
        objEmpresa.setEmpresacod(objrecordset.getInt("EmpresaCod"));
        objEmpresa.setEmpresacom(objrecordset.getString("EmpresaCom"));
        objEmpresa.setEmpresadir(objrecordset.getString("EmpresaDir"));
        objEmpresa.setEmpresaema(objrecordset.getString("EmpresaEma"));
        objEmpresa.setEmpresaraz(objrecordset.getString("EmpresaRaz"));
        objEmpresa.setEmpresafon(objrecordset.getString("EmpresaFon"));
        objEmpresa.setEmpresagir(objrecordset.getString("EmpresaGir"));
        objEmpresa.setEmpresarut(objrecordset.getString("EmpresaRut"));
        
        objEmpresa.setEmpresaacteco(objrecordset.getInt("EmpresaActeco"));
        objEmpresa.setEmpresafechresol(objrecordset.getString("EmpresaFechaResolucion"));
        objEmpresa.setEmpresanumresol(objrecordset.getInt("EmpresaResolucionNum"));
        
        objEmpresa.setSucursalsiicod(objrecordset.getInt("SucursalSiiCod"));
        
        arraylista.add(objEmpresa);
    }
        return arraylista;
}


public ArrayList<Empresa> searchRaz(String empresaraz) throws SQLException, ClassNotFoundException{
       ArrayList<Empresa> arraylista = new ArrayList<>();
       String sql ="Select * from Empresa where EmpresaRaz LIKE '"+empresaraz+"%'";
       Statement stmt = conexion.createStatement();
       ResultSet objrecordset = stmt.executeQuery(sql);
       
    while(objrecordset.next()){
       Empresa objEmpresa = new Empresa(); 
        objEmpresa.setEmpresaciu(objrecordset.getString("EmpresaCiu"));
        objEmpresa.setEmpresacod(objrecordset.getInt("EmpresaCod"));
        objEmpresa.setEmpresacom(objrecordset.getString("EmpresaCom"));
        objEmpresa.setEmpresadir(objrecordset.getString("EmpresaDir"));
        objEmpresa.setEmpresaema(objrecordset.getString("EmpresaEma"));
        objEmpresa.setEmpresaraz(objrecordset.getString("EmpresaRaz"));
        objEmpresa.setEmpresafon(objrecordset.getString("EmpresaFon"));
        objEmpresa.setEmpresagir(objrecordset.getString("EmpresaGir"));
        objEmpresa.setEmpresarut(objrecordset.getString("EmpresaRut"));
        
         objEmpresa.setEmpresaacteco(objrecordset.getInt("EmpresaActeco"));
        objEmpresa.setEmpresafechresol(objrecordset.getString("EmpresaFechaResolucion"));
        objEmpresa.setEmpresanumresol(objrecordset.getInt("EmpresaResolucionNum"));
          objEmpresa.setSucursalsiicod(objrecordset.getInt("SucursalSiiCod"));
        arraylista.add(objEmpresa);
    }
        return arraylista;
}



public ArrayList<Empresa> searchRut(String empresarut) throws SQLException, ClassNotFoundException{
       ArrayList<Empresa> arraylista = new ArrayList<>();
       String sql ="Select * FROM Empresa where EmpresaRut LIKE '"+empresarut+"%'";
       Statement stmt = conexion.createStatement();
       ResultSet objrecordset = stmt.executeQuery(sql);
       
    while(objrecordset.next()){
        Empresa objEmpresa = new Empresa(); 
        objEmpresa.setEmpresaciu(objrecordset.getString("EmpresaCiu"));
        objEmpresa.setEmpresacod(objrecordset.getInt("EmpresaCod"));
        objEmpresa.setEmpresacom(objrecordset.getString("EmpresaCom"));
        objEmpresa.setEmpresadir(objrecordset.getString("EmpresaDir"));
        objEmpresa.setEmpresaema(objrecordset.getString("EmpresaEma"));
        objEmpresa.setEmpresaraz(objrecordset.getString("EmpresaRaz"));
        objEmpresa.setEmpresafon(objrecordset.getString("EmpresaFon"));
        objEmpresa.setEmpresagir(objrecordset.getString("EmpresaGir"));
        objEmpresa.setEmpresarut(objrecordset.getString("EmpresaRut"));
        
        
        objEmpresa.setEmpresaacteco(objrecordset.getInt("EmpresaActeco"));
        objEmpresa.setEmpresafechresol(objrecordset.getString("EmpresaFechaResolucion"));
        objEmpresa.setEmpresanumresol(objrecordset.getInt("EmpresaResolucionNum"));
        
        
        objEmpresa.setSucursalsiicod(objrecordset.getInt("SucursalSiiCod"));
        
        
        arraylista.add(objEmpresa);    
        
        
        
        
    }
        return arraylista;
}




public int getidEmpresa(String parm1) throws SQLException{
       String sql ="Select * FROM Empresa where EmpresaRaz='"+parm1+"'";  
       Statement stmt = conexion.createStatement();
       ResultSet objrecordset = stmt.executeQuery(sql);
       int empresaid =0;
       
       while(objrecordset.next()){
          empresaid  = objrecordset.getInt("EmpresaId");
       }
       return empresaid;
    
}




public Empresa getData(int empresaid) throws SQLException{

    String sql ="Select * FROM Empresa where EmpresaId="+String.valueOf(empresaid);
    Statement stmt = conexion.createStatement();
    ResultSet objrecordset = stmt.executeQuery(sql);
    Empresa objEmpresa = new Empresa(); 
       
    while(objrecordset.next()){
        objEmpresa.setEmpresaciu(objrecordset.getString("EmpresaCiu"));
        objEmpresa.setEmpresacod(objrecordset.getInt("EmpresaCod"));
        objEmpresa.setEmpresacom(objrecordset.getString("EmpresaCom"));
        objEmpresa.setEmpresadir(objrecordset.getString("EmpresaDir"));
        objEmpresa.setEmpresaema(objrecordset.getString("EmpresaEma"));
        objEmpresa.setEmpresaraz(objrecordset.getString("EmpresaRaz"));
        objEmpresa.setEmpresafon(objrecordset.getString("EmpresaFon"));
        objEmpresa.setEmpresagir(objrecordset.getString("EmpresaGir"));
        objEmpresa.setEmpresarut(objrecordset.getString("EmpresaRut"));
        objEmpresa.setEmpresaacteco(objrecordset.getInt("EmpresaActeco"));
        objEmpresa.setEmpresafechresol(objrecordset.getString("EmpresaFechaResolucion"));
        objEmpresa.setEmpresanumresol(objrecordset.getInt("EmpresaResolucionNum"));
        objEmpresa.setSucursalsiicod(objrecordset.getInt("SucursalSiiCod"));
        objEmpresa.setEmpresaid(objrecordset.getInt("EmpresaId"));
    }
    
    return objEmpresa;
    
}
}
