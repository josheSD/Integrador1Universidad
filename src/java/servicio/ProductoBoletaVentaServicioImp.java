/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.List;
import negocio.ProductoBoletaVenta;
import persistencia.ProductoBoletaVentaDao;
import persistencia.ProductoBoletaVentaDaoImp;

/**
 *
 * @author Lance
 */
public class ProductoBoletaVentaServicioImp implements ProductoBoletaVentaServicio{

    ProductoBoletaVentaDao prodBoleVentDao;
    
    public ProductoBoletaVentaServicioImp(){
        this.prodBoleVentDao = new ProductoBoletaVentaDaoImp();
    }
    
    @Override
    public String grabar(ProductoBoletaVenta prodBoleVent) {
        String msg = prodBoleVentDao.grabar(prodBoleVent);
        if(msg == null){
            msg = "Producto Boleta de Venta grabado con éxito";
        }
        return msg;
    }

    @Override
    public String eliminar(int idBoletaVenta) {
        String msg = prodBoleVentDao.eliminar(idBoletaVenta);
        if(msg == null){
            msg = "Produto Boleta de Venta eliminado con éxito";
        }
        return msg;
    }

    @Override
    public List buscar(int idBoletaVenta) {
        List productoBoletaVenta = prodBoleVentDao.buscar(idBoletaVenta);
        return productoBoletaVenta;
    }
    
}
