
package vista;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Usuario;
import servicio.TipoUsuarioServicio;
import servicio.TipoUsuarioServicioImp;
import servicio.UsuarioServicio;
import servicio.UsuarioServicioImp;

@WebServlet(name = "UsuarioControl", urlPatterns = {"/UsuarioControl"})
public class UsuarioControl extends HttpServlet {

    private UsuarioServicio usuSer;
    private UsuarioPresentador usuPre;
    private TipoUsuarioServicio tipUsuSer;

    public UsuarioControl(){
        this.usuSer = new UsuarioServicioImp();
        this.usuPre = new UsuarioPresentador();
        this.tipUsuSer = new TipoUsuarioServicioImp();
    }
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String acc = request.getParameter("acc");
        
        if(acc.equals("Iniciar Sesion")){
            this.iniciarSesion(request, response);
        }
        
        if(acc.equals("Registrate")){
            this.registrate(request,response);
        }
        
        if(acc.equals("Crear")){
            this.crearUsuario(request,response);
        }
        
    }
    
    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usu = request.getParameter("usu");
        String pas = request.getParameter("pas");

        Object[]usuario = usuSer.iniciarSesion(usu, pas);
        usuPre.setListaTipoUsuario(tipUsuSer.lista());

        if(usuario != null){
            usuPre.setMsg("Exito al ingresar");
            usuPre.setUsuario(usuario);
            usuPre.setMenu(usuSer.menu(Integer.parseInt(usuario[3].toString())));
            request.getSession().setAttribute("usuPre", usuPre);
            response.sendRedirect("IUAdmin.jsp");
        }else{
            usuPre.setMsg("Usuario no encontrado, por favor regístrese");
            request.getSession().setAttribute("usuPre", usuPre);
            response.sendRedirect("IURegistrar.jsp");
        }
        
    }
    
    private void registrate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        usuPre.setMsg("");
        usuPre.setListaTipoUsuario(tipUsuSer.lista());
        request.getSession().setAttribute("usuPre", usuPre);
        response.sendRedirect("IURegistrar.jsp");
            
    }
    
    private void crearUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usu         = request.getParameter("usu");
        String pas         = request.getParameter("pas");
        int idTipoUsuario = Integer.parseInt(request.getParameter("idTipoUsuario"));
        
        Usuario usuario = new Usuario(usu,pas,idTipoUsuario);
        String msgUsuario = usuSer.grabar(usuario);
        
        if(msgUsuario != null){
            Object[]usuarioDB = usuSer.iniciarSesion(usu,pas);
            usuPre.setUsuario(usuarioDB);
            usuPre.setMenu(usuSer.menu(Integer.parseInt(usuarioDB[3].toString())));
            response.sendRedirect("IUAdmin.jsp");
        }else{
            usuPre.setMsg("Error al registrar");
            response.sendRedirect("IURegistrar.jsp");
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
