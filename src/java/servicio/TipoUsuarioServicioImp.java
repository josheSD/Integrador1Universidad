/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.List;
import persistencia.TipoUsuarioDao;
import persistencia.TipoUsuarioDaoImp;

/**
 *
 * @author Lance
 */
public class TipoUsuarioServicioImp implements TipoUsuarioServicio{
    
    private TipoUsuarioDao tipUsuDao;
    
    public TipoUsuarioServicioImp(){
        this.tipUsuDao = new TipoUsuarioDaoImp();
    }
    
    @Override
    public List lista() {
        List listaTipoUsuario = this.tipUsuDao.lista();
        return listaTipoUsuario;
    }
    
}
