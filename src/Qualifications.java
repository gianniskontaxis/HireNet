import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class Qualifications extends JFrame {

	private JPanel contentPane;
	private int i;
	private JRadioButton[] radioButtons;
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql="";
	private ArrayList<String> column = new ArrayList<>();
	private int numOfQuals=0;
	
	
	
	public  Qualifications(int i) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Qualifications.class.getResource("/Images/logo_icon25x25.png")));
		
		this.i=i;	
		
		setTitle("Qualifications");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 973, 1200);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 100, 125));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		
		
		radioButtons = new JRadioButton[65];		
		
		JButton btnNewButton_1 = new JButton("Save");	
		btnNewButton_1.setIcon(new ImageIcon(Qualifications.class.getResource("/Images/save_icon.png")));
		
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(659, 649, 149, 34);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Load");	
		btnNewButton_2.setIcon(new ImageIcon(Qualifications.class.getResource("/Images/load.png")));
		
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(159, 649, 149, 34);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("General Qualifications:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(15, 15, 155, 20);
		contentPane.add(lblNewLabel);
		
		radioButtons[0] = new JRadioButton("University Degree in STEM");
		radioButtons[0].setBounds(25, 41, 499, 20);
		radioButtons[0].setBackground(new Color(0, 100, 125));
		radioButtons[0].setForeground(Color.WHITE);
		contentPane.add(radioButtons[0]);
		
		radioButtons[1] = new JRadioButton("Work experience at least 1 year");
		radioButtons[1].setBounds(25, 63, 299, 21);
		radioButtons[1].setBackground(new Color(0, 100, 125));
		radioButtons[1].setForeground(Color.WHITE);
		contentPane.add(radioButtons[1]);
		
		radioButtons[2] = new JRadioButton("Vaccination certificate");
		radioButtons[2].setBounds(25, 87, 233, 21);
		radioButtons[2].setBackground(new Color(0, 100, 125));
		radioButtons[2].setForeground(Color.WHITE);
		contentPane.add(radioButtons[2]);
		
		radioButtons[3] = new JRadioButton("B2 level English degree");
		radioButtons[3].setBounds(25, 110, 243, 21);
		radioButtons[3].setBackground(new Color(0, 100, 125));
		radioButtons[3].setForeground(Color.WHITE);
		contentPane.add(radioButtons[3]);
		
		radioButtons[4] = new JRadioButton("C2 level English degree");
		radioButtons[4].setBounds(25, 133, 216, 21);
		radioButtons[4].setBackground(new Color(0, 100, 125));
		radioButtons[4].setForeground(Color.WHITE);
		contentPane.add(radioButtons[4]);
		
		radioButtons[5] = new JRadioButton("Driving license");
		radioButtons[5].setBounds(25, 156, 164, 21);
		radioButtons[5].setBackground(new Color(0, 100, 125));
		radioButtons[5].setForeground(Color.WHITE);
		contentPane.add(radioButtons[5]);
		
		JLabel lblNewLabel_1 = new JLabel("Marital Status:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(25, 206, 85, 13);
		contentPane.add(lblNewLabel_1);
		
		radioButtons[6] = new JRadioButton("married");
		radioButtons[6].setBounds(126, 202, 85, 21);
		radioButtons[6].setBackground(new Color(0, 100, 125));
		radioButtons[6].setForeground(Color.WHITE);
		contentPane.add(radioButtons[6]);
		
		radioButtons[7] = new JRadioButton("unmarried");
		radioButtons[7].setBounds(221, 202, 103, 21);
		radioButtons[7].setBackground(new Color(0, 100, 125));
		radioButtons[7].setForeground(Color.WHITE);
		contentPane.add(radioButtons[7]);
		
		radioButtons[8] = new JRadioButton("Fulfilled military obligations");
		radioButtons[8].setBounds(25, 179, 205, 21);
		radioButtons[8].setBackground(new Color(0, 100, 125));
		radioButtons[8].setForeground(Color.WHITE);
		contentPane.add(radioButtons[8]);
		
		JLabel lblNewLabel_2 = new JLabel("Additional qualifications:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(15, 251, 155, 20);
		contentPane.add(lblNewLabel_2);
		
		radioButtons[9] = new JRadioButton("Java");
		radioButtons[9].setBounds(25, 270, 103, 21);
		radioButtons[9].setBackground(new Color(0, 100, 125));
		radioButtons[9].setForeground(Color.WHITE);
		contentPane.add(radioButtons[9]);
		
		radioButtons[10] = new JRadioButton("JavaScript");
		radioButtons[10].setBounds(225, 270, 103, 21);
		radioButtons[10].setBackground(new Color(0, 100, 125));
		radioButtons[10].setForeground(Color.WHITE);
		contentPane.add(radioButtons[10]);
		
		radioButtons[11] = new JRadioButton("TypeScript");
		radioButtons[11].setBounds(425, 270, 103, 21);
		radioButtons[11].setBackground(new Color(0, 100, 125));
		radioButtons[11].setForeground(Color.WHITE);
		contentPane.add(radioButtons[11]);
		
		radioButtons[12] = new JRadioButton("C");
		radioButtons[12].setBounds(25, 295, 103, 21);
		radioButtons[12].setBackground(new Color(0, 100, 125));
		radioButtons[12].setForeground(Color.WHITE);
		contentPane.add(radioButtons[12]);
		
		radioButtons[13] = new JRadioButton("C++");
		radioButtons[13].setBounds(225, 295, 103, 21);
		radioButtons[13].setBackground(new Color(0, 100, 125));
		radioButtons[13].setForeground(Color.WHITE);
		contentPane.add(radioButtons[13]);
		
		radioButtons[14]= new JRadioButton("C#");
		radioButtons[14].setBounds(425, 295, 103, 21);
		radioButtons[14].setBackground(new Color(0, 100, 125));
		radioButtons[14].setForeground(Color.WHITE);
		contentPane.add(radioButtons[14]);
		
		radioButtons[15] = new JRadioButton("Python");
		radioButtons[15].setBounds(625, 270, 103, 21);
		radioButtons[15].setBackground(new Color(0, 100, 125));
		radioButtons[15].setForeground(Color.WHITE);
		contentPane.add(radioButtons[15]);
		
		radioButtons[16] = new JRadioButton("HTML");
		radioButtons[16].setBounds(625, 295, 103, 21);
		radioButtons[16].setBackground(new Color(0, 100, 125));
		radioButtons[16].setForeground(Color.WHITE);
		contentPane.add(radioButtons[16]);
		
		radioButtons[17] = new JRadioButton("CSS");
		radioButtons[17].setBounds(825, 295, 103, 21);
		radioButtons[17].setBackground(new Color(0, 100, 125));
		radioButtons[17].setForeground(Color.WHITE);
		contentPane.add(radioButtons[17]);
		
		radioButtons[18] = new JRadioButton("SQL");
		radioButtons[18].setBounds(25, 320, 103, 21);
		radioButtons[18].setBackground(new Color(0, 100, 125));
		radioButtons[18].setForeground(Color.WHITE);
		contentPane.add(radioButtons[18]);
		
		radioButtons[19] = new JRadioButton("MATLAB");
		radioButtons[19].setBounds(825, 270, 103, 21);
		radioButtons[19].setBackground(new Color(0, 100, 125));
		radioButtons[19].setForeground(Color.WHITE);
		contentPane.add(radioButtons[19]);
		
		radioButtons[20] = new JRadioButton("Visual Basic");
		radioButtons[20].setBounds(425, 320, 103, 21);
		radioButtons[20].setBackground(new Color(0, 100, 125));
		radioButtons[20].setForeground(Color.WHITE);
		contentPane.add(radioButtons[20]);
		
		radioButtons[21]= new JRadioButton("Visual Basic.Net");
		radioButtons[21].setBounds(625, 320, 134, 21);
		radioButtons[21].setBackground(new Color(0, 100, 125));
		radioButtons[21].setForeground(Color.WHITE);
		contentPane.add(radioButtons[21]);
		
		radioButtons[22] = new JRadioButton("Objective-C");
		radioButtons[22].setBounds(225, 320, 103, 21);
		radioButtons[22].setBackground(new Color(0, 100, 125));
		radioButtons[22].setForeground(Color.WHITE);
		contentPane.add(radioButtons[22]);
		
		radioButtons[23] = new JRadioButton("Swift");
		radioButtons[23].setBounds(825, 320, 103, 21);
		radioButtons[23].setBackground(new Color(0, 100, 125));
		radioButtons[23].setForeground(Color.WHITE);
		contentPane.add(radioButtons[23]);
		
		radioButtons[24] = new JRadioButton("Ruby");
		radioButtons[24].setBounds(25, 345, 103, 21);
		radioButtons[24].setBackground(new Color(0, 100, 125));
		radioButtons[24].setForeground(Color.WHITE);
		contentPane.add(radioButtons[24]);
		
		radioButtons[25] = new JRadioButton("Perl");
		radioButtons[25].setBounds(225, 345, 103, 21);
		radioButtons[25].setBackground(new Color(0, 100, 125));
		radioButtons[25].setForeground(Color.WHITE);
		contentPane.add(radioButtons[25]);
		
		radioButtons[26] = new JRadioButton("GO");
		radioButtons[26].setBounds(425, 345, 103, 21);
		radioButtons[26].setBackground(new Color(0, 100, 125));
		radioButtons[26].setForeground(Color.WHITE);
		contentPane.add(radioButtons[26]);
		
		radioButtons[27] = new JRadioButton("ASP");
		radioButtons[27].setBounds(25, 370, 103, 21);
		radioButtons[27].setBackground(new Color(0, 100, 125));
		radioButtons[27].setForeground(Color.WHITE);
		contentPane.add(radioButtons[27]);
		
		radioButtons[28] = new JRadioButton("R");
		radioButtons[28].setBounds(825, 345, 103, 21);
		radioButtons[28].setBackground(new Color(0, 100, 125));
		radioButtons[28].setForeground(Color.WHITE);
		contentPane.add(radioButtons[28]);
		
		radioButtons[29] = new JRadioButton("Assembly language");
		radioButtons[29].setBounds(625, 345, 134, 21);
		radioButtons[29].setBackground(new Color(0, 100, 125));
		radioButtons[29].setForeground(Color.WHITE);
		contentPane.add(radioButtons[29]);
		
		radioButtons[30] = new JRadioButton("XML");
		radioButtons[30].setBounds(225, 370, 103, 21);
		radioButtons[30].setBackground(new Color(0, 100, 125));
		radioButtons[30].setForeground(Color.WHITE);
		contentPane.add(radioButtons[30]);
		
		radioButtons[31]= new JRadioButton("AJAX");
		radioButtons[31].setBounds(425, 370, 103, 21);
		radioButtons[31].setBackground(new Color(0, 100, 125));
		radioButtons[31].setForeground(Color.WHITE);
		contentPane.add(radioButtons[31]);
		
		radioButtons[32]= new JRadioButton("JSON");
		radioButtons[32].setBounds(625, 370, 103, 21);
		radioButtons[32].setBackground(new Color(0, 100, 125));
		radioButtons[32].setForeground(Color.WHITE);
		contentPane.add(radioButtons[32]);
		
		radioButtons[33] = new JRadioButton("REST API");
		radioButtons[33].setBounds(825, 370, 103, 21);
		radioButtons[33].setBackground(new Color(0, 100, 125));
		radioButtons[33].setForeground(Color.WHITE);
		contentPane.add(radioButtons[33]);
		
		radioButtons[34] = new JRadioButton("Software Development");
		radioButtons[34].setBounds(25, 395, 164, 21);
		radioButtons[34].setBackground(new Color(0, 100, 125));
		radioButtons[34].setForeground(Color.WHITE);
		contentPane.add(radioButtons[34]);
		
		radioButtons[35] = new JRadioButton("PC Hardware");
		radioButtons[35].setBounds(225, 395, 121, 21);
		radioButtons[35].setBackground(new Color(0, 100, 125));
		radioButtons[35].setForeground(Color.WHITE);
		contentPane.add(radioButtons[35]);
		
		radioButtons[36] = new JRadioButton("E-Marketing");
		radioButtons[36].setBounds(425, 395, 103, 21);
		radioButtons[36].setBackground(new Color(0, 100, 125));
		radioButtons[36].setForeground(Color.WHITE);
		contentPane.add(radioButtons[36]);
		
		radioButtons[37] = new JRadioButton("Social Media");
		radioButtons[37].setBounds(625, 395, 117, 21);
		radioButtons[37].setBackground(new Color(0, 100, 125));
		radioButtons[37].setForeground(Color.WHITE);
		contentPane.add(radioButtons[37]);
		
		radioButtons[38] = new JRadioButton("Use of VPN");
		radioButtons[38].setBounds(825, 395, 103, 21);
		radioButtons[38].setBackground(new Color(0, 100, 125));
		radioButtons[38].setForeground(Color.WHITE);
		contentPane.add(radioButtons[38]);
		
		radioButtons[39]= new JRadioButton("Use of Big Query");
		radioButtons[39].setBounds(25, 420, 136, 21);
		radioButtons[39].setBackground(new Color(0, 100, 125));
		radioButtons[39].setForeground(Color.WHITE);
		contentPane.add(radioButtons[39]);
		
		radioButtons[40] = new JRadioButton("ARM Cortex-M 32-bit");
		radioButtons[40].setBounds(225, 420, 164, 21);
		radioButtons[40].setBackground(new Color(0, 100, 125));
		radioButtons[40].setForeground(Color.WHITE);
		contentPane.add(radioButtons[40]);
		
		radioButtons[41] = new JRadioButton("Modile Applications");
		radioButtons[41].setBounds(425, 418, 134, 21);
		radioButtons[41].setBackground(new Color(0, 100, 125));
		radioButtons[41].setForeground(Color.WHITE);
		contentPane.add(radioButtons[41]);
		
		radioButtons[42] = new JRadioButton("ERP");
		radioButtons[42].setBounds(625, 420, 103, 21);
		radioButtons[42].setBackground(new Color(0, 100, 125));
		radioButtons[42].setForeground(Color.WHITE);
		contentPane.add(radioButtons[42]);
		
		radioButtons[43] = new JRadioButton("SAP");
		radioButtons[43].setBounds(825, 420, 103, 21);
		radioButtons[43].setBackground(new Color(0, 100, 125));
		radioButtons[43].setForeground(Color.WHITE);
		contentPane.add(radioButtons[43]);
		
		radioButtons[44] = new JRadioButton("Photoshop");
		radioButtons[44].setBounds(25, 445, 103, 21);
		radioButtons[44].setBackground(new Color(0, 100, 125));
		radioButtons[44].setForeground(Color.WHITE);
		contentPane.add(radioButtons[44]);
		
		radioButtons[45] = new JRadioButton("Adobe Illustrator");
		radioButtons[45].setBounds(225, 445, 121, 21);
		radioButtons[45].setBackground(new Color(0, 100, 125));
		radioButtons[45].setForeground(Color.WHITE);
		contentPane.add(radioButtons[45]);
		
		radioButtons[46] = new JRadioButton("UI/UX Design");
		radioButtons[46].setBounds(425, 445, 121, 21);
		radioButtons[46].setBackground(new Color(0, 100, 125));
		radioButtons[46].setForeground(Color.WHITE);
		contentPane.add(radioButtons[46]);
		
		radioButtons[47] = new JRadioButton("JSF");
		radioButtons[47].setBounds(625, 445, 103, 21);
		radioButtons[47].setBackground(new Color(0, 100, 125));
		radioButtons[47].setForeground(Color.WHITE);
		contentPane.add(radioButtons[47]);
		
		JLabel lblNewLabel_3 = new JLabel("Operating System:");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(25, 494, 121, 13);
		contentPane.add(lblNewLabel_3);
		
		radioButtons[48]= new JRadioButton("Android");
		radioButtons[48].setBounds(160, 490, 103, 21);
		radioButtons[48].setBackground(new Color(0, 100, 125));
		radioButtons[48].setForeground(Color.WHITE);
		contentPane.add(radioButtons[48]);
		
		radioButtons[49] = new JRadioButton("Linux");
		radioButtons[49].setBounds(280, 490, 103, 21);
		radioButtons[49].setBackground(new Color(0, 100, 125));
		radioButtons[49].setForeground(Color.WHITE);
		contentPane.add(radioButtons[49]);
		
		radioButtons[50] = new JRadioButton("Unix");
		radioButtons[50].setBounds(400, 490, 103, 21);
		radioButtons[50].setBackground(new Color(0, 100, 125));
		radioButtons[50].setForeground(Color.WHITE);
		contentPane.add(radioButtons[50]);
		
		radioButtons[51] = new JRadioButton("MacOS");
		radioButtons[51].setBounds(520, 490, 103, 21);
		radioButtons[51].setBackground(new Color(0, 100, 125));
		radioButtons[51].setForeground(Color.WHITE);
		contentPane.add(radioButtons[51]);
		
		radioButtons[52] = new JRadioButton("Ubuntu");
		radioButtons[52].setBounds(640, 490, 103, 21);
		radioButtons[52].setBackground(new Color(0, 100, 125));
		radioButtons[52].setForeground(Color.WHITE);
		contentPane.add(radioButtons[52]);
		
		JLabel lblNewLabel_4 = new JLabel("CMS:");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(25, 520, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		radioButtons[53] = new JRadioButton("WordPress");
		radioButtons[53].setBounds(160, 515, 103, 21);
		radioButtons[53].setBackground(new Color(0, 100, 125));
		radioButtons[53].setForeground(Color.WHITE);
		contentPane.add(radioButtons[53]);
		
		radioButtons[54] = new JRadioButton("Joomla");
		radioButtons[54].setBounds(280, 515, 103, 21);
		radioButtons[54].setBackground(new Color(0, 100, 125));
		radioButtons[54].setForeground(Color.WHITE);
		contentPane.add(radioButtons[54]);
		
		radioButtons[55] = new JRadioButton("Drupal");
		radioButtons[55].setBounds(400, 515, 103, 21);
		radioButtons[55].setBackground(new Color(0, 100, 125));
		radioButtons[55].setForeground(Color.WHITE);
		contentPane.add(radioButtons[55]);
		
		radioButtons[56]= new JRadioButton("OpenCart");
		radioButtons[56].setBounds(520, 515, 103, 21);
		radioButtons[56].setBackground(new Color(0, 100, 125));
		radioButtons[56].setForeground(Color.WHITE);
		contentPane.add(radioButtons[56]);
		
		radioButtons[57]= new JRadioButton("PrestaShop");
		radioButtons[57].setBounds(640, 515, 103, 21);
		radioButtons[57].setBackground(new Color(0, 100, 125));
		radioButtons[57].setForeground(Color.WHITE);
		contentPane.add(radioButtons[57]);
		
		JLabel lblNewLabel_5 = new JLabel("Microsoft Office:");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(25, 545, 103, 13);
		contentPane.add(lblNewLabel_5);
		
		radioButtons[58] = new JRadioButton("Word");
		radioButtons[58].setBounds(160, 540, 103, 21);
		radioButtons[58].setBackground(new Color(0, 100, 125));
		radioButtons[58].setForeground(Color.WHITE);
		contentPane.add(radioButtons[58]);
		
		radioButtons[59] = new JRadioButton("Excel");
		radioButtons[59].setBounds(280, 540, 103, 21);
		radioButtons[59].setBackground(new Color(0, 100, 125));
		radioButtons[59].setForeground(Color.WHITE);
		contentPane.add(radioButtons[59]);
		
		radioButtons[60] = new JRadioButton("Access");
		radioButtons[60].setBounds(400, 540, 103, 21);
		radioButtons[60].setBackground(new Color(0, 100, 125));
		radioButtons[60].setForeground(Color.WHITE);
		contentPane.add(radioButtons[60]);
		
		radioButtons[61]= new JRadioButton("PowerPoint");
		radioButtons[61].setBounds(520, 540, 103, 21);
		radioButtons[61].setBackground(new Color(0, 100, 125));
		radioButtons[61].setForeground(Color.WHITE);
		contentPane.add(radioButtons[61]);
		
		radioButtons[62] = new JRadioButton("Windows");
		radioButtons[62].setBounds(640, 540, 103, 21);
		radioButtons[62].setBackground(new Color(0, 100, 125));
		radioButtons[62].setForeground(Color.WHITE);
		contentPane.add(radioButtons[62]);
		
		radioButtons[63] = new JRadioButton("Outlook-Internet");
		radioButtons[63].setBounds(760, 540, 128, 21);
		radioButtons[63].setBackground(new Color(0, 100, 125));
		radioButtons[63].setForeground(Color.WHITE);
		contentPane.add(radioButtons[63]);	
		
		try {
			conn = DBConnection.ConnDB();
			ps = conn.prepareStatement("select id from numOfQuals where id = '"+i+"'");
			rs = ps.executeQuery();
			if (rs.isClosed()) {
				ps = conn.prepareStatement("INSERT INTO numOfQuals(id) VALUES(?)");
				ps.setInt(1, i);
				ps.execute();
			}
			ps.close();
			rs.close();
			conn.close();
		} catch (SQLException e1) {			
			e1.printStackTrace();
		}
		
		try {
			conn = DBConnection.ConnDB();
			ps = conn.prepareStatement("select id from quals where id = '"+i+"'");
			rs = ps.executeQuery();
			if (rs.isClosed()) {
				ps = conn.prepareStatement("INSERT INTO quals(id) VALUES(?)");
				ps.setInt(1, i);
				ps.execute();
			}
			conn.close();
		} catch (SQLException e1) {			
			e1.printStackTrace();
		}
		
		FileManager rd = new FileManager();							
		column = rd.read("quals.txt");
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		//sql				
				try {
					conn = DBConnection.ConnDB();
					for (int j=0;j<64;j++) {
					sql = " select `"+column.get(j)+"` from quals where id = "+i+" ";
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
					rs.next();
					if (rs.getString(""+column.get(j)+"").equals("true"))
						radioButtons[j].doClick();						
					}	
					conn.close();
				}					
				 catch (SQLException e1) {					
					 e1.printStackTrace();
				}	
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}		
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				
				//sql
				
				try {
					conn = DBConnection.ConnDB();
					for (int j=0; j<64; j++) {		
						if (radioButtons[j].isSelected()) {
							numOfQuals++;
							sql = "update quals set `"+column.get(j)+"` = 'true' where id = '"+i+"'";
							ps = conn.prepareStatement(sql);
						}
						else
						{
							sql = "update quals set `"+column.get(j)+"` = 'false' where id = '"+i+"'";
							ps = conn.prepareStatement(sql);
						}	
						ps.execute();
					}
					
					ps.close();
					sql = "update numOfQuals set num = "+numOfQuals+" where id = '"+i+"'";
					ps = conn.prepareStatement(sql);
					ps.execute();
					ps.close();					
					conn.close();
					dispose();
				} catch (SQLException e1) {				
					e1.printStackTrace();
				}				
			}			
		});
		
		
		
		this.setVisible(true);
		this.setTitle("Qualifications");
	}
}

