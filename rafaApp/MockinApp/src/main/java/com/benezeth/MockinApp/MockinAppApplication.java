package com.benezeth.MockinApp;

import com.benezeth.MockinApp.entity.UserEntity;
import com.benezeth.MockinApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MockinAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MockinAppApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserID(123);
		userEntity.setUserAddress("Ikuti");
		userEntity.setUserName("Mockin");
		userEntity.setUserJob("Student");
		userEntity.setUserPhoneNo("0622231");
		userRepository.save(userEntity);

	}
}
