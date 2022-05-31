import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
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
	private JList list;	
	
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


		
		//���������� ��� users.		
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
		
		
		this.setVisible(true);
		this.setTitle("Messages");
		
	}
}
