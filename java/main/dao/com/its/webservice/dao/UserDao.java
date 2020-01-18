package com.its.webservice.dao;

import java.util.List;

import com.its.webservice.models.UserModel;

public interface UserDao {
	public List<UserModel> loadAllUser() throws Exception;

	public void updateUserByUserName(UserModel userModel) throws Exception;

	public void deleteUserByUserName(String userName) throws Exception;

	public void insertUser(UserModel userModel) throws Exception;
	
	public UserModel queryUserByUserName(String userName) throws Exception;
}
