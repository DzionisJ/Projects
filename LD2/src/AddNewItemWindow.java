import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewItemWindow extends JFrame {
	private JTextField textField;
	private JTextField textFieldPrice;
	private JTextField textFieldWeight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewItemWindow frame = new AddNewItemWindow();
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
	public AddNewItemWindow() {
		setTitle("Add Item");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 266, 200);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(102, 31, 96, 19);
		getContentPane().add(textField);
		
		JLabel label = new JLabel("Item Name");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(10, 31, 82, 15);
		getContentPane().add(label);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(102, 60, 96, 19);
		getContentPane().add(textFieldPrice);
		
		JLabel labelPrice = new JLabel("Item Price/Kg");
		labelPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelPrice.setBounds(10, 60, 82, 15);
		getContentPane().add(labelPrice);
		
		textFieldWeight = new JTextField();
		textFieldWeight.setColumns(10);
		textFieldWeight.setBounds(102, 89, 96, 19);
		getContentPane().add(textFieldWeight);
		
		JLabel labelWeight = new JLabel("Item Weight");
		labelWeight.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelWeight.setBounds(10, 89, 82, 15);
		getContentPane().add(labelWeight);
		
		JButton AddItemButton = new JButton("Add Item");
		AddItemButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		AddItemButton.setBounds(62, 131, 85, 21);
		getContentPane().add(AddItemButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.setBounds(157, 131, 85, 21);
		getContentPane().add(btnCancel);
	}
}
