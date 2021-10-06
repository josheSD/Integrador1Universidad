/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;

/**
 *
 * @author Jose
 */
public class PruebaConexionBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion con = new Conexion();
        Connection cn = con.getConexion();
        if(cn != null){
            System.out.println("Si hay conexión");
        }else{
            System.out.println("No hay conexión");
        }
    }
    
}
