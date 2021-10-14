/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.BoletaVenta;
import negocio.Producto;
import negocio.ProductoBoletaVenta;
import servicio.BoletaVentaServicio;
import servicio.BoletaVentaServicioImp;
import servicio.PedidoServicio;
import servicio.PedidoServicioImp;
import servicio.ProductoBoletaVentaServicio;
import servicio.ProductoBoletaVentaServicioImp;
import servicio.ProductoServicio;
import servicio.ProductoServicioImp;

/**
 *
 * @author Lance
 */
@WebServlet(name = "BoletaVentaControl", urlPatterns = {"/BoletaVentaControl"})
public class BoletaVentaControl extends HttpServlet {

    private BoletaVentaPresentador boleVentPre;
    private BoletaVentaServicio boleVentSer;
    
    private ProductoServicio prodSer;
    private ProductoPresentador prodPre;
    
    private PedidoServicio pediSer;
    private PedidoPresentador pediPre;
    
    private ProductoBoletaVentaServicio prodBoleVentSer;
    
    public BoletaVentaControl(){
        this.boleVentSer = new BoletaVentaServicioImp();
        this.boleVentPre = new BoletaVentaPresentador();
        this.prodSer = new ProductoServicioImp();
        this.prodPre = new ProductoPresentador();
        this.pediSer = new PedidoServicioImp();
        this.pediPre = new PedidoPresentador();
        this.prodBoleVentSer = new ProductoBoletaVentaServicioImp();  // ME QUEDE AUI IMPLEMENTAR GRABAR PRODUCTOBOLETAVENTA
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acc = request.getParameter("acc");
        String IdBoletaVenta = request.getParameter("idBoletaVenta");
        
        // BOLETA DE VENTA
        if(acc.equals("Lista")){
            this.lista(request,response);
        }
        
        if(acc.equals("AgregarBoletaVenta")){
            this.agregarBoletaVenta(request,response);
        }
        
        if(acc.equals("ModificaBoletaVenta")){
            this.modificaBoletaVenta(request,response);
        }
        
        // CRUD 
        
        if(acc.equals("VerBoletaVenta")){
            this.verBoletaVenta(request,response);
        }
        
        if(acc.equals("GrabarBoletaVenta")){
            if(IdBoletaVenta == null || IdBoletaVenta.isEmpty()){
                this.grabarBoletaVenta(request, response);
            }else{
                this.actualizarBoletaVenta(request, response);
            }
        }
        
        if(acc.equals("EliminarBoletaVenta")){
            this.eliminarBoletaVenta(request,response);
        }
        
        if(acc.equals("AprobarBoletaVenta")){
            this.aprobarBoletaVenta(request,response);
        }
        
        // PRODUCTO TABLE
        if(acc.equals("AgregarProducto")){
            this.agregarProducto(request, response); 
        }
        
        if(acc.equals("ActualizarProducto")){
            this.actualizarProducto(request, response);
        }
        
        if(acc.equals("EliminarProducto")){
            this.eliminarProducto(request, response);
        }
        
        if(acc.equals("ModificarProducto")){
            this.modificarProducto(request, response);
        }
        
        
    }
    
    // ##############################################
    // ############   BOLETA DE VENTA   #############
    // ##############################################
    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int IdTipoUsuario = Integer.parseInt(request.getParameter("IdTipoUsuario"));
        boleVentPre.setMsg("");
        Object[] productoPedido = {"","","","","","","",""};
        pediPre.setProductoPedido(productoPedido);
            
