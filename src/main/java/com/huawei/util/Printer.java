package com.huawei.util;

import com.alibaba.fastjson.JSONObject;

public class Printer {
	public static void print(Object obj) {
		System.out.print(JSONObject.toJSONString(obj));
	}

	public static void println(Object obj) {
		print(obj);
		System.out.println("\n");
	}
}
