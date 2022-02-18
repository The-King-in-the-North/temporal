package com.temporal.repo;

import java.util.LinkedHashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.temporal.model.Order;

public class OrderConfig {

	
	public Order orderVal (String id) {
		LinkedHashMap<String, Order> orderList = new LinkedHashMap<String, Order>();
		orderList.put("1", new Order("1","Lays","10","1",""));
		orderList.put("2", new Order("2","Pringles","100","2",""));
		orderList.put("3", new Order("3","Coke","40","1",""));
		orderList.put("4", new Order("4","Cake","500","2",""));
		orderList.put("5", new Order("5","Gloves","800","1",""));
		orderList.put("6", new Order("6","FIFA23","3000","1",""));
		return orderList.get(id);
		
	}
	
	
}
