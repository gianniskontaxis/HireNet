import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;

public class Employee extends JFrame {
	
	private Connection conn = null;
	private DefaultListModel usernameModel;
	private JPanel contentPane;
	private int i;
	private DefaultListModel scoreModel;
	private DefaultListModel model;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private JList list;	
	private DefaultListModel scoreModel2;
	private int clicks=0;
	private boolean scoreDesk=true;
	private boolean flag=false;
	
	
	
	public Employee(int i) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Employee.class.getResource("/Images/logo_icon25x25.png")));
		
		this.i=i;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, 50, 1000, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(451, 193, 286, 211);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(757, 193, 206, 211);
		contentPane.add(scrollPane2);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		
		JButton Seminars = new JButton("Watch our seminars");
		Seminars.setHorizontalAlignment(SwingConstants.LEFT);
		Seminars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Seminar(i);
			}
		});
		Seminars.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		
		JButton btnSupport = new JButton("Support");
		btnSupport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Support();
			}
		});
		
		JButton btnArticles = new JButton("Articles");
		btnArticles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Articles();
				
			}
		});
		
		JLabel lblNewLabel_20_1 = new JLabel("Skill Match");
		lblNewLabel_20_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_20_1.setForeground(Color.WHITE);
		lblNewLabel_20_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_20_1.setBounds(470, 161, 69, 32);
		contentPane.add(lblNewLabel_20_1);
		
		
		btnArticles.setOpaque(false);
		btnArticles.setHorizontalAlignment(SwingConstants.LEFT);
		btnArticles.setForeground(new Color(0, 102, 102));
		btnArticles.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnArticles.setContentAreaFilled(false);
		btnArticles.setBorderPainted(false);
		btnArticles.setBackground(new Color(47, 79, 79));
		btnArticles.setBounds(52, 165, 117, 32);
		contentPane.add(btnArticles);
		
		JLabel lblNewLabel_22_1_1 = new JLabel("");
		lblNewLabel_22_1_1.setIcon(new ImageIcon(Employee.class.getResource("/Images/articles_icon.png")));
		lblNewLabel_22_1_1.setBounds(34, 165, 32, 32);
		contentPane.add(lblNewLabel_22_1_1);
		btnSupport.setOpaque(false);
		btnSupport.setHorizontalAlignment(SwingConstants.LEFT);
		btnSupport.setForeground(new Color(0, 102, 102));
		btnSupport.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSupport.setContentAreaFilled(false);
		btnSupport.setBorderPainted(false);
		btnSupport.setBackground(new Color(47, 79, 79));
		btnSupport.setBounds(52, 249, 99, 32);
		contentPane.add(btnSupport);
		
		JLabel lblNewLabel_22_3 = new JLabel("");
		lblNewLabel_22_3.setIcon(new ImageIcon(Employee.class.getResource("/Images/support_icon.png")));
		lblNewLabel_22_3.setBounds(34, 249, 32, 32);
		contentPane.add(lblNewLabel_22_3);
		
		JLabel lblNewLabel_22_1 = new JLabel("");
		lblNewLabel_22_1.setIcon(new ImageIcon(Employee.class.getResource("/Images/messages_icon.png")));
		lblNewLabel_22_1.setBounds(34, 123, 32, 32);
		contentPane.add(lblNewLabel_22_1);
		
		JButton btnMessages = new JButton("Messages");
		btnMessages.setOpaque(false);
		btnMessages.setHorizontalAlignment(SwingConstants.LEFT);
		btnMessages.setForeground(new Color(0, 102, 102));
		btnMessages.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMessages.setContentAreaFilled(false);
		btnMessages.setBorderPainted(false);
		btnMessages.setBackground(new Color(47, 79, 79));
		btnMessages.setBounds(52, 123, 117, 32);
		contentPane.add(btnMessages);
		btnMessages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Messages(i);

			}
		});
		
		JButton btnNotifications = new JButton("Notifications");
		btnNotifications.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Notifications(i);
				} catch (SQLException e1) {							
					e1.printStackTrace();
				}
				
				
			}
		});
		
		
		btnNotifications.setOpaque(false);
		btnNotifications.setHorizontalAlignment(SwingConstants.LEFT);
		btnNotifications.setForeground(new Color(0, 102, 102));
		btnNotifications.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNotifications.setContentAreaFilled(false);
		btnNotifications.setBorderPainted(false);
		btnNotifications.setBackground(new Color(47, 79, 79));
		btnNotifications.setBounds(52, 81, 134, 32);
		contentPane.add(btnNotifications);
		
		JLabel lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setIcon(new ImageIcon(Employee.class.getResource("/Images/notifications_icon.png")));
		lblNewLabel_22.setBounds(34, 81, 32, 32);
		contentPane.add(lblNewLabel_22);
		
		JLabel lblNewLabel_21_1 = new JLabel("Company");
		lblNewLabel_21_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_21_1.setForeground(Color.WHITE);
		lblNewLabel_21_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_21_1.setBounds(764, 161, 106, 32);
		contentPane.add(lblNewLabel_21_1);
		
		JLabel lblNewLabel_21 = new JLabel("Company");
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_21.setForeground(Color.WHITE);
		lblNewLabel_21.setBounds(610, 161, 99, 32);
		contentPane.add(lblNewLabel_21);
		
		JLabel lblNewLabel_20 = new JLabel("Match");
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_20.setForeground(Color.WHITE);
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_20.setBounds(551, 161, 69, 32);
		contentPane.add(lblNewLabel_20);
		
		JLabel lblNewLabel_19_1 = new JLabel("");
		lblNewLabel_19_1.setIcon(new ImageIcon(Employee.class.getResource("/Images/black.png")));
		lblNewLabel_19_1.setForeground(Color.WHITE);
		lblNewLabel_19_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_19_1.setBounds(757, 161, 206, 32);
		contentPane.add(lblNewLabel_19_1);
		
		JLabel lblNewLabel_18_1 = new JLabel("");
		lblNewLabel_18_1.setIcon(new ImageIcon(Employee.class.getResource("/Images/companysearch_icon.png")));
		lblNewLabel_18_1.setBounds(764, 86, 52, 60);
		contentPane.add(lblNewLabel_18_1);
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setIcon(new ImageIcon(Employee.class.getResource("/Images/mathcing_icon.png")));
		lblNewLabel_18.setBounds(475, 86, 52, 60);
		contentPane.add(lblNewLabel_18);
		
		JLabel lblNewLabel_13_1 = new JLabel("jobs");
		lblNewLabel_13_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_13_1.setForeground(Color.WHITE);
		lblNewLabel_13_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_13_1.setBounds(826, 111, 56, 27);
		contentPane.add(lblNewLabel_13_1);
		
		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setIcon(new ImageIcon(Employee.class.getResource("/Images/graph_icon2.png")));
		lblNewLabel_17.setBounds(423, 530, 58, 53);
		contentPane.add(lblNewLabel_17);
		
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
		
		JLabel lblNewLabel_15 = new JLabel("Don't forget !");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_15.setForeground(Color.WHITE);
		lblNewLabel_15.setBounds(224, 539, 189, 32);
		contentPane.add(lblNewLabel_15);
		
		JButton EmployeeGraphBtn = new JButton("Employees");
		EmployeeGraphBtn.setForeground(new Color(255, 255, 255));
		EmployeeGraphBtn.setBackground(new Color(0, 0, 0));
		EmployeeGraphBtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		EmployeeGraphBtn.setBounds(794, 522, 147, 27);
		contentPane.add(EmployeeGraphBtn);
		EmployeeGraphBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Graphs2(i);
			}
		});
		
		JButton CompanyGraphBtn = new JButton("Companies");
		CompanyGraphBtn.setForeground(new Color(255, 255, 255));
		CompanyGraphBtn.setBackground(new Color(0, 0, 0));
		CompanyGraphBtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		CompanyGraphBtn.setBounds(794, 559, 147, 27);
		contentPane.add(CompanyGraphBtn);
		CompanyGraphBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Graphs(i);
			}
		});
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(Employee.class.getResource("/Images/background6.png")));
		lblNewLabel_14.setBounds(206, 500, 757, 108);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_13_2 = new JLabel("Matching Results");
		lblNewLabel_13_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_13_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_13_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_13_2.setBounds(537, 104, 188, 27);
		contentPane.add(lblNewLabel_13_2);
		
		JLabel lblNewLabel_13 = new JLabel("Available");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setBounds(826, 93, 98, 27);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(Employee.class.getResource("/Images/black.png")));
		lblNewLabel_3_1.setBounds(757, 86, 206, 60);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setIcon(new ImageIcon(Employee.class.getResource("/Images/background6.png")));
		lblNewLabel_3.setBounds(450, 86, 286, 60);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_10_2 = new JLabel("enough yet?");
		lblNewLabel_10_2.setForeground(Color.WHITE);
		lblNewLabel_10_2.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_10_2.setBounds(244, 389, 134, 27);
		contentPane.add(lblNewLabel_10_2);
		
		JLabel lblNewLabel_10_1 = new JLabel("Not qualified");
		lblNewLabel_10_1.setForeground(Color.WHITE);
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_10_1.setBounds(244, 352, 134, 27);
		contentPane.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_9_1 = new JLabel("");
		lblNewLabel_9_1.setIcon(new ImageIcon(Employee.class.getResource("/Images/arrow_smallicon.png")));
		lblNewLabel_9_1.setBounds(206, 347, 32, 32);
		contentPane.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(Employee.class.getResource("/Images/double_arrow_icon.png")));
		lblNewLabel_12.setBounds(370, 285, 58, 38);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_11_1 = new JLabel("Companies");
		lblNewLabel_11_1.setForeground(Color.WHITE);
		lblNewLabel_11_1.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_11_1.setBounds(244, 230, 120, 27);
		contentPane.add(lblNewLabel_11_1);
		
		JLabel lblNewLabel_11 = new JLabel("for suitable");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setBounds(244, 193, 120, 27);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_10 = new JLabel("Search");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_10.setBounds(244, 156, 104, 27);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(Employee.class.getResource("/Images/arrow_smallicon.png")));
		lblNewLabel_9.setBounds(206, 148, 32, 32);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_8 = new JLabel("your ");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_8.setBounds(248, 86, 58, 27);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel("Complete");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_7.setBounds(244, 49, 104, 27);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Employee.class.getResource("/Images/arrow_smallicon.png")));
		lblNewLabel_6.setBounds(206, 45, 32, 32);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Employee.class.getResource("/Images/logout_icon.png")));
		lblNewLabel_5.setBounds(34, 291, 32, 32);
		contentPane.add(lblNewLabel_5);
		
		JButton LogOutbtn = new JButton("Log Out");
		LogOutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login();
			}
		});
		LogOutbtn.setHorizontalAlignment(SwingConstants.LEFT);
		LogOutbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		LogOutbtn.setForeground(new Color(0, 102, 102));
		LogOutbtn.setBounds(52, 291, 120, 32);
		LogOutbtn.setOpaque(false);
		LogOutbtn.setContentAreaFilled(false);
		LogOutbtn.setBorderPainted(false);
		contentPane.add(LogOutbtn);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Employee.class.getResource("/Images/aboutus_icon.png")));
		lblNewLabel_4.setBounds(34, 207, 32, 32);
		contentPane.add(lblNewLabel_4);
		Seminars.setForeground(new Color(51, 255, 204));
		Seminars.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		Seminars.setBackground(new Color(47, 79, 79));
		Seminars.setBounds(224, 426, 264, 37);
		Seminars.setOpaque(false);
		Seminars.setContentAreaFilled(false);
		Seminars.setBorderPainted(false);
		contentPane.add(Seminars);
		
		JButton Aboutusbtn = new JButton("AboutUs");
		Aboutusbtn.setHorizontalAlignment(SwingConstants.LEFT);
		Aboutusbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AboutUs();
			}
		});
		Aboutusbtn.setForeground(new Color(0, 102, 102));
		Aboutusbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		Aboutusbtn.setBackground(new Color(47, 79, 79));
		Aboutusbtn.setBounds(52, 207, 117, 32);
		Aboutusbtn.setOpaque(false);
		Aboutusbtn.setContentAreaFilled(false);
		Aboutusbtn.setBorderPainted(false);
		contentPane.add(Aboutusbtn);
		
		model = new DefaultListModel();
		
		//���������� ��� companies.		
		try {			
			String sql = "select * from users join quals where users.id = quals.id and role = 'company'";
			conn = DBConnection.ConnDB();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				model.addElement(rs.getString("username"));
					
			}
			ps.close();
			rs.close();
			conn.close();			
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
		
		JButton CVbtn = new JButton("CV");
		
		CVbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new cv(i);
			}
		});
		
		CVbtn.setBackground(new Color(47, 79, 79));
		CVbtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		CVbtn.setForeground(new Color(51, 255, 204));
		CVbtn.setBounds(284, 83, 68, 32);
		CVbtn.setOpaque(false);
		CVbtn.setContentAreaFilled(false);
		CVbtn.setBorderPainted(false);
		CVbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		contentPane.add(CVbtn);
		
		JList usernameList = new JList();
		usernameList.setBackground(SystemColor.menu);
		
		usernameList.setBorder(null);
		usernameList.setForeground(new Color(0, 102, 102));
		usernameList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		usernameList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		usernameList.setBounds(599, 193, 137, 211);
		
		
		usernameModel = new DefaultListModel();
		usernameList.setModel(usernameModel);
		
		JList scoreList = new JList();		
		scoreList.setBackground(SystemColor.menu);
		scoreList.setBorder(null);
		scoreList.setForeground(new Color(0, 102, 102));
		scoreList.setSelectionBackground(Color.WHITE);
		scoreList.setBounds(530, 193, 68, 211);
		
		
		scoreModel = new DefaultListModel();
		scoreList.setModel(scoreModel);
		
		JButton search = new JButton("");
		search.setIcon(new ImageIcon(Employee.class.getResource("/Images/search_icon.png")));
		search.setForeground(new Color(0, 0, 0));
		search.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		search.setBackground(new Color(255, 255, 255));
		search.setBounds(244, 285, 116, 35);
		contentPane.add(search);
	
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag=true;
				//������� �� SQLite.
				
				usernameModel.clear();
				scoreModel.clear();
				scoreModel2.clear();
				
				Matching mr = new Matching(i,"company",scoreDesk);
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
		
		
		JButton Match2 = new JButton("");
		Match2.setIcon(new ImageIcon(Employee.class.getResource("/Images/sort_icon.png")));
		Match2.setRequestFocusEnabled(false);
		Match2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Match2.setBorderPainted(false);
		Match2.setOpaque(false);
		Match2.setForeground(new Color(255, 255, 255));
		Match2.setBackground(new Color(0, 132, 152));
		Match2.setFont(new Font("Tahoma", Font.PLAIN, 12));		
		Match2.setBounds(706, 161, 30, 30);
		contentPane.add(Match2);
		
		Match2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag) {
				clicks++;
				if ((clicks+1)%2==0) {
					scoreDesk=false;
					search.doClick();
				}
				else {
					scoreDesk=true;
					search.doClick();
				}			
			  }
		   }
		});
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(719, 247, 17, 48);
		contentPane.add(scrollBar_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Employee.class.getResource("/Images/profile_icon.png")));
		lblNewLabel_2.setBounds(34, 40, 32, 32);
		contentPane.add(lblNewLabel_2);
		
		JButton Profilebutton = new JButton("Profile");
		Profilebutton.setHorizontalAlignment(SwingConstants.LEFT);
		Profilebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Profile(i);
			}
		});
		Profilebutton.setForeground(new Color(0, 102, 102));
		Profilebutton.setFont(new Font("Tahoma", Font.BOLD, 15));
		Profilebutton.setBackground(new Color(47, 79, 79));
		Profilebutton.setBounds(52, 40, 98, 32);
		Profilebutton.setOpaque(false);
		Profilebutton.setContentAreaFilled(false);
		Profilebutton.setBorderPainted(false);
		contentPane.add(Profilebutton);	
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Employee.class.getResource("/Images/whitelong2.png")));
		lblNewLabel.setBounds(25, 25, 147, 583);
		contentPane.add(lblNewLabel);
		
		scoreModel2 = new DefaultListModel();
		JList score2List = new JList();		
		score2List.setBackground(SystemColor.menu);
		score2List.setLocation(450, 193);
		score2List.setSize(79, 211);
		score2List.setBorder(null);
		score2List.setForeground(new Color(0, 102, 102));
		score2List.setSelectionBackground(Color.WHITE);
		panel.add(score2List);
		panel.add(scoreList);
		panel.add(usernameList);
		score2List.setModel(scoreModel2);
		
		
		
		JLabel lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setIcon(new ImageIcon(Employee.class.getResource("/Images/background6.png")));
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_19.setForeground(Color.WHITE);
		lblNewLabel_19.setBounds(450, 161, 286, 32);
		contentPane.add(lblNewLabel_19);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Employee.class.getResource("/Images/employee_background.png")));
		lblNewLabel_1.setBounds(-14, 10, 1000, 640);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_22_2 = new JLabel("");
		lblNewLabel_22_2.setBounds(34, 156, 32, 32);
		contentPane.add(lblNewLabel_22_2);
		
		list = new JList();
		scrollPane2.setViewportView(list);
		list.setBorder(null);
		list.setForeground(new Color(0, 0, 0));
		list.setBounds(57, 205, 206, 211);
		list.setModel(model);
		
		
		list.addMouseListener(new MouseListener () {		
			
			@Override
			public void mouseClicked(MouseEvent e) {
					
				try {
					new companyInfo(list.getSelectedValue()+"");
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
		
		
		
		usernameList.addMouseListener(new MouseListener () {		
			
			@Override
			public void mouseClicked(MouseEvent e) {
					
				try {
					new MatchingInfo(usernameList.getSelectedValue()+"",i);
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
		this.setTitle("Employee");
	}
}
