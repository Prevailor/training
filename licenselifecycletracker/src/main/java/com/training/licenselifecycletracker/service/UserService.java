package com.training.licenselifecycletracker.service;

import com.training.licenselifecycletracker.entities.User;

public interface UserService {
	
	//Create
		public User addUser(User User);
		//Retrieve
		public User getUserById(Integer UserId) ;
		
		//Delete
		public String deleteUserById(Integer UserId);
		
		//Update
		public User updateUser(User User); 

}
