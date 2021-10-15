

<%@page import="vista.BoletaVentaPresentador"%>
<%@page import="vista.UsuarioPresentador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Boleta de Venta | Sistema de Boleta de Venta Electrónica - Tick</title>
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
                <main class="l-dashboard">

                    <div class="container-fluid">
                        <div class="row mx-1">
                            <div class="col-12 mt-3">
                                <h4>
                                   Lista de Boleta de Venta 
                                </h4>
                                <form method="post" action="BoletaVentaControl">
                                    <% if(usuario[3].toString().equals("1")){ %>
                                        <button class="btn btn-primary my-3" type="submit" name="acc" value="AgregarBoletaVenta">
                                            Agregar
                                        </button>
                                    <% } %>
                                </form>
                            </div>
                            <div class="col-12 mt-3">
                                <div class="table-responsive">
                                    <table class="table table-bordered bg-white">
                                        <thead>
                                          <tr>
                                            <th scope="col">Acciones</th>
                                            <th scope="col">Señor(a)</th>
                                            <th scope="col">Documento de Identidad</th>
                                            <th scope="col">Fecha</th>
                                            <th scope="col">Total</th>
                                          </tr>
                                        </thead>
                                        <tbody>
                                            
                                            <% for(int i=1;i<boleVentPre.getListaBoletaVenta().size();i++){ %>
                                            <% Object[] boletaVenta = (Object[])boleVentPre.getListaBoletaVenta().get(i); %>
                                                <tr>
                                                  <td>
                                                      <form method="post" action="BoletaVentaControl">
                                                        <input type="hidden" name="IdBoletaVenta" value="<%= boletaVenta[0] %>" />
                                                        <input type="hidden" name="Senior" value="<%= boletaVenta[1] %>" />
                                                        <input type="hidden" name="DocumentoIdentidad" value="<%= boletaVenta[2] %>" />
                                                        <input type="hidden" name="Direccion" value="<%= boletaVenta[3] %>" />
                                                        <input type="hidden" name="FechaEmision" value="<%= boletaVenta[4] %>" />
                                                        <input type="hidden" name="Estado" value="<%= boletaVenta[5] %>" />
                                                        <input type="hidden" name="Total" value="<%= boletaVenta[6] %>" />
                                                        <input type="hidden" name="IdUsuario" value="<%= boletaVenta[7] %>" />
                                                        
                                                        <input type="hidden" name="IdTipoUsuarioTable" value="<%= usuario[3] %>">
                                                        
                                                        <!-- MODIFICAR Y ELIMINAR BOLETA DE VENTA PARA USUARIO VENDEDOR -->
                                                        <% if(usuario[3].toString().equals("1") && boletaVenta[5].toString().equals("1")){ %>
                                                            <button class="btn btn-success" type="submit" name="acc" value="ModificaBoletaVenta" data-toggle="tooltip" title="Actualizar Boleta de Venta">
                                                                <i class="fas fa-pencil-alt fa-xs"></i>
                                                            </button>
                                                            <button class="btn btn-danger" type="submit" name="acc" value="EliminarBoletaVenta" data-toggle="tooltip" title="Eliminar Boleta de Venta">
                                                                <i class="fas fa-trash fa-xs"></i>
                                                            </button>
                                                        <% } %>
                                                        
                                                        <!-- APROBAR BOLETA DE VENTA PARA USUARIO CAJERO -->
                                                        <% if(usuario[3].toString().equals("2") && boletaVenta[5].toString().equals("1")){ %>
                                                            <button class="btn btn-primary" type="submit" name="acc" value="AprobarBoletaVenta" data-toggle="tooltip" title="Aprobar Boleta de Venta">
                                                                <i class="fas fa-check-circle"></i>
                                                            </button>
                                                            <button class="btn btn-primary" type="submit" name="acc" value="VerBoletaVenta" data-toggle="tooltip" title="Ver Boleta de Venta">
                                                                <i class="fas fa-eye fa-xs"></i>
                                                            </button>
                                                        <% }%>
                                                        
                                                        <!-- VER BOLETA -->
                                                        <% if(boletaVenta[5].toString().equals("2")){ %>
                                                            <button class="btn btn-primary" type="submit" name="acc" value="VerBoletaVenta" data-toggle="tooltip" title="Ver Boleta de Venta">
                                                                <i class="fas fa-eye fa-xs"></i>
                                                            </button>
                                                        <% }%>
                                                      </form>
                                                  </td>
                                                  <td><%= boletaVenta[1] %></td>
                                                  <td><%= boletaVenta[2] %></td>
                                                  <td><%= boletaVenta[4] %></td>
                                                  <td class="text-right">S/. <%= boletaVenta[6] %></td>
                                                </tr>
                                            <% } %>
                                          
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>

                </main>

            </section>
            <!-- END SIDEBAR -->

        </main>
        
        
        <script type="text/javascript" src="./assets/js/admin.js">
        </script>
    </body>
</html>

