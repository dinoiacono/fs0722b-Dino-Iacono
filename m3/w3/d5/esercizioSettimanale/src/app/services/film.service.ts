import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FavoriteFilm, Film } from '../interfaces/film.interface';
import { environment } from 'src/environments/environment';
import { UtenteLoggato } from '../interfaces/utente.interface';
import { Observable, isObservable, map, observable, tap } from 'rxjs';
import { UtenteService } from './utente.service';


@Injectable({
	providedIn: 'root'
})
export class FilmService {

	constructor(private http: HttpClient) { }

    url = environment.url
    imgUrl = environment.imgUrl
    storage = localStorage.getItem("auth")
    head = {}

    authApi(token:string){
        return new HttpHeaders({ 'Authorization': `Bearer ${token}` });
    }

    getFilm(token:string) {
		return this.http.get<Film>(this.url + "movies-popular", { headers: this.authApi(token) })
	}

    postLike(id:number, user:UtenteLoggato){
        let data: FavoriteFilm = { userId: user.user.id, movieId: id}
        return this.http.post<FavoriteFilm>(`${this.url}favorites`,data)
    }

    removeLike( filmID:number, userID:number ){
        let likeID:any

        this.getLike(userID).pipe((res) => {
            res.subscribe((res) => {
                likeID = res.find(x => x.movieId == filmID)?.id
            })
            console.log(likeID)
            return this.http.delete<FavoriteFilm>(`${this.url}favorites/${likeID}`)

        })
    }

    getLike(userID:number){
        return this.http.get<FavoriteFilm[]>(`${this.url}favorites?userId=${userID}`)
    }
}
