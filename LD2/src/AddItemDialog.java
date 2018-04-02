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
import java.awt.event.ActionEvent;

public class AddItemDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JTextField textFieldPrice;
	private JTextField textFieldWeight;
	
	private ItemDAO itemDAO;
	private ItemApp itemAPP;
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
		setBounds(100, 100, 346, 191);
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
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblItemName)
							.addGap(18)
							.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(labelPriceperKg, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textFieldPrice, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(labelWeight, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldWeight, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(241, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblItemName)
						.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelPriceperKg, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldPrice, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelWeight, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldWeight, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(134, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Add");
				okButton.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent arg0)
					{
						saveItem();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void saveItem()
	{
		String name = textFieldName.getText();
		Double Price = Double.parseDouble(textFieldPrice.getText());
		Double Weight = Double.parseDouble(textFieldWeight.getText());
		
		Item tempItem = new Item(name, Price, Weight);
		itemDAO.addItem(tempItem);
		setVisible(false);
		dispose();
		itemAPP.refreshItemView();
	}
	
	
	public AddItemDialog(ItemApp theItemApp, ItemDAO theitemDAO)
	{
		this();
		itemDAO = theitemDAO;
		itemAPP = theItemApp;
	}
}
