package services;

import Entities.Room;
import Entities.Usr;
import model.UsrDTO;

import java.util.List;

public interface UsrService {
    boolean addUsr(UsrDTO usr);
    Usr getUsrByUsername(String username);
    List<Usr> getAll();
    List<Room> getAllRoomsFromUsername(String username);
}
