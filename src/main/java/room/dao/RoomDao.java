package room.dao;

import room.model.po.Room;

import java.util.List;

public interface RoomDao {
    Room findById(Integer roomId);
    List<Room> findAll();
    int create(Room room);
    int update(Integer roomId, Room room);
    int delete(Integer roomId);
}
