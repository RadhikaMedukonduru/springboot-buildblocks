package com.spring.restservices.entity;

import java.util.Date;

public class CustomErrorDetails {

	
	private Date date;
	private String message;
	private String errorInfo;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorInfo() {
		return errorInfo;
	}
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	@Override
	public String toString() {
		return "CustomErrorDetails [date=" + date + ", message=" + message + ", errorInfo=" + errorInfo + "]";
	}
	public CustomErrorDetails(Date date, String message, String errorInfo) {
		super();
		this.date = date;
		this.message = message;
		this.errorInfo = errorInfo;
	}
}
