package com.ucan.userMgmt.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucan.sharedLib.User;
import com.ucan.userMgmt.repository.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired(required = true)
	UserRepository userRepo;

	public List<User> getAllUsersService() {

		List<User> userList = new ArrayList<User>();
		System.out.println("in get user Db service");
		Iterator<User> userIterator = userRepo.findAll().iterator();
		while (userIterator.hasNext()) {
			userList.add(userIterator.next());
		}
		return userList;
	}

	public User getOneUserService(String email) {
		try {
			User u = userRepo.findByemail(email);
			System.out.println("in get one db user service");
			return u;
		} catch (Exception e) {
			return null;
		}

	}

	public List<User> createUserService(User u) {
		System.out.println("in post db user service");
		try {
			userRepo.save(u);
			return getAllUsersService();
		} catch (Exception e) {
			return null;
		}
	}

	public List<User> updateUserService(User newU, long id) {
		System.out.println("in put user db service");

		userRepo.save(newU);
		return getAllUsersService();
	}

	public List<User> deleteUserService(long id) {
		try {

			System.out.println("in delete user service");
			userRepo.delete(id);
			return getAllUsersService();
		} catch (Exception e) {
			return null;
		}
	}

	public User getOneUserbyIdService(long uid) {
		
		return userRepo.findOne(uid);
	}

}
