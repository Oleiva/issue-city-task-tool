package edu.com.softserveinc.main.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.com.softserveinc.main.dao.UserDao;
import edu.com.softserveinc.main.models.UserModel;
import edu.com.softserveinc.main.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
    private UserDao userDao;
	
	@Override
	public void addUser(UserModel user) {
		// Encode password in SHA-512
		if (user.getPassword().length() < 61)
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		
		userDao.saveAndFlush(user);
	}

	@Override
	public void deleteUser(UserModel user) {

		if (user.getId() != 0) {
			userDao.delete(user);
		}
	}
	
	@Override
	public void deleteUser(int id) {

		if (id != 0) {
			userDao.delete(id);
		}
	}

	@Override
	public void editUser(UserModel user) {
		// Encode password in SHA-512
		if (user.getPassword().length() < 61)
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		
		if (user.getId() != 0) {
			userDao.saveAndFlush(user);
		}
	}

	@Override
	public UserModel getUserByID(int id) {
		return userDao.findOne(id);
	}
	
	@Override
	public List<UserModel> loadUsersList() {
		return userDao.findAll();
	}
	
	@Override
	public UserModel getUserByName(String name) throws Exception {
		UserModel user = userDao.findByName(name);
		if(user == null) throw new Exception("User not found");
		return user;
	}
	
	@Override
	public UserModel getUserByLogin(String login) throws Exception  {
		UserModel user = userDao.findByName(login);
		if(user == null) throw new Exception("User not found");
		return user;
	}
}
