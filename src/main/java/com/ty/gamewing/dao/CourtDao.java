package com.ty.gamewing.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ty.gamewing.dto.Court;
import com.ty.gamewing.entity.ResponseStructure;
import com.ty.gamewing.exception.NoSuchClubExistException;
import com.ty.gamewing.exception.NoSuchClubInTheCourtException;
import com.ty.gamewing.exception.NoSuchCourtFoundException;

import com.ty.gamewing.repository.CourtRepo;
import com.ty.gamewing.repository.UserRepo;
import com.ty.gamewing.service.UserService;

@Repository
public class CourtDao {
	@Autowired
	private CourtRepo courtRepo;

	public Court saveCourt(Court court) {
		return courtRepo.save(court);

	}

	public Court findCourtById(int id) {
		Optional<Court> opt = courtRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new NoSuchCourtFoundException();
	}

	public boolean deleteCourt(int id) {
		if (findCourtById(id) != null) {
			courtRepo.deleteById(id);
			return true;
		}
		throw new NoSuchCourtFoundException();

	}

	public Court findCourtByClubId(int id) {
		Court court = findCourtByClubId(id);
		if (court != null) {
			return court;
		}
		throw new NoSuchClubInTheCourtException();
	}

	public List<Court> findAllCourt() {
		return courtRepo.findAll();
		 
	}

}
