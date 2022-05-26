import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;


public class Recovery extends JFrame {

	private JTextField user;

	private String code;
	private final String secretKey = "aes4";
	private JPanel contentPane;
	private JTextField textField;
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recovery frame = new Recovery();
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
	public Recovery() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane name = new JTextPane();
		name.setEditable(false);
		name.setFont(new Font("Tahoma", Font.PLAIN, 19));
		name.setBackground(SystemColor.control);
		name.setBorder(null);
		name.setText("Please enter your username:");
		name.setBounds(10, 84, 250, 45);
		contentPane.add(name);
		
		user= new JTextField();
		user.setBounds(270, 84, 85, 25);
		contentPane.add(user);
		user.setColumns(10);
		
		JTextPane favnumber = new JTextPane();
		favnumber.setEditable(false);
		favnumber.setFont(new Font("Tahoma", Font.PLAIN, 19));
		favnumber.setBackground(SystemColor.control);
		favnumber.setBorder(null);
		favnumber.setText("Please enter your favourite number:");
		favnumber.setBounds(10, 124, 310, 45);
		contentPane.add(favnumber);
		
		this.setVisible(true);
		
		textField = new JTextField();
		textField.setBounds(330, 124, 64, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBackground(new Color(47, 79, 79));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(165, 179, 100, 30);
		contentPane.add(btnNewButton);
		
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				code="select password from users where username ='"+user.getText()+"'";
				
				
				try
				{
			
					conn = DBConnection.ConnDB();
					ps = conn.prepareStatement(code);
					rs = ps.executeQuery();
					code=rs.getString("password");
					aes Data=new aes();
					code=Data.decrypt(code, secretKey);
					conn.close();
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Your password is "+code);
				dispose();
			} });
		

	}
}
