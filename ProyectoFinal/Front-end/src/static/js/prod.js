let archivo = document.querySelector('#mi-archivo');

archivo.addEventListener('change',() =>{
    document.querySelector('#name_arc').innerText = 
    archivo.files[0].name;
})