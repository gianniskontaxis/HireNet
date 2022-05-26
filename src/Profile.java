import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

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
		
		textField.setBounds(272, 122, 151, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(153, 122, 72, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(153, 148, 47, 16);
		contentPane.add(lblEmail);
		
		textField_1 = new JTextField();
		
		textField_1.setColumns(10);
		textField_1.setBounds(272, 148, 151, 19);
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
		
		JButton btnNewButton = new JButton("Notifications");
		btnNewButton.setBounds(20, 22, 106, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Photograph");
		lblNewLabel_1.setBounds(20, 90, 106, 135);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCommunication = new JLabel("Communication");
		lblCommunication.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCommunication.setBounds(153, 174, 106, 16);
		contentPane.add(lblCommunication);
		
		JButton btnMessages = new JButton("Messages");
		btnMessages.setBounds(153, 22, 106, 21);
		contentPane.add(btnMessages);
		
		textField_2 = new JTextField();
		textField_2.setBounds(272, 174, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		this.setVisible(true);
		this.setTitle("Profile");
	}
}
