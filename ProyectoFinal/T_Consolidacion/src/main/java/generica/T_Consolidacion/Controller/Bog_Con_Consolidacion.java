package generica.T_Consolidacion.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import generica.T_Consolidacion.Repository.Bog_Rep_Consolidacion;

@CrossOrigin(origins = "http://localhost:8084")
@RestController
@RequestMapping("/api")
public class Bog_Con_Consolidacion {

	@Autowired
	Bog_Rep_Consolidacion consolidadoRepo;
	
	@GetMapping("/bogota/consolidado")
	public ResponseEntity<List<Bog_Mod_Consolidacion>> getAllConsolidados(){
		try {
			
		} catch() {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/bogota/consolidado/{id}")
	public ResponseEntity<HttpStatus> delleteConsolidado(@PathVariable("id") String id){
		try {
			consolidadoRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}

	
	@DeleteMapping("/bogota/consolidado")
	public ResponseEntity<HttpStatus> delleteAllConsolidados(){
		try {
			consolidadoRepo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}

}
