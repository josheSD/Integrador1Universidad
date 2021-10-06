

<%@page import="vista.UsuarioPresentador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

                                <form method="POST" action="ProductoControl">
                                    <section class="modules" >

                                        <div class="modules__main">

                                            <button class="modules__button" type="submit"  name="acc" value="<%= menu[2] %>">
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

                    <div class="container-fluid">
                        <div class="row mx-1">
                            <div class="col-12 mt-3">
                                <h4>
                                   Insertar Boleta de Venta 
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
                                        
                                        <div class="row mt-3">
                                         
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label class="formGroupExampleInput" for="user">Señor(es)</label>
                                                    <input id="senior" name="senior" type="text" class="form-control">
                                                </div>
                                            </div>
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label class="formGroupExampleInput" for="password">Documento de identidad</label>
                                                    <input id="documentoIdentidad" name="documentoIdentidad" type="text" class="form-control">
                                                </div>
                                            </div>
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label class="formGroupExampleInput" for="password">Dirección</label>
                                                    <input id="direccion" name="direccion" type="text" class="form-control">
                                                </div>
                                            </div>
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label class="formGroupExampleInput" for="password">Fecha de emisión</label>
                                                    <input id="fechaEmision" name="fechaEmision" type="text" class="form-control">
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
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                  <label for="exampleFormControlSelect1">Seleccionar Producto</label>
                                                                  <select class="form-control" id="exampleFormControlSelect1">
                                                                    <option>Teclado</option>
                                                                    <option>Monitor</option>
                                                                  </select>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="formGroupExampleInput" for="password">Precio Unitario</label>
                                                                    <input id="precio" name="precio" type="text" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="formGroupExampleInput" for="password">Cantidad</label>
                                                                    <input id="cantidad" name="cantidad" type="text" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-2 d-flex align-items-center">
                                                                <button class="btn btn-primary w-100 mt-3">Insertar</button>
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
                                                            <th scope="col">Cantidad</th>
                                                            <th scope="col">Descripción</th>
                                                            <th scope="col">Importe</th>
                                                          </tr>
                                                        </thead>
                                                        <tbody>
                                                          <tr>
                                                            <td>
                                                                <button class="btn btn-success">A</button>
                                                                <button class="btn btn-danger">E</button>
                                                            </td>
                                                            <td>1</td>
                                                            <td>Libro Auditoria Tributaria</td>
                                                            <td class="text-right">250.00</td>
                                                          </tr>
                                                          <tr>
                                                            <td>
                                                                <button class="btn btn-success">A</button>
                                                                <button class="btn btn-danger">E</button>
                                                            </td>
                                                            <td>1</td>
                                                            <td>Libro Manual del Contador</td>
                                                            <td class="text-right">250.00</td>
                                                          </tr>
                                                          <tr>
                                                            <td>
                                                                <button class="btn btn-success">A</button>
                                                                <button class="btn btn-danger">E</button>
                                                            </td>
                                                            <td>1</td>
                                                            <td>Compendio Laboral 2021</td>
                                                            <td class="text-right">300.00</td>
                                                          </tr>
                                                          <tr>
                                                            <td></td>
                                                            <td></td>
                                                            <td class="text-right">Total S/.</td>
                                                            <td class="text-right">800.00</td>
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
                                    <button class="btn btn-primary my-4">Grabar Boleta</button>    
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

