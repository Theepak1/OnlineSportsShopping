package com.capg.onlinesportsshopee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.onlinesportsshopee.bean.Order;
import com.capg.onlinesportsshopee.exceptions.OrderServiceException;
import com.capg.onlinesportsshopee.model.OrderDTO;
import com.capg.onlinesportsshopee.service.IOrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	@Autowired
	private IOrderService orderService;
	
	@PostMapping("/addOrder")
	public OrderDTO addOrder(@RequestBody Order order) {
		return orderService.addOrder(order);
	}
	
	@PutMapping("/updateOrder")
	public ResponseEntity<OrderDTO> updateOrder(@RequestBody Order order) {
		return new ResponseEntity<OrderDTO>(orderService.updateOrder(order.getOrderId(), order),HttpStatus.OK);
	}
	
	@DeleteMapping("/removeOrder/{orderid}")
	public Order removeOrder(@PathVariable long id) throws OrderServiceException {
		orderService.removeOrder(id);
		return null;
	}
	@GetMapping("/getOrderDetails/{orderId}")
	public ResponseEntity<OrderDTO> getOrderDetails(@PathVariable long id) throws OrderServiceException{
		return new ResponseEntity<OrderDTO>(orderService.getOrderDetails(id),HttpStatus.OK);
	}
	
	@GetMapping("/getAllOrders")
	public ResponseEntity<List<OrderDTO>> getAllOrders(){
		return new ResponseEntity<List<OrderDTO>>(orderService.getAllOrders(),HttpStatus.OK);
	}
	

}
