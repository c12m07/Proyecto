const path = require('path');
const express = require('express');
const morgan = require('morgan');
const mongoose = require('mongoose');

const app = express();

// MONGO DB
mongoose.connect('mongodb://localhost:27017/tienda')
    .then(db => console.log('Db connected'))
    .catch(err => console.log(err));

// IMPORT ROUTES
const indexRout = require('./routes/index');

// SETTINGS
app.set('port', process.env.PORT || 3000);
app.set('views', path.join(__dirname+ '/views'));
app.use(express.static(__dirname + '/static'));
app.set('view engine', 'ejs');

// MIDDLEWARES
app.use(morgan('dev'));
app.use(express.urlencoded({extended: false}));

// ROUTES
app.use('/', indexRout);

// STARTING THE SERVER
app.listen(app.get('port'), () =>{
    console.log('SERVIDOR INICIADO');
})