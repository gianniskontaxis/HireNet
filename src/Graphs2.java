import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import java.awt.Toolkit;


public class Graphs2 extends JFrame {
	
	
	
	private ArrayList<String> column = new ArrayList<>();
	private ArrayList<Integer> count = new ArrayList<>();
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql="";
	private Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	private int Screen_size_x = (int) size.getWidth();
	private int Screen_size_y = (int) size.getHeight();
	private int Window_Width = Screen_size_x;
	private int Window_Height = Screen_size_y;
	private int Window_X_Location =0;
	private int Window_Y_Location =0;
	
	

		
	public Graphs2(int i) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Graphs2.class.getResource("/Images/logo_icon25x25.png")));
		setTitle("Employees Graph");
		
		
		
		FileManager rd = new FileManager();							
		column = rd.read("quals.txt");
		
		try {
			conn = DBConnection.ConnDB();
			
			for (int j=0;j<64;j++) {
				sql = "select count(*) as paok from quals where id in (select id from users where role = 'employee') and `"+column.get(j)+"` = 'true';";

				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				rs.next();
				
				int x = Integer.valueOf(rs.getString("paok"));			
				count.add(x);
			
				}
			conn.close();
		}					
		 catch (SQLException e1) {					
			 e1.printStackTrace();
		}
			
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int j=0;j<64;j++) {
			
			dataset.addValue(count.get(j), "Popularity of Qualifications", column.get(j));
		}
		
			
		JFreeChart chart = ChartFactory.createBarChart("Statistics For Employees", "Qualifications", "Popularity", dataset);
		
		ChartPanel chartPanel = new ChartPanel(chart);
			
		this.setContentPane(chartPanel);
		
			
		this.setLocation(Window_X_Location,Window_Y_Location);
		this.setSize(Window_Width,Window_Height);
		this.setVisible(true);
		
			
	}
		

	
}

