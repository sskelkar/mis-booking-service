package com.maxxton.mis.booking.specifications;

import java.util.Date;

import org.springframework.data.jpa.domain.Specification;

import com.maxxton.mis.booking.domain.Booking;
import com.maxxton.util.date.DateUtil;

public class BookingSpecifications {

  public static Specification<Booking> hasRoomId(Long roomId) {
    return (root, query, cb) -> {
      if(roomId == null)
        return cb.conjunction();
      
      return cb.equal(root.get("roomId"), roomId);
    };
  }
  
  public static Specification<Booking> isBookFromOnOrAfter(Date date) {
    return (root, query, cb) -> {
      if(date == null)
        return cb.conjunction();
      
      return cb.greaterThanOrEqualTo(cb.function("trunc", Date.class, root.get("bookFrom")), DateUtil.nullifyTimeStamp(date));
    };
  }
}
