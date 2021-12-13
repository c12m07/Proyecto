const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const VentSchema = new Schema({
    _id: 0,
    cedula_cliente: 0,
    detalle_venta: [{
        primero: [{
          codigo_producto: 0,
          cantidad_producto: 0,
          valor_total: 0,
          valor_venta: 0,
          valoriva: 0
        }],
        segundo: [{
          codigo_producto: 0,
          cantidad_producto: 0,
          valor_total: 0,
          valor_venta: 0,
          valoriva: 0
        }],
        tercero: [{
          codigo_producto: 0,
          cantidad_producto: 0,
          valor_total: 0,
          valor_venta: 0,
          valoriva: 0
        }]
    }],
    ivaventa: 0,
    total_venta: 0,
    valor_venta: 0
});

module.exports = mongoose.model('cal_db_ventas', VentSchema);