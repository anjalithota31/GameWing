package com.ty.gamewing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.gamewing.dto.Court;

public interface CourtRepo extends JpaRepository<Court, Integer> {

}
