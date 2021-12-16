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
        int cantidadcuentas = cantCuentas(cuentaorigen,nivelcuenta);
        System.out.print(cantidadcuentas);
        String sql= "insert into Cuentas (CuentaCod,CuentaDes,Nivel,CuentaPadre,EmpresaId) \n"+
                    "values("+codcuenta+",'"+ cuentades + "'," + String.valueOf(nivelcuenta )+"," + cuentaorigen  + ",31" +  ")";   
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
        
    


    public int genereCodCuenta(){

        return 0;
    }





    public void updateCuenta(){


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

    public void list__subCuenta(int parmcodcuenta, int nivel){
    
    }
    
    
    
    public void deleteCuenta(){




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
