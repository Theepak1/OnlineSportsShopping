package com.capg.onlinesportsshopee;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
import com.capg.onlinesportsshopee.service.IPaymentService;
import com.capg.onlinesportsshopee.service.PaymentServiceImpl;

@SpringBootTest
class PaymentServiceImpTest {

	@Autowired
	IPaymentService paymentService;

	@Autowired
	PaymentServiceImpl service;

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
	void testRemovePayment() throws PaymentServiceException {
		try {
			service.removePayment(96);
		} catch (PaymentServiceException exception) {
			assertEquals("Payment does not exist for paymenId to delete", exception.getMessage());
		}

	}

	@Disabled
	@Test
	void testRemovePayment1() throws PaymentServiceException {
		assertEquals(service.getPaymentDetails(96).getStatus(), service.removePayment(96).getStatus());

	}

	@Disabled
	@Test
	void testUpdatePayment() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Payment payment1 = new Payment(6, "debit", "paid", "SyedSamsudeen", 6, "124", expiryDate, 125);
		assertEquals(payment1, paymentService.addPayment(payment1));
		expiryDate = LocalDate.parse("2025-07-01");
		Payment payment2 = new Payment(6, "debit", "paid", "samsudeen", 7, "124", expiryDate, 369);
		list.add(payment2);
		assertEquals(payment2, paymentService.updatePayment(6, payment2));
		paymentService.removePayment(6);
	}

	@Disabled
	@Test
	void testGetPaymentDetails() {
		PaymentDTO payment = service.getPaymentDetails(25);
		try {
		assertEquals("Syed Samsudeen", payment.getCard().getCardName());
		}
		catch(PaymentServiceException exception)
		{
			assertEquals("Payment does not exist fro paymentId", exception.getMessage());
		}
	}

	@Disabled
	@Test
	void testGetPaymentDetails2() {
		try {
			service.getPaymentDetails(25);
		} catch (PaymentServiceException exception) {
			assertEquals("Payment does not exist fro paymentId", exception.getMessage());
		}
	}

	@Disabled
	@Test
	void testGetAllPaymentDetails() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Payment payment1 = new Payment(8, "debit", "paid", "SyedSssam", 8, "124", expiryDate, 258);
		assertEquals(payment1.toString(), paymentService.addPayment(payment1).toString());
		list.add(payment1);
		assertEquals(list, paymentService.getAllPaymentDetails());
		paymentService.removePayment(8);
	}

	@Disabled
	@Test
	void testValidatePaymentType() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Payment payment1 = new Payment(8, "debit", "paid", "SyedSssam", 8, "124", expiryDate, 258);
		assertEquals(true, service.validatePaymentType(payment1));
		paymentService.removePayment(8);
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