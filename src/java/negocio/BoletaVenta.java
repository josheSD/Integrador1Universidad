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
public class BoletaVenta {
    public String senior;
    public int documentoIdentidad;
    public String direccion;
    public String fechaEmision;
    public int estado;
    public Double total;
    public int idUsuario;

    public BoletaVenta(){
        
    }
    
    public BoletaVenta(String senior, int documentoIdentidad, String direccion, String fechaEmision, int estado, Double total, int idUsuario) {
        this.senior = senior;
        this.documentoIdentidad = documentoIdentidad;
        this.direccion = direccion;
        this.fechaEmision = fechaEmision;
        this.estado = estado;
        this.total = total;
        this.idUsuario = idUsuario;
    }

    public String getSenior() {
        return senior;
    }

    public void setSenior(String senior) {
        this.senior = senior;
    }

    public int getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(int documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
