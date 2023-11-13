package com.ty.gamewing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ty.gamewing.dao.ClubDao;
import com.ty.gamewing.dto.Club;
import com.ty.gamewing.entity.ResponseStructure;
import com.ty.gamewing.entity.Status;
import com.ty.gamewing.exception.NoClubPresentException;
import com.ty.gamewing.exception.NoSuchClubExistException;

public class ClubService {
	@Autowired
	private ClubDao dao;

	public ResponseEntity<ResponseStructure<Club>> saveClub(Club club) {
		Club club2 = dao.saveClub(club);
		ResponseStructure<Club> structure = new ResponseStructure<Club>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Success");
		structure.setData(club2);

		return new ResponseEntity<ResponseStructure<Club>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<String>> deleteClub(int id) {
		Club club = dao.findById(id);
		if (club != null) {
			String club1 = dao.deleteClub(id);
			ResponseStructure<String> structure = new ResponseStructure<String>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(club1);
			structure.setMessage("Success");

			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		} else {
			throw new NoSuchClubExistException();
		}

	}

	public ResponseEntity<ResponseStructure<Club>> findById(int id) {
		Club club = dao.findById(id);
		if (club != null) {
			ResponseStructure<Club> structure = new ResponseStructure<Club>();
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(club);
			structure.setMessage("Success");

			return new ResponseEntity<ResponseStructure<Club>>(structure, HttpStatus.FOUND);
		} else {
			throw new NoSuchClubExistException();
		}
	}

	public ResponseEntity<ResponseStructure<Club>> updateClub(int id) {
		Club club = dao.findById(id);
		if (club != null) {

			Status status = club.getStatus();
			if (status.equals(Status.ACTIVE)) {
				club.setStatus(Status.INACTIVE);
			} else {
				club.setStatus(Status.ACTIVE);
			}
			Club club1 = dao.saveClub(club);

			ResponseStructure<Club> structure = new ResponseStructure<Club>();
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setData(club1);
			structure.setMessage("Success");

			return new ResponseEntity<ResponseStructure<Club>>(structure, HttpStatus.CREATED);

		} else {
			throw new NoSuchClubExistException();
		}

	}

	public ResponseEntity<ResponseStructure<List<Club>>> displayAllClub() {
		List<Club> clubs = dao.displayAllClub();
		if (clubs != null) {
			ResponseStructure<List<Club>> structure = new ResponseStructure<List<Club>>();
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(clubs);
			structure.setMessage("Success");

			return new ResponseEntity<ResponseStructure<List<Club>>>(structure, HttpStatus.FOUND);
		} else {
			throw new NoClubPresentException();
		}
	}

	public ResponseEntity<ResponseStructure<List<Club>>> findByStatus(String status) {
		List<Club> club = dao.findByStatus(status);
		if (club != null) {
			ResponseStructure<List<Club>> structure = new ResponseStructure<List<Club>>();
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(club);
			structure.setMessage("Success");

			return new ResponseEntity<ResponseStructure<List<Club>>>(structure, HttpStatus.FOUND);
		} else {
			throw new NoSuchClubExistException();
		}
	}
}
