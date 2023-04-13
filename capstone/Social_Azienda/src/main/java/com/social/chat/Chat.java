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
	
	@OneToOne(mappedBy = "Chat")
	private User user1;
	
	@OneToOne(mappedBy = "Chat")
	private User user2;
	
	@OneToMany(mappedBy ="Chat", cascade = CascadeType.MERGE)
	private List<Message> messages;
}
