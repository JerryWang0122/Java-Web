package room.dao;

import room.model.po.BookingRoom;

import java.util.List;

public interface BookingRoomDao {
    BookingRoom findById(Integer bookingId);
    List<BookingRoom> findAll();
    List<BookingRoom> findByUserId(Integer userId);
    int create(BookingRoom bookingRoom);
    int update(Integer bookingId, BookingRoom bookingRoom);
    int delete(Integer bookingId);
}
