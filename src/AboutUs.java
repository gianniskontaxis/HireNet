import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AboutUs  extends JFrame {

	private JPanel contentPane;

	
		/*public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						AboutUs frame = new AboutUs();
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
		public AboutUs() {
			setIconImage(Toolkit.getDefaultToolkit().getImage(AboutUs.class.getResource("/Images/logo_icon25x25.png")));
			setBounds(100, 100, 1000, 660);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JSeparator separator_2 = new JSeparator();
			separator_2.setForeground(Color.BLACK);
			separator_2.setBounds(0, 54, 986, 8);
			contentPane.add(separator_2);
			
			JLabel lblNewLabel_12 = new JLabel("HireNet");
			lblNewLabel_12.setForeground(new Color(0, 102, 102));
			lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
			lblNewLabel_12.setBounds(362, 64, 89, 32);
			contentPane.add(lblNewLabel_12);
			
			JLabel lblNewLabel_11_4 = new JLabel("Documentation");
			lblNewLabel_11_4.setIcon(new ImageIcon(AboutUs.class.getResource("/Images/documentation_icon.png")));
			lblNewLabel_11_4.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_11_4.setBounds(618, 436, 195, 32);
			contentPane.add(lblNewLabel_11_4);
			
			JLabel lblNewLabel_11_3 = new JLabel("Testers");
			lblNewLabel_11_3.setIcon(new ImageIcon(AboutUs.class.getResource("/Images/testing.png")));
			lblNewLabel_11_3.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_11_3.setBounds(618, 362, 195, 32);
			contentPane.add(lblNewLabel_11_3);
			
			JLabel lblNewLabel_11_2 = new JLabel("Design");
			lblNewLabel_11_2.setIcon(new ImageIcon(AboutUs.class.getResource("/Images/pen.png")));
			lblNewLabel_11_2.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_11_2.setBounds(618, 285, 195, 32);
			contentPane.add(lblNewLabel_11_2);
			
			JLabel lblNewLabel_11_1 = new JLabel("Programmers");
			lblNewLabel_11_1.setIcon(new ImageIcon(AboutUs.class.getResource("/Images/programming_icon.png")));
			lblNewLabel_11_1.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_11_1.setBounds(618, 133, 195, 32);
			contentPane.add(lblNewLabel_11_1);
			
			JLabel lblNewLabel_11 = new JLabel("Project Manager");
			lblNewLabel_11.setIcon(new ImageIcon(AboutUs.class.getResource("/Images/manager_icon.png")));
			lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_11.setBounds(618, 65, 195, 32);
			contentPane.add(lblNewLabel_11);
			
			JLabel lblNewLabel_10_1 = new JLabel("MACEDONIA");
			lblNewLabel_10_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_10_1.setForeground(Color.WHITE);
			lblNewLabel_10_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_10_1.setBounds(36, 286, 148, 32);
			contentPane.add(lblNewLabel_10_1);
			
			JLabel lblNewLabel_10 = new JLabel("UNIVERSITY OF");
			lblNewLabel_10.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_10.setForeground(Color.WHITE);
			lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_10.setBounds(36, 264, 148, 32);
			contentPane.add(lblNewLabel_10);
			
			JLabel lblNewLabel_9 = new JLabel("");
			lblNewLabel_9.setIcon(new ImageIcon(AboutUs.class.getResource("/Images/uom2.png")));
			lblNewLabel_9.setBounds(33, 180, 89, 86);
			contentPane.add(lblNewLabel_9);
			
			JLabel lblNewLabel_8 = new JLabel("");
			lblNewLabel_8.setIcon(new ImageIcon(AboutUs.class.getResource("/Images/logo_icon-removebg-preview.png")));
			lblNewLabel_8.setBounds(218, 65, 134, 146);
			contentPane.add(lblNewLabel_8);
			
			JLabel lblNewLabel_6 = new JLabel("  About us");
			lblNewLabel_6.setIcon(new ImageIcon(AboutUs.class.getResource("/Images/team_icon.png")));
			lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
			lblNewLabel_6.setBounds(400, 12, 184, 32);
			contentPane.add(lblNewLabel_6);
			
			JTextPane txtpnHirenetIsA = new JTextPane();
			txtpnHirenetIsA.setFont(new Font("Tahoma", Font.ITALIC, 20));
			txtpnHirenetIsA.setEditable(false);
			txtpnHirenetIsA.setText("                                   is a \r\n                      software developed\r\n                      by undergraduate   \r\n                      students (New \r\n                      Horizons \r\n                      Development) as part of their project in the Software Technology course, during their academic semester. Aim of the  particular project is to provide information and enlighten the employees about the IT labor market .Our primary goal is to pass on our knowledge to employees , to help them avoid the path to unemployment .\r\n");
			txtpnHirenetIsA.setBounds(218, 65, 328, 528);
			txtpnHirenetIsA.setOpaque(false);
			contentPane.add(txtpnHirenetIsA);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setOrientation(SwingConstants.VERTICAL);
			separator_1.setForeground(Color.BLACK);
			separator_1.setBounds(576, 65, 32, 528);
			contentPane.add(separator_1);
			
			JLabel lblNewLabel_7 = new JLabel("  \u00A9 Copyright 2022 HireNet, Inc. All Rights Reserved ");
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_7.setBounds(218, 565, 348, 28);
			contentPane.add(lblNewLabel_7);
			
			JLabel lblNewLabel_4_1_1 = new JLabel("Coming soon...");
			lblNewLabel_4_1_1.setBounds(87, 478, 70, 27);
			contentPane.add(lblNewLabel_4_1_1);
			
			JButton btnNewButton_2_1 = new JButton("");
			btnNewButton_2_1.setIcon(new ImageIcon(AboutUs.class.getResource("/Images/website.png")));
			btnNewButton_2_1.setOpaque(false);
			btnNewButton_2_1.setContentAreaFilled(false);
			btnNewButton_2_1.setBorderPainted(false);
			btnNewButton_2_1.setBounds(44, 477, 32, 32);
			contentPane.add(btnNewButton_2_1);
			
			JLabel lblNewLabel_5_1_1 = new JLabel("Development\u2122");
			lblNewLabel_5_1_1.setForeground(Color.WHITE);
			lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			lblNewLabel_5_1_1.setBounds(36, 133, 134, 26);
			contentPane.add(lblNewLabel_5_1_1);
			
			JLabel lblNewLabel_5_1 = new JLabel("Horizons");
			lblNewLabel_5_1.setForeground(Color.WHITE);
			lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			lblNewLabel_5_1.setBounds(36, 106, 97, 26);
			contentPane.add(lblNewLabel_5_1);
			
			JLabel lblNewLabel_5 = new JLabel("New");
			lblNewLabel_5.setForeground(Color.WHITE);
			lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			lblNewLabel_5.setBounds(36, 78, 97, 26);
			contentPane.add(lblNewLabel_5);
			
			JLabel lblNewLabel_4_1 = new JLabel("LinkedIn");
			lblNewLabel_4_1.setBounds(87, 441, 70, 27);
			contentPane.add(lblNewLabel_4_1);
			
			JLabel lblNewLabel_4 = new JLabel("Facebook");
			lblNewLabel_4.setBounds(87, 404, 70, 27);
			contentPane.add(lblNewLabel_4);
			
			JSeparator separator = new JSeparator();
			separator.setForeground(Color.BLACK);
			separator.setBounds(34, 386, 150, 8);
			contentPane.add(separator);
			
			JLabel lblNewLabel = new JLabel("Contact Us");
			lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			lblNewLabel.setBounds(42, 350, 142, 36);
			contentPane.add(lblNewLabel);
			
			JButton fb = new JButton("");
			fb.setIcon(new ImageIcon(AboutUs.class.getResource("/Images/fb.png")));
			fb.setBounds(44, 399, 32, 32);
			fb.setOpaque(false);
			fb.setContentAreaFilled(false);
			fb.setBorderPainted(false);
			contentPane.add(fb);
			/*btnNewButton.setIcon(new ImageIcon(img));*/
			
			fb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
				Desktop desktop = java.awt.Desktop.getDesktop();
				try {
					// specify the protocol along with the URL
					URI oURL = new URI("https://www.facebook.com/HireNetNHD");
					desktop.browse(oURL);
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				}
			});
			
			JButton btnNewButton_2 = new JButton("");
			btnNewButton_2.setIcon(new ImageIcon(AboutUs.class.getResource("/Images/lnkdn.png")));
			btnNewButton_2.setBounds(45, 441, 32, 32);
			btnNewButton_2.setOpaque(false);
			btnNewButton_2.setContentAreaFilled(false);
			btnNewButton_2.setBorderPainted(false);
			
			contentPane.add(btnNewButton_2);
			/*btnNewButton_2.setIcon(new ImageIcon(img2));*/
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
				Desktop desktop = java.awt.Desktop.getDesktop();
				try {
					// specify the protocol along with the URL
					URI oURL = new URI("https://www.uom.gr/");
					desktop.browse(oURL);
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				}
			});
			
			JLabel lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon(AboutUs.class.getResource("/Images/firstback2.png")));
			lblNewLabel_3.setBounds(34, 350, 150, 230);
			contentPane.add(lblNewLabel_3);
			
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(AboutUs.class.getResource("/Images/firstbackground.png")));
			lblNewLabel_2.setBounds(21, 65, 174, 528);
			contentPane.add(lblNewLabel_2);
			
			Image img = new ImageIcon(this.getClass().getResource("Images/facebook.png")).getImage();
			
			Image img2 = new ImageIcon(this.getClass().getResource("Images/Linkedin.png")).getImage();
			
			
			
			JLabel stavros = new JLabel("Dimitriadis Stavros");
			stavros.setFont(new Font("Tahoma", Font.ITALIC, 13));
			stavros.setBounds(679, 175, 174, 20);
			stavros.addMouseListener(new MouseAdapter() {
		       	 
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                try {
	                    Desktop.getDesktop().browse(new URI("https://github.com/StavrosDimitriadis"));
	                } catch (IOException | URISyntaxException e1) {
	                    e1.printStackTrace();
	                }
	            }
			});
			contentPane.add(stavros);
			stavros.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			JLabel Kontaxis = new JLabel("Kontaxis Ioannis");
			Kontaxis.setFont(new Font("Tahoma", Font.ITALIC, 13));
			Kontaxis.setBounds(679, 215, 174, 20);
			Kontaxis.addMouseListener(new MouseAdapter() {
		       	 
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                try {
	                    Desktop.getDesktop().browse(new URI("https://github.com/gianniskontaxis"));
	                } catch (IOException | URISyntaxException e1) {
	                    e1.printStackTrace();
	                }
	            }
			});
		
			contentPane.add(Kontaxis); 
			Kontaxis.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			
			JLabel Chrysanthi = new JLabel("Trentsiou Chrysanthi");
			Chrysanthi.setFont(new Font("Tahoma", Font.ITALIC, 13));
			Chrysanthi.setBounds(679, 235, 174, 20);
			Chrysanthi.addMouseListener(new MouseAdapter() {
		       	 
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                try {
	                    Desktop.getDesktop().browse(new URI("https://github.com/Chrysanthitre"));
	                } catch (IOException | URISyntaxException e1) {
	                    e1.printStackTrace();
	                }
	            }
			});
			contentPane.add(Chrysanthi);
			Chrysanthi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			
			JLabel elisavet = new JLabel("Kanidou Elisavet-Persefoni");
			elisavet.setFont(new Font("Tahoma", Font.ITALIC, 13));
			elisavet.setBounds(679, 195, 174, 20);
			elisavet.addMouseListener(new MouseAdapter() {
		       	 
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                try {
	                    Desktop.getDesktop().browse(new URI("https://github.com/ElisavetKanidou"));
	                } catch (IOException | URISyntaxException e1) {
	                    e1.printStackTrace();
	                }
	            }
			});
			contentPane.add(elisavet);
			elisavet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			
			JLabel Champos = new JLabel("Semelidis Charalampos");
			Champos.setFont(new Font("Tahoma", Font.ITALIC, 13));
			Champos.setBounds(679, 255, 174, 20);
			Champos.addMouseListener(new MouseAdapter() {
		       	 
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                try {
	                    Desktop.getDesktop().browse(new URI("https://github.com/champos4"));
	                } catch (IOException | URISyntaxException e1) {
	                    e1.printStackTrace();
	                }
	            }
			});
			contentPane.add(Champos);
			Champos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			JLabel matina = new JLabel("Karapostoli Stamatia");
			matina.setFont(new Font("Tahoma", Font.ITALIC, 13));
			matina.setBounds(679, 106, 174, 20);
			matina.addMouseListener(new MouseAdapter() {
		       	 
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                try {
	                    Desktop.getDesktop().browse(new URI("https://github.com/MatKrp"));
	                } catch (IOException | URISyntaxException e1) {
	                    e1.printStackTrace();
	                }
	            }
			});
			contentPane.add(matina);
			matina.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			JLabel marina = new JLabel("Gialagkolidou Marina-Makrina");
			marina.setFont(new Font("Tahoma", Font.ITALIC, 13));
			marina.setBounds(679, 406, 195, 20);
			marina.addMouseListener(new MouseAdapter() {
		       	 
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                try {
	                    Desktop.getDesktop().browse(new URI("https://github.com/marinagial"));
	                } catch (IOException | URISyntaxException e1) {
	                    e1.printStackTrace();
	                }
	            }
			});
			contentPane.add(marina);
			marina.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			
			JLabel nikos = new JLabel("Sakellaris Nikolaos");
			nikos.setFont(new Font("Tahoma", Font.ITALIC, 13));
			nikos.setBounds(679, 327, 174, 20);
			nikos.addMouseListener(new MouseAdapter() {
		       	 
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                try {
	                    Desktop.getDesktop().browse(new URI("https://github.com/NikosSakell"));
	                } catch (IOException | URISyntaxException e1) {
	                    e1.printStackTrace();
	                }
	            }
			});
			contentPane.add(nikos);
			nikos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			
			JLabel vene = new JLabel("Venetidis Ioannis");
			vene.setFont(new Font("Tahoma", Font.ITALIC, 13));
			vene.setBounds(679, 480, 174, 20);
			vene.addMouseListener(new MouseAdapter() {
		       	 
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                try {
	                    Desktop.getDesktop().browse(new URI(" "));
	                } catch (IOException | URISyntaxException e1) {
	                    e1.printStackTrace();
	                }
	            }
			});
			contentPane.add(vene);
			vene.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			
			JLabel georgia = new JLabel("Kotzampasi Georgia");
			georgia.setFont(new Font("Tahoma", Font.ITALIC, 13));
			georgia.setBounds(679, 520, 174, 20);
			georgia.addMouseListener(new MouseAdapter() {
		       	 
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                try {
	                    Desktop.getDesktop().browse(new URI(" "));
	                } catch (IOException | URISyntaxException e1) {
	                    e1.printStackTrace();
	                }
	            }
			});
			contentPane.add(georgia);
			georgia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			
			JLabel dimitris = new JLabel("Ampatzis Dimitris");
			dimitris.setFont(new Font("Tahoma", Font.ITALIC, 13));
			dimitris.setBounds(679, 500, 174, 20);
			dimitris.addMouseListener(new MouseAdapter() {
		       	 
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                try {
	                    Desktop.getDesktop().browse(new URI(" "));
	                } catch (IOException | URISyntaxException e1) {
	                    e1.printStackTrace();
	                }
	            }
			});
			contentPane.add(dimitris);
			dimitris.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			JButton btnNewButton_1 = new JButton("");
			btnNewButton_1.setIcon(new ImageIcon(AboutUs.class.getResource("/Images/backblack.png")));
			btnNewButton_1.setBounds(10, 12, 32, 32);
			btnNewButton_1.setOpaque(false);
			btnNewButton_1.setContentAreaFilled(false);
			btnNewButton_1.setBorderPainted(false);
			contentPane.add(btnNewButton_1);
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(AboutUs.class.getResource("/Images/aboutusbackgrnd.png")));
			lblNewLabel_1.setBounds(0, 0, 986, 623);
			contentPane.add(lblNewLabel_1);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				      
					dispose();
					
				}
			});
				
				
				
			
			
			this.setVisible(true);
			this.setTitle("AboutUs");

		}
	}
