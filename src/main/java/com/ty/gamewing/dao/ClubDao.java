package com.ty.gamewing.dao;

import java.util.List;
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
	
	public String deleteClub(int id) {
		Optional<Club> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.deleteById(id);
			return "Deleted";
		} else {
			return "No such club is present to delete";
		}
	}


	public Club findById(int id) {
		Optional<Club> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public Club updateClubStatus(int id) {
		Optional<Club> optional = repo.findById(id);
		if (optional.isPresent()) {
			
			Club club = optional.get();
			
			return repo.save(club);
		}
		else
		{
			return null;
		}
	}
	
	public List<Club> displayAllClub()
	{
		return repo.findAll();
	}
	
	public Club findByStatus(String status)
	{
		Club club=repo.findByStatus(status);
		if(club!=null)
		{
			return club;
		}
		else
		{
			return null;
		}
	}
}
