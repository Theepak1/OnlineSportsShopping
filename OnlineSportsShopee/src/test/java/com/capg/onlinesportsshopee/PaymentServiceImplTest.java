package com.capg.onlinesportsshopee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * Description : This is Payment Service Implementation Test
*/
@SpringBootTest
class PaymentServiceImpTest {


	final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


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

			LOGGER.info("AddPayment()Tested");

		}

	}

	@Disabled
	@Test
	void testAddPayment2() {
		LOGGER.info("Add Payment Details executed");
		LocalDate expiryDate = LocalDate.parse("2025-05-24");
		Payment paymentTemp = new Payment(2, "debit", "paid", "Samsu", 2, "9244472347892236", expiryDate, 256);

		assertEquals(paymentTemp.getStatus(), service.addPayment(paymentTemp).getStatus());

		LOGGER.info("AddPayment2() Tested");


	}

	@Disabled
	@Test
	void testRemovePayment() {
		try {
			service.removePayment(96);

		} catch (PaymentServiceException exception) {
			assertEquals("Payment does not exist for paymentId to delete", exception.getMessage());
			LOGGER.info("RemovePayment()  Tested");
		}

	}

	@Disabled
	@Test
	void testRemovePayment1() {

		assertEquals(service.getPaymentDetails(108).getStatus(), service.removePayment(108).getStatus());
		LOGGER.info("RemovePayment1()  Tested");


	}

	@Disabled
	@Test
	void testUpdatePayment() {
		LocalDate expiryDate = LocalDate.parse("2025-05-24");
		Payment paymentTemp = new Payment(145, "debit", "paid", "Syed Samsudeen A", 144, "9244472347892236", expiryDate,
				256);
		long paymentId = paymentTemp.getPaymentId();
		assertEquals("paid", service.updatePayment(paymentId, paymentTemp).getStatus());

		LOGGER.info("UpdatePayment()  Tested");


	}

	@Disabled
	@Test
	void testUpdatePayment2() {
		LocalDate expiryDate = LocalDate.parse("2025-05-24");
		Payment paymentTemp = new Payment(200, "debit", "paid", "SyedSamsu", 117, "1244472347892236", expiryDate, 256);
		long paymentId = paymentTemp.getPaymentId();
		try {
			service.updatePayment(paymentId, paymentTemp);
		} catch (PaymentServiceException exception) {
			assertEquals("Payment does not exist for PaymentId", exception.getMessage());

			LOGGER.info("UpdatePayment2()  Tested");

		}

	}

	@Disabled
	@Test
	void testGetPaymentDetails() {
		PaymentDTO payment = service.getPaymentDetails(100);

		assertEquals("SyedSamsu", payment.getCard().getCardName());

		LOGGER.info("GetPaymentDetails()  Tested");

	}

	@Disabled
	@Test
	void testGetPaymentDetails2() {
		try {
			service.getPaymentDetails(20);
		} catch (PaymentServiceException exception) {
			assertEquals("Payment does not exist for paymentId", exception.getMessage());

			LOGGER.info("GetPaymentDetails2()  Tested");

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
		LOGGER.info("GetAllPaymentDetails2()  Tested");

	}

	@Disabled
	@Test
	void testValidatePaymentType() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Payment payment1 = new Payment(8, "debit", "paid", "SyedSssam", 8, "124", expiryDate, 258);
		assertEquals(true, service.validatePaymentType(payment1));

		LOGGER.info("ValidatePaymentType()  Tested");

	}

	@Disabled
	@Test
	void testValidatePaymentStatus() {

		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Payment payment2 = new Payment(8, "debit", "paid", "SyedSssam", 8, "124", expiryDate, 258);
		assertEquals(true, service.validatePaymentStatus(payment2));

		LOGGER.info("ValidatePaymentStatus() Tested");


	}

	@Disabled
	@Test
	void testValidateCardName() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Payment payment2 = new Payment(8, "debit", "paid", "SyedSssam", 8, "124", expiryDate, 258);
		assertEquals(true, service.validateCardName(payment2));

		LOGGER.info("ValidateCardName() Tested");

	}

	@Disabled
	@Test
	void testValidateCardNumber() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Payment payment2 = new Payment(8, "debit", "paid", "SyedSssam", 8, "1236998741123698", expiryDate, 258);
		assertEquals(true, service.validateCardNumber(payment2));

		LOGGER.info("ValidateCardNumber() Tested");

	}

	@Disabled
	@Test
	void testValidateCvv() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Payment payment2 = new Payment(8, "debit", "paid", "SyedSssam", 8, "124", expiryDate, 258);
		assertEquals(true, service.validateCvv(payment2));

		LOGGER.info("ValidateCvv() Tested");

	}

	@Disabled
	@Test
	void testValidateCardExpiry() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Payment payment2 = new Payment(8, "debit", "paid", "SyedSssam", 8, "124", expiryDate, 258);
		assertEquals(true, service.validateCardExpiry(payment2));
		LOGGER.info("ValidateCardExpiry() Tested");

	}
}