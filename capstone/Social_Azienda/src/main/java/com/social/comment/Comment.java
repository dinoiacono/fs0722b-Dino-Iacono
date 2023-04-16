package com.social.comment;

import javax.persistence.*;

import com.social.auth.users.User;
import com.social.post.Post;

import lombok.*;


@Entity
@Table(name = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private User user;
	
	private String text;
	
	@ManyToOne
	private Post post;
	
}
