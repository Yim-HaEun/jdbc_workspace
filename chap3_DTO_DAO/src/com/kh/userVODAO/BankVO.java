package com.kh.userVODAO;

import java.util.Date;

/*
 * account_id
 * account_number
 * account_name
 * balance
 * branch_name
 * last_transaction_date
 * */
public class BankVO {
	private int account_id;
	private String account_number;
	private String account_name;
	private double balance;
	private String branch_name;
	private Date last_transaction_date;
	
	
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public Date getLast_transaction_date() {
		return last_transaction_date;
	}
	public void setLast_transaction_date(Date last_transaction_date) {
		this.last_transaction_date = last_transaction_date;
	}
	
	
	

}
