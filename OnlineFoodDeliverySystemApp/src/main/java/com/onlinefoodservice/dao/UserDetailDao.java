package com.onlinefoodservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinefoodservice.model.Roles;
import com.onlinefoodservice.model.UserDetail;

@Repository
public interface UserDetailDao extends JpaRepository<UserDetail , Integer>{

	public UserDetail findByUsername(String username);
	
	public List<UserDetail> findByRoles(Roles role);
	
}
