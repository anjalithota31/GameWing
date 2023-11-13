package com.ty.gamewing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.gamewing.dto.Club;

public interface ClubRepo extends JpaRepository<Club, Integer> {
	
	List<Club> findByStatus(String status);

}
