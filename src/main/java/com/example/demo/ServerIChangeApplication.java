package com.example.demo;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.RoleEnum;

@SpringBootApplication
public class ServerIChangeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(ServerIChangeApplication.class, args);
 
		
		/*RoleRepository roleRepository =ctx.getBean(RoleRepository.class);
		Role roleUser = new Role(RoleEnum.ROLE_USER);
		Role roleAdmin = new Role(RoleEnum.ROLE_ADMIN);
		
		roleRepository.save(roleUser);
		roleRepository.save(roleAdmin);
		
		UserRepository userRepository = ctx.getBean(UserRepository.class);
		byte[] n2 = {};
		User user = new User("user@gmail.com","Ali","Bayoudh","pwd1","Web Developper","Teboubla",n2, true);
		user.setRoles(Arrays.asList(roleUser));
		
		userRepository.save(user);
		
		User admin = new User("admin@gmail.com", "admin","admin","pwd2","Web Developper","Teboulba",n2, true);
		admin.setRoles(Arrays.asList(roleUser, roleAdmin));
		
		userRepository.save(admin);
		
		User rd = new User("user2@gmail.com", "slah","zayani","pwd3","Etudiant","kalaa kbira",n2, true);
		rd.setRoles(Arrays.asList(roleUser));
		
		userRepository.save(rd);*/
	}

}
