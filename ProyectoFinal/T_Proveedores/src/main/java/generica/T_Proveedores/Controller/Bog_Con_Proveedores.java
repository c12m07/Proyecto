package generica.T_Proveedores.Controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import generica.T_Proveedores.Model.Bog_Mod_Proveedores;
import generica.T_Proveedores.Repository.Bog_Rep_Proveedores;

@CrossOrigin(origins = "http://localhost:8085")
@RestController
@RequestMapping("/api")
public class Bog_Con_Proveedores {

	@Autowired
	Bog_Rep_Proveedores proveedorRepo;
	
	@GetMapping("/bogota/proveedores")
	public ResponseEntity<List<Bog_Mod_Proveedores>> getAllProveedres(){
		try{
			List<Bog_Mod_Proveedores> proveedor = new ArrayList<Bog_Mod_Proveedores>();

			proveedorRepo.findAll().forEach(proveedor::add);

			if(proveedor.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(proveedor, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/bogota/proveedores/{id}")
	  public ResponseEntity<Bog_Mod_Proveedores> getProveedorById(@PathVariable("id") String id) {
		  		Optional<Bog_Mod_Proveedores> proveedorData = proveedorRepo.findById(id);

		  if (proveedorData.isPresent()) {
		    return new ResponseEntity<>(proveedorData.get(), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }
	
	@PostMapping("/bogota/proveedores")
	public ResponseEntity<Bog_Mod_Proveedores> createProveedor(@RequestBody Bog_Mod_Proveedores proveedor){
		try {
			Bog_Mod_Proveedores _proveedor= proveedorRepo.save(new Bog_Mod_Proveedores(proveedor.getId(), proveedor.getCiudad_proveedor(), proveedor.getDireecion_proveedor(), proveedor.getNombre_proveedor(), proveedor.getTelefono_proveedor()));
			return new ResponseEntity<>(_proveedor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/bogota/proveedores/{id}")
	public ResponseEntity<Bog_Mod_Proveedores> updateProveedor(@PathVariable("id") String id, @RequestBody Bog_Mod_Proveedores proveedor){
		Optional<Bog_Mod_Proveedores> proveedorData = proveedorRepo.findById(id);
		
		if (proveedorData.isPresent()) {
			Bog_Mod_Proveedores _proveedor = proveedorData.get();
			_proveedor.setId(proveedor.getId());
			_proveedor.setCiudad_proveedor(proveedor.getCiudad_proveedor());
			_proveedor.setDireecion_proveedor(proveedor.getDireecion_proveedor());
			_proveedor.setNombre_proveedor(proveedor.getNombre_proveedor());
			_proveedor.setTelefono_proveedor(proveedor.getTelefono_proveedor());
			return new ResponseEntity<>(proveedorRepo.save(_proveedor), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/bogota/proveedores/{id}")
	public ResponseEntity<HttpStatus> deleteProveedor(@PathVariable("id") String id){
		try {
			proveedorRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/bogota/proveedores")
	public ResponseEntity<HttpStatus> deleteAllProveedores(){
		try {
			proveedorRepo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
}