package service;

import java.util.List;

import model.Hotel;

public interface ServiceHoteles {
	
	public List<Hotel> devolverHotelesDisponibles();
	
	public List<Hotel> devolverTodosHotelesDisponibles(); 
	
	public void guardarHotel(Hotel hotel);
	
	public Hotel obtenerReservaPorId(Integer id);

}
