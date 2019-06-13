package com.neo.enums;

public enum UserSexEnum {
	MAN(0),
	WOMAN(1);

	private int value;
	private UserSexEnum(int value){
		this.value=value;
	}
}
