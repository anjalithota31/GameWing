package com.ty.gamewing.dto;

import java.util.List;

import com.ty.gamewing.entity.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "userinfo")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private long phone;
	@Column(unique = true)
	private String email;

	private String password;
	@OneToMany
	private List<Booking> bookings;
	
	private Role role;
	@OneToOne
	private Club club;
}
