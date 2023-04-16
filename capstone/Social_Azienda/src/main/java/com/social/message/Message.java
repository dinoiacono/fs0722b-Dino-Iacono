package com.social.message;

import javax.persistence.*;

import com.social.auth.users.User;
import com.social.chat.Chat;

import lombok.*;


@Entity
@Table(name = "messages")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String object;
	
	private String text;
	
	@ManyToOne
	private User sender;
	
	@ManyToOne
	private User addressee;
	
	@ManyToOne
	private Chat chat;
}
