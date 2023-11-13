package com.ty.gamewing.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.gamewing.dto.User;
import com.ty.gamewing.entity.Role;
import com.ty.gamewing.exception.NoSuchUserFoundException;
import com.ty.gamewing.repository.UserRepo;

@Repository
public class UserDao {
	@Autowired
	private UserRepo repo;

	public User saveUser(User user) {
		return repo.save(user);
	}

	public boolean deleteUser(int id) {
		Optional<User> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public User findUserById(int id) {
		Optional<User> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public List<User> findAllUser() {
		return repo.findAll();
	}

	public List<User> findByRole(Role role) {
		return repo.findbyRole(role);
	}

	public User findByEmailAndPassword(String email, String password) {
		return repo.findByEmailAndPassword(email, password);

	}

	public User findUserByEmail(String email) {
		return repo.findByEmail(email);
	}

}
