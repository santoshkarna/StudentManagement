package com.santosh.studentinfosystems.dao;

import java.util.List;

import com.santosh.studentinfosystems.dto.User;

public interface UserDao {

	public void saveUserInfo(User user);

	public void updateUserInfo(User user);

	public void deleteUserInfo(int id);

	public List<User> getAllUserInfo();

	public User getUserInfoById(int id);

	public String getImageUrl(int id);

	public int checkUser(String userName, String password);

	public User checkEmail(String email);
}
