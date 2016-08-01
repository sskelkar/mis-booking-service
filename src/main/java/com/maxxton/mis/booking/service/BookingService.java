package com.maxxton.mis.booking.service;

import static com.maxxton.mis.booking.specifications.BookingSpecifications.hasRoomId;
import static com.maxxton.mis.booking.specifications.BookingSpecifications.isBookFromOnOrAfter;
import static org.springframework.data.jpa.domain.Specifications.where;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import com.maxxton.mis.booking.domain.Booking;
import com.maxxton.mis.booking.repository.BookingRepository;

@Service
public class BookingService {

  @Autowired
  private BookingRepository bookingRepository;
  
  public List<Booking> getBookingsForRoomId(Long roomId) {
    Specifications<Booking> specifications =  where(hasRoomId(roomId)).and(isBookFromOnOrAfter(new Date()));
    return bookingRepository.findAll(specifications);
  }
  
  public Long bookRoom(Booking booking) {
    if(isOverlapWithExistingBookings(booking))
      throw new RuntimeException("Dates overlap with existing bookings");
    
    return bookingRepository.save(booking).getBookingId();
  }
  
  boolean isOverlapWithExistingBookings(Booking booking) {
    Specifications<Booking> specifications =  where(hasRoomId(booking.getRoomId())).and(isBookFromOnOrAfter(booking.getBookFrom()));
    List<Booking> existingBookings = bookingRepository.findAll(specifications);
    
    for(Booking existingBooking : existingBookings) {
      boolean newBookingEndsBeforeExistingBookingStarts = !booking.getBookTo().after(existingBooking.getBookFrom());
      boolean newBookingStartsAfterExistingBookingEnds = !booking.getBookFrom().before(existingBooking.getBookTo());
      boolean neitherOfAboveConditionsAreTrue = !(newBookingEndsBeforeExistingBookingStarts || newBookingStartsAfterExistingBookingEnds);
      
      if(neitherOfAboveConditionsAreTrue) {
        return true;
      }
    }
    
    return false;
  }
  
  public void cancelBooking(Long bookingId) {
    bookingRepository.delete(bookingRepository.findOne(bookingId));
  }
}
