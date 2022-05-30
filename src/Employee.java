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
	
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee frame = new Employee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
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
		
		JButton Seminars = new JButton("Watch our seminars");
		Seminars.setHorizontalAlignment(SwingConstants.LEFT);
		Seminars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Seminar(i);
			}
		});
		
		JLabel lblNewLabel_18_1 = new JLabel("");
		lblNewLabel_18_1.setIcon(new ImageIcon(Employee.class.getResource("/Images/request_icon.png")));
		lblNewLabel_18_1.setBounds(764, 128, 52, 53);
		contentPane.add(lblNewLabel_18_1);
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setIcon(new ImageIcon(Employee.class.getResource("/Images/mathcing_icon.png")));
		lblNewLabel_18.setBounds(537, 128, 52, 53);
		contentPane.add(lblNewLabel_18);
		
		JLabel lblNewLabel_13_1 = new JLabel("requested");
		lblNewLabel_13_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13_1.setForeground(Color.WHITE);
		lblNewLabel_13_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_13_1.setBounds(826, 148, 111, 27);
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
		
		JLabel lblNewLabel_13_2_1 = new JLabel("Companies");
		lblNewLabel_13_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_13_2_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_13_2_1.setBounds(599, 148, 134, 27);
		contentPane.add(lblNewLabel_13_2_1);
		
		JLabel lblNewLabel_13_2 = new JLabel("Matching");
		lblNewLabel_13_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_13_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_13_2.setBounds(599, 128, 116, 27);
		contentPane.add(lblNewLabel_13_2);
		
		JLabel lblNewLabel_13 = new JLabel("Most");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setBounds(826, 128, 58, 27);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(Employee.class.getResource("/Images/black.png")));
		lblNewLabel_3_1.setBounds(757, 123, 206, 60);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setIcon(new ImageIcon(Employee.class.getResource("/Images/background6.png")));
		lblNewLabel_3.setBounds(530, 123, 206, 60);
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
		lblNewLabel_12.setBounds(420, 271, 68, 65);
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
		lblNewLabel_5.setBounds(34, 123, 32, 32);
		contentPane.add(lblNewLabel_5);
		
		JButton LogOutbtn = new JButton("Log Out");
		LogOutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		LogOutbtn.setHorizontalAlignment(SwingConstants.RIGHT);
		LogOutbtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		LogOutbtn.setForeground(new Color(0, 102, 102));
		LogOutbtn.setBounds(34, 123, 120, 32);
		LogOutbtn.setOpaque(false);
		LogOutbtn.setContentAreaFilled(false);
		LogOutbtn.setBorderPainted(false);
		contentPane.add(LogOutbtn);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Employee.class.getResource("/Images/aboutus_icon.png")));
		lblNewLabel_4.setBounds(34, 81, 32, 32);
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
		Aboutusbtn.setHorizontalAlignment(SwingConstants.RIGHT);
		Aboutusbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AboutUs();
			}
		});
		Aboutusbtn.setForeground(new Color(0, 102, 102));
		Aboutusbtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		Aboutusbtn.setBackground(new Color(47, 79, 79));
		Aboutusbtn.setBounds(25, 81, 134, 32);
		Aboutusbtn.setOpaque(false);
		Aboutusbtn.setContentAreaFilled(false);
		Aboutusbtn.setBorderPainted(false);
		contentPane.add(Aboutusbtn);
		
		list = new JList();
		list.setBounds(757, 193, 206, 211);
		contentPane.add(list);
		
		model = new DefaultListModel();
		list.setModel(model);
		
		//Καταχωρηση των companies.		
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
		contentPane.add(CVbtn);
		
		JList usernameList = new JList();
		usernameList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		usernameList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		usernameList.setBounds(579, 193, 157, 211);
		contentPane.add(usernameList);
		
		usernameModel = new DefaultListModel();
		usernameList.setModel(usernameModel);
		
		JList scoreList = new JList();
		scoreList.setSelectionBackground(Color.WHITE);
		scoreList.setBounds(530, 193, 52, 211);
		contentPane.add(scoreList);
		
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
				
				//Μέθοδος με SQLite.
				
				usernameModel.clear();
				scoreModel.clear();
				
				Matching mr = new Matching(i,"company");
				ArrayList<String> scoreResults = new ArrayList<>();
				ArrayList<String> usernameResults = new ArrayList<>();
				
				usernameResults = mr.getUsernameResults();
				scoreResults = mr.getScoreResults();
				usernameModel.addAll(usernameResults);
				scoreModel.addAll(scoreResults);					
			}
		});
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(946, 259, 17, 48);
		contentPane.add(scrollBar);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(719, 247, 17, 48);
		contentPane.add(scrollBar_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Employee.class.getResource("/Images/profile_icon.png")));
		lblNewLabel_2.setBounds(34, 40, 32, 32);
		contentPane.add(lblNewLabel_2);
		
		JButton Profilebutton = new JButton("Profile");
		Profilebutton.setHorizontalAlignment(SwingConstants.TRAILING);
		Profilebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Profile(i);
			}
		});
		Profilebutton.setForeground(new Color(0, 102, 102));
		Profilebutton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		Profilebutton.setBackground(new Color(47, 79, 79));
		Profilebutton.setBounds(34, 40, 111, 32);
		Profilebutton.setOpaque(false);
		Profilebutton.setContentAreaFilled(false);
		Profilebutton.setBorderPainted(false);
		contentPane.add(Profilebutton);	
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Employee.class.getResource("/Images/whitelong2.png")));
		lblNewLabel.setBounds(25, 25, 147, 583);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Employee.class.getResource("/Images/employee_background.png")));
		lblNewLabel_1.setBounds(0, 0, 1000, 640);
		contentPane.add(lblNewLabel_1);
		
		
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
		this.setVisible(true);
		this.setTitle("Employee");
	}
}
