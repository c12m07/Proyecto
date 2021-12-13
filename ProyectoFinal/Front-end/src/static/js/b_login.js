function ingreso(){
    var u="admininicial";
    var c="admin123456";
  
    if(document.form.user.value==u && document.form.pass.value==c){
    alert ("Bienvenido a la sucursal de Bogotá");
    window.location="productos";}
    else{
    alert ("Usuario o Contraseña Incorrectos");
  
  }
}