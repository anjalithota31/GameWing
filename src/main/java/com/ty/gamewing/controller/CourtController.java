package com.ty.gamewing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.gamewing.dto.Court;
import com.ty.gamewing.entity.ResponseStructure;
import com.ty.gamewing.service.CourtService;

@RestController
public class CourtController {
	@Autowired
	private CourtService courtService;
	@PostMapping("/savecourt")
	public ResponseEntity<ResponseStructure<Court>> saveCourt(@RequestParam int courtid,@RequestBody Court court)
	{
		return courtService.saveCourt(courtid, court);
	}
	@GetMapping("/findcourtbyid")
	public ResponseEntity<ResponseStructure<Court>> findCourtById(@RequestParam int id)
	{
		return courtService.findCourtById(id);
	}
	@DeleteMapping("/deletecourt")
	public ResponseEntity<ResponseStructure<String>> deleteCourt(@RequestParam int id)
	{
		return courtService.deleteCourt(id);
	}
	@GetMapping("/dispalyallcourts")
	public ResponseEntity<ResponseStructure<List<Court>>> displayAll()
	{
		return courtService.findAllCourts();
	}
	@GetMapping("/findcourtbyclub")
	public ResponseEntity<ResponseStructure<List<Court>>> findCourtByClub(@RequestParam int id)
	{
		return courtService.findCourtByClub(id);
	}

}
