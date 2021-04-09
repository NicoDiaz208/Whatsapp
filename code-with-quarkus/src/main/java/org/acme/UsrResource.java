package org.acme;

import model.UsrDTO;
import services.UsrService;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/Usr")
@RequestScoped
public class UsrResource {
    private final UsrService usrService;

    public UsrResource(UsrService usrService){
        this.usrService = usrService;
    }

    @Transactional
    @POST
    public Response addUsr(UsrDTO usrDTO){
        var result = usrService.addUsr(usrDTO);
        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsrs(){
        var usrs = usrService.getAll();
        return Response.ok(usrs).build();
    }

    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsrByUsername(@PathParam("username") String username){
        var usr = usrService.getUsrByUsername(username);
        return Response.ok(usr).build();
    }

    @GET
    @Path("/Rooms/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRoomsFromUsr(@PathParam("username") String username){
        var rooms = usrService.getAllRoomsFromUsername(username);
        return (rooms != null ? Response.ok(rooms) : Response.status(Response.Status.BAD_REQUEST)).build();
    }
}
