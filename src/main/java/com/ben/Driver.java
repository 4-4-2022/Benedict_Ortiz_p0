package com.ben;

import java.util.ArrayList;
import java.util.Scanner;

import com.ben.model.Account;
import com.ben.model.Customer;
import com.ben.model.Employee;
import com.ben.model.User;
import com.ben.repository.CustomerListRepository;
import com.ben.repository.EmployeeListRepository;

public class Driver {
	
	
	
	public static void userMainPage() {
		System.out.println("you are in the main page of the user, you can buy stuff here");
	}
	
	public static void viewCustomerInfoByEmployee(CustomerListRepository customerListRepository) {
		
		for(Customer c: customerListRepository.getCustomerList()) {
			System.out.println("customer: " + c);
			for(Account a: c.getAccountList()) {
				System.out.println("accounts: " + a.getUserList());
				System.out.println("funds: " + a.getFunds());
				for(User u: a.getUserList()) {
					System.out.println("user's name " + u.getUserName());
				}
			}
		}
	}
	
	
	public static void employeePage(CustomerListRepository customerListRepository) {
		System.out.println("employees see all customers");
		
		Scanner scanner = new Scanner(System.in);

		boolean employeeInEmployeePage = true;
		while (employeeInEmployeePage) {
			System.out.println("type 1 to view customer info type 2 to cancel account of a customer");
			
			int employeePageAnswer = scanner.nextInt();
			switch(employeePageAnswer) {
			case 1:
				viewCustomerInfoByEmployee(customerListRepository);
				break;
			case 2:
				System.out.println("you cancel accounts of customers here");
				break;
			case 3:
				System.out.println("leaving employee main page");
				employeeInEmployeePage = false;
				break;
			}
			
			
		}

		
	}
	
	public static void loginPageEmployee(EmployeeListRepository employeeListRepository, CustomerListRepository customerListRepository) {
		

		for(Employee e: employeeListRepository.getEmployeeList()) {
			System.out.println(e);
			
		}
		
		System.out.println("test");

		Scanner scanner = new Scanner(System.in);

		boolean customerInLoginPage = true;
		while (customerInLoginPage) {
			System.out.println("welcome to the login FOR EMPLOYEES page, login with your username and password. type 1 to exit");
			String loginName = scanner.nextLine();
			if (loginName.equals("1")) {
				customerInLoginPage = false;
				break;
			}
				
			String loginPassword = scanner.nextLine();

			System.out.println(loginName + loginPassword);
			

			if (!employeeListRepository.getEmployeeList().isEmpty()) {
				for (Employee e : employeeListRepository.getEmployeeList()) {
					if (e.getEmployeeName().equalsIgnoreCase(loginName) && e.getEmployeePassword().equalsIgnoreCase(loginPassword)) {
						System.out.println("employee found. this is where employee stuff happens ");
						employeePage(customerListRepository);
						return;
					}
				}
			} else {
				System.out.println("list is empty, but should say user doesn't exist or password wrong");
			}
		}

	}
	
	
	
