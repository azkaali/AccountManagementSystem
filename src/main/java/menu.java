import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



class menu {
	private static final ArrayList<account> accounts = null;
	private static final account[] accountsArray = null;
	customer C1;
	double interestRate;
	int noOfAccounts=0;	
	account acc[]=new account[20];
	account account;
	Scanner sc=new Scanner(System.in); 
	public void menu()
	{
		
	}
	
	int menu(Scanner sc)
	{
		
	System.out.println("Welcome to Account Management System \n");
	System.out.println("1. Open a New Account, Close an Account.\n");
	System.out.println("2. Login to a specific account by providing the unique account number \n");
	System.out.println("3. Perform account operations  \n");
	System.out.println("3. a. Make Deposit \n");
	System.out.println("3. b. Make Withdrawal \n");
	System.out.println("3. c. Check balance \n");
	System.out.println("3. d. Print statement \n");
	System.out.println("3. e. Transfer amount \n");
	System.out.println("3. f. Calculate Zakat \n");
	System.out.println("3. g. Display all deductions \n");
	System.out.println("4. Specify the Interest Rate, applicable to all Saving Accounts \n");
	System.out.println("5. Display all account details, including the bank owner details \n");
	System.out.println("6. Display all accounts deductions along with account details \n");
	System.out.println("7. Exit \n");
	System.out.println(" NOTE: The system has no accounts right now, hence you must make one first \n");
	
	int option=sc.nextInt();
	
	switch(option) {
	
	case 1:
		System.out.println("a. Open a new account. \n b. Close an account.\n");
		String a=sc.next();
		switch(a)
		{
		case "a":
			account.write(account);
			newAccount(sc);
		break;
		case "b":
			System.out.println("Enter account number you wish to close\n");
			int ac=sc.nextInt();
			closeAccount(ac);
		}
		
		   
		break;
	case 2:
			findAccount(account.read());
		break;
	case 3:
			operationsMenu(sc);
		break;
	case 4:
		
		double ir=0;
		addInterest(ir);
		break;
	case 5:
		
		displayAllDetails();	
		break;
	case 6:
		displayAllDeductions();
		break;
	case 7:
		exit();
		break;
	}
	
	return option;
	}

	
	void choice()
	{
		
	}
	

	
	
	int accountTypes(Scanner sc)
	{
		System.out.println("Welcome to Account Menu \n");
		System.out.println("Select Account Type \n");
		System.out.println("1. Checkings account\n");
		System.out.println("2. Savings account\n");
		int selected = 0;
		
			 System.out.println("Select 1 or 2");
			 try {
   				 selected=sc.nextInt();
   			 }
   			 catch(Exception e) {
    			System.out.println("Please enter correct value");
   				System.out.println("Select 1 or 2");
   				selected=sc.nextInt();
   			 }
   		
		 return selected;
	}
	
	
	
	//1.
	account newAccount(Scanner sc)
	{
		System.out.println("Enter a 4 digit number which will be your account no \n");
			
		int accountNo = sc.nextInt();  
		System.out.println("Your account number is "+accountNo);
		
		
		int selected=accountTypes(sc);
		if(selected==1)
		{
			
			customer C1= new customer();
			System.out.println("1. Checkings account\n");
			System.out.println("Enter your name \n");
			String name=sc.nextLine();
			C1.setName(name);
			System.out.println("Enter your address \n");
			String address=sc.nextLine();
			C1.setAddress(address);
			System.out.println("Enter your phoneNo \n");
			String phoneNo=sc.nextLine();
			C1.setPhoneNo(phoneNo);
			
			//C1=new customer(name,address,phoneNo);
			System.out.println("Customer's details are "+C1.getName()+" "+C1.getAddress()+" "+C1.getPhoneNo());
			System.out.println("Enter today's date \n");
			String dateCreated;
			dateCreated=sc.nextLine();
			int balance;
			balance=sc.nextInt();
			account=new checkingsAccount(accountNo,balance,dateCreated,C1);
		}
		else 
		{
			System.out.println("2. Savings account\n");
			
			System.out.println("Enter your name \n");
			String name;
			name=sc.nextLine();
			System.out.println("Enter your address \n");
			String address;
			address=sc.nextLine();
			System.out.println("Enter your phoneNo \n");
			String phoneNo;
			phoneNo=sc.nextLine();
			customer C1=new customer();
			//C1=new customer(name,address,phoneNo);
			System.out.println("Enter today's date \n");
			String dateCreated;
			dateCreated=sc.nextLine();
			int balance;
			balance=sc.nextInt();
			
			account=new savingsAccount(accountNo,balance,dateCreated,C1);
		}
		account.write(account);
		return account;
	}
	//closing an account
	void closeAccount(int accno){
	      for(account b :accountsArray){
	          if (b.getAccountno() == accno){
	              account.searchAccount(accno);
	          }
	          
	      }
	      
	  }
	
	//2.
	void findAccount(ArrayList<account> accountsArray )
	{ 		
			int accountNo;
			accountNo=sc.nextInt();
			for(int i = 0; i <accountsArray.size(); i++)
			{
			         account a = (account)accountsArray.get(i);
			         if(a.accountNo==accountNo)
			         {
			        	 System.out.println("Login successful \n");
			         }
			         else
			         {
			        	 System.out.println("Login failed \n");
			         }
			    
			}
		 operationsMenu(sc);
	}
	
	//3.
	
