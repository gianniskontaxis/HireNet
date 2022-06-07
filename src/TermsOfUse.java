import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class TermsOfUse extends JFrame {

	private JPanel contentPane;

	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TermsOfUse frame = new TermsOfUse();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	
	public TermsOfUse() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TermsOfUse.class.getResource("/Images/logo_icon25x25.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Terms of use");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(167, 10, 129, 29);
		contentPane.add(lblNewLabel);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 52, 390, 309);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("");
		scrollPane.setViewportView(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Close");
		
		btnNewButton.addActionListener(e -> {
	         dispose();
	      });
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(176, 381, 109, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(TermsOfUse.class.getResource("/Images/hirenetwhite.png")));
		lblNewLabel_2.setBounds(0, 0, 456, 443);
		contentPane.add(lblNewLabel_2);
		this.setVisible(true);
		this.setTitle("Terms of Use");
		
	}
	
	
	
}
