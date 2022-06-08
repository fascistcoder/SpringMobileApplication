package com.appsdeveloperblog.app.rest.controller;

import com.appsdeveloperblog.app.exception.UserServiceException;
import com.appsdeveloperblog.app.rest.dto.UpdateUserRequest;
import com.appsdeveloperblog.app.rest.dto.UserRequest;
import com.appsdeveloperblog.app.rest.dto.UserResponse;
import com.appsdeveloperblog.app.service.UserService;
import lombok.AllArgsConstructor;
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
import java.util.Objects;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 08/06/22
 */

@AllArgsConstructor
@RestController @RequestMapping("/users") // http://localhost:2001/users
public class UserController {

	private final UserService userService;

	@GetMapping public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit, @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		return "get user was called with page = " + page + " with limit " + limit + " and sort " + sort;
	}

	@GetMapping(path = "/{userId}") public ResponseEntity<UserResponse> getUser(@PathVariable String userId) {

		if (Objects.equals(userId, "1622i0o")) {
			throw new UserServiceException("A user service exception is thrown");
		}

		UserResponse userResponse = userService.getUser(userId);

		if (userResponse != null) {
			return ResponseEntity.status(HttpStatus.OK).body(userResponse);

		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}

	}

	@PostMapping public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) {

		UserResponse userResponse = userService.createUser(userRequest);

		return ResponseEntity.status(HttpStatus.OK).body(userResponse);
	}

	@PutMapping(path = "/{userId}") public UserResponse updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserRequest updateUserRequest) {

		return userService.updateUser(userId, updateUserRequest);
	}

	@DeleteMapping(path = "/{id}") public ResponseEntity deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
