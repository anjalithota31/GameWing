package com.ty.gamewing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.gamewing.dto.Club;
import com.ty.gamewing.entity.ResponseStructure;
import com.ty.gamewing.service.ClubService;

@RestController
public class ClubController {

	@Autowired
	private ClubService clubService;

	@PostMapping("/saveclub")
	public ResponseEntity<ResponseStructure<Club>> saveClub(@RequestBody Club club) {
		return clubService.saveClub(club);
	}

	@DeleteMapping("/deleteclub")
	public ResponseEntity<ResponseStructure<String>> deleteClub(@RequestParam int id) {
		return clubService.deleteClub(id);
	}

	@GetMapping("/findclub")
	public ResponseEntity<ResponseStructure<Club>> findClubById(@RequestParam int id) {
		return clubService.findById(id);
	}

	@PutMapping("/updateclub/{id}")
	public ResponseEntity<ResponseStructure<Club>> updateClub(@PathVariable int id) {
		return clubService.updateClub(id);
	}

	@GetMapping("/displayclub")
	public ResponseEntity<ResponseStructure<List<Club>>> displayAll() {
		return clubService.displayAllClub();
	}

	@GetMapping("/clubbystatus")
	public ResponseEntity<ResponseStructure<List<Club>>> findClubByStatus(@RequestParam String status) {
		return clubService.findByStatus(status);
	}

}
