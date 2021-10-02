/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;

/**
 *
 * @author Lance
 */
public class TipoUsuarioDaoImp implements TipoUsuarioDao{

    @Override
    public List lista() {
        String sql = "SELECT * FROM tipousuario";
        return Operacion.listar(sql);
    }
    
}
