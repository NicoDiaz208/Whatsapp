package repositories;

import Entities.Room;

import java.util.List;

public interface RoomRepository {
    void addRoom(Room room);
    Room getById(String roomId);
    List<Room> getAllRooms();
    Room updateRoom(Room room);
}
