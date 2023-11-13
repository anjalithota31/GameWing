package com.ty.gamewing.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.gamewing.dao.UserDao;
import com.ty.gamewing.dto.User;
import com.ty.gamewing.entity.ResponseStructure;
import com.ty.gamewing.entity.Role;
import com.ty.gamewing.entity.Status;
import com.ty.gamewing.exception.AdminAlreadyPresentException;
import com.ty.gamewing.exception.NoSuchUserFoundException;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<User>> saveAdmin(User user) {
		List<User> list = userDao.findAllUser();
		User user1 = null;
		if (list == null) {
			user1 = userDao.saveUser(user);
		} else {
			for (User user2 : list) {
				if (user2.getRole().equals(Role.ADMIN)) {
					throw new AdminAlreadyPresentException();
				}
			}
			user1 = userDao.saveUser(user);
		}
		ResponseStructure<User> structure = new ResponseStructure<User>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Success");
		structure.setData(user);

		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		if (user.getRole().equals(Role.ADMIN)) {
			throw new AdminAlreadyPresentException(); 
		}
		User user1 = userDao.saveUser(user);
		ResponseStructure<User> structure = new ResponseStructure<User>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Success");
		structure.setData(user);

		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> findUserById(int id) {
		User user = userDao.findUserById(id);
		if (user != null) {
			ResponseStructure<User> structure = new ResponseStructure<User>();
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("Success");
			structure.setData(user);

			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.FOUND);
		}
		throw new NoSuchUserFoundException();

	}

	public ResponseEntity<ResponseStructure<List<User>>> findAllUser() {
		List<User> users = userDao.findAllUser();
		if (users != null) {
			ResponseStructure<List<User>> structure = new ResponseStructure<List<User>>();
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("Success");
			structure.setData(users);

			return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.FOUND);

		} else {
			throw new NoSuchUserFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<String>> deleteUser(int id) {
		boolean condition = userDao.deleteUser(id);
		if (condition == true) {
			ResponseStructure<String> structure = new ResponseStructure<String>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData("User Deleted Successfully");

			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);

		}
		throw new NoSuchUserFoundException();

	}

	public ResponseEntity<ResponseStructure<List<User>>> findUserByRole(Role role) {
		List<User> users = userDao.findByRole(role);
		if (users != null) {
			ResponseStructure<List<User>> structure = new ResponseStructure<List<User>>();
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("Success");
			structure.setData(users);

			return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.FOUND);
		}
		throw new NoSuchUserFoundException();
	}

	public ResponseEntity<ResponseStructure<User>> findUserByMailAndPassword(String email, String password) {
		User user = userDao.findByEmailAndPassword(email, password);
		if (user != null) {
			ResponseStructure<User> structure = new ResponseStructure<User>();
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("Success");
			structure.setData(user);

			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.FOUND);
		}
		throw new NoSuchUserFoundException();

	}

	public ResponseEntity<ResponseStructure<User>> findUserByMail(String email) {
		User user = userDao.findUserByEmail(email);
		if (user != null) {
			ResponseStructure<User> structure = new ResponseStructure<User>();
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("Success");
			structure.setData(user);

			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.FOUND);
		}
		throw new NoSuchUserFoundException();

	}

}
