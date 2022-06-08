package com.appsdeveloperblog.app.rest.controller;

import com.appsdeveloperblog.app.rest.dto.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 08/06/22
 */
@RestController @RequestMapping("/users") // http://localhost:2001/users
public class UserController {

	@GetMapping public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit, @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		return "get user was called with page = " + page + " with limit " + limit + " and sort " + sort;
	}

	@GetMapping(path = "/{userId}") public ResponseEntity<UserResponse> getUser(@PathVariable String userId) {

		UserResponse userResponse = UserResponse.builder()
				.firstName("Pulkit")
				.lastName("Aggarwal")
				.email("pulkitaggarwal@gmail.com")
				.build();

		return ResponseEntity.status(HttpStatus.OK).body(userResponse);
	}

	@PostMapping public String createUser() {
		return "create user was called";
	}

	@PutMapping public String updateUser() {
		return "update user was called";
	}

	@DeleteMapping public String deleteUser() {
		return "delete user was called";
	}
}
