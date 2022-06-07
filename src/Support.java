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
		txtpnAlmostFiveYears.setText("1) \u039C\u03C0\u03BF\u03C1\u03CE \u03BD\u03B1 \u03B4\u03B9\u03B1\u03B3\u03C1\u03AC\u03C8\u03C9 \u03C4\u03BF\u03BD \u03BB\u03BF\u03B3\u03B1\u03C1\u03B9\u03B1\u03C3\u03BC\u03CC \u03BC\u03BF\u03C5 \u03C3\u03B5 \u03C0\u03B5\u03C1\u03AF\u03C0\u03C4\u03C9\u03C3\u03B7 \u03C0\u03BF\u03C5 \u03B4\u03B5\u03BD \u03B5\u03C0\u03B9\u03B8\u03C5\u03BC\u03CE \u03BD\u03B1 \u03B5\u03AF\u03BC\u03B1\u03B9 \u03C0\u03BB\u03AD\u03BF\u03BD \u03C7\u03C1\u03AE\u03C3\u03C4\u03B7\u03C2; ");
		txtpnAlmostFiveYears.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtpnAlmostFiveYears.setBackground(Color.LIGHT_GRAY);
		txtpnAlmostFiveYears.setBounds(51, 86, 459, 47);
		contentPane.add(txtpnAlmostFiveYears);
		
		JTextPane txtpnAlmostFiveYears_1 = new JTextPane();
		txtpnAlmostFiveYears_1.setEditable(false);
		txtpnAlmostFiveYears_1.setOpaque(false);
		txtpnAlmostFiveYears_1.setText("2) \u03A0\u03C9\u03C2 \u03BC\u03C0\u03BF\u03C1\u03CE \u03BD\u03B1 \u03B1\u03BD\u03B1\u03B2\u03B1\u03B8\u03BC\u03AF\u03C3\u03C9 \u03C4\u03B1 \u03C0\u03C1\u03BF\u03C3\u03CC\u03BD\u03C4\u03B1 \u03BC\u03BF\u03C5; ");
		txtpnAlmostFiveYears_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtpnAlmostFiveYears_1.setBackground(Color.LIGHT_GRAY);
		txtpnAlmostFiveYears_1.setBounds(51, 171, 459, 39);
		contentPane.add(txtpnAlmostFiveYears_1);
		
		JTextPane txtpnAlmostFiveYears_2 = new JTextPane();
		txtpnAlmostFiveYears_2.setEditable(false);
		txtpnAlmostFiveYears_2.setOpaque(false);
		txtpnAlmostFiveYears_2.setText("3) \u03A0\u03C9\u03C2 \u03BC\u03C0\u03BF\u03C1\u03CE \u03BD\u03B1 \u03BB\u03AC\u03B2\u03C9 \u03BC\u03AD\u03C1\u03BF\u03C2 \u03C3\u03C4\u03B1 \u03C3\u03B5\u03BC\u03B9\u03BD\u03AC\u03C1\u03B9\u03B1; ");
		txtpnAlmostFiveYears_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtpnAlmostFiveYears_2.setBackground(Color.LIGHT_GRAY);
		txtpnAlmostFiveYears_2.setBounds(51, 260, 459, 29);
		contentPane.add(txtpnAlmostFiveYears_2);
		
		JTextPane txtpnAlmostFiveYears_3 = new JTextPane();
		txtpnAlmostFiveYears_3.setEditable(false);
		txtpnAlmostFiveYears_3.setOpaque(false);
		txtpnAlmostFiveYears_3.setText("4)  \u03A0\u03C9\u03C2 \u03BC\u03C0\u03BF\u03C1\u03CE \u03BD\u03B1 \u03B3\u03AF\u03BD\u03C9 \u03C7\u03C1\u03AE\u03C3\u03C4\u03B7\u03C2(\u03B5\u03C1\u03B3\u03B1\u03B6\u03CC\u03BC\u03B5\u03BD\u03BF\u03C2/\u03B5\u03C4\u03B1\u03B9\u03C1\u03AF\u03B1);");
		txtpnAlmostFiveYears_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtpnAlmostFiveYears_3.setBackground(Color.LIGHT_GRAY);
		txtpnAlmostFiveYears_3.setBounds(51, 355, 459, 29);
		contentPane.add(txtpnAlmostFiveYears_3);
		
		JTextPane txtpnAlmostFiveYears_2_1 = new JTextPane();
		txtpnAlmostFiveYears_2_1.setEditable(false);
		txtpnAlmostFiveYears_2_1.setOpaque(false);
		txtpnAlmostFiveYears_2_1.setText("\u039A\u03B1\u03B8\u03CE\u03C2 \u03B3\u03AF\u03BD\u03B5\u03B9\u03C2 \u03C7\u03C1\u03AE\u03C3\u03C4\u03B7\u03C2 \u03B8\u03B1 \u03C5\u03C0\u03AC\u03C1\u03C7\u03B5\u03B9 \u03C4\u03BF \u03BA\u03BF\u03C5\u03BC\u03C0\u03AF, book, \u03C3\u03B5 \u03BA\u03AC\u03B8\u03B5 \u03C0\u03B5\u03C1\u03B9\u03B3\u03C1\u03B1\u03C6\u03AE \u03C4\u03C9\u03BD \u03C3\u03B5\u03BC\u03B9\u03BD\u03B1\u03C1\u03AF\u03C9\u03BD. \u0388\u03C0\u03B5\u03B9\u03C4\u03B1, \u03BC\u03B5\u03C4\u03AC \u03C4\u03BF \u03C0\u03AC\u03C4\u03B7\u03BC\u03B1 \u03C4\u03BF\u03C5 \u03BA\u03BF\u03C5\u03BC\u03C0\u03B9\u03BF\u03CD \u03B8\u03B1 \u03C0\u03C1\u03BF\u03C3\u03C4\u03AF\u03B8\u03B5\u03C4\u03B1\u03B9 \u03C3\u03C4\u03B9\u03C2 \u03B5\u03B9\u03B4\u03BF\u03C0\u03BF\u03B9\u03AE\u03C3\u03B5\u03B9\u03C2 \u03BF\u03B9 \u03C0\u03B5\u03C1\u03B5\u03C4\u03B1\u03AF\u03C1\u03C9 \u03C0\u03BB\u03B7\u03C1\u03BF\u03C6\u03BF\u03C1\u03AF\u03B5\u03C2 \u03B3\u03B9\u03B1 \u03C4\u03BF \u03C3\u03B5\u03BC\u03B9\u03BD\u03AC\u03C1\u03B9\u03BF.");
		txtpnAlmostFiveYears_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnAlmostFiveYears_2_1.setBackground(Color.WHITE);
		txtpnAlmostFiveYears_2_1.setBounds(51, 289, 459, 56);
		contentPane.add(txtpnAlmostFiveYears_2_1);
		
		JTextPane txtpnAlmostFiveYears_2_1_1 = new JTextPane();
		txtpnAlmostFiveYears_2_1_1.setEditable(false);
		txtpnAlmostFiveYears_2_1_1.setOpaque(false);
		txtpnAlmostFiveYears_2_1_1.setText("\u0391\u03C1\u03C7\u03B9\u03BA\u03AC, \u03C0\u03B1\u03C4\u03CE\u03BD\u03C4\u03B1\u03C2 \u03C4\u03BF \u03BA\u03BF\u03C5\u03BC\u03C0\u03AF, Sing up, \u03C0\u03C1\u03AD\u03C0\u03B5\u03B9 \u03BD\u03B1 \u03B5\u03C0\u03B9\u03BB\u03AD\u03BE\u03B5\u03B9\u03C2 \u03AC\u03BC\u03B1 \u03B5\u03AF\u03C3\u03B1\u03B9 \u03B5\u03C1\u03B3\u03B1\u03B6\u03CC\u03BC\u03B5\u03BD\u03BF\u03C2 \u03AE \u03B5\u03C4\u03B1\u03B9\u03C1\u03AF\u03B1. \u0391\u03BD \u03B5\u03C0\u03B9\u03BB\u03AD\u03BE\u03B5\u03B9\u03C2 \u03B5\u03C1\u03B3\u03B1\u03B6\u03CC\u03BC\u03B5\u03BD\u03BF\u03C2: \u03A3\u03C5\u03BC\u03C0\u03BB\u03B7\u03C1\u03CE\u03BD\u03B5\u03B9\u03C2 \u03C4\u03B1 \u03C0\u03C1\u03BF\u03C3\u03C9\u03C0\u03B9\u03BA\u03AC \u03C3\u03BF\u03C5 \u03C3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03B1, \u03AD\u03C0\u03B5\u03B9\u03C4\u03B1 \u03B5\u03C0\u03B9\u03BB\u03AD\u03B3\u03B5\u03B9\u03C2 \u03C4\u03BF \u03BA\u03C9\u03B4\u03B9\u03BA\u03CC \u03C0\u03C1\u03CC\u03C3\u03B2\u03B1\u03C3\u03B7\u03C2 \u03CE\u03C3\u03C4\u03B5 \u03BD\u03B1 \u03B4\u03B7\u03BC\u03B9\u03BF\u03C5\u03C1\u03B3\u03B5\u03AF \u03C4\u03BF \u03C0\u03C1\u03BF\u03C6\u03AF\u03BB \u03C3\u03BF\u03C5, \u03C3\u03C4\u03B7 \u03C3\u03C5\u03BD\u03AD\u03C7\u03B5\u03B9\u03B1, \u03BA\u03AC\u03BD\u03B5\u03B9\u03C2 log in \u2026.");
		txtpnAlmostFiveYears_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnAlmostFiveYears_2_1_1.setBackground(Color.WHITE);
		txtpnAlmostFiveYears_2_1_1.setBounds(51, 383, 459, 66);
		contentPane.add(txtpnAlmostFiveYears_2_1_1);
		
		JTextPane txtpnAlmostFiveYears_3_1 = new JTextPane();
		txtpnAlmostFiveYears_3_1.setEditable(false);
		txtpnAlmostFiveYears_3_1.setOpaque(false);
		txtpnAlmostFiveYears_3_1.setText("5) \u039F \u03BA\u03C9\u03B4\u03B9\u03BA\u03CC\u03C2 \u03C0\u03C1\u03AD\u03C0\u03B5\u03B9 \u03BD\u03B1 \u03C4\u03B7\u03C1\u03B5\u03AF \u03BA\u03AC\u03C0\u03BF\u03B9\u03B5\u03C2 \u03C0\u03C1\u03BF\u03CB\u03C0\u03BF\u03B8\u03AD\u03C3\u03B5\u03B9\u03C2 \u03C0.\u03C7. \u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u03C7\u03B1\u03C1\u03B1\u03BA\u03C4\u03AE\u03C1\u03C9\u03BD \u03AE \u03B1\u03C1\u03B9\u03B8\u03BC\u03BF\u03CD\u03C2;");
		txtpnAlmostFiveYears_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtpnAlmostFiveYears_3_1.setBackground(Color.LIGHT_GRAY);
		txtpnAlmostFiveYears_3_1.setBounds(51, 459, 459, 47);
		contentPane.add(txtpnAlmostFiveYears_3_1);
		
		JTextPane txtpnAlmostFiveYears_2_1_1_1 = new JTextPane();
		txtpnAlmostFiveYears_2_1_1_1.setEditable(false);
		txtpnAlmostFiveYears_2_1_1_1.setOpaque(false);
		txtpnAlmostFiveYears_2_1_1_1.setText("\u038C\u03C7\u03B9, \u03BF \u03BA\u03C9\u03B4\u03B9\u03BA\u03CC\u03C2 \u03B4\u03B5\u03BD \u03AD\u03C7\u03B5\u03B9 \u03BA\u03AC\u03C0\u03BF\u03B9\u03BF\u03BD \u03C3\u03C5\u03BC\u03B2\u03B9\u03B2\u03B1\u03C3\u03BC\u03CC.");
		txtpnAlmostFiveYears_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnAlmostFiveYears_2_1_1_1.setBackground(Color.WHITE);
		txtpnAlmostFiveYears_2_1_1_1.setBounds(51, 506, 459, 29);
		contentPane.add(txtpnAlmostFiveYears_2_1_1_1);
		
		JTextPane txtpnAlmostFiveYears_2_1_1_1_1 = new JTextPane();
		txtpnAlmostFiveYears_2_1_1_1_1.setEditable(false);
		txtpnAlmostFiveYears_2_1_1_1_1.setOpaque(false);
		txtpnAlmostFiveYears_2_1_1_1_1.setText("\u03A3\u03C4\u03BF \u03C0\u03B1\u03C1\u03AC\u03B8\u03C5\u03C1\u03BF \u03BC\u03B5 \u03C4\u03B1 \u03C0\u03C1\u03BF\u03C3\u03CC\u03BD\u03C4\u03B1 \u03C5\u03C0\u03AC\u03C1\u03C7\u03B5\u03B9 \u03C4\u03BF \u03BA\u03BF\u03C5\u03BC\u03C0\u03AF, load, \u03C0\u03BF\u03C5 \u03C3\u03B1\u03C2 \u03B4\u03AF\u03BD\u03B5\u03B9 \u03C4\u03B7\u03BD \u03B4\u03C5\u03BD\u03B1\u03C4\u03CC\u03C4\u03B7\u03C4\u03B1 \u03BD\u03B1 \u03C0\u03C1\u03BF\u03C3\u03B8\u03AD\u03C3\u03B5\u03C4\u03B5 \u03C0\u03B5\u03C1\u03B9\u03C3\u03C3\u03CC\u03C4\u03B5\u03C1\u03B1.");
		txtpnAlmostFiveYears_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnAlmostFiveYears_2_1_1_1_1.setBackground(Color.WHITE);
		txtpnAlmostFiveYears_2_1_1_1_1.setBounds(51, 211, 459, 39);
		contentPane.add(txtpnAlmostFiveYears_2_1_1_1_1);
		
		JTextPane txtpnAlmostFiveYears_2_1_1_1_1_1 = new JTextPane();
		txtpnAlmostFiveYears_2_1_1_1_1_1.setEditable(false);
		txtpnAlmostFiveYears_2_1_1_1_1_1.setOpaque(false);
		txtpnAlmostFiveYears_2_1_1_1_1_1.setText("\u039D\u03B1\u03B9, \u03C5\u03C0\u03AC\u03C1\u03C7\u03B5\u03B9 \u03C4\u03BF \u03BA\u03B1\u03C4\u03AC\u03BB\u03BB\u03B7\u03BB\u03BF \u03BA\u03BF\u03C5\u03BC\u03C0\u03AF \u03C3\u03C4\u03BF \u03C0\u03C1\u03BF\u03C6\u03AF\u03BB \u03C3\u03B1\u03C2.");
		txtpnAlmostFiveYears_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnAlmostFiveYears_2_1_1_1_1_1.setBackground(Color.WHITE);
		txtpnAlmostFiveYears_2_1_1_1_1_1.setBounds(51, 132, 459, 29);
		contentPane.add(txtpnAlmostFiveYears_2_1_1_1_1_1);
		
		JTextPane txtpnAlmostFiveYears_3_1_1 = new JTextPane();
		txtpnAlmostFiveYears_3_1_1.setEditable(false);
		txtpnAlmostFiveYears_3_1_1.setOpaque(false);
		txtpnAlmostFiveYears_3_1_1.setText("6) \u0393\u03B9\u03B1 \u03BD\u03B1 \u03B3\u03AF\u03BD\u03C9 \u03C7\u03C1\u03AE\u03C3\u03C4\u03B7\u03C2 \u03C0\u03C1\u03AD\u03C0\u03B5\u03B9 \u03BD\u03B1 \u03C0\u03BB\u03B7\u03C1\u03CE\u03C3\u03C9 \u03BA\u03AC\u03C0\u03BF\u03B9\u03BF \u03C3\u03C5\u03B3\u03BA\u03B5\u03BA\u03C1\u03B9\u03BC\u03AD\u03BD\u03BF \u03C0\u03BF\u03C3\u03CC; ");
		txtpnAlmostFiveYears_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtpnAlmostFiveYears_3_1_1.setBackground(Color.LIGHT_GRAY);
		txtpnAlmostFiveYears_3_1_1.setBounds(51, 545, 459, 47);
		contentPane.add(txtpnAlmostFiveYears_3_1_1);
		
		JTextPane txtpnAlmostFiveYears_2_1_1_1_2 = new JTextPane();
		txtpnAlmostFiveYears_2_1_1_1_2.setEditable(false);
		txtpnAlmostFiveYears_2_1_1_1_2.setOpaque(false);
		txtpnAlmostFiveYears_2_1_1_1_2.setText("\u038C\u03C7\u03B9, \u03B7 \u03B5\u03B3\u03B3\u03C1\u03B1\u03C6\u03AE \u03C3\u03B1\u03C2 \u03B5\u03AF\u03BD\u03B1\u03B9 \u03B4\u03C9\u03C1\u03B5\u03AC\u03BD.");
		txtpnAlmostFiveYears_2_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnAlmostFiveYears_2_1_1_1_2.setBackground(Color.WHITE);
		txtpnAlmostFiveYears_2_1_1_1_2.setBounds(51, 591, 459, 29);
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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

