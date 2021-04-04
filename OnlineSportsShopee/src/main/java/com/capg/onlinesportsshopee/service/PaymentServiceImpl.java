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
		if (paymentTemp.isEmpty() && validatePaymentType(payment)  && validatePaymentStatus(payment)  
				&& validateCardName(payment) && validateCvv(payment)  
			&& validateCardNumber(payment) && validateCardExpiry(payment) ) 
		{
			Payment addPayment = paymentRepository.save(payment);
			return PaymentUtil.convertToPaymentDto(addPayment);
		} else {
			throw new PaymentServiceException("Payment already exists or Enter the valid payment detials");
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
		if ( !paymentTemp.isEmpty() && validatePaymentStatus(payment) && validatePaymentStatus(payment)
				&&  validateCardName(payment) && validateCardNumber(payment) 
				&& validateCvv(payment) && validateCardExpiry(payment) ) {
			/*
			 * Payment newPayment = paymentRepository.findById(paymentId).orElse(null);
			 * newPayment.setPaymentId(payment.getPaymentId());
			 * newPayment.setType(payment.getType());
			 * newPayment.setStatus(payment.getStatus());
			 * newPayment.setCard(payment.getCard());
			 */
			Payment updatePayment = paymentRepository.save(payment);
			return PaymentUtil.convertToPaymentDto(updatePayment);
		} else {
			throw new PaymentServiceException("PaymentId not found or Enter validate update data");
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
		Pattern pattern = Pattern.compile("^[A-Za-z]*$"); 
		CharSequence cs= payment.getType();
		if (pattern.matcher(cs).matches()) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public  boolean validatePaymentStatus(Payment payment) {
		boolean flag = false;
		Pattern pattern = Pattern.compile("^[A-Za-z]*$");
		CharSequence cs= payment.getStatus();
		if (pattern.matcher(cs).matches()) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public  boolean validateCardName(Payment payment) {
		boolean flag = false;
		Pattern pattern = Pattern.compile("^[a-zA-Z ]*$");
		CharSequence cs= payment.getCard().getCardName();
		if (pattern.matcher(cs).matches()) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public  boolean validateCardNumber(Payment payment) {
		boolean flag = false;
		Pattern pattern = Pattern.compile("^[0-9]*$");
		CharSequence cs= payment.getCard().getCardNumber();
		if ((pattern.matcher(cs).matches()) && payment.getCard().getCardNumber().length() == 16) 
		{
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public boolean validateCvv(Payment payment) {
		boolean flag = false;
		if (payment.getCard().getCvv() != 0) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;

	}

	public  boolean validateCardExpiry(Payment payment) {
		boolean flag = false;
		if (payment.getCard().getCardExpiry().isAfter(LocalDate.now())) {
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
	
	
	/*
	 * public static boolean validateCardNumber2(Card card) {
	 * 
	 * boolean flag = false;
	 * 
	 * String regex = "^[0-9]&"; Pattern pattern = Pattern.compile(regex); if
	 * (pattern.matcher(card.getCardNumber()).matches() && card.getCardNumber() !=
	 * null || !card.getCardNumber().isEmpty()) { flag = true; } return flag; }
	 */
	 
}
