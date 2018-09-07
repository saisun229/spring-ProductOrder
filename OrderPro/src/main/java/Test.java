
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.spring.Order;
import com.java.spring.OrderService;
import com.java.spring.ProductDBstore;


public class Test {
	

	
	public static void main(String[] args) {
		
		
           ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
	       OrderService orderService = applicationContext.getBean(OrderService.class);
       
           
           Order order = new Order(2,2,2);

   		boolean flag = orderService.processOrder(order);
   		
   		
   		if(flag) {
   			System.out.println("Record added successfully");
   		}else {
   			System.out.println("Failed to add record");
   		}
           
	}

}
