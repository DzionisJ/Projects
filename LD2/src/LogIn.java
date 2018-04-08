import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JTextField textFieldPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setTitle("Log in");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHello = new JLabel("Hello!");
		lblHello.setForeground(new Color(255, 255, 255));
		lblHello.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblHello.setHorizontalAlignment(SwingConstants.CENTER);
		lblHello.setBounds(177, 75, 106, 29);
		contentPane.add(lblHello);
		
		JLabel lblinfotext = new JLabel("Please input your profile information to Log in.");
		lblinfotext.setHorizontalAlignment(SwingConstants.CENTER);
		lblinfotext.setForeground(Color.WHITE);
		lblinfotext.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblinfotext.setBounds(80, 112, 295, 53);
		contentPane.add(lblinfotext);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setDisabledTextColor(new Color(0, 0, 0));
		textFieldUsername.setCaretColor(new Color(204, 204, 204));
		textFieldUsername.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldUsername.setBounds(147, 175, 175, 35);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JButton btnLogIN = new JButton("Log in");
		btnLogIN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(textFieldUsername.getText().equals("Jonas")&& textFieldPass.getText().equals("123"))
				{
					dispose();
					ItemApp s = new ItemApp();
					s.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Wrong Username/Password entered!", "Alert", JOptionPane.ERROR_MESSAGE);
					System.out.print("Wrong Username/Password entered!");
				}
			}
		});
		btnLogIN.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLogIN.setForeground(new Color(0, 0, 0));
		btnLogIN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogIN.setBackground(new Color(0, 255, 102));
		btnLogIN.setBounds(147, 326, 175, 35);
		contentPane.add(btnLogIN);
		
		textFieldPass = new JTextField();
		textFieldPass.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldPass.setDisabledTextColor(Color.BLACK);
		textFieldPass.setColumns(10);
		textFieldPass.setCaretColor(new Color(204, 204, 204));
		textFieldPass.setBounds(147, 233, 175, 35);
		contentPane.add(textFieldPass);
	}
}
