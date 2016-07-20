package com.maxxton.mis.booking.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.maxxton.mis.booking.domain.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Serializable>, JpaSpecificationExecutor<Booking> {

}