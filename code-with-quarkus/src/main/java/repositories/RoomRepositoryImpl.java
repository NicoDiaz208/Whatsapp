package repositories;

import Entities.Room;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class RoomRepositoryImpl implements RoomRepository {
    private final EntityManager entityManager;

    public RoomRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void addRoom(Room room) {
        entityManager.persist(room);
    }

    @Override
    public Room getById(String roomId) {
        var q = entityManager.createQuery("Select r from Room r where r.roomId = :roomId", Room.class);
        q.setParameter("roomId", roomId);
        return q.getResultStream().findFirst().orElse(null);
    }

    @Override
    public List<Room> getAllRooms() {
        return entityManager.createQuery("Select r from  Room r", Room.class).getResultList();
    }

    @Override
    public Room updateRoom(Room room) {
        entityManager.merge(room);
        return room;
    }
}
