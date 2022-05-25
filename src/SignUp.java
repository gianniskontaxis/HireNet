import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField email;
	private JPasswordField code;
	private aes data = new aes();
	private final String secretKey = "aes4";		
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql="";
	private JPasswordField password;
	
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
		
		JLabel lblNewLabel = new JLabel("Username");
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
		
		JLabel lblConfirmCode = new JLabel("Confirm password");
		lblConfirmCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfirmCode.setBounds(43, 262, 128, 29);
		contentPane.add(lblConfirmCode);
		
		code = new JPasswordField();
		code.setColumns(10);
		code.setBounds(193, 263, 116, 32);
		contentPane.add(code);		
		
		JLabel lblCompleteYourInformation = new JLabel("Complete your information");
		lblCompleteYourInformation.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCompleteYourInformation.setBounds(101, 24, 251, 32);
		contentPane.add(lblCompleteYourInformation);
		
		JCheckBox terms = new JCheckBox("Agree with terms");
		terms.setFont(new Font("Tahoma", Font.BOLD, 12));
		terms.setBounds(71, 323, 139, 21);
		contentPane.add(terms);		
		
		JButton btnNewButton_1 = new JButton("Complete");
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {	
				conn = DBConnection.ConnDB();
				
				//Μέθοδος με sql.
				
				//Έλεγχος έγκυρων στοιχείων.
				sql = "select username from users where username = '"+name.getText()+"' or email = '"+email.getText()+"'";
				
				try {					
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
					
					if (rs.isClosed() && terms.isSelected()) {
						
						//Εγγραφή χρήστη.
						sql = "INSERT INTO users(username,email,password,role) VALUES(?,?,?,?)";
						
						int k=0;
						
						try {
							ps = conn.prepareStatement(sql);
							
							if(name.getText().length() >=4) {
								ps.setString(1, name.getText());
								k++;
							}
							else {
								JOptionPane.showMessageDialog(null, "Invalid name");
								dispose();
								new SignUp();
							}
							
							if(email.getText().contains("@yahoo.com") || email.getText().contains("@yahoo.gr") || email.getText().contains("@gmail.com") || email.getText().contains("@gmail.gr") || email.getText().contains("@uom.edu.gr")) {
								ps.setString(2, email.getText());
								k++;
							}
							else {
								JOptionPane.showMessageDialog(null, "Invalid email");
								dispose();
								new SignUp();
									   
							}
						    if(String.valueOf(code.getPassword()).equals(String.valueOf(password.getPassword())))
							 if(String.valueOf(code.getPassword()).length()<=15) {
								 ps.setString(3, data.encrypt(String.valueOf(code.getPassword()), secretKey));
								 k++;
							 }
							 else {
								 JOptionPane.showMessageDialog(null, "Invalid password");
								 dispose();
								 new SignUp();
							 }
							
							ps.setString(4, "empty role");		
							
							if(k==3) {
								ps.execute();
							}
							else {
								JOptionPane.showMessageDialog(null, "Complete Correctly th information");
								dispose();
								new SignUp();
							}
							
						}
						catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					else {
						//Μήνυμα σφάλματος επειδή τα στοιχεία υπάρχουν ήδη ή δεν έγινε η αποδοχή των όρων χρήσης.
						JOptionPane.showMessageDialog(null, "Data already exist");    

					}
					
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
				
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
				new  TermsOfUse();
			}
		});
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(47, 79, 79));
		btnNewButton_2.setBounds(224, 324, 85, 21);
		contentPane.add(btnNewButton_2);
		
		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(193, 203, 116, 32);
		contentPane.add(password);
		
		this.setVisible(true);
		this.setTitle("Sign Up");
	}	
}


