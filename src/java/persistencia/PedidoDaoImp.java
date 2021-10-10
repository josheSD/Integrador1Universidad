/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.ArrayList;
import java.util.List;
import negocio.LineaBoletaVenta;
import negocio.Pedido;
import negocio.Producto;

/**
 *
 * @author Jose
 */
public class PedidoDaoImp implements PedidoDao{

    private Pedido ped;
    
    public PedidoDaoImp(){
        this.ped = new Pedido();
    }
    
    @Override
    public List agregarProducto(Producto prod, int cant) {
        ped.agregarLinea(prod,cant);
        return verCesta();
    }
    
    @Override
    public List actualizarProducto(Producto prod, int cant, int indice) {
        ped.actualizarLinea(prod, cant, indice);
        return verCesta();
    }

    @Override
    public List quitarProducto(int IdProducto) {
        ped.quitarLinea(IdProducto);
        return verCesta();
    }

    private List verCesta() {
        List list = new ArrayList();
        for(int i=0; i<ped.getCes().size();i++){
            LineaBoletaVenta lin = (LineaBoletaVenta) ped.getCes().get(i);
            Object[]fil = new Object[7];
            fil[0] = lin.getProd().getIdProducto();
            fil[1] = lin.getProd().getNombre();
            fil[2] = lin.getProd().getPrecioUnitario();
            fil[3] = lin.getProd().getCantidad();
            fil[4] = lin.getCant();
            fil[5] = lin.getImp();
            fil[6] = ped.getTot();
            list.add(fil);
        }
        return list;
    }

    @Override
    public List vaciarCesta() {
        ped.vaciarCesta();
        return verCesta();
    }
    
}
