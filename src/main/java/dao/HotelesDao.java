package dao;

import java.util.List;
import model.Hotel;

public interface HotelesDao {
	
	
	public List<Hotel> devolverHoteles();
	
	public void guardarHotel(Hotel hotel);
	
	public Hotel obtenerReservaPorIdDAO(Integer id);
	
	public void editarHotelDAO(Integer id);
}
