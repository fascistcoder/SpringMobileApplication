package com.appsdeveloperblog.app.service;

import com.appsdeveloperblog.app.rest.dto.UserRequest;
import com.appsdeveloperblog.app.rest.dto.UserResponse;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 08/06/22
 */
public interface UserService {
	UserResponse createUser(UserRequest userRequest);

	UserResponse getUser(String userId);

	void deleteUser(String id);
}

