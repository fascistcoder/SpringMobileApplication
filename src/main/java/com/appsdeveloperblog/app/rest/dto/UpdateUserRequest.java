package com.appsdeveloperblog.app.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 08/06/22
 */
@Getter
@Setter
@Builder
public class UpdateUserRequest {

	@NotNull
	private String firstName;
	@NotNull
	private String lastName;

}
