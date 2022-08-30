package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import model.Hotel;
import service.ServiceHoteles;

@CrossOrigin(origins="*")
@RestController
public class HotelesController {

	@Autowired
	ServiceHoteles service;
	
	@GetMapping (value ="/api/hoteles", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> devolverHoteles () {
		return service.devolverHotelesDisponibles();
	}
	
	@GetMapping (value ="/api/allhoteles", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> devolverTodosHoteles () {
		return service.devolverTodosHotelesDisponibles();
	}
	
	@PostMapping("/api/hotel")
	public void guardarHotel(@RequestBody Hotel hotel) {
		service.guardarHotel(hotel);
	}
	
	@GetMapping("/api/hotel/{id}")
	public ResponseEntity<Hotel> obtenerHotel(@PathVariable Integer id){
		try {
			Hotel telo=service.obtenerReservaPorId(id);
			return  new ResponseEntity<Hotel>(telo,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Hotel>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/api/hotel/{id}")
	public ResponseEntity<?> actualizarDisponiblidad(@RequestBody Hotel hotel,@PathVariable Integer id){
		try {
			Hotel teloexistente=service.obtenerReservaPorId(id);
			
			teloexistente.setCategoria(hotel.getCategoria());
			teloexistente.setDisponible(hotel.getDisponible());
			teloexistente.setNombre(hotel.getNombre());
			teloexistente.setPrecio(hotel.getPrecio());
			
			service.guardarHotel(teloexistente);
			
			return  new ResponseEntity<Hotel>(teloexistente,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Hotel>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}

