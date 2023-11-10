package com.ty.gamewing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.gamewing.dto.Court;

public interface CourtRepo extends JpaRepository<Court, Integer> {
	
	@Query("select c.courts from Club c where c.id=?1")
	Court findCourtByClubId(int id);

}
