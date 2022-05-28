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
import javax.swing.JButton;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnAlmostFiveYears = new JTextPane();
		txtpnAlmostFiveYears.setText("1) \u039C\u03C0\u03BF\u03C1\u03CE \u03BD\u03B1 \u03B4\u03B9\u03B1\u03B3\u03C1\u03AC\u03C8\u03C9 \u03C4\u03BF\u03BD \u03BB\u03BF\u03B3\u03B1\u03C1\u03B9\u03B1\u03C3\u03BC\u03CC \u03BC\u03BF\u03C5 \u03C3\u03B5 \u03C0\u03B5\u03C1\u03AF\u03C0\u03C4\u03C9\u03C3\u03B7 \u03C0\u03BF\u03C5 \u03B4\u03B5\u03BD \u03B5\u03C0\u03B9\u03B8\u03C5\u03BC\u03CE \u03BD\u03B1 \u03B5\u03AF\u03BC\u03B1\u03B9 \u03C0\u03BB\u03AD\u03BF\u03BD \u03C7\u03C1\u03AE\u03C3\u03C4\u03B7\u03C2; ");
		txtpnAlmostFiveYears.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnAlmostFiveYears.setBackground(Color.LIGHT_GRAY);
		txtpnAlmostFiveYears.setBounds(51, 37, 459, 47);
		contentPane.add(txtpnAlmostFiveYears);
		
		JTextPane txtpnAlmostFiveYears_1 = new JTextPane();
		txtpnAlmostFiveYears_1.setText("2) \u03A0\u03C9\u03C2 \u03BC\u03C0\u03BF\u03C1\u03CE \u03BD\u03B1 \u03B1\u03BD\u03B1\u03B2\u03B1\u03B8\u03BC\u03AF\u03C3\u03C9 \u03C4\u03B1 \u03C0\u03C1\u03BF\u03C3\u03CC\u03BD\u03C4\u03B1 \u03BC\u03BF\u03C5; ");
		txtpnAlmostFiveYears_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnAlmostFiveYears_1.setBackground(Color.LIGHT_GRAY);
		txtpnAlmostFiveYears_1.setBounds(51, 126, 459, 39);
		contentPane.add(txtpnAlmostFiveYears_1);
		
		JTextPane txtpnAlmostFiveYears_2 = new JTextPane();
		txtpnAlmostFiveYears_2.setText("3) \u03A0\u03C9\u03C2 \u03BC\u03C0\u03BF\u03C1\u03CE \u03BD\u03B1 \u03BB\u03AC\u03B2\u03C9 \u03BC\u03AD\u03C1\u03BF\u03C2 \u03C3\u03C4\u03B1 \u03C3\u03B5\u03BC\u03B9\u03BD\u03AC\u03C1\u03B9\u03B1; ");
		txtpnAlmostFiveYears_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnAlmostFiveYears_2.setBackground(Color.LIGHT_GRAY);
		txtpnAlmostFiveYears_2.setBounds(51, 201, 459, 29);
		contentPane.add(txtpnAlmostFiveYears_2);
		
		JTextPane txtpnAlmostFiveYears_3 = new JTextPane();
		txtpnAlmostFiveYears_3.setText("4)  \u03A0\u03C9\u03C2 \u03BC\u03C0\u03BF\u03C1\u03CE \u03BD\u03B1 \u03B3\u03AF\u03BD\u03C9 \u03C7\u03C1\u03AE\u03C3\u03C4\u03B7\u03C2(\u03B5\u03C1\u03B3\u03B1\u03B6\u03CC\u03BC\u03B5\u03BD\u03BF\u03C2/\u03B5\u03C4\u03B1\u03B9\u03C1\u03AF\u03B1);");
		txtpnAlmostFiveYears_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnAlmostFiveYears_3.setBackground(Color.LIGHT_GRAY);
		txtpnAlmostFiveYears_3.setBounds(51, 294, 459, 29);
		contentPane.add(txtpnAlmostFiveYears_3);
		
		JTextPane txtpnAlmostFiveYears_2_1 = new JTextPane();
		txtpnAlmostFiveYears_2_1.setText("\u039A\u03B1\u03B8\u03CE\u03C2 \u03B3\u03AF\u03BD\u03B5\u03B9\u03C2 \u03C7\u03C1\u03AE\u03C3\u03C4\u03B7\u03C2 \u03B8\u03B1 \u03C5\u03C0\u03AC\u03C1\u03C7\u03B5\u03B9 \u03C4\u03BF \u03BA\u03BF\u03C5\u03BC\u03C0\u03AF, book, \u03C3\u03B5 \u03BA\u03AC\u03B8\u03B5 \u03C0\u03B5\u03C1\u03B9\u03B3\u03C1\u03B1\u03C6\u03AE \u03C4\u03C9\u03BD \u03C3\u03B5\u03BC\u03B9\u03BD\u03B1\u03C1\u03AF\u03C9\u03BD. \u0388\u03C0\u03B5\u03B9\u03C4\u03B1, \u03BC\u03B5\u03C4\u03AC \u03C4\u03BF \u03C0\u03AC\u03C4\u03B7\u03BC\u03B1 \u03C4\u03BF\u03C5 \u03BA\u03BF\u03C5\u03BC\u03C0\u03B9\u03BF\u03CD \u03B8\u03B1 \u03C0\u03C1\u03BF\u03C3\u03C4\u03AF\u03B8\u03B5\u03C4\u03B1\u03B9 \u03C3\u03C4\u03B9\u03C2 \u03B5\u03B9\u03B4\u03BF\u03C0\u03BF\u03B9\u03AE\u03C3\u03B5\u03B9\u03C2 \u03BF\u03B9 \u03C0\u03B5\u03C1\u03B5\u03C4\u03B1\u03AF\u03C1\u03C9 \u03C0\u03BB\u03B7\u03C1\u03BF\u03C6\u03BF\u03C1\u03AF\u03B5\u03C2 \u03B3\u03B9\u03B1 \u03C4\u03BF \u03C3\u03B5\u03BC\u03B9\u03BD\u03AC\u03C1\u03B9\u03BF.");
		txtpnAlmostFiveYears_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnAlmostFiveYears_2_1.setBackground(Color.WHITE);
		txtpnAlmostFiveYears_2_1.setBounds(51, 231, 459, 56);
		contentPane.add(txtpnAlmostFiveYears_2_1);
		
		JTextPane txtpnAlmostFiveYears_2_1_1 = new JTextPane();
		txtpnAlmostFiveYears_2_1_1.setText("\u0391\u03C1\u03C7\u03B9\u03BA\u03AC, \u03C0\u03B1\u03C4\u03CE\u03BD\u03C4\u03B1\u03C2 \u03C4\u03BF \u03BA\u03BF\u03C5\u03BC\u03C0\u03AF, Sing up, \u03C0\u03C1\u03AD\u03C0\u03B5\u03B9 \u03BD\u03B1 \u03B5\u03C0\u03B9\u03BB\u03AD\u03BE\u03B5\u03B9\u03C2 \u03AC\u03BC\u03B1 \u03B5\u03AF\u03C3\u03B1\u03B9 \u03B5\u03C1\u03B3\u03B1\u03B6\u03CC\u03BC\u03B5\u03BD\u03BF\u03C2 \u03AE \u03B5\u03C4\u03B1\u03B9\u03C1\u03AF\u03B1. \u0391\u03BD \u03B5\u03C0\u03B9\u03BB\u03AD\u03BE\u03B5\u03B9\u03C2 \u03B5\u03C1\u03B3\u03B1\u03B6\u03CC\u03BC\u03B5\u03BD\u03BF\u03C2: \u03A3\u03C5\u03BC\u03C0\u03BB\u03B7\u03C1\u03CE\u03BD\u03B5\u03B9\u03C2 \u03C4\u03B1 \u03C0\u03C1\u03BF\u03C3\u03C9\u03C0\u03B9\u03BA\u03AC \u03C3\u03BF\u03C5 \u03C3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03B1, \u03AD\u03C0\u03B5\u03B9\u03C4\u03B1 \u03B5\u03C0\u03B9\u03BB\u03AD\u03B3\u03B5\u03B9\u03C2 \u03C4\u03BF \u03BA\u03C9\u03B4\u03B9\u03BA\u03CC \u03C0\u03C1\u03CC\u03C3\u03B2\u03B1\u03C3\u03B7\u03C2 \u03CE\u03C3\u03C4\u03B5 \u03BD\u03B1 \u03B4\u03B7\u03BC\u03B9\u03BF\u03C5\u03C1\u03B3\u03B5\u03AF \u03C4\u03BF \u03C0\u03C1\u03BF\u03C6\u03AF\u03BB \u03C3\u03BF\u03C5, \u03C3\u03C4\u03B7 \u03C3\u03C5\u03BD\u03AD\u03C7\u03B5\u03B9\u03B1, \u03BA\u03AC\u03BD\u03B5\u03B9\u03C2 log in \u2026.");
		txtpnAlmostFiveYears_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnAlmostFiveYears_2_1_1.setBackground(Color.WHITE);
		txtpnAlmostFiveYears_2_1_1.setBounds(51, 327, 459, 66);
		contentPane.add(txtpnAlmostFiveYears_2_1_1);
		
		JTextPane txtpnAlmostFiveYears_3_1 = new JTextPane();
		txtpnAlmostFiveYears_3_1.setText("5) \u039F \u03BA\u03C9\u03B4\u03B9\u03BA\u03CC\u03C2 \u03C0\u03C1\u03AD\u03C0\u03B5\u03B9 \u03BD\u03B1 \u03C4\u03B7\u03C1\u03B5\u03AF \u03BA\u03AC\u03C0\u03BF\u03B9\u03B5\u03C2 \u03C0\u03C1\u03BF\u03CB\u03C0\u03BF\u03B8\u03AD\u03C3\u03B5\u03B9\u03C2 \u03C0.\u03C7. \u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u03C7\u03B1\u03C1\u03B1\u03BA\u03C4\u03AE\u03C1\u03C9\u03BD \u03AE \u03B1\u03C1\u03B9\u03B8\u03BC\u03BF\u03CD\u03C2;");
		txtpnAlmostFiveYears_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnAlmostFiveYears_3_1.setBackground(Color.LIGHT_GRAY);
		txtpnAlmostFiveYears_3_1.setBounds(51, 395, 459, 47);
		contentPane.add(txtpnAlmostFiveYears_3_1);
		
		JTextPane txtpnAlmostFiveYears_2_1_1_1 = new JTextPane();
		txtpnAlmostFiveYears_2_1_1_1.setText("\u038C\u03C7\u03B9, \u03BF \u03BA\u03C9\u03B4\u03B9\u03BA\u03CC\u03C2 \u03B4\u03B5\u03BD \u03AD\u03C7\u03B5\u03B9 \u03BA\u03AC\u03C0\u03BF\u03B9\u03BF\u03BD \u03C3\u03C5\u03BC\u03B2\u03B9\u03B2\u03B1\u03C3\u03BC\u03CC.");
		txtpnAlmostFiveYears_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnAlmostFiveYears_2_1_1_1.setBackground(Color.WHITE);
		txtpnAlmostFiveYears_2_1_1_1.setBounds(51, 442, 459, 29);
		contentPane.add(txtpnAlmostFiveYears_2_1_1_1);
		
		JTextPane txtpnAlmostFiveYears_2_1_1_1_1 = new JTextPane();
		txtpnAlmostFiveYears_2_1_1_1_1.setText("\u03A3\u03C4\u03BF \u03C0\u03B1\u03C1\u03AC\u03B8\u03C5\u03C1\u03BF \u03BC\u03B5 \u03C4\u03B1 \u03C0\u03C1\u03BF\u03C3\u03CC\u03BD\u03C4\u03B1 \u03C5\u03C0\u03AC\u03C1\u03C7\u03B5\u03B9 \u03C4\u03BF \u03BA\u03BF\u03C5\u03BC\u03C0\u03AF, load, \u03C0\u03BF\u03C5 \u03C3\u03B1\u03C2 \u03B4\u03AF\u03BD\u03B5\u03B9 \u03C4\u03B7\u03BD \u03B4\u03C5\u03BD\u03B1\u03C4\u03CC\u03C4\u03B7\u03C4\u03B1 \u03BD\u03B1 \u03C0\u03C1\u03BF\u03C3\u03B8\u03AD\u03C3\u03B5\u03C4\u03B5 \u03C0\u03B5\u03C1\u03B9\u03C3\u03C3\u03CC\u03C4\u03B5\u03C1\u03B1.");
		txtpnAlmostFiveYears_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnAlmostFiveYears_2_1_1_1_1.setBackground(Color.WHITE);
		txtpnAlmostFiveYears_2_1_1_1_1.setBounds(51, 164, 459, 39);
		contentPane.add(txtpnAlmostFiveYears_2_1_1_1_1);
		
		JTextPane txtpnAlmostFiveYears_2_1_1_1_1_1 = new JTextPane();
		txtpnAlmostFiveYears_2_1_1_1_1_1.setText("\u039D\u03B1\u03B9, \u03C5\u03C0\u03AC\u03C1\u03C7\u03B5\u03B9 \u03C4\u03BF \u03BA\u03B1\u03C4\u03AC\u03BB\u03BB\u03B7\u03BB\u03BF \u03BA\u03BF\u03C5\u03BC\u03C0\u03AF \u03C3\u03C4\u03BF \u03C0\u03C1\u03BF\u03C6\u03AF\u03BB \u03C3\u03B1\u03C2.");
		txtpnAlmostFiveYears_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnAlmostFiveYears_2_1_1_1_1_1.setBackground(Color.WHITE);
		txtpnAlmostFiveYears_2_1_1_1_1_1.setBounds(51, 82, 459, 29);
		contentPane.add(txtpnAlmostFiveYears_2_1_1_1_1_1);
		
		JTextPane txtpnAlmostFiveYears_3_1_1 = new JTextPane();
		txtpnAlmostFiveYears_3_1_1.setText("6) \u0393\u03B9\u03B1 \u03BD\u03B1 \u03B3\u03AF\u03BD\u03C9 \u03C7\u03C1\u03AE\u03C3\u03C4\u03B7\u03C2 \u03C0\u03C1\u03AD\u03C0\u03B5\u03B9 \u03BD\u03B1 \u03C0\u03BB\u03B7\u03C1\u03CE\u03C3\u03C9 \u03BA\u03AC\u03C0\u03BF\u03B9\u03BF \u03C3\u03C5\u03B3\u03BA\u03B5\u03BA\u03C1\u03B9\u03BC\u03AD\u03BD\u03BF \u03C0\u03BF\u03C3\u03CC; ");
		txtpnAlmostFiveYears_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnAlmostFiveYears_3_1_1.setBackground(Color.LIGHT_GRAY);
		txtpnAlmostFiveYears_3_1_1.setBounds(51, 476, 459, 47);
		contentPane.add(txtpnAlmostFiveYears_3_1_1);
		
		JTextPane txtpnAlmostFiveYears_2_1_1_1_2 = new JTextPane();
		txtpnAlmostFiveYears_2_1_1_1_2.setText("\u038C\u03C7\u03B9, \u03B7 \u03B5\u03B3\u03B3\u03C1\u03B1\u03C6\u03AE \u03C3\u03B1\u03C2 \u03B5\u03AF\u03BD\u03B1\u03B9 \u03B4\u03C9\u03C1\u03B5\u03AC\u03BD.");
		txtpnAlmostFiveYears_2_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnAlmostFiveYears_2_1_1_1_2.setBackground(Color.WHITE);
		txtpnAlmostFiveYears_2_1_1_1_2.setBounds(51, 524, 459, 29);
		contentPane.add(txtpnAlmostFiveYears_2_1_1_1_2);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(493, 10, 68, 21);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     
				dispose();
				
			}
		});
		
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

