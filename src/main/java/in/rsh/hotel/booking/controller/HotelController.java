package in.rsh.hotel.booking.controller;

import in.rsh.hotel.booking.model.Hotel;
import in.rsh.hotel.booking.service.HotelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

  private final HotelService hotelService;

  @Autowired
  public HotelController(HotelService hotelService) {
    this.hotelService = hotelService;
  }

  @GetMapping("/hotels")
  public List<Hotel> getAllHotels() {
    return hotelService.getAllHotels();
  }

  @GetMapping("/hotels/{id}")
  public Hotel getHotel(@PathVariable("id") int id) {
    return hotelService.getHotelById(id);
  }

  @DeleteMapping("/hotels/{id}")
  public void deleteHotel(@PathVariable("id") int id) {
    hotelService.delete(id);
  }

  @PostMapping("/hotels")
  public int saveHotel(@RequestBody Hotel hotel) {
    hotelService.saveOrUpdate(hotel);
    return hotel.getId();
  }
}
