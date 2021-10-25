/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcont.movimiento;

import appcont.cliprov.CliProv;
import appcont.documento.Documento;

/**
 *
 * @author esteban
 */
public class Movimiento {
    
  private  CliProv cliprov;
  private int numdoc;
  private int montoexento;
  private int montoafecto;
  private int montoiva;
  private int montototal;
 private String fechadoc;
    public int getMontoexento() {
        return montoexento;
    }

    public void setMontoexento(int montoexento) {
        this.montoexento = montoexento;
    }

    public int getMontoafecto() {
        return montoafecto;
    }

    public void setMontoafecto(int montoafecto) {
        this.montoafecto = montoafecto;
    }

    public int getMontoiva() {
        return montoiva;
    }

    public void setMontoiva(int montoiva) {
        this.montoiva = montoiva;
    }

    public int getMontototal() {
        return montototal;
    }

    public void setMontototal(int montototal) {
        this.montototal = montototal;
    }
  
  
  private Documento tipodocumento;       

    public CliProv getCliprov() {
        return cliprov;
    }

    public void setCliprov(CliProv cliprov) {
        this.cliprov = cliprov;
    }

    public Documento getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(Documento tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getFechadoc() {
        return fechadoc;
    }

    public void setFechadoc(String fechadoc) {
        this.fechadoc = fechadoc;
    }

    public int getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(int numdoc) {
        this.numdoc = numdoc;
    }
    
    
    
}











