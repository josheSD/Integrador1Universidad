/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.List;
import negocio.ProductoBoletaVenta;

/**
 *
 * @author Lance
 */
public interface ProductoBoletaVentaServicio {
    public String grabar(ProductoBoletaVenta prodBoleVent);
    public String eliminar(int idBoletaVenta);
    public List buscar(int idBoletaVenta);
}
