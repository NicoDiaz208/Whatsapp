package repositories;

import Entities.Message;
import Entities.Room;
import Entities.Usr;

import java.util.List;

public interface MessageRepository {
    void addMessage(Message message);
    List<Message> getAllMessages();
    List<Message> getAllMessagesFromRoom(String roomId);
}
