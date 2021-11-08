package com.recipes.service;

import com.recipes.data.UserData;

public interface UserService {

	public boolean addUser(UserData user);
	public boolean validateUser(UserData user);
}
