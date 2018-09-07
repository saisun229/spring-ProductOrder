package com.java.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;


@Component("productDBstore")
public class ProductDBstore {
	
public int newQ;
public int newQuantity;
	
public static final ArrayList<Product> products = new ArrayList<Product>();
public ProductDBstore() {
	
	products.add(new Product(1, "Biryani",200, 5));
	products.add(new Product(2, "Chicken",200, 5));
	products.add(new Product(3, "Mutton",200, 5));
	products.add(new Product(4, "Fish",200, 5));
	products.add(new Product(5, "Prawns",200, 5));

	
	}


	
	
/*	
public void updateQuantity(int indx, int quantity) {
	
this.newQ= products.get(indx).getQuantity() ;

this.newQuantity= newQ- quantity;
products.get(indx).setQuantity(newQuantity);
}*/
	


}
