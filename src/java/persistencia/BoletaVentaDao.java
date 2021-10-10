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
public interface BoletaVentaDao {
    public Object[] grabar(BoletaVenta boleVent);
    public String actualizar(BoletaVenta boleVent,int idBoletaVenta);
    public String eliminar(int idBoletaVenta);
    public List lista(int idTipoUsuario);
    public String aprobar(int idBoletaVenta);
}
