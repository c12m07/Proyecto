const express = require('express');
const router = express.Router();

const Bog_Cli = require('../models/bog_clientes');
const Bog_Prod = require('../models/bog_productos');
const Bog_Prov = require('../models/bog_proveedores');
const Bog_Vent = require('../models/bog_ventas');
const Cal_Cli = require('../models/cal_clientes');
const Cal_Prod = require('../models/cal_productos');
const Cal_Prov = require('../models/cal_proveedores');
const Cal_Vent = require('../models/cal_ventas');
const Med_Cli = require('../models/med_clientes');
const Med_Prod = require('../models/med_productos');
const Med_Prov = require('../models/med_proveedores');
const Med_Vent = require('../models/med_ventas');


// CRUD CLIENTES BOGOTÁ
router.post('/bogota/clientes/CRUD', async (req, res) => {
    const op = req.body.op;
    const id = req.body.id;
    console.log(op);
    var clien = null;
    switch(op){
        case 'consultar':
            var clien = await Bog_Cli.find({id});
            res.render('bogota/b_clientes',{
                clien
            })
            break;
        case 'crear':
            const clientes = new Bog_Cli(req.body);
            console.log(clientes);
            var clien = await Bog_Cli.find();
            await clientes.save();
            res.render('bogota/b_clientes',{
                clien
            });
            break;
        case 'actualizar':
            var clienF = await Bog_Cli.updateOne({id}, req.body);
            var clien = await Bog_Cli.find();
            res.render('bogota/b_clientes',{
                clien
            });
            break;
        case 'borrar':
            await   Bog_Cli.remove({id: id});
            var clien = await Bog_Cli.find();
            res.render('bogota/b_clientes',{
                clien
            });
            break;
    }
});

// CRUD CLIENTES CALI
router.post('/cali/clientes/CRUD', async (req, res) => {
    const op = req.body.op;
    const id = req.body.id;
    console.log(op);
    var clien = null;
    switch(op){
        case 'consultar':
            var clien = await Cal_Cli.find({id});
            res.render('cali/c_clientes',{
                clien
            })
            break;
        case 'crear':
            const clientes = new Cal_Cli(req.body);
            console.log(clientes);
            var clien = await Cal_Cli.find();
            await clientes.save();
            res.render('cali/c_clientes',{
                clien
            });
            break;
        case 'actualizar':
            var clienF = await Cal_Cli.updateOne({id}, req.body);
            var clien = await Cal_Cli.find();
            res.render('cali/c_clientes',{
                clien
            });
            break;
        case 'borrar':
            await Cli.remove({id: id});
            var clien = await Cal_Cli.find();
            res.render('cali/c_clientes',{
                clien
            });
            break;
    }
});

// CRUD CLIENTES MEDELLIN
router.post('/medellin/clientes/CRUD', async (req, res) => {
    const op = req.body.op;
    const id = req.body.id;
    console.log(op);
    var clien = null;
    switch(op){
        case 'consultar':
            var clien = await Med_Cli.find({id});
            res.render('medellin/m_clientes',{
                clien
            })
            break;
        case 'crear':
            const clientes = new Med_Cli(req.body);
            console.log(clientes);
            var clien = await Med_Cli.find();
            await clientes.save();
            res.render('medellin/m_clientes',{
                clien
            });
            break;
        case 'actualizar':
            var clienF = await Med_Cli.updateOne({id}, req.body);
            var clien = await Med_Cli.find();
            res.render('medellin/m_clientes',{
                clien
            });
            break;
        case 'borrar':
            await Cli.remove({id: id});
            var clien = await Med_Cli.find();
            res.render('medellin/m_clientes',{
                clien
            });
            break;
    }
});

