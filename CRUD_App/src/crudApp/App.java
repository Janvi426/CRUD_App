package crudApp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws SQLException {
		int choice;
		do {
			System.out.println("\n================ > Customer Deatils < ================\n");
			System.out.println("1 = Create Data \t 2 = Read All Data \n3 = Read Specific Data \t 4 = Update Data(Name) \n5 = Delete Data \t 6 = Exit\n");
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
			
			if(choice < 1 || choice > 7) break;
			switch(choice) {
				case 1: System.out.println("Enter id, name, product, price");
						System.out.print("Enter id : ");
				        int id = sc.nextInt();
				        sc.nextLine();
				        System.out.print("Enter name : ");
				        String name = sc.nextLine();
				        System.out.print("Enter produnct name : ");
				        String product = sc.nextLine();
				        System.out.print("Enter price : ");
				        int price = sc.nextInt();
				        Customer cst = new Customer(id,name,product,price);
				        CustomerDao.createCustomer(cst);
				        break;
				        
				case 2: ArrayList<Customer> List  = CustomerDao.readAllCustomer();
						for (Customer cst1 : List) {
							System.out.println(cst1);
						}
						break;
						
				case 3: System.out.print("Enter id : ");
						id = sc.nextInt();
						CustomerDao.readOneCustomer(id);
						break;
						
				case 4: System.out.print("Enter id : ");
						id = sc.nextInt();
						sc.nextLine();
						System.out.print("Enter updated name : ");
						name = sc.nextLine();
						CustomerDao.updateCustomer(id, name);
						break;
						
				case 5: System.out.print("Enter id : ");
						id = sc.nextInt();
						CustomerDao.deleteCustomer(id);
						break;
						
				case 6: System.out.println("\n------------------");
						System.out.println("Exit Successfully!");
						System.out.println("------------------");
						break;
			}
		}while(choice != 6);
	}

}
