package com.example.spring.security.auth.runners;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.spring.device.Device;
import com.example.spring.device.DeviceRepo;
import com.example.spring.device.DeviceStatus;
import com.example.spring.device.DeviceType;
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
	@Autowired DeviceRepo devRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Role admin = new Role();
		admin.setRoleName(ERole.ROLE_ADMIN);
		roleRepository.save(admin);
		
		Role user = new Role();
		user.setRoleName(ERole.ROLE_USER);
		roleRepository.save(user);
		
		Set<Role> adminRole = new HashSet<Role>();
		adminRole.add(admin);
		adminRole.add(user);
		
		Set<Role> moderatorRole = new HashSet<Role>();
		moderatorRole.add(user);
		
		Set<Role> userRole = new HashSet<Role>();
		userRole.add(user);
		
		User userAdmin = new User();
		userAdmin.setNome("Admino");
		userAdmin.setCognome("Stretor");
		userAdmin.setUsername("admin");
		userAdmin.setEmail("admin@example.com");
		userAdmin.setPassword(encoder.encode("admin"));
		userAdmin.setRoles(adminRole);
		userRepository.save(userAdmin);
		
		User simpleUser = new User();
		simpleUser.setNome("Mario");
		simpleUser.setCognome("Rossi");
		simpleUser.setUsername("mariorossi");
		simpleUser.setEmail("m.rossi@example.com");
		simpleUser.setPassword(encoder.encode("12345"));
		simpleUser.setRoles(userRole);
		userRepository.save(simpleUser);
		
		Device dev1 = new Device(DeviceStatus.DISPONIBILE, DeviceType.LAPTOP);
		devRepo.save(dev1);
		
		Device dev2 = new Device(DeviceStatus.DISPONIBILE, DeviceType.SMARTPHONE);
		devRepo.save(dev1);
		
		Device dev3 = new Device(DeviceStatus.MANUTENZIONE, DeviceType.TABLET);
		devRepo.save(dev1);
		
	}

}
