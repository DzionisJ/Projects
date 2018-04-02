package dao;

import java.util.ArrayList;
import java.util.List;

import Core.Item;

public class ItemDAO 
{
	List<Item> list = new ArrayList<>();
	
	public ItemDAO()
	{
		list.add(new Item("King Shrimp", 20d, 300d));
		list.add(new Item("Salmon file", 12d, 1300d));
	}

	public List<Item> searchItems(String name) 
	{
		// TODO Auto-generated method stub
		return list;
	}

	public List<Item> getAllItems()
	{
		// TODO Auto-generated method stub
		return list;
	}
	
	public void addItem(Item newItem)
	{
		list.add(newItem);	
	}
}
