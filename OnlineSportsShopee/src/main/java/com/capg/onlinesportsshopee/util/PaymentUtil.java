package com.capg.onlinesportsshopee.util;


import java.util.ArrayList;
import java.util.List;

import com.capg.onlinesportsshopee.bean.Payment;
import com.capg.onlinesportsshopee.model.PaymentDTO;

public class PaymentUtil {
	
	public static List<PaymentDTO> convertToPaymentDtoList(List<Payment> list)
	{
		List<PaymentDTO> paymentDtoList = new ArrayList<PaymentDTO>();
		for (Payment payment : list)
			paymentDtoList.add(convertToPaymentDto(payment));
	    return paymentDtoList;
	}
	
	public static Payment convertToPayment(PaymentDTO paymentDto) {
		Payment payment = new Payment();
		
		payment.setPaymentId(paymentDto.getPaymentId());
		payment.setType(paymentDto.getType());
		payment.setStatus(paymentDto.getStatus());
		payment.getCard().setId(paymentDto.getCard().getId());
		payment.getCard().setCardName(paymentDto.getCard().getCardName());
		payment.getCard().setCardNumber(paymentDto.getCard().getCardNumber());
		payment.getCard().setCardExpiry(paymentDto.getCard().getCardExpiry());
		payment.getCard().setCvv(paymentDto.getCard().getCvv());
		
		return payment;
	}
	
	public static PaymentDTO convertToPaymentDto(Payment payment) {
		PaymentDTO paymentDto = new PaymentDTO();
		
		paymentDto.setPaymentId(payment.getPaymentId());
		paymentDto.setType(payment.getStatus());
		paymentDto.setStatus(payment.getStatus());
		paymentDto.getCard().setId(payment.getCard().getId());
		paymentDto.getCard().setCardName(payment.getCard().getCardName());
		paymentDto.getCard().setCardNumber(payment.getCard().getCardNumber());
		paymentDto.getCard().setCardExpiry(payment.getCard().getCardExpiry());
		paymentDto.getCard().setCvv(payment.getCard().getCvv());
		
		return paymentDto;
	}

}
