package com.example.spring.security.auth.runners;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.spring.dispositivo.Dispositivo;
import com.example.spring.dispositivo.DispositivoRepo;
import com.example.spring.dispositivo.Status;
import com.example.spring.dispositivo.TipoDispositivo;
import com.example.spring.security.auth.roles.ERole;
import com.example.spring.security.auth.roles.Role;
import com.example.spring.security.auth.roles.RoleRepository;
import com.example.spring.security.auth.users.User;
import com.example.spring.security.auth.users.UserRepository;

@Component
public class UserRunner implements ApplicationRunner {
	
	@Autowired RoleRepository roleRepository;
	@Autowired UserRepository userRepository;
	@Autowired PasswordEncoder encoder;
	@Autowired DispositivoRepo disporepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Role admin = new Role();
		admin.setRoleName(ERole.ADMIN);
//		roleRepository.save(admin);
		
		Role user = new Role();
		user.setRoleName(ERole.USER);
//		roleRepository.save(user);		
		
		Set<Role> adminRole = new HashSet<Role>();
		adminRole.add(admin);
		adminRole.add(user);
		
		Set<Role> userRole = new HashSet<Role>();
		userRole.add(user);
		
		Dispositivo dis1 = new Dispositivo(Status.DISPONIBILE, TipoDispositivo.LAPTOP);
//		disporepo.save(dis1);
		
		List<Dispositivo> lista = new ArrayList<Dispositivo>();
		lista.add(dis1);
		
		User userAdmin = new User();
		userAdmin.setNome("Admino");
		userAdmin.setCognome("Stretor");
		userAdmin.setUsername("admin");
		userAdmin.setEmail("admin@example.com");
		userAdmin.setPassword(encoder.encode("admin"));
		userAdmin.setRoles(adminRole);
		userAdmin.setDispositivi(lista);
//		userRepository.save(userAdmin);
		
		User simpleUser = new User();
		simpleUser.setNome("Mario");
		simpleUser.setCognome("Rossi");
		simpleUser.setUsername("mariorossi");
		simpleUser.setEmail("m.rossi@example.com");
		simpleUser.setPassword(encoder.encode("12345"));
		simpleUser.setRoles(userRole);
//		userRepository.save(simpleUser);
		
		
	}

}
