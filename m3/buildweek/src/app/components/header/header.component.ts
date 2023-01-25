import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PostService } from 'src/app/services/post.service';
import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor(public as:AuthService) { }

  ngOnInit(): void {
  }

  accedi(f:NgForm){
    if(f.value.username == 'admin' && f.value.password == 'admin'){
      this.as.isLogged = true
    }else{
      this.as.isLogged = false
    }
  }

  logout(){
    this.as.isLogged = false
  }

}
