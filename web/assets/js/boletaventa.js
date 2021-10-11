/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


document.addEventListener("DOMContentLoaded", function(event) {
    
    // OnInit modificarProducto
    const productoFormActualizar = document.getElementById('productoFormActualizar');
    const idproductoform = productoFormActualizar.dataset.idproductoform;
    
    if(idproductoform){
        document.getElementById('selectProducto').value = idproductoform;
    }
    
    // Escuchando selectProducto
    const selectProducto = document.getElementById('selectProducto');
          selectProducto.addEventListener('change', (event) => {
              const seleccionado = parseInt(event.target.value);
              
              const parent = event.srcElement;
              Array.prototype.forEach.call(parent.children, child => {
                const idproducto = parseInt(child.dataset.idproducto);
                if(seleccionado == idproducto){
                    const producto       = child.dataset.product;
                    const preciounitario = child.dataset.preciounitario;
                    document.getElementById('precio').value = preciounitario;
                }
              });
          });
});


