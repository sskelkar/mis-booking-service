package com.maxxton.mis.booking.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.*;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import java.util.Calendar;

import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.jpa.domain.Specifications;

import com.maxxton.mis.booking.domain.Booking;
import com.maxxton.mis.booking.repository.BookingRepository;
import com.maxxton.mis.booking.service.BookingService;

@RunWith(MockitoJUnitRunner.class)
public class BookingServiceTest {
  @Mock
  private BookingRepository bookingRepository;
  
  @InjectMocks
  private BookingService bookingService;
  
  @SuppressWarnings("unchecked")
  @Before
  public void init() {
    TestObjects.initTestObjects();
    when(bookingRepository.findAll(any(Specifications.class))).thenReturn(TestObjects.BOOKINGS);
  }
  
  @Test
  public void successWhenNoOverlap() {
    Calendar cal = Calendar.getInstance();
    Booking booking = new Booking();
    booking.setRoomId(1L);
    cal.set(2016, 01, 20, 14, 0);
    booking.setBookFrom(cal.getTime());
    cal.set(2016, 01, 20, 15, 0);
    booking.setBookTo(cal.getTime());
    
    Assert.assertFalse(bookingService.isOverlapWithExistingBookings(booking));
  }
  
  @Test
  public void noOverlapAtBoundaryCondition() {
    Calendar cal = Calendar.getInstance();
    cal.clear();
    Booking booking = new Booking();
    booking.setRoomId(1L);
    cal.set(2016, 06, 20, 13, 0);
    booking.setBookFrom(cal.getTime());
    cal.set(2016, 06, 20, 14, 0);
    booking.setBookTo(cal.getTime());
    
    Assert.assertFalse(bookingService.isOverlapWithExistingBookings(booking));
  }
  
  @Test
  public void testOverlapCondition() {
    Calendar cal = Calendar.getInstance();
    cal.clear();
    Booking booking = new Booking();
    booking.setRoomId(1L);
    cal.set(2016, 06, 21, 11, 0);
    booking.setBookFrom(cal.getTime());
    cal.set(2016, 06, 21, 12, 0);
    booking.setBookTo(cal.getTime());
        
    Assert.assertTrue(bookingService.isOverlapWithExistingBookings(booking));
  }
  
  @Test
  public void overlapExistsWhenNewBookingEngulfsExisting() {
    Calendar cal = Calendar.getInstance();
    cal.clear();
    Booking booking = new Booking();
    booking.setRoomId(1L);
    cal.set(2016, 06, 21, 10, 0);
    booking.setBookFrom(cal.getTime());
    cal.set(2016, 06, 21, 14, 0);
    booking.setBookTo(cal.getTime());
        
    Assert.assertTrue(bookingService.isOverlapWithExistingBookings(booking));
  }
}
