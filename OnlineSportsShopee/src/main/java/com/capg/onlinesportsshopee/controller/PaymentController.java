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

/*
 * Author : SYED SAMSUDEEN A
 * Version : 1.0
 * Date : 05-04-2021
 * Description : This is Payment Controller
*/
@RestController
@RequestMapping("/api/oss")
public class PaymentController {
	
	@Autowired
	private IPaymentService paymentService;
	
	@PostMapping("/addPayment")
	public ResponseEntity<PaymentDTO> addPayment(@RequestBody Payment payment) {
		PaymentDTO addPayment = paymentService.addPayment(payment);
		return new ResponseEntity<PaymentDTO>(addPayment, HttpStatus.OK);
	}
	
	@DeleteMapping("/removePayment/{paymentId}")
	public ResponseEntity<PaymentDTO> removePayment(@PathVariable long paymentId)
	{
		PaymentDTO removePayment = paymentService.removePayment(paymentId);
		return new ResponseEntity<PaymentDTO>(removePayment,HttpStatus.OK);
	}
	
	@PutMapping("/updatePayment")
	public ResponseEntity<PaymentDTO> updatePayment(@RequestBody Payment payment) {
		PaymentDTO updatePayment = paymentService.updatePayment(payment.getPaymentId(), payment);
		return new ResponseEntity<PaymentDTO>(updatePayment, HttpStatus.OK);
	}
	
	@GetMapping("/getPaymentById/{paymentId}")
	public ResponseEntity<PaymentDTO> GetPaymentDetails(@PathVariable long paymentId) throws PaymentServiceException {
		PaymentDTO getByPaymentId = paymentService.getPaymentDetails(paymentId);
		return new ResponseEntity<PaymentDTO>(getByPaymentId, HttpStatus.OK);
	}
	
	@GetMapping("/getAllPayment")
	public ResponseEntity<List<PaymentDTO>> getAllPayment() {
		List<PaymentDTO> getAllPayment = paymentService.getAllPaymentDetails();
		return new ResponseEntity<List<PaymentDTO>>(getAllPayment, HttpStatus.OK);
	}
	

}