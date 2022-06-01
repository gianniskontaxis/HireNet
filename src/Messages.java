import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.JScrollPane;

public class Messages extends JFrame{
	
	private JPanel contentPane;
	private int i;
	private DefaultListModel model;
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private PreparedStatement ps1 = null;
	private ResultSet rs1 = null;
	private JList list;	
	private JTextField searchtextField;
	
	public Messages(int i) {
		
		this.i=i;


		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("List Of Users");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(129, 16, 117, 16);
		contentPane.add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(82, 42, 206, 211);
			
	   model = new DefaultListModel();
	   list.setModel(model);
	   
	   JScrollPane scrollPane = new JScrollPane();
	   scrollPane.setBounds(82, 42, 206, 211);
	   contentPane.add(scrollPane);
	   scrollPane.setViewportView(list);
	   
	   searchtextField = new JTextField();
	   searchtextField.setBounds(282, 16, 96, 19);
	   contentPane.add(searchtextField);
	   searchtextField.setColumns(10);
		
	   JButton searchNewButton = new JButton("Q");
	   searchNewButton.setBounds(376, 15, 39, 21);
	   contentPane.add(searchNewButton);
	   searchNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int o=0;
				int k=0;
				
				try {
					String sql = "select username from users ";
					conn = DBConnection.ConnDB();
					ps1 = conn.prepareStatement(sql);
					rs1 = ps1.executeQuery();	

					while (rs1.next()) {
						if(rs1.getString("username").equals(searchtextField.getText())) {
							new SendMessages(i,rs1.getString("username"));						
						}
						else {
							o++;
						}
						k++;
					}
					if (o==k){
						JOptionPane.showMessageDialog(null, "There is no user with this username");	
					}

					
					ps1.execute();	
					ps1.close();
					rs1.close();

					conn.close();
				}
				catch (SQLException e1) {					
					e1.printStackTrace();
				}	
				
		    }
		});


		
		//Καταχωρηση των users.		
		try {			
			String sql = "select username from users ";
			conn = DBConnection.ConnDB();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				model.addElement(rs.getString("username"));
					
			}
            ps.execute();
			ps.close();
			rs.close();
			conn.close();			
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
		
        list.addMouseListener(new MouseListener () {		
			
			@Override
			public void mouseClicked(MouseEvent e) {
					
					try {
						new SendMessages(i,(list.getSelectedValue()+""));
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
        
       
		
        JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnBack.setBackground(new Color(47, 79, 79));
		btnBack.setBounds(20, 234, 78, 19);
		contentPane.add(btnBack);
		
	
		
		
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			} });
		
		this.setVisible(true);
		this.setTitle("Messages");
		
	}
}
