/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.List;
import negocio.Producto;

/**
 *
 * @author Lance
 */
public interface ProductoServicio {
    public String grabar(Producto prod);
    public String actualizar(Producto prod,int idProducto);
    public String eliminar(int idProducto);
    public List lista();
    public Producto buscar(int idProducto);
}
