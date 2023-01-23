import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/interfaces/post.interface';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {

  constructor(private ps:PostService) { }

  posts: Post[] = []

  ngOnInit(): void {
    this.getPosts()
  }

  getPosts(){
    this.ps.getPost().subscribe((res)=>{
      this.posts = res
    })
  }

  elimina(postID:number){
    this.ps.eliminaPost(postID).subscribe((res) => {
      console.log(res)
      this.posts = this.posts.filter(p=>p.id!=postID)
    })
  }

}
