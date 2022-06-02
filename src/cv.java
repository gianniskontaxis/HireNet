import java.awt.Color; 
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class cv extends JFrame {

	private JPanel contentPane;
	private JTextField firstnametextField;
	private JTextField lastnametextField_1;
	private JTextField emailtextField_2;
	private JTextField agetextField_3;
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
	private JTextField countrytextField_4;
	private JTextField phonetextField;


	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cv frame = new cv();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public cv( int i ){
		
		this.i=i;

		setBounds(50, 50, 750, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel firstnamelblNewLabel = new JLabel("First Name");
		firstnamelblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		firstnamelblNewLabel.setBounds(47, 42, 93, 40);
		contentPane.add(firstnamelblNewLabel);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(47, 92, 93, 40);
		contentPane.add(lblLastName);
		
		JLabel emaillNewLabel_1_1 = new JLabel("Email");
		emaillNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emaillNewLabel_1_1.setBounds(47, 142, 69, 40);
		contentPane.add(emaillNewLabel_1_1);
		
		JLabel ageNewLabel = new JLabel("Age");
		ageNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ageNewLabel.setBounds(47, 192, 69, 40);
		contentPane.add(ageNewLabel);
		
		firstnametextField = new JTextField();
		firstnametextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		firstnametextField.setBounds(138, 51, 155, 28);
		contentPane.add(firstnametextField);
		firstnametextField.setColumns(10);
		
		lastnametextField_1 = new JTextField();
		lastnametextField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lastnametextField_1.setColumns(10);
		lastnametextField_1.setBounds(138, 105, 155, 28);
		contentPane.add(lastnametextField_1);
		
		emailtextField_2 = new JTextField();
		emailtextField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		emailtextField_2.setColumns(10);
		emailtextField_2.setBounds(107, 155, 186, 28);
		contentPane.add(emailtextField_2);
		
		agetextField_3 = new JTextField();
		agetextField_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		agetextField_3.setColumns(10);
		agetextField_3.setBounds(107, 205, 54, 28);
		contentPane.add(agetextField_3);			
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("summary");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_1_1_1.setBounds(375, 55, 210, 40);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(209, 559, 85, 21);
		contentPane.add(btnNewButton_1);
		
		countrytextField_4 = new JTextField();
		countrytextField_4.setBounds(107, 271, 96, 19);
		contentPane.add(countrytextField_4);
		countrytextField_4.setColumns(10);
		
		JLabel countryNewLabel_1 = new JLabel("Country");
		countryNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		countryNewLabel_1.setBounds(47, 258, 69, 40);
		contentPane.add(countryNewLabel_1);
		
		JLabel phoneNewLabel_2 = new JLabel("Phone");
		phoneNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phoneNewLabel_2.setBounds(47, 327, 69, 40);
		contentPane.add(phoneNewLabel_2);
		
		phonetextField = new JTextField();
		phonetextField.setColumns(10);
		phonetextField.setBounds(124, 340, 96, 19);
		contentPane.add(phonetextField);
		
		JTextPane textPanesummary = new JTextPane();
		textPanesummary.setBounds(364, 105, 278, 230);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Work Experience");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_1_1_1_1.setBounds(375, 367, 210, 40);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		JTextPane textPaneexperience = new JTextPane();
		textPaneexperience.setBounds(352, 413, 278, 230);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			      
				dispose();
				
			}
		});
		
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Write your");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_2.setBounds(36, 442, 93, 40);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		try {

			conn = DBConnection.ConnDB();

            ps = conn.prepareStatement("select id from employees where id = '"+i+"'");
            rs = ps.executeQuery();
            if (rs.isClosed()) {
                ps = conn.prepareStatement("INSERT INTO employees(id) VALUES(?)");
                ps.setInt(1, i);
                ps.execute();
            }
            ps.close();
			conn.close();

            


        } catch (SQLException e1) {
            e1.printStackTrace();
        }
		
    
		
		//anagnosh email
		sql = "select * from users where id = '"+i+"'";
        try {
    		conn = DBConnection.ConnDB();

        	ps1 = conn.prepareStatement(sql);
    		rs1 = ps1.executeQuery();		
    		emailtextField_2.setText(rs1.getString("email"));

			
			ps1.execute();
			conn.close();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		//anagnosh firstname

		sql = "select * from employees where id = '"+i+"'";
        try {
    		conn = DBConnection.ConnDB();

        	ps2 = conn.prepareStatement(sql);
    		rs2 = ps2.executeQuery();		
    		firstnametextField.setText(rs2.getString("firstname"));

			
			ps2.execute();
			conn.close();

		}
		catch (Exception e2) {
			e2.printStackTrace();
		}
		//anagnosh lastname

		sql = "select * from employees where id = '"+i+"'";
        try {
    		conn = DBConnection.ConnDB();

        	ps3 = conn.prepareStatement(sql);
    		rs3 = ps3.executeQuery();		
    		lastnametextField_1.setText(rs3.getString("lastname"));

			
			ps3.execute();
			conn.close();

		}
		catch (Exception e3) {
			e3.printStackTrace();
		}
		//anagnosh age

		sql = "select * from employees where id = '"+i+"'";
        try {
    		conn = DBConnection.ConnDB();

        	ps4 = conn.prepareStatement(sql);
    		rs4 = ps4.executeQuery();		
    		agetextField_3.setText(rs4.getString("age"));

			
			ps4.execute();
			conn.close();

		}
		catch (Exception e4) {
			e4.printStackTrace();
		}
        
        //anagnoni country//
        sql = "select * from employees where id = '"+i+"'";
        try {
    		conn = DBConnection.ConnDB();

        	ps5 = conn.prepareStatement(sql);
    		rs5 = ps5.executeQuery();		
    		countrytextField_4.setText(rs5.getString("country"));

			
			ps5.execute();
			conn.close();

		}
		catch (Exception e5) {
			e5.printStackTrace();
		}
        
        //anagnoni phone//
        sql = "select * from users where id = '"+i+"'";
        try {
    		conn = DBConnection.ConnDB();

        	ps6 = conn.prepareStatement(sql);
    		rs6 = ps6.executeQuery();		
    		phonetextField.setText(rs6.getString("phone"));

			
			ps6.execute();
			conn.close();

		}
		catch (Exception e6) {
			e6.printStackTrace();
		}
        
        //anagnoni summary//
        sql = "select * from employees where id = '"+i+"'";
        try {
    		conn = DBConnection.ConnDB();

        	ps7 = conn.prepareStatement(sql);
    		rs7 = ps7.executeQuery();		
    		textPanesummary.setText(rs7.getString("summary"));

			
			ps7.execute();
			conn.close();

		}
		catch (Exception e7) {
			e7.printStackTrace();
		}
        
        
        //anagnoni experience//
        sql = "select * from employees where id = '"+i+"'";
        try {
    		conn = DBConnection.ConnDB();

        	ps8 = conn.prepareStatement(sql);
    		rs8 = ps8.executeQuery();		
    		textPaneexperience.setText(rs8.getString("experience"));

			
			ps8.execute();
			conn.close();

		}
		catch (Exception e8) {
			e8.printStackTrace();
		}
        
        
		JButton btnNewButton = new JButton("Qualifications");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Qualifications(i);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.setBackground(new Color(47, 79, 79));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(161, 443, 155, 40);
		contentPane.add(btnNewButton);
		
		JButton save = new JButton("Save");
		save.setForeground(Color.WHITE);
		save.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		save.setBackground(new Color(47, 79, 79));
		save.setBounds(18, 544, 143, 48);
		contentPane.add(save);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(364, 105, 278, 230);
		contentPane.add(scrollPane);
		   scrollPane.setViewportView(textPanesummary);

		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(351, 413, 279, 230);
		contentPane.add(scrollPane_1);
		scrollPane_1.setViewportView(textPaneexperience);

		
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  //Εγγραφή χρήστη//
		        
				sql = "update employees set firstname = '"+firstnametextField.getText()+"' , lastname= '"+lastnametextField_1.getText()+"' , age = '"+agetextField_3.getText()+"',country = '"+countrytextField_4.getText()+"', summary = '"+textPanesummary.getText()+"' , experience = '"+textPaneexperience.getText()+"' where id = '"+i+"'";
                try {
            		conn = DBConnection.ConnDB();

                    ps = conn.prepareStatement(sql);
                    ps.execute();
        			conn.close();

                }
                catch (Exception e0) {
                    e0.printStackTrace();
				}
                
                sql = "update users set   email= '"+emailtextField_2.getText()+"' , phone= '"+phonetextField.getText()+"' where id = '"+i+"'";
                try {
            		conn = DBConnection.ConnDB();

                    ps = conn.prepareStatement(sql);
                    ps.execute();
        			conn.close();

                }
                catch (Exception ee) {
                    ee.printStackTrace();
				}
                dispose();
                
			
		}
		});
		
	
		
		
		
		this.setVisible(true);
		this.setTitle("cv");
	}
}
