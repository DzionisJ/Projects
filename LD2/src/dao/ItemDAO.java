package dao;

import java.util.ArrayList;
import java.util.List;

import Core.Item;

public class ItemDAO 
{
	List<Item> list = new ArrayList<>();
	
	public ItemDAO()
	{
		list.add(new Item("King Shrimp", 20, 300));
		list.add(new Item("Salmon file", 12, 1300));
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
}
