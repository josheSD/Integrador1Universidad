/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.List;
import negocio.Usuario;
import persistencia.UsuarioDao;
import persistencia.UsuarioDaoImp;

/**
 *
 * @author Lance
 */
public class UsuarioServicioImp implements UsuarioServicio{

    private UsuarioDao usuDao;
    
    public UsuarioServicioImp(){
        this.usuDao = new UsuarioDaoImp();
    }
    
    @Override
    public String grabar(Usuario usu) {
        String msg = usuDao.grabar(usu);
        if(msg == null){
            msg = "Usuario Grabado con éxito";
        }
        return msg;
    }

    @Override
    public Object[] iniciarSesion(String usu, String pass) {
        Object[] usuario = usuDao.iniciarSesion(usu, pass);
        if(usuario!=null){
            return usuario;
        }
        return null;
    }

    @Override
    public List menu(int idTipoUsuario) {
        List listaTipoUsuario = usuDao.menu(idTipoUsuario);
        return listaTipoUsuario;
    }
    
}
