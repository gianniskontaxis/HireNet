
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Notifications extends JFrame{

	private JPanel contentPane;
	private int i;
	private Connection conn = null;
    private PreparedStatement ps = null;
	private ResultSet rs = null;
	private PreparedStatement ps2 = null;
	private ResultSet rs2 = null;
	private DefaultListModel model;
	private DefaultListModel model2;
	private PreparedStatement ps3 = null;
	private ResultSet rs3 = null;
	private PreparedStatement ps4 = null;
	private ResultSet rs4 = null;
	private PreparedStatement ps5 = null;
	private ResultSet rs5 = null;
	private PreparedStatement ps6 = null;
	private ResultSet rs6 = null;
	private PreparedStatement ps7 = null;
	private ResultSet rs7= null;
	private ArrayList<String> users = new ArrayList<>();
	private ArrayList<Integer> cou = new ArrayList<>();

	private String sql="";
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
	public Notifications(int i) throws SQLException {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Notifications.class.getResource("/Images/logo_icon25x25.png")));
		this.i = i;
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(0, 54, 436, 8);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Notifications");
		lblNewLabel.setIcon(new ImageIcon(Notifications.class.getResource("/Images/notswhite_icon.png")));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(131, 12, 180, 32);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 95, 331, 130);
		contentPane.add(scrollPane);
		
		
		
		
		
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(cv.class.getResource("/Images/back_icon.png")));
		btnBack.setBounds(10, 12, 32, 32);
		btnBack.setOpaque(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			      /*System.exit(i);*/
				dispose();
				
			}
		});
		
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		
		model = new DefaultListModel();
		list.setModel(model);
		
		scrollPane.setColumnHeaderView(list);
		
		model2 = new DefaultListModel();
		
		//αθροισμα λιστας ιδ απο τον πινακα notifications
		conn = DBConnection.ConnDB();	

		sql = "select  count(*) as ar from notifications  where id = '"+i+"'";
		ps3 = conn.prepareStatement(sql);
		rs3 = ps3.executeQuery();	
		rs3.next();
		
		int y = Integer.valueOf(rs3.getString("ar"));
			
		ps3.close();
		rs3.close();	
		
	   //αθροισμα λιστας χρηστων που εχουν εστειλει μνμ στον χρηστη	 απο τον πινακα messages
 
		sql = "select  count(*) as ar from users join messages where username=usernameTo and id = '"+i+"'";

		ps4 = conn.prepareStatement(sql);
		rs4 = ps4.executeQuery();
		rs4.next();
		
		int x = Integer.valueOf(rs4.getString("ar"));	
		
		ps4.close();
		rs4.close();
		// φορτωση λιστασ χρηστων για τουσ οποιος ενημερωθηκε ο χρηστησ οτι εχει μνμ
	
		sql = "select  idFrom  from users join messages where username=usernameTo and id = '"+i+"'";

		ps5 = conn.prepareStatement(sql);
		rs5 = ps5.executeQuery();
		
		while (rs5.next()) {
			cou.add(rs5.getInt("idFrom"));
		}
		ps5.close();
		rs5.close();
		
		for(int w=0; w<cou.size(); w++) {				
		sql = "select  username  from users where  id = '"+cou.get(w)+"'";
		ps6 = conn.prepareStatement(sql);
		rs6 = ps6.executeQuery();
		users.add(rs6.getString("username"));
		
		ps6.close();
		rs6.close();
		}
		
		
		conn.close();
		

		
		
			for(int w1=0; w1<users.size(); w1++) {				
				model.addElement("You 've new Message from " + users.get(w1) + "\n");
				if(y<users.size()) {
				try {

					conn = DBConnection.ConnDB();			
			
					ps7 = conn.prepareStatement("INSERT INTO notifications(id,MesFrom) VALUES(?,?)");           
					ps7.setInt(1, i);			
					ps7.setString(2, users.get(w1));
						
					ps7.execute();
	                ps7.close();
					conn.close();

			
				 } catch (SQLException e1) {
			            e1.printStackTrace();
			        
			}
			
			}
		}
			
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
								 if(j==1) {
									model2.addElement("Seminar - Programming with Java");
								 }
								 else if (j==2){
									 model2.addElement("Seminar - Mobile Applications Development");
								 }
								 else if (j==3){
									 model2.addElement("Seminar - CRM Management");
								 }
								 else if (j==4){
									 model2.addElement("Seminar - Programming with Python");
								 }
								 else if (j==5){
									 model2.addElement("Seminar - Microsoft Office Tutorials");
								 }
								 else if (j==6){
									 model2.addElement("You 've booked our Νο.6 Seminar");
								 }
								 //model.addElement("You 've booked our  Seminar" + j);
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
			
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(54, 224, 331, 130);
		contentPane.add(scrollPane_1);
			
		
		JList list_sem = new JList();
		list_sem.setBackground(Color.WHITE);
		list_sem.setBounds(55, 224, 329, 265);
		scrollPane_1.setColumnHeaderView(list_sem);
	    scrollPane_1.setViewportBorder(new LineBorder(new Color(0, 206, 209)));

		list_sem.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		list_sem.setModel(model2);
		


		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Notifications.class.getResource("/Images/notificback.png")));
		lblNewLabel_1.setBounds(0, 0, 436, 563);
		contentPane.add(lblNewLabel_1);
		
		
	/*	
     list.addMouseListener(new MouseListener () {		
			
			@Override
			public void mouseClicked(MouseEvent e) {
					/*new MatchingInfo(usernameList.getSelectedValue()+"",i);*/
					//new CvMatching(list.getSelectedValue()+"",i);
					//JOptionPane.showMessageDialog(null,
						 //   "You 've chosen on of our seminars."
						 //   + " For more information about the chosen " + "\n" + " seminar check our website.");
				//}
			
			//@Override
			//public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			//}

			//@Override
			//public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			//}

			//@Override
			//public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			//}

			//@Override
			//public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			//}	
			
        //});
		
        
		this.setVisible(true);
		this.setTitle("Notifications");
		
		
	}
}
