package repositories;

import Entities.Membership;
import Entities.Room;
import Entities.Usr;

public interface MembershipRepository {
    Membership getByRoomUsr(Room room, Usr usr);
    void addMembership(Membership membership);
    Membership updateMembership(Membership membership);
}
