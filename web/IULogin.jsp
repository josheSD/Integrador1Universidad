
<%@page import="vista.UsuarioPresentador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login | Sistema de Boleta de Venta Electrónica - Tick</title>
        <style>@import"./assets/css/styles.css";</style>
        <style>@import"./assets/css/components/login.css";</style>
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
        
                                
        <main class="l-auth">
            

            <section class="l-auth__hero">

                <article class="l-auth__hero-top"></article>
                <article class="l-auth__hero-top-left"> <img src="./assets/img/tick.png"> </article>
                <article class="l-auth__hero-bottom"></article>

            </section>

            <section class="l-auth__content">

                <article>

                    <aside>
                        <p class="title">Bienvenido a tu nuevo</p>
                        <p class="subtitle">Sistema <span>Tick</span></p>
                        <img src="./assets/img/login/laptop-erp.png" alt="laptop">
                    </aside>

                </article>

            </section>

            <section class="l-auth__login">

                <!-- START LOGIN -->
                
                <section class="l-login-hero">
                    <img src="./assets/img/tick.png" alt="logo"> 
                </section>

                <main class="l-login">

                    <section class="l-login__title">

                        <h1>Iniciar sesión </h1>

                    </section>

                    <section class="l-login__content">

                        <form method="post" action="UsuarioControl">

                            <div class="container">
                                <div class="row">
                                    <div class="col-12 px-0">
                                        <div class="form-group">
                                            <label class="formGroupExampleInput" for="user">Usuario</label>
                                            <input id="user" name="usu" type="text" class="form-control">
                                        </div>
                                    </div>
                                    <div class="col-12 px-0">
                                        <div class="form-group">
                                            <label class="formGroupExampleInput" for="password">Contraseña</label>
                                            <input id="password" name="pas" type="password" class="form-control">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <input class="btn btn-primary" type="submit"  name="acc" value="Iniciar Sesion" /> 
                                
                            <div class="mt-2 d-flex flex-column">
                                <input class="btn btn-light" type="submit"  name="acc" value="Registrate" /> 
                            </div>
                            

                        </form>
                        
                        
                        
                    </section>

                </main>
                <!-- END LOGIN -->

            </section>

        </main>
        
    </body>
</html>
