package com.onlinefoodservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinefoodservice.dao.UserDetailDao;
import com.onlinefoodservice.model.Roles;
import com.onlinefoodservice.model.UserDetail;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailService{

	@Autowired
	UserDetailDao userDetailDao;
	
	@Override
	public void saveUserDetail(UserDetail userDetail) {
		Roles role = new Roles();
		
		if(userDetail.getAuthority().equals("USER")) {
			userDetail.setActive("1");
			role.setRole("ROLE_USER");
		}else {
			userDetail.setActive("0");
			role.setRole("ROLE_ADMIN");
		}
		
		role.setUserDetail(userDetail);
		userDetail.setRoles(role);
		
		userDetailDao.save(userDetail);
	}

	@Override
	public List<UserDetail> selectAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetail selectUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetail selectUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userDetailDao.findByUsername(username);
	}

	@Override
	public List<UserDetail> selectUserByRole(Roles Role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUserDetail(UserDetail userDetail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserDetail(UserDetail userDetail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUserActive(UserDetail userDetail) {
		// TODO Auto-generated method stub
		
	}

}
