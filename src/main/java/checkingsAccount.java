
class checkingsAccount extends account {

	checkingsAccount(int accountNo, int balance, String dateCreated, customer C1) {
		super(accountNo, balance, dateCreated, C1);
		// TODO Auto-generated constructor stub
	}
	checkingsAccount()
	{
		super();
	}
	checkingsAccount(int accountNo)
	{
		super(accountNo);
		//this.transactionFee=transactionFee;
	}

	double transactionCount;
	
	
	//private static double transactionFee=10;
	
	
	int makeWithdrawal(int amount,int balance)  //specific based upon the type of account, using method overriding
	{
		if(amount<=balance)
		{
			//System.out.println("The amount you wish to withdraw is " +amount);
			balance=balance-amount;
			//balance-=transactionFee;
			return balance;
			//System.out.println("Your remaining balance is " +balance);
		}
		else
			//System.out.println("Zero amount cannot be withdrawn \n");
		return balance;
	}
	
	String displayAllDeductions(int accountNo, int tax)
	{
		//int tax=100;
		String s="The amount "+tax+" is deducted from accountNo "+accountNo ;
		return s;
	}
	
}
