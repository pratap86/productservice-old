package com.pratap.springcloud.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CouponNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1370286004779672584L;

	public CouponNotFoundException(String message) {
		super(message);
	}

}
