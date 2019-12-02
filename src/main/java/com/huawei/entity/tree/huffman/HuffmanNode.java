 package com.huawei.entity.tree.huffman;

import com.huawei.entity.tree.binary.BinaryNode;

/**
 * 
 * @author vein
 * @date 2019年12月2日
 */
public class HuffmanNode<T extends Comparable<? super T>> extends BinaryNode<T> {

	private static final long serialVersionUID = -6412666904057826102L;
	// 权重
	private int weight;
	// 哈夫曼编码
	private char[] hmCode;

	public int getWeight() {
		return weight;
	}

	public HuffmanNode<T> setWeight(int weight) {
		this.weight = weight;
		return this;
	}

	public char[] getHmCode() {
		return hmCode;
	}

	public HuffmanNode<T> setHmCode(char[] hmCode) {
		this.hmCode = hmCode;
		return this;
	}

}
