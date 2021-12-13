package generica.T_Productos.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import generica.T_Productos.Model.Med_Mod_Productos;
import generica.T_Productos.Repository.Med_Rep_Productos;

@CrossOrigin(origins = "http://localhost:8083")
@RestController
@RequestMapping("/api")
public class Med_Con_Productos {

	@Autowired
	Med_Rep_Productos productoRepo;

	@GetMapping("/medellin/productos")
	  public ResponseEntity<List<Med_Mod_Productos>> getAllProductos() {
		  try {
			    List<Med_Mod_Productos> productos = new ArrayList<Med_Mod_Productos>();

			    productoRepo.findAll().forEach(productos::add);

			    if (productos.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }

			    return new ResponseEntity<>(productos, HttpStatus.OK);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
	
	@GetMapping("/medellin/productos/{id}")
	  public ResponseEntity<Med_Mod_Productos> getProductoById(@PathVariable("id") String id) {
		  		Optional<Med_Mod_Productos> productoData = productoRepo.findById(id);

		  if (productoData.isPresent()) {
		    return new ResponseEntity<>(productoData.get(), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }
	
	  @PostMapping("/medellin/productos")
	  public ResponseEntity<Med_Mod_Productos> createProducto(@RequestBody Med_Mod_Productos producto) {
		  try {
			  	Med_Mod_Productos _producto = productoRepo.save(new Med_Mod_Productos(producto.getId(), producto.getNombre_producto(), producto.getNitproveedor(), producto.getPrecio_compra(), producto.getIvacompra(), producto.getPrecio_venta()));
			    return new ResponseEntity<>(_producto, HttpStatus.CREATED);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
	  
	  @DeleteMapping("/medellin/productos")
	  public ResponseEntity<HttpStatus> deleteAllProductos() {
		  try {
			  	productoRepo.deleteAll();
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
}