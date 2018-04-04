import java.util.List;

import javax.swing.table.AbstractTableModel;

import Core.Item;

public class ItemTableModel extends AbstractTableModel
{
	private static final int ITEM_ID = 0;
	private static final int ITEM_NAME_COL = 1;
	private static final int ITEM_PRICE_COL  = 2;
	private static final int ITEM_WEIGHT_COL  = 3;
	private List<Item> items;
	private String[] columnNames = {"ID", "Item Name", "Item Price/Kg", "Item Total Weight Kg"};

	@Override
	public int getColumnCount() 
	{
		return columnNames.length;
	}

	@Override
	public int getRowCount()
	{
		return items.size();
	}
	
	public ItemTableModel(List<Item> items)
	{
		super();
		this.items = items;
	}
	
	@Override
	public String getColumnName(int col)
	{
		return columnNames[col];
		
	}

	@Override
	public Object getValueAt(int row, int col) 
	{
		Item tempItem = items.get(row);
		switch(col) 
		{
		case ITEM_ID:
			return tempItem.getID();
		case ITEM_NAME_COL:
		    return tempItem.getName();
		case ITEM_PRICE_COL:
			return tempItem.getPrice();
		case ITEM_WEIGHT_COL:
			return tempItem.getWeight();
		default:
			return tempItem.getName();
		}
		
	}
	
}
