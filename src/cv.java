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
		setIconImage(Toolkit.getDefaultToolkit().getImage(cv.class.getResource("/Images/logo_icon25x25.png")));
		
		this.i=i;

		setBounds(50, 50, 1000, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(37, 487, 202, 8);
		contentPane.add(separator_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Qualifications");
		lblNewLabel_1_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(37, 457, 210, 32);
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Contact");
		lblNewLabel_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_1_1_1_1_1.setBounds(37, 292, 210, 32);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(37, 322, 202, 8);
		contentPane.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(0, 54, 986, 8);
		contentPane.add(separator);
		
		JLabel lblNewLabel_3 = new JLabel("Edit CV");
		lblNewLabel_3.setIcon(new ImageIcon(cv.class.getResource("/Images/cv_icon.png")));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_3.setBounds(400, 12, 105, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(cv.class.getResource("/Images/profilephoto.png")));
		lblNewLabel_2.setBounds(95, 72, 82, 81);
		contentPane.add(lblNewLabel_2);
		
		firstnametextField = new JTextField();
		firstnametextField.setForeground(Color.WHITE);
		firstnametextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		firstnametextField.setBounds(37, 179, 202, 28);
		firstnametextField.setOpaque(false);
		contentPane.add(firstnametextField);
		firstnametextField.setColumns(10);
		
		lastnametextField_1 = new JTextField();
		lastnametextField_1.setForeground(Color.WHITE);
		lastnametextField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lastnametextField_1.setOpaque(false);
		lastnametextField_1.setColumns(10);
		lastnametextField_1.setBounds(37, 216, 202, 28);
		contentPane.add(lastnametextField_1);
		
		emailtextField_2 = new JTextField();
		emailtextField_2.setForeground(Color.WHITE);
		emailtextField_2.setEditable(false);
		emailtextField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emailtextField_2.setColumns(10);
		emailtextField_2.setOpaque(false);
		emailtextField_2.setBounds(37, 338, 155, 28);
		contentPane.add(emailtextField_2);
		
		agetextField_3 = new JTextField();
		agetextField_3.setForeground(Color.WHITE);
		agetextField_3.setOpaque(false);
		agetextField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		agetextField_3.setColumns(10);
		agetextField_3.setBounds(37, 254, 40, 28);
		contentPane.add(agetextField_3);			
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Professional Summary");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_1_1_1.setBounds(308, 63, 241, 32);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(cv.class.getResource("/Images/back_icon.png")));
		btnNewButton_1.setBounds(10, 12, 32, 32);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);
		
		countrytextField_4 = new JTextField();
		countrytextField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		countrytextField_4.setForeground(Color.WHITE);
		countrytextField_4.setBounds(37, 414, 90, 28);
		countrytextField_4.setOpaque(false);
		contentPane.add(countrytextField_4);
		countrytextField_4.setColumns(10);
		
		phonetextField = new JTextField();
		phonetextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phonetextField.setForeground(Color.WHITE);
		phonetextField.setOpaque(false);
		phonetextField.setEditable(false);
		phonetextField.setColumns(10);
		phonetextField.setBounds(37, 376, 155, 28);
		contentPane.add(phonetextField);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Work Experience");
		lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_1_1_1_1.setBounds(308, 320, 210, 32);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		btnNewButton_1.addActionListener(new ActionListener() {
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
    		emailtextField_2.setText("Email");

			
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
    		firstnametextField.setText("First Name");

			
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
    		lastnametextField_1.setText("Last Name");

			
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
    		agetextField_3.setText("Age");

			
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
    		countrytextField_4.setText("Address");

			
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
    		phonetextField.setText("Phone Number");

			
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

			
			ps8.execute();
			conn.close();

		}
		catch (Exception e8) {
			e8.printStackTrace();
		}
        
        
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(cv.class.getResource("/Images/add_icon.png")));
		btnNewButton.setOpaque(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Qualifications(i);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.setBackground(new Color(47, 79, 79));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(37, 499, 32, 32);
		contentPane.add(btnNewButton);
		
		JButton save = new JButton("Save");
		save.setIcon(new ImageIcon(cv.class.getResource("/Images/save_icon.png")));
		save.setForeground(Color.WHITE);
		save.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		save.setBackground(Color.BLACK);
		save.setBounds(817, 577, 112, 32);
		contentPane.add(save);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(308, 105, 621, 205);
		contentPane.add(scrollPane);
		
		JTextPane textPanesummary = new JTextPane();
		scrollPane.setViewportView(textPanesummary);
		textPanesummary.setText("Complete your info...");

		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(308, 362, 621, 205);
		contentPane.add(scrollPane_1);
		JTextPane textPaneexperience = new JTextPane();
		scrollPane_1.setViewportView(textPaneexperience);
		textPaneexperience.setText("Complete your info...");
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(cv.class.getResource("/Images/background1.png")));
		lblNewLabel_1.setBounds(20, 58, 235, 555);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(cv.class.getResource("/Images/cv_backgr.png")));
		lblNewLabel.setBounds(0, 0, 986, 623);
		contentPane.add(lblNewLabel);

		
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
		this.setTitle("CV ");
	}
}
