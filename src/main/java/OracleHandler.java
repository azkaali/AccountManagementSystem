import java.sql.*;
import java.util.*;
 class OracleHandler {
		
		
	public void OracleDB (String str1,String str2,String str3)
		{
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver successfully loaded");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		System.out.println("Connection Established");
		
		//step3 create the statement object
		Statement stmt = con.createStatement();
		
		System.out.println("Account#  AccountType  Address  MobileNo  Name");
		//INSERTION
		String sql = "INSERT INTO account(acc_No, acc_Type, address, mob_No, name) VALUES(?,?,?,?,?)";
		
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, str1);
		statement.setString(2, str2);
		statement.setString(3, str3);
	
		int rowInserted = statement.executeUpdate();
		if (rowInserted > 0)
		{
			System.out.println("New account added successfully");
		}
		
		
		//step4 execute query	---> Display the table after insertion
		ResultSet rs = stmt.executeQuery("select * from account");
		
		while(rs.next())
		{
			String acc_No = rs.getString("acc_No");
			String acc_Type = rs.getString("acc_Type");
			String address = rs.getString("address");
			String mob_No = rs.getString("mob_No");
			String name = rs.getString("name");
			
			
			System.out.println(acc_No + "	 " + acc_Type + " 	" + address + " 	" + " 	" + mob_No + " 		" + name);
		}
		
		//DELETE QUERY
		/*String sql2 = "DELETE FROM student WHERE name=?";
		
		PreparedStatement statement2 = con.prepareStatement(sql2);
		statement2.setString(1, "Vara");
		
		int rowsdeleted = statement2.executeUpdate();
		
		if (rowsdeleted > 0)
		{
			System.out.println("A user was successfully deleted");
		}
		
		//step4 execute query	---> Display the table after deletion
		ResultSet rs2 = stmt.executeQuery("select * from student");
		
		while(rs2.next())
		{
			int id = rs2.getInt(1);
			String name = rs2.getString("name");
			
			System.out.println("ID: " + id + " Name: " + name);
		}*/
		
		
		//step5 close the connection
		con.close();
	}
	catch(ClassNotFoundException e) 
	{
		System.out.println("Driver not loaded");
	}
	
	catch(SQLException e) 
	{
		System.out.println("Connection Failed");
	}
	
	}
	


}
