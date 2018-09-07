import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


import com.java.spring.Order;
import com.java.spring.OrderService;
import com.java.spring.Product;
import com.java.spring.ProductDBstore;

@Configuration
@ComponentScan(basePackages ="com.java.Spring")
public class AppConfig {
	
	
	/*
	@Bean(name="Ordering")
	public void getOrder() {


		final ArrayList<Order> prodOrderDet = new ArrayList<Order>();
		
	prodOrderDet.forEach(System.out::println);
		
		
	}*/
	
/*
@Bean
public Product getProduct(){
	
	Product product = new Product();
	return product;
	
}
@Bean
public Order getOrder(){
	
	Order order = new Order();
	return order;
	
}

@Bean
public ProductDBstore getProductDBstore(){
	
	ProductDBstore productDBstore = new ProductDBstore();
	return productDBstore;
}
*/

}
