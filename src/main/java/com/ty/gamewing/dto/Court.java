package com.ty.gamewing.dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Court {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String SportName;

	private String sportType;

	private double courtArea;

	private double duration;

	private double price;
	@OneToMany
	private List<Booking> bookings;
	@ManyToOne
	@JoinColumn
	private Club club;

}
