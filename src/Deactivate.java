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


public class Deactivate extends JFrame {
    private int i;
	private JPanel contentPane;
	private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private PreparedStatement ps2=null;
   /*
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deactivation frame = new Deactivation(i);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} //

	/**
	 * Create the frame.
	 */
	public Deactivate(int i) {
		this.i=i;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setVisible(true);
		
		JTextPane txtpnAreYouSure = new JTextPane();
		txtpnAreYouSure.setEditable(false);
		txtpnAreYouSure.setBackground(SystemColor.control);
		txtpnAreYouSure.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtpnAreYouSure.setText("Are you sure you want to delete your account?");
		txtpnAreYouSure.setBounds(110, 51, 213, 52);
		contentPane.add(txtpnAreYouSure);
		
		JButton btnNewButton = new JButton("Yes");
		
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBackground(new Color(47, 79, 79));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(96, 141, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("No");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.setBackground(new Color(47, 79, 79));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(252, 141, 85, 21);
		contentPane.add(btnNewButton_1);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					conn = DBConnection.ConnDB();
					String sql;
					
                    
                    sql="select role from users where id ="+i+"";
                    ps=conn.prepareStatement(sql);
                    rs=ps.executeQuery();
                    if(rs.getString("role").equals("employee"))
                    {
                    	sql="delete from employees where id="+i+"";
                    	ps2=conn.prepareStatement(sql);
                    	ps2.execute();
                    }
                    sql="delete from users where id="+i+"";
                    ps2 = conn.prepareStatement(sql);
                    ps2.execute();
                    sql="delete from quals where id="+i+"";
                    ps2=conn.prepareStatement(sql);
                    ps2.execute();
                    
              
                    
                conn.close();
                
				} 
				catch (Exception e1) {
                    e1.printStackTrace();
                  
                  
                }
				
				
				JOptionPane.showMessageDialog(null,"Succesfully deleted!");
			} });
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			} });
		
	
		
	}
}
