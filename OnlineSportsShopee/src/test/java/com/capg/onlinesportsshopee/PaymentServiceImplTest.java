package com.capg.onlinesportsshopee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capg.onlinesportsshopee.bean.Payment;
import com.capg.onlinesportsshopee.service.IPaymentService;
import com.capg.onlinesportsshopee.service.PaymentServiceImpl;

class PaymentServiceImpTest {
	
	@Autowired
	IPaymentService paymentService;
	
	@Autowired
	PaymentServiceImpl service;
	
	
	List<Payment> list = new ArrayList<>();

	@Test
	void testAddPayment() {
		LocalDate expiryDate=LocalDate.parse("2025-05-24");
		Payment paymentTemp=new Payment(1, "debit","paid",1, "SyedSamsu","1244652347891236",expiryDate,256);
		assertEquals(paymentTemp,paymentService.addPayment(paymentTemp));
		list.add(paymentTemp);
		paymentService.removePayment(1);
	}

	@Test
	void testRemovePayment() {
		LocalDate expiryDate=LocalDate.parse("2025-07-24");
		Payment paymentTemp=new Payment(2, "debit","paid",2, "SyedSamsu","1244652347891236",expiryDate,256);
		paymentService.addPayment(paymentTemp);
		assertNotEquals(paymentTemp,paymentService.removePayment(paymentTemp.getPaymentId()));
	}

	@Test
	void testUpdatePayment() {
		LocalDate expiryDate=LocalDate.parse("2025-07-01");
		Payment payment1=new Payment(6,"debit","paid",6,"SyedSamsudeen","124",expiryDate,125);
		assertEquals(payment1,paymentService.addPayment(payment1));
		expiryDate=LocalDate.parse("2025-07-01");
		Payment payment2=new Payment(6,"debit","paid",7,"samsudeen","124",expiryDate,369);
		list.add(payment2);
		assertEquals(payment2,paymentService.updatePayment(6,payment2));
		//paymentService.removePayment(6);
	}

	@Test
	void testGetPaymentDetails() {
		LocalDate expiryDate=LocalDate.parse("2025-07-01");
		Payment payment1=new Payment(9,"debit","paid",6,"Samsusyed","124",expiryDate,158);
		assertEquals(payment1,paymentService.addPayment(payment1));
		list.add(payment1);
		assertEquals(payment1,paymentService.getPaymentDetails(9));
		//paymentService.removePayment(5);
	}

	@Test
	void testGetAllPaymentDetails() {
		LocalDate expiryDate=LocalDate.parse("2025-07-01");
		Payment payment1=new Payment(8,"debit","paid",8,"SyedSssam","124",expiryDate,258);
		assertEquals(payment1.toString(),paymentService.addPayment(payment1).toString());
		list.add(payment1);
		assertEquals(list, paymentService.getAllPaymentDetails());
		//paymentService.removePayment(8);
	}

	@Test
	void testValidatePaymentType() {
		LocalDate expiryDate=LocalDate.parse("2025-07-01");
		Payment payment1=new Payment(8,"debit","paid",8,"SyedSssam","124",expiryDate,258);
		assertEquals(true,service.validatePaymentType(payment1));
	}

	@Test
	void testValidatePaymentStatus() {
		LocalDate expiryDate=LocalDate.parse("2025-07-01");
		Payment payment1=new Payment(8,"debit","paid",8,"SyedSssam","124",expiryDate,258);
		assertEquals(true,service.validatePaymentStatus(payment1));
	}

	@Test
	void testValidateCardName() {
		LocalDate expiryDate=LocalDate.parse("2025-07-01");
		Payment payment1=new Payment(8,"debit","paid",8,"SyedSssam","124",expiryDate,258);
		assertEquals(true,service.validateCardName(payment1));
	}

	@Test
	void testValidateCardNumber() {
		LocalDate expiryDate=LocalDate.parse("2025-07-01");
		Payment payment1=new Payment(8,"debit","paid",8,"SyedSssam","124",expiryDate,258);
		assertEquals(true,service.validateCardNumber(payment1));
	}

	@Test
	void testValidateCvv() {
		LocalDate expiryDate=LocalDate.parse("2025-07-01");
		Payment payment1=new Payment(8,"debit","paid",8,"SyedSssam","124",expiryDate,258);
		assertEquals(true,service.validateCvv(payment1));
	}

	@Test
	void testValidateCardExpiry() {
		LocalDate expiryDate=LocalDate.parse("2025-07-01");
		Payment payment1=new Payment(8,"debit","paid",8,"SyedSssam","124",expiryDate,258);
		assertEquals(true,service.validateCvv(payment1));
	}

}
