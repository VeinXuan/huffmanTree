 package com.huawei.entity.tree.node;

import java.util.Iterator;

import com.huawei.entity.tree.comm.AbstractNode;

/**
 * 
 * @author vein
 * @date 2019年12月2日
 */
public class SimpleLinkedList<T> {
	private Node<T> head;
	private Node<T> curNode;
	private int size;

	public SimpleLinkedList() {
		this.head = new Node<T>();
		this.head.setDesc("头结点");
		curNode = this.head;
	}

	/**
	 * 尾插
	 * 
	 * @param data
	 * @return
	 */
	public SimpleLinkedList<T> add(T data) {
		Node<T> dataNode = new Node<T>();
		dataNode.setData(data);
		curNode.setNext(dataNode);
		curNode = dataNode.setPrevious(curNode);
		this.size++;
		return this;
	}

	/**
	 * 从尾部去除最后一个元素
	 * 
	 * @param data
	 * @return
	 */
	public T remove() {
		if (curNode == this.head||this.size==0) {
			return null;
		}
		Node<T> node = curNode;
		curNode = curNode.getPrevious().setNext(null);
		this.size--;
		return node.getData();
	}

	/**
	 * 从尾部去除最后一个元素
	 * 
	 * @param data
	 * @return
	 */
	public T removeAll(T data) {
		return remove(new Node<T>().setData(data), 2);
	}

	/**
	 * 从尾部去除最后一个元素
	 * 
	 * @param data
	 * @return
	 */
	public T removeFirst(T data) {
		return remove(new Node<T>().setData(data), 0);
	}

	/**
	 * 从尾部去除最后一个元素
	 * 
	 * @param data
	 * @return
	 */
	public T removeLast(T data) {
		return remove(new Node<T>().setData(data), 1);
	}

	/**
	 * 从一个有元素集合去除元素
	 * 
	 * @param data
	 * @param from
	 *            0，从前面删除一个；1，从后面删除一个；2.删除所有
	 * @return
	 */
	private T remove(AbstractNode<T> dataNode, int from) {
		if (this.head.getNext() == null) {
			return dataNode.getData();
		}
		Node<T> cursor = from == 1 ? size == 0 ? null : this.curNode : this.head.getNext();
		while(cursor!=null){
			if(nodeEquals(cursor, dataNode)){
				cursor.getPrevious().setNext(cursor.getNext());
				if (cursor.getNext() != null) {
					cursor.getNext().setPrevious(cursor.getPrevious());
				}
				size--;
				if (this.curNode == cursor) {
					this.curNode = cursor.getNext() == null ? cursor.getPrevious() : cursor.getNext();
				}
				if (from / 2 == 0) {// 当不等于2时，删除即结束
					break;
				}
			}
			if(from ==1){
				cursor = cursor.getPrevious();
				if(cursor==this.head){
					break;
				}
			}else{
				cursor = cursor.getNext();
			}
		}
		return dataNode == null ? null : dataNode.getData();
	}

	private boolean nodeEquals(AbstractNode<T> node1, AbstractNode<T> node2) {
		if (node1 == null || node2 == null) {
			return node1 == null ? node2 == null : false;
		}
		if (node1.getData() == null || node2.getData() == null) {
			return node1.getData() == null ? node2.getData() == null : false;
		}
		return node1 == node2 || node1.getData().equals(node2.getData());
	}

	public int getSize() {
		return this.size;
	}

	public Iterator<T> iterator() {
		return new SimpleLinkedListIterator();
	}

	private class SimpleLinkedListIterator implements Iterator<T> {
		private Node<T> iteratorNode;

		private SimpleLinkedListIterator() {
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
