package com.ty.gamewing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@SpringBootApplication
public class GameWingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameWingApplication.class, args);
		
	}

}
