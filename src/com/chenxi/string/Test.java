package com.chenxi.string;

import com.alibaba.fastjson.JSON;

public class Test {

	public static void main(String[] args) {
		/**
		 * �� php explode����
		 */
		String message = "��  18";
		System.out.println(JSON.toJSONString(message.split(" |��|,")));//["��","","18"]
		//���Դ������ո�����
		System.out.println(JSON.toJSONString(message.split("[ ]+|��|,")));//["��","18"]
	}

}
