import java.io.IOException;
import java.util.Scanner;


public class DBMenu {

	void menu() throws IOException{
	      Scanner sc=new Scanner(System.in);

		System.out.println("Where do you wish to store your data?");
		System.out.println("1. Files\n2. Oracle Database\n3. MySQL Database");
		//Scanner sc = null;
		int choice=sc.nextInt();
		if(choice==1)
		{
			MyObjectOutputStream f=new MyObjectOutputStream();
		}
		if(choice==2)
		{
			customer oc= new customer();
			String strName = oc.getName();
			String strAddress = oc.getAddress();
			String strMobNo = oc.getPhoneNo();
			OracleHandler orcl=new OracleHandler();
			orcl.OracleDB(strName, strAddress, strMobNo);
		}
		if(choice==3)
		{
			//MySQLCon mc=new MySQLCon();
			customer ac= new customer();
			String strName = ac.getName();
			String strAddress = ac.getAddress();
			String strMobNo = ac.getPhoneNo();
			MySQLHandler sqlh = new MySQLHandler();
			sqlh.MySQLDB( strName, strAddress, strMobNo);
			
		}
	}
}
