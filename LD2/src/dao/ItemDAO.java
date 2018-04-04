package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Core.Item;

public class ItemDAO 
{
	List<Item> list = new ArrayList<>();
	//String dburl = "jdbc:mysql://localhost:3306/dbName";
	//String user = "user id"; // root
	//String password = "password";

	
	public ItemDAO()
	{
		//list.add(new Item(1d,"King Shrimp", 20d, 300d));
		//list.add(new Item(2,"Salmon file", 12d, 1300d));
	}

	public List<Item> searchItems(String name) 
	{
		
		return list; // need to be changed
	}

	public List<Item> getAllItems()
	{
	
		return list;
	}
	
	public void addItem(Item newItem)
	{
		list.add(newItem);	
	}
	
	public static Connection getConnection() throws SQLException
	{
		try
		{
	//	String Driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/Items";
		String user = "Jonas";
	    String Password = "Cookie123**"; // I love cookies :3
		
		Connection conn = DriverManager.getConnection(url,user,Password);
		System.out.println("DB connected successfully!");
		
	/*	String query = "Select * from item";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);*/
		return conn;
		}
		catch(Exception e) {System.out.println(e);}
		return null;	
	}
	
	//26 skaidre bandyt i item sourc
	
/*	private Item convertRowToItem(ResultSet myRs) 
			throws SQLException 
	{
		   String Name = myRs.getString("Name");
		   Double Price = myRs.getDouble("Price");
		   Double Weight = myRs.getDouble("Weight");
		   int id = myRs.getInt("id");
		   
		   Item tempEmployee = 	new Item(id, Name, Price, Weight);
		   return tempEmployee;
		}*/
}
