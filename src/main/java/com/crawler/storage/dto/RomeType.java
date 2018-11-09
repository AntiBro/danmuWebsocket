package com.crawler.storage.dto;

import java.util.HashMap;
import java.util.Map;

public enum RomeType {
	MAN("0", "男"),
	WOMEN("1", "女"),
	Action("2","活动");

	private String typeNumber;
	private String typeName;

	static Map<String, RomeType> enumMap = new HashMap<String, RomeType>();
	static {
		for (RomeType type : RomeType.values()) {
			enumMap.put(type.getTypeNumber(), type);
		}
	}

	private RomeType(String typeNumber, String typeName) {
		this.typeName = typeName;
		this.typeNumber = typeNumber;
	}

	public String getTypeNumber() {
		return typeNumber;
	}

	public void setTypeNumber(String typeNumber) {
		this.typeNumber = typeNumber;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public static RomeType getEnum(String value) {
		return enumMap.get(value);
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getTypeName();
	}
	
	

}
