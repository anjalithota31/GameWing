package com.ty.gamewing.dto;

import java.util.List;

import com.ty.gamewing.entity.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Club {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	private Status status;
	@OneToMany
	private List<User> user;
	
	@OneToMany(mappedBy = "club")
	private List<Court> court;
}
