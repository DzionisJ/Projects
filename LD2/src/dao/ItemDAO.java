package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Core.Item;

public class ItemDAO 
{
	static List<Item> list = new ArrayList<>();
	
	public ItemDAO()
	{
		//list.add(new Item(1d,"King Shrimp", 20d, 300d));
		//list.add(new Item(2,"Salmon file", 12d, 1300d));
	}

	public List<Item> searchItems(String name)
	{
		return list; 
	}
	
	public static Connection getSpecificItems(String name) throws SQLException
	{
		try
		{
		String url = "jdbc:mysql://localhost:3306/Items";
		String user = "Jonas";
	    String Password = "Cookie123**"; // I love cookies :3
		
		Connection conn = DriverManager.getConnection(url,user,Password);
		System.out.println("DB connected successfully!");
		
		//String query = "Select * from item";
		String query = ("select * from Item where Name =" + "'" +name+ "'") ;
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next())
		{
			Item tempItem = convertRowToItem(rs);
		}
		return conn;
		}
		catch(Exception e) {System.out.println(e);}
		return null;	
	}

	public List<Item> getAllItems()
	{
		return list;
	}
	
	public void addItem(Item newItem) throws SQLException
	{

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String insertTableSQL = "INSERT INTO Item"
				+ "(Name, Price, Weight, ID) VALUES"
				+ "(?,?,?,?)";
		
		try {
			dbConnection = addtoSQL();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, newItem.getName());
			preparedStatement.setDouble(2, newItem.getPrice());
			preparedStatement.setDouble(3, newItem.getWeight());
			preparedStatement.setDouble(4, newItem.getID());

			// execute insert SQL stetement
			preparedStatement.executeUpdate();
			
			
			Item tempitem= 	new Item(newItem.getID(),newItem.getName(), newItem.getPrice(),newItem.getWeight());
			list.add(tempitem);
			   
			System.out.println("New Item is inserted into Item table Successfully !");

		} catch (SQLException e)
		{

			System.out.println(e.getMessage());

		} finally 
		{

			if (preparedStatement != null) 
			{
				preparedStatement.close();
			}

			if (dbConnection != null) 
			{
				dbConnection.close();
			}

		}
	}
	
	public static Connection addtoSQL() throws SQLException
	{
		try
		{
		String url = "jdbc:mysql://localhost:3306/Items";
		String user = "Jonas";
	    String Password = "Cookie123**"; // I love cookies :3
		
		Connection conn = DriverManager.getConnection(url,user,Password);
		//System.out.println("DB connected successfully!");

		return conn;
		}
		catch(Exception e) {System.out.println(e);}
		return null;	
	}
	
	public static Connection getConnection() throws SQLException
	{
		try
		{
		String url = "jdbc:mysql://localhost:3306/Items";
		String user = "Jonas";
	    String Password = "Cookie123**"; // I love cookies :3
		
		Connection conn = DriverManager.getConnection(url,user,Password);
		System.out.println("DB connected successfully!");
		
		String query = "Select * from item";
		//String query = ("select * from Item where Name =" + "'" + "Frozen Cherries" + "'") ;
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next())
		{
			Item tempItem = convertRowToItem(rs);
		}
		return conn;
		}
		catch(Exception e) {System.out.println(e);}
		return null;	
	}
	
	private static Item convertRowToItem(ResultSet myRs) throws SQLException 
	{
	
		   String Name = myRs.getString("Name");
		   Double Price = myRs.getDouble("Price");
		   Double Weight = myRs.getDouble("Weight");
		   int id = myRs.getInt("id");
		   
		   Item tempitem= 	new Item(id, Name, Price, Weight);
		
		   list.add(tempitem);
		   return tempitem;
	}
	
}
