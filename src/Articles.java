
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


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

public class Articles extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Articles frame = new Articles();
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
	public Articles() {
		setBounds(100, 100, 973, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Linux is the quiet revolution that will leave Microsoft eating dust");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(30, 38, 421, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblThatWillLeave = new JLabel("Help your employees thrive with Microsoft Viva in the hybrid world");
		lblThatWillLeave.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblThatWillLeave.setBounds(30, 221, 421, 37);
		contentPane.add(lblThatWillLeave);
		
		JTextPane txtpnLinuxTheMost = new JTextPane();
		txtpnLinuxTheMost.setEditable(false);
		txtpnLinuxTheMost.setText("Linux, the most widely used open source operating system in the world, has scored a major publicity coup in the revelation that it is used on 94% of the world\u2019s top 500 supercomputers.");
		txtpnLinuxTheMost.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnLinuxTheMost.setBackground(Color.LIGHT_GRAY);
		txtpnLinuxTheMost.setBounds(30, 76, 421, 111);
		contentPane.add(txtpnLinuxTheMost);
		
		JTextPane txtpnAsTheShift = new JTextPane();
		txtpnAsTheShift.setEditable(false);
		txtpnAsTheShift.setText("As the shift to hybrid work becomes a reality, it is clear that the workplace today is different than it was two years ago. Employees\u2019 expectations continue to evolve as they reconsider their \u201Cworth it\u201D equation. In our 2022 Work Trend Index, 53 percent of employees say they\u2019re more likely to prioritize their health and wellbeing over work than before. At the same time, 43 percent of employees are somewhat or extremely likely to consider changing jobs in the coming year, with younger employees even more likely to consider changing employers.  ");
		txtpnAsTheShift.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnAsTheShift.setBackground(Color.LIGHT_GRAY);
		txtpnAsTheShift.setBounds(30, 268, 421, 171);
		contentPane.add(txtpnAsTheShift);
		
		JLabel lblJavasMissingFeatures = new JLabel("Java's Missing Features: Five Years Later");
		lblJavasMissingFeatures.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblJavasMissingFeatures.setBounds(30, 492, 263, 37);
		contentPane.add(lblJavasMissingFeatures);
		
		JTextPane txtpnAlmostFiveYears = new JTextPane();
		txtpnAlmostFiveYears.setEditable(false);
		txtpnAlmostFiveYears.setText("Almost five years ago, I wrote an article outlining some feature ideas from other languages that I felt could be of benefit to Java. A lot has happened since then \u2014 at that time, Java 8 was the newly minted release, whereas the most recent version is now Java 14.");
		txtpnAlmostFiveYears.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnAlmostFiveYears.setBackground(Color.LIGHT_GRAY);
		txtpnAlmostFiveYears.setBounds(30, 536, 421, 111);
		contentPane.add(txtpnAlmostFiveYears);
		
		JLabel lblBestProgrammingLanguages = new JLabel("Best Programming Languages to Learn in 2022");
		lblBestProgrammingLanguages.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBestProgrammingLanguages.setBounds(528, 38, 331, 28);
		contentPane.add(lblBestProgrammingLanguages);
		
		JTextPane txtpnOnceUponA = new JTextPane();
		txtpnOnceUponA.setEditable(false);
		txtpnOnceUponA.setText("Once upon a time, the world of computer programming was a mysterious and exclusive place. Only a select handful of people were considered computer programmers with cutting-edge coding skills. Today, many IT jobs require a solid grasp of the top programming languages, and yes, we mean more than one. ");
		txtpnOnceUponA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnOnceUponA.setBackground(Color.LIGHT_GRAY);
		txtpnOnceUponA.setBounds(528, 76, 421, 111);
		contentPane.add(txtpnOnceUponA);
		
		JTextPane txtpnLinuxTheMost_1_1 = new JTextPane();
		txtpnLinuxTheMost_1_1.setEditable(false);
		txtpnLinuxTheMost_1_1.setText("Afraid of coding and a thought arises in your mind that you won\u2019t get a high-paying job, then you\u2019re wrong. Calm Down Geeks, it\u2019s completely okay if you\u2019re not good at coding and still searching for a technical job. Even students at college are tired of hearing about jobs for software developers, again and again, many have least or no interest in coding. The future seems to be confusing for them. There are a lot of people who wander in search of high-paying jobs other than software developers and there\u2019s also high demand for it. ");
		txtpnLinuxTheMost_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnLinuxTheMost_1_1.setBackground(Color.LIGHT_GRAY);
		txtpnLinuxTheMost_1_1.setBounds(528, 268, 421, 171);
		contentPane.add(txtpnLinuxTheMost_1_1);
		
		JTextPane txtpnLinuxTheMost_1_2 = new JTextPane();
		txtpnLinuxTheMost_1_2.setEditable(false);
		txtpnLinuxTheMost_1_2.setText("Since its inception in 1965, Medicare has been leading the way in providing affordable, quality coverage and care, playing a key role in the health and financial security of more than 63 million Americans. As the largest single purchaser of health care\u2014with one in every five health care dollars paid by the program\u2014Medicare serves as a transformative force in the United States. It plays a central role in the Biden Administration\u2019s vision for the Centers for Medicare & Medicaid Services (CMS): to serve the public as a trusted partner and steward, dedicated to advancing health equity, expanding access to affordable coverage and care, and improving health outcomes. ");
		txtpnLinuxTheMost_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnLinuxTheMost_1_2.setBackground(Color.LIGHT_GRAY);
		txtpnLinuxTheMost_1_2.setBounds(528, 536, 421, 199);
		contentPane.add(txtpnLinuxTheMost_1_2);
		
		JLabel lblHighestPaying = new JLabel("7 Highest Paying Technical Jobs Other Than Software Developers");
		lblHighestPaying.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHighestPaying.setBounds(528, 221, 421, 28);
		contentPane.add(lblHighestPaying);
		
		JLabel lblBuildingOnThe = new JLabel("Working Together For A Stronger Medicare");
		lblBuildingOnThe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBuildingOnThe.setBounds(528, 496, 421, 28);
		contentPane.add(lblBuildingOnThe);
		
		JLabel lblBuildingOnThe_2 = new JLabel("Building On The CMS Strategic Vision: ");
		lblBuildingOnThe_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBuildingOnThe_2.setBounds(528, 475, 421, 28);
		contentPane.add(lblBuildingOnThe_2);
		
		JLabel more = new JLabel("continue reading");
		more.setForeground(new Color(0, 0, 139));
		more.setFont(new Font("Tahoma", Font.PLAIN, 11));
		more.setBounds(336, 197, 115, 13);
		more.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://theconversation-com.translate.goog/linux-is-the-quiet-revolution-that-will-leave-microsoft-eating-dust-28533?_x_tr_sl=en&_x_tr_tl=el&_x_tr_hl=el&_x_tr_pto=op%2Csc&fbclid=IwAR0JzmZ2j2vrLjSX8YFaqm3xodyapcUeE0Cegr9avb86EecMBY0QY4z_tg4"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		contentPane.add(more);
		
		JLabel more_1 = new JLabel("continue reading");
		more_1.setForeground(new Color(0, 0, 139));
		more_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		more_1.setBounds(336, 452, 115, 13);
		more_1.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www-microsoft-com.translate.goog/en-us/microsoft-365/blog/2022/03/24/help-your-employees-thrive-with-microsoft-viva-in-the-hybrid-world/?_x_tr_sl=en&_x_tr_tl=el&_x_tr_hl=el&_x_tr_pto=op%2Csc&fbclid=IwAR0C00Kr_QQce9FNbOnkMUlVbJpTbKprsKkSUAI4mnhymxhWShvsgNfDqSE"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		contentPane.add(more_1);
		
		
		JLabel more_2 = new JLabel("continue reading");
		more_2.setForeground(new Color(0, 0, 139));
		more_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		more_2.setBounds(336, 657, 115, 13);
		more_2.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.infoq.com/articles/java-missing-features-5years/?fbclid=IwAR0Sl6mHy6uE4fzHxR57Ve9K-G04Aj5o1yQQ3g_JTTAmkb6MH-nzZ08xmOk"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		contentPane.add(more_2);
		
		
		JLabel more_3 = new JLabel("continue reading");
		more_3.setForeground(new Color(0, 0, 139));
		more_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		more_3.setBounds(834, 197, 115, 13);
		more_3.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.simplilearn.com/best-programming-languages-start-learning-today-article?fbclid=IwAR00LYTuyuB_lfdrDqHjTjA7G-dk4sJMpL1gUGY1DXcMWXV5laUTAiTnPiU"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		contentPane.add(more_3);
		
		
		JLabel more_4 = new JLabel("continue reading");
		more_4.setForeground(new Color(0, 0, 139));
		more_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		more_4.setBounds(834, 452, 115, 13);
		more_4.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www-geeksforgeeks-org.translate.goog/7-highest-paying-technical-jobs-other-than-software-developers/?ref=leftbar-rightbar&_x_tr_sl=en&_x_tr_tl=el&_x_tr_hl=el&_x_tr_pto=op%2Csc&fbclid=IwAR2b6q0hDEh4EgMLxgKZ6BLqo7OaxmBdZ39UlnAY1UtsvGaNLKZPwE9x42Y"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		contentPane.add(more_4);

		
		
		JLabel more_5 = new JLabel("continue reading");
		more_5.setForeground(new Color(0, 0, 139));
		more_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		more_5.setBounds(834, 744, 115, 13);
		more_4.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www-healthaffairs-org.translate.goog/do/10.1377/forefront.20220110.198444?cookieSet=1&_x_tr_sl=en&_x_tr_tl=el&_x_tr_hl=el&_x_tr_pto=op,sc"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		contentPane.add(more_5);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnBack.setBackground(new Color(47, 79, 79));
		btnBack.setBounds(20, 24, 78, 19);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			} });
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}



