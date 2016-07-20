package com.maxxton.mis.booking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="room")
public class Room {
  
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_ROOM")
  @SequenceGenerator(name="SEQ_ROOM", sequenceName="SEQ_ROOM", allocationSize=1)
  @Column(name = "room_id")
  private Long roomId;
  
  private String name;
  
  private String description;

  public Long getRoomId() {
    return roomId;
  }

  public void setRoomId(Long roomId) {
    this.roomId = roomId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }  
  
}
