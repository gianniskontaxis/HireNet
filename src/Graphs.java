import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;


public class Graphs extends JFrame {
	
	private ArrayList<String> column = new ArrayList<>();
	private ArrayList<Integer> count = new ArrayList<>();
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql="";
	private int pl=0;
	

		
	public Graphs(int i) {
		
		
		
		FileManager rd = new FileManager();							
		column = rd.read("quals.txt");
		
		try {
			conn = DBConnection.ConnDB();
			for (int j=0;j<64;j++) {
			sql = "select count(*) from quals where id in (select id from users where role = 'company') and `"+column.get(j)+"` = 'true';";
			System.out.println(sql);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();	
			count.add(rs.getInt(column.get(j)));
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
		
			
		JFreeChart chart = ChartFactory.createBarChart("Statistics", "Qualifications", "Popularity", dataset);
		
		ChartPanel chartPanel = new ChartPanel(chart);
			
		this.setContentPane(chartPanel);
			
		this.setVisible(true);
		this.setSize(1500,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}
		

	
}
