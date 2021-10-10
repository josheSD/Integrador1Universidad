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
 * @author Jose
 */
public class PedidoPresentador {
    
    private Object[] productoPedido = {"","","","","","","",""};
    private List listaPedido = new ArrayList<>();
    
    public PedidoPresentador(){
        
    }

    public Object[] getProductoPedido() {
        return productoPedido;
    }

    public void setProductoPedido(Object[] productoPedido) {
        this.productoPedido = productoPedido;
    }

    public List getListaPedido() {
        return listaPedido;
    }

    public void setListaPedido(List listaPedido) {
        this.listaPedido = listaPedido;
    }

    
    
}
