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
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Color;

public class MatchingInfo extends JFrame {

	private int i;
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
	private PreparedStatement ps3 = null;
	private ResultSet rs3 = null;
	private String sql="";
	private DefaultListModel qualModel;
	private JLabel lblNewLabel;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	// Create Frame.
	
	public MatchingInfo(String username, int i) throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MatchingInfo.class.getResource("/Images/logo_icon25x25.png")));
		
		setResizable(false);
		setTitle("Matching Info");
		conn = DBConnection.ConnDB();
		
		this.i=i;
		this.username = username;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MatchingInfo.class.getResource("/Images/puzzle_icon.png")));
		lblNewLabel_2.setBounds(38, 184, 32, 32);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MatchingInfo.class.getResource("/Images/profile_icon.png")));
		lblNewLabel_1.setBounds(38, 42, 32, 32);
		contentPane.add(lblNewLabel_1);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(38, 216, 328, 12);
		contentPane.add(separator_1);
		
		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(38, 74, 328, 12);
		contentPane.add(separator);
		
		JTextPane txtpnUsersData = new JTextPane();
		txtpnUsersData.setEditable(false);
		txtpnUsersData.setBackground(SystemColor.menu);
		txtpnUsersData.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtpnUsersData.setText("User's Data");
		txtpnUsersData.setOpaque(false);
		txtpnUsersData.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtpnUsersData.setBounds(78, 42, 133, 32);
		contentPane.add(txtpnUsersData);
		
		txtEmail = new JTextField();
		txtEmail.setBorder(null);
		txtEmail.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtEmail.setEditable(false);
		txtEmail.setBackground(SystemColor.menu);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setText("Email");
		txtEmail.setOpaque(false);
		txtEmail.setBounds(38, 84, 50, 32);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBackground(SystemColor.window);
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		emailField.setEditable(false);
		emailField.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		emailField.setBounds(38, 120, 216, 30);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		txtpnMatches = new JTextPane();
		txtpnMatches.setText("Matching Skills");
		txtpnMatches.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtpnMatches.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtpnMatches.setBackground(SystemColor.menu);
		txtpnMatches.setOpaque(false);
		txtpnMatches.setBounds(78, 184, 166, 32);
		contentPane.add(txtpnMatches);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 238, 328, 292);
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
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MatchingInfo.class.getResource("/Images/hirenetwhite.png")));
		lblNewLabel.setBounds(0, 0, 406, 563);
		contentPane.add(lblNewLabel);
		
		// Kαταχωρηση των κοινων qual.
		
		FileManager rd = new FileManager();
		ArrayList<String> column = new ArrayList<>();					
		column = rd.read("quals.txt");
		
		//Διαβασμα των quals του user.
		sql = "select * from users join quals where users.id = quals.id and users.id = '"+i+"'";
		ps2 = conn.prepareStatement(sql);
		rs2 = ps2.executeQuery();	
		
		//Διαβασμα των quals του επιλεγμενου user.
		sql = "select * from users join quals where users.id = quals.id and username = '"+username+"'";
		ps3 = conn.prepareStatement(sql);
		rs3 = ps3.executeQuery();
		qualModel.clear();
		 				
		for (int j=0; j<64; j++ ) {
				
			if (rs2.getString(""+column.get(j)+"").equals(""+rs3.getString(column.get(j))+"") 
				&& rs2.getString(column.get(j)).equals("true")) {						
						qualModel.addElement(column.get(j));							
			}										
		}	
			
		// Κλεισιμο.
		ps.close();
		rs.close();
		ps2.close();
		rs2.close();
		ps3.close();
		rs3.close();
		conn.close();
		
		this.setVisible(true);
	}
}
