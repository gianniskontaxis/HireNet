import java.awt.Color;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		conn = DBConnection.ConnDB();
		
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
		
		JLabel lblCode = new JLabel("Password");
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCode.setBounds(80, 170, 67, 30);
		contentPane.add(lblCode);
		
		code = new JPasswordField();
		code.setColumns(10);
		code.setBounds(157, 168, 165, 39);
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
		btnNewButton_2.setBackground(new Color(47, 79, 79));
		btnNewButton_2.setBounds(194, 255, 92, 39);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("New to HireNet?");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(224, 375, 119, 28);
		contentPane.add(lblNewLabel_1);		
		
		JLabel lblCompany = new JLabel("Username");
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
