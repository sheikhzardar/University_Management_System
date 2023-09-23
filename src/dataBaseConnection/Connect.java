package dataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect
{
	public Connection connect()
	{
		Connection con=null;
		try 
		{
			// 1. Loading the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. Making a Connection
			final String connect="jdbc:mysql://localhost:3306/universitymanagementsystem";
			final String sqluserid="root";
			final String sqlpassword="123Alpha@beta";
			con = DriverManager.getConnection(connect,sqluserid,sqlpassword);
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		return con;
	}
	
}
