import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.sql.*;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField email;
	private JTextField code;
	
	private ArrayList<String> names = new ArrayList<>();
	private ArrayList<String> emails = new ArrayList<>();
	private aes data = new aes();
	private final String secretKey = "aes4";
	private FileManager rw = new FileManager();
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	
	public SignUp() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(99, 82, 86, 32);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(193, 85, 116, 32);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblCompanysCeo = new JLabel("Email");
		lblCompanysCeo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCompanysCeo.setBounds(137, 140, 46, 32);
		contentPane.add(lblCompanysCeo);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(193, 143, 116, 32);
		contentPane.add(email);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(111, 201, 129, 19);
		contentPane.add(lblPassword);
		
		JButton btnNewButton = new JButton("Code");
		btnNewButton.setBackground(new Color(47, 79, 79));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.setBounds(227, 201, 85, 41);
		contentPane.add(btnNewButton);
		
		JLabel lblConfirmCode = new JLabel("Confirm password");
		lblConfirmCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfirmCode.setBounds(51, 262, 128, 29);
		contentPane.add(lblConfirmCode);
		
		code = new JTextField();
		code.setColumns(10);
		code.setBounds(196, 263, 116, 32);
		contentPane.add(code);		
		
		JLabel lblCompleteYourInformation = new JLabel("Complete your information");
		lblCompleteYourInformation.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCompleteYourInformation.setBounds(101, 24, 251, 32);
		contentPane.add(lblCompleteYourInformation);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Agree with terms");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxNewCheckBox.setBounds(71, 323, 139, 21);
		contentPane.add(chckbxNewCheckBox);		  
		
		JButton btnNewButton_1 = new JButton("Complete");
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {	
				
				names = rw.readDecr("file3.txt");				
				emails = rw.readDecr("file2.txt");
				
				if ( names.contains(name.getText()) || emails.contains(email.getText()) || !chckbxNewCheckBox.isSelected() )
					System.out.println("Error");
				
				else
				{
					rw.writeText("file3.txt", name.getText() , true , true);					
					rw.writeText("file2.txt", email.getText(), true, true);					
					rw.writeText("file1.txt", code.getText(), true, true);					
					rw.writeText("file4.txt", "empty role", true, true);					
				}
				//sql
				
				dispose();
			}
		});
		
		btnNewButton_1.setBackground(new Color(47, 79, 79));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_1.setBounds(170, 382, 116, 41);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Terms");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TermsOfUse tof = new  TermsOfUse();
			}
		});
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(47, 79, 79));
		btnNewButton_2.setBounds(224, 324, 85, 21);
		contentPane.add(btnNewButton_2);
		
		this.setVisible(true);
		this.setTitle("Sign Up");
	}	
}
