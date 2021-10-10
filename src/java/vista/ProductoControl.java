/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Producto;
import servicio.BoletaVentaServicio;
import servicio.BoletaVentaServicioImp;
import servicio.ProductoServicio;
import servicio.ProductoServicioImp;

/**
 *
 * @author Lance
 */
@WebServlet(name = "ProductoControl", urlPatterns = {"/ProductoControl"})
public class ProductoControl extends HttpServlet {
    
    private ProductoServicio prodSer;
    private ProductoPresentador prodPre;
    
    public ProductoControl(){
        this.prodSer = new ProductoServicioImp();
        this.prodPre = new ProductoPresentador();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acc = request.getParameter("acc");
        
        String idProducto = request.getParameter("idProducto");
        
        if(acc.equals("Lista")){
            this.lista(request,response);
        }
        
        if(acc.equals("AgregarProducto")){
            this.agregarProducto(request,response);
        }
        
        if(acc.equals("GrabarProducto")){
            
            if(idProducto.equals("")){
                this.grabarProducto(request,response);
            }else{
                this.actualizarProducto(request,response);
            }
            
        }
        
        if(acc.equals("ModificaProducto")){
            this.modificarProducto(request,response);
        }
        
        if(acc.equals("EliminarProducto")){
            this.eliminarProducto(request,response);
        }
        
        
    }
    
    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        prodPre.setMsg("");
        prodPre.setListaProducto(prodSer.lista());
        request.getSession().setAttribute("prodPre", prodPre);
        response.sendRedirect("IUProducto.jsp");
        
    }
    
    private void agregarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        prodPre.setTipoAccion("Crear");
        
        Object[] prodObject = {"","","",""};
        prodPre.setProducto(prodObject);
        
        request.getSession().setAttribute("prodPre", prodPre);
        response.sendRedirect("IUProductoNuevo.jsp");
        
    }
    
    private void grabarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String producto = request.getParameter("producto");
        Double precioUnitario = Double.parseDouble(request.getParameter("precioUnitario"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        
        Producto prod = new Producto(producto,precioUnitario,stock);
        prodPre.setMsg(prodSer.grabar(prod));
        
        Object[] prodObject = {"","","",""};
        prodPre.setProducto(prodObject);
        
        prodPre.setListaProducto(prodSer.lista());
        request.getSession().setAttribute("prodPre", prodPre);
        response.sendRedirect("IUProducto.jsp");
        
    }
    
    private void modificarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String IdProducto     = request.getParameter("IdProducto");
        String Nombre         = request.getParameter("Nombre");
        String PrecioUnitario = request.getParameter("PrecioUnitario");
        String Cantidad       = request.getParameter("Cantidad");
        
        Object[] prod = {"","","",""};
                 prod[0] = IdProducto;
                 prod[1] = Nombre;
                 prod[2] = PrecioUnitario;
                 prod[3] = Cantidad;
                 
        prodPre.setProducto(prod);
        prodPre.setTipoAccion("Actualizar");
        
        request.getSession().setAttribute("prodPre", prodPre);
        response.sendRedirect("IUProductoNuevo.jsp");
        
    }
    
    private void actualizarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        String producto = request.getParameter("producto");
        Double precioUnitario = Double.parseDouble(request.getParameter("precioUnitario"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        
        Producto prod = new Producto(producto,precioUnitario,stock);
        prodPre.setMsg(prodSer.actualizar(prod, idProducto));
        
        Object[] prodObject = {"","","",""};
        prodPre.setProducto(prodObject);
        
        prodPre.setListaProducto(prodSer.lista());
        request.getSession().setAttribute("prodPre", prodPre);
        response.sendRedirect("IUProducto.jsp");
        
    }
    
    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int IdProducto = Integer.parseInt(request.getParameter("IdProducto"));
        
        prodPre.setMsg(prodSer.eliminar(IdProducto));
        
        Object[] prodObject = {"","","",""};
        prodPre.setProducto(prodObject);
        
        prodPre.setListaProducto(prodSer.lista());
        request.getSession().setAttribute("prodPre", prodPre);
        response.sendRedirect("IUProducto.jsp");
        
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
