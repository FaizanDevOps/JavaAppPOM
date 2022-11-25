package org.qritrim.qivrtrack.exceptions;

import lombok.Data;

@Data
public class QivrException extends RuntimeException {

	private int code;
	private String message;
	public int getCode() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
