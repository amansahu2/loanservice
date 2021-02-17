package com.loan.user.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.user.exception.UserNotFoundException;
import com.loan.user.model.User;
import com.loan.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public boolean findUser(String userName, String password) throws UserNotFoundException {
		try {
			User user = userRepository.findById(userName).get();
			if (user.getPassword().equals(password)) {
				return user.isAdmin();
			} else {
				throw new UserNotFoundException("Enter correct password");
			}
		} catch (NoSuchElementException e) {
			throw new UserNotFoundException("USER ID does not exist");
		}
	}
}
