import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Photo } from './photo.interface';
import { map } from 'rxjs/operators';



@Injectable({
  providedIn: 'root'
})
export class PhotoService {

  constructor(private http: HttpClient) { }


  getphoto(){
    return this.http.get<{data: Photo[]}>('https://jsonplaceholder.typicode.com/photos').pipe(map(ris => ris.data));
  }

}
