package com.android.dao;

import java.util.Date;

import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;

@DatabaseTable(tableName = "receipt")
public class Receipt {
	@DatabaseField(foreign=true)
	Tickets ticket;
	@DatabaseField(foreign=true)
	Payment payment;
	@DatabaseField(canBeNull=false)
	Date date_new;
	

}
