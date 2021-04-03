package com.capg.onlinesportsshopee.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.onlinesportsshopee.bean.Order;



public interface IOrderRepository extends JpaRepository<Order, Long> {

	

	
	/*public Order addOrder(Order order);
	public Order removeOrder(long id);
	public Order  updateOrder(long id, Order order);
	public Order  getOrderDetails(long id);
	public List<Order> getAllOrders(); */
    
}
