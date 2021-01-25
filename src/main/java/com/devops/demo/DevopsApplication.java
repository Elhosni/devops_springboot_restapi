package com.devops.demo;

import org.springframework.boot.CommandLineRunner;
import com.devops.demo.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

import com.devops.demo.model.User;

@SpringBootApplication
public class DevopsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DevopsApplication.class, args);
	}
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		this.userRepository.save(new User("mootez","elhosni","elhosnimtz@gmail.com"));
	}

}
