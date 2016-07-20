package com.maxxton.mis.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxxton.mis.booking.domain.Room;
import com.maxxton.mis.booking.repository.RoomRepository;

@Service
public class RoomService {

  @Autowired
  private RoomRepository roomRepository;
  
  public List<Room> getAllRooms() {
    return roomRepository.findAll();
  }
}
