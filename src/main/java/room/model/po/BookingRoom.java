package room.model.po;

import lombok.Data;

import java.util.Date;

@Data
public class BookingRoom {
    private Integer bookingId;
    private Integer roomId;
    private Integer userId;
    private Date checkinDate;
    private Date createTime;
}
