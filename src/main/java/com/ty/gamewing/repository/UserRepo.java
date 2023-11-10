package com.ty.gamewing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.gamewing.dto.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
