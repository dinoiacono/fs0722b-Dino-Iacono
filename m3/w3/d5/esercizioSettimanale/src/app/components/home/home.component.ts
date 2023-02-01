import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth/auth.service';
import { Utente } from 'src/app/interfaces/utente.interface';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

logged = false;
utente: Utente = {email: '',nome: '',id: 0};

    constructor(private as:AuthService) { }

    ngOnInit(): void {
		this.as.authObs.subscribe((res)=>{
			if(res) {
				this.logged = true
				this.utente = res.user
			} else {
				this.logged = false,
				this.utente = {email: '',nome: '',id: 0}
			}
		})
	}

}
