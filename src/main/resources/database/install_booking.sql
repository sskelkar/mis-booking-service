-- Package com.maxxton.mis.booking

-- room
CREATE SEQUENCE seq_room START WITH 1;

CREATE TABLE room
(
  room_id NUMBER NOT NULL,
  name VARCHAR2(50),
  description VARCHAR2(100),
  
  CONSTRAINT pk_room PRIMARY KEY (room_id)
);

-- room_booking
CREATE SEQUENCE seq_room_booking START WITH 1;

CREATE TABLE room_booking
(
  room_booking_id NUMBER NOT NULL,
  book_from DATE NOT NULL,
  book_to DATE NOT NULL,
  room_id NUMBER,
  employee_id NUMBER,  
  purpose VARCHAR2(100),
  
  CONSTRAINT pk_booking PRIMARY KEY (room_booking_id),
  CONSTRAINT fk_booking_emp FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
  CONSTRAINT fk_booking_room FOREIGN KEY (room_id) REFERENCES room(room_id)  
);