// CRUD PROVEEDORES BOGOTA
router.post('/bogota/proveedores/CRUD', async (req, res) => {
    const op = req.body.op;
    const id = req.body.id;
    console.log(id);
    console.log(op);
    var prov = null;
    switch(op){
        case 'consultar':
            var prov = await Bog_Prov.find({id});
            res.render('bogota/b_proveedores',{
                prov
            })
            break;
        case 'crear':
            var prover = new Bog_Prov(req.body);
            console.log(prov);
            var prov = await Bog_Prov.find();
            await prover.save();
            res.render('bogota/b_proveedores',{
                prov
            });
            break;
        case 'actualizar':
            var provF = await Bog_Prov.updateOne({id}, req.body);
            var prov = await Bog_Prov.find();
            res.render('bogota/b_proveedores',{
                prov
            });
            break;
        case 'borrar':
            await Bog_Prov.remove({id: id});
            var prov = await Bog_Prov.find();
            res.render('bogota/b_proveedores',{
                prov
            });
            break;
    }
});

// CRUD PROVEEDORES CALI
router.post('/cali/proveedores/CRUD', async (req, res) => {
    const op = req.body.op;
    const id = req.body.id;
    console.log(id);
    console.log(op);
    var prov = null;
    switch(op){
        case 'consultar':
            var prov = await Cal_Prov.find({id});
            res.render('cali/c_proveedores',{
                prov
            })
            break;
        case 'crear':
            var prover = new Cal_Prov(req.body);
            console.log(prov);
            var prov = await Cal_Prov.find();
            await prover.save();
            res.render('cali/c_proveedores',{
                prov
            });
            break;
        case 'actualizar':
            var provF = await Cal_Prov.updateOne({id}, req.body);
            var prov = await Cal_Prov.find();
            res.render('cali/c_proveedores',{
                prov
            });
            break;
        case 'borrar':
            await Cal_Prov.remove({id: id});
            var prov = await Cal_Prov.find();
            res.render('cali/c_proveedores',{
                prov
            });
            break;
    }
});

// CRUD PROVEEDORES MEDELLIN
router.post('/medellin/proveedores/CRUD', async (req, res) => {
    const op = req.body.op;
    const id = req.body.id;
    console.log(id);
    console.log(op);
    var prov = null;
    switch(op){
        case 'consultar':
            var prov = await Med_Prov.find({id});
            res.render('medellin/m_proveedores',{
                prov
            })
            break;
        case 'crear':
            var prover = new Med_Prov(req.body);
            console.log(prov);
            var prov = await Med_Prov.find();
            await prover.save();
            res.render('medellin/m_proveedores',{
                prov
            });
            break;
        case 'actualizar':
            var provF = await Med_Prov.updateOne({id}, req.body);
            var prov = await Med_Prov.find();
            res.render('medellin/m_proveedores',{
                prov
            });
            break;
        case 'borrar':
            await Med_Prov.remove({id: id});
            var prov = await Med_Prov.find();
            res.render('medellin/m_proveedores',{
                prov
            });
            break;
    }
});

// METODO ELIMINAR
router.get('/bogota/productos/delete', async (req, res) => {
    await Bog_Prod.deleteMany();
    const prods = await Prod.find();
    res.render('bogota/b_productos', {
        prods
    });
});
router.get('/cali/productos/delete', async (req, res) => {
    await Cal_Prod.deleteMany();
    const prods = await Cal_Prod.find();
    res.render('cali/c_productos', {
        prods
    });
});
router.get('/medellin/productos/delete', async (req, res) => {
    await Med_Prod.deleteMany();
    const prods = await Med_Prod.find();
    res.render('medellin/m_productos', {
        prods
    });
});

// PRINCIPAL
router.get('/', (req, res) => {
    res.render('index')
});

// LOGIN
router.get('/cali/login', (req, res) => {
    res.render('cali/c_login')
});
router.get('/bogota/login', (req, res) => {
    res.render('bogota/b_login')
});
router.get('/medellin/login', (req, res) => {
    res.render('medellin/m_login')
});

