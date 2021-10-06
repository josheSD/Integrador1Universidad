/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.Usuario;

/**
 *
 * @author Lance
 */
public class UsuarioDaoImp implements UsuarioDao {

    @Override
    public String grabar(Usuario usu) {
        String sql = "INSERT INTO usuario(Usuario,Contrasenia,IdTipoUsuario) VALUES('"+ usu.getUsuario()+"','"+usu.getContrasenia()+"',"+usu.getIdTipoUsuario()+")";
        return Operacion.ejecutar(sql);
    }

    @Override
    public Object[] iniciarSesion(String usu, String pass) {
        String sql = "SELECT U.*, TU.Nombre AS 'TipoUsuario' FROM Usuario AS U INNER JOIN TipoUsuario AS TU ON U.IdTipoUsuario = TU.IdTipoUsuario WHERE usuario='"+usu+"' AND contrasenia='"+pass+"'";
        return Operacion.buscar(sql);
    }

    @Override
    public List menu(int idTipoUsuario) {
        String sql = "SELECT M.* FROM TipoUsuario as TS INNER JOIN TipoUsuarioMenu as TSM ON TS.IdTipoUsuario = TSM.IdTipoUsuario INNER JOIN Menu as M ON M.IdMenu = TSM.IdMenu WHERE TS.IdTipoUsuario ="+idTipoUsuario+"";
        return Operacion.listar(sql);
    }
    
}
