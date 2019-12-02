 package com.huawei.entity;

public class Token {
	private String name;
	private String desc;
	private TokenType tokenType;

	public String getName() {
		return name;
	}

	public Token setName(String name) {
		this.name = name;
		return this;
	}

	public String getDesc() {
		return desc;
	}

	public Token setDesc(String desc) {
		this.desc = desc;
		return this;
	}

	public TokenType getTokenType() {
		return tokenType;
	}

	public Token setTokenType(TokenType tokenType) {
		this.tokenType = tokenType;
		return this;
	}
}
