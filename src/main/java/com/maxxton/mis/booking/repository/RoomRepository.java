package com.maxxton.mis.booking.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maxxton.mis.booking.domain.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Serializable> {

}
