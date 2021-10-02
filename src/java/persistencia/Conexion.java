/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Lance
 */
public class Conexion {
    public Connection getConexion(){
        Connection  cn=null;
        
        try{
            Class.forName("org.apache.mysql.jdbc.ClientDriver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:1527/bdboleta","root","");
        }catch(Exception ex){
            cn=null;
        }
        
        return cn;
    }
}
