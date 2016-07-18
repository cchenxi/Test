package com.chenxi.map;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�Ƽ���Ʒids
		int[] ids = { 2, 12, 7, 5, 9, 18, 3, 6, 4 };
		// ԭʼ��Ʒ�б�
		List<Product> productsOriginal = new ArrayList<>();
		for (int i = 1; i < 11; i++) {
			Product book = new Product(i, "��o" + i, i * 10.0);
			productsOriginal.add(book);
		}
		System.out.println(JSON.toJSONString(productsOriginal));

		// ��ԭʼ��Ʒ�б�ת��map
		Map<Integer, Product> originalProductMap = new LinkedHashMap<>();
		for (Product product : productsOriginal) {
			originalProductMap.put(product.getProductId(), product);
		}
		
		//putAll�����ᱣ����������� ����ǰ�������
		//ͬphp array_merge����
		for (int id : ids) {
			if (null != originalProductMap.get(id)) {
				originalProductMap.remove(id);
			}
		}
		
		System.out.println(JSON.toJSONString(originalProductMap));

		// �Ƽ���Ʒ�б�
		List<Product> productsRecommend = new ArrayList<>();
		for (int j = 20; j >= 1; j--) {
			if (j % 3 == 0) {
				Product book = new Product(j, "��r" + j, j * 10.0);
				productsRecommend.add(book);
			}
		}
		System.out.println(JSON.toJSONString(productsRecommend));

		// ���Ƽ���Ʒ�б�ת��map
		Map<Integer, Product> recommendProductMap = new LinkedHashMap<>();
		for (Product product : productsRecommend) {
			recommendProductMap.put(product.getProductId(), product);
		}
		System.out.println(JSON.toJSONString(recommendProductMap));

		// ���Ƽ���Ʒ�б�id����
		Map<Integer, Product> recommendProductMapResort = new LinkedHashMap<>();
		for (int i : ids) {
			if (null != recommendProductMap.get(i)) {
				recommendProductMapResort.put(i, recommendProductMap.get(i));
			}
		}
		System.out.println(JSON.toJSONString(recommendProductMapResort));

		// ��ԭʼ��Ʒ���б�׷�ӵ��Ƽ�����
		recommendProductMapResort.putAll(originalProductMap);

		System.out.println(JSON.toJSONString(recommendProductMapResort));

		// ��map����ת��list
		List<Product> finalProducts = new ArrayList<Product>(recommendProductMapResort.values());
		System.out.println(JSON.toJSONString(finalProducts));
	}
}

class Product {
	private int productId;
	private String productName;
	private double price;

	public Product(int productId, String productName, double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
