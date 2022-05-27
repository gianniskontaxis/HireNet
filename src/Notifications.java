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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JList;
import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Notifications extends JFrame {

	private JPanel contentPane;
	private int i;
	private Connection conn = null;
    private PreparedStatement ps = null;
	private ResultSet rs = null;
	private DefaultListModel model;
	/*HashMap<Integer,List<String>> seminars = new HashMap<Integer,List<String>>();
	private DefaultListModel model;
	List<String> seminarlist = new ArrayList<String>();*/
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
	public Notifications(int i) {
		this.i = i;
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
		
		model = new DefaultListModel();
		list.setModel(model);
		
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
		
		
		try {
			conn = DBConnection.ConnDB();
			ps = conn.prepareStatement("select * from Seminars where id="+i+"");
			rs = ps.executeQuery();
			
			for(int j=1; j<6; j++) {
				 if(rs.getString("Seminar" + j).equals("true")){
					 model.addElement("You 've booked our Seminar" + j);
				 }
			}
			
          
            
           conn.close();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
		
		
		JButton Refresh = new JButton("Refresh");
		Refresh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		Refresh.setBounds(341, 47, 85, 21);
		contentPane.add(Refresh);
		Refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
				
				
				
			}
		});
		
		
		
		this.setVisible(true);
		this.setTitle("Notifications");
		
		
	}
}
