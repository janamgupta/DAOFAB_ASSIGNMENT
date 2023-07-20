package com.transaction.model;

import java.util.List;

//Parent Transaction Model
public class ParentTransaction {
	private Integer id;
    private String sender;
    private String receiver;
    private Double totalAmount;
    // Getters and setters
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
    // Calculate and return the total paid amount for this parent transaction
    public Double getTotalPaidAmount(List<ChildTransaction> childTransactions) {
        return childTransactions.stream()
                .filter(child -> child.getParentId() == id)
                .mapToDouble(ChildTransaction::getPaidAmount)
                .sum();
    }
}
