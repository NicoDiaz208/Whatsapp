package model;

import Entities.Room;

public class RoomRegistrationDTO {
    private String username;
    private String roomId;

    public RoomRegistrationDTO(){}
    public RoomRegistrationDTO(String username, String roomId){
        this.username = username;
        this.roomId = roomId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
