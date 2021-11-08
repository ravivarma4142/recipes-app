package com.recipes.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipes.data.UserData;
import com.recipes.repository.UserDataRepo;
import com.recipes.service.UserService;

@Service()
public class UserServiceImpl implements UserService{

	@Autowired
	UserDataRepo userRepo;
	@Override
	public boolean addUser(UserData user) {
		try {
			userRepo.save(user);
			}catch(Exception e) {
				return false;
			}
			return true;
	}

	@Override
	public boolean validateUser(UserData user) {
		  
		  List<UserData> users = userRepo.findAll().stream().filter(use ->
		  use.getUserName() != null) .filter(use ->
		  use.getUserName().equals(user.getUserName())) .filter(use ->
		  use.getPassword().equals(user.getPassword())) .collect(Collectors.toList());
		  if (users.size() > 0) return true;
		  
		  return false;
		 
	}

}
