package com.appsdeveloperblog.app.rest.controller;

import com.appsdeveloperblog.app.rest.dto.UpdateUserRequest;
import com.appsdeveloperblog.app.rest.dto.UserRequest;
import com.appsdeveloperblog.app.rest.dto.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 08/06/22
 */
@RestController @RequestMapping("/users") // http://localhost:2001/users
public class UserController {

	Map<String, UserResponse> users;

	@GetMapping public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit, @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		return "get user was called with page = " + page + " with limit " + limit + " and sort " + sort;
	}

	@GetMapping(path = "/{userId}") public ResponseEntity<UserResponse> getUser(@PathVariable String userId) {

		if(users.containsKey(userId)){
			return ResponseEntity.status(HttpStatus.OK).body(users.get(userId));

		}else{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}

	}

	@PostMapping public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) {

		String userId = UUID.randomUUID().toString();

		UserResponse userResponse = UserResponse.builder()
				.firstName(userRequest.getFirstName())
				.lastName(userRequest.getLastName())
				.email(userRequest.getEmail())
				.userId(userId)
				.build();

		if(users==null) {
			users = new HashMap<>();
		}

		users.put(userId, userResponse);

		return ResponseEntity.status(HttpStatus.OK).body(userResponse);
	}

	@PutMapping(path = "/{userId}") public UserResponse updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserRequest updateUserRequest) {

		UserResponse userResponse = users.get(userId);
		userResponse.setFirstName(updateUserRequest.getFirstName());
		userResponse.setLastName(updateUserRequest.getLastName());

		users.put(userId, userResponse);

		return userResponse;
	}

	@DeleteMapping(path="/{id}") public ResponseEntity deleteUser(@PathVariable String id) {
		users.remove(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
