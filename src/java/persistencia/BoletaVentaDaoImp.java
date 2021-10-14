/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.BoletaVenta;

/**
 *
 * @author Lance
 */
public class BoletaVentaDaoImp implements BoletaVentaDao{

    @Override
    public Object[] grabar(BoletaVenta boleVent) {
        String sql = "INSERT INTO boletaventa(Senior,DocumentoIdentidad,Direccion,FechaEmision,Estado,Total,IdUsuario) VALUES('"+ boleVent.getSenior()+"',"+boleVent.getDocumentoIdentidad()+",'"+boleVent.getDireccion()+"','"+boleVent.getFechaEmision()+"',"+boleVent.getEstado()+","+boleVent.getTotal()+","+boleVent.getIdUsuario()+")";
        Operacion.ejecutar(sql);
        String sqlId = "SELECT * FROM boletaventa ORDER BY IdBoletaVenta DESC LIMIT 0,1;";
        return Operacion.buscar(sqlId);
    }

    @Override
    public String actualizar(BoletaVenta boleVent, int idBoletaVenta) {
        String sql = "UPDATE boletaventa SET Senior ='"+ boleVent.getSenior()+"', DocumentoIdentidad = "+boleVent.getDocumentoIdentidad()+", Direccion = '"+boleVent.getDireccion()+"', FechaEmision = '"+boleVent.getFechaEmision()+"', Total = "+boleVent.getTotal()+", IdUsuario = "+boleVent.getIdUsuario()+" WHERE IdBoletaVenta = "+ idBoletaVenta +"";
        return Operacion.ejecutar(sql);
    }

    @Override
    public String eliminar(int idBoletaVenta) {
        String sql = "DELETE FROM boletaventa WHERE IdBoletaVenta = "+idBoletaVenta+"";
        return Operacion.ejecutar(sql);
    }

    @Override
    public List lista(int idTipoUsuario) {
        // 1 VENDEDOR      2 CAJERO 
        String sql = "SELECT * FROM boletaventa WHERE Estado = 1 OR Estado = 2 ORDER BY IdBoletaVenta DESC";
        return Operacion.listar(sql);
    }

    @Override
    public String aprobar(int idBoletaVenta) {
        String sql = "UPDATE boletaventa SET Estado = 2 WHERE IdBoletaVenta = "+idBoletaVenta+"";
        return Operacion.ejecutar(sql);
    }
    
}
