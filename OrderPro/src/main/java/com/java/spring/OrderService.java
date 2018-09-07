
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
	
	public int index;
	public int remainingQuantity;
	public int productQuantity;
	public int orderQuantity;
	
	@Autowired
	ProductDBstore productDBstore;

	public static final ArrayList<Order> prodOrderDet = new ArrayList<Order>();
	
	
	public  void addOrder(Order order){
		
		prodOrderDet.add(new Order(order.getOrderId(),order.getProductId(), order.getQuantity()));
		List<Order> names = prodOrderDet.stream().collect(Collectors.toList());
		System.out.println("****printing after adding the qualified order to orderList  ********");
		names.forEach(System.out::println);
	}
	
	

	public boolean processOrder(Order order){

		

		
    
  List<Product> qualifiedOrder = productDBstore.products.stream().filter(c ->c.getId()==order.getProductId()).filter(c -> c.getQuantity() > order.getQuantity()).collect(Collectors.toList());
    
    System.out.println("****printing out the qualified product order ********");
    System.out.println(qualifiedOrder);

	if(!qualifiedOrder.isEmpty()) {
    
			addOrder(order);
			
	
		
		//updating the ProductList after qualifying order
	    //getting the index
       this.index = productDBstore.products.indexOf(qualifiedOrder.get(0));

       System.out.println("*******finding the index of qualified order********");
       System.out.println(this.index);
        
       
       this.productQuantity =  productDBstore.products.get(this.index).getQuantity();
       System.out.println("product	Quantity");
       System.out.println(this.productQuantity);
       
       this.orderQuantity = order.getQuantity();
       System.out.println("order Quantity");
       System.out.println(this.orderQuantity);
       
       this.remainingQuantity = this.productQuantity - this.orderQuantity;
       System.out.println("remaining Quantity");
       System.out.println(this.remainingQuantity);
       
       productDBstore.products.get(this.index).setQuantity(this.remainingQuantity);
      
       System.out.println("*******Printing out the ProductList element after updating quantity(5-->3)********");
       System.out.println(productDBstore.products.get(this.index));
	   
       
		return true;
		
		}
        return false;
        
        
		 
  }	
}