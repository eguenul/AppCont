/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcont.cuentas;

/**
 *
 * @author esteban
 */
public class Cuenta {
    
    
    private int cuentacod;
    private int cuentaid;
    private int empresaid;
    private int cuentanivel;
    private int cuentapadre;

    public int getCuentapadre() {
        return cuentapadre;
    }

    public void setCuentapadre(int cuentapadre) {
        this.cuentapadre = cuentapadre;
    }
    private String cuentanom;

    public int getCuentacod() {
        return cuentacod;
    }

    public void setCuentacod(int cuentacod) {
        this.cuentacod = cuentacod;
    }

    public int getCuentaid() {
        return cuentaid;
    }

    public void setCuentaid(int cuentaid) {
        this.cuentaid = cuentaid;
    }

    public int getEmpresaid() {
        return empresaid;
    }

    public void setEmpresaid(int empresaid) {
        this.empresaid = empresaid;
    }

    public int getCuentanivel() {
        return cuentanivel;
    }

    public void setCuentanivel(int cuentanivel) {
        this.cuentanivel = cuentanivel;
    }

    public String getCuentanom() {
        return cuentanom;
    }

    public void setCuentanom(String cuentanom) {
        this.cuentanom = cuentanom;
    }
            
  
}
