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
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Toolkit;

public class Notifications extends JFrame {

	private JPanel contentPane;
	private int i;
	private Connection conn = null;
    private PreparedStatement ps = null;
	private ResultSet rs = null;
	private PreparedStatement ps2 = null;
	private ResultSet rs2 = null;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Notifications.class.getResource("/Images/logo_icon25x25.png")));
		this.i = i;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Refresh = new JButton("");
		Refresh.setIcon(new ImageIcon(Notifications.class.getResource("/Images/refresh_icon.png")));
		Refresh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		Refresh.setBounds(347, 72, 32, 32);
		Refresh.setOpaque(false);
		Refresh.setContentAreaFilled(false);
		Refresh.setBorderPainted(false);
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
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Notifications.class.getResource("/Images/background6.png")));
		lblNewLabel_2.setBounds(50, 72, 331, 32);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 54, 436, 8);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Notifications");
		lblNewLabel.setIcon(new ImageIcon(Notifications.class.getResource("/Images/notswhite_icon.png")));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(153, 12, 153, 32);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 105, 331, 430);
		contentPane.add(scrollPane);
		
		model = new DefaultListModel();
		
		try {
			conn = DBConnection.ConnDB();
			String sql = "select role from users where id = "+i+" ";
			ps2 = conn.prepareStatement(sql);
			rs2 = ps2.executeQuery();
			
			if (rs2.getString("role").equals("employee")) {
				
				try {
					conn = DBConnection.ConnDB();
					ps = conn.prepareStatement("select * from Seminars where id="+i+"");
					rs = ps.executeQuery();
						
					if (!rs.isClosed()) {
					
					for(int j=1; j<6; j++) {
						 if(rs.getString("Seminar" + j).equals("true")){
							 model.addElement("You 've booked our Seminar" + j);
						 }
					}
					}
					ps.close();
					rs.close();
		        } 
				catch (SQLException e1) {
		            e1.printStackTrace();
		        }			
			}
			ps2.close();
			rs2.close();
			 conn.close();
		}
		catch (SQLException e1) {
            e1.printStackTrace();
        }		
		
		
		JButton Back = new JButton("");
		contentPane.add(Back);
		Back.setForeground(Color.WHITE);
		Back.setIcon(new ImageIcon(cv.class.getResource("/Images/back_icon.png")));
		Back.setBounds(10, 12, 32, 32);
		Back.setOpaque(false);
		Back.setContentAreaFilled(false);
		Back.setBorderPainted(false);
		Back.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		Back.setBackground(new Color(47, 79, 79));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Notifications.class.getResource("/Images/notificback.png")));
		lblNewLabel_1.setBounds(0, 0, 436, 563);
		contentPane.add(lblNewLabel_1);
		
		
		
		
		JList list = new JList();
		list.setBounds(225, 167, 329, 428);
		contentPane.add(list);
		list.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		list.setModel(model);
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
