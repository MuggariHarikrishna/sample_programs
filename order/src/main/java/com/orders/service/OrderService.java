package com.orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Order;
import com.orders.dao.OrderDao;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;

	public int addOrder(Order order) {
		return orderDao.addOrder(order);
	}

	public List<Order> findAllOrders() {
		return orderDao.findAllOrders();
	}

	public Order findOrderById(int id) {
		return orderDao.findOrderById(id);
	}

	public int updateOrderById(Order order) {
		return orderDao.updateOrderById(order);
	}

	public int deleteOrderById(int id) {
		return orderDao.deleteOrderById(id);
	}
}
