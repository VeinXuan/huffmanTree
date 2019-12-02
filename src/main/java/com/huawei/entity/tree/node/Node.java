 package com.huawei.entity.tree.node;

import java.util.List;

import com.huawei.entity.tree.comm.BaseNode;

public class Node<T> extends BaseNode<T> {
	private static final long serialVersionUID = -5241072842976939596L;
	private Node<T> next;
	private Node<T> previous;
	private List<Node<T>> children;

	public List<Node<T>> getChildren() {
		return children;
	}

	public Node<T> setChildren(List<Node<T>> children) {
		this.children = children;
		return this;
	}

	public Node<T> getNext() {
		return next;
	}

	public Node<T> setNext(Node<T> next) {
		this.next = next;
		return this;
	}

	public Node<T> getPrevious() {
		return previous;
	}

	public Node<T> setPrevious(Node<T> previous) {
		this.previous = previous;
		return this;
	}
}
