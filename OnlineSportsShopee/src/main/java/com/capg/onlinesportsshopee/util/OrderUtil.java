package com.capg.onlinesportsshopee.util;
import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.capg.onlinesportsshopee.bean.Order;
import com.capg.onlinesportsshopee.model.OrderDTO;

@Component
public class OrderUtil {
	public static List<OrderDTO> convertToOrderDtoList(List<Order> list)
	{
		List<OrderDTO> OrderDtoList = new ArrayList<OrderDTO>();
		for (Order order : list)
			OrderDtoList.add(convertToOrderDto(order));
	    return OrderDtoList;
	}
	public static OrderDTO convertToOrderDto(Order order) {
		OrderDTO orderDto = new OrderDTO();
		
		orderDto.setOrderId(order.getOrderId());
		orderDto.setAmount(order.getAmount());
		orderDto.setBillingDate(order.getBillingDate());
		
		return orderDto;
	}
	
	public static Order convertToorder(OrderDTO orderDto) {
		Order order = new Order();
		
		order.setOrderId(orderDto.getOrderId());
		order.setBillingDate(orderDto.getBillingDate());
		order.setAmount(orderDto.getAmount());
		
		return order;
	}
	
	

}
	