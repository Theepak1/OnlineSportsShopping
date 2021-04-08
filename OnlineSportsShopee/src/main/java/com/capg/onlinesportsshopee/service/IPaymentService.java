package com.capg.onlinesportsshopee.service;

import java.util.List;

import com.capg.onlinesportsshopee.bean.Payment;
import com.capg.onlinesportsshopee.model.PaymentDTO;

public interface IPaymentService {
	public PaymentDTO addPayment(Payment payment);
	public PaymentDTO removePayment(long paymentId);
	public PaymentDTO updatePayment(long paymentId ,Payment payment);
	public PaymentDTO getPaymentDetails(long paymentId);
	public List<PaymentDTO> getAllPaymentDetails();
}