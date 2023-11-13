package com.ty.gamewing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.gamewing.dto.User;
import com.ty.gamewing.entity.ResponseStructure;
import com.ty.gamewing.entity.Role;
import com.ty.gamewing.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/saveadmin")
	public ResponseEntity<ResponseStructure<User>> saveAdmin(@RequestBody User user) {
		return userService.saveAdmin(user);
	}

	@PostMapping("/saveuser")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);
	}

	@GetMapping("/findallusers")
	public ResponseEntity<ResponseStructure<List<User>>> findAllUsers() {
		return userService.findAllUser();
	}

	@GetMapping("/finduserbyid/{id}")
	public ResponseEntity<ResponseStructure<User>> findUserById(@PathVariable int id) {
		return userService.findUserById(id);
	}

	@GetMapping("/findbyemail/{email}")
	public ResponseEntity<ResponseStructure<User>> findUserByMail(@PathVariable String email) {
		return userService.findUserByMail(email);
	}

	@GetMapping("/findby/{email}/{password}")
	public ResponseEntity<ResponseStructure<User>> findUserByMailAndPassword(@PathVariable String email,
			@PathVariable String password) {
		return userService.findUserByMailAndPassword(email, password);
	}

	@GetMapping("/findbyrole/{role}")
	public ResponseEntity<ResponseStructure<List<User>>> findUserByRole(@PathVariable Role role) {
		return userService.findUserByRole(role);
	}

}
