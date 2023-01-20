import { Component, OnInit } from '@angular/core';
import { AuthResponse, AuthService } from 'src/app/auth/auth.service';
import { Utente } from 'src/app/interfaces/utente.interface';

@Component({
	selector: 'app-navbar',
	templateUrl: './navbar.component.html',
	styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

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

    esci(){
        this.as.logout()
    }
}
