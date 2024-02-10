package crudApp;

public class Query {
	// All SQL queries are here
	static String insert = "INSERT INTO customer (id, name, product, price) VALUES (?,?,?,?)";
	static String update = "UPDATE customer SET name = ? WHERE id = ?";
	static String delete = "DELETE FROM customer WHERE id = ?";
	static String select = "SELECT * FROM customer";
	static String selectID = "SELECT * FROM customer WHERE id = ?";
}
