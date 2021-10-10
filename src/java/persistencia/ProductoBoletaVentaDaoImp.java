/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.ProductoBoletaVenta;

/**
 *
 * @author Lance
 */
public class ProductoBoletaVentaDaoImp implements ProductoBoletaVentaDao{

    @Override
    public String grabar(ProductoBoletaVenta prodBoleVent) {
        String sql = "INSERT INTO productoboletaventa(Importe,Cantidad,IdBoletaVenta,IdProducto) VALUES("+prodBoleVent.getImporte()+","+prodBoleVent.getCantidad()+","+prodBoleVent.getIdBoletaVenta()+","+prodBoleVent.getIdProducto()+")";
        return Operacion.ejecutar(sql);
    }

    @Override
    public String eliminar(int idBoletaVenta) {
        String sql = "DELETE FROM productoboletaventa WHERE IdBoletaVenta = "+idBoletaVenta+"";
        return Operacion.ejecutar(sql);
    }

    @Override
    public List buscar(int idBoletaVenta) {
        String sql = "SELECT P.*, PBV.Cantidad AS PBVCantidad FROM boletaventa AS BV INNER JOIN productoboletaventa AS PBV ON BV.IdBoletaVenta = PBV.IdBoletaVenta INNER JOIN producto AS P ON P.IdProducto = PBV.IdProducto WHERE BV.IdBoletaVenta = "+idBoletaVenta+"";
        return Operacion.listar(sql);
    }
    
}
