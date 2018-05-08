package com.eee.mybatis.impl;
import java.util.List;
import com.eee.mybatis.dao.UserDao;
import com.eee.mybatis.entity.User;
import com.eee.mybatis.service.UserService;

public class UserServiceImpl implements UserService {
	
	UserDao userDao=new UserDao();

	public void add(String id,String username,String password) {
		userDao.add(id,username,password);
	}

	public void delete(String id) {
		userDao.delete(id);
	}

	public int update(String username,
			String password,String id){
		return userDao.update(username,password,id);
	}

	public User getUser(String id) {
		return userDao.getUser(id);
	}
	
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	public List<User> getUsersByPage(int offset, int pageSize) {
		return userDao.getUsers(offset, pageSize);
	}

}
