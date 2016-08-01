package com.maxxton.mis.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maxxton.mis.booking.domain.Booking;
import com.maxxton.mis.booking.domain.Room;
import com.maxxton.mis.booking.service.BookingService;
import com.maxxton.mis.booking.service.RoomService;

@RestController
public class BookingController {

  @Autowired
  private RoomService roomService;
  
  @Autowired
  private BookingService bookingService;
  
  @RequestMapping(value="/mis/rooms", method=RequestMethod.GET)
  public List<Room> getRooms() {
    return roomService.getAllRooms();
  }
  
  @RequestMapping(value="/mis/rooms/{roomId}", method=RequestMethod.GET)
  public Room getRoom(@PathVariable("roomId") Long roomId) {
    return roomService.getRoom(roomId);
  }
  
  @RequestMapping(value="/mis/rooms/{roomId}/bookings", method=RequestMethod.GET)
  public List<Booking> getBookingsForRoom(@PathVariable("roomId") Long roomId) {
    return bookingService.getBookingsForRoomId(roomId);
  }
  
  @RequestMapping(value="/mis/rooms/{roomId}/book", method=RequestMethod.POST)
  public Long bookRoom(@RequestBody Booking booking) {
    return bookingService.bookRoom(booking);  
  }
  
  @RequestMapping(value="/mis/rooms/bookings/{bookingId}", method=RequestMethod.DELETE)
  public void cancelBooking(@PathVariable("bookingId") Long bookingId) {
    bookingService.cancelBooking(bookingId);  
  }
}
