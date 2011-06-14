package com.android.dao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "tickets")
public class Tickets {
	@DatabaseField(generatedId = true)
	int id;
	@DatabaseField(unique=true)
	int ticket_number;
	@DatabaseField
	String salesperson;
	@DatabaseField
	String customer;
	@DatabaseField
	String status;
	@DatabaseField
	String discount_name;
	@DatabaseField
	String discount_value;
	
	
	/**
	 * use by ormlite
	 */
	public Tickets() {
		
	}


	/**
	 * @param salesperson
	 * @param customer
	 * @param status
	 * @param discountName
	 * @param discountValue
	 */
	public Tickets(String salesperson, String customer, String status,
			String discountName, String discountValue) {
		super();
		this.salesperson = salesperson;
		this.customer = customer;
		this.status = status;
		discount_name = discountName;
		discount_value = discountValue;
	}


	@Override
	public String toString() {
		return "Tickets [customer=" + customer + ", discount_name="
				+ discount_name + ", discount_value=" + discount_value
				+ ", id=" + id + ", salesperson=" + salesperson + ", status="
				+ status + ", ticket_number=" + ticket_number + "]";
	}
	
	
	
	
	
	

}
