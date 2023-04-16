package com.social.auth.users;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.social.auth.roles.Role;
import com.social.chat.Chat;
import com.social.comment.Comment;
import com.social.message.Message;
import com.social.post.Post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),@UniqueConstraint(columnNames = "email") })
@Data
@NoArgsConstructor
@ToString
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;

	@Size(max = 50)
	private String nome;

	@Size(max = 50)
	private String cognome;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.MERGE, mappedBy= "users")
	private List<Chat> chats;
	
	@OneToMany(cascade = CascadeType.MERGE, mappedBy= "sender")
	private List<Message> sendedMessages;

	@OneToMany(cascade = CascadeType.MERGE, mappedBy= "addressee")
	private List<Message> receivedMessages;
	
	@OneToMany(cascade = CascadeType.MERGE, mappedBy= "user")
	private List<Post> posts;
	
	@OneToMany(cascade = CascadeType.MERGE)
	private List<Comment> comments;
	
	public User(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, @Size(max = 50) String nome, @Size(max = 50) String cognome) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
	}

}
