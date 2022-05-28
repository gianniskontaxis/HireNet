import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

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
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 514, 700);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Our Social media");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			lblNewLabel.setBounds(42, 570, 157, 55);
			contentPane.add(lblNewLabel);
			
			JButton btnNewButton = new JButton("");
			btnNewButton.setBounds(248, 587, 23, 27);
			contentPane.add(btnNewButton);
			
			Image img = new ImageIcon(this.getClass().getResource("/facebook.png")).getImage();
			btnNewButton.setIcon(new ImageIcon(img));
			
			JButton btnNewButton_2 = new JButton("");
			btnNewButton_2.setBounds(309, 589, 23, 27);
			contentPane.add(btnNewButton_2);
			
			Image img2 = new ImageIcon(this.getClass().getResource("/Linkedin.png")).getImage();
			btnNewButton_2.setIcon(new ImageIcon(img2));
			
			btnNewButton.addActionListener(new ActionListener() {
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
			
			
			
			JLabel stavros = new JLabel("Dimitriadis Stavros");
			stavros.setFont(new Font("Tahoma", Font.ITALIC, 13));
			stavros.setBounds(239, 168, 174, 20);
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
			
			JLabel lblNewLabel_1 = new JLabel("\u0397 \u03BF\u03BC\u03AC\u03B4\u03B1 \u03C4\u03B7\u03C2 NHD \u03B1\u03C0\u03BF\u03C4\u03B5\u03BB\u03B5\u03AF\u03C4\u03B1\u03B9 \u03B1\u03C0\u03CC 11 \u03BC\u03AD\u03BB\u03B7 ");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lblNewLabel_1.setBounds(10, 23, 295, 46);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("\u03C4\u03B1 \u03BF\u03C0\u03BF\u03AF\u03B1 \u03B4\u03B9\u03B1\u03BA\u03C1\u03AF\u03BD\u03BF\u03BD\u03C4\u03B1\u03B9 \u03C3\u03B5:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lblNewLabel_2.setBounds(58, 63, 170, 27);
			contentPane.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("5 \u03C0\u03C1\u03BF\u03B3\u03C1\u03B1\u03BC\u03BC\u03B1\u03C4\u03B9\u03C3\u03C4\u03B5\u03C2:");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_3.setBounds(40, 159, 170, 39);
			contentPane.add(lblNewLabel_3);
			
			JLabel Kontaksis = new JLabel("Kontaksis Ioannis");
			Kontaksis.setFont(new Font("Tahoma", Font.ITALIC, 13));
			Kontaksis.setBounds(239, 216, 174, 20);
			Kontaksis.addMouseListener(new MouseAdapter() {
		       	 
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                try {
	                    Desktop.getDesktop().browse(new URI("https://github.com/gianniskontaxis"));
	                } catch (IOException | URISyntaxException e1) {
	                    e1.printStackTrace();
	                }
	            }
			});
			contentPane.add(Kontaksis); 
			Kontaksis.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			
			JLabel Chrysanthi = new JLabel("Trentsiou Chrysanthi");
			Chrysanthi.setFont(new Font("Tahoma", Font.ITALIC, 13));
			Chrysanthi.setBounds(239, 246, 174, 20);
			Chrysanthi.addMouseListener(new MouseAdapter() {
		       	 
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                try {
	                    Desktop.getDesktop().browse(new URI(" "));
	                } catch (IOException | URISyntaxException e1) {
	                    e1.printStackTrace();
	                }
	            }
			});
			contentPane.add(Chrysanthi);
			Chrysanthi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			
			JLabel elisavet = new JLabel("Kanidou Elisavet-Persefoni");
			elisavet.setFont(new Font("Tahoma", Font.ITALIC, 13));
			elisavet.setBounds(239, 194, 174, 20);
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
			Champos.setBounds(239, 276, 174, 20);
			Champos.addMouseListener(new MouseAdapter() {
		       	 
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                try {
	                    Desktop.getDesktop().browse(new URI(" "));
	                } catch (IOException | URISyntaxException e1) {
	                    e1.printStackTrace();
	                }
	            }
			});
			contentPane.add(Champos);
			Champos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			
			JLabel lblNewLabel_3_1 = new JLabel("1 Project Manager");
			lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_3_1.setBounds(40, 110, 170, 39);
			contentPane.add(lblNewLabel_3_1);
			
			JLabel matina = new JLabel("Karapostoli Stamatia");
			matina.setFont(new Font("Tahoma", Font.ITALIC, 13));
			matina.setBounds(239, 124, 174, 20);
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

			
			JLabel lblNewLabel_3_2 = new JLabel("2 testers");
			lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_3_2.setBounds(37, 329, 170, 39);
			contentPane.add(lblNewLabel_3_2);
			
			JLabel lblNewLabel_3_3 = new JLabel("3 \u03C3\u03C5\u03B3\u03B3\u03C1\u03B1\u03C6\u03B5\u03AF\u03C2 \u03C0\u03B1\u03C1\u03B1\u03B4\u03BF\u03C4\u03AD\u03BF\u03C5 ");
			lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_3_3.setBounds(33, 463, 203, 39);
			contentPane.add(lblNewLabel_3_3);
			
			JLabel marina = new JLabel("Gialagkolodou Marina-Makrina");
			marina.setFont(new Font("Tahoma", Font.ITALIC, 13));
			marina.setBounds(232, 324, 195, 20);
			marina.addMouseListener(new MouseAdapter() {
		       	 
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                try {
	                    Desktop.getDesktop().browse(new URI(" "));
	                } catch (IOException | URISyntaxException e1) {
	                    e1.printStackTrace();
	                }
	            }
			});
			contentPane.add(marina);
			marina.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			
			JLabel nikos = new JLabel("Sakellaris Nikolaos");
			nikos.setFont(new Font("Tahoma", Font.ITALIC, 13));
			nikos.setBounds(231, 354, 174, 20);
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
			vene.setBounds(244, 442, 174, 20);
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
			georgia.setBounds(243, 477, 174, 20);
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
			dimitris.setBounds(244, 512, 174, 20);
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
			
			JButton btnNewButton_1 = new JButton("Back");
			btnNewButton_1.setBounds(405, 632, 85, 21);
			contentPane.add(btnNewButton_1);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				      
					dispose();
					
				}
			});
				
				
				
			
			
			this.setVisible(true);
			this.setTitle("AboutUs");

		}
	}
