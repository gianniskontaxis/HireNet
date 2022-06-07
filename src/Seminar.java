import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Seminar extends JFrame {

	private JPanel contentPane;
    private int i;
    private Connection conn = null;
    private PreparedStatement ps = null;
    private PreparedStatement ps2 = null;
	private ResultSet rs = null;
    /*HashMap<Integer,List<String>> seminars = new HashMap<Integer,List<String>>();*/
    
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seminar frame = new Seminar();
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
	public Seminar(int i) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Seminar.class.getResource("/Images/logo_icon25x25.png")));
		
		this.i = i;
		
		
		
		setTitle("Seminars");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1127, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Seminar.class.getResource("/Images/seminarbig.png")));
		lblNewLabel_2.setBounds(20, 235, 100, 100);
		contentPane.add(lblNewLabel_2);
		
		JTextPane textPaneSeminar = new JTextPane();
		textPaneSeminar.setFont(new Font("Tahoma", Font.ITALIC, 22));
		textPaneSeminar.setForeground(new Color(255, 255, 255));
		textPaneSeminar.setText("Welcome to our Seminars !\r\n\r\nYou can check for available courses and choose the one you would like to attent to.");
		textPaneSeminar.setBounds(20, 54, 340, 281);
		textPaneSeminar.setOpaque(false);
		contentPane.add(textPaneSeminar);
		
		JLabel lblNewLabel_1 = new JLabel("Seminars");
		lblNewLabel_1.setIcon(new ImageIcon(Seminar.class.getResource("/Images/seminar.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(123, 12, 134, 32);
		contentPane.add(lblNewLabel_1);
		
		Panel panel1 = new Panel();
		panel1.setBackground(Color.LIGHT_GRAY);
		panel1.setBounds(386, 24, 342, 311);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(Seminar.class.getResource("/Images/smallarrow_black.png")));
		lblNewLabel_4_1.setBounds(45, 267, 32, 32);
		panel1.add(lblNewLabel_4_1);
		
		JLabel sem1 = new JLabel("Programming With Java");
		sem1.setHorizontalAlignment(SwingConstants.CENTER);
		sem1.setForeground(new Color(255, 255, 255));
		sem1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		sem1.setBounds(36, 37, 257, 24);
		panel1.add(sem1);
		
		JTextPane txt1 = new JTextPane();
		txt1.setEditable(false);
		txt1.setOpaque(false);
		txt1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt1.setBackground(Color.LIGHT_GRAY);
		txt1.setText("Java remains a great choice for anyone looking to get started with structured programming. In the seminar one of the main goals is to learn object-oriented programming, concepts necessary for anyone looking for a career in developing applications regardless of language. ");
		txt1.setBounds(10, 100, 319, 108);
		panel1.add(txt1);
		
		JLabel day1 = new JLabel("May 23-28\r\n");
		day1.setFont(new Font("Tahoma", Font.BOLD, 15));
		day1.setBounds(117, 244, 101, 24);
		panel1.add(day1);
		
		conn = DBConnection.ConnDB();
		try {
			
            ps = conn.prepareStatement("select id from Seminars where id = '"+i+"'");
            rs = ps.executeQuery();
            if (rs.isClosed()) {
                ps2 = conn.prepareStatement("INSERT INTO Seminars(id) VALUES(?)");
                ps2.setInt(1, i);
                ps2.execute();
            }
            ps.close();
            

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
		
		try {
			conn.close();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		JButton button1 = new JButton("Seat Reservation");
		button1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button1.setForeground(Color.WHITE);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
					    "You 've successfully book a seat."
					    + " For more information check your notifications.");
				
				   try {
					   
					   conn = DBConnection.ConnDB();
					   ps = conn.prepareStatement("update Seminars set Seminar1 = 'true' where id = '"+i+"'");
					   ps.execute();
					   conn.close();
				   }catch (Exception e1) {
					   e1.printStackTrace();
				   }
				
			}
		});
		
		
		
		button1.setBackground(Color.BLACK);
		button1.setBounds(87, 278, 157, 21);
		panel1.add(button1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Seminar.class.getResource("/Images/firstbackground.png")));
		lblNewLabel_3.setBounds(10, 10, 319, 80);
		panel1.add(lblNewLabel_3);
		
		JLabel img1 = new JLabel("");
		img1.setIcon(new ImageIcon(Seminar.class.getResource("/Images/whitelong.png")));
		img1.setBounds(0, 0, 342, 311);
		panel1.add(img1);
		
		Panel panel2 = new Panel();
		panel2.setBackground(Color.LIGHT_GRAY);
		panel2.setBounds(753, 24, 340, 311);
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		JLabel lblNewLabel_4_2 = new JLabel("");
		lblNewLabel_4_2.setIcon(new ImageIcon(Seminar.class.getResource("/Images/smallarrow_black.png")));
		lblNewLabel_4_2.setBounds(57, 269, 32, 32);
		panel2.add(lblNewLabel_4_2);
		
		JLabel sem2 = new JLabel("Mobile Applications Development ");
		sem2.setForeground(new Color(255, 255, 255));
		sem2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		sem2.setBounds(32, 37, 285, 24);
		panel2.add(sem2);
		
		JTextPane txt2 = new JTextPane();
		txt2.setEditable(false);
		txt2.setOpaque(false);
		txt2.setBackground(Color.LIGHT_GRAY);
		txt2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt2.setText("This seminar offers you the opportunity to be the first to discover the secrets of innovative applications for your mobile phone and you may be the next to reach the top of the future.");
		txt2.setBounds(10, 100, 319, 74);
		panel2.add(txt2);
		
		JLabel day2 = new JLabel("June 9-12");
		day2.setFont(new Font("Tahoma", Font.BOLD, 15));
		day2.setBounds(128, 239, 101, 31);
		panel2.add(day2);
		
		JButton button2 = new JButton("Seat Reservation");
		button2.setFont(new Font("Tahoma", Font.BOLD, 11));
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
					    "You 've successfully book a seat."
					    + " For more information check your notifications.");
				 try {
					   
					   conn = DBConnection.ConnDB();
					   ps = conn.prepareStatement("update Seminars set Seminar2 = 'true' where id = '"+i+"'");
					   ps.execute();
					   conn.close();
				   }catch (Exception e1) {
					   e1.printStackTrace();
				   }
				
			}
		});
		button2.setForeground(Color.WHITE);
		button2.setBackground(Color.BLACK);
		button2.setBounds(99, 280, 157, 21);
		panel2.add(button2);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(Seminar.class.getResource("/Images/background6.png")));
		lblNewLabel_3_1.setBounds(10, 10, 319, 80);
		panel2.add(lblNewLabel_3_1);
		
		JLabel img2 = new JLabel("");
		img2.setIcon(new ImageIcon(Seminar.class.getResource("/Images/whitelong.png")));
		img2.setBounds(0, 0, 340, 311);
		panel2.add(img2);
		
		Panel panel3 = new Panel();
		panel3.setBackground(Color.LIGHT_GRAY);
		panel3.setBounds(20, 364, 340, 305);
		contentPane.add(panel3);
		panel3.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Seminar.class.getResource("/Images/smallarrow_black.png")));
		lblNewLabel_4.setBounds(61, 259, 32, 32);
		panel3.add(lblNewLabel_4);
		
		JLabel sem3 = new JLabel("CRM Management\r\n");
		sem3.setHorizontalAlignment(SwingConstants.CENTER);
		sem3.setForeground(new Color(255, 255, 255));
		sem3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		sem3.setBounds(10, 37, 319, 21);
		panel3.add(sem3);
		
		JTextPane txt3 = new JTextPane();
		txt3.setEditable(false);
		txt3.setOpaque(false);
		txt3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt3.setBackground(Color.LIGHT_GRAY);
		txt3.setText("CRM is software that automates a business's sales processes. The aim of the seminar is to facilitate the implementation of these systems and to present their usefulness in everyday business.");
		txt3.setBounds(10, 100, 319, 100);
		panel3.add(txt3);
		
		JLabel day3 = new JLabel("June 28-30");
		day3.setFont(new Font("Tahoma", Font.BOLD, 15));
		day3.setBounds(127, 236, 107, 30);
		panel3.add(day3);
		
		JButton button3 = new JButton("Seat Reservation");
		button3.setFont(new Font("Tahoma", Font.BOLD, 11));
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
					    "You 've successfully book a seat."
					    + " For more information check your notifications.");
				
				 try {
					   
					   conn = DBConnection.ConnDB();
					   ps = conn.prepareStatement("update Seminars set Seminar3 = 'true' where id = '"+i+"'");
					   ps.execute();
					   conn.close();
				   }catch (Exception e1) {
					   e1.printStackTrace();
				   }
			}
		});
		button3.setForeground(Color.WHITE);
		button3.setBackground(Color.BLACK);
		button3.setBounds(103, 270, 157, 21);
		panel3.add(button3);
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setIcon(new ImageIcon(Seminar.class.getResource("/Images/background6.png")));
		lblNewLabel_3_2.setBounds(10, 10, 319, 80);
		panel3.add(lblNewLabel_3_2);
		
		JLabel img3 = new JLabel("");
		img3.setIcon(new ImageIcon(Seminar.class.getResource("/Images/whitelong.png")));
		img3.setBounds(0, 0, 350, 305);
		panel3.add(img3);
		
		Panel panel4 = new Panel();
		panel4.setBackground(Color.LIGHT_GRAY);
		panel4.setBounds(386, 364, 342, 305);
		contentPane.add(panel4);
		panel4.setLayout(null);
		
		JLabel lblNewLabel_4_3 = new JLabel("");
		lblNewLabel_4_3.setIcon(new ImageIcon(Seminar.class.getResource("/Images/smallarrow_black.png")));
		lblNewLabel_4_3.setBounds(55, 259, 32, 32);
		panel4.add(lblNewLabel_4_3);
		
		JLabel sem4 = new JLabel("Programming With Python");
		sem4.setHorizontalAlignment(SwingConstants.CENTER);
		sem4.setForeground(new Color(255, 255, 255));
		sem4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		sem4.setBounds(10, 37, 319, 20);
		panel4.add(sem4);
		
		JTextPane txt4 = new JTextPane();
		txt4.setEditable(false);
		txt4.setOpaque(false);
		txt4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt4.setText("The key features of Python are its code recognition and the ability for developers to write concepts in fewer lines of code than in other languages. One of the most sought after programming languages for both the novice and the advanced programmer.");
		txt4.setBackground(Color.LIGHT_GRAY);
		txt4.setBounds(10, 100, 319, 110);
		panel4.add(txt4);
		
		JLabel day4 = new JLabel("July 18-23\r\n");
		day4.setFont(new Font("Tahoma", Font.BOLD, 15));
		day4.setBounds(127, 236, 101, 24);
		panel4.add(day4);
		
		JButton button4 = new JButton("Seat Reservation");
		button4.setFont(new Font("Tahoma", Font.BOLD, 11));
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
					    "You 've successfully book a seat."
					    + " For more information check your notifications.");
				
				 try {
					   
					   conn = DBConnection.ConnDB();
					   ps = conn.prepareStatement("update Seminars set Seminar4 = 'true' where id = '"+i+"'");
					   ps.execute();
					   conn.close();
				   }catch (Exception e1) {
					   e1.printStackTrace();
				   }
			}
		});
		button4.setForeground(Color.WHITE);
		button4.setBackground(Color.BLACK);
		button4.setBounds(97, 270, 157, 21);
		panel4.add(button4);
		
		JLabel lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.setIcon(new ImageIcon(Seminar.class.getResource("/Images/firstbackground.png")));
		lblNewLabel_3_3.setBounds(10, 10, 319, 80);
		panel4.add(lblNewLabel_3_3);
		
		JLabel img4 = new JLabel("");
		img4.setIcon(new ImageIcon(Seminar.class.getResource("/Images/whitelong.png")));
		img4.setBounds(0, 0, 342, 305);
		panel4.add(img4);
		
		Panel panel5 = new Panel();
		panel5.setBackground(Color.LIGHT_GRAY);
		panel5.setBounds(753, 364, 340, 305);
		contentPane.add(panel5);
		panel5.setLayout(null);
		
		JLabel lblNewLabel_4_4 = new JLabel("");
		lblNewLabel_4_4.setIcon(new ImageIcon(Seminar.class.getResource("/Images/smallarrow_black.png")));
		lblNewLabel_4_4.setBounds(59, 261, 32, 32);
		panel5.add(lblNewLabel_4_4);
		
		JLabel sem5 = new JLabel("Microsoft Office Tutorials");
		sem5.setHorizontalAlignment(SwingConstants.CENTER);
		sem5.setForeground(new Color(255, 255, 255));
		sem5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		sem5.setBounds(10, 37, 319, 20);
		panel5.add(sem5);
		
		JTextPane txt5 = new JTextPane();
		txt5.setEditable(false);
		txt5.setOpaque(false);
		txt5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt5.setText("The aim of the seminar is to learn: Microsoft Word, Microsoft Excel, Microsoft Power-Point, Microsoft Access, Computer Use and File Management - Windows 10 Environment, Internet Explorer + Microsoft Outlook - Internet Services (Internet Explorer 8, Microsoft Outlook - Windows 10).");
		txt5.setBackground(Color.LIGHT_GRAY);
		txt5.setBounds(10, 100, 319, 130);
		panel5.add(txt5);
		
		JButton button5 = new JButton("Seat Reservation");
		button5.setFont(new Font("Tahoma", Font.BOLD, 11));
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
					    "You 've successfully book a seat."
					    + " For more information check your notifications.");
				
				 try {
					   
					   conn = DBConnection.ConnDB();
					   ps = conn.prepareStatement("update Seminars set Seminar5 = 'true' where id = '"+i+"'");
					   ps.execute();
					   conn.close();
				   }catch (Exception e1) {
					   e1.printStackTrace();
				   }
			}
		});
		button5.setForeground(Color.WHITE);
		button5.setBackground(Color.BLACK);
		button5.setBounds(101, 272, 157, 21);
		panel5.add(button5);
		
		JLabel day5 = new JLabel("August 1-14");
		day5.setFont(new Font("Tahoma", Font.BOLD, 15));
		day5.setBounds(135, 238, 101, 24);
		panel5.add(day5);
		
		JLabel lblNewLabel_3_4 = new JLabel("");
		lblNewLabel_3_4.setIcon(new ImageIcon(Seminar.class.getResource("/Images/background6.png")));
		lblNewLabel_3_4.setBounds(10, 10, 319, 80);
		panel5.add(lblNewLabel_3_4);
		
		JLabel img5 = new JLabel("");
		img5.setIcon(new ImageIcon(Seminar.class.getResource("/Images/whitelong.png")));
		img5.setBounds(0, 0, 340, 305);
		panel5.add(img5);
		
		
		
		
		
		JButton btnBck = new JButton("");
		btnBck.setIcon(new ImageIcon(Seminar.class.getResource("/Images/back_icon.png")));
		btnBck.setForeground(Color.WHITE);
		btnBck.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnBck.setBackground(new Color(47, 79, 79));
		btnBck.setBounds(10, 12, 32, 32);
		btnBck.setOpaque(false);
		btnBck.setContentAreaFilled(false);
		btnBck.setBorderPainted(false);
		contentPane.add(btnBck);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Seminar.class.getResource("/Images/seminarsback2.png")));
		lblNewLabel.setBounds(0, 0, 1138, 707);
		contentPane.add(lblNewLabel);
		btnBck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			} });
     
		this.setVisible(true);
		this.setTitle("Seminars");
		
	}
}
