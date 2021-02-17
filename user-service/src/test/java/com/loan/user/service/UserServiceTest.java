package com.loan.user.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.loan.user.exception.UserNotFoundException;
import com.loan.user.model.User;
import com.loan.user.repository.UserRepository;
import com.loan.user.service.UserService;

@SpringBootTest
public class UserServiceTest {

	@InjectMocks
	UserService userService;
	
	@Mock
	UserRepository userRepository;
	@Mock
	User user;
	
	@Test
	void testCheckUserAdmin() throws UserNotFoundException {
		user = new User("admin", "password", true);
		Optional<User> user_1 = Optional.of(user);
		when(userRepository.findById("admin")).thenReturn(user_1);
		assertEquals(userService.findUser("admin", "password"), true);
	}
	
	@Test
	void testCheckUser() throws UserNotFoundException {
		user = new User("admin", "password", false);
		Optional<User> user_1 = Optional.of(user);
		when(userRepository.findById("admin")).thenReturn(user_1);
		assertEquals(userService.findUser("admin", "password"), false);
	}
	
	@Test
	void testCheckUserAdminFalse() throws UserNotFoundException {
		user = new User("admin", "password", true);
		Optional<User> user_1 = Optional.of(user);
		when(userRepository.findById("admin")).thenReturn(user_1);
		assertThrows(UserNotFoundException.class, () -> userService.findUser("ctsuser", "ctspassword"));
	}
	
	
}
