

<%@page import="vista.PedidoPresentador"%>
<%@page import="vista.ProductoPresentador"%>
<%@page import="vista.BoletaVentaPresentador"%>
<%@page import="vista.UsuarioPresentador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Boleta de Venta Electrónica - Tick</title>
        <style>@import"./assets/css/styles.css";</style>
        <style>@import"./assets/css/components/admin.css"</style>
        <link rel="icon" type="image/x-icon" href="./assets/img/tick.png">
        <meta name="theme-color" content="#0078D7">
        <meta name='viewport' content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'/>
        <script src="https://kit.fontawesome.com/2fb25d77eb.js" crossorigin="anonymous"></script>
        
        
        <!-- BOOSTSTRAP -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

        
    </head>
    <body class="theme-light" id="body">
        
        <main class="l-admin" id="admin">
            <% UsuarioPresentador usuPre = (UsuarioPresentador) session.getAttribute("usuPre"); %>
            <% BoletaVentaPresentador boleVentPre = (BoletaVentaPresentador) session.getAttribute("boleVentPre"); %>
            <% ProductoPresentador prodPre = (ProductoPresentador) session.getAttribute("prodPre"); %>
            <% PedidoPresentador pediPre = (PedidoPresentador) session.getAttribute("pediPre"); %>
            <%! String totalPedido = String.valueOf(0.00); %>
                        
            <!-- START NAVBAR -->
            <section class="l-navbar" id="navbar">
                <article class="l-navbar__icon">

                    <aside class="l-hamburguer" id="l-hamburguer">
                        <div class="hamburger hamburger--slider" id="hamburger">
                            <span class="hamburger__box">
                                <span class="hamburger__inner"></span>
                            </span>
                        </div>
                    </aside>

                    <img src="./assets/img/tick.png">

                </article>
                <article class="l-navbar__main">

                    <p class="mb-0">TICK </p> <span>/</span> <p class="mb-0">Sistema de Boleta de Venta Electrónica</p>
                    

                </article>
                <article class="l-navbar__options">

                    <div class="l-toggle-theme">
                        <div>
                            <input type="checkbox" class="checkbox" id="check-theme" />
                            <label class="label" for="check-theme">
                                <i class="fas fa-moon"></i>
                                <i class="fas fa-sun"></i>
                                <div class="ball"></div>
                            </label>
                        </div>
                    </div>

                </article>
                <article class="l-navbar__hero">
                    <img src="./assets/img/admin/user.png" id="user-photo"> 
                </article>
            </section>

            <section class="l-navbar-profile" id="navbar-profile">

                <article class="l-navbar-profile__name">
                    <p class="mb-0" >Sistema Tick</p>
                </article>

                <article class="l-navbar-profile__logout">
                    <p class="mb-0" id="sign-out">
                        <a href="./IULogin.jsp">Desconectar</a>
                    </p>
                </article>

                <article class="l-navbar-profile__info">

                    <aside class="l-navbar-profile__info-hero">

                        <img src="./assets/img/admin/user.png"> 

                    </aside>

                    <aside class="l-navbar-profile__info-user">
                        <% Object[]usuario = usuPre.getUsuario(); %>
                        <h2 class="mb-0"> <%= usuario[1] %> </h2>
                        <p class="mb-0" > <%= usuario[4] %> </p>
                        <p class="mb-0" > Ver Cuenta </p>
                    </aside>

                </article>

            </section>
            <!-- END NAVBAR -->

            <section class="l-portal" id="portal">

            </section>
            
            <!-- START SIDEBAR -->
            <section class="l-sidebar" id="sidebar">
                <main class="w-sidebar">

                    <article class="w-sidebar__title">
                        <a href="javascript:void(0)">
                            <span>
                                <img src="./assets/img/admin/proyecto.png" /> 
                            </span>
                            <span class="module-parrafo">
                                TICK Sistema
                            </span>
                        </a>
                    </article>

                    <article class="w-sidebar__separator top">
                    </article>

                    <article class="w-sidebar__modules">

                            <section class="modules">

                                <div class="modules__main">
                                    <a href="IUAdmin.jsp">
                                        <span>
                                            <img src="./assets/img/sidebar/01-analysis.svg" alt="modulo">
                                        </span>
                                        <span class="module-parrafo">
                                            Dashboard
                                        </span>
                                    </a>
                                </div>

                            </section>
                        
                            <% for(int i=1;i<usuPre.getMenu().size();i++){ %>
                            <% Object[] menu = (Object[])usuPre.getMenu().get(i); %>

                                <form method="POST" action="<%= menu[2] %>">
                                    <section class="modules" >

                                        <div class="modules__main">
                                            <input type="hidden" name="IdTipoUsuario" value="<%= usuario[3] %>">

                                            <button class="modules__button" type="submit"  name="acc" value="Lista">
                                                  <span>
                                                       <img src="<%= menu[3] %>" alt="modulo">
                                                  </span>
                                                  <span class="module-parrafo">
                                                       <%= menu[1] %>
                                                  </span>
                                            </button>

                                        </div>
                                    </section>
                                </form>

                            <% } %>

                                                

                    </article>

                    <article class="w-sidebar__separator bottom">
                    </article>

                    <article class="w-sidebar__icons">

                        <i class="fa fa-cog first"></i>
                        <span>Project settings</span>
                        <i class="fas fa-angle-double-left second" id="sidebar-bottom-angle"></i>

                    </article>


                </main>
            </section>
            <!-- END SIDEBAR -->
            
            
            <!-- START MAIN -->
            <section class="l-main" id="main">
                <main class="l-dashboard boleta overflow-auto">

                    <form method="post" action="BoletaVentaControl">
                        
                        <div class="container-fluid">
                            <div class="row mx-1">
                                <div class="col-12 mt-3">
                                    <h4>
                                       <% String tipoAccion = boleVentPre.getTipoAccion(); %>
                                       <%= tipoAccion %> Boleta de Venta 
                                    </h4>
                                </div>

                                <div class="col-12 mt-3">

                                    <div class="card bg-yellow">
                                        <div class="card-body py-3">

                                            <div class="row">
                                                <div class="col-md-8 d-flex justify-content-center">
                                                    <section>
                                                        <div class="d-flex">
                                                            <h5 class="mb-0 text-center font-italic">Tienda de computo <h5><h5 class="mb-0 font-italic font-weight-bold">"TICK"</h5>
                                                        </div>
                                                        <p class="mb-0 text-center">De: Román Guzmán, Elta</p>
                                                        <p class="mb-0 text-center">Av. San Antornio 680 - Lima</p>
                                                        <p class="mb-0 text-center">Jr. Brasil 312 - Lima</p>
                                                    </section>
                                                </div>
                                                <div class="col-md-4 d-flex align-items-center justify-content-end">
                                                    <section>
                                                        <div class="card bg-white px-3 px-md-5">
                                                            <div class="card-body py-1">
                                                                <p class="mb-0 text-center">R.U.C. 100007456065</p>
                                                                <p class="mb-0 text-center"><b>BOLETA DE VENTA</b></p>
                                                                <p class="mb-0 text-center">002 - 0000504</p>
                                                            </div>
                                                        </div>
                                                    </section>
                                                </div>
                                            </div>

                                            <!-- ################     FORMULARIO BOLETA DE VENTA   ################# -->
                                            <% Object[] boleVentaForm = boleVentPre.getBoletaVenta(); %>
                                            <input type="hidden" name="idUsuarioForm" value="<%= usuario[0] %>" />
                                            <input type="hidden" name="idTipoUsuarioForm" value="<%= usuario[3] %>" />
                                            
                                            <input type="hidden" name="idBoletaVenta" value="<%= boleVentaForm[0] %>" />
                                            

                                            <div class="row mt-3">

                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label class="formGroupExampleInput">Señor(a)</label>
                                                        <input name="seniorForm" type="text" class="form-control" value="<%= boleVentaForm[1] %>">
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label class="formGroupExampleInput">Documento de identidad</label>
                                                        <input name="documentoIdentidadForm" type="text" class="form-control" value="<%= boleVentaForm[2] %>">
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label class="formGroupExampleInput">Dirección</label>
                                                        <input name="direccionForm" type="text" class="form-control" value="<%= boleVentaForm[3] %>">
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label class="formGroupExampleInput">Fecha de emisión</label>
                                                        <input name="fechaEmisionForm" type="text" class="form-control" value="<%= boleVentaForm[4] %>">
                                                    </div>
                                                </div>

                                            </div>

                                            <div class="row mt-3">

                                                <div class="col-xl-8 offset-xl-2">

                                                    <div class="card bg-blue">
                                                        <div class="card-body pb-2">
                                                            <div class="row">
                                                                <div class="col-12">
                                                                    <h5 class="mb-3">Ingresar Producto</h5>
                                                                </div>
                                                            </div>
                                                            <div class="row pl-md-4">
                                                                <% Object[] productoPed = pediPre.getProductoPedido(); %>
                                                                
                                                                <div class="col-md-3">
                                                                    <div class="form-group">
                                                                      <label for="exampleFormControlSelect1">Seleccionar Producto</label>
                                                                      <select class="form-control" id="selectProducto" name="IdProductoForm" >
                                                                        <% for(int i=1;i<prodPre.getListaProducto().size();i++){ %>
                                                                        <% Object[] producto = (Object[])prodPre.getListaProducto().get(i); %>
                                                                        <option value="<%= producto[0] %>"> <%= producto[1] %> </option>
                                                                        <% } %>
                                                                      </select>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-3">
                                                                    <div class="form-group">
                                                                        <label class="formGroupExampleInput">Precio Unitario</label>
                                                                        <input id="precio" name="precioForm" value="<%= productoPed[2] %>" type="text" disabled class="form-control">
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-3">
                                                                    <div class="form-group">
                                                                        <label class="formGroupExampleInput">Cantidad</label>
                                                                        <input id="cantidad" name="CantidadForm" value="<%= productoPed[4] %>" type="text" class="form-control">
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-2 d-flex align-items-center">
                                                                    <button class="btn btn-primary w-100 mt-3" name="acc" value="AgregarProducto">
                                                                        Insertar
                                                                    </button>
                                                                    <button class="btn btn-primary w-100 mt-3 ml-3" name="acc" value="ActualizarProducto">
                                                                        Actualizar
                                                                    </button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                </div>

                                            </div>

                                            <div class="row mt-3">
                                                <div class="col-12">

                                                    <div class="table-responsive">
                                                        <table class="table table-bordered bg-white">
                                                            <thead>
                                                              <tr>
                                                                <th scope="col">Acciones</th>
                                                                <th scope="col">Producto</th>
                                                                <th scope="col">Precio Unitario</th>
                                                                <th scope="col">Cantidad</th>
                                                                <th scope="col">Importe</th>
                                                              </tr>
                                                            </thead>
                                                            <tbody>
                                                                
                                                                <% for(int i=0;i<pediPre.getListaPedido().size();i++){ %>
                                                                <% Object[] productoPedido = (Object[])pediPre.getListaPedido().get(i); %>
                                                                <% totalPedido = productoPedido[6].toString(); %>
                                                                    <tr>
                                                                      <td>
                                                                        <form method="post" action="BoletaVentaControl">
                                                                            <input type="hidden" name="IdProducto" value="<%= productoPedido[0] %>" />
                                                                            <input type="hidden" name="Nombre" value="<%= productoPedido[1] %>" />
                                                                            <input type="hidden" name="PrecioUnitario" value="<%= productoPedido[2] %>" />
                                                                            <input type="hidden" name="Cantidad" value="<%= productoPedido[3] %>" />
                                                                            <input type="hidden" name="Cant" value="<%= productoPedido[4] %>" />
                                                                            <input type="hidden" name="Importe" value="<%= productoPedido[5] %>" />
                                                                            <input type="hidden" name="Total" value="<%= productoPedido[6] %>" />
                                                                            <input type="hidden" name="Indice" value="<%= i %>" />
                                                                            
                                                                            <button class="btn btn-success" type="submit" name="acc" value="ModificarProducto">
                                                                                <i class="fas fa-pencil-alt fa-xs"></i>
                                                                            </button>
                                                                            <button class="btn btn-danger" type="submit" name="acc" value="EliminarProducto">
                                                                                <i class="fas fa-trash fa-xs"></i>
                                                                            </button>
                                                                        </form>
                                                                      </td>
                                                                      <td><%= productoPedido[1] %></td>
                                                                      <td class="text-right">S/. <%= productoPedido[2] %></td>
                                                                      <td class="text-right"><%= productoPedido[4] %></td>
                                                                      <td class="text-right">S/. <%= productoPedido[5] %></td>
                                                                    </tr>
                                                                <% } %>
                                                                
                                                                <tr>
                                                                  <td></td>
                                                                  <td></td>
                                                                  <td></td>
                                                                  <td class="text-right">Total</td>
                                                                  <td class="text-right">
                                                                      S/. <%= totalPedido %>
                                                                  </td>
                                                                </tr>
                                                                
                                                            </tbody>
                                                        </table>
                                                    </div>

                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="col-md-3 mt-2 mb-4">
                                                    <section>
                                                        <p class="mb-0 text-center">R.U.C N 20403034591</p>
                                                        <p class="mb-0 text-center">N de autorización de impresión</p>
                                                        <p class="mb-0 text-center">1543628050</p>
                                                        <p class="mb-0 text-center">Fit. 05-1-2021</p>
                                                    </section>
                                                </div>
                                            </div>

                                        </div>
                                    </div>

                                </div>

                                <div class="col-12">  
                                    <div class="d-flex justify-content-end">
                                        <button type="submit" class="btn btn-primary mr-1 mt-4 mb-4" name="acc" value="GrabarBoletaVenta">
                                           <i class="fas fa-save d-inline-block mr-2"></i>
                                           <% String tipoAccion2 = boleVentPre.getTipoAccion(); %>
                                           <%= tipoAccion2 %> Boleta
                                        </button>   
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                    </form>

                </main>

            </section>
            <!-- END SIDEBAR -->

        </main>
        
        <script type="text/javascript">
            
            //const selectProducto = document.getElementById('selectProducto');
            //selectProducto.addEventListener('change', (event) => {
            //    console.log(event);
            //});
            
            
        </script>
                                        
        <script type="text/javascript" src="./assets/js/admin.js">
        </script>
    </body>
</html>

