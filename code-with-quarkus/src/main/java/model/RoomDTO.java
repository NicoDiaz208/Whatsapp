package model;

import Entities.Room;

public class RoomDTO {
    private String roomId;

    public RoomDTO(){}

    public RoomDTO(String roomId){
        this.roomId = roomId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
