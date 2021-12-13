const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const ProductSchema = new Schema({
    _id: 0,
    ivacompra: 0,
    nitproveedor: 0,
    nombre_producto: String,
    precio_compra: 0,
    precio_venta: 0
})

module.exports = mongoose.model('bog_db_productos', ProductSchema);