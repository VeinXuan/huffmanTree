package com.huawei.entity;

public class Student extends BaseEntity {

	private static final long serialVersionUID = 4361467614452218832L;

	private double score;

	private String educationLevel;

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	@Override
	public String toString() {
		return "Student [score=" + score + ", educationLevel=" + educationLevel + ", name=" + name + ", createDate="
				+ createDate + ", objectId=" + objectId + ", createdBy=" + createdBy + "]";
	}
}
