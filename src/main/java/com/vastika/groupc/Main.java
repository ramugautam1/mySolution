package com.vastika.groupc;

import java.util.Scanner;

import com.vastika.groupc.controller.ProjectController;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ProjectController pController = new ProjectController();

		while (true) {
			System.out.println("\n\n-------------------Select option to proceed--------------------------");
			System.out.println("    1---> Open Account\t\t|\t2---> Already have an account  ");
				System.out.println("---------------------------------------------------------------------");
			int selection = scanner.nextInt();
			scanner.nextLine();
			
			switch (selection) {	
			
			case 1:				
				pController.openAccount(scanner);
				break;

			case 2:
				pController.serveCustomer(scanner);
				break;
				
			default:
				System.out.println("wrong choice !!!");
				break;
			}
		}

	}



}
