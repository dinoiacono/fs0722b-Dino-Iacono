import { Component, OnInit } from '@angular/core';
import { FilmService } from '../../services/film.service';
import { Film } from '../../interfaces/film.interface';
import { UtenteService } from '../../services/utente.service';
import { Utente } from '../../interfaces/utente.interface';

@Component({
	selector: 'app-hero',
	templateUrl: './hero.component.html',
	styleUrls: ['./hero.component.scss']
})
export class HeroComponent implements OnInit {

	constructor(private fs: FilmService, private us:UtenteService) { }

	film: Film | undefined;
	utenti: Utente[] = [];

	ngOnInit(): void {
		// this.fs.getFilm().subscribe((data: Film) => this.film = { ...data });
        
		this.us.getUtenti().subscribe((data: any) => {
			this.utenti = data
		});

	}

}
