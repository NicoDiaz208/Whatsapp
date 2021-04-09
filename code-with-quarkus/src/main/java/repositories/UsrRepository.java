package repositories;

import Entities.Usr;

import java.util.List;

public interface UsrRepository {
    void addUsr(Usr user);
    Usr getUsrByUsername(String username);
    List<Usr> getAll();
    Usr updateUsr(Usr usr);
}