	int operationsMenu(Scanner sc)
		{
			System.out.println("Welcome to Account Operations Menu \n");
			System.out.println("Select Operation \n");
			System.out.println("i. Make Deposit \n");
			System.out.println("ii. Make Withdrawal \n");
			System.out.println("iii. Check balance \n");
			System.out.println("iv. Print statement \n");
			System.out.println("v. Transfer amount \n");
			System.out.println("vi. Calculate Zakat \n");
			System.out.println("vii. Display all deductions \n");
			int selected;
                        selected=sc.nextInt();
			switch(selected){
                            case 1:
                                
                                System.out.println("Enter amount. ");
                                int amount=sc.nextInt();
                               if (account instanceof checkingsAccount){
                                checkingsAccount c = new checkingsAccount();
                                c = (checkingsAccount)account;
                                c.makeDeposit(amount);
                               }else {
                                savingsAccount c = new savingsAccount();
                                c = (savingsAccount)account;
                                c.makeDeposit(amount);  
                                }
                            break;
                            case 2:
                                System.out.println("Enter amount you want to withdraw. ");
                                int bal=(int) account.balance;
                                int am=sc.nextInt();
                                if (account instanceof checkingsAccount){
                                checkingsAccount c = new checkingsAccount();
                                c = (checkingsAccount)account;
                                c.makeWithdrawal(am,bal);
                               }else {
                                savingsAccount c = new savingsAccount();
                                c = (savingsAccount)account;
                               // c.makeWithdrawal(am);  
                                }
                            break;
                           
                            case 3:
                                System.out.println("Which account's balance do you wish to check? \n ");
                                String name=sc.nextLine();
                                if (account instanceof checkingsAccount){
                                checkingsAccount c = new checkingsAccount();
                                c = (checkingsAccount)account;
                                c.checkBalance();
                               }else {
                                savingsAccount c = new savingsAccount();
                                c = (savingsAccount)account;
                                c.checkBalance();
                                }
                            break;
                            
                            case 4:
                                System.out.println("Which account's bank statement do you wish to see? \n ");
                                String accname=sc.nextLine();
                                if (account instanceof checkingsAccount){
                                checkingsAccount c = new checkingsAccount();
                                c = (checkingsAccount)account;
                                c.printStatement();
                               }else {
                                savingsAccount c = new savingsAccount();
                                c = (savingsAccount)account;
                                c.printStatement();
                                }
                            break;
                            
                            case 5:
                                System.out.println("Enter the amount you wish to transfer? \n ");
                                int transAmount=sc.nextInt();
                                System.out.println("Enter the account no. where you wish to transfer? \n ");
                                int transAccount=sc.nextInt();
                                //if(transAccount==findAccount(accountNo))
                                if (account instanceof checkingsAccount){
                                checkingsAccount c = new checkingsAccount();
                                c = (checkingsAccount)account;
                                c.transferAmount(transAmount,transAccount);
                               }else {
                                savingsAccount c = new savingsAccount();
                                c = (savingsAccount)account;
                                c.transferAmount(transAmount,transAccount);
                                }
                            break;
                           
                            case 6:
                                System.out.println("Enter the account for which you wish to calculate Zakat? \n ");
                                int zakatAccount=sc.nextInt();
                              
                                if (account instanceof checkingsAccount){
                                System.out.println("Zakat is not deducted from checkings account \n");
                                
                               }else {
                                savingsAccount c = new savingsAccount();
                                
                                c = (savingsAccount)account;
                            
                                //c.calculateZakat();
                                
                               }
                            break;
                            
                            case 7:
                                System.out.println("Displaying all deductions, enter accountNo \n ");
                                int deductAccount=sc.nextInt();
                                int tax=sc.nextInt();
                                if (account instanceof checkingsAccount){
                                    checkingsAccount c = new checkingsAccount();
                                    c = (checkingsAccount)account;
                                    c.displayAllDeductions(deductAccount,tax);
                                   }else {
                                    savingsAccount c = new savingsAccount();
                                    c = (savingsAccount)account;
                                    //c.calculateZakat();
                                    //double zakat=c.calculateZakat(getInterestRate());
                                 
                                    //c.displayAllDeductions(c.calculateZakat());
                                    }
                            break;
                            
                        }
			return selected;
		}
		
	//4.
	boolean addInterest(double ir)
	{
		//System.out.println("Specify interest Rate \n");
		//double interestRate=sc.nextDouble();
		
		for(account n : accountsArray)
		{
			if(n instanceof savingsAccount && ir>0)
			{
				savingsAccount s =  ((savingsAccount)n);
                                s.addInterest(interestRate);
                               return true;
			}
			
				
		}
		//System.out.println("Successfully applied interest rate "+interestRate+" on all savings accounts \n");
		return false;
	
	
		
	}
	
	
	
	
	//5.
	void displayAllDetails()
	{
		account a = null;
		String s;
		Scanner sc=new Scanner(System.in);
		for(int i = 0; i <((List<account>) account).size(); i++)
		{
		        System.out.println("Printing all Details \n");
		        s=a.toString();		    
		}
		menu(sc);
	}
	
	//6. 
	void displayAllDeductions()
	{
		int tax=sc.nextInt();
		checkingsAccount c=null;
		savingsAccount s=null;
		String all;
		Scanner sc=new Scanner(System.in);
		for(int i = 0; i <((List<account>) account).size(); i++)
		{
			 System.out.println("Printing all Deductions of checkings Accounts \n");
		    all=c.displayAllDeductions(i,tax);
		     System.out.println("Printing all Deductions of savings Accounts \n");
		    all=s.displayAllDeductions(i);
		}
		
		menu(sc);
	}
	
	//7. 
	void exit()
	{
		System.out.println("System closed!");
	}


	
	
	
}
