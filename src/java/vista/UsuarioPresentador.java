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
public class UsuarioPresentador {
    private String msg = "";
    private Object[] usuario = {"","","","",""};
    private List menu = new ArrayList();
    private List listaTipoUsuario = new ArrayList();

    public UsuarioPresentador() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object[] getUsuario() {
        return usuario;
    }

    public void setUsuario(Object[] usuario) {
        this.usuario = usuario;
    }

    public List getMenu() {
        return menu;
    }

    public void setMenu(List menu) {
        this.menu = menu;
    }

    public List getListaTipoUsuario() {
        return listaTipoUsuario;
    }

    public void setListaTipoUsuario(List listaTipoUsuario){
        this.listaTipoUsuario = listaTipoUsuario;
    }
    
}
