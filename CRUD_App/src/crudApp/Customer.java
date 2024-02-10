package crudApp;

public class Customer {
	private int id;
	private String name;
	private String product;
	private int price;
	
	public Customer(int id, String name, String product, int price) {
		this.id = id;
		this.name = name;
		this.product = product;
		this.price = price;
	}
	
	public int getId() {return id;}
	public String getName() {return name;}
	public String getProduct() {return product;}
	public int getPrice() {return price;}
	
	public String toString() {
		return "Customer [id = " + id + " | name = " + name + " | product = " + product + " | price = " + price + "]\n--------------------------------------------------------------------------" ;	
	}
	
}
