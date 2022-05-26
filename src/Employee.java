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

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

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
		
		this.i=i;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, 50, 750, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("If you want to watch our seminar click...");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(134, 114, 323, 60);
		contentPane.add(lblNewLabel);
		
		JButton btnHere = new JButton("Here!");
		btnHere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Seminar();
			}
		});
		btnHere.setForeground(Color.WHITE);
		btnHere.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnHere.setBackground(new Color(47, 79, 79));
		btnHere.setBounds(441, 127, 118, 37);
		contentPane.add(btnHere);
		
		JButton Aboutusbtn = new JButton("AboutUs!");
		Aboutusbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AboutUs();
			}
		});
		Aboutusbtn.setForeground(Color.WHITE);
		Aboutusbtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		Aboutusbtn.setBackground(new Color(47, 79, 79));
		Aboutusbtn.setBounds(441, 157, 118, 37);
		contentPane.add(Aboutusbtn);
		
		JLabel lblYourResults = new JLabel("Matcing results:");
		lblYourResults.setBackground(new Color(240, 240, 240));
		lblYourResults.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblYourResults.setBounds(478, 240, 149, 60);
		contentPane.add(lblYourResults);
		
		list = new JList();
		list.setBounds(100, 304, 206, 211);
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
		
		JButton btnNewButton_1 = new JButton("Write your CV");
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new cv(i);
			}
		});
		
		btnNewButton_1.setBackground(new Color(47, 79, 79));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(117, 549, 149, 47);
		contentPane.add(btnNewButton_1);
		
		JLabel lblWhatCompaniesWant = new JLabel("What Companies ask for the most:");
		lblWhatCompaniesWant.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWhatCompaniesWant.setBackground(SystemColor.menu);
		lblWhatCompaniesWant.setBounds(82, 240, 269, 60);
		contentPane.add(lblWhatCompaniesWant);
		
		JList usernameList = new JList();
		usernameList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		usernameList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		usernameList.setBounds(489, 304, 147, 211);
		contentPane.add(usernameList);
		
		usernameModel = new DefaultListModel();
		usernameList.setModel(usernameModel);
		
		JList scoreList = new JList();
		scoreList.setSelectionBackground(Color.WHITE);
		scoreList.setBounds(437, 304, 52, 211);
		contentPane.add(scoreList);
		
		scoreModel = new DefaultListModel();
		scoreList.setModel(scoreModel);
		
		JButton search = new JButton("Search");
		search.setForeground(Color.WHITE);
		search.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		search.setBackground(new Color(47, 79, 79));
		search.setBounds(459, 549, 149, 47);
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
		scrollBar.setBounds(219, 379, 17, 48);
		contentPane.add(scrollBar);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(516, 379, 17, 48);
		contentPane.add(scrollBar_1);
		
		JLabel lblFindTheSuitable_1 = new JLabel("Find the suitable Company");
		lblFindTheSuitable_1.setFont(new Font("Modern No. 20", Font.BOLD | Font.ITALIC, 33));
		lblFindTheSuitable_1.setBounds(47, 28, 435, 47);
		contentPane.add(lblFindTheSuitable_1);		
		
		JButton btnNewButton_2 = new JButton("Profile");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Profile(i);
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_2.setBackground(new Color(47, 79, 79));
		btnNewButton_2.setBounds(589, 39, 115, 32);
		contentPane.add(btnNewButton_2);	
		
		
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
