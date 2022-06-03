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
import javax.swing.JSeparator;

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
		btnNewButton.setIcon(new ImageIcon(First.class.getResource("/Images/company_profile.png")));
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
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(First.class.getResource("/Images/slogan2-removebg-preview.png")));
		lblNewLabel_5.setBounds(10, 59, 566, 148);
		contentPane.add(lblNewLabel_5);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(122, 342, 159, 55);
		contentPane.add(btnNewButton);
		
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.setIcon(new ImageIcon(First.class.getResource("/Images/profile_icon.png")));
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
		btnEmployee.setBackground(new Color(255, 255, 255));
		btnEmployee.setForeground(new Color(0, 0, 0));
		btnEmployee.setBounds(313, 342, 159, 55);
		contentPane.add(btnEmployee);
		
		JLabel lblNewLabel_2 = new JLabel("Please select your role to continue:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(122, 298, 350, 40);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("You have Succesfully created your Account!");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_3.setBounds(165, 251, 319, 31);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(First.class.getResource("/Images/success.png")));
		lblNewLabel_4.setBounds(125, 251, 30, 31);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(First.class.getResource("/Images/firstlabel.png")));
		lblNewLabel_1.setBounds(112, 292, 372, 116);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(First.class.getResource("/Images/firstback3.png")));
		lblNewLabel.setBounds(0, 0, 610, 575);
		contentPane.add(lblNewLabel);
		/*Image img = new ImageIcon(this.getClass().getResource("/HireNet400X400.png")).getImage();*/
		
		this.setVisible(true);
	}
}
