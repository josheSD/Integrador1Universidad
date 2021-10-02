/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import negocio.Usuario;

/**
 *
 * @author Lance
 */
public class UsuarioDaoImp implements UsuarioDao {

    @Override
    public String grabar(Usuario usu) {
        String sql = "INSERT INTO usuario VALUES('"+ usu.getUsuario()+"','"+usu.getContrasenia()+"',"+usu.getIdTipoUsuario()+")";
        return Operacion.ejecutar(sql);
    }

    @Override
    public Object[] iniciarSesion(String usu, String pass, int idTipoUsuario) {
        String sql = "SELECT * FROM usuario WHERE usuario='"+usu+"', contrasenia='"+pass+"'";
        return Operacion.buscar(sql);
    }
    
}
