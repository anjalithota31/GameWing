package com.ty.gamewing.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.gamewing.dao.ClubDao;
import com.ty.gamewing.dao.CourtDao;
import com.ty.gamewing.dto.Club;
import com.ty.gamewing.dto.Court;
import com.ty.gamewing.entity.ResponseStructure;
import com.ty.gamewing.exception.NoSuchClubExistException;
import com.ty.gamewing.exception.NoSuchClubInTheCourtException;
import com.ty.gamewing.exception.NoSuchCourtFoundException;

@Service
public class CourtService {

	@Autowired
	private CourtDao courtDao;

	@Autowired
	private ClubDao clubDao;

	public ResponseEntity<ResponseStructure<Court>> saveCourt(int clubId, Court court) {
		Club club = clubDao.findById(clubId);
		if (club != null) {
			Court gotCourt = courtDao.saveCourt(court);
			List<Court> courts = club.getCourt();
			if (courts != null) {
				courts.add(gotCourt);
			} else {
				courts = new ArrayList<Court>();
				courts.add(gotCourt);
			}
			club.setCourt(courts);
			clubDao.saveClub(club);

			ResponseStructure<Court> responseStructure = new ResponseStructure<Court>();
			responseStructure.setData(gotCourt);
			responseStructure.setMessage("Success");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());

			return new ResponseEntity<ResponseStructure<Court>>(responseStructure, HttpStatus.CREATED);
		}
		throw new NoSuchClubExistException();

	}

	public ResponseEntity<ResponseStructure<Court>> findCourtById(int id) {
		Court gotCourt = courtDao.findCourtById(id);
		if (gotCourt != null) {
			ResponseStructure<Court> responseStructure = new ResponseStructure<Court>();
			responseStructure.setData(gotCourt);
			responseStructure.setMessage("Success");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Court>>(responseStructure, HttpStatus.FOUND);
		}
		throw new NoSuchCourtFoundException();
	}

	public ResponseEntity<ResponseStructure<String>> deleteCourt(int id) {
		boolean gotCourt = courtDao.deleteCourt(id);
		if (gotCourt == true) {
			ResponseStructure<String> responseStructure = new ResponseStructure<String>();
			responseStructure.setData("Court Removed Successfully!!");
			responseStructure.setMessage("Success");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoSuchCourtFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<List<Court>>> findAllCourts() {
		List<Court> courts = courtDao.findAllCourt();

		ResponseStructure<List<Court>> responseStructure = new ResponseStructure<List<Court>>();
		
		responseStructure.setData(courts);
		

		responseStructure.setMessage("Success");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Court>>>(responseStructure, HttpStatus.FOUND);

	}

	public ResponseEntity<ResponseStructure<List<Court>>> findCourtByClub(int id) {
		List<Court> courts = courtDao.findCourtByClub(id);
		if (courts != null) {
			ResponseStructure<List<Court>> responseStructure = new ResponseStructure<List<Court>>();
			responseStructure.setData(courts);
			responseStructure.setMessage("Success");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Court>>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new NoSuchClubInTheCourtException();
		}

	}

}
