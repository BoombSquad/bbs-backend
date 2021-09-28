package com.labengsoftware.engsoftware.model.type;

public enum UserStatus {

	NONE("0"), ENABLE("1"), BLOCKED("2"), DELETED("3");

	private String keyValue;
	
	UserStatus(String i) {
		
		this.keyValue = i;
	}
	
	public String keyValue() {
		return this.keyValue;
		
	}
	
}
