package repositories;

import Entities.Membership;
import Entities.Room;
import Entities.Usr;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;

@RequestScoped
public class MembershipRepositoryImpl implements MembershipRepository{
    private final EntityManager entityManager;

    public MembershipRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    public Membership getByRoomUsr(Room room, Usr usr) {
        var q = entityManager.createQuery("Select m from Membership m where m.room = :room and m.usr = :usr", Membership.class);
        q.setParameter("room", room).setParameter("usr", usr);
        return q.getResultStream().findFirst().orElse(null);
    }

    @Override
    public void addMembership(Membership membership) {
        entityManager.persist(membership);
    }

    @Override
    public Membership updateMembership(Membership membership) {
        entityManager.merge(membership);
        return  membership;
    }
}
