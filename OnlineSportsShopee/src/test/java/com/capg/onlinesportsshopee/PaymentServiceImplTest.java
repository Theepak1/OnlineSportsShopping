package com.capg.onlinesportsshopee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.onlinesportsshopee.bean.Payment;
import com.capg.onlinesportsshopee.exceptions.PaymentServiceException;
import com.capg.onlinesportsshopee.model.PaymentDTO;
import com.capg.onlinesportsshopee.service.PaymentServiceImpl;
import com.capg.onlinesportsshopee.util.PaymentUtil;

/*
 * Author : SYED SAMSYUDEEN A
 * Version : 1.0
 * Date : 07-04-2021
 * Description : This is Tenant Controller
*/
@SpringBootTest
class PaymentServiceImpTest {


	@Autowired
	private PaymentServiceImpl service;

	List<Payment> list = new ArrayList<>();

	@Disabled
	@Test
	void testAddPayment() {
		LocalDate expiryDate = LocalDate.parse("2025-05-24");
		Payment paymentTemp = new Payment(1, "debit", "paid", "SyedSamsu", 1, "12444683478", expiryDate, 256);
		try {
			service.addPayment(paymentTemp);
		} catch (PaymentServiceException exception) {
			assertEquals("Enter the valid payment detials", exception.getMessage());
		}

	}

	@Disabled
	@Test
	void testAddPayment2() {
		LocalDate expiryDate = LocalDate.parse("2025-05-24");
		Payment paymentTemp = new Payment(1, "debit", "paid", "SyedSamsu", 1, "1244472347892236", expiryDate, 256);

		assertEquals(paymentTemp.getStatus(), service.addPayment(paymentTemp).getStatus());

	}

	@Disabled
	@Test
	void testRemovePayment()  {
		try {
			service.removePayment(96);
		} catch (PaymentServiceException exception) {
			assertEquals("Payment does not exist for paymenId to delete", exception.getMessage());
		}

	}

	@Disabled
	@Test
	void testRemovePayment1()  {
		assertEquals(service.getPaymentDetails(96).getStatus(), service.removePayment(96).getStatus());

	}

	@Disabled
	@Test
	void testUpdatePayment() {
		LocalDate expiryDate = LocalDate.parse("2025-05-24");
		Payment paymentTemp = new Payment(112, "debit", "pending", "SyedSamsudeen", 111, "1244472347892236", expiryDate, 256);
		long paymentId = paymentTemp.getPaymentId();
		assertEquals("pending", service.updatePayment(paymentId, paymentTemp).getStatus());
		
	}
	
	@Disabled
	@Test
	void testUpdatePayment2() {
		LocalDate expiryDate = LocalDate.parse("2025-05-24");
		Payment paymentTemp = new Payment(119, "debit", "paid", "SyedSamsu", 117, "1244472347892236", expiryDate, 256);
		long paymentId = paymentTemp.getPaymentId();
		try {
		service.updatePayment(paymentId, paymentTemp);
		}
		catch(PaymentServiceException exception)
		{
			assertEquals("Payment does not exist for PaymentId", exception.getMessage());
		}
		
	}

	@Disabled
	@Test
	void testGetPaymentDetails(){
		PaymentDTO payment = service.getPaymentDetails(100);
		
		assertEquals("SyedSamsu", payment.getCard().getCardName());
		
	}

	@Disabled
	@Test
	void testGetPaymentDetails2()  {
		try {
			service.getPaymentDetails(25);
		} catch (PaymentServiceException exception) {
			assertEquals("Payment does not exist for paymentId", exception.getMessage());
		}
	}

	
	@Disabled
	@Test
	void testGetAllPaymentDetails2() {
		PaymentDTO payment1 = service.getPaymentDetails(100);
		PaymentDTO payment2 = service.getPaymentDetails(108);
		Payment payment10 = PaymentUtil.convertToPayment(payment1);
		Payment payment11 = PaymentUtil.convertToPayment(payment2);
		list.add(payment10);
		list.add(payment11);
		assertNotNull(list);
		
	}

	@Disabled
	@Test
	void testValidatePaymentType() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Payment payment1 = new Payment(8, "debit", "paid", "SyedSssam", 8, "124", expiryDate, 258);
		assertEquals(true, service.validatePaymentType(payment1));
	}

	@Disabled
	@Test
	void testValidatePaymentStatus() {

		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Payment payment2 = new Payment(8, "debit", "paid", "SyedSssam", 8, "124", expiryDate, 258);
		assertEquals(true, service.validatePaymentStatus(payment2));

	}

	@Disabled
	@Test
	void testValidateCardName() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Payment payment2 = new Payment(8, "debit", "paid", "SyedSssam", 8, "124", expiryDate, 258);
		assertEquals(true, service.validateCardName(payment2));
	}

	@Disabled
	@Test
	void testValidateCardNumber() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Payment payment2 = new Payment(8, "debit", "paid", "SyedSssam", 8, "1236998741123698", expiryDate, 258);
		assertEquals(true, service.validateCardNumber(payment2));
	}

	@Disabled
	@Test
	void testValidateCvv() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Payment payment2 = new Payment(8, "debit", "paid", "SyedSssam", 8, "124", expiryDate, 258);
		assertEquals(true, service.validateCvv(payment2));
	}

	@Disabled
	@Test
	void testValidateCardExpiry() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Payment payment2 = new Payment(8, "debit", "paid", "SyedSssam", 8, "124", expiryDate, 258);
		assertEquals(true, service.validateCardExpiry(payment2));
	}

}