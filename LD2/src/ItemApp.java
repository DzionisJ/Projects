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
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ItemApp extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEnteredName;
	private ItemDAO itemDAO;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		JLabel lblEnterItemName = new JLabel("Enter Item Name");
		lblEnterItemName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblEnterItemName);
		
		textFieldEnteredName = new JTextField();
		textFieldEnteredName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(textFieldEnteredName);
		textFieldEnteredName.setColumns(10);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String name = textFieldEnteredName.getText();
				List<Core.Item> allitems = null;
				
				if(name != null && name.trim().length()>0)
				{
					allitems = itemDAO.searchItems(name);
				}
				else
				{
					allitems = itemDAO.getAllItems();
				}
				
				//for(Core.Item temp: allitems) {System.out.println(temp);}
				
				ItemTableModel model = new ItemTableModel(allitems);
				table.setModel(model);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(btnSearch);
		
		JButton btnAddNewItem = new JButton("Add new Item");
		btnAddNewItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				AddNewItemWindow adnew = new AddNewItemWindow();
				adnew.setVisible(true);
			}
		});
		btnAddNewItem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(btnAddNewItem);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

	/*public Object getItemName() {
		// TODO Auto-generated method stub
		return null;
	}*/

}
