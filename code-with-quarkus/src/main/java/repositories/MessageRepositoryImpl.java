package repositories;

import Entities.Message;
import Entities.Room;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class MessageRepositoryImpl implements MessageRepository {

    @Inject
    EntityManager entityManager;

    @Override
    public void addMessage(Message message) {
        entityManager.persist(message);
    }

    @Override
    public List<Message> getAllMessages() {
        return entityManager.createQuery("Select m from Message m").getResultList();
    }

    @Override
    public List<Message> getAllMessagesFromRoom(String roomId) {
        var q =  entityManager.createQuery("Select m from Message m where m.membership.room.roomId = :roomId");
        q.setParameter("roomId", roomId);
        return q.getResultList();
    }
}
