package com.oasis.apigestmenu.controllers.exception;

public class StandardError {
	
	private Long timesTamp;
	private Integer status;
	private String error;
	
	
	public StandardError() {
		super();
	
	}


	public StandardError(Long timesTamp, Integer status, String error) {
		super();
		this.timesTamp = timesTamp;
		this.status = status;
		this.error = error;
	}


	public Long getTimesTamp() {
		return timesTamp;
	}


	public void setTimesTamp(Long timesTamp) {
		this.timesTamp = timesTamp;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}
	
	
	
	

}
