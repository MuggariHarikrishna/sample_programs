package com.orders.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.Order;
import com.orders.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@SuppressWarnings("deprecation")
	@PostMapping("/addOrder")
	public String addOrder(@RequestParam("OrderName") String OrderName, @RequestParam("quantity") int quantity,
			Model model) {
		int result = -1;
		Order order = null;

		order = new Order();
		order.setOrderName(OrderName);
		order.setQuantity(quantity);
		System.out.println("order in addOrder :: " + order);
		order.setCreatedDate(new Date(2019, 05, 5));
		order.setModifiedDate(new Date(2019, 05, 5));

		result = orderService.addOrder(order);
		System.out.println("result in controller addOrder ::: " + result);
		if (result > -1) {
			model.addAttribute("orders", orderService.findAllOrders());
			return "todo-home";
		} else {
			return "error";
		}
	}

	@GetMapping("/orders")
	public String findAllOrders(Model model) {
		model.addAttribute("orders", orderService.findAllOrders());
		return "todo-home";
	}

	public Order findOrderById(int id) {
		return orderService.findOrderById(id);
	}

	@PostMapping("/updateOrder")
	public String updateOrderById(@RequestParam("orderName") String OrderName,@RequestParam("orderId") int OrderId,@RequestParam("quantity") int quantity,Model model) {
		int result=-1;
		
		Order order=null;
		
		
		order=new Order();
		order.setOrderNo(OrderId);
		order.setQuantity(quantity);
		order.setOrderName(OrderName);
		
		result=orderService.updateOrderById(order);
		
		
		if (result > -1) {
			model.addAttribute("orders", orderService.findAllOrders());
			return "todo-home";
		} else {
			return "error";
		}
	}

	@PostMapping("/deleteOrderbyId")
	public String deleteOrderById(@RequestParam("id") int id, Model model) {
		int result = -1;
		result = orderService.deleteOrderById(id);
		if (result > -1) {
			model.addAttribute("orders", orderService.findAllOrders());
			return "todo-home";
		} else {
			return "error";
		}

	}

	@RequestMapping("/welcome")
	public String showWelcome() {
		return "welcome";
	}
}
