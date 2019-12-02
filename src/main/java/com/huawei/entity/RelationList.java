 package com.huawei.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RelationList {
	private static final String PARENTHESES = "PARENTHESES";// 圆括号
	private static final String BRACKETS = "BRACKETS";// 方括号
	private static final String BRACE = "BRACE";// 双引号

	public static final Map<Character, String> tokenPaire = new HashMap<Character, String>() {
		private static final long serialVersionUID = -571088631266058197L;
		{
			this.put('(', PARENTHESES);
			this.put(')', PARENTHESES);
			this.put('[', BRACKETS);
			this.put(']', BRACKETS);
			this.put('{', BRACE);
			this.put('}', BRACE);
		}
	};
	public static final Map<String, TokenPaire> tokeRelationMap = new HashMap<String, TokenPaire>() {
		private static final long serialVersionUID = -571088631266058197L;
		{
			this.put(BRACE, new TokenPaire() {
				{
					this.tokenList = new ArrayList<Token>();
					this.tokenList.add(new Token() {
						{
							this.setDesc("左花括号").setName("{").setTokenType(TokenType.LeftToken);
						}
					});
					this.tokenList.add(new Token() {
						{
							this.setDesc("右花括号").setName("}").setTokenType(TokenType.RightToken);
						}
					});
				}
			});
			this.put(BRACKETS, new TokenPaire() {
				{
					this.tokenList = new ArrayList<Token>();
					this.tokenList.add(new Token() {
						{
							this.setDesc("左方括号").setName("[").setTokenType(TokenType.LeftToken);
						}
					});
					this.tokenList.add(new Token() {
						{
							this.setDesc("右方括号").setName("]").setTokenType(TokenType.RightToken);
						}
					});
				}
			});
			this.put(PARENTHESES, new TokenPaire() {
				{
					this.tokenList = new ArrayList<Token>();
					this.tokenList.add(new Token(){
						{
							this.setDesc("左括号").setName("(").setTokenType(TokenType.LeftToken);
						}
					});
					this.tokenList.add(new Token() {
						{
							this.setDesc("右括号").setName(")").setTokenType(TokenType.RightToken);
						}
					});
				}
			});
		}
	};
}
