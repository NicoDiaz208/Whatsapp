package websocket;

import Entities.Membership;
import model.MessageDTO;
import repositories.*;
import services.RoomService;
import services.RoomServiceImpl;

import java.lang.reflect.Member;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.Session;

@ServerEndpoint("/chat/{username}")
@ApplicationScoped
public class ChatSocket {

    Map<String, Session> sessions = new ConcurrentHashMap<>();

    @Inject
    RoomRepository roomRepository;

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {//, @PathParam("roomId") String roomId
        System.out.println(username+" joined!");
        sessions.put(username, session);
        String loginInfo = "{\"author\":\"Server\", \"message\":\"User "+username+" joined!\", \"date\":\"2021-03-20T12:54:21.933Z\"}";
        broadcast(loginInfo);
    }

    @OnClose
    public void onClose(Session session, @PathParam("username") String username) {
        sessions.remove(username);
        broadcast("{\"author\":\"Server\", \"message\":\"User "+username+" left!\", \"date\":\"2021-03-20T12:54:21.933Z\"}");
    }

    @OnError
    public void onError(Session session, @PathParam("username") String username, Throwable throwable) {
        sessions.remove(username);
        broadcast("User " + username + " left on error: " + throwable);
    }

    @OnMessage
    public void onMessage(String message, @PathParam("username") String username) {
        System.out.println(roomRepository.getById("Hello").getRoomId());
        System.out.println(username+": "+message);
        broadcast(message);
    }

    private void broadcast(String message) {
        sessions.values().forEach(s -> {
            s.getAsyncRemote().sendObject(message, result ->  {
                if (result.getException() != null) {
                    System.out.println("Unable to send message: " + result.getException());
                }
            });
        });
    }

}
