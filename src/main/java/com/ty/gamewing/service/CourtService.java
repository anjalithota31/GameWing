package com.ty.gamewing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.gamewing.dao.CourtDao;
import com.ty.gamewing.dto.Court;
import com.ty.gamewing.entity.ResponseStructure;
import com.ty.gamewing.exception.NoSuchClubInTheCourtException;
import com.ty.gamewing.exception.NoSuchCourtFoundException;

@Service
public class CourtService {
	
	@Autowired
	CourtDao courtDao;
	
	public ResponseEntity<ResponseStructure<Court>> saveCourt(Court court){
	Court gotCourt=courtDao.saveCourt(court);
		ResponseStructure<Court> responseStructure=new ResponseStructure<Court>();
		responseStructure.setData(gotCourt);
		responseStructure.setMessage("Success");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		
		return new ResponseEntity<ResponseStructure<Court>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Court>> findCourtById(int id){
		Court gotCourt=courtDao.findCourtById(id);
		if(gotCourt!=null) {
			ResponseStructure<Court> responseStructure=new ResponseStructure<Court>();
			responseStructure.setData(gotCourt);
			responseStructure.setMessage("Success");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Court>>(responseStructure,HttpStatus.FOUND);
		}
		throw new NoSuchCourtFoundException();
	}
	public ResponseEntity<ResponseStructure<String>> deleteCourt(int id){
		boolean gotCourt=courtDao.deleteCourt(id);
		if(gotCourt==true) {
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setData("Court Removed Successfully!!");
		responseStructure.setMessage("Success");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new NoSuchCourtFoundException();
		}
		
	}
	public ResponseEntity<ResponseStructure<Court>> findAllCourts()
	{
		List<Court> courts=courtDao.findAllCourt();
		
		ResponseStructure<Court> responseStructure=new ResponseStructure<Court>();
		for(Court court:courts) {
			responseStructure.setData(court);
		}
		
		responseStructure.setMessage("Success");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<Court>>(responseStructure,HttpStatus.FOUND);
		
		
	}
	public ResponseEntity<ResponseStructure<Court>> findCourtByClub(int id){
		Court court=courtDao.findCourtByClub(id);
		if(court!=null) {
		ResponseStructure<Court> responseStructure=new ResponseStructure<Court>();
		responseStructure.setData(court);
		responseStructure.setMessage("Success");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<Court>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new NoSuchClubInTheCourtException();
		}
		
	}
	

}
