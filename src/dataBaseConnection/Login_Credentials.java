package dataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login_Credentials 
{
	public boolean check(String userid, String password) throws ClassNotFoundException, SQLException, Exception
	{
		//for storing the result upon execution of query
		ResultSet rs=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		try
		{
			// 1. Loading the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			// 2. Making a Connection
			final String connect="jdbc:mysql://localhost:3306/universitymanagementsystem";
			final String sqluserid="root";
			final String sqlpassword="123Alpha@beta";
		
			con = DriverManager.getConnection(connect,sqluserid,sqlpassword);
		
			// 3. Creating Statement
			final String statement = "SELECT userid FROM login WHERE userid = '"+userid+"' AND password = '"+password+"'";
			pstmt=con.prepareStatement(statement);
		
			// 4. Executing Query
			rs=pstmt.executeQuery();
			return rs.next();
		}
		finally
		{
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(con!=null)
				con.close();
		}
	}
}
