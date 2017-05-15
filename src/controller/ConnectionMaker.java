package controller;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionMaker {
	public static Connection getConnection()
	{
		Connection con= null;
		try{
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/users";
		String user = "root";
		String password = "";
		Class.forName(driverName);
		con = DriverManager.getConnection(url, user, password);
		return con;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
}
