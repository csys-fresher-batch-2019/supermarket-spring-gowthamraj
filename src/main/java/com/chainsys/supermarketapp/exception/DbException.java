package com.chainsys.supermarketapp.exception;


@SuppressWarnings("serial")
public class DbException extends Exception {
	public DbException(String msg) {
		super(msg);
	}

	public DbException(String msg, Exception e) {
		super(msg,e);
	}

}

