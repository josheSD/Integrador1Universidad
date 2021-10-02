
document.addEventListener("DOMContentLoaded", function(event) {
    
    
    var localTheme = localStorage.getItem("theme");

    if(localTheme == 'dark'){
        body.classList.remove('theme-light');
        body.classList.add('theme-dark');
    }else{
        body.classList.remove('theme-dark');
        body.classList.add('theme-light');
    }
    
    document.getElementById('check-theme').addEventListener("click",() =>{
        
        var body = document.getElementById('body');
        var localTheme = localStorage.getItem("theme");
    
        if(localTheme == 'dark'){
            body.classList.remove('theme-dark');
            body.classList.add('theme-light');
            localStorage.setItem("theme","light");
        }else{
            body.classList.remove('theme-light');
            body.classList.add('theme-dark');
            localStorage.setItem("theme","dark");
        }
        
    });
    
    document.getElementById('user-photo').addEventListener("click",() =>{
        var navbarProfile= document.getElementById('navbar-profile');
        navbarProfile.classList.toggle('open');
    });
    
    document.getElementById('sign-out').addEventListener("click", () =>{
        window.location="http://localhost:8084/SupermercadoChutas/index.htm";
    });
    
    document.getElementById('l-hamburguer').addEventListener("click", () =>{
        
        var sidebar = document.getElementById('sidebar');
        var portal = document.getElementById('portal');
        if(sidebar.classList.contains('open')){
          sidebar.classList.remove('open');
          setTimeout(() => portal.classList.remove('open'),300);
        }else{
          sidebar.classList.add('open');
          portal.classList.add('open');
        }
        
    });
    
    document.getElementById('portal').addEventListener("click", () =>{
        var sidebar = document.getElementById('sidebar');
        var portal = document.getElementById('portal');
        if(sidebar.classList.contains('open')){
          sidebar.classList.remove('open');
          setTimeout(() => portal.classList.remove('open'),300);
        }else{
          sidebar.classList.add('open');
          portal.classList.add('open');
        } 
    });
    
    document.getElementById('sidebar-bottom-angle').addEventListener("click",() =>{
        
        var sidebar = document.getElementById('sidebar');
        var main = document.getElementById('main');
        var parrafo = document.querySelectorAll('.module-parrafo');

        var icons_span = document.querySelector('.w-sidebar__icons span');
        var icons_firs = document.querySelector('.w-sidebar__icons .first');
        var icons_second = document.querySelector('.w-sidebar__icons .second');

        sidebar.classList.toggle('expanded');
        main.classList.toggle('expanded');
        parrafo.forEach(x => x.classList.toggle('expanded'));

        icons_span.classList.toggle('expanded');
        icons_firs.classList.toggle('expanded');

        if(icons_second.classList.contains('expanded')){
          icons_second.classList.replace(icons_second.classList[1],'fa-angle-double-left');
          icons_second.classList.remove('expanded');
        }else{
          icons_second.classList.replace(icons_second.classList[1],'fa-angle-double-right');
          icons_second.classList.add('expanded');
        }
    
    });
    
    // MODULOS SIDEBAR
    document.getElementById('module-articulo').addEventListener("click",() =>{
        
        document.querySelectorAll('.modules').forEach((module) =>{
            if('module-articulo' != module.id){
                module.classList.remove('active');   
            }
        });
        
        document.getElementById('module-articulo').classList.toggle('active');
        
    });
    
    document.getElementById('module-proveedor').addEventListener("click",() =>{
        
        document.querySelectorAll('.modules').forEach((module) =>{
            if('module-proveedor' != module.id){
                module.classList.remove('active');   
            }
        });
        
        document.getElementById('module-proveedor').classList.toggle('active');
        
    });
    
    document.getElementById('module-cliente').addEventListener("click",() =>{
        
        document.querySelectorAll('.modules').forEach((module) =>{
            if('module-cliente' != module.id){
                module.classList.remove('active');   
            }
        });
        
        document.getElementById('module-cliente').classList.toggle('active');
        
    });
    
    document.getElementById('module-empleado').addEventListener("click",() =>{
        
        document.querySelectorAll('.modules').forEach((module) =>{
            if('module-empleado' != module.id){
                module.classList.remove('active');   
            }
        });
        
        document.getElementById('module-empleado').classList.toggle('active');
        
    });
    
    document.getElementById('module-pedido').addEventListener("click",() =>{
        
        document.querySelectorAll('.modules').forEach((module) =>{
            if('module-pedido' != module.id){
                module.classList.remove('active');   
            }
        });
        
        document.getElementById('module-pedido').classList.toggle('active');
        
    });
    
    document.getElementById('module-compra').addEventListener("click",() =>{
        
        document.querySelectorAll('.modules').forEach((module) =>{
            if('module-compra' != module.id){
                module.classList.remove('active');   
            }
        });
        
        document.getElementById('module-compra').classList.toggle('active');
        
    });
    
});


