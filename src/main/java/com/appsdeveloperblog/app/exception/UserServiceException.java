package com.appsdeveloperblog.app.exception;

import java.io.Serial;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 08/06/22
 */
public class UserServiceException extends RuntimeException{

	@Serial private static final long serialVersionUID = 807011032431668725L;

	public UserServiceException(String message){
		super(message);
	}

}
