/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcont.cuentas;

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
public class CuentaModel {
    
private final Connection conexion;

public CuentaModel(String pathservlet) throws SQLException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException{
        
           Conexion auxconexion = new Conexion(pathservlet);
           conexion = auxconexion.obtener();
      
        
}



    public void addCuenta(String codcuenta, int nivelcuenta,int cuentaorigen, String cuentades ,int empresaid) throws SQLException{
   
        
        int auxcuenta = 0;
        boolean flagcuenta = buscaCuenta(cuentaorigen,nivelcuenta);
      if (flagcuenta == false ){ 
         auxcuenta = genereCodCuenta(cuentaorigen,nivelcuenta,flagcuenta);
      }else{
          
          auxcuenta = genereCodCuenta2(cuentaorigen,nivelcuenta);
          
      }
        String sql= "insert into Cuentas (CuentaCod,CuentaDes,Nivel,CuentaPadre,EmpresaId) \n"+
                    "values("+auxcuenta+",'"+ cuentades + "'," + String.valueOf(nivelcuenta )+"," + cuentaorigen  + ",31" +  ")";   
        System.out.print(sql);
        Statement stmt = conexion.createStatement(); 
       
        stmt.execute(sql);
       
        }

    public int cantCuentas(int cuentaorigen,int nivelcuenta) throws SQLException{
           String sql= "Select count(*) as Cantidad from Cuentas where CuentaPadre="+String.valueOf(cuentaorigen) + " and Nivel="+nivelcuenta;
           Statement stmt = conexion.createStatement();
           ResultSet objRecordset = stmt.executeQuery(sql);
        if(objRecordset.next()==true){
           return objRecordset.getInt("Cantidad");
        
        }else{
            return 0;
        }
        }
    
    
    
     public int conteoCuentas() throws SQLException{
           String sql= "Select count(*) as Cantidad from Cuentas";
           Statement stmt = conexion.createStatement();
           ResultSet objRecordset = stmt.executeQuery(sql);
        if(objRecordset.next()==true){
           return objRecordset.getInt("Cantidad");
        
        }else{
            return 0;
        }
        }
     
     
     
      public ArrayList<Cuenta> listCuentalimit(int begin, int pageSize) throws SQLException{
           String sql= "Select * from Cuentas Order By CuentaCod  ASC limit " + String.valueOf(begin) + "," + String.valueOf(pageSize) ;
           Statement stmt = conexion.createStatement();
           ResultSet objrecordset = stmt.executeQuery(sql);
           ArrayList<Cuenta> arraylistcuenta = new ArrayList<>();

       
               while(objrecordset.next()){
                   
                    Cuenta objCuenta2 = new Cuenta();
                    objCuenta2.setCuentacod(objrecordset.getInt("CuentaCod"));
                    objCuenta2.setCuentanom(objrecordset.getString("CuentaDes"));
                    objCuenta2.setCuentanivel(objrecordset.getInt("Nivel"));
                    arraylistcuenta.add(objCuenta2);
               }
               
               
          
         
           return arraylistcuenta;
    }     
      
    
    public boolean buscaCuenta(int cuentacod, int nivelcuenta) throws SQLException{
          
        /* busco la ultima cuenta generada */
              
         String sql= "Select CuentaCod from Cuentas where CuentaPadre="+String.valueOf(cuentacod) + " and Nivel="+nivelcuenta + " Order By CuentaCod DESC limit 0,1";
         System.out.print(sql);
         Statement stmt = conexion.createStatement();
           ResultSet objRecordset = stmt.executeQuery(sql);
        if(objRecordset.next()==true){
             System.out.print("cuenta existente");
           return true;
        
        }else{
                
             System.out.print("cuenta nueva");
            return false;
        }
        
    }
    
    
    public int getCuentaCod(int cuentacod, int nivelcuenta) throws SQLException{
          
        /* busco la ultima cuenta generada */
         String sql= "Select CuentaCod from Cuentas where CuentaPadre="+String.valueOf(cuentacod) + " and Nivel="+nivelcuenta + " Order By CuentaCod DESC limit 0,1";
         System.out.print(sql);
         Statement stmt = conexion.createStatement();
         ResultSet objRecordset = stmt.executeQuery(sql);
         
         if (objRecordset.next()==true){
         return objRecordset.getInt("CuentaCod");
  
         }else{
             
             return 0;
         }
         }
    
    
    
    


    public int genereCodCuenta(int cuentapadre, int cuentanivel, boolean flagcuenta){
       int codigocuenta = 0;
        switch(cuentanivel){
            
            
            case 2: codigocuenta = cuentapadre + 100000;
                
                    break;
            
                    
            case 3:codigocuenta = cuentapadre + 10000;
                
                    break;
                    
            case 4: codigocuenta = cuentapadre + 1000;
                
                    break;
                    
                    
            case 5:codigocuenta = cuentapadre + 100;
                
                    break;
                  
            case 6: codigocuenta = cuentapadre + 10;
                
                    break;
                
                    
        }
        
        
        return codigocuenta;
    }

 public int genereCodCuenta2(int cuentacod, int cuentanivel) throws SQLException{
            int codigocuenta = getCuentaCod(cuentacod,cuentanivel);
             switch(cuentanivel){
            
            
            case 2: codigocuenta = codigocuenta + 100000;
                
                    break;
            
                    
            case 3:codigocuenta = codigocuenta + 10000;
                
                    break;
                    
            case 4: codigocuenta = codigocuenta + 1000;
                
                    break;
                    
                    
            case 5:codigocuenta = codigocuenta + 100;
                
                    break;
                  
            case 6: codigocuenta = codigocuenta + 10;
                
                    break;
                
                    
        }
        
        
        return codigocuenta;
          
 }



    public void updateCuenta(int cuentacod, String cuentades) throws SQLException{
         String sql= "Update Cuentas set CuentaDes='"+cuentades + "' Where CuentaCod=" + String.valueOf(cuentacod);
         System.out.print(sql);
         Statement stmt = conexion.createStatement();
         stmt.execute(sql);

    }


    
    public void deleteCuenta(int cuentacod) throws SQLException{
          String sql= "Delete from Cuentas Where CuentaCod=" + String.valueOf(cuentacod);
         System.out.print(sql);
         Statement stmt = conexion.createStatement();
         stmt.execute(sql);



    }

    
    
    
    
    public ArrayList<Cuenta> listCuenta() throws SQLException{
           String sql= "Select * from Cuentas Order By CuentaCod  ASC";
           Statement stmt = conexion.createStatement();
           ResultSet objrecordset = stmt.executeQuery(sql);
           ArrayList<Cuenta> arraylistcuenta = new ArrayList<>();

       
               while(objrecordset.next()){
                   
                    Cuenta objCuenta2 = new Cuenta();
                    objCuenta2.setCuentacod(objrecordset.getInt("CuentaCod"));
                    objCuenta2.setCuentanom(objrecordset.getString("CuentaDes"));
                    objCuenta2.setCuentanivel(objrecordset.getInt("Nivel"));
                    arraylistcuenta.add(objCuenta2);
               }
               
               
          
         
           return arraylistcuenta;
    }     

    
    
    
    
    

    public int getIDCuenta(){


                           return 0;
    }

    public Cuenta getDataCuenta(){

            Cuenta objCuenta = new Cuenta();

            return objCuenta;

    }

    public void clonarCuenta(){


    }

    
    

}
