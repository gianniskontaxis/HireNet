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
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

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
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(cv.class.getResource("/Images/logo_icon25x25.png")));
		
		this.i=i;

		setBounds(50, 50, 990, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("* You can edit these fields in Profile");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_6.setBounds(18, 592, 196, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(cv.class.getResource("/Images/arrow_smallicon.png")));
		lblNewLabel_5.setBounds(421, 578, 32, 32);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("Don't forget to...");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_4.setBounds(463, 579, 162, 32);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("CV Edit");
		lblNewLabel_3.setIcon(new ImageIcon(cv.class.getResource("/Images/cv_icon.png")));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(407, 12, 115, 32);
		contentPane.add(lblNewLabel_3);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.BLACK);
		separator_1_1.setBounds(18, 205, 210, 8);
		contentPane.add(separator_1_1);
		
		JLabel Contact_label_1 = new JLabel("Personal Info");
		Contact_label_1.setForeground(Color.WHITE);
		Contact_label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		Contact_label_1.setBounds(18, 175, 144, 28);
		contentPane.add(Contact_label_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(18, 445, 210, 8);
		contentPane.add(separator_1);
		
		JLabel Contact_label = new JLabel("Contact");
		Contact_label.setForeground(Color.WHITE);
		Contact_label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		Contact_label.setBounds(18, 415, 69, 28);
		contentPane.add(Contact_label);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(0, 54, 986, 8);
		contentPane.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(cv.class.getResource("/Images/profilephoto.png")));
		lblNewLabel_2.setBounds(80, 70, 82, 82);
		contentPane.add(lblNewLabel_2);
		
		JLabel firstnamelblNewLabel = new JLabel("First Name");
		firstnamelblNewLabel.setForeground(Color.WHITE);
		firstnamelblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		firstnamelblNewLabel.setBounds(18, 215, 93, 28);
		contentPane.add(firstnamelblNewLabel);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLastName.setBounds(18, 275, 93, 28);
		contentPane.add(lblLastName);
		
		JLabel emaillNewLabel_1_1 = new JLabel("Email*");
		emaillNewLabel_1_1.setForeground(Color.WHITE);
		emaillNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		emaillNewLabel_1_1.setBounds(18, 455, 69, 28);
		contentPane.add(emaillNewLabel_1_1);
		
		JLabel ageNewLabel = new JLabel("Age");
		ageNewLabel.setForeground(Color.WHITE);
		ageNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		ageNewLabel.setBounds(18, 335, 69, 28);
		contentPane.add(ageNewLabel);
		
		firstnametextField = new JTextField();
		firstnametextField.setForeground(new Color(0, 0, 0));
		firstnametextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		firstnametextField.setBounds(18, 240, 186, 28);
		contentPane.add(firstnametextField);
		firstnametextField.setColumns(10);
		
		lastnametextField_1 = new JTextField();
		lastnametextField_1.setForeground(new Color(0, 0, 0));
		lastnametextField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lastnametextField_1.setColumns(10);
		lastnametextField_1.setBounds(18, 300, 186, 28);
		contentPane.add(lastnametextField_1);
		
		emailtextField_2 = new JTextField();
		emailtextField_2.setBackground(new Color(224, 255, 255));
		emailtextField_2.setForeground(new Color(0, 0, 0));
		emailtextField_2.setEditable(false);
		emailtextField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		emailtextField_2.setColumns(10);
		emailtextField_2.setBounds(18, 480, 186, 28);
		contentPane.add(emailtextField_2);
		
		agetextField_3 = new JTextField();
		agetextField_3.setForeground(new Color(0, 0, 0));
		agetextField_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		agetextField_3.setColumns(10);
		agetextField_3.setBounds(18, 362, 54, 28);
		contentPane.add(agetextField_3);			
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Professional Summary");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1_1_1.setBounds(309, 72, 235, 40);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JButton back_button = new JButton("");
		back_button.setIcon(new ImageIcon(cv.class.getResource("/Images/back_icon.png")));
		back_button.setBounds(10, 12, 32, 32);
		back_button.setOpaque(false);
		back_button.setContentAreaFilled(false);
		back_button.setBorderPainted(false);
		contentPane.add(back_button);
		
		countrytextField_4 = new JTextField();
		countrytextField_4.setForeground(new Color(0, 0, 0));
		countrytextField_4.setBounds(97, 362, 107, 28);
		contentPane.add(countrytextField_4);
		countrytextField_4.setColumns(10);
		
		JLabel countryNewLabel_1 = new JLabel("Country");
		countryNewLabel_1.setForeground(Color.WHITE);
		countryNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		countryNewLabel_1.setBounds(97, 335, 69, 28);
		contentPane.add(countryNewLabel_1);
		
		JLabel phoneNewLabel_2 = new JLabel("Phone*");
		phoneNewLabel_2.setForeground(Color.WHITE);
		phoneNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		phoneNewLabel_2.setBounds(18, 515, 69, 28);
		contentPane.add(phoneNewLabel_2);
		
		phonetextField = new JTextField();
		phonetextField.setBackground(new Color(224, 255, 255));
		phonetextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		phonetextField.setForeground(new Color(0, 0, 0));
		phonetextField.setEditable(false);
		phonetextField.setColumns(10);
		phonetextField.setBounds(18, 540, 115, 28);
		contentPane.add(phonetextField);
		
		JTextPane textPanesummary = new JTextPane();
		textPanesummary.setForeground(new Color(0, 0, 0));
		textPanesummary.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPanesummary.setBounds(364, 105, 278, 230);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Work Experience");
		lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1_1_1_1.setBounds(309, 312, 210, 40);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		JTextPane textPaneexperience = new JTextPane();
		textPaneexperience.setForeground(new Color(0, 0, 0));
		textPaneexperience.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPaneexperience.setBounds(352, 413, 278, 230);
		back_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			      
				dispose();
				
			}
		});
		
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
        
        
		JButton btnNewButton = new JButton("Add Qualifications");
		btnNewButton.setIcon(new ImageIcon(cv.class.getResource("/Images/add_icon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Qualifications(i);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(635, 581, 170, 32);
		contentPane.add(btnNewButton);
		
		JButton btnSave = new JButton("Save");
		btnSave.setIcon(new ImageIcon(Profile.class.getResource("/Images/save_icon.png")));
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnSave.setBackground(new Color(0, 0, 0));
		btnSave.setBounds(815, 581, 112, 32);
		contentPane.add(btnSave);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(309, 119, 620, 183);
		contentPane.add(scrollPane);
		   scrollPane.setViewportView(textPanesummary);

		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(309, 360, 620, 183);
		contentPane.add(scrollPane_1);
		scrollPane_1.setViewportView(textPaneexperience);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(cv.class.getResource("/Images/background1.png")));
		lblNewLabel_1.setBounds(10, 58, 235, 555);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(cv.class.getResource("/Images/cv_backgr.png")));
		lblNewLabel.setBounds(0, 0, 986, 623);
		contentPane.add(lblNewLabel);


		
		btnSave.addActionListener(new ActionListener() {
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
		this.setTitle("CV");
	}
}
