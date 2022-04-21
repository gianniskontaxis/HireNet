import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import java.sql.*;

public class Qualifications extends JFrame {

	private JPanel contentPane;
	private int i;
	private JRadioButton[] radioButtons;
	private ArrayList<String> roles = new ArrayList<>();
	private aes data = new aes();
	private final String secretKey = "aes4";
	private ArrayList<String> qual = new ArrayList<>();
	private ArrayList<String> qual2 = new ArrayList<>();
	private String filename="";
	private FileManager rw = new FileManager();
	private String role = "";
	private ArrayList<String> companies = new ArrayList<String>();
	private ArrayList<String> employees = new ArrayList<String>();
	private int y=0;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Qualifications frame = new Qualifications();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Qualifications(int i) {
		
		this.i=i;
		y=i+1;
		setTitle("Qualifications");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 973, 1200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		radioButtons = new JRadioButton[65];
		
		/*roles = rw.readDecr("file4.txt");		
		role = roles.get(i);		
		if (role.equals("employee"))	{		
			  filename = "Employees/user" + i +".txt";
			  employees = rw.read("employees.txt");		
			  
		}
		else {
			  filename = "Companies/user" + i +".txt";
			  companies = rw.read("companies.txt");			 
		}			
		
			  File File=new File(filename);
			  try {
				File.createNewFile();
			} catch (IOException e2) {				
				e2.printStackTrace();
			}			  
		qual = rw.read(filename);*/	
		
		
		
		JButton btnNewButton_1 = new JButton("Save");	
		
		btnNewButton_1.setBackground(new Color(47, 79, 79));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(659, 649, 149, 47);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Load");	
		
		btnNewButton_2.setBackground(new Color(47, 79, 79));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(159, 649, 149, 47);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("General Qualifications:");
		lblNewLabel.setBounds(15, 15, 155, 20);
		contentPane.add(lblNewLabel);
		
		radioButtons[0] = new JRadioButton("University Degree in STEM");
		radioButtons[0].setBounds(25, 41, 499, 20);
		contentPane.add(radioButtons[0]);
		
		radioButtons[1] = new JRadioButton("Work experience at least 1 year");
		radioButtons[1].setBounds(25, 63, 299, 21);
		contentPane.add(radioButtons[1]);
		
		radioButtons[2] = new JRadioButton("Vaccination certificate");
		radioButtons[2].setBounds(25, 87, 233, 21);
		contentPane.add(radioButtons[2]);
		
		radioButtons[3] = new JRadioButton("B2 level English degree");
		radioButtons[3].setBounds(25, 110, 243, 21);
		contentPane.add(radioButtons[3]);
		
		radioButtons[4] = new JRadioButton("C2 level English degree");
		radioButtons[4].setBounds(25, 133, 216, 21);
		contentPane.add(radioButtons[4]);
		
		radioButtons[5] = new JRadioButton("Driving license");
		radioButtons[5].setBounds(25, 156, 164, 21);
		contentPane.add(radioButtons[5]);
		
		JLabel lblNewLabel_1 = new JLabel("Marital Status:");
		lblNewLabel_1.setBounds(25, 206, 85, 13);
		contentPane.add(lblNewLabel_1);
		
		radioButtons[6] = new JRadioButton("married");
		radioButtons[6].setBounds(126, 202, 85, 21);
		contentPane.add(radioButtons[6]);
		
		radioButtons[7] = new JRadioButton("unmarried");
		radioButtons[7].setBounds(221, 202, 103, 21);
		contentPane.add(radioButtons[7]);
		
		radioButtons[8] = new JRadioButton("Fulfilled military obligations");
		radioButtons[8].setBounds(25, 179, 205, 21);
		contentPane.add(radioButtons[8]);
		
		JLabel lblNewLabel_2 = new JLabel("Additional qualifications:");
		lblNewLabel_2.setBounds(15, 251, 155, 20);
		contentPane.add(lblNewLabel_2);
		
		radioButtons[9] = new JRadioButton("Java");
		radioButtons[9].setBounds(25, 270, 103, 21);
		contentPane.add(radioButtons[9]);
		
		radioButtons[10] = new JRadioButton("JavaScript");
		radioButtons[10].setBounds(225, 270, 103, 21);
		contentPane.add(radioButtons[10]);
		
		radioButtons[11] = new JRadioButton("TypeScript");
		radioButtons[11].setBounds(425, 270, 103, 21);
		contentPane.add(radioButtons[11]);
		
		radioButtons[12] = new JRadioButton("C");
		radioButtons[12].setBounds(25, 295, 103, 21);
		contentPane.add(radioButtons[12]);
		
		radioButtons[13] = new JRadioButton("C++");
		radioButtons[13].setBounds(225, 295, 103, 21);
		contentPane.add(radioButtons[13]);
		
		radioButtons[14]= new JRadioButton("C#");
		radioButtons[14].setBounds(425, 295, 103, 21);
		contentPane.add(radioButtons[14]);
		
		radioButtons[15] = new JRadioButton("Python");
		radioButtons[15].setBounds(625, 270, 103, 21);
		contentPane.add(radioButtons[15]);
		
		radioButtons[16] = new JRadioButton("HTML");
		radioButtons[16].setBounds(625, 295, 103, 21);
		contentPane.add(radioButtons[16]);
		
		radioButtons[17] = new JRadioButton("CSS");
		radioButtons[17].setBounds(825, 295, 103, 21);
		contentPane.add(radioButtons[17]);
		
		radioButtons[18] = new JRadioButton("SQL");
		radioButtons[18].setBounds(25, 320, 103, 21);
		contentPane.add(radioButtons[18]);
		
		radioButtons[19] = new JRadioButton("MATLAB");
		radioButtons[19].setBounds(825, 270, 103, 21);
		contentPane.add(radioButtons[19]);
		
		radioButtons[20] = new JRadioButton("Visual Basic");
		radioButtons[20].setBounds(425, 320, 103, 21);
		contentPane.add(radioButtons[20]);
		
		radioButtons[21]= new JRadioButton("Visual Basic.Net");
		radioButtons[21].setBounds(625, 320, 134, 21);
		contentPane.add(radioButtons[21]);
		
		radioButtons[22] = new JRadioButton("Objective-C");
		radioButtons[22].setBounds(225, 320, 103, 21);
		contentPane.add(radioButtons[22]);
		
		radioButtons[23] = new JRadioButton("Swift");
		radioButtons[23].setBounds(825, 320, 103, 21);
		contentPane.add(radioButtons[23]);
		
		radioButtons[24] = new JRadioButton("Ruby");
		radioButtons[24].setBounds(25, 345, 103, 21);
		contentPane.add(radioButtons[24]);
		
		radioButtons[25] = new JRadioButton("Perl");
		radioButtons[25].setBounds(225, 345, 103, 21);
		contentPane.add(radioButtons[25]);
		
		radioButtons[26] = new JRadioButton("GO");
		radioButtons[26].setBounds(425, 345, 103, 21);
		contentPane.add(radioButtons[26]);
		
		radioButtons[27] = new JRadioButton("ASP");
		radioButtons[27].setBounds(25, 370, 103, 21);
		contentPane.add(radioButtons[27]);
		
		radioButtons[28] = new JRadioButton("R");
		radioButtons[28].setBounds(825, 345, 103, 21);
		contentPane.add(radioButtons[28]);
		
		radioButtons[29] = new JRadioButton("Assembly language");
		radioButtons[29].setBounds(625, 345, 134, 21);
		contentPane.add(radioButtons[29]);
		
		radioButtons[30] = new JRadioButton("XML");
		radioButtons[30].setBounds(225, 370, 103, 21);
		contentPane.add(radioButtons[30]);
		
		radioButtons[31]= new JRadioButton("AJAX");
		radioButtons[31].setBounds(425, 370, 103, 21);
		contentPane.add(radioButtons[31]);
		
		radioButtons[32]= new JRadioButton("JSON");
		radioButtons[32].setBounds(625, 370, 103, 21);
		contentPane.add(radioButtons[32]);
		
		radioButtons[33] = new JRadioButton("REST API");
		radioButtons[33].setBounds(825, 370, 103, 21);
		contentPane.add(radioButtons[33]);
		
		radioButtons[34] = new JRadioButton("Software Development");
		radioButtons[34].setBounds(25, 395, 164, 21);
		contentPane.add(radioButtons[34]);
		
		radioButtons[35] = new JRadioButton("PC Hardware");
		radioButtons[35].setBounds(225, 395, 121, 21);
		contentPane.add(radioButtons[35]);
		
		radioButtons[36] = new JRadioButton("E-Marketing");
		radioButtons[36].setBounds(425, 395, 103, 21);
		contentPane.add(radioButtons[36]);
		
		radioButtons[37] = new JRadioButton("Social Media");
		radioButtons[37].setBounds(625, 395, 117, 21);
		contentPane.add(radioButtons[37]);
		
		radioButtons[38] = new JRadioButton("Use of VPN");
		radioButtons[38].setBounds(825, 395, 103, 21);
		contentPane.add(radioButtons[38]);
		
		radioButtons[39]= new JRadioButton("Use of Big Query");
		radioButtons[39].setBounds(25, 420, 136, 21);
		contentPane.add(radioButtons[39]);
		
		radioButtons[40] = new JRadioButton("ARM Cortex-M 32-bit");
		radioButtons[40].setBounds(225, 420, 164, 21);
		contentPane.add(radioButtons[40]);
		
		radioButtons[41] = new JRadioButton("Modile Applications");
		radioButtons[41].setBounds(425, 418, 134, 21);
		contentPane.add(radioButtons[41]);
		
		radioButtons[42] = new JRadioButton("ERP");
		radioButtons[42].setBounds(625, 420, 103, 21);
		contentPane.add(radioButtons[42]);
		
		radioButtons[43] = new JRadioButton("SAP");
		radioButtons[43].setBounds(825, 420, 103, 21);
		contentPane.add(radioButtons[43]);
		
		radioButtons[44] = new JRadioButton("Photoshop");
		radioButtons[44].setBounds(25, 445, 103, 21);
		contentPane.add(radioButtons[44]);
		
		radioButtons[45] = new JRadioButton("Adobe Illustrator");
		radioButtons[45].setBounds(225, 445, 121, 21);
		contentPane.add(radioButtons[45]);
		
		radioButtons[46] = new JRadioButton("UI/UX Design");
		radioButtons[46].setBounds(425, 445, 121, 21);
		contentPane.add(radioButtons[46]);
		
		radioButtons[47] = new JRadioButton("JSF");
		radioButtons[47].setBounds(625, 445, 103, 21);
		contentPane.add(radioButtons[47]);
		
		JLabel lblNewLabel_3 = new JLabel("Operating System:");
		lblNewLabel_3.setBounds(25, 494, 121, 13);
		contentPane.add(lblNewLabel_3);
		
		radioButtons[48]= new JRadioButton("Android");
		radioButtons[48].setBounds(160, 490, 103, 21);
		contentPane.add(radioButtons[48]);
		
		radioButtons[49] = new JRadioButton("Linux");
		radioButtons[49].setBounds(280, 490, 103, 21);
		contentPane.add(radioButtons[49]);
		
		radioButtons[50] = new JRadioButton("Unix");
		radioButtons[50].setBounds(400, 490, 103, 21);
		contentPane.add(radioButtons[50]);
		
		radioButtons[51] = new JRadioButton("MacOS");
		radioButtons[51].setBounds(520, 490, 103, 21);
		contentPane.add(radioButtons[51]);
		
		radioButtons[52] = new JRadioButton("Ubuntu");
		radioButtons[52].setBounds(640, 490, 103, 21);
		contentPane.add(radioButtons[52]);
		
		JLabel lblNewLabel_4 = new JLabel("CMS:");
		lblNewLabel_4.setBounds(25, 520, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		radioButtons[53] = new JRadioButton("WordPress");
		radioButtons[53].setBounds(160, 515, 103, 21);
		contentPane.add(radioButtons[53]);
		
		radioButtons[54] = new JRadioButton("Joomla");
		radioButtons[54].setBounds(280, 515, 103, 21);
		contentPane.add(radioButtons[54]);
		
		radioButtons[55] = new JRadioButton("Drupal");
		radioButtons[55].setBounds(400, 515, 103, 21);
		contentPane.add(radioButtons[55]);
		
		radioButtons[56]= new JRadioButton("OpenCart");
		radioButtons[56].setBounds(520, 515, 103, 21);
		contentPane.add(radioButtons[56]);
		
		radioButtons[57]= new JRadioButton("PrestaShop");
		radioButtons[57].setBounds(640, 515, 103, 21);
		contentPane.add(radioButtons[57]);
		
		JLabel lblNewLabel_5 = new JLabel("Microsoft Office:");
		lblNewLabel_5.setBounds(25, 545, 103, 13);
		contentPane.add(lblNewLabel_5);
		
		radioButtons[58] = new JRadioButton("Word");
		radioButtons[58].setBounds(160, 540, 103, 21);
		contentPane.add(radioButtons[58]);
		
		radioButtons[59] = new JRadioButton("Excel");
		radioButtons[59].setBounds(280, 540, 103, 21);
		contentPane.add(radioButtons[59]);
		
		radioButtons[60] = new JRadioButton("Access");
		radioButtons[60].setBounds(400, 540, 103, 21);
		contentPane.add(radioButtons[60]);
		
		radioButtons[61]= new JRadioButton("PowerPoint");
		radioButtons[61].setBounds(520, 540, 103, 21);
		contentPane.add(radioButtons[61]);
		
		radioButtons[62] = new JRadioButton("Windows");
		radioButtons[62].setBounds(640, 540, 103, 21);
		contentPane.add(radioButtons[62]);
		
		radioButtons[63] = new JRadioButton("Outlook-Internet");
		radioButtons[63].setBounds(760, 540, 128, 21);
		contentPane.add(radioButtons[63]);	
		
		try {					
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hirenetdb", 
			"root", "hnppass21");
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery("select id from quals where id = '"+y+"'");			
			if (!rs.next()) {
				state.executeUpdate("INSERT INTO `hirenetdb`.`quals` (`id`) VALUES ('"+y+"');");
			}
			rs.close(); 
            state.close(); 
            conn.close(); 
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		/*
		int j=0;
		for (String state : qual) {
			if (state.equals("TRUE"))
				radioButtons[j].doClick();
			j++;
			}	
		*/
				//sql				
				try {					
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hirenetdb", 
					"root", "hnppass21");					
					Statement state = conn.createStatement();
					for (int j=0;j<64;j++) {
					ResultSet rs = state.executeQuery("select `"+radioButtons[j].getLabel()+"` from quals where id = "+y+"");
					rs.next();
					if (rs.getString(""+radioButtons[j].getLabel()+"").equals("true"))
						radioButtons[j].doClick();						
					}
					
		               state.close(); 
		               conn.close(); 
				}
				catch (Exception exc){
					exc.printStackTrace();
				}
		}
	});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				/*
				int	j=0;				
				for (j=0; j<64; j++)	{					
					if (radioButtons[j].isSelected()) 
						qual2.add("TRUE");				
					else
						qual2.add("FALSE");
				}			
			rw.writeList(filename, qual2, false, false);
			String r = i+"";
			if (role.equals("employee") && !employees.contains(r))
				rw.writeText("employees.txt", i+"", true, false);
			if (role.equals("company") && !companies.contains(r))
				rw.writeText("companies.txt", i+"", true, false);	
				*/
				//sql
				
				for (int j=0; j<64; j++) {
					if (radioButtons[j].isSelected())
					{
						try {					
							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hirenetdb", 
							"root", "hnppass21");
							Statement state = conn.createStatement();
							state.executeUpdate("update quals set `"+radioButtons[j].getLabel()+"` = 'true' where id = '"+y+"'");							
							}
						catch (Exception exc){
							exc.printStackTrace();
							}
					}
					else
					{
						try {					
							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hirenetdb", 
							"root", "hnppass21");
							Statement state = conn.createStatement();
							state.executeUpdate("update quals set `"+radioButtons[j].getLabel()+"` = 'false' where id = '"+y+"'");							
							}
						catch (Exception exc){
							exc.printStackTrace();
							}
					}
				}				
			dispose();
			}			
		});
		
		this.setVisible(true);
		this.setTitle("Qualifications");
	}
}
