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
public interface UsuarioDao {
    public String grabar(Usuario usu);
    public Object[] iniciarSesion(String usu,String pass,int idTipoUsuario);
}
