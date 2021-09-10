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
    
    
    
}