// PRODUCTOS
router.get('/bogota/productos', async (req, res) => {
    const prods = await Bog_Prod.find();
    res.render('bogota/b_productos', {
        prods
    });
});
router.get('/cali/productos', async (req, res) => {
    const prods = await Cal_Prod.find();
    res.render('cali/c_productos', {
        prods
    });
});
router.get('/medellin/productos', async (req, res) => {
    const prods = await Med_Prod.find();
    res.render('medellin/m_productos', {
        prods
    });
});

// CLIENTES
router.get('/bogota/clientes', async (req, res) => {
    const clien = await Bog_Cli.find();
    res.render('bogota/b_clientes',{
        clien
    });
});
router.get('/cali/clientes', async (req, res) => {
    const clien = await Cal_Cli.find();
    res.render('cali/c_clientes',{
        clien
    });
});
router.get('/medellin/clientes', async (req, res) => {
    const clien = await Med_Cli.find();
    res.render('medellin/m_clientes',{
        clien
    });
});
// PROVEEDORES
router.get('/bogota/proveedores', async (req, res) => {
    const prov = await Bog_Prov.find();
    res.render('bogota/b_proveedores',{
        prov
    })
});
router.get('/cali/proveedores', async (req, res) => {
    const prov = await Cal_Prov.find();
    res.render('cali/c_proveedores',{
        prov
    })
});
router.get('/medellin/proveedores', async (req, res) => {
    const prov = await Med_Prov.find();
    res.render('medellin/m_proveedores',{
        prov
    })
});
// VENTAS
router.get('/bogota/ventas', (req, res) => { 
    res.render('bogota/b_ventas')
});
router.get('/medellin/ventas', (req, res) => {
    res.render('medellin/m_ventas')
});
router.get('/cali/ventas', (req, res) => {
    res.render('cali/c_ventas')
});
// REPORTES
router.get('/bogota/reportes', (req, res) => {
    res.render('bogota/b_reportes')
});
router.get('/medellin/reportes', (req, res) => {
    res.render('medellin/m_reportes')
});
router.get('/cali/reportes', (req, res) => {
    res.render('cali/c_reportes')
});
        // LISTADO DE CLIENTES VENTAS
            router.get('/bogota/lista_clientes', async (req, res) => {
                const client = await Bog_Cli.find();
                res.render('bogota/b_lista_clientes',{
                    client
                })
            });
            router.get('/cali/lista_clientes', async (req, res) => {
                const client = await Cal_Cli.find();
                res.render('cali/c_lista_clientes',{
                    client
                })
            });
            router.get('/medellin/lista_clientes', async (req, res) => {
                const client = await Med_Cli.find();
                res.render('medellin/m_lista_clientes',{
                    client
                })
            });
        // VENTAS POR CLIENTE
        router.get('/bogota/ventas_cliente', async(req, res) => {
            const ventas = await Bog_Vent.find();
            const calculo = await Bog_Vent.find();
            var clien = await Bog_Cli.find();
            console.log(ventas);
            res.render('bogota/b_ventas_cliente',{
                ventas, calculo, clien
            })
        });
        router.get('/cali/ventas_cliente', async(req, res) => {
            const ventas = await Cal_Vent.find();
            const calculo = await Cal_Vent.find();
            var clien = await Cal_Cli.find();
            console.log(ventas);
            res.render('cali/c_ventas_cliente',{
                ventas, calculo, clien
            })
        });
        router.get('/medellin/ventas_cliente', async(req, res) => {
            const ventas = await Med_Vent.find();
            const calculo = await Med_Vent.find();
            var clien = await Med_Cli.find();
            console.log(ventas);
            res.render('medellin/m_ventas_cliente',{
                ventas, calculo, clien
            })
        });
// CONSOLIDADO
router.get('/bogota/consolidado', async(req, res) => {
    const bog = await Bog_Vent.find();
    const cal = await Cal_Vent.find();
    const med = await Med_Vent.find();
    console.log(bog);
    console.log(cal);
    console.log(med);
    res.render('bogota/b_consolidado',{
        bog, cal, med
    })
});

module.exports = router;