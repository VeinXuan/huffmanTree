package com.huawei.entity;

public class Person extends BaseEntity {

	private static final long serialVersionUID = -2639045434118005875L;

	private int age;

	private String chsDesc;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getChsDesc() {
		return chsDesc;
	}

	public void setChsDesc(String chsDesc) {
		this.chsDesc = chsDesc;
	}
}
