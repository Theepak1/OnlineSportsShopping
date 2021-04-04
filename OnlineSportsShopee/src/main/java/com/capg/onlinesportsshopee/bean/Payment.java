package com.capg.onlinesportsshopee.bean;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "payment" )
public class Payment implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "paymentId")
	private long paymentId;
	
	@Column(name = "type")
	@NotBlank(message = "Payment type Should Not Be Blank")
	private String type;
	
	@Column(name = "status")
	@NotBlank(message = "Payment Status Should Not Be Blank")
	private String status;
	
	@ManyToOne(cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="card_id",referencedColumnName = "id",nullable = false)
	private Card card;
	
	public Payment() {
		super();
	}

	public Payment(long paymentId,String type, String status, long id,String cardName, String cardNumber, LocalDate cardExpiry, int cvv) {
		super();
		this.card = new Card(id,cardName,cardNumber,cardExpiry,cvv);
		this.paymentId=paymentId;
		this.type = type;
		this.status = status;
		
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

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", type=" + type + ", status=" + status + ", card=" + card + "]";
	}
}
