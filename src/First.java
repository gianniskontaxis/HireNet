import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JLabel;

public class First extends JFrame {

	private JPanel contentPane;
	private int i,y;
	private ArrayList<String> roles = new ArrayList<>();
	private aes data = new aes();
	private final String secretKey = "aes4";
	private FileManager rw = new FileManager();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					First frame = new First();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public First(int i) {
		this.i=i;
		y=i+1;
		//roles = rw.readDecr("file4.txt");
		//sql
		try {					
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hirenetdb", 
			"root", "hnppass21");
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery("select role from users");
			while (rs.next()) {
				roles.add(rs.getString("role"));
			}					
		}
		catch (Exception exc){
			exc.printStackTrace();
		}	
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 614, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Company");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new Company(i);
				/*roles.set(i,"company");				
				rw.writeList("file4.txt", roles, false, true);*/
				
				//sql
				try {	
					
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hirenetdb", 
					"root", "hnppass21");
					Statement state = conn.createStatement();
					state.executeUpdate("UPDATE\r\n"
							+ " `hirenetdb`.`users` \r\n"
							+ "SET `role` = 'company' \r\n"
							+ "WHERE (`id` = '"+y+"');");
					
		               state.close(); 
		               conn.close(); 
				}
				catch (Exception exc){
					exc.printStackTrace();
				}
				
				dispose();
		    }
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.setBackground(new Color(47, 79, 79));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(84, 421, 159, 55);
		contentPane.add(btnNewButton);
		
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new Employee(i);				
				/*roles.set(i,"employee");				
				rw.writeList("file4.txt", roles, false, true);*/
				
				//sql
				
				try {					
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hirenetdb", 
					"root", "hnppass21");
					Statement state = conn.createStatement();
					state.executeUpdate("UPDATE\r\n"
							+ " `hirenetdb`.`users` \r\n"
							+ "SET `role` = 'employee' \r\n"
							+ "WHERE (`id` = '"+y+"');");		
				   
		               state.close(); 
		               conn.close(); 
				}
				catch (Exception exc){
					exc.printStackTrace();
				}
				
				dispose();
		    }
		});
		btnEmployee.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnEmployee.setBackground(new Color(47, 79, 79));
		btnEmployee.setForeground(Color.WHITE);
		btnEmployee.setBounds(337, 421, 159, 55);
		contentPane.add(btnEmployee);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(100, -30, 548, 301);	
		contentPane.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/HireNet400X400.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		this.setVisible(true);

	}
}
