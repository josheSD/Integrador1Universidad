/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Lance
 */
public class ProductoBoletaVenta {
    public Double importe;
    public int cantidad;
    public int idBoletaVenta;
    public int idProducto;

    public ProductoBoletaVenta(){}
    
    public ProductoBoletaVenta(Double importe, int cantidad, int idBoletaVenta, int idProducto) {
        this.importe = importe;
        this.cantidad = cantidad;
        this.idBoletaVenta = idBoletaVenta;
        this.idProducto = idProducto;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdBoletaVenta() {
        return idBoletaVenta;
    }

    public void setIdBoletaVenta(int idBoletaVenta) {
        this.idBoletaVenta = idBoletaVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
}
