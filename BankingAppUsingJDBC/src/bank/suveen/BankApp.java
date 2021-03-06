package bank.suveen;

import java.util.ArrayList;
import java.util.Scanner;

public class BankApp {
	public static void main(String[] args) {
		CustomerManager customerManager = new CustomerManager();
		ArrayList<Customer> customersList = new ArrayList<Customer>();
		String name;
		int id, choice, trId;
		double balance, amount;
		Customer cust = null, transferee = null;
		Scanner sc = new Scanner(System.in);

		do {

			System.out.println("1. Add Customer");
			System.out.println("2. Display Customer");
			System.out.println("3. Display All Customers");
			System.out.println("4. Deposit");
			System.out.println("5. Withdraw");
			System.out.println("6. Transfer");
			System.out.println("7. Exit");
			System.out.println("Enter your choice :");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter your name :");
				sc.nextLine();
				name = sc.nextLine();
				System.out.println("Enter balance :");
				balance = sc.nextDouble();
				if(balance <= 0) {
					System.out.println("Incorrect balance... Enter positive balance again..");
					balance = sc.nextDouble();
				}
				id = customerManager.addCustomer(name, balance);
				if (id != -1)
					System.out.println("Transaction Success with id :" + id);
				else
					System.out.println("Adding failed!");
				System.out.println("-----------------------------");
				break;
			case 2:
				System.out.println("Enter id to display :");
				id = sc.nextInt();
				cust = customerManager.displayCustomer(id);
				if (cust != null)
					System.out.println(cust);
				else
					System.out.println("No Record found...");
				System.out.println("-----------------------------");
				break;
			case 3:
				customersList = customerManager.getAllCustomers();
				if (!customersList.isEmpty())
					for (Customer customer : customersList) {
						System.out.println("-----------------------------");
						System.out.println("id \t\t: " + customer.getId());
						System.out.println("name \t\t: " + customer.getName());
						System.out.println("balance \t: " + customer.getBalance());
						System.out.println("-----------------------------");
					}
				else {
					System.out.println("No customers found...");
					System.out.println("-----------------------------");
				}
				break;
			case 4:
				System.out.println("Enter id to deposit");
				id = sc.nextInt();
				cust = customerManager.displayCustomer(id);
				if (cust != null) {
					System.out.println("Enter amount to be deposited into " + cust.getName() + " account : ");
					amount = sc.nextDouble();
					if(amount <= 0) {
						System.out.println("Incorrect amount... Enter positive amount again..");
						amount = sc.nextDouble();
					}
					cust = customerManager.depositAmount(cust, amount);
					System.out.println("Amount deposited into account of " + cust.getName() + " updated balance : "
							+ cust.getBalance());
					System.out.println(cust);
				} else
					System.out.println("No Record found...");
				System.out.println("-----------------------------");
				break;
			case 5:
				System.out.println("Enter id to withdraw");
				id = sc.nextInt();
				cust = customerManager.displayCustomer(id);
				if (cust != null) {
					System.out.println("Enter amount to be withdrawn from " + cust.getName() + " account : ");
					amount = sc.nextDouble();
					if(amount <= 0) {
						System.out.println("Incorrect amount... Enter positive amount again..");
						amount = sc.nextDouble();
					}
					cust = customerManager.withdrawAmount(cust, amount);
					if (cust != null) {
						System.out.println("Amount withdraw from account of " + cust.getName() + " successful. Updated balance : "
								+ cust.getBalance());
						System.out.println(cust);
					} else
						System.out.println("Insufficient balance...");
				} else
					System.out.println("No Record found...");
				System.out.println("-----------------------------");
				break;
				case 6:
					System.out.println("Enter your account id :");
					id = sc.nextInt();
					cust = customerManager.displayCustomer(id);
					if (cust != null) {
						System.out.println("Welcome " + cust.getName() + ". Enter the id of transferee : ");
						trId = sc.nextInt();
						transferee = customerManager.displayCustomer(trId);
						if (transferee != null) {
							System.out.println("Enter amount to be transferred to " + transferee.getName() + " account : ");
							amount = sc.nextDouble();
							if(amount <= 0) {
								System.out.println("Incorrect amount... Enter positive amount again..");
								amount = sc.nextDouble();
							}
							System.out.println(customerManager.transferAmount(cust, transferee, amount));
						} else {
							System.out.println("Transfer id not found!");
						}
					} else {
						System.out.println("Customer id not found, Try again!");
					}
					break;
				case 7:
					break;
				default:
					System.out.println("Invalid input... try again!");
					System.out.println("-----------------------------");

			}
		} while (choice != 7);
		System.out.println("Thank you!");
	}
}
