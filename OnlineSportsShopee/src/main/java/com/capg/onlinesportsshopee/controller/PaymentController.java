package com.capg.onlinesportsshopee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.onlinesportsshopee.bean.Payment;
import com.capg.onlinesportsshopee.exceptions.PaymentServiceException;
import com.capg.onlinesportsshopee.model.PaymentDTO;
import com.capg.onlinesportsshopee.service.IPaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	
	@Autowired
	IPaymentService paymentService;
	
	@PostMapping("/addPayment")
	public ResponseEntity<PaymentDTO> addPayment(@RequestBody Payment payment) {
		PaymentDTO resultpayment = paymentService.addPayment(payment);
		return new ResponseEntity<PaymentDTO>(resultpayment, HttpStatus.OK);
	}
	
	@DeleteMapping("/removePayment/{paymentId}")
	public PaymentDTO removePayment(@PathVariable long paymentId) throws PaymentServiceException {
		return paymentService.removePayment(paymentId);
	}
	
	@PutMapping("/updatePayment")
	public ResponseEntity<PaymentDTO> updatePayment(@RequestBody Payment payment) {
		PaymentDTO resultPayment = paymentService.updatePayment(payment.getPaymentId(), payment);
		return new ResponseEntity<PaymentDTO>(resultPayment, HttpStatus.OK);
	}
	
	@GetMapping("/getPaymentDetails/{paymentId}")
	public ResponseEntity<PaymentDTO> GetPaymentDetails(@PathVariable long paymentId) throws PaymentServiceException {
		PaymentDTO resultPayment = paymentService.getPaymentDetails(paymentId);
		return new ResponseEntity<PaymentDTO>(resultPayment, HttpStatus.OK);
	}
	
	@GetMapping("/getAllPaymentDetails")
	public ResponseEntity<List<PaymentDTO>> getAllPayment() {
		List<PaymentDTO> resultPayment = paymentService.getAllPaymentDetails();
		return new ResponseEntity<List<PaymentDTO>>(resultPayment, HttpStatus.OK);
	}
	

}

