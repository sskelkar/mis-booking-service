CREATE OR REPLACE TRIGGER trg_room_bi
BEFORE INSERT ON room
FOR EACH ROW
BEGIN
  IF :NEW.room_id IS NULL THEN
    SELECT seq_room.NEXTVAL INTO :NEW.room_id FROM dual;
  END IF;
END;
/

CREATE OR REPLACE TRIGGER trg_room_booking_bi
BEFORE INSERT ON room_booking
FOR EACH ROW
BEGIN
  IF :NEW.room_booking_id IS NULL THEN
    SELECT seq_room_booking.NEXTVAL INTO :NEW.room_booking_id FROM dual;
  END IF;
END;
/

