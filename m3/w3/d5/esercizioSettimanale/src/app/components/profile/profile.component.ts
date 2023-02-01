import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth/auth.service';
import { Utente } from 'src/app/interfaces/utente.interface';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

    utenteLoggato : Utente = {
        email: '',
        nome: '',
        id: 0
    }

  constructor(private as: AuthService) { }

  ngOnInit(): void {
    this.getUtenteLoggato()
  }

  getUtenteLoggato(){
    this.as.authObs.subscribe((res)=>{
       if(res){this.utenteLoggato = res?.user}
    })
  }


}
