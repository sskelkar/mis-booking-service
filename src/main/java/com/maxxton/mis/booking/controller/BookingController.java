package com.maxxton.mis.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maxxton.mis.booking.domain.Booking;
import com.maxxton.mis.booking.domain.Room;
import com.maxxton.mis.booking.service.BookingService;
import com.maxxton.mis.booking.service.RoomService;

@RestController
@RequestMapping(value = "/mis/rooms")
public class BookingController {

  @Autowired
  private RoomService roomService;
  
  @Autowired
  private BookingService bookingService;
  
  @RequestMapping(method=RequestMethod.GET)
  public List<Room> getRooms() {
    return roomService.getAllRooms();
  }
  
  @RequestMapping(value="/{roomId}/bookings", method=RequestMethod.GET)
  public List<Booking> getBookingsForRoom(@PathVariable("roomId") Long roomId) {
    return bookingService.getBookingsForRoomId(roomId);
  }
  
  @RequestMapping(value="/{roomId}/book", method=RequestMethod.POST)
  public Long bookRoom(@PathVariable("roomId") Long roomId, Booking booking) {
    booking.setRoomId(roomId);
    return bookingService.bookRoom(booking);  
  }
}
