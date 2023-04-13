package com.social.post;

import java.util.List;

import javax.persistence.*;

import com.social.auth.users.User;
import com.social.comment.Comment;

import lombok.*;


@Entity
@Table(name = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private User author;
	
	private String title;
	
	private String content;
	
//	private List<Comment> comments; 
}
