package services;

import Entities.Membership;
import Entities.Message;
import Entities.Room;
import model.MessageDTO;
import model.RoomDTO;
import model.RoomRegistrationDTO;
import repositories.MembershipRepository;
import repositories.MessageRepositoryImpl;
import repositories.RoomRepository;
import repositories.UsrRepositoryImpl;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class RoomServiceImpl implements RoomService {
    private final MessageRepositoryImpl messageRepository;
    private final UsrRepositoryImpl usrRepository;
    private final RoomRepository roomRepository;
    private final MembershipRepository membershipRepository;

    public RoomServiceImpl(MessageRepositoryImpl messageRepository, UsrRepositoryImpl usrRepository, RoomRepository roomRepository, MembershipRepository membershipRepository){
        this.messageRepository = messageRepository;
        this.usrRepository = usrRepository;
        this.roomRepository = roomRepository;
        this.membershipRepository = membershipRepository;
    }


    @Override
    public boolean addMessage(MessageDTO messageDTO, String roomId) {
        var usr = usrRepository.getUsrByUsername(messageDTO.getAuthor());
        var room = roomRepository.getById(roomId);
        var membership = membershipRepository.getByRoomUsr(room, usr);

        if(usr == null) return false;
        if(room == null) return false;
        if(membership == null) return false;

        var message = new Message();
        message.setMessage(messageDTO.getMessage());
        message.setMembership(membership);
        message.setDate(messageDTO.getDate());
        message.setDate(messageDTO.getDate());

        messageRepository.addMessage(message);

        return true;
    }

    @Override
    public boolean addRoom(RoomDTO roomDTO) {
        var existsRoom = roomRepository.getById(roomDTO.getRoomId());
        if(existsRoom != null) return false;

        var room = new Room();
        room.setRoomId(roomDTO.getRoomId());
        room.setMessages(null);
        room.setMemberships(null);

        roomRepository.addRoom(room);
        return true;
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.getAllRooms();
    }

    @Override
    public boolean assignUsrToRoom(RoomRegistrationDTO rrDTO) {
        var usr = usrRepository.getUsrByUsername(rrDTO.getUsername());
        var room = roomRepository.getById(rrDTO.getRoomId());

        if(usr == null) return false;
        if(room == null) return false;

        if(membershipRepository.getByRoomUsr(room, usr) != null) return false;

        var membership = new Membership(room, usr);

        membershipRepository.addMembership(membership);

        System.out.println(roomRepository.getById(rrDTO.getRoomId()).getMemberships().size());

        return true;
    }
}
