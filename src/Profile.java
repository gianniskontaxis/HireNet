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

public class Profile extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;	
	private int i;
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql="";
	private JTextField textField_2;
	private JTextField textField_3;
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
		this.i=i;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();	
		
		textField.setBounds(272, 90, 151, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(153, 90, 72, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(153, 116, 47, 16);
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
		Delete.setBackground(new Color(47, 79, 79));
		Delete.setForeground(new Color(255, 255, 255));
		Delete.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		Delete.setBounds(293, 22, 121, 19);
		contentPane.add(Delete);
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Deactivate(i);
			} });
		
		textField_1.setColumns(10);
		textField_1.setBounds(272, 119, 151, 19);
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
			
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("Photograph");
		lblNewLabel_1.setBounds(20, 90, 106, 135);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCommunication = new JLabel("Communication");
		lblCommunication.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCommunication.setBounds(153, 148, 106, 16);
		contentPane.add(lblCommunication);
		
		
		textField_2 = new JTextField();
		textField_2.setBounds(272, 148, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
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
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnBack.setBackground(new Color(47, 79, 79));
		btnBack.setBounds(20, 234, 78, 19);
		contentPane.add(btnBack);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			} });
		
		

		JButton btnSave = new JButton("Save");
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnSave.setBackground(new Color(47, 79, 79));
		btnSave.setBounds(159, 233, 78, 19);
		contentPane.add(btnSave);
		
		JLabel lblFavNumber = new JLabel("Fav number");
		lblFavNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFavNumber.setBounds(153, 181, 106, 16);
		contentPane.add(lblFavNumber);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(272, 181, 96, 19);
		contentPane.add(textField_3);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "update users set username = '"+textField.getText()+"' , email= '"+textField_1.getText()+"'  where id = '"+i+"'";
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