	public static void accountFundManagePageTransfer(Customer customer) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean isManagingAccountsAddRemove = true;
		while(isManagingAccountsAddRemove) {
			for(Account account : customer.getAccountList()) {
				System.out.println(account);
			}
			System.out.println("Enter the two accounts you want to transfer funds. The first fund, then the second fund to transfer to, type 1 to exit");
			String firstAccount = scanner.nextLine();
			if(firstAccount.equals("1")) {
				isManagingAccountsAddRemove = false;
				break;
			}
			String secondAccount = scanner.nextLine();
			
			System.out.println("you are transferring from " + firstAccount + " to " + secondAccount);
			System.out.println("how much do you want to transer?");
			
			int transferAmount = scanner.nextInt();
			
			for(Account a: customer.getAccountList()) {
				if(a.getAccountName().equalsIgnoreCase(firstAccount)) {
					a.setFunds(a.getFunds() - transferAmount);
					break;
				}
			}
			
			for(Account a: customer.getAccountList()) {
				if(a.getAccountName().equalsIgnoreCase(secondAccount)) {
					a.setFunds(a.getFunds() + transferAmount);
					break;
				}
			}
//			
//			for(Account a: customer.getAccountList()) {
//				System.out.println(a);
//			}
//			
			//eat new line from pressing enter after entering transfer amount
			scanner.nextLine();
			
		}
		
	}
	
	public static void addRemoveFundsPage(Account account) {
		Scanner scanner = new Scanner(System.in);
		
		boolean isManagingAccountsAddRemove = true;
		while(isManagingAccountsAddRemove) {
			System.out.println("this is how many funds " + account.getAccountName() + " has: "+ account.getFunds());
			System.out.println("type 1 to add funds type 2 to remove funds type 3 to exit");
			
			int addRemoveFundsPageAnswer = scanner.nextInt();
			switch(addRemoveFundsPageAnswer) {
			case 1:
				System.out.println("how much do you want to add?");
				int addFunds = scanner.nextInt();
				account.setFunds(account.getFunds() + addFunds);
				break;
			case 2:
				System.out.println("how much do you want to add?");
				int removeFunds = scanner.nextInt();
				account.setFunds(account.getFunds() - removeFunds);
				break;
			case 3:
				System.out.println("leaving the addremovefundspage");
				isManagingAccountsAddRemove = false;
				break;
			}
		
			
		}
	}
	
	public static void accountFundManagePageAddRemove(Customer customer) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean isManagingAccountsAddRemove = true;
		while(isManagingAccountsAddRemove) {
			
			System.out.println("enter the account you want to add or remove funds from");
			/*
			 * just prints accounts of users
			 */
			for(Account a: customer.getAccountList()) {
				System.out.println(a);
			}
			
			String accountChoiceAnswer = scanner.nextLine();
			
			/*
			 * TODO finish the account fund manage page
			 * Once the account is open, customers should be able to add funds, remove funds, and transfer funds between different accounts.
			 */
			for(Account a : customer.getAccountList()) {
				if(a.getAccountName().equalsIgnoreCase(accountChoiceAnswer)) {
					System.out.println("account fund ");
					System.out.println("the account is " + a);
					addRemoveFundsPage(a);
				}
			}
			
			isManagingAccountsAddRemove = false;
		}
		
		
		
		
	}
	
	
	public static void accountFundManagePage(Customer customer) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean isManagingAccounts = true;
		while(isManagingAccounts) {

			System.out.println("where account fund modication page would go, type 1 to add and remove funds in an account, type 2 to transfer funds between accounts, type 3 to exti");
			/*
			 * for loop just prints accounts of the chosen customer
			 */
			for(Account a : customer.getAccountList()) {
				System.out.println(a);
			}
			
			int accountFundManagePageAnswer = scanner.nextInt();
			
			switch(accountFundManagePageAnswer) {
			case 1:
				accountFundManagePageAddRemove(customer);
				break;
			case 2:
				accountFundManagePageTransfer(customer);
				break;
			case 3:
				System.out.println("exit");
				isManagingAccounts = false;
				break;
			}
			

			
		}
		
		System.out.println("left the while loop");
		
		
	}
	
	public static void addOtherUsersPageToAccount(Account account) {
		
		
		Scanner scanner = new Scanner(System.in);
		boolean customerAddingOtherUsersToAccount = true;
		while(customerAddingOtherUsersToAccount) {
			System.out.println("this is where you add other users to this account");
			
			System.out.println("enter the other users username this account. type 1 to exit");
			
			String otherUser = scanner.nextLine();
			if(otherUser.equals("1")) {
				customerAddingOtherUsersToAccount = false;
				break;
			}
			
			User temp = new User(otherUser, false);
			account.getUserList().add(temp);
			
			System.out.println("successfully added another user");

			System.out.println(account.getUserList());
			
			
			
		}
	}
	
	public static void userLoginPage(Account account) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		boolean customerInUserPage = true;
		while(customerInUserPage) {
			System.out.println("you've logged in the users login page, type the user you want to enter using the userName, type 1 to exit, type 2 to add other users");
			
			
			System.out.println("printing the userList of this Account");
			//------------- make this separate
			for(int i = 0; i < account.getUserList().size(); i++) {
				int n = i + 1;
				System.out.println(n + " " + account.getUserList().get(i));
			}
			//------------- 
			
			String userPageAnswer = scanner.nextLine();
			
			if(userPageAnswer.equals("1")) {
				customerInUserPage = false;
				break;
			} else if(userPageAnswer.equals("2")) {
				addOtherUsersPageToAccount(account);
			}
			
			
			for(User u: account.getUserList()) {
				if(u.getUserName().equalsIgnoreCase(userPageAnswer)) {
					System.out.println("user " + u.getUserName() + " found");
					userMainPage();
				}
//				} else {
//					System.out.println("user not found");
//					break;
//				}
			}

			
			

		}
		System.out.println("you hit this");
	}
	
	
	
	public static void accountLoginPage(Customer customer) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean isInAccountLoginPage = true;
		while(isInAccountLoginPage) {
			
			System.out.println("page where customers can login to their accounts, enter accountName and accountPw to login, type 1 to exit ");
			System.out.println("printing the accountList of the user");
			//------------- make this separate
			for(int i = 0; i < customer.getAccountList().size(); i++) {
				int n = i + 1;
				System.out.println(n + " " + customer.getAccountList().get(i));
			}
			//-------------
			/*
			 * TODO BUG entering empty lines is valid and will add to accountList of customer
			 * SOLUTION: code some input validation for empty lines
			 */
			String accountLoginUsernameAnswer = scanner.nextLine();
			if(accountLoginUsernameAnswer.equals("1")) {
				isInAccountLoginPage = false;
				break;
			}
			String accountLoginPasswordAnswer = scanner.nextLine();
			
			/*
			 * TODO add condition where if it's an account manager, goes to a page that can add funds, modify funds etc.
			 * not sure if this is needed. going to do this in another way. 
			 */
			
			
			if (!customer.getAccountList().isEmpty()) {
				for (Account a: customer.getAccountList()) {
					if (a.getAccountName().equalsIgnoreCase(accountLoginUsernameAnswer) && a.getAccountPassword().equalsIgnoreCase(accountLoginPasswordAnswer) && a.isAccountManager()) {
						System.out.println("this is where the accountmanager account page goes doesn't really do anything yet");
						break;
					} else if (a.getAccountName().equalsIgnoreCase(accountLoginUsernameAnswer) && a.getAccountPassword().equalsIgnoreCase(accountLoginPasswordAnswer)  && !a.isAccountManager()) {
						System.out.println("account " + a.getAccountName() + " found");
						userLoginPage(a);
						
						
					}
				}
			} else {
				System.out.println("accountlist is empty, but should say user doesn't exist or password wrong");
			}
			
			
		}
	}
	
	public static void accountRegisterPage(Customer customer) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		boolean isInAccountRegisterPage = true;
		while(isInAccountRegisterPage) {
			System.out.println("page where customers can add new accounts, enter an accountName, accountPw, and type yes if you want them to manage the account to register, or type 1 to exit. ");
			
			String accountRegisterUsername = scanner.nextLine();
			if(accountRegisterUsername.equals("1")) {
				break;
			}
			String accountRegisterPassword = scanner.nextLine();
			String isAccountManager = scanner.nextLine();
			
			
			/*
			 * FIXED
			 * BUG: wont work as intended, isAccountManagr not changing if yes or no. 
			 * SOLUTION: constructore didnt have the line this.isAccountManager = isAccountManager;
			 */
			if(isAccountManager.equalsIgnoreCase("yes")) {
				System.out.println("you said yes");
				Account tempAccount = new Account(accountRegisterUsername, accountRegisterPassword, true);
				customer.getAccountList().add(tempAccount);
			} else {
				Account tempAccount = new Account(accountRegisterUsername, accountRegisterPassword, false);
				customer.getAccountList().add(tempAccount);
			}
			
			
			System.out.println("success, you've added a new account");
			
		}
		
	}

	public static void accountMainPage(Customer customer) {
		
		Scanner scanner = new Scanner(System.in);

		boolean customerInAccountsPage = true;
		while(customerInAccountsPage) {
//			System.out.println("heres the list of accounts this customer has");
//			for(Account a : customer.getAccountList()) {
//				System.out.println(a);
//			}
			System.out.println("you've logged in, "+ customer.getCustomerName() +" you're in the account login page now, type 1 to login to an account, type 2 to register a new account, type 3 to modfiy funds between accounts, type 4 to exit");
//			System.out.println("printing the accountList of the user");
//			//------------- make this separate
//			for(int i = 0; i < customer.getAccountList().size(); i++) {
//				int n = i + 1;
//				System.out.println(n + " " + customer.getAccountList().get(i));
//			}
//			//-------------
			
			
			
//			String accountPageAnswer = scanner.nextLine();
			
			int accountPageAnswer = scanner.nextInt();
			
			switch(accountPageAnswer) {
			case 1:
				accountLoginPage(customer);
				break;
			case 2:
				accountRegisterPage(customer);
				break;
			case 3:
				accountFundManagePage(customer);
				break;
			case 4:
				System.out.println("you're exiting the accountMain page");
				customerInAccountsPage = false;
				break;
				
			}
			
			
			
//			if(accountPageAnswer.equals("1")) {
//				System.out.println("you exited the for loop in accountloginpage");
//				customerInAccountsPage = false;
//				break;
//			}
			
			
			String accountPagePassword = scanner.nextLine();
			
			
//			if (!customer.getAccountList().isEmpty()) {
//				for (Account a: customer.getAccountList()) {
//					if (a.getAccountName().equalsIgnoreCase(accountPageAnswer) && a.getAccountPassword().equalsIgnoreCase(accountPagePassword)) {
//						System.out.println("account " + a.getAccountName() + " found");
//						userLoginPage(a);
//					}
////					} else if (!a.getAccountName().equalsIgnoreCase(accountPageAnswer) && !a.getAccountPassword().equalsIgnoreCase(accountPagePassword)) {
////						System.out.println("account not found, enter another one");
////						break;
////						
////					}
//				}
//			} else {
//				System.out.println("accountlist is empty, but should say user doesn't exist or password wrong");
//			}
			
			

		}
	}
	


	public static void loginPage(CustomerListRepository customerListRepository) {
		
		/* FIXED
		 * BUG for some reason, customerListRepository.getCustomerList() is doublinng everytime
		 * SOLUTION: CustomerListRepository customerListRepository had to be inside while loop in main. Not outside. Or else
		 * a new CustomerListRepository would keep getting created 
		 */
//		System.out.println(customerListRepository.getCustomerList());
		for(Customer c: customerListRepository.getCustomerList()) {
			System.out.println(c);
			
		}
		
		System.out.println("test");

		Scanner scanner = new Scanner(System.in);

		boolean customerInLoginPage = true;
		while (customerInLoginPage) {
			System.out.println("welcome to the login page, login with your username and password. type 1 to exit");
			String loginName = scanner.nextLine();
			if (loginName.equals("1")) {
				customerInLoginPage = false;
				break;
			}
				
			String loginPassword = scanner.nextLine();

			System.out.println(loginName + loginPassword);
//			System.out.println(userList);
			

			if (!customerListRepository.getCustomerList().isEmpty()) {
				for (Customer c : customerListRepository.getCustomerList()) {
					if (c.getCustomerName().equalsIgnoreCase(loginName) && c.getCustomerPassword().equalsIgnoreCase(loginPassword)) {
//						System.out.println("user found. this is where accounts of user is shown. ");
						accountMainPage(c);
						return;
					}
//					} else if (!c.getUserName().equalsIgnoreCase(loginName) && !c.getUserPassword().equalsIgnoreCase(loginPassword)) {
//						System.out.println("user not found. try to enter credneitlas again ");
//						break;
//						
//					}
				}
			} else {
				System.out.println("list is empty, but should say user doesn't exist or password wrong");
			}
		}

	}

	public static void registerPage(CustomerListRepository customerListRepository) {
		
		for(Customer c: customerListRepository.getCustomerList()) {
			System.out.println(c);
		}

		Scanner scanner = new Scanner(System.in);

		boolean customerInRegisterPage = true;
		while (customerInRegisterPage) {
			System.out.println("welcome to the register page, register your username and password. type 1 to exit");
			String userName = scanner.nextLine();
			if (userName.equals("1"))
				break;
			String userPassword = scanner.nextLine();

			Customer temp = new Customer(userName, userPassword);
			customerListRepository.getCustomerList().add(temp);

			System.out.println("successfully registered");

			for(Customer c: customerListRepository.getCustomerList()) {
				System.out.println(c);
			}
//			System.out.println(CustomerListRepository.getCustomerList());

		}

//		scanner.close();
	}

	public static void main(String[] args) {
		System.out.println("hi");

		Scanner scanner = new Scanner(System.in);

		boolean customerInMainPage = true;
		while (customerInMainPage) {
			/*
			 * reason customerListRepository kept doubling was because everytime main ran, it would create a new CustomerListRepository Object.
			 * needs to be in while loop so only one instance at a time
			 */
			CustomerListRepository customerListRepository = new CustomerListRepository();
			EmployeeListRepository employeeListRepository = new EmployeeListRepository();
			
			System.out.println("welcome to the main customer page enter 1 to login, 2 to register, 3 to exit, 4 to print customerList, 5 for employee login");
			int mainPageAnswer = scanner.nextInt();

			switch (mainPageAnswer) {
			case 1:
				loginPage(customerListRepository);
				break;
			case 2:
				registerPage(customerListRepository);
				break;
			case 3:
				System.out.println("you typed 3, exit now");
				customerInMainPage = false;
				break;
			case 4:
				for(Customer customer: customerListRepository.getCustomerList()) {
					System.out.println(customer);
				}
			case 5:
				loginPageEmployee(employeeListRepository, customerListRepository);
				
			}
		}

		scanner.close();
		

	}

}
