package com.maxxton.mis.booking.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Table
@Entity(name="room_booking")
public class Booking {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_ROOM_BOOKING")
  @SequenceGenerator(name="SEQ_ROOM_BOOKING", sequenceName="SEQ_ROOM_BOOKING", allocationSize=1)
  @Column(name = "room_booking_id")
  private Long bookingId;
  
  @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
  private Date bookFrom;
  
  @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
  private Date bookTo;
  
  private Long roomId;
  
  private Long employeeId;
  
  private String purpose;
  
  public Date getBookFrom() {
    return bookFrom;
  }

  public void setBookFrom(Date bookFrom) {
    this.bookFrom = bookFrom;
  }
  
  public Date getBookTo() {
    return bookTo;
  }

  public void setBookTo(Date bookTo) {
    this.bookTo = bookTo;
  }
  
  public Long getBookingId() {
    return bookingId;
  }

  public void setBookingId(Long bookingId) {
    this.bookingId = bookingId;
  }

  public Long getRoomId() {
    return roomId;
  }

  public void setRoomId(Long roomId) {
    this.roomId = roomId;
  }

  public Long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public String getPurpose() {
    return purpose;
  }

  public void setPurpose(String purpose) {
    this.purpose = purpose;
  } 
}
