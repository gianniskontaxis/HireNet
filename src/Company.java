import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;

public class Company extends JFrame {

	private JPanel contentPane;
	private int i;
	private ArrayList<ArrayList<String>> employees = new ArrayList<ArrayList<String>>();
	private ArrayList<String> company = new ArrayList<>();
	private ArrayList<String> employeesIDs = new ArrayList<>();
	private ArrayList<String> namesUser = new ArrayList<>();
	private ArrayList<Integer> matches = new ArrayList<>();
	String filename="";
	private FileManager rw = new FileManager();
	private DefaultListModel model;



	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Company frame = new Company();
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
	public Company(int i) {
		
		this.i=i;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, 50, 750, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Profile");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.setBackground(new Color(47, 79, 79));
		btnNewButton.setBounds(577, 39, 115, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Write the qualifications");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Qualifications(i);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1.setBackground(new Color(47, 79, 79));
		btnNewButton_1.setBounds(93, 138, 212, 55);
		contentPane.add(btnNewButton_1);
		
		JButton results = new JButton("Matching Results");
		results.setForeground(new Color(255, 255, 255));
		results.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		results.setBackground(new Color(47, 79, 79));
		results.setBounds(432, 138, 149, 55);
		contentPane.add(results);
		
		JList list = new JList();
		list.setBackground(Color.LIGHT_GRAY);
		list.setBounds(79, 219, 239, 268);
		contentPane.add(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBackground(Color.WHITE);
		scrollBar.setBounds(301, 270, 17, 117);
		contentPane.add(scrollBar);
		
		JList list_1 = new JList();
		list_1.setBackground(Color.LIGHT_GRAY);
		list_1.setBounds(387, 219, 239, 268);
		contentPane.add(list_1);
		
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
		
			
		
		model = new DefaultListModel();
		list_1.setModel(model);
		results.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
				}			
			}
		});
		
		JButton btnNewButton_2_1 = new JButton("select");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});	
		
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_2_1.setForeground(new Color(255, 255, 255));
		btnNewButton_2_1.setBackground(new Color(47, 79, 79));
		btnNewButton_2_1.setBounds(425, 573, 137, 47);
		contentPane.add(btnNewButton_2_1);
		
		this.setVisible(true);
		this.setTitle("Company");
	}
}
