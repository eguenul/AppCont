/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.calxmlsii.json;

import java.util.ArrayList;

/**
 *
 * @author esteban
 */
public class Comprobante {
 private   String  TpoComp;
 private   String  NumComp;
 private   String FechaContable;
 private   String GlosaAnalisis;
 private  ArrayList<Movimiento> detalleMovimiento;
 
 public Comprobante(){
    
 }
       
 
    public String getTpoComp() {
        return TpoComp;
    }

    public void setTpoComp(String TpoComp) {
        this.TpoComp = TpoComp;
    }

    public String getNumComp() {
        return NumComp;
    }

    public void setNumComp(String NumComp) {
        this.NumComp = NumComp;
    }

    public String getFechaContable() {
        return FechaContable;
    }

    public void setFechaContable(String FechaContable) {
        this.FechaContable = FechaContable;
    }

    public String getGlosaAnalisis() {
        return GlosaAnalisis;
    }

    public void setGlosaAnalisis(String GlosaAnalisis) {
        this.GlosaAnalisis = GlosaAnalisis;
    }

    public ArrayList<Movimiento> getDetalleMovimiento() {
        return detalleMovimiento;
    }
 
    public void setDetalleMovimiento(ArrayList<Movimiento> detalleMovimiento ){
        this.detalleMovimiento = detalleMovimiento;
    }
 
 
}
