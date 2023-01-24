import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { ModificaPost, NuovoPost, Post } from '../interfaces/post.interface';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http:HttpClient) { }

  url:string = environment.url
  isLogged: boolean = false

  getPost(){
    return this.http.get<Post[]>(`${this.url}`)
  }

  getPostbyID(postID:number){
    return this.http.get<Post>(`${this.url}/${postID}`)
  }

  nuovoPost(articolo:NuovoPost){
    return this.http.post(`${this.url}`, articolo)
  }

  modificaPost(articolo:ModificaPost){
    return this.http.put(`${this.url}/${articolo.id}`, articolo)
  }

  eliminaPost(postID:number){
    return this.http.delete(`${this.url}/${postID}`)
  }

}
