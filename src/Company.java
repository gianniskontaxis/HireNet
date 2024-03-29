import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ScrollPaneConstants;
import java.awt.SystemColor;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;

public class Company extends JFrame {

	private int i; // id of user.
	private JPanel contentPane;		
	private DefaultListModel usernameModel;	
	private DefaultListModel scoreModel;	
	private DefaultListModel scoreModel2;
	private JList usernameList = new JList();
	private JList scoreList = new JList();
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql="";
	private DefaultListModel qualModel;
	private int clicks=0;
	
	// Create the Frame.
	
	public Company(int i) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Company.class.getResource("/Images/logo_icon25x25.png")));
		setResizable(false);
		
		this.i=i;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, 50, 1000, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(450, 193, 286, 211);
		contentPane.add(scrollPane_1);
		
		JPanel panel = new JPanel();
		scrollPane_1.setViewportView(panel);
		
		JButton profile = new JButton("Profile");
		profile.setHorizontalAlignment(SwingConstants.LEFT);
		profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Profile(i);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Employees");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Graphs(i);
				
			}
		});
		
		JButton select = new JButton("Companies");
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				new Graphs2(i);
			}
		});
		
		
		
		JList list = new JList();
		list.setBackground(new Color(255, 255, 255));
		list.setBounds(757, 193, 206, 211);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(757, 193, 206, 211);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(list);
		qualModel = new DefaultListModel();
		list.setModel(qualModel);
		
		JButton ButtonRef = new JButton("");
		ButtonRef.setIcon(new ImageIcon(Company.class.getResource("/Images/refresh_icon.png")));
		ButtonRef.setBounds(925, 161, 32, 32);
		ButtonRef.setOpaque(false);
		ButtonRef.setContentAreaFilled(false);
		ButtonRef.setBorderPainted(false);
		ButtonRef.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		contentPane.add(ButtonRef);
		ButtonRef.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// K��������� ��� qual.
				
				FileManager rd = new FileManager();
				ArrayList<String> column = new ArrayList<>();					
				column = rd.read("quals.txt");
				//anagnosh epilegmanvnapaithsevn etairias
				sql = "select * from quals where id = '"+i+"'";

			       try {
			   		conn = DBConnection.ConnDB();

		        	ps = conn.prepareStatement(sql);
			  		rs = ps.executeQuery();	
			  		
			  		qualModel.clear();
						
					for (int j=0; j<64; j++ ) {
							
						if (rs.getString(column.get(j)).equals("true")) {						
									qualModel.addElement(column.get(j));							
						}										
					}

							
					ps.execute();
					conn.close();
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(Company.class.getResource("/Images/doublearrow_icon.png")));
		lblNewLabel_12.setBounds(370, 270, 52, 65);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_16_1 = new JLabel("the qualifications graph for:");
		lblNewLabel_16_1.setForeground(Color.WHITE);
		lblNewLabel_16_1.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_16_1.setBounds(504, 556, 280, 27);
		contentPane.add(lblNewLabel_16_1);
		
		JLabel lblNewLabel_16 = new JLabel("You can always check");
		lblNewLabel_16.setForeground(Color.WHITE);
		lblNewLabel_16.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_16.setBounds(504, 533, 280, 27);
		contentPane.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setIcon(new ImageIcon(Company.class.getResource("/Images/graph_icon2.png")));
		lblNewLabel_17.setBounds(423, 530, 58, 53);
		contentPane.add(lblNewLabel_17);
		
		JLabel lblNewLabel_15 = new JLabel("Don't forget !");
		lblNewLabel_15.setForeground(Color.WHITE);
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_15.setBounds(224, 539, 189, 32);
		contentPane.add(lblNewLabel_15);
		
		JLabel lblNewLabel_21_1 = new JLabel("Skills");
		lblNewLabel_21_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_21_1.setForeground(Color.WHITE);
		lblNewLabel_21_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_21_1.setBounds(764, 161, 106, 32);
		contentPane.add(lblNewLabel_21_1);
		
		JLabel lblNewLabel_21 = new JLabel("Employee");
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_21.setForeground(Color.WHITE);
		lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_21.setBounds(569, 161, 87, 32);
		contentPane.add(lblNewLabel_21);
		
		JLabel lblNewLabel_20 = new JLabel("Match");
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_20.setForeground(Color.WHITE);
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_20.setBounds(520, 161, 58, 32);
		contentPane.add(lblNewLabel_20);
		
		JLabel lblNewLabel_13 = new JLabel("Requirements");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_13.setBounds(820, 103, 152, 27);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_18_1 = new JLabel("");
		lblNewLabel_18_1.setIcon(new ImageIcon(Company.class.getResource("/Images/skill.png")));
		lblNewLabel_18_1.setBounds(760, 86, 60, 60);
		contentPane.add(lblNewLabel_18_1);
		
		JLabel lblNewLabel_13_2 = new JLabel("Matching Results");
		lblNewLabel_13_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_13_2.setForeground(Color.WHITE);
		lblNewLabel_13_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_13_2.setBounds(537, 104, 181, 27);
		contentPane.add(lblNewLabel_13_2);
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setIcon(new ImageIcon(Company.class.getResource("/Images/mathcing_icon.png")));
		lblNewLabel_18.setBounds(475, 86, 52, 60);
		contentPane.add(lblNewLabel_18);
		
		select.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		select.setForeground(new Color(255, 255, 255));
		select.setBackground(new Color(0, 0, 0));
		select.setBounds(794, 559, 147, 27);
		contentPane.add(select);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setBounds(794, 522, 147, 27);
		contentPane.add(btnNewButton_2);	
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(Company.class.getResource("/Images/background6.png")));
		lblNewLabel_14.setBounds(206, 500, 757, 108);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_19_1 = new JLabel("");
		lblNewLabel_19_1.setIcon(new ImageIcon(Company.class.getResource("/Images/black.png")));
		lblNewLabel_19_1.setForeground(Color.WHITE);
		lblNewLabel_19_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_19_1.setBounds(757, 161, 206, 32);
		contentPane.add(lblNewLabel_19_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setIcon(new ImageIcon(Company.class.getResource("/Images/black.png")));
		lblNewLabel_3_1_1.setBounds(757, 86, 206, 60);
		contentPane.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(Company.class.getResource("/Images/background6.png")));
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setBounds(450, 86, 286, 60);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_7_1_3 = new JLabel("employees");
		lblNewLabel_7_1_3.setForeground(Color.BLACK);
		lblNewLabel_7_1_3.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_7_1_3.setBounds(244, 244, 134, 27);
		contentPane.add(lblNewLabel_7_1_3);
		
		JLabel lblNewLabel_7_1_2 = new JLabel("for suitable");
		lblNewLabel_7_1_2.setForeground(Color.BLACK);
		lblNewLabel_7_1_2.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_7_1_2.setBounds(244, 207, 134, 27);
		contentPane.add(lblNewLabel_7_1_2);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("Search");
		lblNewLabel_7_1_1.setForeground(Color.BLACK);
		lblNewLabel_7_1_1.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_7_1_1.setBounds(244, 170, 87, 27);
		contentPane.add(lblNewLabel_7_1_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("");
		lblNewLabel_6_1.setIcon(new ImageIcon(Company.class.getResource("/Images/smallarrow_black.png")));
		lblNewLabel_6_1.setBounds(206, 168, 32, 32);
		contentPane.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("qualifications");
		lblNewLabel_7_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_7_1.setBounds(244, 81, 134, 27);
		contentPane.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_7 = new JLabel("Fill the");
		lblNewLabel_7.setForeground(new Color(0, 0, 0));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_7.setBounds(244, 49, 104, 27);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Company.class.getResource("/Images/smallarrow_black.png")));
		lblNewLabel_6.setBounds(206, 45, 32, 32);
		contentPane.add(lblNewLabel_6);
		
		JLabel label_mess_1_1_1_1 = new JLabel("");
		label_mess_1_1_1_1.setIcon(new ImageIcon(Company.class.getResource("/Images/logout_icon.png")));
		label_mess_1_1_1_1.setBounds(34, 291, 32, 32);
		contentPane.add(label_mess_1_1_1_1);
		
		JButton Logoutbtn = new JButton("Log Out");
		Logoutbtn.setOpaque(false);
		Logoutbtn.setHorizontalAlignment(SwingConstants.LEFT);
		Logoutbtn.setForeground(new Color(0, 102, 102));
		Logoutbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		Logoutbtn.setContentAreaFilled(false);
		Logoutbtn.setBorderPainted(false);
		Logoutbtn.setBounds(52, 291, 120, 32);
		contentPane.add(Logoutbtn);
		Logoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login();
			} });
		
		
		JLabel label_mess_1_1_1 = new JLabel("");
		label_mess_1_1_1.setIcon(new ImageIcon(Company.class.getResource("/Images/support_icon.png")));
		label_mess_1_1_1.setBounds(34, 249, 32, 32);
		contentPane.add(label_mess_1_1_1);
		
		JLabel label_mess_1_1 = new JLabel("");
		label_mess_1_1.setIcon(new ImageIcon(Company.class.getResource("/Images/aboutus_icon.png")));
		label_mess_1_1.setBounds(34, 207, 32, 32);
		contentPane.add(label_mess_1_1);
		
		JLabel label_mess_1 = new JLabel("");
		label_mess_1.setIcon(new ImageIcon(Company.class.getResource("/Images/articles_icon.png")));
		label_mess_1.setBounds(34, 165, 32, 32);
		contentPane.add(label_mess_1);
		
		JLabel label_mess = new JLabel("");
		label_mess.setIcon(new ImageIcon(Company.class.getResource("/Images/messages_icon.png")));
		label_mess.setBounds(34, 123, 32, 32);
		contentPane.add(label_mess);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Company.class.getResource("/Images/notifications_icon.png")));
		lblNewLabel_1.setBounds(34, 81, 32, 32);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNotifications = new JButton("Notifications");
		btnNotifications.setHorizontalAlignment(SwingConstants.LEFT);
		btnNotifications.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNotifications.setForeground(new Color(0, 102, 102));
		btnNotifications.setBounds(52, 81, 134, 32);
		btnNotifications.setOpaque(false);
		btnNotifications.setContentAreaFilled(false);
		btnNotifications.setBorderPainted(false);
		contentPane.add(btnNotifications);
		btnNotifications.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Notifications(i);
				} catch (SQLException e1) {							
					e1.printStackTrace();
				}			}
		});
		
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Company.class.getResource("/Images/company_profile.png")));
		lblNewLabel.setBounds(34, 40, 32, 32);
		contentPane.add(lblNewLabel);
		profile.setForeground(new Color(0, 102, 102));
		profile.setFont(new Font("Tahoma", Font.BOLD, 15));
		profile.setBackground(new Color(47, 79, 79));
		profile.setBounds(52, 40, 98, 32);
		profile.setOpaque(false);
		profile.setContentAreaFilled(false);
		profile.setBorderPainted(false);
		contentPane.add(profile);
		
		JButton quals = new JButton("form");
		quals.setHorizontalAlignment(SwingConstants.LEADING);
		quals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Qualifications(i);
			}
		});
		quals.setForeground(new Color(0, 102, 102));
		quals.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		quals.setBackground(new Color(47, 79, 79));
		quals.setBounds(227, 114, 97, 32);
		quals.setOpaque(false);
		quals.setContentAreaFilled(false);
		quals.setBorderPainted(false);
		quals.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		contentPane.add(quals);
		
		JButton results = new JButton("");
		results.setIcon(new ImageIcon(Company.class.getResource("/Images/search_icon.png")));
		results.setForeground(new Color(255, 255, 255));
		results.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		results.setBackground(new Color(255, 255, 255));
		results.setBounds(244, 285, 116, 35);
		contentPane.add(results);
		
		
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBackground(Color.WHITE);
		scrollBar.setBounds(946, 244, 17, 117);
		contentPane.add(scrollBar);		
		usernameList.setForeground(new Color(0, 102, 102));
		
		usernameList.setBackground(SystemColor.menu);
		usernameList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		usernameList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
		scoreList.setForeground(new Color(0, 102, 102));
		
		scoreList.setBackground(SystemColor.menu);
		scoreList.setSelectionBackground(Color.LIGHT_GRAY);
		
		
		usernameModel = new DefaultListModel();
		usernameList.setModel(usernameModel);
		
		scoreModel = new DefaultListModel();
		scoreList.setModel(scoreModel);	
		
		
		
		JList score2List = new JList();
		score2List.setForeground(new Color(0, 102, 102));		
		score2List.setBackground(SystemColor.menu);
		score2List.setSelectionBackground(Color.LIGHT_GRAY);
		score2List.setVisible(false);
		panel.setLayout(new MigLayout("", "[1px][1px][1px]", "[1px]"));
		
		panel.add(score2List, "cell 0 0,alignx left,aligny top");
		panel.add(scoreList, "cell 1 0,alignx left,aligny top");
		panel.add(usernameList, "cell 2 0,alignx left,aligny top");
		
		scoreModel2 = new DefaultListModel();
		score2List.setModel(scoreModel2);
		
		results.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				/* ������� �� files.
				// ������� ��� ID ��� ������� ��� ����� ����� �� ������ ��������� ������������ ����� �� qualifications.
				String line="";
				employeesIDs = rw.read("employees.txt");
				
				namesUser = rw.readDecr("file3.txt");
				
				//initialize the list of lists.
				for (int j = 0; j <employeesIDs.size(); j++) {
		            employees.add(new ArrayList<String>());
		        }		
				
				//������� ��� qualifications ���� ��� ������� �� ��� ����� ��� ������.
				for (int j=0; j< employeesIDs.size() ; j++) {					
					filename= "Employees/user" + employeesIDs.get(j) + ".txt";					
					employees.set(j, rw.read(filename));					
				}
				
				//������� ��� ����� ��� qualifications ��� ������� ������.				
				filename = "Companies/user" + i + ".txt";				
				company = rw.read(filename);
				
				int score=0;
				for (int j=0; j< employeesIDs.size(); j++ ) {
					score=0;			
					for (int k=0; k<64; k++) {		
						
						if ( company.get(k).equals(employees.get(j).get(k)) && company.get(k).equals("TRUE") ) {							
							score++;					
						}	
						
					}		
					matches.add(score);			
				}
				int pl=0;
				for(String sun: company) {
					if(sun.equals("TRUE")) {
						pl++;
					}	
				}
				for (int j=0;j< employeesIDs.size();j++) {	
					int s = Integer.parseInt(employeesIDs.get(j));
					int o = matches.get(j);
					double sc=((o*1.0)/pl*1.0)*100;
					sc = Math.ceil(sc);
				
					model.addElement(namesUser.get(s) + " matches with score: "  + sc    +" % \n");
				}*/	
				
				
				//������� �� SQLite.
				
				usernameModel.clear();
				scoreModel.clear();
				scoreModel2.clear();
				
				Matching mr = new Matching(i,"employee",true);
				ArrayList<String> scoreResults = new ArrayList<>();
				ArrayList<String> usernameResults = new ArrayList<>();
				ArrayList<String> scoreResults2 = new ArrayList<>();
				
				usernameResults = mr.getUsernameResults();
				scoreResults = mr.getScoreResults();
				scoreResults2 = mr.getScoreResults2();
				usernameModel.addAll(usernameResults);
				scoreModel.addAll(scoreResults);		
				scoreModel2.addAll(scoreResults2);	
			}
			
		});
		
		
		JButton AboutUs_btn = new JButton("AboutUs");
		AboutUs_btn.setHorizontalAlignment(SwingConstants.LEFT);
		AboutUs_btn.setForeground(new Color(0, 102, 102));
		AboutUs_btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		AboutUs_btn.setBounds(52, 207, 117, 32);
		AboutUs_btn.setOpaque(false);
		AboutUs_btn.setContentAreaFilled(false);
		AboutUs_btn.setBorderPainted(false);
		contentPane.add(AboutUs_btn);
		AboutUs_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				new AboutUs();
			}
		});	
		
		
		JButton Messagesbtn = new JButton("Messages");
		Messagesbtn.setHorizontalAlignment(SwingConstants.LEFT);
		Messagesbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		Messagesbtn.setForeground(new Color(0, 102, 102));
		Messagesbtn.setBounds(52, 123, 117, 32);
		Messagesbtn.setOpaque(false);
		Messagesbtn.setContentAreaFilled(false);
		Messagesbtn.setBorderPainted(false);
		contentPane.add(Messagesbtn);
		
		Messagesbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				new Messages(i);
			}
		});	
		

		JButton articlesbtn = new JButton("Articles");
		articlesbtn.setHorizontalAlignment(SwingConstants.LEFT);
		articlesbtn.setForeground(new Color(0, 102, 102));
		articlesbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		articlesbtn.setBounds(52, 165, 117, 32);
		articlesbtn.setOpaque(false);
		articlesbtn.setContentAreaFilled(false);
		articlesbtn.setBorderPainted(false);
		contentPane.add(articlesbtn);
		articlesbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				new Articles();
			}
		});	
		
		JButton Sup = new JButton("Support");
		Sup.setForeground(new Color(0, 102, 102));
		Sup.setFont(new Font("Tahoma", Font.BOLD, 15));
		Sup.setHorizontalAlignment(SwingConstants.LEFT);
		Sup.setBounds(52, 249, 99, 32);
		Sup.setOpaque(false);
		Sup.setContentAreaFilled(false);
		Sup.setBorderPainted(false);
		contentPane.add(Sup);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Company.class.getResource("/Images/whitelong2.png")));
		lblNewLabel_3.setBounds(25, 25, 147, 583);
		contentPane.add(lblNewLabel_3);	
		
		JLabel lblNewLabel_20_1 = new JLabel("C. Match");
		lblNewLabel_20_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_20_1.setForeground(Color.WHITE);
		lblNewLabel_20_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_20_1.setBounds(454, 161, 73, 32);
		contentPane.add(lblNewLabel_20_1);
		
		JButton Match2 = new JButton("");
		Match2.setIcon(new ImageIcon(Company.class.getResource("/Images/add_column.png")));
		Match2.setRequestFocusEnabled(false);
		Match2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Match2.setBorderPainted(false);
		Match2.setOpaque(false);
		Match2.setForeground(new Color(255, 255, 255));
		Match2.setBackground(new Color(0, 132, 152));
		Match2.setFont(new Font("Tahoma", Font.PLAIN, 12));		
		Match2.setBounds(706, 163, 30, 30);
		contentPane.add(Match2);
		
		Match2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicks++;
				if ((clicks+1)%2==0) 
					score2List.setVisible(true);
				
				else 
					score2List.setVisible(false);				
		   }
		});
		
		JLabel lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setIcon(new ImageIcon(Company.class.getResource("/Images/background6.png")));
		lblNewLabel_19.setForeground(Color.WHITE);
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_19.setBounds(450, 161, 286, 32);
		contentPane.add(lblNewLabel_19);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Company.class.getResource("/Images/whitelong.png")));
		lblNewLabel_4.setBounds(450, 193, 79, 211);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Company.class.getResource("/Images/company_bck.png")));
		lblNewLabel_2.setBounds(0, 0, 986, 633);
		contentPane.add(lblNewLabel_2);
		
		
		
		
		Sup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				new Support();
			}
		});	
		
		usernameList.addMouseListener(new MouseListener () {		
			
			@Override
			public void mouseClicked(MouseEvent e) {
					
				try {
					/*new MatchingInfo(usernameList.getSelectedValue()+"",i);*/
					new CvMatching(usernameList.getSelectedValue()+"",i);

				} catch (SQLException e1) {							
					e1.printStackTrace();
				}				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}	
		});
		
		
		this.setVisible(true);
		this.setTitle("Company");
	}
}
