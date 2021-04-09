import { Message } from '../message';
import { Component, OnInit } from '@angular/core';
import { Router } from  '@angular/router';
import { ChatService } from  '../../services/chat.service';
import { User } from  '../user';

@Component({
  selector: 'app-group-detail',
  templateUrl: './group-detail.page.html',
  styleUrls: ['./group-detail.page.scss'],
})
export class GroupDetailPage implements OnInit {
  messageList:  Message[] = [];
  chatMessage:  string  ="";
  private message : Message = {
    author: "Nico",
    message: "",
    date : null,
  };

    constructor(private chatService: ChatService) {

    }

  ngOnInit() {
    this.chatService.messages.subscribe(msg => {
      console.log("Response from websocket: " + JSON.stringify(msg));
      msg.date = new Date();
      this.messageList.push(msg);
    });
  }

  getTime(date : Date) : String{
    let result : String =  (date.getHours().toString() + ":" + date.getMinutes().toString());
    return result;
  }

  sendMessage(){
    console.log(this.messageList.map(x=> x.date))
    this.message.message = this.chatMessage;
    this.chatService.messages.next(this.message);
    this.chatMessage = "";
}

}
