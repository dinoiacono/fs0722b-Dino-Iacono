import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Post } from 'src/app/interfaces/post.interface';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.scss']
})
export class PostComponent implements OnInit {

  @Input() post: Post = {
    id: 0,
    title: '',
    body: '',
    userId: 0,
    tags: [],
    reactions: 0
  }

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  goToPage(postID:number) {
    this.router.navigate(['/post'], { queryParams: { id: postID } });
  }

}
