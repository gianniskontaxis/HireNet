import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

public class SendMessages extends JFrame {

	private JPanel contentPane;
	private int i;
	private int pl=0;
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private PreparedStatement ps2 = null;
	private ResultSet rs2 = null;
	private PreparedStatement ps3 = null;
	private ResultSet rs3 = null;
	private String username;
	private String sql="";
	private DefaultListModel Model;
	private ArrayList<String> mess = new ArrayList<>();
	private Date currenDateTime = new Date();





	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SendMessages frame = new SendMessages();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public SendMessages(int i, String username) throws SQLException {
		
		this.i=i;
		this.username = username;
		setBounds(100, 100, 550, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea NewMessagetextArea = new JTextArea();
		NewMessagetextArea.setBounds(25, 439, 369, 81);
		contentPane.add(NewMessagetextArea);

		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(47, 79, 79));
		btnNewButton.setBounds(416, 448, 85, 56);
		contentPane.add(btnNewButton);
		
		Model = new DefaultListModel();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 53, 476, 318);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setBounds(25, 53, 476, 318);
		   scrollPane.setViewportView(textArea);

	    
	    //fortosh mhnhmatwn apo thn basi//
		conn = DBConnection.ConnDB();	
 
		sql = "select username from users where id = '"+i+"'";
		ps2 = conn.prepareStatement(sql);
		rs2 = ps2.executeQuery();	
		
		sql = "select username,usernameTo ,text,dateOfMessage from users join messages where id=idFrom and ((username='"+rs2.getString(1)+"' and usernameTo='"+username+"') or(username= '"+username+"' and usernameTo='"+rs2.getString(1)+"')) order by dateOfMessage";
		ps3 = conn.prepareStatement(sql);
		rs3 = ps3.executeQuery();
		
		while (rs3.next()) {
			textArea.append(rs3.getString("username")+": "+rs3.getString("text") +" \n" + rs3.getString("dateOfMessage") + "\n");							
				
		}
		
		
		ps2.close();
		rs2.close();
		ps3.close();
		rs3.close();
		

				
		
		conn.close();

		
	//kataxorisi minimaton sth basi//
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if((NewMessagetextArea.getText()).equals("")) {
					JOptionPane.showMessageDialog(null, "write a mesage first");	
				}
				else {
												
				try {

					conn = DBConnection.ConnDB();	
					
					conn = DBConnection.ConnDB();	
					 
					sql = "select username from users where id = '"+i+"'";
					ps2 = conn.prepareStatement(sql);
					rs2 = ps2.executeQuery();
					
		                
					ps = conn.prepareStatement("INSERT INTO messages(idFrom,usernameTo,text,dateOfMessage) VALUES(?,?,?,?)");
		            ps.setInt(1, i);
					ps.setString(2, username);
					ps.setString(3, NewMessagetextArea.getText()); 
					ps.setString(4, currenDateTime.toString());
					
					textArea.append(rs2.getString("username")+": "+ NewMessagetextArea.getText() +" \n" + currenDateTime.toString() + "\n");							

					


		            
	                ps.execute();
	                ps.close();
	                ps2.execute();
	                ps2.close();
	        		rs2.close();
					conn.close();

		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }
				

				NewMessagetextArea.setText("");
				}
				
				
				
			
			} });
		
		
		
		
		
		this.setVisible(true);
		this.setTitle("Chat");
	}
}
