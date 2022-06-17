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
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

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
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Messages.class.getResource("/Images/logo_icon25x25.png")));
		
		this.i=i;


		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	   JButton searchNewButton = new JButton("");
	   searchNewButton.setBackground(Color.WHITE);
	   searchNewButton.setIcon(new ImageIcon(Messages.class.getResource("/Images/search2_icon.png")));
	   searchNewButton.setBounds(332, 98, 39, 25);
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
		
		searchtextField = new JTextField();
		searchtextField.setBounds(210, 98, 125, 25);
		contentPane.add(searchtextField);
		searchtextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Messages.class.getResource("/Images/background1.png")));
		lblNewLabel_2.setBounds(51, 92, 327, 38);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(0, 54, 436, 8);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Contacts");
		lblNewLabel.setIcon(new ImageIcon(Messages.class.getResource("/Images/contact_icon.png")));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(160, 12, 152, 32);
		contentPane.add(lblNewLabel);
		
		JList list = new JList();
		list.setBorder(null);
		list.setForeground(new Color(0, 102, 102));
		list.setBackground(new Color(255, 255, 255));
		list.setBounds(82, 42, 206, 211);
			
	   model = new DefaultListModel();
	   list.setModel(model);
	   
	   JScrollPane scrollPane = new JScrollPane();
	   scrollPane.setViewportBorder(new LineBorder(new Color(0, 206, 209)));
	   scrollPane.setBounds(51, 129, 327, 237);
	   contentPane.add(scrollPane);
	   scrollPane.setViewportView(list);


		
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
        
       
		
        JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(Messages.class.getResource("/Images/back_icon.png")));
		btnBack.setBounds(10, 12, 32, 32);
		btnBack.setOpaque(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Messages.class.getResource("/Images/firstbackground.png")));
		lblNewLabel_1.setBounds(0, 0, 436, 413);
		contentPane.add(lblNewLabel_1);
			
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			} });
		
		this.setVisible(true);
		this.setTitle("Messages");
		
	}
}
