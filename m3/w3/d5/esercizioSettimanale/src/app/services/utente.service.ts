import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Utente } from '../interfaces/utente.interface';
import { environment } from 'src/environments/environment';

@Injectable({
	providedIn: 'root'
})
export class UtenteService {

	constructor(private http: HttpClient) { }

	url = environment.url + "users"


    getUtenti() {
        return this.http.get<Utente>(this.url)
    }
}
