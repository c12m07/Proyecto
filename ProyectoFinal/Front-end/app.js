const express = require('express');
const path = require('path');
const bodyParser = require('body-parser')
const app = express();
const bcrypt= require('bcrypt');
const mongoose=require('mongoose');
const user = require('./public/user.js');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:false}));
app.use(express.static(path.join(__dirname,'public')));
const mongo_uri ='mongodb://localhost:27017/tienda'
mongoose.connect(mongo_uri,function(err){
    if(err){
        console.log('Inicia Log de errores de Mongo');
        throw  err;
        console.log('Finaliza Log de errores de Mongo');
    }
    else{
        console.log('se conectó a ${mongo_uri}');
    }
});

app.post('/register',(req,res) => { 
    
    const {username,password} =req.body;
    console.log('Entra a metodo post/register');
const  User=new user({username,password});
console.log('Declara variable user');
    User.save(err =>{
        if(err){
            res.status(500).send('Error al registrar usuario');
        }
        else{
            res.status(200).send('Usuario Registrado');
            return res.redirect('http://localhost:3000/Principal.html');0.
        }
    });
    
});
app.post('/authenticate',(req,res) => { 
    const {username,password} =req.body;
    user.findOne({username},(err,user) => {
        if(err){
            res.status(500).send('Error al autenticar usuario');
        }else if(!user){
            res.status(500).send('El usuario no existe');
        } else
        {
            user.isCorrectPassword(password,(err,result)=>{
                if(err){
                    res.status(500).send('Error al autenticar');
                }else if(result){
                    // res.status(200).send('Usuario logueado correctamente');
                    return res.redirect('http://localhost:3000/Principal.html');
                }else{
                    res.status(500).send('usuario o clave incorrecta');
                }
            });
        }
    });
});
app.listen(3000,() => {
        console.log('Servidor Inicia puerto 3000');
})
module.exports=app;