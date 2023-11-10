package com.ty.game_wing_springboot.dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Club {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	private Status status;
	@OneToMany
	private List<User> user;
	
	

}
enum Status
{
	ACTIVE,INACTIVE
}