import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class cv extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private int i;	

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cv frame = new cv();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public cv(int i) {
		
		this.i=i;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, 50, 750, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(47, 42, 93, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(47, 92, 93, 40);
		contentPane.add(lblLastName);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(47, 142, 69, 40);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Age");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(47, 192, 69, 40);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBounds(138, 51, 155, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(138, 105, 155, 28);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(107, 155, 186, 28);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_3.setColumns(10);
		textField_3.setBounds(107, 205, 54, 28);
		contentPane.add(textField_3);			
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("*Jobs");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_1_1_1.setBounds(505, 58, 69, 40);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Write your");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_2.setBounds(47, 260, 93, 40);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		JButton btnNewButton = new JButton("Qualifications");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Qualifications(i);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.setBackground(new Color(47, 79, 79));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(138, 262, 155, 40);
		contentPane.add(btnNewButton);
		
		JList list = new JList();
		list.setBounds(384, 105, 300, 195);
		contentPane.add(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(667, 173, 17, 48);
		contentPane.add(scrollBar);
		
		JList list_2 = new JList();
		list_2.setBounds(47, 361, 300, 195);
		contentPane.add(list_2);
		
		JButton btnNewButton_1_1 = new JButton("Search");
		btnNewButton_1_1.setBackground(new Color(47, 79, 79));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.setBounds(469, 460, 143, 48);
		contentPane.add(btnNewButton_1_1);
		
		JButton save = new JButton("Save");
		save.setForeground(Color.WHITE);
		save.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		save.setBackground(new Color(47, 79, 79));
		save.setBounds(469, 386, 143, 48);
		contentPane.add(save);
		
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {								
		}
		});	
		
		JLabel lblNewLabel_1 = new JLabel("*press ctrl for multiple selections");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setBounds(69, 561, 239, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("or to unmark a selection...");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2.setBounds(103, 581, 218, 40);
		contentPane.add(lblNewLabel_2);
		this.setVisible(true);
		this.setTitle("cv");
	}
}
