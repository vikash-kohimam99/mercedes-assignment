package com.mercedes.fuleeventdriver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mercedes.fuleeventdriver.model.Role;
import com.mercedes.fuleeventdriver.model.User;
import com.mercedes.fuleeventdriver.service.RoleService;
import com.mercedes.fuleeventdriver.service.UserService;

@SpringBootApplication
public class MsMercedesFuleeventdriverserviceApplication implements CommandLineRunner{

	@Autowired
	RoleService roleService;
	
	@Autowired
	UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(MsMercedesFuleeventdriverserviceApplication.class, args);
	}
	
	@Bean
	public MappingJackson2MessageConverter jackson2Converter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		return converter;
	}

	@Override
	public void run(String... args) throws Exception {
		Role role = new Role();
		role.setName("admin");
		roleService.saveOrUpdate(role);		
		User user = new User();
		user.setEmail("test@test.com");
		user.setName("vikash");
		user.setMobile("8015492244");
		user.setRole(roleService.findById(1L).get());
		user.setPassword(new BCryptPasswordEncoder().encode("test"));
		userService.saveOrUpdate(user);

		
	}

}
