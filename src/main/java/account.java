import java.util.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

import java.io.*;

class account implements Serializable{
	protected int accountNo;
	protected double balance;
	protected double transactionAmount;
	protected String dateCreated;
    protected customer C1;

    account(int accountNo,int balance,String dateCreated,customer C1)
    {
    	this.accountNo=accountNo;
    	this.balance=balance;
    	this.dateCreated=dateCreated;
    	this.C1=C1;
    }
    account(int accountNo)
    {
    	
    }
    account()
    {
    	
    }
    int getAccountno()
    {
    	return accountNo;
    }
    void setAccountno(int accountNo)
    {
    	 this.accountNo=accountNo;
    }
    double getBalance()
    {
    	return balance;
    }
    void setBalance(double balance)
    {
    	this.balance=balance;
    }
    double getTransactionAmount()
    {
    	return transactionAmount;
    }
    void setTransactionAmount(double transactionAmount)
    {
    	this.transactionAmount=transactionAmount;
    }
    String getDateCreated()
    {
    	return dateCreated;
    }
    void setDateCreated(String dateCreated)
    {
    	this.dateCreated=dateCreated;
    }
    
    String checkBalance()
	{
			String s="Your remaining balance is " + getBalance();
			return s;
	}
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	LocalDateTime now = LocalDateTime.now(); 
	void printStatement()
	{
		System.out.println("Your account number is "+ getAccountno());
		System.out.println("Remaining balance is "+ getBalance() );
		System.out.println("Amount of transaction "+ getTransactionAmount());
		System.out.println("Dated "+ dtf.format(now));
		
	}
	boolean transferAmount(int amount,int accountNo2)
	{
	 if(amount>0)
	 {
		 //System.out.println("The amount "+amount+" is transferred to accountNo "+accountNo2 );
		 return true;
	     }
	 else
	 	{
	     //System.out.println("Something went wrong.");
	     return false;
		}
		
	}
	
	boolean makeDeposit(int amount)
	{
		if(amount>0)
		{
			//System.out.println("You wish to deposit "+amount);
			balance=balance+amount;
			System.out.println("Deposit successful\n");
			return true;
			//System.out.println("Your new balance is " +getBalance());
		}
		else
			System.out.println("Amount is negative, can't be deposited \n");
			return false;
			
	}
	
	public static ArrayList<account>read(){
		ArrayList<account> list = new ArrayList<account>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("acc.dat"));
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
            File f = new File("acc.dat");
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


	//abstract void makeDeposit(double amount);
	//abstract void makeWithdrawal(double amount);

    @Override
    public String toString() {
        return "account{" + "accountNo=" + accountNo + ", balance=" + balance + ", dateCreated=" + dateCreated + ", transactionAmount=" + transactionAmount + "name"+C1.getName() + "Address"+C1.getAddress()+"phone no"+C1.getPhoneNo();
    }
    


}
