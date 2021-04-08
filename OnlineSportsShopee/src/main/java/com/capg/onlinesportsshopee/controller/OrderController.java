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
@RequestMapping("/api/oss")
public class OrderController {
	@Autowired
	private IOrderService orderService;
	
	@PostMapping("/addOrder")
	public ResponseEntity<OrderDTO> addOrder(@RequestBody Order order) 
	{
		OrderDTO resultorder = orderService.addOrder(order);
		return new ResponseEntity<OrderDTO>(resultorder, HttpStatus.OK);

	}
	
	
	@PutMapping("/updateOrder")
	public ResponseEntity<OrderDTO> updateOrder(@RequestBody Order order) {
		OrderDTO updateOrder = orderService.updateOrder(order.getOrderId(), order);
		return new ResponseEntity<OrderDTO>(updateOrder, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/removeOrder/{orderid}")
	public ResponseEntity<OrderDTO> removePayment(@PathVariable long orderId)
		{
			OrderDTO removeOrder = orderService.removeOrder(orderId);
			return new ResponseEntity<OrderDTO>(removeOrder,HttpStatus.OK);
		}
	
	@GetMapping("/getOrder/{orderId}")
	public ResponseEntity<OrderDTO> GetOrderDetails(@PathVariable long orderId) throws OrderServiceException {
		OrderDTO getByOrderId = orderService.getOrderDetails(orderId);
		return new ResponseEntity<OrderDTO>(getByOrderId, HttpStatus.OK);
	}
	
	@GetMapping("/getAllOrder")
	public ResponseEntity<List<OrderDTO>> getAllOrders() {
		List<OrderDTO> getAllOrder = orderService.getAllOrders();
		return new ResponseEntity<List<OrderDTO>>(getAllOrder, HttpStatus.OK);
	}

}