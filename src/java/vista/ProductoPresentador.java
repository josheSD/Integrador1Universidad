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
public class ProductoPresentador {

    private String msg = "";
    private String tipoAccion = "";
    private Object[] producto = {"","","",""};
    private List listaProducto = new ArrayList();
    
    public ProductoPresentador(){
    }

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

    public Object[] getProducto() {
        return producto;
    }

    public void setProducto(Object[] producto) {
        this.producto = producto;
    }
    
    public List getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List listaProducto) {
        this.listaProducto = listaProducto;
    }
    
}
