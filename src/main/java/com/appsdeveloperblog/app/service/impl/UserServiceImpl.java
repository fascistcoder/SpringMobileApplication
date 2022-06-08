package com.appsdeveloperblog.app.service.impl;

import com.appsdeveloperblog.app.rest.dto.UpdateUserRequest;
import com.appsdeveloperblog.app.rest.dto.UserRequest;
import com.appsdeveloperblog.app.rest.dto.UserResponse;
import com.appsdeveloperblog.app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 08/06/22
 */

@Service
public class UserServiceImpl implements UserService {

	Map<String, UserResponse> users;

	@Override public UserResponse createUser(UserRequest userRequest) {
		String userId = UUID.randomUUID().toString();

		UserResponse userResponse = UserResponse.builder()
				.firstName(userRequest.getFirstName())
				.lastName(userRequest.getLastName())
				.email(userRequest.getEmail())
				.userId(userId)
				.build();

		if (users == null) {
			users = new HashMap<>();
		}

		users.put(userId, userResponse);

		return userResponse;
	}

	@Override public UserResponse getUser(String userId) {

		return users.getOrDefault(userId, null);
	}

	@Override public UserResponse updateUser(String userId, UpdateUserRequest updateUserRequest) {

		UserResponse userResponse = users.get(userId);
		userResponse.setFirstName(updateUserRequest.getFirstName());
		userResponse.setLastName(updateUserRequest.getLastName());

		users.put(userId, userResponse);

		return userResponse;
	}

	@Override public void deleteUser(String id) {
		users.remove(id);
	}
}
