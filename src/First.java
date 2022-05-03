import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class First extends JFrame {

	private JPanel contentPane;
	private int i;			
	private Connection conn = null;
	private PreparedStatement ps = null;	
	private String sql="";	
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					First frame = new First();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public First(int i) {
		
		this.i=i;	
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 614, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		conn = DBConnection.ConnDB();
		
		JButton btnNewButton = new JButton("Company");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new Company(i);				
				
				//sql
				
				try {
					sql = "UPDATE users set role = 'company' where id = '"+i+"' ";
					ps = conn.prepareStatement(sql);
					ps.execute();	
					ps.close();
					conn.close();
				}
				catch (SQLException e1) {					
					e1.printStackTrace();
				}				
				dispose();
		    }
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.setBackground(new Color(47, 79, 79));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(84, 421, 159, 55);
		contentPane.add(btnNewButton);
		
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new Employee(i);				
				
				//sql
								
				try {
					sql = "UPDATE users set role = 'employee' where id = '"+i+"' ";
					ps = conn.prepareStatement(sql);
					ps.execute();
					ps.close();
					conn.close();
				}
				catch (SQLException e1) {					
					e1.printStackTrace();
				}				
				dispose();				
		    }
		});
		btnEmployee.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnEmployee.setBackground(new Color(47, 79, 79));
		btnEmployee.setForeground(Color.WHITE);
		btnEmployee.setBounds(337, 421, 159, 55);
		contentPane.add(btnEmployee);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(100, -30, 548, 301);	
		contentPane.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/HireNet400X400.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		this.setVisible(true);
	}
}
