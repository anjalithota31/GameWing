package com.ty.game_wing_springboot.dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Court {

	private int id;

	private String SportName;

	private String sportType;

	private double courtArea;

	private double duration;

	private double price;
	@OneToMany
	private List<Booking> bookings;

}
