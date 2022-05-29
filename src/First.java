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
import java.awt.Toolkit;
import javax.swing.SwingConstants;

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
		setResizable(false);
		setTitle("Welcome to HireNet");
		setIconImage(Toolkit.getDefaultToolkit().getImage(First.class.getResource("/Images/logo_icon25x25.png")));
		
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
		btnNewButton.setBackground(new Color(0, 102, 102));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(122, 421, 159, 55);
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
		btnEmployee.setBackground(new Color(0, 102, 102));
		btnEmployee.setForeground(Color.WHITE);
		btnEmployee.setBounds(313, 421, 159, 55);
		contentPane.add(btnEmployee);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(First.class.getResource("/Images/rsz_hirenet810x810.png")));
		lblNewLabel_1.setBounds(122, 0, 350, 213);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Please select your role to continue:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 21));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(122, 356, 350, 55);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("You have Succesfully created your Account!");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_3.setBounds(162, 275, 310, 31);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(First.class.getResource("/Images/success.png")));
		lblNewLabel_4.setBounds(122, 275, 30, 31);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(First.class.getResource("/Images/firstback3.png")));
		lblNewLabel.setBounds(0, 0, 610, 575);
		contentPane.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/HireNet400X400.png")).getImage();
		
		this.setVisible(true);
	}
}
