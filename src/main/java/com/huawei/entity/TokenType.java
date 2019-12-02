 package com.huawei.entity;

public enum TokenType {
	LeftToken(-1, "左符号"), RightToken(1, "右符号");
	TokenType(int relationType, String relationDesc) {
		this.relationDesc = relationDesc;
		this.relationType = relationType;
	}

	private int relationType;
	private String relationDesc;

	public int getRelationType() {
		return relationType;
	}

	public String getRelationDesc() {
		return relationDesc;
	}

}
