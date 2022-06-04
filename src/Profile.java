import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class Profile extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;	
	private int i;
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql="";
	private JTextField textFieldcomm;
	private JTextField textField_2;
	/*HashMap<Integer,List<String>> seminars = new HashMap<Integer,List<String>>();*/
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile(i);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	
	
	public Profile(int i) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Profile.class.getResource("/Images/logo_icon25x25.png")));
		setResizable(false);
		this.i=i;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(0, 54, 636, 8);
		contentPane.add(separator);
		
		JLabel lblFavoriteNumber = new JLabel("Favorite number");
		lblFavoriteNumber.setForeground(Color.WHITE);
		lblFavoriteNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFavoriteNumber.setBounds(232, 293, 136, 22);
		contentPane.add(lblFavoriteNumber);
		
		textField_2 = new JTextField();
		textField_2.setText((String) null);
		textField_2.setColumns(10);
		textField_2.setBounds(232, 325, 163, 32);
		contentPane.add(textField_2);
		
		JLabel Photo_label = new JLabel("");
		Photo_label.setIcon(new ImageIcon(Profile.class.getResource("/Images/profilephoto.png")));
		Photo_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		Photo_label.setForeground(Color.WHITE);
		Photo_label.setBackground(Color.WHITE);
		Photo_label.setHorizontalAlignment(SwingConstants.CENTER);
		Photo_label.setBounds(36, 71, 126, 126);
		contentPane.add(Photo_label);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Profile.class.getResource("/Images/background1.png")));
		lblNewLabel_5.setBounds(25, 62, 147, 528);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("Edit Profile");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(274, 12, 121, 32);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Profile.class.getResource("/Images/edit_icon.png")));
		lblNewLabel_3.setBounds(232, 12, 32, 32);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();	
		textField.setEditable(false);
		
		textField.setBounds(232, 103, 359, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(232, 71, 121, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(232, 145, 57, 22);
		contentPane.add(lblEmail);
		
		textField_1 = new JTextField();
		
		//JButton Logout=new JButton("Sign out");
		//Logout.setForeground(new Color(255, 255, 255));
		//Logout.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		//Logout.setBackground(new Color(47, 79, 79));
		//Logout.setBounds(307, 234, 89, 19);
		//contentPane.add(Logout);
		//Logout.addActionListener(new ActionListener() {
			//public void actionPerformed(ActionEvent e) {
			      /*System.exit(i);*/
				//dispose();
				//new Login();
			//}
		//});
		
		
		
		JButton Delete=new JButton("Delete account");
		Delete.setIcon(new ImageIcon(Profile.class.getResource("/Images/delete_icon.png")));
		Delete.setBackground(new Color(0, 0, 0));
		Delete.setForeground(new Color(255, 255, 255));
		Delete.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		Delete.setBounds(459, 558, 151, 32);
		contentPane.add(Delete);
		
		textFieldcomm = new JTextField();
		textFieldcomm.setBounds(232, 251, 163, 32);
		contentPane.add(textFieldcomm);
		textFieldcomm.setColumns(10);
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Deactivate(i);
			} });
		
		textField_1.setColumns(10);
		textField_1.setBounds(232, 177, 359, 32);
        sql = "select * from users where id = '"+i+"'";
        try {
    		conn = DBConnection.ConnDB();

        	ps = conn.prepareStatement(sql);
    		rs = ps.executeQuery();		
    		textField.setText(rs.getString("username"));

			
			ps.execute();
  			conn.close();

		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
        
	        sql = "select * from users where id = '"+i+"'";
	        try {
	    		conn = DBConnection.ConnDB();

	        	ps = conn.prepareStatement(sql);
	    		rs = ps.executeQuery();		
	    		textField_1.setText(rs.getString("email"));

				
				ps.execute();
      			conn.close();

			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
	        
	        sql = "select * from users where id = '"+i+"'";
	        try {
	    		conn = DBConnection.ConnDB();

	        	ps = conn.prepareStatement(sql);
	    		rs = ps.executeQuery();		
	    		textFieldcomm.setText(rs.getString("phone"));

				
				ps.execute();
      			conn.close();

			}
			catch (Exception ee) {
				ee.printStackTrace();
			}
	        
	        sql = "select * from users where id = '"+i+"'";
	        try {
	    		conn = DBConnection.ConnDB();

	        	ps = conn.prepareStatement(sql);
	    		rs = ps.executeQuery();		
	    		textField_2.setText(rs.getString("number"));

				
				ps.execute();
      			conn.close();

			}
			catch (Exception ee) {
				ee.printStackTrace();
			}
			
		contentPane.add(textField_1);
		
		JLabel lblCommunication = new JLabel("Phone number");
		lblCommunication.setForeground(new Color(255, 255, 255));
		lblCommunication.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCommunication.setBounds(232, 219, 136, 22);
		contentPane.add(lblCommunication);
		
		
		
		
		/*JButton btnNotifiactions = new JButton("Notifications");
		btnNotifiactions.setForeground(Color.WHITE);
		btnNotifiactions.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNotifiactions.setBackground(new Color(47, 79, 79));
		btnNotifiactions.setBounds(20, 22, 115, 19);
		contentPane.add(btnNotifiactions);
		btnNotifiactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Notifications(i);
			} });
		*/
		
		/*JButton btnMessages_1 = new JButton("Messages");
		btnMessages_1.setForeground(Color.WHITE);
		btnMessages_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnMessages_1.setBackground(new Color(47, 79, 79));
		btnMessages_1.setBounds(153, 22, 115, 19);
		contentPane.add(btnMessages_1);
		btnMessages_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Messages(i);
			} });
		*/
		
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(Profile.class.getResource("/Images/back_icon.png")));
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnBack.setBackground(new Color(47, 79, 79));
		btnBack.setBounds(10, 12, 32, 32);
		btnBack.setOpaque(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		contentPane.add(btnBack);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			} });
		
		

		JButton btnSave = new JButton("Save");
		btnSave.setIcon(new ImageIcon(Profile.class.getResource("/Images/save_icon.png")));
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnSave.setBackground(new Color(0, 0, 0));
		btnSave.setBounds(337, 558, 112, 32);
		contentPane.add(btnSave);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Profile.class.getResource("/Images/profile_backgrnd.png")));
		lblNewLabel_2.setBounds(0, 0, 636, 613);
		contentPane.add(lblNewLabel_2);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "update users set username = '"+textField.getText()+"' , email= '"+textField_1.getText()+"' , phone = '"+textFieldcomm.getText()+"' , number = '"+textField_2.getText()+"'  where id = '"+i+"'";
                try {
            		conn = DBConnection.ConnDB();

                    ps = conn.prepareStatement(sql);
                    ps.execute();
        			conn.close();

                }
                catch (Exception e0) {
                    e0.printStackTrace();
				}
				
			} });
		
		
		
		this.setVisible(true);
		this.setTitle("Profile");
	}
}
