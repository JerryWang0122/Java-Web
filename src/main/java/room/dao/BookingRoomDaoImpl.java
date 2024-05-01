package room.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import room.model.po.BookingRoom;

import java.util.List;

public class BookingRoomDaoImpl implements BookingRoomDao{

    private JdbcTemplate jdbcTemplate = JdbcTemplateBuild.getInstance();

    @Override
    public BookingRoom findById(Integer bookingId) {
        String sql = "select booking_id, room_id, user_id, checkin_date, create_time " +
                        "from booking_room where booking_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BookingRoom.class), bookingId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<BookingRoom> findAll() {
        String sql = "select booking_id, room_id, user_id, checkin_date, create_time from booking_room";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BookingRoom.class));
    }

    @Override
    public List<BookingRoom> findByUserId(Integer userId) {
        String sql = "select booking_id, room_id, user_id, checkin_date, create_time " +
                        "from booking_room where user_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BookingRoom.class), userId);
    }

    @Override
    public int create(BookingRoom bookingRoom) {
        String sql = "insert into booking_room(room_id, user_id, checkin_date) values (?, ?, ?)";
        return jdbcTemplate.update(sql, bookingRoom.getRoomId(),
                bookingRoom.getUserId(), bookingRoom.getCheckinDate());
    }

    @Override
    public int update(Integer bookingId, BookingRoom bookingRoom) {
        String sql = "update booking_room set room_id = ?, user_id = ?, " +
                "checkin_date = ? where booking_id = ?";
        return jdbcTemplate.update(sql, bookingRoom.getBookingId());
    }

    @Override
    public int delete(Integer bookingId) {
        return 0;
    }
}
