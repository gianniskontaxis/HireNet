
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollBar;

public class Employee extends JFrame {

	private JPanel contentPane;
	private int i;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
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
		
		JLabel lblYourResults = new JLabel("Matcing results:");
		lblYourResults.setBackground(new Color(240, 240, 240));
		lblYourResults.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblYourResults.setBounds(478, 240, 149, 60);
		contentPane.add(lblYourResults);
		
		JList list = new JList();
		list.setBounds(100, 304, 206, 211);
		contentPane.add(list);
		
		JButton btnNewButton_1 = new JButton("Write your CV");
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new cv(i);
			}
		});
		btnNewButton_1.setBackground(new Color(47, 79, 79));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(459, 549, 149, 47);
		contentPane.add(btnNewButton_1);
		
		JLabel lblWhatCompaniesWant = new JLabel("What Companies ask for the most:");
		lblWhatCompaniesWant.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWhatCompaniesWant.setBackground(SystemColor.menu);
		lblWhatCompaniesWant.setBounds(82, 240, 269, 60);
		contentPane.add(lblWhatCompaniesWant);
		
		JList list_1 = new JList();
		list_1.setBounds(429, 304, 206, 211);
		contentPane.add(list_1);
		
		JButton btnNewButton_1_1 = new JButton("Search");
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1_1.setBackground(new Color(47, 79, 79));
		btnNewButton_1_1.setBounds(117, 549, 149, 47);
		contentPane.add(btnNewButton_1_1);
		
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
		this.setVisible(true);
		this.setTitle("Employee");
	}
}
