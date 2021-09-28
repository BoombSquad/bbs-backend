package com.labengsoftware.engsoftware.model.type;

public enum SneakerStatus {

	NONE("0"), ENABLE("1"), SELLED("2"), DELETED("3");

	private String keyValue;
	
	SneakerStatus(String i) {
		
		this.keyValue = i;
	}
	
	public String keyValue() {
		return this.keyValue;
		
	}
	
}
