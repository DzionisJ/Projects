import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Core.Item;
import dao.ItemDAO;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddItemDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JTextField textFieldPrice;
	private JTextField textFieldWeight;
	
	private ItemDAO itemDAO;
	private ItemApp itemAPP;
	private JTextField textFieldID;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			AddItemDialog dialog = new AddItemDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the dialog.
	 */
	public AddItemDialog() 
	{
		setTitle("Add New Items");
		
		setBounds(100, 100, 348, 225);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JLabel labelPriceperKg = new JLabel("Price/Kg");
		labelPriceperKg.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JLabel labelWeight = new JLabel("Item Weight");
		labelWeight.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldName.setColumns(10);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldPrice.setColumns(10);
		
		textFieldWeight = new JTextField();
		textFieldWeight.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldWeight.setColumns(10);
		
		JLabel lblItemId = new JLabel("Item ID");
		lblItemId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textFieldID = new JTextField();
		textFieldID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldID.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblItemName)
						.addComponent(labelPriceperKg, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelWeight, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblItemId, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textFieldName, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
								.addComponent(textFieldPrice)
								.addComponent(textFieldWeight))
							.addContainerGap(97, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(textFieldID, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
							.addGap(97))))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblItemName)
						.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(labelPriceperKg, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldPrice, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelWeight, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldWeight, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblItemId)
						.addComponent(textFieldID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton AddItemButton = new JButton("Add Item");
				AddItemButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
				AddItemButton.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent arg0)
					{
						try {
							saveItem();
						} catch (SQLException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						itemAPP.refreshItemView();
						try {
							ItemDAO.getConnection();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				AddItemButton.setActionCommand("OK");
				buttonPane.add(AddItemButton);
				getRootPane().setDefaultButton(AddItemButton);
			}
		}
	}
	
	public void saveItem() throws SQLException
	{
		Double ID = Double.parseDouble(textFieldID.getText());
		String name = textFieldName.getText();
		Double Price = Double.parseDouble(textFieldPrice.getText());
		Double Weight = Double.parseDouble(textFieldWeight.getText());
		
		Item tempItem = new Item(ID, name, Price, Weight);
		itemDAO.addItem(tempItem); 
		itemAPP.refreshItemView();
		setVisible(false);
		dispose();
	}
	
	
	
	public AddItemDialog(ItemApp theItemApp, ItemDAO theitemDAO)
	{
		this();
		itemDAO = theitemDAO;
		itemAPP = theItemApp;
	}
}
