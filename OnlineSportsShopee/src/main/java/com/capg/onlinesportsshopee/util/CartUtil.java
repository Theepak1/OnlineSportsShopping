package com.capg.onlinesportsshopee.util;

import java.util.ArrayList;
import java.util.List;

import com.capg.onlinesportsshopee.bean.Cart;
import com.capg.onlinesportsshopee.model.CartDTO;

public class CartUtil {

	public static List<CartDTO> convertToCartDtoList(List<Cart> list) {
		List<CartDTO> cartDtoList = new ArrayList<CartDTO>();
		for (Cart cart : list)
			cartDtoList.add(convertToCartDto(cart));
		return cartDtoList;
	}

	public static Cart convertToCart(CartDTO cartDto) {
		Cart cart = new Cart();

		cart.setCartId(cartDto.getCartId());
		cart.setImageName(cartDto.getImageName());
		cart.setProductName(cartDto.getProductName());
		cart.setQuantity(cartDto.getQuantity());
		cart.setPrice(cartDto.getPrice());
		cart.setTotal(cartDto.getTotal());

		return cart;
	}

	public static CartDTO convertToCartDto(Cart cart) {
		CartDTO cartDto = new CartDTO();

		cartDto.setCartId(cartDto.getCartId());
		cartDto.setImageName(cartDto.getImageName());
		cartDto.setProductName(cartDto.getProductName());
		cartDto.setQuantity(cartDto.getQuantity());
		cartDto.setPrice(cartDto.getPrice());
		cartDto.setTotal(cartDto.getTotal());

		return cartDto;
	}

}
