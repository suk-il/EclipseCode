package com.bwf.onlineweb.enums;

public enum Gender {

	MAN("0","ç”?"),WOMAN("1","å¥?");
	
	private String key;
	private String value;
	public String getKey() {
		return key;
	}
	public String getValue() {
		return value;
	}
	
	private Gender(String key,String value) {
		this.key=key;
		this.value=value;
	}
	
	
} 