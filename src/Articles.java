
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
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
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Articles extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public Articles() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Articles.class.getResource("/Images/logo_icon25x25.png")));
		setTitle("Articles");
		setBounds(100, 0, 973, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel more = new JLabel("Read more...");
		more.setForeground(new Color(51, 255, 204));
		more.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		more.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		more.setBounds(346, 236, 95, 20);
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
		
		JLabel articleslabel = new JLabel("Articles");
		articleslabel.setIcon(new ImageIcon(Articles.class.getResource("/Images/articlestitle.png")));
		articleslabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		articleslabel.setForeground(new Color(255, 255, 255));
		articleslabel.setBounds(437, 12, 128, 32);
		contentPane.add(articleslabel);
		contentPane.add(more);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(0, 54, 959, 8);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Linux is the quiet revolution that will leave Microsoft eating dust");
		lblNewLabel.setIcon(new ImageIcon(Articles.class.getResource("/Images/arrow1.png")));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(20, 83, 421, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblThatWillLeave = new JLabel("Help your employees thrive with Microsoft Viva in the hybrid world");
		lblThatWillLeave.setIcon(new ImageIcon(Articles.class.getResource("/Images/arrow1.png")));
		lblThatWillLeave.setForeground(new Color(255, 255, 255));
		lblThatWillLeave.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblThatWillLeave.setBounds(20, 274, 421, 32);
		contentPane.add(lblThatWillLeave);
		
		JTextPane txtpnLinuxTheMost = new JTextPane();
		txtpnLinuxTheMost.setEditable(false);
		txtpnLinuxTheMost.setText("Linux, the most widely used open source operating system in the world, has scored a major publicity coup in the revelation that it is used on 94% of the world\u2019s top 500 supercomputers.");
		txtpnLinuxTheMost.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnLinuxTheMost.setBackground(new Color(224, 255, 255));
		txtpnLinuxTheMost.setBounds(20, 115, 421, 111);
		contentPane.add(txtpnLinuxTheMost);
		
		JTextPane txtpnAsTheShift = new JTextPane();
		txtpnAsTheShift.setEditable(false);
		txtpnAsTheShift.setText("As the shift to hybrid work becomes a reality, it is clear that the workplace today is different than it was two years ago. Employees\u2019 expectations continue to evolve as they reconsider their \u201Cworth it\u201D equation. In our 2022 Work Trend Index, 53 percent of employees say they\u2019re more likely to prioritize their health and wellbeing over work than before. At the same time, 43 percent of employees are somewhat or extremely likely to consider changing jobs in the coming year, with younger employees even more likely to consider changing employers.  ");
		txtpnAsTheShift.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnAsTheShift.setBackground(new Color(224, 255, 255));
		txtpnAsTheShift.setBounds(20, 306, 421, 171);
		contentPane.add(txtpnAsTheShift);
		
		JLabel lblJavasMissingFeatures = new JLabel("Java's Missing Features: Five Years Later");
		lblJavasMissingFeatures.setIcon(new ImageIcon(Articles.class.getResource("/Images/arrow1.png")));
		lblJavasMissingFeatures.setForeground(new Color(255, 255, 255));
		lblJavasMissingFeatures.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblJavasMissingFeatures.setBounds(20, 532, 421, 32);
		contentPane.add(lblJavasMissingFeatures);
		
		JTextPane txtpnAlmostFiveYears = new JTextPane();
		txtpnAlmostFiveYears.setEditable(false);
		txtpnAlmostFiveYears.setText("Almost five years ago, I wrote an article outlining some feature ideas from other languages that I felt could be of benefit to Java. A lot has happened since then \u2014 at that time, Java 8 was the newly minted release, whereas the most recent version is now Java 14.");
		txtpnAlmostFiveYears.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnAlmostFiveYears.setBackground(new Color(224, 255, 255));
		txtpnAlmostFiveYears.setBounds(20, 565, 421, 111);
		contentPane.add(txtpnAlmostFiveYears);
		
		JLabel lblBestProgrammingLanguages = new JLabel("Best Programming Languages to Learn in 2022");
		lblBestProgrammingLanguages.setIcon(new ImageIcon(Articles.class.getResource("/Images/arrow1.png")));
		lblBestProgrammingLanguages.setForeground(new Color(255, 255, 255));
		lblBestProgrammingLanguages.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBestProgrammingLanguages.setBounds(520, 83, 421, 32);
		contentPane.add(lblBestProgrammingLanguages);
		
		JTextPane txtpnOnceUponA = new JTextPane();
		txtpnOnceUponA.setEditable(false);
		txtpnOnceUponA.setText("Once upon a time, the world of computer programming was a mysterious and exclusive place. Only a select handful of people were considered computer programmers with cutting-edge coding skills. Today, many IT jobs require a solid grasp of the top programming languages, and yes, we mean more than one. ");
		txtpnOnceUponA.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnOnceUponA.setBackground(new Color(224, 255, 255));
		txtpnOnceUponA.setBounds(520, 115, 421, 111);
		contentPane.add(txtpnOnceUponA);
		
		JTextPane txtpnLinuxTheMost_1_1 = new JTextPane();
		txtpnLinuxTheMost_1_1.setEditable(false);
		txtpnLinuxTheMost_1_1.setText("Afraid of coding and a thought arises in your mind that you won\u2019t get a high-paying job, then you\u2019re wrong. Calm Down Geeks, it\u2019s completely okay if you\u2019re not good at coding and still searching for a technical job. Even students at college are tired of hearing about jobs for software developers, again and again, many have least or no interest in coding. The future seems to be confusing for them. There are a lot of people who wander in search of high-paying jobs other than software developers and there\u2019s also high demand for it. ");
		txtpnLinuxTheMost_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnLinuxTheMost_1_1.setBackground(new Color(224, 255, 255));
		txtpnLinuxTheMost_1_1.setBounds(520, 306, 421, 171);
		contentPane.add(txtpnLinuxTheMost_1_1);
		
		JTextPane txtpnLinuxTheMost_1_2 = new JTextPane();
		txtpnLinuxTheMost_1_2.setEditable(false);
		txtpnLinuxTheMost_1_2.setText("Since its inception in 1965, Medicare has been leading the way in providing affordable, quality coverage and care, playing a key role in the health and financial security of more than 63 million Americans. As the largest single purchaser of health care\u2014with one in every five health care dollars paid by the program\u2014Medicare serves as a transformative force in the United States. It plays a central role in the Biden Administration\u2019s vision for the Centers for Medicare & Medicaid Services (CMS): to serve the public as a trusted partner and steward, dedicated to advancing health equity, expanding access to affordable coverage and care, and improving health outcomes. ");
		txtpnLinuxTheMost_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnLinuxTheMost_1_2.setBackground(new Color(224, 255, 255));
		txtpnLinuxTheMost_1_2.setBounds(520, 565, 421, 199);
		contentPane.add(txtpnLinuxTheMost_1_2);
		
		JLabel lblHighestPaying = new JLabel("7 Highest Paying Technical Jobs Other Than Software Developers");
		lblHighestPaying.setIcon(new ImageIcon(Articles.class.getResource("/Images/arrow1.png")));
		lblHighestPaying.setForeground(new Color(255, 255, 255));
		lblHighestPaying.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHighestPaying.setBounds(520, 274, 421, 32);
		contentPane.add(lblHighestPaying);
		
		JLabel lblBuildingOnThe = new JLabel("Working Together For A Stronger Medicare");
		lblBuildingOnThe.setForeground(new Color(255, 255, 255));
		lblBuildingOnThe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBuildingOnThe.setBounds(554, 538, 381, 32);
		contentPane.add(lblBuildingOnThe);
		
		JLabel lblBuildingOnThe_2 = new JLabel("Building On The CMS Strategic Vision: ");
		lblBuildingOnThe_2.setIcon(new ImageIcon(Articles.class.getResource("/Images/arrow1.png")));
		lblBuildingOnThe_2.setForeground(new Color(255, 255, 255));
		lblBuildingOnThe_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBuildingOnThe_2.setBounds(520, 523, 421, 32);
		contentPane.add(lblBuildingOnThe_2);
		
		JLabel more_1 = new JLabel("Read more...");
		more_1.setForeground(new Color(51, 255, 204));
		more_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		more_1.setBounds(346, 487, 95, 20);
		more_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

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
		
		
		JLabel more_2 = new JLabel("Read more...");
		more_2.setForeground(new Color(51, 255, 204));
		more_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		more_2.setBounds(346, 686, 95, 20);
		more_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		
		
		JLabel more_3 = new JLabel("Read more...");
		more_3.setForeground(new Color(51, 255, 204));
		more_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		more_3.setBounds(846, 236, 95, 20);
		more_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		
		
		JLabel more_4 = new JLabel("Read more...");
		more_4.setForeground(new Color(51, 255, 204));
		more_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		more_4.setBounds(834, 487, 95, 20);
		more_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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

		
		
		JLabel more_5 = new JLabel("Read more...");
		more_5.setForeground(new Color(51, 255, 204));
		more_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		more_5.setBounds(834, 774, 95, 20);
		more_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		more_5.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.healthaffairs.org/do/10.1377/forefront.20220110.198444/full/"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		contentPane.add(more_5);
		
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(Profile.class.getResource("/Images/back_icon.png")));
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnBack.setBackground(new Color(47, 79, 79));
		btnBack.setBounds(10, 12, 32, 32);
		btnBack.setOpaque(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Articles.class.getResource("/Images/background1.png")));
		lblNewLabel_2.setBounds(20, 78, 421, 37);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(Articles.class.getResource("/Images/background1.png")));
		lblNewLabel_2_1.setBounds(20, 269, 421, 37);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon(Articles.class.getResource("/Images/background1.png")));
		lblNewLabel_2_2.setBounds(520, 78, 421, 37);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("");
		lblNewLabel_2_3.setIcon(new ImageIcon(Articles.class.getResource("/Images/background1.png")));
		lblNewLabel_2_3.setBounds(520, 269, 421, 37);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("");
		lblNewLabel_2_4.setIcon(new ImageIcon(Articles.class.getResource("/Images/background1.png")));
		lblNewLabel_2_4.setBounds(20, 528, 421, 37);
		contentPane.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("");
		lblNewLabel_2_5.setIcon(new ImageIcon(Articles.class.getResource("/Images/background1.png")));
		lblNewLabel_2_5.setBounds(520, 527, 421, 37);
		contentPane.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Articles.class.getResource("/Images/articlesback.png")));
		lblNewLabel_1.setBounds(0, 0, 959, 835);
		contentPane.add(lblNewLabel_1);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			} });
		
		
		this.setVisible(true);
		
	}
}



