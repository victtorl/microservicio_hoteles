package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import model.Hotel;

@Repository
public class HotelesDaoImpl implements HotelesDao {
	@Autowired
	HotelesJpaSpring hoteles;
	@Override
	
	
	public List<Hotel> devolverHoteles() {		
		return hoteles.findAll();
	}
	public List<Hotel> devolverTodosHoteles() {		
		return hoteles.findAll();
	}
	
	public void guardarHotel(Hotel hotel) {
		hoteles.save(hotel);	 
	}
	
	public void actualizarHotel(Hotel hotel) {
		hoteles.save(hotel);	 
	}
	
	public Hotel obtenerReservaPorIdDAO(Integer id) {
		return hoteles.findById(id).get();
	}
	
	public void editarHotelDAO(Integer id) {
		
	}
}
