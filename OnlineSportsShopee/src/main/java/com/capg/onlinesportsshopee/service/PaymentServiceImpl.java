package com.capg.onlinesportsshopee.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.onlinesportsshopee.bean.Payment;
import com.capg.onlinesportsshopee.exceptions.PaymentServiceException;
import com.capg.onlinesportsshopee.model.PaymentDTO;
import com.capg.onlinesportsshopee.repo.IPaymentRepository;
import com.capg.onlinesportsshopee.util.PaymentUtil;

@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	IPaymentRepository paymentRepository;

	@Override
	public PaymentDTO addPayment(Payment payment) throws PaymentServiceException {
		Optional<Payment> paymentTemp = paymentRepository.findById(payment.getPaymentId());
		if (paymentTemp.isEmpty() && validatePaymentStatus(payment) && validatePaymentType(payment)
				&& validateCardName(payment) && validateCardNumber(payment) 
				&& validateCvv(payment) && validateCardExpiry(payment) ) 
		{
			Payment addPayment = paymentRepository.save(payment);
			return PaymentUtil.convertToPaymentDto(addPayment);
		} else {
			throw new PaymentServiceException("Payment already exists");
		}
	}

	@Override
	public PaymentDTO removePayment(long paymentId) throws PaymentServiceException {
		Optional<Payment> payment = paymentRepository.findById(paymentId);
		if (payment.isEmpty()) {
			throw new PaymentServiceException("paymentId does not exist to delete");
		} else {
			paymentRepository.delete(payment.get());
			return PaymentUtil.convertToPaymentDto(payment.get());
		}
	}

	@Override
	public PaymentDTO updatePayment(long paymentId, Payment payment) throws PaymentServiceException {
		Optional<Payment> paymentTemp = paymentRepository.findById(paymentId);
		if (!paymentTemp.isEmpty() && validatePaymentStatus(payment) && validatePaymentStatus(payment)
				&&  validateCardName(payment) && validateCardNumber(payment) 
				&& validateCvv(payment) && validateCardExpiry(payment) ) {
			Payment newPayment = paymentRepository.findById(paymentId).orElse(null);
			newPayment.setType(payment.getType());
			newPayment.setStatus(payment.getStatus());
			newPayment.setCard(payment.getCard());
			Payment updatePayment = paymentRepository.save(newPayment);
			return PaymentUtil.convertToPaymentDto(updatePayment);
		} else {
			throw new PaymentServiceException("PaymentId not found or Enter validate type and Status");
		}
	}

	@Override
	public PaymentDTO getPaymentDetails(long paymentId) throws PaymentServiceException {
		Optional<Payment> paymentTemp = paymentRepository.findById(paymentId);
		if (paymentTemp.isEmpty()) {
			throw new PaymentServiceException("PaymentId does not exist");
		} else {
			Payment getPayment = paymentRepository.findById(paymentId).orElse(null);
			return PaymentUtil.convertToPaymentDto(getPayment);
		}
	}

	@Override
	public List<PaymentDTO> getAllPaymentDetails() throws PaymentServiceException {
		List<Payment> paymentTemp = paymentRepository.findAll();
		if (paymentTemp.isEmpty()) {
			throw new PaymentServiceException("Payments not found");
		} else {
			List<Payment> getAllPayment = paymentRepository.findAll();
			return PaymentUtil.convertToPaymentDtoList(getAllPayment);
		}
	}

	public  boolean validatePaymentType(Payment payment) {
		boolean flag = false;
		if (Pattern.matches("^[A-Za-z]+$", payment.getType())) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public  boolean validatePaymentStatus(Payment payment) {
		boolean flag = false;
		if (Pattern.matches("^[A-Za-z]+$", payment.getStatus())) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public  boolean validateCardName(Payment payment) {
		boolean flag = false;
		if (payment.getCard().getCardName() != null && payment.getCard().getCardName().length() > 4) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public  boolean validateCardNumber(Payment payment) {
		boolean flag = false;
		if (payment.getCard().getCardNumber().length() == 16
				&& Pattern.matches("^[0-9]+&", payment.getCard().getCardNumber())) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public boolean validateCvv(Payment payment) {
		boolean flag = false;
		if (payment.getCard().getCvv() >= 100 && payment.getCard().getCvv() <= 999) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;

	}

	public  boolean validateCardExpiry(Payment payment) {
		boolean flag = false;
		if (payment.getCard().getCardExpiry() != null && payment.getCard().getCardExpiry().isAfter(LocalDate.now())) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	/*
	 * public static boolean validatePayment(Payment payment) { boolean flag =
	 * false; if ( payment.getType().contentEquals("") ||
	 * payment.getType().contentEquals("card") &&
	 * payment.getStatus().contentEquals("Success") ||
	 * payment.getStatus().contentEquals("Pending") ||
	 * payment.getStatus().contentEquals("success") ||
	 * payment.getStatus().contentEquals("pending")) { flag = true; } else { flag =
	 * false; } return flag; }
	 * 
	 * public static boolean validatePaymentType(Payment payment) { boolean flag =
	 * false; if (payment.getType().contentEquals("Card") ||
	 * payment.getType().contentEquals("card") ) { flag = true; } else { flag =
	 * false; } return flag; }
	 * 
	 * public static boolean validatePaymentStatus(Payment payment) { boolean flag =
	 * false; if (payment.getStatus().contentEquals("Success") ||
	 * payment.getStatus().contentEquals("Pending") ||
	 * payment.getStatus().contentEquals("success") ||
	 * payment.getStatus().contentEquals("pending")) { flag = true; } else { flag =
	 * false; } return flag; }
	 */
}
