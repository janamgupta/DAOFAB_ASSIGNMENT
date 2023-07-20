package com.transaction.model;

//Parent Transaction DTO
public class ParentTransactionDTO {
	private Integer id;
    private String sender;
    private String receiver;
    private Double totalAmount;
    private Double totalPaidAmount;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Double getTotalPaidAmount() {
		return totalPaidAmount;
	}
	public void setTotalPaidAmount(Double totalPaidAmount) {
		this.totalPaidAmount = totalPaidAmount;
	}
	public ParentTransactionDTO(Integer id, String sender, String receiver, Double totalAmount,
			Double totalPaidAmount) {
		super();
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.totalAmount = totalAmount;
		this.totalPaidAmount = totalPaidAmount;
	}
	public ParentTransactionDTO() {
		super();
	}
}
