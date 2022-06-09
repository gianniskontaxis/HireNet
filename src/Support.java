import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Desktop;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JSeparator;

public class Support extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Support frame = new Support();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Support() {
		setResizable(false);
		setTitle("Support");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Support.class.getResource("/Images/logo_icon25x25.png")));
		setBounds(100, 100, 600, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Support");
		lblNewLabel_1.setIcon(new ImageIcon(Support.class.getResource("/Images/support_icon.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(222, 12, 129, 32);
		contentPane.add(lblNewLabel_1);
		
		JTextPane txtpnAlmostFiveYears = new JTextPane();
		txtpnAlmostFiveYears.setEditable(false);
		txtpnAlmostFiveYears.setOpaque(false);
		txtpnAlmostFiveYears.setText("1) Can I delete my account if I don\u2019t want to be user anymore? ");
		txtpnAlmostFiveYears.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtpnAlmostFiveYears.setBackground(Color.LIGHT_GRAY);
		txtpnAlmostFiveYears.setBounds(52, 72, 459, 47);
		contentPane.add(txtpnAlmostFiveYears);
		
		JTextPane txtpnAlmostFiveYears_1 = new JTextPane();
		txtpnAlmostFiveYears_1.setEditable(false);
		txtpnAlmostFiveYears_1.setOpaque(false);
		txtpnAlmostFiveYears_1.setText("2) How can I upgrade my skills?");
		txtpnAlmostFiveYears_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtpnAlmostFiveYears_1.setBackground(Color.LIGHT_GRAY);
		txtpnAlmostFiveYears_1.setBounds(51, 143, 459, 39);
		contentPane.add(txtpnAlmostFiveYears_1);
		
		JTextPane txtpnAlmostFiveYears_2 = new JTextPane();
		txtpnAlmostFiveYears_2.setEditable(false);
		txtpnAlmostFiveYears_2.setOpaque(false);
		txtpnAlmostFiveYears_2.setText("3) How can I participate in the seminars?  ");
		txtpnAlmostFiveYears_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtpnAlmostFiveYears_2.setBackground(Color.LIGHT_GRAY);
		txtpnAlmostFiveYears_2.setBounds(51, 240, 459, 29);
		contentPane.add(txtpnAlmostFiveYears_2);
		
		JTextPane txtpnAlmostFiveYears_3 = new JTextPane();
		txtpnAlmostFiveYears_3.setEditable(false);
		txtpnAlmostFiveYears_3.setOpaque(false);
		txtpnAlmostFiveYears_3.setText("4) How can I recover my password?");
		txtpnAlmostFiveYears_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtpnAlmostFiveYears_3.setBackground(Color.LIGHT_GRAY);
		txtpnAlmostFiveYears_3.setBounds(51, 332, 459, 29);
		contentPane.add(txtpnAlmostFiveYears_3);
		
		JTextPane txtpnAlmostFiveYears_2_1 = new JTextPane();
		txtpnAlmostFiveYears_2_1.setText("As you become a user there is a \"book\" button in every description of the seminars. Then, after pressing the button, further information about the seminar will be added to the notifications.");
		txtpnAlmostFiveYears_2_1.setEditable(false);
		txtpnAlmostFiveYears_2_1.setOpaque(false);
		txtpnAlmostFiveYears_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnAlmostFiveYears_2_1.setBackground(Color.WHITE);
		txtpnAlmostFiveYears_2_1.setBounds(61, 266, 459, 56);
		contentPane.add(txtpnAlmostFiveYears_2_1);
		
		JTextPane txtpnAlmostFiveYears_2_1_1 = new JTextPane();
		txtpnAlmostFiveYears_2_1_1.setText("In case you forget your password, there is a \"forgot password\u201D button at log in window. Once you press it, one window will appear and you should fill in your username and your favourite password. If your data are correct, your password will appear at your screen.");
		txtpnAlmostFiveYears_2_1_1.setEditable(false);
		txtpnAlmostFiveYears_2_1_1.setOpaque(false);
		txtpnAlmostFiveYears_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnAlmostFiveYears_2_1_1.setBackground(Color.WHITE);
		txtpnAlmostFiveYears_2_1_1.setBounds(61, 359, 459, 66);
		contentPane.add(txtpnAlmostFiveYears_2_1_1);
		
		JTextPane txtpnAlmostFiveYears_3_1 = new JTextPane();
		txtpnAlmostFiveYears_3_1.setEditable(false);
		txtpnAlmostFiveYears_3_1.setOpaque(false);
		txtpnAlmostFiveYears_3_1.setText("5) Does the password have any restrictions?");
		txtpnAlmostFiveYears_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtpnAlmostFiveYears_3_1.setBackground(Color.LIGHT_GRAY);
		txtpnAlmostFiveYears_3_1.setBounds(51, 435, 459, 47);
		contentPane.add(txtpnAlmostFiveYears_3_1);
		
		JTextPane txtpnAlmostFiveYears_2_1_1_1 = new JTextPane();
		txtpnAlmostFiveYears_2_1_1_1.setEditable(false);
		txtpnAlmostFiveYears_2_1_1_1.setOpaque(false);
		txtpnAlmostFiveYears_2_1_1_1.setText("The password must be at least 8 characters.");
		txtpnAlmostFiveYears_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnAlmostFiveYears_2_1_1_1.setBackground(Color.WHITE);
		txtpnAlmostFiveYears_2_1_1_1.setBounds(61, 467, 459, 29);
		contentPane.add(txtpnAlmostFiveYears_2_1_1_1);
		
		JTextPane txtpnAlmostFiveYears_2_1_1_1_1 = new JTextPane();
		txtpnAlmostFiveYears_2_1_1_1_1.setText("First, you should open your CV window. There is a button called \u201CAdd Qualficications\u201D. Once you push this, a window with skills will appear and you will be able to add yours. When you are finished, you can save your Qualifications and return to main Menu.");
		txtpnAlmostFiveYears_2_1_1_1_1.setEditable(false);
		txtpnAlmostFiveYears_2_1_1_1_1.setOpaque(false);
		txtpnAlmostFiveYears_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnAlmostFiveYears_2_1_1_1_1.setBackground(Color.WHITE);
		txtpnAlmostFiveYears_2_1_1_1_1.setBounds(61, 166, 459, 70);
		contentPane.add(txtpnAlmostFiveYears_2_1_1_1_1);
		
		JTextPane txtpnAlmostFiveYears_2_1_1_1_1_1 = new JTextPane();
		txtpnAlmostFiveYears_2_1_1_1_1_1.setText("Yes, there is a suitable button on profile window.");
		txtpnAlmostFiveYears_2_1_1_1_1_1.setEditable(false);
		txtpnAlmostFiveYears_2_1_1_1_1_1.setOpaque(false);
		txtpnAlmostFiveYears_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnAlmostFiveYears_2_1_1_1_1_1.setBackground(Color.WHITE);
		txtpnAlmostFiveYears_2_1_1_1_1_1.setBounds(61, 115, 459, 29);
		contentPane.add(txtpnAlmostFiveYears_2_1_1_1_1_1);
		
		JTextPane txtpnAlmostFiveYears_3_1_1 = new JTextPane();
		txtpnAlmostFiveYears_3_1_1.setEditable(false);
		txtpnAlmostFiveYears_3_1_1.setOpaque(false);
		txtpnAlmostFiveYears_3_1_1.setText("6) How can I change my personal information? ");
		txtpnAlmostFiveYears_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtpnAlmostFiveYears_3_1_1.setBackground(Color.LIGHT_GRAY);
		txtpnAlmostFiveYears_3_1_1.setBounds(51, 492, 459, 47);
		contentPane.add(txtpnAlmostFiveYears_3_1_1);
		
		JTextPane txtpnAlmostFiveYears_2_1_1_1_2 = new JTextPane();
		txtpnAlmostFiveYears_2_1_1_1_2.setText("You can change your e-mail, your phone and your favourite number at profile window. Your first and last name, your age and your country can be changed at CV window.");
		txtpnAlmostFiveYears_2_1_1_1_2.setEditable(false);
		txtpnAlmostFiveYears_2_1_1_1_2.setOpaque(false);
		txtpnAlmostFiveYears_2_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnAlmostFiveYears_2_1_1_1_2.setBackground(Color.WHITE);
		txtpnAlmostFiveYears_2_1_1_1_2.setBounds(61, 525, 459, 56);
		contentPane.add(txtpnAlmostFiveYears_2_1_1_1_2);
		
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(Support.class.getResource("/Images/backblack.png")));
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnBack.setBackground(new Color(47, 79, 79));
		btnBack.setBounds(10, 12, 32, 32);
		btnBack.setOpaque(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		contentPane.add(btnBack);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(0, 54, 586, 8);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Support.class.getResource("/Images/hirenetwhite2.png")));
		lblNewLabel.setBounds(0, 0, 586, 643);
		contentPane.add(lblNewLabel);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     
				dispose();
				
			}
		});
		
		
		
		this.setVisible(true);
		
	}
}

