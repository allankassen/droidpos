package com.android.dao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "category")
public class Category {
	@DatabaseField(generatedId = true)
	int id;
	@DatabaseField
	String name;
	
	/**
	 * use by ormlite
	 */
	public Category() {
		
	}

	/**
	 * @param id
	 * @param name
	 */
	public Category( int id ,String name) {
		this.id=id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	
	
	

}
