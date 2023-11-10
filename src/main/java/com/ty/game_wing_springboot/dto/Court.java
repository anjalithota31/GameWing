package com.ty.game_wing_springboot.dto;

import jakarta.persistence.Entity;
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

}
