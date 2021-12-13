package generica.T_Clientes.Controller;

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

import generica.T_Clientes.Model.Cal_Mod_Clientes;
import generica.T_Clientes.Repository.Cal_Rep_Clientes;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/api")
public class Cal_Con_Clientes {

	@Autowired
	Cal_Rep_Clientes clienteRepo;
	
	@GetMapping("/cali/clientes/listar")
	public ResponseEntity<List<Cal_Mod_Clientes>> getAllClientes(){
		try {
			List<Cal_Mod_Clientes> clientes = new ArrayList<Cal_Mod_Clientes>();
			clienteRepo.findAll().forEach(clientes::add);
		
			if(clientes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(clientes, HttpStatus.OK);
		} catch(Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/cali/clientes/{id}")
	  public ResponseEntity<Cal_Mod_Clientes> getClienteById(@PathVariable("id") String id) {
		  		Optional<Cal_Mod_Clientes> clienteData = clienteRepo.findById(id);

		  if (clienteData.isPresent()) {
		    return new ResponseEntity<>(clienteData.get(), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }
	
	@PostMapping("/cali/clientes")
	public ResponseEntity<Cal_Mod_Clientes> createCliente(@RequestBody Cal_Mod_Clientes cliente) {
		try {
			Cal_Mod_Clientes _cliente = clienteRepo.save(new Cal_Mod_Clientes(cliente.getId(), cliente.getDireccion_cliente(), cliente.getEmail_cliente(), cliente.getNombre_cliente(), cliente.getTelefono_cliente()));
			return new ResponseEntity<>(_cliente, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/cali/clientes/{id}")
	public ResponseEntity<Cal_Mod_Clientes> updateCliente(@PathVariable("id") String id, @RequestBody Cal_Mod_Clientes cliente){
		Optional<Cal_Mod_Clientes> clienteData = clienteRepo.findById(id);
		
		if (clienteData.isPresent()) {
			Cal_Mod_Clientes _cliente = clienteData.get();
			_cliente.setId(cliente.getId());
			_cliente.setDireccion_cliente(cliente.getDireccion_cliente());
			_cliente.setEmail_cliente(cliente.getEmail_cliente());
			_cliente.setNombre_cliente(cliente.getNombre_cliente());
			_cliente.setTelefono_cliente(cliente.getTelefono_cliente());
			return new ResponseEntity<>(clienteRepo.save(_cliente), HttpStatus.OK);	
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/cali/clientes/{id}")
	public ResponseEntity<HttpStatus> deleteCliente(@PathVariable("id") String id){
		try {
			clienteRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/cali/clientes")
	public ResponseEntity<HttpStatus> deleteAllClientes() {
		try {
			clienteRepo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}