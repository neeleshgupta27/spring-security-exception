package com.neel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.neel.entity.Authorities;
import com.neel.entity.User;
import com.neel.repository.AuthoritiesRepository;
import com.neel.repository.UserRepository;

@SpringBootApplication
@EnableAutoConfiguration 
@ComponentScan(basePackages = {"com.neel"})
public class Application extends SpringBootServletInitializer implements ApplicationRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthoritiesRepository authoritiesRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	  public void run(ApplicationArguments args) {
		
		List<User> users = userRepository.findAll();
		if(!(users!=null && users.size()>0)){
			
			User user = new User();
			user.setUsername("admin");
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode("admin");
			user.setPassword(encodedPassword);
			userRepository.save(user);
			
			Authorities a1 = new Authorities();
			a1.setId(1l);
			a1.setAuthority("ROLE_USER");
			a1.setUser(user);
			authoritiesRepository.save(a1);
			
			Authorities a2 = new Authorities();
			a2.setId(2l);
			a2.setAuthority("ROLE_ADMIN");
			a2.setUser(user);
			authoritiesRepository.save(a2);
			
		}
		
	    
	  }
}
