package com.social.chat;

import java.util.List;

import javax.persistence.*;

import com.social.auth.users.User;
import com.social.message.Message;

import lombok.*;


@Entity
@Table(name = "chats")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Chat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany
	private List<User> users; 
	
	@OneToMany(cascade = CascadeType.MERGE)
	private List<Message> messages;
}
