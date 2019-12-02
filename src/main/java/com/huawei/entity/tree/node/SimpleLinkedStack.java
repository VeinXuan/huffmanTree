package com.huawei.entity.tree.node;

import java.util.Iterator;

/**
 * 
 * @author vein
 * @date 2019年12月2日
 */
public class SimpleLinkedStack<T> {
	private int size = 0;
	private Node<T> head;

	public SimpleLinkedStack() {
		head = new Node<T>();
	}

	public T get(int index) {
		Node<T> target = this.head.getNext();
		if (index < 0) {
			throw new RuntimeException("error index");
		}
		if (target == null) {
			throw new RuntimeException("there is no element can iterator");
		}
		if (index < size) {
			int i = 0;
			while (i++ < index) {
				target = target.getNext();
			}
		} else {
			throw new RuntimeException("error index");
		}
		return target == null ? null : target.getData();
	}

	public int getIndexOf(T data) {
		int index = -1;
		Node<T> cursor = this.head.getNext();
		if (cursor == null) {
			return index;
		}
		if (cursor.getData() == data || IsDataEqual(cursor, data)) {
			return 0;
		}
		if (cursor != null) {
			for (int i = 0; i < this.size; i++) {
				if (IsDataEqual(cursor, data)) {
					index = i;
					break;
				}
				cursor = cursor.getNext();
			}
		}
		return index;
	}

	private boolean IsDataEqual(Node<T> node, T data) {
		if(node==null){
			return data==null;
		}
		return node.getData() == null ? data == null : node.getData().equals(data);
	}

	/**
	 * 头插法
	 * 
	 * @param t
	 * @return
	 */
	public SimpleLinkedStack<T> push(T t) {
		Node<T> newNode = new Node<T>();
		newNode.setData(t);
		newNode.setPrevious(head);
		newNode.setNext(head.getNext());
		if (head.getNext() != null) {
			head.getNext().setPrevious(newNode);
		}
		head.setNext(newNode);
		size++;
		return this;
	}

	/**
	 * 去除第一个节点
	 * 
	 * @return
	 */
	public T pop() {
		Node<T> nodeRemoved = this.head.getNext();
		if (nodeRemoved == null || size == 0) {
			return null;
		}
		if (nodeRemoved.getNext() == null) {
			size = 0;
		}else{
			head.setNext(nodeRemoved.getNext());
			size--;
			if (nodeRemoved.getNext() != null) {
				nodeRemoved.getNext().setPrevious(head);
			}
		}
		return nodeRemoved.getData();
	}

	public int size() {
		return this.size;
	}

	public Iterator<T> iterator() {
		return new MyIterator();
	}

	class MyIterator implements Iterator<T> {
		private Node<T> iteratorNode;
		private MyIterator() {
			iteratorNode = head;
		}

		public boolean hasNext() {
			return iteratorNode.getNext() != null;
		}

		public T next() {
			if (size == 0 || iteratorNode == null) {
				throw new RuntimeException("there is no element can iterator!");
			}
			if (iteratorNode.getNext() != null) {
				iteratorNode = iteratorNode.getNext();
			}
			return iteratorNode.getData();
		}
	}
}