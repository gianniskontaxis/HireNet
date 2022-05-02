import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Company extends JFrame {

	private int i; // id of user.
	private JPanel contentPane;		
	private DefaultListModel usernameModel;	
	private DefaultListModel scoreModel;	
	private JList usernameList = new JList();
	private JList scoreList = new JList();
	
	// Create the Frame.
	
	public Company(int i) {
		
		this.i=i;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, 50, 750, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		
		JButton profile = new JButton("Profile");
		profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		profile.setForeground(new Color(255, 255, 255));
		profile.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		profile.setBackground(new Color(47, 79, 79));
		profile.setBounds(577, 39, 115, 32);
		contentPane.add(profile);
		
		JButton quals = new JButton("Write the qualifications");
		quals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Qualifications(i);
			}
		});
		quals.setForeground(new Color(255, 255, 255));
		quals.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		quals.setBackground(new Color(47, 79, 79));
		quals.setBounds(93, 138, 212, 55);
		contentPane.add(quals);
		
		JButton results = new JButton("Matching Results");
		results.setForeground(new Color(255, 255, 255));
		results.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		results.setBackground(new Color(47, 79, 79));
		results.setBounds(432, 138, 149, 55);
		contentPane.add(results);
		
		JList list = new JList();
		list.setBackground(Color.LIGHT_GRAY);
		list.setBounds(79, 219, 237, 268);
		contentPane.add(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBackground(Color.WHITE);
		scrollBar.setBounds(301, 270, 17, 117);
		contentPane.add(scrollBar);		
		
		usernameList.setBackground(Color.LIGHT_GRAY);
		usernameList.setBounds(451, 219, 177, 268);
		usernameList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		contentPane.add(usernameList);
		usernameList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
		
		scoreList.setBackground(Color.LIGHT_GRAY);
		scoreList.setSelectionBackground(Color.LIGHT_GRAY);
		scoreList.setBounds(391, 219, 60, 268);
		contentPane.add(scoreList);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBackground(Color.WHITE);
		scrollBar_1.setBounds(577, 270, 17, 117);
		contentPane.add(scrollBar_1);
		
		JLabel lblNewLabel = new JLabel("You can watch the analysis of...");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(391, 520, 255, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblFindTheSuitable = new JLabel("Find the suitable employee");
		lblFindTheSuitable.setFont(new Font("Modern No. 20", Font.BOLD | Font.ITALIC, 33));
		lblFindTheSuitable.setBounds(47, 28, 435, 47);
		contentPane.add(lblFindTheSuitable);
		
		JLabel lblNewLabel_1 = new JLabel("You can watch the analysis of...");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(79, 524, 272, 39);
		contentPane.add(lblNewLabel_1);		
		
		JButton btnNewButton_2 = new JButton("Graph1");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(47, 79, 79));
		btnNewButton_2.setBounds(117, 573, 137, 47);
		contentPane.add(btnNewButton_2);	
		
		usernameModel = new DefaultListModel();
		usernameList.setModel(usernameModel);
		
		scoreModel = new DefaultListModel();
		scoreList.setModel(scoreModel);
		
		results.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/* Μέθοδος με files.
				// φορτωση των ID των χρηστων του αλλου ρολου οι οποιοι διαθετουν αποθηκευμενη λιστα με qualifications.
				String line="";
				employeesIDs = rw.read("employees.txt");
				
				namesUser = rw.readDecr("file3.txt");
				
				//initialize the list of lists.
				for (int j = 0; j <employeesIDs.size(); j++) {
		            employees.add(new ArrayList<String>());
		        }		
				
				//φορτωση των qualifications ολων των χρηστων σε μια λιστα απο λιστες.
				for (int j=0; j< employeesIDs.size() ; j++) {					
					filename= "Employees/user" + employeesIDs.get(j) + ".txt";					
					employees.set(j, rw.read(filename));					
				}
				
				//φορτωση την λιστα των qualifications του ενεργου χρηστη.				
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
				
				
				//Μέθοδος με SQLite.
				
				usernameModel.clear();
				scoreModel.clear();
				
				Matching mr = new Matching(i,"employee");
				ArrayList<String> scoreResults = new ArrayList<>();
				ArrayList<String> usernameResults = new ArrayList<>();
				
				usernameResults = mr.getUsernameResults();
				scoreResults = mr.getScoreResults();
				usernameModel.addAll(usernameResults);
				scoreModel.addAll(scoreResults);				
			}
		});
		
		JButton select = new JButton("select");
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {							
					try {
						new MatchingInfo(usernameList.getSelectedValue()+"",i);
					} catch (SQLException e1) {							
						e1.printStackTrace();
					}					
			}
		});	
		
		select.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		select.setForeground(new Color(255, 255, 255));
		select.setBackground(new Color(47, 79, 79));
		select.setBounds(425, 573, 137, 47);
		contentPane.add(select);
		
		this.setVisible(true);
		this.setTitle("Company");
	}
}
