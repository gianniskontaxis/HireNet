import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;


public class Recovery extends JFrame {

	private JTextField user;

	private String code;
	private final String secretKey = "aes4";
	private JPanel contentPane;
	private JTextField favNum;
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String favnum = "";
	private int k=0;
	private int t=0;
	/*
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recovery frame = new Recovery();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Recovery() {
		setForeground(new Color(0, 0, 0));
		setTitle("Account Recovery");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Recovery.class.getResource("/Images/logo_icon25x25.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane name = new JTextPane();
		name.setForeground(new Color(240, 248, 255));
		name.setEditable(false);
		name.setFont(new Font("Tahoma", Font.PLAIN, 19));
		name.setBackground(SystemColor.control);
		name.setBorder(null);
		name.setText("Username");
		name.setBounds(64, 113, 100, 25);
		name.setOpaque(false);
		contentPane.add(name);
		
		user= new JTextField();
		user.setBounds(237, 113, 100, 25);
		contentPane.add(user);
		user.setColumns(10);
		
		JTextPane favnumber = new JTextPane();
		favnumber.setForeground(new Color(240, 248, 255));
		favnumber.setOpaque(false);
		favnumber.setEditable(false);
		favnumber.setFont(new Font("Tahoma", Font.PLAIN, 19));
		favnumber.setBackground(SystemColor.control);
		favnumber.setBorder(null);
		favnumber.setText("Favorite number:");
		favnumber.setBounds(64, 148, 162, 25);
		contentPane.add(favnumber);
		
		this.setVisible(true);
		
		favNum = new JTextField();
		favNum.setBounds(237, 148, 100, 25);
		contentPane.add(favNum);
		favNum.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBackground(new Color(0, 102, 102));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(165, 197, 100, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Account Recovery");
		lblNewLabel_1.setForeground(new Color(240, 248, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(150, 36, 195, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Recovery.class.getResource("/Images/icons8-forgot-password-48.png")));
		lblNewLabel_2.setBounds(92, 24, 48, 49);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Recovery.class.getResource("/Images/recovery_background.png")));
		lblNewLabel.setBounds(0, 0, 446, 275);
		contentPane.add(lblNewLabel);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					conn = DBConnection.ConnDB();
					code = "select number from users where username ='"+user.getText()+"'";
					ps = conn.prepareStatement(code);
					rs = ps.executeQuery();
					if (rs.isClosed()) {
						JOptionPane.showMessageDialog(null,"Something went wrong");
						k++;
					}
					else {						
						favnum = rs.getString("number");
					}
					
					ps.close();
					rs.close();
					conn.close();
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}	
				
				if (favnum.equals(favNum.getText())) {
						
				try
				{			
					conn = DBConnection.ConnDB();
					code="select password from users where username ='"+user.getText()+"'";		
					ps = conn.prepareStatement(code);
					rs = ps.executeQuery();
					if (!rs.isClosed()) {	
					t++;
					code=rs.getString("password");
					aes Data=new aes();
					code=Data.decrypt(code, secretKey);	
					}
					ps.close();
					rs.close();
					conn.close();
				}				
				catch (Exception e2) {
					e2.printStackTrace();
				}	
				if (t>0)
					JOptionPane.showMessageDialog(null,"Your password is "+code);
			}
				else	{	
					if (k==0) 
					    JOptionPane.showMessageDialog(null,"Something went wrong");	
				}
				dispose();
			} });
		}
}
