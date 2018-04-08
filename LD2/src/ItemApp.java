import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ItemDAO;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ItemApp extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEnteredID;
	private ItemDAO itemDAO;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemApp frame = new ItemApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public ItemApp() 
	{
		setTitle("Items In Storage");
		itemDAO = new ItemDAO();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblEnterItemID = new JLabel("Enter Item ID");
		lblEnterItemID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblEnterItemID);
		
		textFieldEnteredID = new JTextField();
		textFieldEnteredID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(textFieldEnteredID);
		textFieldEnteredID.setColumns(10);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
				String ID = textFieldEnteredID.getText();
				List<Core.Item> allitems = null;
				
				if(ID != null && ID.trim().length()>0)
				{
					allitems = itemDAO.searchItems(ID);
					try
					{
						ItemDAO.getSpecificItems(ID);
					} catch (SQLException e)
					{
						e.printStackTrace();
					}
				}
				else
				{
					allitems = itemDAO.getAllItems(); // DB
					try
					{
						ItemDAO.getConnection();
					} catch (SQLException e) 
					{
						e.printStackTrace();
					}
				}
				
				
				//for(Core.Item temp: allitems) {System.out.println(temp);}
				
				ItemTableModel model = new ItemTableModel(allitems);
				
				table.setModel(model);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(btnSearch);
		
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				AddItemDialog dialog = new AddItemDialog(ItemApp.this, itemDAO);
				dialog.setVisible(true);
			}
		});
		btnAddItem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(btnAddItem);
		
		JButton btnDeleteItem = new JButton("Delete Item");
		btnDeleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ItemDeleteDialog dialoger = new ItemDeleteDialog(ItemApp.this, itemDAO);
				dialoger.setVisible(true);
			}
		});
		btnDeleteItem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(btnDeleteItem);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
	
	public void refreshItemView()
	{
		
		//itemDAO.getAllItems();
		ItemTableModel	mdl = new ItemTableModel(itemDAO.getAllItems());
		table.setModel(mdl);
		
	}
	
	

	/*public Object getItemName() {
		// TODO Auto-generated method stub
		return null;
	}*/

}
