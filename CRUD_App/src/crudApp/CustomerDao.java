package crudApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDao {
	// Function for creating data - insert
	public static void createCustomer(Customer customer) throws SQLException {
		Connection con = DB.connect();
		String query = Query.insert;
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setInt(1, customer.getId());
		pstm.setString(2, customer.getName());
		pstm.setString(3, customer.getProduct());
		pstm.setInt(4, customer.getPrice());
		
		System.out.println("\nps = " + pstm +"\n" + customer + "\n");
		pstm.executeUpdate();
		pstm.close();
	}
	
	// Function for updating name of data using id
	public static void updateCustomer(int id, String name) throws SQLException {
		Connection con = DB.connect();
		String query = Query.update;
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setInt(2, id);
		pstm.setString(1, name);
		System.out.println("\nps = " + pstm + "\n");
		pstm.executeUpdate();
		pstm.close();
	}
	
	// Function for reading whole table
	public static ArrayList<Customer> readAllCustomer() throws SQLException {
		ArrayList<Customer> cstList = new ArrayList<Customer>();
		Connection con = DB.connect();
		String query = Query.select;
		Statement stm = con.prepareStatement(query);
		System.out.println("\nst = " + stm + "\n");
		System.out.println("\n--------------------------------------------------------------------------");
		ResultSet rs = stm.executeQuery(query);
		 while(rs.next()) {
			 Customer cst = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			 cstList.add(cst);
		 }
		 stm.close();
		 return cstList;
	}
	
	// Function for read specific data using id
		public static void readOneCustomer(int id) throws SQLException {
		    Connection con = DB.connect();
		    String query = Query.selectID;
		    PreparedStatement pstm = con.prepareStatement(query);
		    pstm.setInt(1, id);
		    System.out.println("\nps = " + pstm + "\n");
		    ResultSet rs = pstm.executeQuery();
		    if (rs.next()) {
		        Customer cst = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("product"), rs.getInt("price"));
		        System.out.println(cst);
		    } else {
		        System.out.println("Customer with id " + id + " not found.");
		    }
		    pstm.close();
		}
	
	// function for delete specific data
	public static void deleteCustomer(int id) throws SQLException {
	    Connection con = DB.connect();
	 // Use the select query to check if the ID exists
	    String querySelect = Query.selectID;  
	    PreparedStatement pstmSelect = con.prepareStatement(querySelect);
	    pstmSelect.setInt(1, id);
	    ResultSet rs = pstmSelect.executeQuery();
	    if (rs.next()) {
	        // ID exists, proceed with deletion
	        String queryDelete = Query.delete;
	        PreparedStatement pstmDelete = con.prepareStatement(queryDelete);
	        pstmDelete.setInt(1, id);
	        System.out.println("\nps = " + pstmDelete + "\n");
	        System.out.println("Data Deleted Successfully! ID = " + id);
	        pstmDelete.executeUpdate();
	        pstmDelete.close();
	    } else {
	        // ID does not exist, display a message
	        System.out.println("Data with ID " + id + " not found. Deletion aborted.");
	    }
	    pstmSelect.close();
	    rs.close();
	}

}
