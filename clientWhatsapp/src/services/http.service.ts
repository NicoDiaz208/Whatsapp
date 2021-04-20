import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Room} from '../app/entities/room';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  http : HttpClient

  constructor(http : HttpClient) {
    this.http = http;
   }

   headers = new HttpHeaders().set("Content-Type", "application/json");

   addRoom(room : Room){
     var json = JSON.stringify(room);
     return this.http.post("http://localhost:50000/api/Room", json, {headers: this.headers});
   }

   getAllRooms(){
     return this.http.get<Room[]>('http://localhost:50000/api/Room/all');
   }
}
