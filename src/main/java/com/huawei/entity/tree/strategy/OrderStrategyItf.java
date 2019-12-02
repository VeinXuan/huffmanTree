 package com.huawei.entity.tree.strategy;

import com.huawei.entity.tree.binary.BinaryNode;

public interface OrderStrategyItf {
	<T> void createNode(BinaryNode<T> tree, T data);

	<T> void traverse(BinaryNode<T> tree);
}
