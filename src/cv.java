import java.awt.Color; 
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class cv extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private int i;	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private PreparedStatement ps1 = null;
	private ResultSet rs1 = null;
	private PreparedStatement ps2 = null;
	private ResultSet rs2 = null;
	private PreparedStatement ps3 = null;
	private ResultSet rs3 = null;
	private PreparedStatement ps4 = null;
	private ResultSet rs4 = null;
	private String sql="";


	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cv frame = new cv();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public cv( int i ){
		
		this.i=i;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, 50, 750, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(47, 42, 93, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(47, 92, 93, 40);
		contentPane.add(lblLastName);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(47, 142, 69, 40);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Age");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(47, 192, 69, 40);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBounds(138, 51, 155, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(138, 105, 155, 28);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(107, 155, 186, 28);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_3.setColumns(10);
		textField_3.setBounds(107, 205, 54, 28);
		contentPane.add(textField_3);			
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("*Jobs");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_1_1_1.setBounds(505, 58, 69, 40);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Write your");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_2.setBounds(47, 260, 93, 40);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		try {

			conn = DBConnection.ConnDB();

            ps = conn.prepareStatement("select id from employees where id = '"+i+"'");
            rs = ps.executeQuery();
            if (rs.isClosed()) {
                ps = conn.prepareStatement("INSERT INTO employees(id) VALUES(?)");
                ps.setInt(1, i);
                ps.execute();
            }
            ps.close();
			conn.close();

            


        } catch (SQLException e1) {
            e1.printStackTrace();
        }
		
    
		
		//anagnosh email
		sql = "select * from users where id = '"+i+"'";
        try {
    		conn = DBConnection.ConnDB();

        	ps1 = conn.prepareStatement(sql);
    		rs1 = ps1.executeQuery();		
    		textField_2.setText(rs1.getString("email"));

			
			ps1.execute();
			conn.close();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		//anagnosh firstname

		sql = "select * from employees where id = '"+i+"'";
        try {
    		conn = DBConnection.ConnDB();

        	ps2 = conn.prepareStatement(sql);
    		rs2 = ps2.executeQuery();		
    		textField.setText(rs2.getString("firstname"));

			
			ps2.execute();
			conn.close();

		}
		catch (Exception e2) {
			e2.printStackTrace();
		}
		//anagnosh lastname

		sql = "select * from employees where id = '"+i+"'";
        try {
    		conn = DBConnection.ConnDB();

        	ps3 = conn.prepareStatement(sql);
    		rs3 = ps3.executeQuery();		
    		textField_1.setText(rs3.getString("lastname"));

			
			ps3.execute();
			conn.close();

		}
		catch (Exception e3) {
			e3.printStackTrace();
		}
		//anagnosh age

		sql = "select * from employees where id = '"+i+"'";
        try {
    		conn = DBConnection.ConnDB();

        	ps4 = conn.prepareStatement(sql);
    		rs4 = ps4.executeQuery();		
    		textField_3.setText(rs4.getString("age"));

			
			ps4.execute();
			conn.close();

		}
		catch (Exception e4) {
			e4.printStackTrace();
		}
		JButton btnNewButton = new JButton("Qualifications");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Qualifications(i);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.setBackground(new Color(47, 79, 79));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(138, 262, 155, 40);
		contentPane.add(btnNewButton);
		
		JList list = new JList();
		list.setBounds(384, 105, 300, 195);
		contentPane.add(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(667, 173, 17, 48);
		contentPane.add(scrollBar);
		
		JList list_2 = new JList();
		list_2.setBounds(47, 361, 300, 195);
		contentPane.add(list_2);
		
		JButton btnNewButton_1_1 = new JButton("Search");
		btnNewButton_1_1.setBackground(new Color(47, 79, 79));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.setBounds(469, 460, 143, 48);
		contentPane.add(btnNewButton_1_1);
		
		JButton save = new JButton("Save");
		save.setForeground(Color.WHITE);
		save.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		save.setBackground(new Color(47, 79, 79));
		save.setBounds(469, 386, 143, 48);
		contentPane.add(save);
		
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  //������� ������.
				sql = "update employees set firstname = '"+textField.getText()+"' , lastname= '"+textField_1.getText()+"' , age = '"+textField_3.getText()+"'  where id = '"+i+"'";
                try {
            		conn = DBConnection.ConnDB();

                    ps = conn.prepareStatement(sql);
                    ps.execute();
        			conn.close();

                }
                catch (Exception e0) {
                    e0.printStackTrace();
				}
                
			
		}
		});	
		
		JLabel lblNewLabel_1 = new JLabel("*press ctrl for multiple selections");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setBounds(69, 561, 239, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("or to unmark a selection...");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2.setBounds(103, 581, 218, 40);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(599, 591, 85, 21);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			      
				dispose();
				
			}
		});
		
		
		
		
		this.setVisible(true);
		this.setTitle("cv");
	}
}
