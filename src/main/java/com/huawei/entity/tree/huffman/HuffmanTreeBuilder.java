 package com.huawei.entity.tree.huffman;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.huawei.entity.tree.binary.BinaryNode;
import com.huawei.entity.tree.node.SimpleLinkedStack;

/**
 * 
 * @author vein
 * @date 2019年12月2日
 */
public class HuffmanTreeBuilder {
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<Integer>();
		int[] ints = { -2, -0, 2 };
		for (int i = 0; i < ints.length; i++) {
			nums.add(ints[i]);
		}
		HuffmanNode<?> hf = buildNode(nums);
		System.out.println(JSONArray.toJSONString(hf));
		buildHuffmanCode(hf);
		System.out.println(JSONArray.toJSONString(hf));
	}

	/**
	 * 构建哈夫曼编码
	 * 
	 * @param huffmanTree
	 */
	public static <T extends Comparable<? super T>> void buildHuffmanCode(HuffmanNode<T> huffmanTree) {
		if (huffmanTree == null) {
			return;
		}
		HuffmanNode<T> parent = null, curNode = huffmanTree;
		char[] huffmanCode;
		SimpleLinkedStack<BinaryNode<T>> stack = new SimpleLinkedStack<BinaryNode<T>>();
		do {
			parent = (HuffmanNode<T>) curNode.getParent();
			curNode.setLevel(parent == null ? 0 : parent.getLevel() + 1);
			huffmanCode = new char[curNode.getLevel()];
			if (curNode.getLevel() > 0) {
				System.arraycopy(parent.getHmCode(), 0, huffmanCode, 0, parent == null ? 0 : parent.getHmCode().length);
				if (curNode == parent.getLchild()) {// 左子树
					huffmanCode[curNode.getLevel() - 1] = '0';
				} else {// 右子树
					huffmanCode[curNode.getLevel() - 1] = '1';
				}
			}
			curNode.setHmCode(huffmanCode);
			if (curNode.getLchild() != null) {
				if (curNode.getRchild() != null) {
					stack.push(curNode.getRchild());
				}
				curNode = (HuffmanNode<T>) curNode.getLchild();
			} else if (curNode.getRchild() != null) {
				curNode = (HuffmanNode<T>) curNode.getRchild();
			} else {
				curNode = (HuffmanNode<T>) stack.pop();
			}
		} while (curNode != null);
	}

	/**
	 * 构建哈夫曼树
	 * 
	 * @param data
	 * @return
	 */
	public static <T extends Comparable<? super T>> HuffmanNode<T> buildNode(List<T> data) {
		HuffmanNode<T> hn = new HuffmanNode<T>();
		if (data == null || data.size() == 0) {
			return hn;
		}
		if (data.size() == 1) {
			hn.setWeight(0).setParent(new HuffmanNode<T>().setHmCode(new char[0]).setLchild(hn).setLevel(0))
					.setData(data.get(0));
			return hn;
		}
		/*
		 * 由于哈夫曼树是两两组合在一起的， 所以当节点数大于1时，整个哈夫曼树只存在叶子节点和根节点，
		 * 由二叉树的性质可知，叶子节点恰比所有出度为2的节点多一个 因此整个哈夫曼树可以用一个2n-1个节点的一维数组表示
		 */
		List<HuffmanNode<T>> hnList = new ArrayList<HuffmanNode<T>>(data.size() * 2 - 1);
		// 初始化所有节点
		for (int i = 0, j = data.size() * 2 - 1; i < j; i++) {
			hn = new HuffmanNode<T>();
			if (i < data.size()) {// 前n个数组空间用于存储数据相关的节点
				hn.setData(data.get(i));
				hn.setWeight(data.get(i) == null ? 0 : data.get(i).hashCode());
			} else {// 第n+1至第2n-1个数组空间用于存储所有子树的根节点
				hn.setWeight(Integer.MAX_VALUE);// 默认所有子树的根节点权重为无限大
			}
			hnList.add(hn);
		}
		// 用于保存最小的两个元素
		@SuppressWarnings("unchecked")
		HuffmanNode<T>[] selectedNode = new HuffmanNode[2];
		HuffmanNode<T> parent;
		for (int i = 0, j = data.size() - 1; i < j; i++) {
			select(hnList, selectedNode);// 选择权重最小的两个子树，进行合并
			parent = hnList.get(data.size() + i);// 取n+i个空间作为根节点的存储空间
			parent.setWeight(selectedNode[0].getWeight() + selectedNode[1].getWeight());// 新的根节点为左右子树的权重之和
			// 双亲与子节点的关联关系的建立
			parent.setLchild(selectedNode[0]);
			parent.setRchild(selectedNode[1]);
			selectedNode[0].setParent(parent);
			selectedNode[1].setParent(parent);
		}
		return hn = hnList.get(hnList.size() - 1);// 获取最后一个构成的哈夫曼树
	}

	private static <T extends Comparable<? super T>> void select(List<HuffmanNode<T>> hnList,
			HuffmanNode<T>[] selectedNode) {
		if(hnList==null||hnList.size()<1){
			return;
		}
		HuffmanNode<T> curNode;
		selectedNode[0] = selectedNode[1] = hnList.get(hnList.size() - 1);// 默认最后两个元素的权重是最大的
		for (int i = 0, j = hnList.size(); i < j; i++) {
			curNode = hnList.get(i);
			if (curNode.getParent() != null) {
				continue;
			}
			if (curNode.getWeight() < selectedNode[0].getWeight()) {
				selectedNode[1] = selectedNode[0];
				selectedNode[0] = curNode;
			} else if (curNode.getWeight() < selectedNode[1].getWeight()) {
				selectedNode[1] = curNode;
			}
		}
	}

}
