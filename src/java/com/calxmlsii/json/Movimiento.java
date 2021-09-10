/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.calxmlsii.json;

/**
 *
 * @author esteban
 */
public class Movimiento {
private  String CodigoCuenta;
 private String TpoDocum;
 private String Numero;
 private String Debe;
 private String Haber;         

    public String getCodigoCuenta() {
        return CodigoCuenta;
    }

    public void setCodigoCuenta(String CodigoCuenta) {
        this.CodigoCuenta = CodigoCuenta;
    }

    public String getTpoDocum() {
        return TpoDocum;
    }

    public void setTpoDocum(String TpoDocum) {
        this.TpoDocum = TpoDocum;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getDebe() {
        return Debe;
    }

    public void setDebe(String Debe) {
        this.Debe = Debe;
    }

    public String getHaber() {
        return Haber;
    }

    public void setHaber(String Haber) {
        this.Haber = Haber;
    }
}
