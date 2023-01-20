import { Component, Input, OnInit } from '@angular/core';
import { FavoriteFilm, Film } from 'src/app/interfaces/film.interface';
import { FilmService } from 'src/app/services/film.service';
import { LibreriaComponent } from '../libreria/libreria.component';
import { AuthService } from 'src/app/auth/auth.service';
import { UtenteLoggato } from 'src/app/interfaces/utente.interface';

@Component({
	selector: 'app-film',
	templateUrl: './film.component.html',
	styleUrls: ['./film.component.scss']
})
export class FilmComponent implements OnInit {

	@Input() film!: Film

		liked: boolean = false
        user!: UtenteLoggato

	constructor(private fs:FilmService, private as:AuthService) { }

	ngOnInit(): void {
        this.as.authObs.subscribe((res)=>{
			if(res) {
                this.user = res
                this.checkLike(this.user.user.id)
			}
		})
	}

    likeToggle(id:number){
        if (!this.liked) {
            this.fs.postLike(id, this.user).subscribe(() =>{
                this.liked = true
            })
        }
    }

    checkLike(id:number){
        this.fs.getLike(id).subscribe((res) => {
            if (res) {
                res.forEach(element => {
                    if (element.movieId == this.film.id) {
                        this.liked = true
                    }
                });
            }
        })
    }

}
