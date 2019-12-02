package com.huawei.entity;

public class Teacher extends Person {
	private static final long serialVersionUID = 5012295531764258654L;

	// 绩效考核
	private double keyPerformanceIndex;

	public double getKeyPerformanceIndex() {
		return keyPerformanceIndex;
	}

	public void setKeyPerformanceIndex(double keyPerformanceIndex) {
		this.keyPerformanceIndex = keyPerformanceIndex;
	}

	@Override
	public String toString() {
		return "Teacher [keyPerformanceIndex=" + keyPerformanceIndex + ", name=" + name + ", createDate=" + createDate
				+ ", objectId=" + objectId + ", createdBy=" + createdBy + "]";
	}

}
