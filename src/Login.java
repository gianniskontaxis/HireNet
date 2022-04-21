import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField code;
	private int i=0;
	
	private ArrayList<String> names = new ArrayList<>();
	private ArrayList<String> codes = new ArrayList<>();
	private ArrayList<String> roles = new ArrayList<>();
	private aes data = new aes();
	private final String secretKey = "aes4";
	private FileManager rw = new FileManager();
	
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				 new SignUp();
		    }
		});
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.setBackground(new Color(47, 79, 79));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(323, 370, 98, 39);
		contentPane.add(btnNewButton_1);
		
		name = new JTextField();
		name.setBounds(157, 108, 165, 39);
		contentPane.add(name);
		name.setColumns(10);	
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCode.setBounds(84, 170, 63, 30);
		contentPane.add(lblCode);
		
		code = new JTextField();
		code.setColumns(10);
		code.setBounds(157, 168, 165, 39);
		contentPane.add(code);
		
		JButton btnNewButton_2 = new JButton("Login");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				//files
				names = rw.readDecr("file3.txt");				
				roles = rw.readDecr("file4.txt");				
				codes = rw.readDecr("file1.txt");
				*/
				//sql
				try {					
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hirenetdb", 
					"root", "hnppass21");
					Statement state = conn.createStatement();
					ResultSet rs = state.executeQuery("select username from users");
					while (rs.next()) {
						names.add(rs.getString("username"));
					}	
						rs.close(); 
		               state.close(); 
		               conn.close(); 
				}
				catch (Exception exc){
					exc.printStackTrace();
				}
				try {					
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hirenetdb", 
					"root", "hnppass21");
					Statement state = conn.createStatement();
					ResultSet rs = state.executeQuery("select role from users");
					while (rs.next()) {
						roles.add(rs.getString("role"));
					}	
					rs.close(); 
		               state.close(); 
		               conn.close(); 
				}
				catch (Exception exc){
					exc.printStackTrace();
				}
				try {					
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hirenetdb", 
					"root", "hnppass21");
					Statement state = conn.createStatement();
					ResultSet rs = state.executeQuery("select password from users");
					while (rs.next()) {
						codes.add(rs.getString("password"));
					}
					rs.close(); 
		               state.close(); 
		               conn.close(); 
				}
				catch (Exception exc){
					exc.printStackTrace();
				}
				
				i= names.indexOf(name.getText());
				
				if ( i==-1 || ( !(codes.get(i).equals(code.getText())) ) )  {
						System.out.println("Error");
				}
				else {
					if (roles.get(i).equals("empty role"))      
							new First(i);
					else
					{
						if (roles.get(i).equals("company"))
							new Company(i);
						if (roles.get(i).equals("employee"))
							new Employee(i);
					}						
				}				
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(47, 79, 79));
		btnNewButton_2.setBounds(194, 255, 92, 39);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("New to HireNet?");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(224, 375, 119, 28);
		contentPane.add(lblNewLabel_1);		
		
		JLabel lblCompany = new JLabel("User Name");
		lblCompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCompany.setBounds(72, 108, 92, 30);
		contentPane.add(lblCompany);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(223, 59, 49, 39);
		contentPane.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		this.setVisible(true);
		this.setTitle("Login");		
	}
}
