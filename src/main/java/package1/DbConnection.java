package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static Connection con;
	

	static
	{
		try
		{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						//System.out.println("Driver class loaded successfully...........");
						

						final String URL = "jdbc:oracle:thin:@localhost:1521";
						final String username = "meghana"; 
						final String password = "1234";
						
						
						con = DriverManager.getConnection(URL, username, password);
						//System.out.println("Establised connection successfully..........");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Failed to Load Driver class...........");
		}
		catch(SQLException e)
		{
			System.out.println("Failed......." + e);
		}
		
	}
	
	
	public static Connection getConnection() {
		return con;
	}

}

