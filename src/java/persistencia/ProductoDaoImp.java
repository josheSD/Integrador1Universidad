/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.Producto;

/**
 *
 * @author Lance
 */
public class ProductoDaoImp implements ProductoDao{

    @Override
    public String grabar(Producto prod) {
        String sql = "INSERT INTO producto(Nombre,PrecioUnitario,Cantidad) VALUES('"+ prod.getNombre()+"',"+prod.getPrecioUnitario()+","+prod.getCantidad()+")";
        return Operacion.ejecutar(sql);
    }

    @Override
    public String actualizar(Producto prod, int idProducto) {
        String sql = "UPDATE producto SET Nombre = '"+prod.getNombre()+"', PrecioUnitario = "+prod.getPrecioUnitario()+", Cantidad = "+prod.getCantidad()+" WHERE IdProducto = "+idProducto+"";
        return Operacion.ejecutar(sql);
    }

    @Override
    public String eliminar(int idProducto) {
        String sql = "DELETE FROM producto WHERE IdProducto = "+idProducto+"";
        return Operacion.ejecutar(sql);
    }

    @Override
    public List lista() {
        String sql = "SELECT * FROM producto;";
        return Operacion.listar(sql);
    }
    
}
