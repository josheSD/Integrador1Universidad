/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.List;
import negocio.Producto;
import persistencia.PedidoDao;
import persistencia.PedidoDaoImp;

/**
 *
 * @author Jose
 */
public class PedidoServicioImp implements PedidoServicio{

    private PedidoDao pedDao;
    
    public PedidoServicioImp(){
        this.pedDao = new PedidoDaoImp();
    }
    
    @Override
    public List agregarProducto(Producto prod, int cant) {
        List cesta = pedDao.agregarProducto(prod, cant);
        return cesta;
    }

    @Override
    public List quitarProducto(int IdProducto) {
        List cesta = pedDao.quitarProducto(IdProducto);
        return cesta;
    }

    @Override
    public List vaciarCesta() {
        List cesta = pedDao.vaciarCesta();
        return cesta;
    }

    @Override
    public List actualizarProducto(Producto prod, int cant, int indice) {
        List cesta = pedDao.actualizarProducto(prod, cant, indice);
        return cesta;
    }
    
}
