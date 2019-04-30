package com.order.demo;

import java.time.Month;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.dto.Order;
import com.orders.controller.OrderController;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dto","com.orders.controller","com.orders.dao","com.orders.service"})
public class OrderApplication {

	public static void main(String[] args) {
		
		ApplicationContext context=null;
		Order order=null;
		
		context=SpringApplication.run(OrderApplication.class, args);
		
//		OrderController controller=context.getBean("orderController",OrderController.class);
//		order=new Order();
//		order.setOrderName("plasma tv");
//		order.setQuantity(101);
//		order.setCreatedDate(new java.sql.Date(2019,04,29));
//		order.setModifiedDate(new java.sql.Date(2019, 05, 30));
//		System.out.println(controller.addOrder(order));
		
//		System.out.println("All orders in test :: "+controller.findAllOrders());
		
//		System.out.println("order in test by ID :: "+controller.findOrderById(2));
		
		
//		System.out.println("update order by ID :: "+controller.updateOrderById(order));
	}

}
