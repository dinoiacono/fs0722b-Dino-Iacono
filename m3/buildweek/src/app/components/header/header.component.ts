import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor(public ps:PostService) { }

  ngOnInit(): void {
  }

  accedi(f:NgForm){
    if(f.value.username == 'admin' && f.value.password == 'admin'){
      this.ps.isLogged = true
    }else{
      this.ps.isLogged = false
    }
  }

  logout(){
    this.ps.isLogged = false
  }

}
