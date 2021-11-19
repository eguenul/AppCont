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

public CuentaModel() throws SQLException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException{
        
           Conexion auxconexion = new Conexion();
           conexion = auxconexion.obtener();
      
        
}



    public void addCuenta(int nivelcuenta,int cuentacod, int empresaid) throws SQLException{
           String sql= "";
           Statement stmt = conexion.createStatement();
           stmt.executeQuery(sql);

    }

    public int cantCuentas(int cuentaorigen,int nivelcuenta){


        return 0;
    }


    public int genereCodCuenta(){

        return 0;
    }





    public void updateCuenta(){


    }


    public ArrayList<Cuenta> listCuenta() throws SQLException{
           String sql= "Select * from Cuentas";
           Statement stmt = conexion.createStatement();
           ResultSet objrecordset = stmt.executeQuery(sql);
           ArrayList<Cuenta> arraylistcuenta = new ArrayList<>();

        while(objrecordset.next()) {
           Cuenta objCuenta = new Cuenta();
           objCuenta.setCuentacod(objrecordset.getInt("CuentaCod"));
           objCuenta.setCuentanom(objrecordset.getString("CuentaDes"));
           objCuenta.setCuentanivel(objrecordset.getInt("Nivel"));
           arraylistcuenta.add(objCuenta);
          }
           return arraylistcuenta;
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



    
    

}
