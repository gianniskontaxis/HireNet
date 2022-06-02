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
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

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
			
			JLabel lblNewLabel_5_1_1 = new JLabel("Development\u2122");
			lblNewLabel_5_1_1.setForeground(Color.WHITE);
			lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
			lblNewLabel_5_1_1.setBounds(36, 133, 121, 26);
			contentPane.add(lblNewLabel_5_1_1);
			
			JLabel lblNewLabel_5_1 = new JLabel("Horizons");
			lblNewLabel_5_1.setForeground(Color.WHITE);
			lblNewLabel_5_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
			lblNewLabel_5_1.setBounds(36, 106, 97, 26);
			contentPane.add(lblNewLabel_5_1);
			
			JLabel lblNewLabel_5 = new JLabel("New");
			lblNewLabel_5.setForeground(Color.WHITE);
			lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 16));
			lblNewLabel_5.setBounds(36, 78, 97, 26);
			contentPane.add(lblNewLabel_5);
			
			JLabel lblNewLabel_4_1 = new JLabel("LinkedIn");
			lblNewLabel_4_1.setBounds(75, 441, 70, 27);
			contentPane.add(lblNewLabel_4_1);
			
			JLabel lblNewLabel_4 = new JLabel("Facebook");
			lblNewLabel_4.setBounds(75, 404, 70, 27);
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
			
			JButton btnNewButton = new JButton("");
			btnNewButton.setBounds(42, 404, 23, 27);
			contentPane.add(btnNewButton);
			/*btnNewButton.setIcon(new ImageIcon(img));*/
			
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
			
			JButton btnNewButton_2 = new JButton("");
			btnNewButton_2.setBounds(42, 441, 23, 27);
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
			
			JLabel Kontaksis = new JLabel("Kontaksis Ioannis");
			Kontaksis.setFont(new Font("Tahoma", Font.ITALIC, 13));
			Kontaksis.setBounds(679, 246, 174, 20);
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
			Chrysanthi.setBounds(679, 276, 174, 20);
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
			elisavet.setBounds(679, 205, 174, 20);
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
			Champos.setBounds(679, 306, 174, 20);
			Champos.addMouseListener(new MouseAdapter() {
		       	 
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                try {
	                    Desktop.getDesktop().browse(new URI("https://github.com/champos4EEli"));
	                } catch (IOException | URISyntaxException e1) {
	                    e1.printStackTrace();
	                }
	            }
			});
			contentPane.add(Champos);
			Champos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			JLabel matina = new JLabel("Karapostoli Stamatia");
			matina.setFont(new Font("Tahoma", Font.ITALIC, 13));
			matina.setBounds(679, 128, 174, 20);
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
			
			JLabel marina = new JLabel("Gialagkolodou Marina-Makrina");
			marina.setFont(new Font("Tahoma", Font.ITALIC, 13));
			marina.setBounds(679, 336, 195, 20);
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
			nikos.setBounds(679, 376, 174, 20);
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
			vene.setBounds(679, 431, 174, 20);
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
			georgia.setBounds(679, 477, 174, 20);
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
			dimitris.setBounds(679, 526, 174, 20);
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
