import java.io.IOException;
import java.util.Scanner;

public class DBMenu {

	void menu() throws IOException{
		System.out.println("Where do you wish to store your data?");
		System.out.println("1. Files\n 2. Oracle Database\n 3. MySQL Database");
		Scanner sc = null;
		int choice=sc.nextInt();
		if(choice==1)
		{
			MyObjectOutputStream f=new MyObjectOutputStream();
		}
		if(choice==2)
		{
			OracleCon oc=new OracleCon();
		}
		if(choice==3)
		{
			MySQLCon mc=new MySQLCon();
		}
	}
}
