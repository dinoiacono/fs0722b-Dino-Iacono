import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { FetchedPost, Post } from '../interfaces/post.interface';
import { map } from 'rxjs/operators';



@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http:HttpClient) { }

  url:string = environment.url

  getPost(){
    return this.http.get<FetchedPost>(`${this.url}`).pipe(map((res) => {
      return res.posts
    }))
  }

  getPostbyID(postID:number){
    return this.http.get<Post>(`${this.url}/${postID}`)
  }

  nuovoPost(){

  }

  modificaPost(){

  }

  eliminaPost(postID:number){
    return this.http.delete(`${this.url}/${postID}`)
  }

}
