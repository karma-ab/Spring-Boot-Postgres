package com.project.demo.exception;

public class ErrorInfo {

	private int errorCode;
	private String errorMessage;
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return "ErrorInfo [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}
	public ErrorInfo(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	
}
