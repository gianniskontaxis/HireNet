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

public class Profile extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;	
	private int i;
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql="";
	
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
		conn = DBConnection.ConnDB();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();	
		
		textField.setBounds(158, 85, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(76, 85, 72, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(101, 124, 47, 16);
		contentPane.add(lblEmail);
		
		textField_1 = new JTextField();
		
		textField_1.setColumns(10);
		textField_1.setBounds(158, 14, 96, 19);
        sql = "select * from users where id = '"+i+"'";
        try {
        	ps = conn.prepareStatement(sql);
    		rs = ps.executeQuery();		
    		textField.setText(rs.getString("username"));

			
			ps.execute();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
        
	        sql = "select * from users where id = '"+i+"'";
	        try {
	        	ps = conn.prepareStatement(sql);
	    		rs = ps.executeQuery();		
	    		textField_1.setText(rs.getString("email"));

				
				ps.execute();
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
			
		contentPane.add(textField_1);
		this.setVisible(true);
		this.setTitle("Profile");
	}
}
