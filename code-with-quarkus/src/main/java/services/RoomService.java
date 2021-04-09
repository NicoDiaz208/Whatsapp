package services;

import Entities.Room;
import model.MessageDTO;
import model.RoomDTO;
import model.RoomRegistrationDTO;

import java.util.List;

public interface RoomService {
    boolean addMessage(MessageDTO messageDTO, String roomId);
    List<Room> getAllRooms();
    boolean addRoom(RoomDTO roomDTO);
    boolean assignUsrToRoom(RoomRegistrationDTO rrDTO);
}
