import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

  private username : String;
  private password : String;

  constructor(private router:Router) {}

  login(){
    console.log(this.username + '       ' + this.password);

    this.router.navigate(['/group']);
  }

  ngOnInit() {
  }

}
