import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Profile extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private aes data = new aes();
	private final String secretKey = "aes4";
	private int i;
	private ArrayList<String> emails = new ArrayList<>();
	private ArrayList<String> UserNames = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile();
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
	public Profile(int i) {
		this.i=i;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		String line="";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(("file3.txt")));
			while( (line=reader.readLine()) != null ) {	
				line=data.decrypt(line,secretKey);
				UserNames.add(line);					
			}				
			reader.close();					
		} catch (IOException e1) {
			e1.printStackTrace();
		}				
		
		textField.setText(UserNames.get(i));
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
		String lin="";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(("file2.txt")));
			while( (lin=reader.readLine()) != null ) {	
				lin=data.decrypt(lin,secretKey);
				emails.add(lin);					
			}				
			reader.close();					
		} catch (IOException e1) {
			e1.printStackTrace();
		}				
		
		textField_1.setText(emails.get(i));
		textField_1.setColumns(10);
		textField_1.setBounds(158, 124, 96, 19);
		contentPane.add(textField_1);
		this.setVisible(true);
		this.setTitle("Profile");
	}
}
