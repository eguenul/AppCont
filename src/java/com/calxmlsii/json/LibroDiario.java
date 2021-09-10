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
public class LibroDiario {
    private ArrayList<Comprobante> detallecomprobante;

    public ArrayList<Comprobante> getDetallecomprobante() {
        return detallecomprobante;
    }

    public void setDetallecomprobante(ArrayList<Comprobante> detallecomprobante) {
        this.detallecomprobante = detallecomprobante;
    }
}
