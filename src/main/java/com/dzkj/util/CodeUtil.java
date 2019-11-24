package com.dzkj.util;

import java.util.Random;

public class CodeUtil {

	public static String getCode() {
		StringBuffer code = new StringBuffer();
		Random rd = new Random();
		for(int i=0;i<4;i++) {
			int number = rd.nextInt(10);
			code.append(number);
		}
		return code.toString();
	}
}
