import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/interfaces/post.interface';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-archivio',
  templateUrl: './archivio.component.html',
  styleUrls: ['./archivio.component.scss']
})
export class ArchivioComponent implements OnInit {

  constructor(private ps:PostService) { }

  posts: Post[] = []
  numeroPost: number = 12

  ngOnInit(): void {
    this.getPosts()
  }

  getPosts(){
    this.ps.getPost().subscribe((res) => {
      this.posts = res
    })
  }

  cambiaNumero(value:string){
    this.numeroPost = Number(value)
  }

}
