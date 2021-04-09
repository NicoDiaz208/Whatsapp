import { Injectable } from '@angular/core';
import { Observable, Subject } from "rxjs";
import { map } from "rxjs/operators";
import { WebsocketService } from "./websocket.service";
import {Message} from "../app/message";

const CHAT_URL = "ws://localhost:50000/chat/nicodiaz208";

@Injectable({
  providedIn: 'root'
})
export class ChatService {
  public messages: Subject<Message>;

  constructor(wsService: WebsocketService) {
    console.log('Connect To WS-Server');

    this.messages = <Subject<Message>>wsService.connect(CHAT_URL).pipe(
      map((response: MessageEvent) => {
          let message = JSON.parse(response.data);
          return message;
      })
   );
  }
}
