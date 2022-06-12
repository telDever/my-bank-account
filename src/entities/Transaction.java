package entities;

import java.util.Date;

import enums.TransactionType;

public class Transaction {

	private TransactionType type;
	private double amount;
	private Date date;

	public Transaction(TransactionType type, double amount, Date date) {
		this.type = type;
		this.amount = amount;
		this.date = date;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
