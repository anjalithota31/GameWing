package com.ty.gamewing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.gamewing.dto.User;
import com.ty.gamewing.entity.Role;

public interface UserRepo extends JpaRepository<User, Integer> {

	public List<User> findbyRole(Role role);
	
	public User findByEmailAndPassword(String email,String password);
}
