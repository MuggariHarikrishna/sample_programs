package com.orders.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.dto.Order;

@Repository
public class OrderDao {

	private final String SQL_ADD_ORDER = "insert into orders(order_name,quantity,created_date,modified_date) values(?,?,?,?)";

	private final String SQL_FIND_ALL_ORDERS = "select order_no,order_name,quantity,created_date,modified_date from orders";

	private final String SQL_FIND_ORDER_BY_ID = "select order_no,order_name,quantity,created_date,modified_date from orders where order_no=?";

	private final String SQL_UPDATE_ORDER_BY_ID = "UPDATE orders SET order_name=?,quantity=? WHERE order_no=?";

	private final String SQL_DELETE_ORDER_BY_ID = "DELETE FROM orders WHERE order_no=?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int addOrder(final Order order) {
		System.out.println("order in dao :: " + order);

		GeneratedKeyHolder generatedKeyHolder = null;

		generatedKeyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement preparedStatement = null;

				preparedStatement = con.prepareStatement(SQL_ADD_ORDER, new String[] { "order_no" });
				preparedStatement.setString(1, order.getOrderName());
				preparedStatement.setInt(2, order.getQuantity());
				preparedStatement.setDate(3, order.getCreatedDate());
				preparedStatement.setDate(4, order.getModifiedDate());
				return preparedStatement;
			}
		}, generatedKeyHolder);

		return generatedKeyHolder.getKey().intValue();
	}

	public List<Order> findAllOrders() {
		List<Order> orders = null;

		orders = jdbcTemplate.query(SQL_FIND_ALL_ORDERS, new OrderRowMapper());
		return orders;
	}

	public Order findOrderById(int id) {
		Order order = null;

		order = jdbcTemplate.queryForObject(SQL_FIND_ORDER_BY_ID, new Object[] { id }, new OrderRowMapper());
		return order;
	}

	public int updateOrderById(Order order) {
		int modified_count = -1;

		modified_count = jdbcTemplate.update(SQL_UPDATE_ORDER_BY_ID,
				new Object[] { order.getOrderName(), order.getQuantity(), order.getOrderNo() });

		return modified_count;
	}

	public int deleteOrderById(int id) {
		return jdbcTemplate.update(SQL_DELETE_ORDER_BY_ID, new Object[] { id });
	}

	private final class OrderRowMapper implements RowMapper<Order> {

		@Override
		public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
			Order order = null;
			order = new Order();

			order.setOrderNo(rs.getInt(1));
			order.setOrderName(rs.getString(2));
			order.setQuantity(rs.getInt(3));
			order.setCreatedDate(rs.getDate(4));
			order.setModifiedDate(rs.getDate(5));
			return order;
		}

	}

}
