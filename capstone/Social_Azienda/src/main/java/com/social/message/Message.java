package com.social.message;

import javax.persistence.*;

import com.social.auth.users.User;

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
	
	@OneToOne(mappedBy = "Message")
	private User sender;
	
	@OneToOne(mappedBy = "Message")
	private User receiver;
	
	private String object;
	
	private String text;
}
