/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jose
 */
public class LineaBoletaVenta {
    
    private Producto prod;
    private int cant;

    public LineaBoletaVenta(){
        
    }
    
    public LineaBoletaVenta(Producto prod, int cant) {
        this.prod = prod;
        this.cant = cant;
    }

    public Producto getProd() {
        return prod;
    }

    public void setProd(Producto prod) {
        this.prod = prod;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
    
    public double getImp(){
        return prod.getPrecioUnitario() * cant;
    }
    
}
