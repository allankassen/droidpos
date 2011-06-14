package com.android.dao;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

/**
 * Database helper class used to manage the creation and upgrading of your database. This class also usually provides
 * the DAOs used by the other classes.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	// name of the database file for your application -- change to something appropriate for your app
	private static final String DATABASE_NAME = "androidpos.db";
	// any time you make changes to your database objects, you may have to increase the database version
	private static final int DATABASE_VERSION = 1;

	// the DAO object we use to access the product table
	private Dao<Product, Integer> product = null;

	// the DAO object we use to access the category table
	private Dao<Category, Integer> category = null;
	

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	/**
	 * This is called when the database is first created. Usually you should call createTable statements here to create
	 * the tables that will store your data.
	 */
	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
		try {
			Log.i(DatabaseHelper.class.getName(), "onCreate");
			//DML database stuff
			TableUtils.dropTable(connectionSource, Category.class, true);
			TableUtils.createTable(connectionSource, Category.class);
			TableUtils.dropTable(connectionSource, Product.class, true);
			TableUtils.createTable(connectionSource, Product.class);
			TableUtils.createTable(connectionSource, TicketLines.class);
			TableUtils.createTable(connectionSource, Tickets.class);
			TableUtils.createTable(connectionSource, Payment.class);
			TableUtils.createTable(connectionSource, Receipt.class);
			// here we try inserting data in the on-create as a test
			Dao<Product, Integer> productDao = getProduct();
			Dao<Category, Integer> categoryDao = getCategory();
			
			//long millis = System.currentTimeMillis();
			// create some entries in the onCreate
			//create category
			Category category = new Category(1,"Test");
			categoryDao.create(category);
			Log.i(DatabaseHelper.class.getName(), "category id"+category.id);
			Product product = new Product(1,"TEST","TEST","TEST",1000, category);
			int code = productDao.create(product);
			Log.i(DatabaseHelper.class.getName(), "created new entries in onCreate: " + code);
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * This is called when your application is upgraded and it has a higher version number. This allows you to adjust
	 * the various data to match the new version number.
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
		try {
			Log.i(DatabaseHelper.class.getName(), "onUpgrade");
			TableUtils.dropTable(connectionSource, Product.class, true);
			// after we drop the old databases, we create the new ones
			onCreate(db, connectionSource);
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * Returns the Database Access Object (DAO) for our SimpleData class. It will create it or just give the cached
	 * value.
	 */
	public Dao<Product, Integer> getProduct() throws SQLException {
		if (product == null) {
			product = getDao(Product.class);
		}
		return product;
	}
	
	public Dao<Category, Integer> getCategory()throws SQLException{
		if (category == null) {
			category = getDao(Category.class);
		}
		return category;
	}
	

	/**
	 * Close the database connections and clear any cached DAOs.
	 */
	@Override
	public void close() {
		super.close();
		product = null;
	}
}
