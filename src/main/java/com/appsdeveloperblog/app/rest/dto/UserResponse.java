package com.appsdeveloperblog.app.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 08/06/22
 */
@Getter
@Setter
@Builder
public class UserResponse {
	private String firstName;
	private String lastName;
	private String email;
	private String userId;
}
