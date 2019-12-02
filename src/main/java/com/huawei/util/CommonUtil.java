package com.huawei.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class CommonUtil {
	public static void killTime(long cost) {
		try {
			Thread.sleep(cost);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Random rand = new Random();

	public static void killTime() {
		killTime(rand.nextInt(2000) + 200);
	}

	public static int nextInt(int base, int bound) {
		return base + rand.nextInt(bound);
	}

	public static <T> String join(Collection<T> objs) {
		return join(objs, ",");
	}

	public static <T> String join(Collection<T> objs, String seperator) {
		if (objs == null || objs.size() < 1) {
			return "";
		}
		seperator = seperator == null ? "" : seperator;
		StringBuffer sb = new StringBuffer();
		Iterator<T> it = objs.iterator();
		while (it.hasNext()) {
			sb.append(it.next()).append(seperator);
		}
		return sb.substring(0, sb.length() - seperator.length());
	}

	public static <T> T[] toArray(Collection<T> list) {
		if(list == null){
			return null;
		}
		@SuppressWarnings("unchecked")
		T[] arr = (T[]) new Object[list.size()];
		int i = 0;
		for (T t : list) {
			arr[i++] = t;
		}
		return arr;
	}
}
