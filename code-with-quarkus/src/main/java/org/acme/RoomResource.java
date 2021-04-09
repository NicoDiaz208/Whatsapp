package org.acme;

import model.MessageDTO;
import model.RoomDTO;
import model.RoomRegistrationDTO;
import model.UsrDTO;
import services.RoomService;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/Room")
@RequestScoped
public class RoomResource {
    private final RoomService roomService;

    public RoomResource(RoomService roomService){
        this.roomService = roomService;
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRooms(){
        var rooms =roomService.getAllRooms();
        return Response.ok(rooms).build();
    }

    @Transactional
    @POST
    public Response addRoom(RoomDTO roomDTO){
        var result = roomService.addRoom(roomDTO);
        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }

    @Transactional
    @POST
    @Path("/addMessage/{roomId}")
    public Response addMessage(MessageDTO messageDTO, @PathParam("roomId") String roomId){
        var result = roomService.addMessage(messageDTO, roomId);
        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }

    @Transactional
    @POST
    @Path("/addUsrToRoom/")
    public Response addUsrToRoom(RoomRegistrationDTO rrDTO){
        var result = roomService.assignUsrToRoom(rrDTO);
        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }

}
