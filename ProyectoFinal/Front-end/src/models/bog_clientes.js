const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const ClientSchema = new Schema({
    id: String,
    direccion_cliente: String,
    email_cliente: String,
    nombre_cliente: String,
    telefono_cliente: String
})

module.exports = mongoose.model('bog_db_clientes', ClientSchema);