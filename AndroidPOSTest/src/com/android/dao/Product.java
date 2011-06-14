package com.android.dao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "products")
public class Product {
	// id is generated by the database and set on the object automagically
	@DatabaseField(generatedId = true)
	int id;
	// reference is manage internally
	@DatabaseField(index = true)
	String reference;
	// SKU code
	@DatabaseField(index = true)
	String code;
	// the name of the product
	@DatabaseField
	String name;
	// the sell price
	@DatabaseField
	float pricesell;
	@DatabaseField(foreign=true)
	Category category;
	
	
	
	
	/**
	 * need by ormlite
	 */
	public Product() {
		
	}
	

	/**
	 * @param id
	 * @param reference
	 * @param code
	 * @param name
	 * @param pricesell
	 * @param category TODO
	 */
	public Product(int id, String reference, String code, String name,
			float pricesell, Category category) {
		super();
		this.id = id;
		this.reference = reference;
		this.code = code;
		this.name = name;
		this.pricesell = pricesell;
		this.category = category;
	}


	@Override
	public String toString() {
		return "ProductDAO [code=" + code + ", id=" + id + ", name=" + name
				+ ", pricesell=" + pricesell + ", reference=" + reference +  ", category=" + category + "]";
	}
	
	
	
	

}
