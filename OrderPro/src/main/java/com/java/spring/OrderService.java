package com.java.spring;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	
	
	@Autowired
	ProductDBstore productDBstore;

	public static final ArrayList<Order> prodOrderDet = new ArrayList<Order>();
	
	public void addOrder(Order order){
		
		prodOrderDet.add(new Order(order.getOrderId(),order.getProductId(), order.getQuantity()));
	
	}
	
	/*
	public  boolean processOrder(Order order){
		return false;
	
	}
	public static void main(String[] args) {
		
		
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");
	       OrderService orderService = applicationContext.getBean(OrderService.class);
    
        
        Order order = new Order(1,1,1);

		boolean flag = orderService.processOrder(order);
		
		if(flag) {
			System.out.println("Record added successfully");
		}else {
			System.out.println("Failed to add record");
		}
		}
        */
	

	
	
	public boolean processOrder(Order order){

		
		
     List<Product> qOrder = productDBstore.products.stream().filter(c -> c.getQuantity() > order.getQuantity()).filter(c ->c.getId()==order.getProductId()).collect(Collectors.toList());
		
        System.out.println(qOrder);

		if(qOrder != null) {
			
			addOrder(order);
	    /* prodOrderDet.add(new Order(order));
		//order.addOrderDetails(order.Order(order.getProductId(), order.getQuantity()));
			 prodOrderDet.add(new Order());
	   */
		
		
		//updating the ProductList after qualifying order
       	int index = productDBstore.products.indexOf(qOrder);
        productDBstore.updateQuantity(index, order.getQuantity());
		
		return true;
		
		}

		 return false;
		 
		 
		 
			}
	
	/*public static void main(String[] args) {
		
		
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");
	     OrderService orderService = applicationContext.getBean(OrderService.class);
        System.out.println(orderService.processOrder(new Order(1,1,3)));	
        
	}*/
	
	
	
	
}