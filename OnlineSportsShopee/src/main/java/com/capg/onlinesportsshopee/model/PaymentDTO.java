package com.capg.onlinesportsshopee.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class PaymentDTO {
	
	private long paymentId;
	
	private String type;
	
	private String status;
	
	private CardDTO cardDTO;
	
	public PaymentDTO() {
		super();
	}

	public PaymentDTO(long paymentId, String type, String status,long id, String cardName, String cardNumber, LocalDate cardExpiry, int cvv) {
		super();
		this.paymentId = paymentId;
		this.type = type;
		this.status = status;
		this.cardDTO = new CardDTO (id,cardName,cardNumber,cardExpiry,cvv);
	}

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CardDTO getCard() {
		return cardDTO;
	}

	public void setCard(CardDTO cardDTO) {
		this.cardDTO = cardDTO;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", type=" + type + ", status=" + status + ", card=" + cardDTO + "]";
	}

}

