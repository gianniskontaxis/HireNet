import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JTree;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Terms of use");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
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
		
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.setBackground(new Color(47, 79, 79));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(176, 381, 109, 29);
		contentPane.add(btnNewButton);
		this.setVisible(true);
		this.setTitle("TermsOfUse");
		
	}
	
	
	
}
