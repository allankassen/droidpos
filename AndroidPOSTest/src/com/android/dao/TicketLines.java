package com.android.dao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "ticketlines")
public class TicketLines {
	@DatabaseField(foreign=true)
	Tickets tickets ;
	@DatabaseField
	int lines;
	@DatabaseField(foreign=true)
	Product product;
	@DatabaseField
	Float unit;
	boolean isDiscount;
	@DatabaseField
	Float price;
	
	/**
	 * orm lite use it
	 */
	public TicketLines() {
		
	}

	/**
	 * @param tickets
	 * @param lines
	 * @param product
	 * @param unit
	 * @param isDiscount
	 * @param price
	 */
	public TicketLines(Tickets tickets, int lines, Product product, Float unit,
			boolean isDiscount, Float price) {
		this.tickets = tickets;
		this.lines = lines;
		this.product = product;
		this.unit = unit;
		this.isDiscount = isDiscount;
		this.price = price;
	}

	@Override
	public String toString() {
		return "TicketLines [isDiscount=" + isDiscount + ", lines=" + lines
				+ ", price=" + price + ", product=" + product + ", tickets="
				+ tickets + ", unit=" + unit + "]";
	}
	
	
	
	
	
	
	
	
	

}
