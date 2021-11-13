import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

class savingsAccount extends account implements Serializable {

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
	
	public static ArrayList<account>read(){
		ArrayList<account> list = new ArrayList<account>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("saving.txt"));
            while (true) {
                account obj = (account) input.readObject();
                list.add(obj); 
            }
        } catch (ClassNotFoundException e) {
        } catch (FileNotFoundException e) {
        } catch (EOFException e) {
        } catch (IOException e) {
        }
        return list;
	
	}
	
	

    public static void write(account s) {
        try {
            File f = new File("saving.txt");
            ObjectOutputStream oos;
            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f, true));
            }
            oos.writeObject(s);
            oos.close();

        } catch (FileNotFoundException e) {	
        } catch (EOFException e) {
        } catch (IOException e) {
        }
    }
    
    public static account searchAccount(int m) {
        ArrayList<account> list = read();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAccountno() == (m)) {
                return list.get(i);
            }

        }
        return null;

    }

	
	String displayAllDeductions(double zakat)
	{
		String s="Your deductions include Zakat, the amount is"+ zakat;
		return s;
	}
	
	
}
