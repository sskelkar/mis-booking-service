package com.maxxton.mis.booking.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import com.maxxton.mis.booking.domain.Booking;

public class TestObjects {

  public static Booking BOOKING_1;
  public static Booking BOOKING_2;
  public static List<Booking> BOOKINGS;
  
  public static void initTestObjects() {
    Calendar cal = Calendar.getInstance();
    cal.clear();
    
    BOOKING_1 = new Booking();
    BOOKING_1.setRoomId(1L);
    cal.set(2016, 06, 20, 14, 0);
    BOOKING_1.setBookFrom(cal.getTime());
    cal.set(2016, 06, 20, 15, 0);
    BOOKING_1.setBookTo(cal.getTime());
    
    BOOKING_2 = new Booking();
    BOOKING_2.setRoomId(1L);    
    cal.set(2016, 06, 21, 11, 30);
    BOOKING_2.setBookFrom(cal.getTime());
    cal.set(2016, 06, 21, 12, 0);
    BOOKING_2.setBookTo(cal.getTime());
    
    BOOKINGS = Arrays.asList(BOOKING_1, BOOKING_2);
  }
}
