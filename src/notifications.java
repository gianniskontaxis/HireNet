import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Notifications extends JFrame {

	private JPanel contentPane;
	
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notifications frame = new Notifications(i);
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
	public Notifications() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Your Notifications");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(131, 35, 180, 13);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(85, 75, 245, 164);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		
		/*list.setFont(new Font("Arial", Font.BOLD, 13));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Seminar Reservation!", "New Matching!"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});*/
		scrollPane.setViewportView(list);
		
		JButton Back = new JButton("Back");
		Back.setForeground(Color.WHITE);
		Back.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		Back.setBackground(new Color(47, 79, 79));
		Back.setBounds(345, 234, 81, 19);
		contentPane.add(Back);
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			      /*System.exit(i);*/
				dispose();
				
			}
		});
		
		
		this.setVisible(true);
		this.setTitle("Notifications");
		
		
	}
}
