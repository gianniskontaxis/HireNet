import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Profile extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;	
	private int i;
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile(i);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public Profile(int i) {
		this.i=i;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();	
		
		textField.setBounds(158, 85, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(76, 85, 72, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(101, 124, 47, 16);
		contentPane.add(lblEmail);
		
		textField_1 = new JTextField();
		
		textField_1.setColumns(10);
		textField_1.setBounds(158, 124, 96, 19);
		contentPane.add(textField_1);
		this.setVisible(true);
		this.setTitle("Profile");
	}
}
