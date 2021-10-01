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

class checkingsAccount extends account implements Serializable {

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
	public static ArrayList<account>read(){
		ArrayList<account> list = new ArrayList<account>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("checking.dat"));
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
	
	

    public static void writeCity(account s) {
        try {
            File f = new File("checking.dat");
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

	
	
	
}
