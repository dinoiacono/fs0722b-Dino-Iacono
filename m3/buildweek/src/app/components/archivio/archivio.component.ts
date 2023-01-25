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
  
  select: number = 12
  posts: Post[] = []
  numeroPost: number = 12
  offset:number = 0

  ngOnInit(): void {
    this.getPosts()
  }

  getPosts(){
    this.ps.getPost().subscribe((res) => {
      this.posts = res
    })
  }

  cambiaNumero(value:string){
    this.select = Number(value)
    this.numeroPost = this.select
  }

  cambiaOffset(control:boolean){
    if(control) {
      this.offset += this.select
      this.numeroPost += this.select
    } else {
      this.offset -= this.select
      this.numeroPost -= this.select
    }
  }

}
