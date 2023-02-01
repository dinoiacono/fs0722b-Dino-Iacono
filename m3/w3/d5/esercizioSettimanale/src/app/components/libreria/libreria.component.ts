import { Component, OnInit, Output } from '@angular/core';
import { AuthService } from 'src/app/auth/auth.service';
import { FavoriteFilm, Film } from 'src/app/interfaces/film.interface';
import { FilmService } from 'src/app/services/film.service';

@Component({
	selector: 'app-libreria',
	templateUrl: './libreria.component.html',
	styleUrls: ['./libreria.component.scss']
})
export class LibreriaComponent implements OnInit {

	constructor(private as:AuthService, private fs:FilmService) { }

	film: Film[] = []
	likes: FavoriteFilm[] = []


	ngOnInit(): void {
		this.as.authObs.subscribe((res)=>{
			if(res) {
				this.fs.getFilm(res.accessToken).subscribe((res: any) => {
					this.film = res
				})
			} else {
				this.film = []
			}
		})
	}

}
