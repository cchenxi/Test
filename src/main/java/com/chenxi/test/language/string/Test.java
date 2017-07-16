package com.chenxi.test.language.string;

import com.alibaba.fastjson.JSON;

import java.util.Date;

public class Test {

	public static void main(String[] args) {
		/**
		 * 类 php explode函数
		 */
		String message = "我  18";
		System.out.println(JSON.toJSONString(message.split(" |，|,")));//["我","","18"]
		//可以处理多个空格的情况
		System.out.println(JSON.toJSONString(message.split("[ ]+|，|,")));//["我","18"]

		System.out.printf("%tc", new Date());
	}

}
