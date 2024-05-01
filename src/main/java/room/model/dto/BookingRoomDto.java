package room.model.dto;

import room.model.po.Room;

import java.util.Date;

public class BookingRoomDto {
    private Integer bookingId;
    // private Integer roomId;
    private Room room;
    private Integer userId;
    private Date checkinDate;
    private Date createTime;
}
