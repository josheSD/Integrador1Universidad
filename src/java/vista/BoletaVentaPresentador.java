/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lance
 */
public class BoletaVentaPresentador {
    
    private String msg = "";
    private String tipoAccion = "";
    private Object[] boletaVenta = {"","","","","","","",""};
    private List listaBoletaVenta = new ArrayList();

    public BoletaVentaPresentador(){}
    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(String tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    public Object[] getBoletaVenta() {
        return boletaVenta;
    }

    public void setBoletaVenta(Object[] boletaVenta) {
        this.boletaVenta = boletaVenta;
    }

    public List getListaBoletaVenta() {
        return listaBoletaVenta;
    }

    public void setListaBoletaVenta(List listaBoletaVenta) {
        this.listaBoletaVenta = listaBoletaVenta;
    }
    
}
