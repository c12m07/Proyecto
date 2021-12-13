const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const ProductSchema = new Schema({
    id: String,
    nombre_proveedor: String,
    direccion_proveedor: String,
    email_proveedor: String,
    telefono_proveedor: String
})

module.exports = mongoose.model('med_db_proveedores', ProductSchema);