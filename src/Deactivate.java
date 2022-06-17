import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;


public class Deactivate extends JFrame {
    private int i;
	private JPanel contentPane;
	private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private PreparedStatement ps2=null;
  

	/**
	 * Create the frame.
	 */
	public Deactivate(int i) {
		setResizable(false);
		setTitle("Delete Account?");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Deactivate.class.getResource("/Images/logo_icon25x25.png")));
		this.i=i;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setVisible(true);
		
		JLabel lblNewLabel_1 = new JLabel("* You will not be able to undo this action !");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 240, 241, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel stoplabel = new JLabel("  WARNING !");
		stoplabel.setForeground(new Color(255, 255, 255));
		stoplabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		stoplabel.setIcon(new ImageIcon(Deactivate.class.getResource("/Images/warning2.png")));
		stoplabel.setBounds(96, 36, 241, 50);
		contentPane.add(stoplabel);
		
		JTextPane txtpnAreYouSure = new JTextPane();
		txtpnAreYouSure.setForeground(new Color(255, 255, 255));
		txtpnAreYouSure.setEditable(false);
		txtpnAreYouSure.setOpaque(false);
		txtpnAreYouSure.setBackground(SystemColor.control);
		txtpnAreYouSure.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnAreYouSure.setText("Are you sure you want to delete your account?");
		txtpnAreYouSure.setBounds(96, 111, 241, 56);
		contentPane.add(txtpnAreYouSure);
		
		JButton btnNewButton = new JButton("Yes");
		
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(96, 177, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(252, 177, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Deactivate.class.getResource("/Images/recovery_background.png")));
		lblNewLabel.setBounds(0, 0, 436, 263);
		contentPane.add(lblNewLabel);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					conn = DBConnection.ConnDB();
					String sql;
					
                    
                    sql="select * from users where id ="+i+"";
                    ps=conn.prepareStatement(sql);
                    rs=ps.executeQuery();
                    if(rs.getString("role").equals("employee"))
                    {
                    	sql="delete from employees where id="+i+"";
                    	ps2=conn.prepareStatement(sql);
                    	ps2.execute();
                    	ps2.close();
                    	sql="delete from Seminars where id="+i+"";
                    	ps2=conn.prepareStatement(sql);
                    	ps2.execute();
                    	ps2.close();
                    }
                    sql="delete from users where id="+i+"";
                    ps2 = conn.prepareStatement(sql);
                    ps2.execute();
                    ps2.close();
                    sql="delete from quals where id="+i+"";
                    ps2=conn.prepareStatement(sql);
                    ps2.execute();
                    ps2.close();
                    sql="delete from numOfQuals where id="+i+"";
                    ps2=conn.prepareStatement(sql);
                    ps2.execute();
                    ps2.close();
                    sql="delete from notifications where id="+i+" or MesFrom= '"+rs.getString("username")+"'";
                    ps2=conn.prepareStatement(sql);
                    ps2.execute();
                    ps2.close();
                    sql="delete from messages where idFrom="+i+" or usernameTo= '"+rs.getString("username")+"'";
                    ps2=conn.prepareStatement(sql);
                    ps2.execute();
                    ps2.close();
              
                   ps.close();
                   rs.close();
                conn.close();
                
				} 
				catch (Exception e1) {
                    e1.printStackTrace();
                  
                  
                }
				
				
				JOptionPane.showMessageDialog(null,"Succesfully deleted!");
				System.exit(i);
			} });
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			} });
		
	
		
	}
}