        boleVentPre.setListaBoletaVenta(boleVentSer.lista(IdTipoUsuario));
        request.getSession().setAttribute("boleVentPre", boleVentPre);
        response.sendRedirect("IUBoletaDeVenta.jsp");
        
    }
    
    private void agregarBoletaVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            Object[] boletaVenta = {"","","","","","","",""};
            boleVentPre.setBoletaVenta(boletaVenta);

            boleVentPre.setMsg("");
            boleVentPre.setTipoAccion("Crear");
            prodPre.setListaProducto(prodSer.lista());        
            pediPre.setListaPedido(pediSer.vaciarCesta());

            request.getSession().setAttribute("prodPre", prodPre);
            request.getSession().setAttribute("boleVentPre", boleVentPre);
            request.getSession().setAttribute("pediPre", pediPre);
            response.sendRedirect("IUBoletaDeVentaNuevo.jsp");
        }catch(Exception ex){
            System.out.println(ex);
        }
        
    }
    
    private void modificaBoletaVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            
            // Tabla información
            String IdBoletaVenta = request.getParameter("IdBoletaVenta");
            String Senior = request.getParameter("Senior");
            String DocumentoIdentidad = request.getParameter("DocumentoIdentidad");
            String Direccion = request.getParameter("Direccion");
            String FechaEmision = request.getParameter("FechaEmision");
            String Estado = request.getParameter("Estado");
            String Total = request.getParameter("Total");
            String IdUsuario = request.getParameter("IdUsuario");
            
            Object[] boletaVentaActualizar = {"","","","","","","",""};
                     boletaVentaActualizar[0] = IdBoletaVenta;
                     boletaVentaActualizar[1] = Senior;
                     boletaVentaActualizar[2] = DocumentoIdentidad;
                     boletaVentaActualizar[3] = Direccion;
                     boletaVentaActualizar[4] = FechaEmision;
                     boletaVentaActualizar[5] = Estado;
                     boletaVentaActualizar[6] = Total;
                     boletaVentaActualizar[7] = IdUsuario;
            boleVentPre.setMsg("");
            boleVentPre.setTipoAccion("Actualizar");
            boleVentPre.setBoletaVenta(boletaVentaActualizar);
            
            prodPre.setListaProducto(prodSer.lista());        
            pediPre.setListaPedido(pediSer.vaciarCesta());

            List boletaVentaDB = prodBoleVentSer.buscar(Integer.parseInt(IdBoletaVenta));

            for(int i=1;i<boletaVentaDB.size();i++){
                Object[] boleVent = (Object[])boletaVentaDB.get(i);
                int CantidadForm = Integer.parseInt(boleVent[4].toString());
                Producto productoDB = new Producto();
                         productoDB.setIdProducto(Integer.parseInt(boleVent[0].toString()));
                         productoDB.setNombre(boleVent[1].toString());
                         productoDB.setPrecioUnitario(Double.parseDouble(boleVent[2].toString()));
                         productoDB.setCantidad(Integer.parseInt(boleVent[3].toString()));
                pediPre.setListaPedido(pediSer.agregarProducto(productoDB,CantidadForm));
            }

            request.getSession().setAttribute("prodPre", prodPre);
            request.getSession().setAttribute("boleVentPre", boleVentPre);
            request.getSession().setAttribute("pediPre", pediPre);
            response.sendRedirect("IUBoletaDeVentaNuevo.jsp");
            
        }catch(Exception err){
            System.out.println(err);
        }
        
    }
    
    
    private void actualizarBoletaVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            
            int IdBoletaVenta = Integer.parseInt(request.getParameter("idBoletaVenta"));
            prodBoleVentSer.eliminar(IdBoletaVenta);
            
            // Boleta de Venta
            String seniorForm = request.getParameter("seniorForm");
            int documentoIdentidadForm = Integer.parseInt(request.getParameter("documentoIdentidadForm"));
            String direccionForm = request.getParameter("direccionForm");
            String fechaEmisionForm = request.getParameter("fechaEmisionForm");
            
            // Usuario
            int idUsuarioForm = Integer.parseInt(request.getParameter("idUsuarioForm"));
            int idTipoUsuarioForm = Integer.parseInt(request.getParameter("idTipoUsuarioForm"));
            
            Double boletaVentaTotal = 0.0;
            for(int i=0;i<pediPre.getListaPedido().size();i++){
                Object[] productoPedido = (Object[])pediPre.getListaPedido().get(i);
                boletaVentaTotal += Double.parseDouble(productoPedido[5].toString());
            }
            
            BoletaVenta boleVent = new BoletaVenta();
                        boleVent.setSenior(seniorForm);
                        boleVent.setDocumentoIdentidad(documentoIdentidadForm);
                        boleVent.setDireccion(direccionForm);
                        boleVent.setFechaEmision(fechaEmisionForm);
                        boleVent.setTotal(boletaVentaTotal);
                        boleVent.setIdUsuario(idUsuarioForm);
                               
            String mensajeRespuesta = boleVentSer.actualizar(boleVent, IdBoletaVenta);
            boleVentPre.setMsg(mensajeRespuesta);
            boleVentPre.setListaBoletaVenta(boleVentSer.lista(idTipoUsuarioForm));
            
            for(int i=0;i<pediPre.getListaPedido().size();i++){
                Object[] productoPedido = (Object[])pediPre.getListaPedido().get(i);
                ProductoBoletaVenta productoBoletaVenta = new ProductoBoletaVenta();
                                    productoBoletaVenta.setImporte(Double.parseDouble(productoPedido[5].toString()));
                                    productoBoletaVenta.setCantidad(Integer.parseInt(productoPedido[4].toString()));
                                    productoBoletaVenta.setIdBoletaVenta(IdBoletaVenta);
                                    productoBoletaVenta.setIdProducto(Integer.parseInt(productoPedido[0].toString()));
                prodBoleVentSer.grabar(productoBoletaVenta);
            }
        
            boleVentPre.setListaBoletaVenta(boleVentSer.lista(idTipoUsuarioForm));
            
            request.getSession().setAttribute("boleVentPre", boleVentPre);
            response.sendRedirect("IUBoletaDeVenta.jsp");
            
        }catch(Exception err){
            System.out.println(err);
        }
        
    }
    
    private void verBoletaVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            
            // Tabla información
            String IdBoletaVenta = request.getParameter("IdBoletaVenta");
            String Senior = request.getParameter("Senior");
            String DocumentoIdentidad = request.getParameter("DocumentoIdentidad");
            String Direccion = request.getParameter("Direccion");
            String FechaEmision = request.getParameter("FechaEmision");
            String Estado = request.getParameter("Estado");
            String Total = request.getParameter("Total");
            String IdUsuario = request.getParameter("IdUsuario");
            
            Object[] boletaVentaActualizar = {"","","","","","","",""};
                     boletaVentaActualizar[0] = IdBoletaVenta;
                     boletaVentaActualizar[1] = Senior;
                     boletaVentaActualizar[2] = DocumentoIdentidad;
                     boletaVentaActualizar[3] = Direccion;
                     boletaVentaActualizar[4] = FechaEmision;
                     boletaVentaActualizar[5] = Estado;
                     boletaVentaActualizar[6] = Total;
                     boletaVentaActualizar[7] = IdUsuario;
                     
            boleVentPre.setMsg("");
            boleVentPre.setTipoAccion("Ver");
            boleVentPre.setBoletaVenta(boletaVentaActualizar);
            
            prodPre.setListaProducto(prodSer.lista());        
            pediPre.setListaPedido(pediSer.vaciarCesta());

            List boletaVentaDB = prodBoleVentSer.buscar(Integer.parseInt(IdBoletaVenta));

            for(int i=1;i<boletaVentaDB.size();i++){
                Object[] boleVent = (Object[])boletaVentaDB.get(i);
                int CantidadForm = Integer.parseInt(boleVent[4].toString());
                Producto productoDB = new Producto();
                         productoDB.setIdProducto(Integer.parseInt(boleVent[0].toString()));
                         productoDB.setNombre(boleVent[1].toString());
                         productoDB.setPrecioUnitario(Double.parseDouble(boleVent[2].toString()));
                         productoDB.setCantidad(Integer.parseInt(boleVent[3].toString()));
                pediPre.setListaPedido(pediSer.agregarProducto(productoDB,CantidadForm));
            }

            request.getSession().setAttribute("prodPre", prodPre);
            request.getSession().setAttribute("boleVentPre", boleVentPre);
            request.getSession().setAttribute("pediPre", pediPre);
            
            response.sendRedirect("IUBoletaDeVentaNuevo.jsp");
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        
    }
        
    private void grabarBoletaVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            // Boleta de Venta
            String seniorForm = request.getParameter("seniorForm");
            int documentoIdentidadForm = Integer.parseInt(request.getParameter("documentoIdentidadForm"));
            String direccionForm = request.getParameter("direccionForm");
            String fechaEmisionForm = request.getParameter("fechaEmisionForm");
            
            // Usuario
            int idUsuarioForm = Integer.parseInt(request.getParameter("idUsuarioForm"));
            int idTipoUsuarioForm = Integer.parseInt(request.getParameter("idTipoUsuarioForm"));
            
            Double boletaVentaTotal = 0.0;
            for(int i=0;i<pediPre.getListaPedido().size();i++){
                Object[] productoPedido = (Object[])pediPre.getListaPedido().get(i);
                boletaVentaTotal += Double.parseDouble(productoPedido[5].toString());
            }
            
            BoletaVenta boletaVentaForm = new BoletaVenta();
                        boletaVentaForm.setSenior(seniorForm);
                        boletaVentaForm.setDocumentoIdentidad(documentoIdentidadForm);
                        boletaVentaForm.setDireccion(direccionForm);
                        boletaVentaForm.setFechaEmision(fechaEmisionForm);
                        
                        boletaVentaForm.setEstado(1);
                        boletaVentaForm.setTotal(boletaVentaTotal);
                        boletaVentaForm.setIdUsuario(idUsuarioForm);
            
            Object[] boletaVentaDB = boleVentSer.grabar(boletaVentaForm);
            BoletaVenta boleVent = new BoletaVenta();
                        boleVent.setSenior(boletaVentaDB[1].toString());
                        boleVent.setDocumentoIdentidad(Integer.parseInt(boletaVentaDB[2].toString()));
                        boleVent.setDireccion(boletaVentaDB[3].toString());
                        boleVent.setFechaEmision(boletaVentaDB[4].toString());
                        boleVent.setEstado(Integer.parseInt(boletaVentaDB[5].toString()));
                        boleVent.setIdUsuario(Integer.parseInt(boletaVentaDB[7].toString()));
                        
            boleVentPre.setListaBoletaVenta(boleVentSer.lista(idTipoUsuarioForm));
            
            for(int i=0;i<pediPre.getListaPedido().size();i++){
                Object[] productoPedido = (Object[])pediPre.getListaPedido().get(i);
                ProductoBoletaVenta productoBoletaVenta = new ProductoBoletaVenta();
                                    productoBoletaVenta.setImporte(Double.parseDouble(productoPedido[5].toString()));
                                    productoBoletaVenta.setCantidad(Integer.parseInt(productoPedido[4].toString()));
                                    productoBoletaVenta.setIdBoletaVenta(Integer.parseInt(boletaVentaDB[0].toString()));
                                    productoBoletaVenta.setIdProducto(Integer.parseInt(productoPedido[0].toString()));
                prodBoleVentSer.grabar(productoBoletaVenta);
            }
            
            boleVentPre.setMsg("Boleta de Venta grabado con éxito");
            
            request.getSession().setAttribute("boleVentPre", boleVentPre);
            response.sendRedirect("IUBoletaDeVenta.jsp");
        }catch(Exception err){
            System.out.println(err);
        }
        
    }
    
    
    private void eliminarBoletaVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            
            int IdBoletaVenta = Integer.parseInt(request.getParameter("IdBoletaVenta"));
            int IdTipoUsuarioTable = Integer.parseInt(request.getParameter("IdTipoUsuarioTable"));
            
            String respuestaBoletaVenta = prodBoleVentSer.eliminar(IdBoletaVenta);
            boleVentSer.eliminar(IdBoletaVenta);
            boleVentPre.setMsg(respuestaBoletaVenta);
            boleVentPre.setListaBoletaVenta(boleVentSer.lista(IdTipoUsuarioTable));
            
            request.getSession().setAttribute("boleVentPre", boleVentPre);
            response.sendRedirect("IUBoletaDeVenta.jsp");
        }catch(Exception err){
            System.out.println(err);
        }
        
    }
    
    private void aprobarBoletaVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            
            int IdBoletaVenta = Integer.parseInt(request.getParameter("IdBoletaVenta"));
            int IdTipoUsuarioTable = Integer.parseInt(request.getParameter("IdTipoUsuarioTable"));
            
            boleVentPre.setMsg(boleVentSer.aprobar(IdBoletaVenta));
            boleVentPre.setListaBoletaVenta(boleVentSer.lista(IdTipoUsuarioTable));
            
            // RESETEAR FORMULARIO
            Object[] boletaVenta = {"","","","","","","",""};
            boleVentPre.setBoletaVenta(boletaVenta);
            
            request.getSession().setAttribute("boleVentPre", boleVentPre);
            response.sendRedirect("IUBoletaDeVenta.jsp");
        }catch(Exception err){
            System.out.println(err);
        }
        
    }
    
    // #####################################
    // ##########   PRODUCTO   #############
    // #####################################
    
    private void agregarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            int IdProductoForm = Integer.parseInt(request.getParameter("IdProductoForm"));
            int CantidadForm = Integer.parseInt(request.getParameter("CantidadForm"));
            Producto productoDB = prodSer.buscar(IdProductoForm);
            pediPre.setListaPedido(pediSer.agregarProducto(productoDB, CantidadForm));
            
            // Boleta de Venta
            String idBoletaVenta = request.getParameter("idBoletaVenta");
            String seniorForm = request.getParameter("seniorForm");
            int documentoIdentidadForm = Integer.parseInt(request.getParameter("documentoIdentidadForm"));
            String direccionForm = request.getParameter("direccionForm");
            String fechaEmisionForm = request.getParameter("fechaEmisionForm");
            
            // Usuario
            int idUsuarioForm = Integer.parseInt(request.getParameter("idUsuarioForm"));
            int idTipoUsuarioForm = Integer.parseInt(request.getParameter("idTipoUsuarioForm"));
            
            Object[] boletaVentaForm =  {"","","","","","","",""};
                     boletaVentaForm[0] = idBoletaVenta;
                     boletaVentaForm[1] = seniorForm;
                     boletaVentaForm[2] = documentoIdentidadForm;
                     boletaVentaForm[3] = direccionForm;
                     boletaVentaForm[4] = fechaEmisionForm;

                     boletaVentaForm[5] = 1;
                     boletaVentaForm[6] = 0.00;
                     boletaVentaForm[7] = idUsuarioForm;
                        
            boleVentPre.setBoletaVenta(boletaVentaForm);
                    
            request.getSession().setAttribute("pediPre", pediPre);
            response.sendRedirect("IUBoletaDeVentaNuevo.jsp");
        }catch(Exception err){
            System.out.println(err);
        }
        
    }
    
    private void actualizarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            Object[] productoPedidoSelected = pediPre.getProductoPedido();
            // Producto
            int IdProducto = Integer.parseInt(productoPedidoSelected[0].toString());
            String Nombre = productoPedidoSelected[1].toString();
            double PrecioUnitario = Double.parseDouble(productoPedidoSelected[2].toString());
            int Cantidad = Integer.parseInt(productoPedidoSelected[3].toString());
            
            // Informacion adicional
            int Cant = Integer.parseInt(productoPedidoSelected[4].toString());
            double Importe = Double.parseDouble(productoPedidoSelected[5].toString());
            double Total = Double.parseDouble(productoPedidoSelected[6].toString());
            int Indice = Integer.parseInt(productoPedidoSelected[7].toString());
            
            // Formulario
            int CantidadForm = Integer.parseInt(request.getParameter("CantidadForm"));
            int IdProductoForm = Integer.parseInt(request.getParameter("IdProductoForm"));
            Producto productoDB = prodSer.buscar(IdProductoForm);
            
                     
            pediPre.setListaPedido(pediSer.actualizarProducto(productoDB, CantidadForm, Indice));
            
            
            Object[] productoPed = {"","","","","","","",""};
            pediPre.setProductoPedido(productoPed);
            
            request.getSession().setAttribute("pediPre", pediPre);
            response.sendRedirect("IUBoletaDeVentaNuevo.jsp");
        }catch(Exception err){
            System.out.println(err);
        }
        
    }
    
    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            int IdProducto = Integer.parseInt(request.getParameter("IdProducto"));
            pediPre.setListaPedido(pediSer.quitarProducto(IdProducto));
            
            request.getSession().setAttribute("pediPre", pediPre);
            response.sendRedirect("IUBoletaDeVentaNuevo.jsp");
        }catch(Exception err){
            System.out.println(err);
        }
        
    }
    
    
    private void modificarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            // Producto
            int IdProducto = Integer.parseInt(request.getParameter("IdProducto"));
            String Nombre = request.getParameter("Nombre");
            double PrecioUnitario = Double.parseDouble(request.getParameter("PrecioUnitario"));
            int Cantidad = Integer.parseInt(request.getParameter("Cantidad"));
            // Informacion adicional
            int Cant = Integer.parseInt(request.getParameter("Cant"));
            double Importe = Double.parseDouble(request.getParameter("Importe"));
            double Total = Double.parseDouble(request.getParameter("Total"));
            int Indice = Integer.parseInt(request.getParameter("Indice"));
            
            Object[] productoPedido = {"","","","","","","",""};
                     productoPedido[0] = IdProducto;
                     productoPedido[1] = Nombre;
                     productoPedido[2] = PrecioUnitario;
                     productoPedido[3] = Cantidad;
                     productoPedido[4] = Cant;
                     productoPedido[5] = Importe;
                     productoPedido[6] = Total;
                     productoPedido[7] = Indice;
                     
            pediPre.setProductoPedido(productoPedido);
            
            request.getSession().setAttribute("pediPre", pediPre);
            response.sendRedirect("IUBoletaDeVentaNuevo.jsp");
        }catch(Exception err){
            System.out.println(err);
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
