/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.List;
import negocio.Producto;
import persistencia.ProductoDao;
import persistencia.ProductoDaoImp;

/**
 *
 * @author Lance
 */
public class ProductoServicioImp implements ProductoServicio{

    private ProductoDao prodDao;
    
    public ProductoServicioImp(){
        this.prodDao = new ProductoDaoImp();
    }
    
    @Override
    public String grabar(Producto prod) {
        String msg = prodDao.grabar(prod);
        if(msg == null){
            msg = "Producto grabado con éxito";
        }
        return msg;
    }

    @Override
    public String actualizar(Producto prod, int idProducto) {
        String msg = prodDao.actualizar(prod,idProducto);
        if(msg == null){
            msg = "Producto actualizado con éxito";
        }
        return msg;
    }

    @Override
    public String eliminar(int idProducto) {
        String msg = prodDao.eliminar(idProducto);
        if(msg == null){
            msg = "Producto eliminado con éxito";
        }
        return msg;
    }

    @Override
    public List lista() {
        List listaProducto = prodDao.lista();
        return listaProducto;
    }
    
}
