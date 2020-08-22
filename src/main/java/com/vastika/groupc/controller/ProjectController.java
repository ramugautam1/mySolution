package com.vastika.groupc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vastika.groupc.model.Customer;
import com.vastika.groupc.service.ProjectService;
import com.vastika.groupc.service.ProjectServiceImpl;

public class ProjectController {

	ProjectService projectService = new ProjectServiceImpl();
	Customer customer = new Customer();

//---------------------------------BLOCK FOR OPENING NEW ACCOUNTS-----------------------------------------//	

	public void openAccount(Scanner scanner) {
		Customer customer = (Customer) getData(scanner);
		

		if (!doesExist(customer.getId())) {

			int pw = projectService.openAccount(customer);
			System.out.println("Account opened successfully. " + "Your initial password is [ " + pw + " ]."
					+ " Please Change your password ASAP to activate your account.");

		} else {
			System.out.println("!!!!!!!!!!Account already exits for this ID.!!!!!!!!!!");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		}

	}

	public Customer getData(Scanner scanner) {
		
		Customer tempCustomer = new Customer();
System.out.println("~~~~~~~~~~~~~~~~~Please provide the necesary info~~~~~~~~~~~~~~~~~~");

		System.out.println("Enter your id:");
		tempCustomer.setId(scanner.nextLong());

		scanner.nextLine();

		System.out.println("Enter your id type:");
		tempCustomer.setUnique_id_type(scanner.nextLine());
		System.out.println("Enter account name:");
		tempCustomer.setAccount_name(scanner.nextLine());
		System.out.println("Enter Address: ");
		tempCustomer.setAddress(scanner.nextLine());
		System.out.println("Enter Mobile No.:");
		tempCustomer.setMobile_no(scanner.nextLong());
		scanner.nextLine();
		
		System.out.println("\nProcessing......\n");
		
System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		return tempCustomer;
	}

//------------------------------------------------------------------------------------------------------------------------//	

	public boolean doesExist(long id) {
		return projectService.doesExist(id);
	}

//------------------------------------------------------------------------------------------------------------------------//	

	public void deposit(long id, Scanner scanner) {
		System.out.println("Enter the amount: ");
		double amount = scanner.nextDouble();

		if (amount > 0) {
			if (projectService.deposit(id, amount) >= 1) {
				System.out.println("Congratulations! Deposited successfully.");
			} else {
				System.out.println("We encountered an error. :(  Please try later.");
			}
		} else {
			System.out.println("You entered negative number. Exiting...");
		}

	}

//------------------------------------------------------------------------------------------------------------------------//	

	public void updateInfo(long id, Scanner scanner) {
		Customer customer= (Customer) getCustomer(id);
		
		if(customer!=null) {
			System.out.println("Enter what you want to change: \n Password | Address | Mobile No ");
				String choice = ("" + scanner.nextLine().charAt(0)).toLowerCase();
				switch(choice) {
				case "p":
					System.out.println("Enter new password: ");
					String pw= scanner.nextLine();
					customer.setPassword(pw);
					if(projectService.updateInfo(customer)>=1) {
						System.out.println("\n#############Password Updated.#############\n");
					}else {
						System.out.println("Error!!!");
					}
					break;
				case "a":
					System.out.println("Enter new address:");
					String ad= scanner.nextLine();
					customer.setAddress(ad);
					if(projectService.updateInfo(customer)>=1) {
						System.out.println("\n############Address Updated.###############\n");
					}else {
						System.out.println("Error!!!");
					}
					break;
				case "m":
					System.out.println("Enter new Mobile:");
					Long mo= scanner.nextLong();
					scanner.hasNextLine();
					if(projectService.updateInfo(customer)>=1) {
						System.out.println("\n############Mobile No. Updated.###########\n");
					}else {
						System.out.println("Error!!!");
					}
					break;
				default:
					System.out.println("wrong choice...");
					break;					
				}
		}


	
	}
	
	public Customer getCustomer(long id) {
		return projectService.getCustomer(id);
	}
	
	

//------------------------------------------------------------------------------------------------------------------------//	

	public void withdraw(long id, Scanner scanner) {
		System.out.println("Enter the amount: ");
		double amount = scanner.nextDouble();

		if (amount > 0) {
			if (projectService.withdraw(id, amount) >= 1) {
				System.out.println("\n\t\tCongratulations! Withdawl completed successfully.\n");
			} else {
				System.out.println("We encountered an error. :(  Please try later.");
			}
		} else {
			System.out.println("You entered negative number. Exiting...");
		}
	}

//------------------------------------------------------------------------------------------------------------------------//	

	public void checkBalance(long id) {
		double balanceOrError=projectService.checkBalance(id);
		if(!(balanceOrError<0)) {
			System.out.println("\n\t\tYour Balance is: "+ balanceOrError+"\n");
		}else {
			System.out.println("\nThere was an error. Please try again later.\n");
		}
	}

//------------------------------------------------------------------------------------------------------------------------//	

	public void getTransactions(long id) {
		// Ram
		// Get transactions of a particular customer
	//	List<Double> transactionList= new ArrayList<>(projectService.getTransactions(id));
		System.out.println("\n+++++++++++++++++++Under Construction+++++++++++++++++++++\n");

	}

//------------------------------------------------------------------------------------------------------------------------//	

	public boolean verifyCustomer(long id, String password) {
		// returns true if both id and id_type match in database. following is just for
		// testing
		System.out.println("\nattempting to verify...");
		return projectService.verifyCustomer(id, password);
	}

//------------------------------BLOCK FOR HANDLING EXISTING CUSTOMERS--------------------------------------//	

	public void serveCustomer(Scanner scanner) {
		ProjectController projectController = new ProjectController();
		System.out.println("Enter your ID to continue");
		long id = scanner.nextLong();
		scanner.nextLine();
		System.out.println("Enter your Password");
		String password = scanner.nextLine();

		if (projectController.verifyCustomer(id, password)) {

			boolean flag = true;
			while (flag) {

				printMenu();

				String choice = ("" + scanner.nextLine().charAt(0)).toLowerCase();

				switch (choice) {

				case "d":
					projectController.deposit(id, scanner);
					scanner.nextLine();
					break;

				case "w":
					projectController.withdraw(id, scanner);
					scanner.nextLine();
					break;

				case "c":
					projectController.checkBalance(id);
					break;

				case "u":
					projectController.updateInfo(id, scanner);
					break;

				case "t":
					projectController.getTransactions(id);
					break;

				case "q":
					flag = false;
					System.out.println("\n\t\t...Exiting...!");
					break;

				default:
					System.out.println("Wrong choice!");
					break;

				}
			}

		}else {
			System.out.println("\nID and Password didn't match. Try again later.\n");
		}
	}

	public static void printMenu() {
		System.out.println(" \n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~WHAT NEXT?~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("|          |          |               |             |                     |      |");
		System.out.println("| Deposit  | Withdraw | Check Balance | Update Info | Transaction-History | Quit |");
		System.out.println("|          |          |               |             |                     |      |");
		System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
//------------------------------------------------------------------------------------------------------------------------//	

}
