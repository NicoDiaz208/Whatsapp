package repositories;

import Entities.Usr;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class UsrRepositoryImpl implements UsrRepository {
    private final EntityManager entityManager;

    public UsrRepositoryImpl(EntityManager em){
        this.entityManager = em;
    }

    @Override
    public void addUsr(Usr user) {
        entityManager.persist(user);
    }

    @Override
    public Usr getUsrByUsername(String username) {
        var q = entityManager.createQuery("Select u FROM Usr u WHERE u.username = :username ", Usr.class);
        q.setParameter("username", username);

        return q.getResultStream().findFirst().orElse(null);
    }

    @Override
    public List<Usr> getAll() {
        return entityManager.createQuery("Select u from Usr u", Usr.class).getResultList();
    }

    @Override
    public Usr updateUsr(Usr usr) {
        return entityManager.merge(usr);
    }
}
