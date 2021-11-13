import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class OracleCon {

	public static void main(String args[]) throws SQLException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver successfully loaded");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:azka","scott","1234");
			System.out.println("Connection Established");
			
			Statement st= con.createStatement();
			
			
			
			//INSERTION
			String sql = "INSERT INTO class(id, name) VALUES(?,?)";
			
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, 3);
			statement.setString(2, "Vara");
			
			int rowInserted = statement.executeUpdate();
			if (rowInserted > 0)
			{
				System.out.println("New student added successfully");
			}
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
