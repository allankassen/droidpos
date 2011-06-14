package com.android.dao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "payment")
public class Payment {
	@DatabaseField(generatedId = true)
	int id;
	@DatabaseField
	String type;
	@DatabaseField(canBeNull=false)
	float montant;
	
	/**
	 * use by ormlite 
	 */
	public Payment() {
	}

	/**
	 * @param type
	 * @param montant
	 */
	public Payment(String type, float montant) {
		this.type = type;
		this.montant = montant;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", montant=" + montant + ", type=" + type
				+ "]";
	}
	
	
	
	
	
	

}
