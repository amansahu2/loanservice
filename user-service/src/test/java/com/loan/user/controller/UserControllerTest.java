package com.loan.user.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.loan.user.controller.UserController;
import com.loan.user.exception.UserNotFoundException;
import com.loan.user.model.User;
import com.loan.user.service.UserService;

@SpringBootTest
public class UserControllerTest {

	@InjectMocks
	UserController userController;
	
	@Mock
	User user;
	
	@Mock
	UserService userservice;

	@Test
	void testUserValidateTrue() throws UserNotFoundException {
		when(userservice.findUser("admin", "password")).thenReturn(true);
		assertEquals(userController.validateUser("admin", "password"),true);
	}
	
	@Test
	void testUserValidateFalse() throws UserNotFoundException {
		when(userservice.findUser("admin1", "admin1")).thenReturn(false);
		assertEquals(userController.validateUser("admin", "password"),false);

	}

}
