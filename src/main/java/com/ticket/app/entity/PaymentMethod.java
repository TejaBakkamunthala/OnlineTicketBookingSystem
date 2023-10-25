package com.ticket.app.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "paymentmethods",schema="otbsystem")
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_method_id")
    private int paymentMethodId;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "booking_id",referencedColumnName = "booking_id")
    private Booking booking;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "amount")
    private float amount;

    @Column(name = "transaction_time")
    private Date transactionTime;

    @Column(name = "status")
    private String status;

	public int getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(int paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PaymentMethod(int paymentMethodId, User user, Booking booking, String paymentType, float amount,
			Date transactionTime, String status) {
		super();
		this.paymentMethodId = paymentMethodId;
		this.user = user;
		this.booking = booking;
		this.paymentType = paymentType;
		this.amount = amount;
		this.transactionTime = transactionTime;
		this.status = status;
	}

	@Override
	public String toString() {
		return "PaymentMethod [paymentMethodId=" + paymentMethodId + ", user=" + user + ", booking=" + booking
				+ ", paymentType=" + paymentType + ", amount=" + amount + ", transactionTime=" + transactionTime
				+ ", status=" + status + "]";
	}

	public PaymentMethod() {
		super();
	}

	
}
