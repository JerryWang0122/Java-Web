package room.dao;

import room.model.dto.BookingRoomCount;
import room.model.po.BookingRoom;

import java.util.List;

public interface BookingRoomDao {
    BookingRoom findById(Integer bookingId);
    List<BookingRoom> findAll();
    List<BookingRoom> findByUserId(Integer userId);
    // 5/1 額外需要增加的統計功能
    List<BookingRoomCount> getBookingRoomCounts();
    int create(BookingRoom bookingRoom);
    int update(Integer bookingId, BookingRoom bookingRoom);
    int delete(Integer bookingId);
}
