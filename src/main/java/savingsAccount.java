
class savingsAccount extends account {

	double interestRate;
	double interest;
	
	savingsAccount(int accountNo, int balance, String dateCreated, customer C1) {
		super(accountNo, balance, dateCreated,  C1);
		// TODO Auto-generated constructor stub
	}

	savingsAccount()
	{
		super();
	}
	savingsAccount(int accountNo,double interestRate)
	{
		super(accountNo);
		this.interestRate=interestRate;
	}
	
	double getInterestRate()
	{
		return interestRate;
	}
	void setInterestRate(double interestRate)
	{
		this.interestRate=interestRate;
	}
	int calculateInterest(double interestRate, int balance)
	{
		double interest= (interestRate*balance)/100;
		return (int) interest;
	}
	
	boolean addInterest(double interestRate)
	{
		//System.out.println("The interest is "+interest);
		if(makeDeposit((int) interest)==true)
		return true;
		else
			return false;
	}
	
	private static int transactionFee=10;

	int makeWithdrawal(double amount,int balance)  //specific based upon the type of account, using method overriding
	{
		if(amount<=balance)
		{
			balance=(int) (balance-amount);
			return balance;
			//System.out.println("Your remaining balance is " +balance);
		}
		else
			//System.out.println("Zero amount cannot be withdrawn \n");
		return balance;
	}	
	int calculateZakat(int balance)
	{
		if(balance>=20000)
		{
			int zakat= (int) ((balance*2.5)/100);
			System.out.println("Your annualy payable Zakat is "+zakat);
			return zakat;
		}
		else
			System.out.println("You are not bound to pay Zakat yet \n");
		return -1;
	}
	
	String displayAllDeductions(double zakat)
	{
		String s="Your deductions include Zakat, the amount is"+ zakat;
		return s;
	}
	
	
}
