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
		this.i=i;
		this.username = username;


		setBounds(50, 50, 750, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel firstnamelblNewLabel = new JLabel("First Name");
		firstnamelblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		firstnamelblNewLabel.setBounds(40, 64, 93, 40);
		contentPane.add(firstnamelblNewLabel);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(40, 114, 93, 40);
		contentPane.add(lblLastName);
		
		JLabel emaillNewLabel_1_1 = new JLabel("Email");
		emaillNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emaillNewLabel_1_1.setBounds(40, 164, 69, 40);
		contentPane.add(emaillNewLabel_1_1);
		
		JLabel ageNewLabel = new JLabel("Age");
		ageNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ageNewLabel.setBounds(40, 214, 69, 40);
		contentPane.add(ageNewLabel);
		
		JLabel countryNewLabel_1 = new JLabel("Country");
		countryNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		countryNewLabel_1.setBounds(40, 270, 69, 40);
		contentPane.add(countryNewLabel_1);
		
		JLabel phoneNewLabel_2 = new JLabel("Phone");
		phoneNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phoneNewLabel_2.setBounds(40, 320, 69, 40);
		contentPane.add(phoneNewLabel_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("summary");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_1_1_1.setBounds(333, 64, 210, 40);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Work Experience");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_1_1_1_1.setBounds(318, 343, 210, 40);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(290, 114, 238, 181);
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
		textArea_exp.setBounds(290, 393, 238, 181);
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
		textArea_firstname.setEditable(false);
		textArea_firstname.setBounds(143, 79, 116, 25);
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
		textArea_lastname.setEditable(false);
		textArea_lastname.setBounds(143, 129, 116, 25);
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
		textArea_email.setEditable(false);
		textArea_email.setBounds(143, 179, 116, 25);
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
		textArea_age.setEditable(false);
		textArea_age.setBounds(143, 229, 116, 25);
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
		textArea_country.setEditable(false);
		textArea_country.setBounds(143, 279, 116, 25);
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
		
		JTextArea textArea_phone = new JTextArea();
		textArea_phone.setEditable(false);
		textArea_phone.setBounds(143, 322, 116, 25);
		contentPane.add(textArea_phone);
		 //anagnoni phone//
		sql = "select * from users join employees where users.id = employees.id and username = '"+username+"'";
        try {
    		conn = DBConnection.ConnDB();

        	ps6 = conn.prepareStatement(sql);
    		rs6 = ps6.executeQuery();	
    		
    		textArea_phone.setText(rs6.getString("phone"));
    		

			
			ps6.execute();
			conn.close();

		}
		catch (Exception e6) {
			e6.printStackTrace();
		}
		
		this.setVisible(true);
		this.setTitle("CvOfUser");
	}
}
