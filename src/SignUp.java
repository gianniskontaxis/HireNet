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
import java.awt.Toolkit;
import javax.swing.ImageIcon;

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
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignUp.class.getResource("/Images/logo_icon25x25.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(61, 68, 86, 32);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(61, 110, 350, 32);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblCompanysCeo = new JLabel("Email");
		lblCompanysCeo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCompanysCeo.setBounds(61, 152, 46, 32);
		contentPane.add(lblCompanysCeo);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(61, 194, 350, 32);
		contentPane.add(email);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(61, 236, 129, 29);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmCode = new JLabel("Confirm password");
		lblConfirmCode.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConfirmCode.setBounds(61, 317, 158, 29);
		contentPane.add(lblConfirmCode);
		
		code = new JPasswordField();
		code.setColumns(10);
		code.setBounds(61, 275, 350, 32);
		contentPane.add(code);		
		
		JLabel lblCompleteYourInformation = new JLabel("Sign Up");
		lblCompleteYourInformation.setForeground(new Color(0, 0, 0));
		lblCompleteYourInformation.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCompleteYourInformation.setBounds(200, 30, 79, 32);
		contentPane.add(lblCompleteYourInformation);
		
		JCheckBox terms = new JCheckBox("I Agree to");
		terms.setOpaque(false);
		terms.setContentAreaFilled(false);
		terms.setBorderPainted(false);
		terms.setFont(new Font("Tahoma", Font.ITALIC, 15));
		terms.setBounds(61, 423, 139, 21);
		contentPane.add(terms);		
		
		JButton btnNewButton_1 = new JButton("Create your account");
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {	
				conn = DBConnection.ConnDB();
				
				//������� �� sql.
				
				//������� ������� ���������.
				sql = "select username from users where username = '"+name.getText()+"' or email = '"+email.getText()+"'";
				
				try {					
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
					
					if (rs.isClosed() && terms.isSelected()) {
						
						//������� ������.
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
							}
							
							if(email.getText().contains("@yahoo.com") || email.getText().contains("@yahoo.gr") || email.getText().contains("@gmail.com") || email.getText().contains("@gmail.gr") || email.getText().contains("@uom.edu.gr")) {
								ps.setString(2, email.getText());
								k++;
							}
							else {
								JOptionPane.showMessageDialog(null, "Invalid email");
								dispose();	   
							}
						    if(String.valueOf(code.getPassword()).equals(String.valueOf(password.getPassword()))) {
						    	if(String.valueOf(code.getPassword()).length()<=15) {
									 ps.setString(3, data.encrypt(String.valueOf(code.getPassword()), secretKey));
									 k++;
								 }
								 else {
									 JOptionPane.showMessageDialog(null, "Invalid password");
									 dispose();
					                }
						    }
						    else {
								 JOptionPane.showMessageDialog(null, "Not the same passwords");
                                 dispose();
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
						//������ ��������� ������ �� �������� �������� ��� � ��� ����� � ������� ��� ���� ������.
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
		
		btnNewButton_1.setBackground(new Color(0, 102, 102));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_1.setBounds(61, 473, 350, 41);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Terms of use");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				new  TermsOfUse();
			}
		});
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(new Color(0, 102, 102));
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBounds(130, 423, 149, 21);
		contentPane.add(btnNewButton_2);
		
		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(61, 356, 350, 32);
		contentPane.add(password);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(SignUp.class.getResource("/Images/hirenetwhite.png")));
		lblNewLabel_1.setBounds(0, 0, 496, 573);
		contentPane.add(lblNewLabel_1);
		
		this.setVisible(true);
		this.setTitle("Sign Up");
	}	
}


