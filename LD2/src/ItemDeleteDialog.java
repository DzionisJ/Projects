import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ItemDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ItemDeleteDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldID;

	private ItemDAO itemDAO;
	private ItemApp itemAPP;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		try {
			ItemDeleteDialog dialog = new ItemDeleteDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public ItemDeleteDialog() {
		setTitle("Delete Item");
		setBounds(100, 100, 250, 142);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.WEST);
		{
			JLabel lblNewLabel = new JLabel("Item ID");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			contentPanel.add(lblNewLabel);
		}
		{
			textFieldID = new JTextField();
			textFieldID.setFont(new Font("Tahoma", Font.PLAIN, 12));
			contentPanel.add(textFieldID);
			textFieldID.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton DeleteButton = new JButton("Delete");
				DeleteButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{
					
						int dialogButton = JOptionPane.YES_NO_OPTION;
						int dialogResult = JOptionPane.showConfirmDialog (null, "Do you want to DELETE this Item?","Warning",dialogButton);
						if(dialogResult == JOptionPane.YES_OPTION)
						{
							try {
								//ItemDAO.deleteIdem(ID);
								refresh();
							//	ItemDAO.getConnection();
							} catch (SQLException e) 
							{
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
						
					}
				});
				DeleteButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
				DeleteButton.setActionCommand("OK");
				buttonPane.add(DeleteButton);
				getRootPane().setDefaultButton(DeleteButton);
			}
		}
	}
	
	public void refresh() throws SQLException
	{
		Double ID = Double.parseDouble(textFieldID.getText());
		
		ItemDAO.deleteIdem(ID);
		itemAPP.refreshItemView();
		setVisible(false);
		dispose();
	}
	
	
	public ItemDeleteDialog(ItemApp theItemApp, ItemDAO theitemDAO)
	{
		this();
		itemDAO = theitemDAO;
		itemAPP = theItemApp;
	}

}
