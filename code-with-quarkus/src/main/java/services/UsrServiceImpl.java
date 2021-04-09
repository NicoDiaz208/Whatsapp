package services;

import Entities.Membership;
import Entities.Room;
import Entities.Usr;
import model.UsrDTO;
import repositories.UsrRepositoryImpl;

import javax.enterprise.context.RequestScoped;
import java.util.LinkedList;
import java.util.List;

@RequestScoped
public class UsrServiceImpl implements UsrService {
    private final UsrRepositoryImpl usrRepository;

    public UsrServiceImpl(UsrRepositoryImpl usrRepository){
        this.usrRepository = usrRepository;
    }

    @Override
    public boolean addUsr(UsrDTO usr) {
        var existsUsr = usrRepository.getUsrByUsername(usr.getUsername());
        if(existsUsr != null) return false;

        var usrOrig = new Usr();
        usrOrig.setUsername(usr.getUsername());
        usrOrig.setPassword(usr.getPassword());

        this.usrRepository.addUsr(usrOrig);

        return true;
    }

    @Override
    public Usr getUsrByUsername(String username) {
        var usr = this.usrRepository.getUsrByUsername(username);
        return usr;
    }

    @Override
    public List<Usr> getAll() {
        return usrRepository.getAll();
    }

    @Override
    public List<Room> getAllRoomsFromUsername(String username) {
        var usr = this.getUsrByUsername(username);
        var memberships = usr.getMemberships();
        var rooms = new LinkedList<Room>();

        for (Membership membership : memberships) {
            rooms.add(membership.getRoom());
        }

        return rooms;
    }
}
