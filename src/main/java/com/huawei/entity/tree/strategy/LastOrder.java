 package com.huawei.entity.tree.strategy;

import com.huawei.entity.tree.binary.BinaryNode;
import com.huawei.entity.tree.node.SimpleLinkedStack;

/**
 * 先序遍历树结构
 * 
 * @author vein
 * @date 2019年10月17日
 */
public class LastOrder extends OrderStrategyAbs {

	/**
	 * 平衡二叉树的构建
	 */
	public <T> void createNode(BinaryNode<T> tree, T data) {

	}

	public <T> void traverse(BinaryNode<T> tree) {
		// TODO Auto-generated method stub
		if (tree == null) {
			return;
		}
		SimpleLinkedStack<BinaryNode<T>> traverseStack = new SimpleLinkedStack<BinaryNode<T>>();
		this.doTraverse(tree, traverseStack);
	}

	private <T> void doTraverse(BinaryNode<T> tree, SimpleLinkedStack<BinaryNode<T>> traverseStack) {
		BinaryNode<T> curNode = tree;
		while (curNode != null) {

			if (curNode.getRchild() != null) {
				traverseStack.push(curNode.getRchild());
			}
			if (curNode.getLchild() != null) {
				curNode = curNode.getLchild();
			} else {
				curNode = traverseStack.pop();
			}
			System.out.println(curNode.getData());
		}
	}

}
