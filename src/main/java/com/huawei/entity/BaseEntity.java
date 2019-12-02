package com.huawei.entity;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable {

	protected static final long serialVersionUID = 6835689493171623137L;
	protected String name;
	protected Date createDate;
	protected Long objectId;
	protected String createdBy;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
