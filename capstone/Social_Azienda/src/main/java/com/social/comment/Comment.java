package com.social.comment;

import javax.persistence.*;

import com.social.auth.users.User;

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
	
//	private User user;
	
	private String text;
	
}
