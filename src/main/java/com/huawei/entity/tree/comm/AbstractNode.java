 package com.huawei.entity.tree.comm;

import java.io.Serializable;

public class AbstractNode<T> implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected T data;
	protected AbstractNode<T> parent;
	protected Integer level;
	public T getData() {
		return data;
	}

	public Integer getLevel() {
		return level;
	}

	public AbstractNode<T> setLevel(Integer level) {
		this.level = level;
		return this;
	}
	public AbstractNode<T> setData(T data) {
		this.data = data;
		return this;
	}

	public AbstractNode<T> getParent() {
		return parent;
	}

	public AbstractNode<T> setParent(AbstractNode<T> parent) {
		this.parent = parent;
		return this;
	}

}
