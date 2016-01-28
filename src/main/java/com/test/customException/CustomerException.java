package com.test.customException;

public class CustomerException extends Exception{

	public CustomerException(String string) throws Exception {
		throw new Exception(string);
	}

}
