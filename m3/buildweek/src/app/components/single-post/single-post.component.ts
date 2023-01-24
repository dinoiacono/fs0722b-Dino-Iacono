import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Post } from 'src/app/interfaces/post.interface';
import { PostService } from 'src/app/services/post.service';

@Component({
	selector: 'app-single-post',
	templateUrl: './single-post.component.html',
	styleUrls: ['./single-post.component.scss']
})
export class SinglePostComponent implements OnInit {

	constructor( private route: ActivatedRoute,private ps:PostService) {}

	post!: Post

	ngOnInit() {
		this.route.queryParams.subscribe(params => {
      if (params['id']) {
        this.ps.getPostbyID(params['id'] ).subscribe((res) => {
          this.post = res
        })
      } else {
        this.ps.getPostbyID(1).subscribe((res) => {
          this.post = res
        })
      }
			}
		);
	}

}

