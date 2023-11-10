package com.ty.game_wing_springboot.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private long phone;
	@Column(unique = true)
	private String email;
	
	private String password;
	
	private Role role;
	@OneToOne
	private Club club;
}

enum Role{
	ADMIN,OWNER,MANAGER,CUSTOMER
}