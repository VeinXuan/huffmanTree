 package com.huawei.entity.tree.comm;

public class BaseNode<T> extends AbstractNode<T> {
	private static final long serialVersionUID = 779192562888883276L;
	protected String desc;
	protected String name;

	public String getDesc() {
		return desc;
	}

	public BaseNode<T> setDesc(String desc) {
		this.desc = desc;
		return this;
	}

	public String getName() {
		return name;
	}

	public BaseNode<T> setName(String name) {
		this.name = name;
		return this;
	}
}
