package com.ty.gamewing.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.gamewing.dto.Club;
import com.ty.gamewing.exception.NoSuchClubExistException;
import com.ty.gamewing.repository.ClubRepo;

@Repository
public class ClubDao {
	@Autowired
	private ClubRepo repo;

	public Club saveClub(Club club) {
		return repo.save(club);
	}

	public Club updateClub(Club club) {
		return repo.save(club);
	}

	public boolean deleteClub(int id) {
		Optional<Club> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.deleteById(id);
			return true;
		} else {
			throw new NoSuchClubExistException();
		}
	}

//	public Club findById(int id) {
//
//	}
	}
