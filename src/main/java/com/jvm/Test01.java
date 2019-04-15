package com.jvm;


import java.text.DecimalFormat;

public class Test01 {

	public static void main(String[] args) {

		//-Xms5m -Xmx20m -XX:+PrintGCDetails -XX:+UseSerialGC -XX:+PrintCommandLineFlags
		
		//查看GC信息
		System.out.println("max memory:" + getSize(Runtime.getRuntime().maxMemory()));
		System.out.println("free memory:" + getSize(Runtime.getRuntime().freeMemory()));
		System.out.println("total memory:" + getSize(Runtime.getRuntime().totalMemory()));
//
//		byte[] b1 = new byte[1*1024*1024];
//		System.out.println("分配了1M");
//		System.out.println("max memory:" + Runtime.getRuntime().maxMemory());
//		System.out.println("free memory:" + Runtime.getRuntime().freeMemory());
//		System.out.println("total memory:" + Runtime.getRuntime().totalMemory());
//
//		byte[] b2 = new byte[4*1024*1024];
//		System.out.println("分配了4M");
//		System.out.println("max memory:" + Runtime.getRuntime().maxMemory());
//		System.out.println("free memory:" + Runtime.getRuntime().freeMemory());
//		System.out.println("total memory:" + Runtime.getRuntime().totalMemory());
		
	}

	public static String getSize(long size) {
		//获取到的size为：1705230
		int GB = 1024 * 1024 * 1024;//定义GB的计算常量
		int MB = 1024 * 1024;//定义MB的计算常量
		int KB = 1024;//定义KB的计算常量
		DecimalFormat df = new DecimalFormat("0.00");//格式化小数
		String resultSize = "";
		if (size / GB >= 1) {
			//如果当前Byte的值大于等于1GB
			resultSize = df.format(size / (float) GB) + "GB   ";
		} else if (size / MB >= 1) {
			//如果当前Byte的值大于等于1MB
			resultSize = df.format(size / (float) MB) + "MB   ";
		} else if (size / KB >= 1) {
			//如果当前Byte的值大于等于1KB
			resultSize = df.format(size / (float) KB) + "KB   ";
		} else {
			resultSize = size + "B   ";
		}
		return  resultSize;
	}
	
}
