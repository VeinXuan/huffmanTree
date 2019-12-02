 package com.huawei.entity.tree.binary;

import com.huawei.entity.tree.comm.BaseNode;

public class BinaryNode<T> extends BaseNode<T> {
	private static final long serialVersionUID = -4794220103877318725L;
	private BinaryNode<T> rchild;
	private BinaryNode<T> lchild;

	public BinaryNode<T> getRchild() {
		return rchild;
	}

	public BinaryNode<T> setRchild(BinaryNode<T> rchild) {
		this.rchild = rchild;
		return this;
	}

	public BinaryNode<T> getLchild() {
		return lchild;
	}

	public BinaryNode<T> setLchild(BinaryNode<T> lchild) {
		this.lchild = lchild;
		return this;
	}
}
