import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {HttpService} from '../../services/http.service';
import {Room} from '../entities/room';

@Component({
  selector: 'app-group',
  templateUrl: './group.page.html',
  styleUrls: ['./group.page.scss'],
})
export class GroupPage implements OnInit {
  http : HttpService;
  newRoomid : String;
  rooms : Room[];

  constructor(http : HttpService) {
    this.http = http;
  }

  addRoom(id : String){
    let room : Room;
    room = new Room();
    room.roomId = id;
    this.http.addRoom(room).subscribe();
    this.rooms.push(room);
  }

  ngOnInit() {
    this.http.getAllRooms().subscribe(data => this.rooms = data);
  }

}
