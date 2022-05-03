import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class companyInfo extends JFrame {
	
	private String username;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField emailField;
	private JTextPane txtpnMatches;
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private PreparedStatement ps2 = null;
	private ResultSet rs2 = null;
	private String sql="";
	private DefaultListModel qualModel;

	// Create Frame.
	
	public companyInfo(String username) throws SQLException {
		
		setResizable(false);
		setTitle("Company's Info");
		conn = DBConnection.ConnDB();	
		
		this.username = username;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 792, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnUsersData = new JTextPane();
		txtpnUsersData.setEditable(false);
		txtpnUsersData.setBackground(SystemColor.menu);
		txtpnUsersData.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpnUsersData.setText("User's Data");
		txtpnUsersData.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtpnUsersData.setBounds(100, 63, 146, 36);
		contentPane.add(txtpnUsersData);
		
		txtEmail = new JTextField();
		txtEmail.setBorder(null);
		txtEmail.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtEmail.setEditable(false);
		txtEmail.setBackground(SystemColor.menu);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setText("Email");
		txtEmail.setBounds(23, 105, 50, 36);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBackground(SystemColor.window);
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		emailField.setEditable(false);
		emailField.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		emailField.setBounds(90, 109, 216, 30);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		txtpnMatches = new JTextPane();
		txtpnMatches.setText("We ask for!");
		txtpnMatches.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpnMatches.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtpnMatches.setBackground(SystemColor.menu);
		txtpnMatches.setBounds(539, 58, 132, 36);
		contentPane.add(txtpnMatches);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(477, 105, 270, 256);
		contentPane.add(scrollPane);
		
		JList qualList = new JList();
		qualList.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(qualList);
		
		qualModel = new DefaultListModel();
		qualList.setModel(qualModel);
		
		// Καταχωρηση email επιλεγμενου user.
		sql = "select * from users where username = '"+username+"'";
		
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		
		emailField.setText(rs.getString("email"));
		
		// Kαταχωρηση των qual.
		
		FileManager rd = new FileManager();
		ArrayList<String> column = new ArrayList<>();					
		column = rd.read("quals.txt");
		
		//Διαβασμα των quals του user.
		sql = "select * from users join quals where users.id = quals.id and username = '"+username+"'";
		ps2 = conn.prepareStatement(sql);
		rs2 = ps2.executeQuery();	
				
		qualModel.clear();
		 				
		for (int j=0; j<64; j++ ) {
				
			if (rs2.getString(column.get(j)).equals("true")) {						
						qualModel.addElement(column.get(j));							
			}										
		}	
			
		// Κλεισιμο.
		ps.close();
		rs.close();
		ps2.close();
		rs2.close();		
		conn.close();
		
		this.setVisible(true);
	}
}
