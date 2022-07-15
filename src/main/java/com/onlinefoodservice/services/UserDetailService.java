package com.onlinefoodservice.services;

import java.util.List;

import com.onlinefoodservice.model.Roles;
import com.onlinefoodservice.model.UserDetail;

public interface UserDetailService {
	
	public void saveUserDetail(UserDetail userDetail);
	public List<UserDetail> selectAllUsers();
	public UserDetail selectUserById(int id);
	public UserDetail selectUserByUsername(String username);
	public List<UserDetail> selectUserByRole(Roles Role);
	public void updateUserDetail(UserDetail userDetail);
	public void deleteUserDetail(UserDetail userDetail);
	public void setUserActive(UserDetail userDetail);
	

}
