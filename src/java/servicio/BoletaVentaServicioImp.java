/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.List;
import negocio.BoletaVenta;
import persistencia.BoletaVentaDao;
import persistencia.BoletaVentaDaoImp;

/**
 *
 * @author Lance
 */
public class BoletaVentaServicioImp implements BoletaVentaServicio{

    private BoletaVentaDao boleVentDao;
    
    public BoletaVentaServicioImp(){
        this.boleVentDao = new BoletaVentaDaoImp();
    }
    
    @Override
    public Object[] grabar(BoletaVenta boleVent) {
        Object[] boletaVenta = boleVentDao.grabar(boleVent);
        return boletaVenta;
    }

    @Override
    public String actualizar(BoletaVenta boleVent, int idBoletaVenta) {
        String msg = boleVentDao.actualizar(boleVent,idBoletaVenta);
        if(msg == null){
            msg = "Boleta de Venta actualizado con éxito";
        }
        return msg;
    }

    @Override
    public String eliminar(int idBoletaVenta) {
        String msg = boleVentDao.eliminar(idBoletaVenta);
        if( msg == null){
            msg = "Boleta de Venta eliminado con éxito";
        }
        return msg;
    }

    @Override
    public List lista(int idTipoUsuario) {
        List listaProducto = boleVentDao.lista(idTipoUsuario);
        return listaProducto;
    }

    @Override
    public String aprobar(int idBoletaVenta) {
        String msg = boleVentDao.aprobar(idBoletaVenta);
        if( msg == null ){
            msg = "Boleta de Venta actualizado con éxito";
        }
        return msg;
    }
    
}
