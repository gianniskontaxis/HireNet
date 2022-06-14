import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JPasswordField code;
	private aes data = new aes();
	private final String secretKey = "aes4";	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql="";
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public Login() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Images/logo_icon25x25.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 840, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		conn = DBConnection.ConnDB();
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				 new SignUp();
		    }
		});
		
		JLabel lblNewLabel_7 = new JLabel("  \u00A9 Copyright 2022 HireNet, Inc. All Rights Reserved ");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_7.setBounds(0, 555, 409, 28);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon(Login.class.getResource("/Images/white2.png")));
		lblNewLabel_6.setBounds(0, 555, 826, 38);
		contentPane.add(lblNewLabel_6);
		
		JButton Recover=new JButton("Forgot password?");
		Recover.setHorizontalAlignment(SwingConstants.RIGHT);
		Recover.setFont(new Font("Tahoma", Font.ITALIC, 14));
		Recover.setBackground(new Color(51, 102, 102));
		Recover.setForeground(new Color(0, 102, 102));
		Recover.setBounds(36, 321, 158, 25);
		Recover.setOpaque(false);
		Recover.setContentAreaFilled(false);
		Recover.setBorderPainted(false);
		Recover.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		contentPane.add(Recover);
		Recover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Recovery();
				
			} });
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_1.setBackground(new Color(51, 102, 102));
		btnNewButton_1.setForeground(new Color(0, 51, 51));
		btnNewButton_1.setBounds(115, 454, 92, 25);
		contentPane.add(btnNewButton_1);
		
		name = new JTextField();
		name.setBounds(65, 183, 225, 39);
		contentPane.add(name);
		name.setColumns(10);	
		
		JLabel lblCode = new JLabel("Password");
		lblCode.setForeground(new Color(0, 0, 0));
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCode.setBounds(65, 232, 92, 30);
		contentPane.add(lblCode);
		
		code = new JPasswordField();
		code.setColumns(10);
		code.setBounds(65, 272, 225, 39);
		contentPane.add(code);
		
		JButton btnNewButton_2 = new JButton("Login");
		btnNewButton_2.addActionListener(new ActionListener() {    
			public void actionPerformed(ActionEvent e) {
				
				sql = "select id,role from users where username = '"+name.getText()+"' and password = '"+data.encrypt(String.valueOf(code.getPassword()), secretKey)+"'";
				
				try {
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
					
					if (rs.isClosed()) {
						JOptionPane.showMessageDialog(null, "Invalid Username or Password"); 
					    dispose();
					    new Login();
					} 
					else {
						rs.next();
						if (rs.getString("role").equals("empty role"))
							new First(rs.getInt("id"));
						if (rs.getString("role").equals("company"))
							new Company(rs.getInt("id"));
						if (rs.getString("role").equals("employee"))
							new Employee(rs.getInt("id"));		
					
					ps.close();
					rs.close();
					conn.close();
					}
					dispose();				
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}			
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 102, 102));
		btnNewButton_2.setBounds(65, 384, 225, 60);
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		contentPane.add(btnNewButton_2);
		
		JLabel lblCompany = new JLabel("Username");
		lblCompany.setForeground(new Color(0, 0, 0));
		lblCompany.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCompany.setBounds(65, 143, 92, 30);
		contentPane.add(lblCompany);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/Images/Logopit_1648914555345-removebg-preview.png")));
		lblNewLabel_2.setBounds(310, -3, 355, 313);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Images/background5.png")));
		lblNewLabel.setBounds(419, 0, 420, 575);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome to ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 21));
		lblNewLabel_1.setBounds(65, 79, 122, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("HireNet");
		lblNewLabel_3.setForeground(new Color(0, 102, 102));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel_3.setBounds(181, 79, 99, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New here? ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_4.setBounds(65, 454, 77, 25);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("By New Horizons Development");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_5.setBounds(65, 107, 167, 13);
		contentPane.add(lblNewLabel_5);
		
		this.setVisible(true);
		this.setTitle("Login");		
	}
}
