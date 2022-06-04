import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class CvMatching extends JFrame {

	private JPanel contentPane;
	private int i;	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private PreparedStatement ps1 = null;
	private ResultSet rs1 = null;
	private PreparedStatement ps2 = null;
	private ResultSet rs2 = null;
	private PreparedStatement ps3 = null;
	private ResultSet rs3 = null;
	private PreparedStatement ps4 = null;
	private ResultSet rs4 = null;
	private PreparedStatement ps5 = null;
	private ResultSet rs5 = null;
	private PreparedStatement ps6 = null;
	private ResultSet rs6 = null;
	private PreparedStatement ps7 = null;
	private ResultSet rs7 = null;
	private PreparedStatement ps8 = null;
	private ResultSet rs8 = null;
	private String sql="";
	private String username;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CvMatching frame = new CvMatching();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public CvMatching(String username,int i) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CvMatching.class.getResource("/Images/logo_icon25x25.png")));
		this.i=i;
		this.username = username;


		setBounds(50, 50, 600, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(33, 472, 202, 8);
		contentPane.add(separator_1_1);
		
		JTextArea textArea_phone = new JTextArea();
		textArea_phone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textArea_phone.setForeground(Color.WHITE);
		textArea_phone.setEditable(false);
		textArea_phone.setBounds(33, 391, 116, 32);
		textArea_phone.setOpaque(false);
		contentPane.add(textArea_phone);
		
		/*textArea_phone.setText(rs6.getString("phone"));*/
		
		JLabel lblNewLabel_3 = new JLabel("years old");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(58, 274, 97, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(CvMatching.class.getResource("/Images/profilephoto.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(93, 65, 82, 81);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(33, 349, 202, 8);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Contact");
		lblNewLabel_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_1_1_1_1_1.setBounds(33, 319, 210, 32);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel countryNewLabel_1 = new JLabel("Address");
		countryNewLabel_1.setForeground(Color.WHITE);
		countryNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		countryNewLabel_1.setBounds(33, 442, 69, 32);
		contentPane.add(countryNewLabel_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Professional Summary");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_1_1_1.setBounds(290, 20, 253, 40);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Work Experience");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_1_1_1_1.setBounds(290, 329, 210, 40);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(290, 64, 272, 231);
		contentPane.add(textArea);
		
		
		
		  //anagnosh summary// 
		sql = "select * from users join employees where users.id = employees.id and username = '"+username+"'";
        try {
    		conn = DBConnection.ConnDB();

        	ps7 = conn.prepareStatement(sql);
    		rs7 = ps7.executeQuery();
    		while (rs7.next()) {
    		textArea.append(rs7.getString("summary"));
    		}

			
			ps7.execute();
			conn.close();

		}
		catch (Exception e7) {
			e7.printStackTrace();
		}
		
		JTextArea textArea_exp = new JTextArea();
		textArea_exp.setEditable(false);
		textArea_exp.setBounds(290, 379, 272, 231);
		contentPane.add(textArea_exp);
		
		
		
		   //anagnosh experience//
		sql = "select * from users join employees where users.id = employees.id and username = '"+username+"'";
        try {
    		conn = DBConnection.ConnDB();

        	ps8 = conn.prepareStatement(sql);
    		rs8 = ps8.executeQuery();	
    		while (rs8.next()) {
    		textArea_exp.append(rs8.getString("experience"));
    		}

			
			ps8.execute();
			conn.close();

		}
		catch (Exception e8) {
			e8.printStackTrace();
		}
		
		JTextArea textArea_firstname = new JTextArea();
		textArea_firstname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textArea_firstname.setForeground(Color.WHITE);
		textArea_firstname.setEditable(false);
		textArea_firstname.setBounds(33, 207, 194, 32);
		textArea_firstname.setOpaque(false);
		contentPane.add(textArea_firstname);
		
		//anagnosh firstname

				sql = "select * from users join employees where users.id = employees.id and username = '"+username+"'";
		        try {
		    		conn = DBConnection.ConnDB();

		        	ps2 = conn.prepareStatement(sql);
		    		rs2 = ps2.executeQuery();	
		    		
		    		textArea_firstname.setText(rs2.getString("firstname"));
		    		

					
					ps2.execute();
					rs2.close();
					ps2.close();
					conn.close();

				}
				catch (Exception e2) {
					e2.printStackTrace();
				}
		
		JTextArea textArea_lastname = new JTextArea();
		textArea_lastname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textArea_lastname.setForeground(Color.WHITE);
		textArea_lastname.setEditable(false);
		textArea_lastname.setBounds(33, 235, 194, 32);
		textArea_lastname.setOpaque(false);
		contentPane.add(textArea_lastname);
		//anagnosh lastname

		sql = "select * from users join employees where users.id = employees.id and username = '"+username+"'";
		        try {
		    		conn = DBConnection.ConnDB();

		        	ps3 = conn.prepareStatement(sql);
		    		rs3 = ps3.executeQuery();	
		    		
		    		textArea_lastname.setText(rs3.getString("lastname"));
		    		

					
					ps3.execute();
					conn.close();

				}
				catch (Exception e3) {
					e3.printStackTrace();
				}
		
		JTextArea textArea_email = new JTextArea();
		textArea_email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textArea_email.setForeground(Color.WHITE);
		textArea_email.setEditable(false);
		textArea_email.setBounds(33, 367, 202, 32);
		textArea_email.setOpaque(false);
		contentPane.add(textArea_email);
		//anagnosh email
				sql = "select * from users where username = '"+username+"'";
		        try {
		    		conn = DBConnection.ConnDB();

		        	ps1 = conn.prepareStatement(sql);
		    		rs1 = ps1.executeQuery();	
		    		
		    		textArea_email.setText(rs1.getString("email"));
		    		
					
					ps1.execute();
					rs1.close();
					ps1.close();
					conn.close();
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
		
		JTextArea textArea_age = new JTextArea();
		textArea_age.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textArea_age.setForeground(Color.WHITE);
		textArea_age.setEditable(false);
		textArea_age.setBounds(33, 280, 50, 32);
		textArea_age.setOpaque(false);
		contentPane.add(textArea_age);
		//anagnosh age

		sql = "select * from users join employees where users.id = employees.id and username = '"+username+"'";
        try {
    		conn = DBConnection.ConnDB();

        	ps4 = conn.prepareStatement(sql);
    		rs4 = ps4.executeQuery();
    		
    		textArea_age.setText(rs4.getString("age"));
    		

			
			ps4.execute();
			conn.close();

		}
		catch (Exception e4) {
			e4.printStackTrace();
		}
		
		JTextArea textArea_country = new JTextArea();
		textArea_country.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textArea_country.setForeground(Color.WHITE);
		textArea_country.setEditable(false);
		textArea_country.setBounds(33, 484, 202, 32);
		textArea_country.setOpaque(false);
		contentPane.add(textArea_country);
		  //anagnoni country//
		sql = "select * from users join employees where users.id = employees.id and username = '"+username+"'";
        try {
    		conn = DBConnection.ConnDB();

        	ps5 = conn.prepareStatement(sql);
    		rs5 = ps5.executeQuery();		
    		
    		textArea_country.setText(rs5.getString("country"));
    		

			
			ps5.execute();
			conn.close();

		}
		catch (Exception e5) {
			e5.printStackTrace();
		}
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CvMatching.class.getResource("/Images/background1.png")));
		lblNewLabel_1.setBounds(20, 20, 235, 590);
		contentPane.add(lblNewLabel_1);
		 //anagnoni phone//
		sql = "select * from users join employees where users.id = employees.id and username = '"+username+"'";
        try {
    		conn = DBConnection.ConnDB();

        	ps6 = conn.prepareStatement(sql);
    		rs6 = ps6.executeQuery();	
    		
    		JLabel lblNewLabel = new JLabel("");
    		lblNewLabel.setIcon(new ImageIcon(CvMatching.class.getResource("/Images/cv_backgr2.png")));
    		lblNewLabel.setBounds(0, 0, 586, 623);
    		contentPane.add(lblNewLabel);
    		

			
			ps6.execute();
			conn.close();

		}
		catch (Exception e6) {
			e6.printStackTrace();
		}
		
		this.setVisible(true);
		this.setTitle("User CV");
	}
}
