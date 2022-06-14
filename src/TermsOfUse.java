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
import javax.swing.JTextPane;
import java.awt.CardLayout;

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
		
		JTextPane txt1 = new JTextPane();
		txt1.setText("1. Introduction\r\nWe created this summary of Hirenet\u2019s Full Privacy Policy to help guide you through it and keep you informed about how we handle your information.\r\nOur Privacy Policy details how we collect, use and disclose the Personal and Non-Personal Data we collect from and about you when you access or use our online and/or mobile websites, applications, services, and software, interactions with us on the phone or in person, or that we obtain from publicly available sources or third-party sources.\r\nHirenet\u2019s core mission is to help people get jobs and help Employers find great candidates. Since each of our affiliates shares that core mission, we have developed a Privacy Center as a way of educating our users about who our affiliates are and how we share data with them. You can find out more about how we share data between affiliates on our Privacy Center FAQ page.\r\n2. Who is responsible for your information?\r\nThe Indeed entity responsible for your information will depend on your location and whether we are acting as a data controller or data processor pursuant to Hirenet\u2019s full Privacy Policy, below. \r\n3. What information do we collect about you?\r\nAcross the Sites we collect information:\r\nyou choose to provide to us through our Sites, e.g. contact details, resume details, location data;\r\nthrough your activity on our Sites, e.g. information from your device and actions taken on the Sites, searches you run or jobs you click on;\r\nwhen you apply to jobs, use screener or assessment questions or automated phone screening, or log in from third party sites; and\r\nwhere you use chargeable services or are an Employer providing necessary Employer information, e.g., for verification purposes.\r\nHirenet may also collect information about your interactions with our social media accounts on third-party platforms, or by obtaining data such as resumes, prospect data or recruiting progress data from third parties.\r\nFull details of the types of Personal Data we collect from you and details of the legal basis for such collection are detailed in section 2 of our full Privacy Policy.\r\n4. Why do we collect this information?\r\nWe collect and use your information in order to help Job Seekers find jobs, to help Employers find candidates, and to provide and improve our services to you. To summarize, we use your Personal Data, where applicable, to:\r\ncreate your account and send you Job Alerts or other promotional materials; \r\ngive you relevant search results and job recommendations; \r\nfacilitate communication as part of the job search, application and interview process;\r\nmake your resume available to third parties, depending on your privacy settings (e.g. private or public resume);\r\nmatch Job Seekers with Employer Job Listings; \r\nprevent fraud, spam and other potentially fraudulent or illegal activities; \r\nfacilitate payment, in connection with chargeable services; \r\ncarry out automated processing in order to provide many of our services; \r\nenhance and optimize our services and security for Job Seekers and Employers by data sharing with our affiliates;\r\nimprove our services, maintain product quality and protect users; and \r\naggregate and share with third parties content posted on Hirenet intended to be publicly available.\r\nFull details of the purposes for which we use your Personal Data are set out in sections 4, 5 and 8 of our full Privacy Policy.\r\n5. Who is this information shared with?\r\nYour information is shared with: \r\nHirenet affiliates;\r\nEmployers and Job Seekers (e.g., if a Job Seeker decides to apply for a job); \r\nthird-party service providers who help us with our operations, e.g. for data storage or fraud detection.\r\nPlease see sections 4 and 7 of our full Privacy Policy for more details. \r\n6. How long do we store your information?\r\nHirenet stores your Personal Data until it is no longer necessary to provide our services, or until you ask us to delete your Personal Data. We may also be required to retain certain information in order to comply with local laws. If you wish to delete your Personal Data, you should submit a deletion request. Please see section 2 of our full Privacy Policy for further information on how long we store your data.\r\n7. What are your rights with respect to your Personal Data?\r\nHirenet takes your privacy very seriously. We provide GDPR-type rights to all our users globally. This includes the rights to access your Personal Data; delete your Personal Data; get your Personal Data in a portable format; and to restrict or object to certain processing of your Personal Data. Where our use of your Personal Data is based on your consent, you also have the right to withdraw that consent. Please see section 8 of our full Privacy Policy for further information in respect of your rights and how they can be exercised.\r\nYou also have the right to complain to your local data protection supervisory authority about Indeed\u2019s use of your data as detailed in section 10 of our full Privacy Policy. If you are located in the US, you may have specific privacy rights which can be found in section 9 of our full Privacy Policy.\r\n8. Contacting us \r\nYou may contact Hirenet, Inc. at PAMAK, Thessaloniki,  Greece, and  you may contact either entity via our Sites\u2019 Help Center.\r\n");
		scrollPane.setViewportView(txt1);
		txt1.setOpaque(false);
		txt1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt1.setEditable(false);
		txt1.setBackground(Color.LIGHT_GRAY);
		
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
