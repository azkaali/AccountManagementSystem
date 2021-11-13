import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class MySQLCon {

	public static void main(String args[]) throws SQLException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver successfully loaded");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","1234");
			System.out.println("Connection Established");
			
			Statement st= con.createStatement();
			ResultSet rs=st.executeQuery("select * from class");
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString("name");
				System.out.println("ID:"+id+"Name:"+name);
			}
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver not loaded");
		}
		
		catch(SQLException e) {
			System.out.println("Connection Failed");
		}
		
	}
	

}
